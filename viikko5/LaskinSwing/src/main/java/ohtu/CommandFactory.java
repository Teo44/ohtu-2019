package ohtu;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CommandFactory {
    private HashMap<String, Command> commands;
    private Sovelluslogiikka sovellus;
    
    
    public CommandFactory(Sovelluslogiikka sovellus, JTextField syotekentta, JTextField tuloskentta, JButton nollaa, JButton undo)   {
        this.sovellus = sovellus;
        commands = new HashMap<>();
        commands.put("summa", new Summa(syotekentta, tuloskentta, nollaa, undo));
        commands.put("erotus", new Erotus(syotekentta, tuloskentta, nollaa, undo));
        commands.put("nollaa", new Nollaa(syotekentta, tuloskentta, nollaa, undo));
        commands.put("", new Undefined(syotekentta, tuloskentta, nollaa, undo));
    }
    
    public Command get(String operaatio) {
        return commands.get(operaatio);
    }
}
