package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
        
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        varasto = mock(Varasto.class);
    }
    

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);              

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
    
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);              

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }
    
    @Test
    public void kaksiOstostaTehtaessaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "ruisleipa", 3));

        Kauppa k = new Kauppa(varasto, pankki, viite);              

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 8);   
    }
    
    @Test
    public void kaksiSamaaTuotettaOstaessaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);              

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);   
    }
    
    @Test
    public void kunToinenTuoteOnLoppuPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "ruisleipa", 3));

        Kauppa k = new Kauppa(varasto, pankki, viite);              

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }
}

