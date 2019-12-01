package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Erotus extends Command{
    public Erotus(JTextField syotekentta, JTextField tuloskentta, JButton nollaa, JButton undo)  {
        super(syotekentta, tuloskentta, nollaa, undo);
    }
    
    @Override
    public void suorita(Sovelluslogiikka sovellus) {
        Integer arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(arvo);
        
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
