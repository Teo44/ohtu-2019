package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public abstract class Command {
    protected JTextField syotekentta;
    protected JTextField tuloskentta;
    protected JButton nollaa;
    protected JButton undo;
    public Command(JTextField syotekentta, JTextField tuloskentta, JButton nollaa, JButton undo)  {
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
    }

    public abstract void suorita(Sovelluslogiikka sovellus);    
    public abstract void peru();
}
