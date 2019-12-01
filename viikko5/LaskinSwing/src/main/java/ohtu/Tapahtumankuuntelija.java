package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private CommandFactory factory;
    private Command edellinen;
    private Command komento;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        this.factory = new CommandFactory(sovellus, syotekentta, tuloskentta, nollaa, undo);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int arvo = 0;
 
        String command = "";
        
        if (ae.getSource() == plus) {
            command = "summa";
        } else if (ae.getSource() == miinus) {
            command = "erotus";
        } else {
            command = "nollaa";
        }

        komento = factory.get(command);
        if (ae.getSource() != undo) {
            edellinen = komento;
            komento.suorita(sovellus);
        } else  {
            if (edellinen != null)  {
                edellinen.peru();
                edellinen = null;
            }
        }
        
    }
 
}