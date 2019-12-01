package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Summa extends Command {
    public Summa(JTextField syotekentta, JTextField tuloskentta, JButton nollaa, JButton undo)    {
        super(syotekentta, tuloskentta, nollaa, undo);
        previous = "";
    }
    
    @Override
    public void suorita(Sovelluslogiikka sovellus) {
        Integer arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
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
