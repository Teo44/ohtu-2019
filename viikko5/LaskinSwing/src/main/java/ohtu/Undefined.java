package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Undefined extends Command{
    public Undefined(JTextField syotekentta, JTextField tuloskentta, JButton nollaa, JButton undo)  {
        super(syotekentta, tuloskentta, nollaa, undo);
    }
    
    @Override
    public void suorita(Sovelluslogiikka sovellus) {
    }    
    
    @Override
    public void peru()  {
        
    }
    
}
