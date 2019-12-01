package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public abstract class Command {
    protected JTextField syotekentta;
    protected JTextField tuloskentta;
    protected JButton nollaa;
    protected JButton undo;
    protected String previous;
    public Command(JTextField syotekentta, JTextField tuloskentta, JButton nollaa, JButton undo)  {
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        previous = "";
    }

    public abstract void suorita(Sovelluslogiikka sovellus);    
    public abstract void peru();
}
