package ohtu.verkkokauppa;

public interface RahaaSiirtava {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
