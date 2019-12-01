package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Nollaa extends Command{
    public Nollaa(JTextField syotekentta, JTextField tuloskentta, JButton nollaa, JButton undo)   {
        super(syotekentta, tuloskentta, nollaa, undo);
    }
    
    @Override
    public void suorita(Sovelluslogiikka sovellus) {
        sovellus.nollaa();
        
        int laskunTulos = sovellus.tulos();
        previous = tuloskentta.getText();
        syotekentta.setText(""); 
        tuloskentta.setText("" + laskunTulos);
        if ( laskunTulos==0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
        undo.setEnabled(true);
    }    
    
    @Override
    public void peru()  {
        tuloskentta.setText(previous);
    }
    
}
