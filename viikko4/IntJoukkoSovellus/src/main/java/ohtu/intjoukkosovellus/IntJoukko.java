
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuTaulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla.
    private static int[] aTaulu;
    private static int[] bTaulu;

    public IntJoukko() {
        lukuTaulukko = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        lukuTaulukko = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            return;
        }
        if (kasvatuskoko < 0) {
            return;
        }
        lukuTaulukko = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {

        if (alkioidenLkm == 0) {
            lukuTaulukko[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluuko(luku)) {
            lukuTaulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukuTaulukko.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }
    
    private void kasvataTaulukkoa() {
        int[] taulukkoOld = lukuTaulukko;
        lukuTaulukko = new int[alkioidenLkm + kasvatuskoko];
        System.arraycopy(taulukkoOld, 0, lukuTaulukko, 0, taulukkoOld.length);
    }

    public boolean kuuluuko(int luku) {
        if (etsiLuku(luku) == -1)   {
            return false;
        }
        return true;
    }
    
    private int etsiLuku(int luku)  {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuTaulukko[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        int kohta = etsiLuku(luku);
        if (kohta != -1) {
            pienennaTaulukkoa(kohta);
            return true;
        }
        return false;
    }
    
    private void pienennaTaulukkoa(int kohta)    {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = lukuTaulukko[j];
                lukuTaulukko[j] = lukuTaulukko[j + 1];
                lukuTaulukko[j + 1] = apu;
            }
        alkioidenLkm--;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukuTaulukko[0] + "}";
        } else {
            String tuloste = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuloste += lukuTaulukko[i];
                tuloste += ", ";
            }
            tuloste += lukuTaulukko[alkioidenLkm - 1];
            tuloste += "}";
            return tuloste;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukuTaulukko[i];
        }
        return taulu;
    }
    
    private static void luoAputaulukot(IntJoukko a, IntJoukko b)    {
        aTaulu = a.toIntArray();
        bTaulu = b.toIntArray();
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        luoAputaulukot(a, b);
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        luoAputaulukot(a, b);
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        luoAputaulukot(a, b);
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
        return z;
    }
        
}
