package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Kirjaapitava {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
