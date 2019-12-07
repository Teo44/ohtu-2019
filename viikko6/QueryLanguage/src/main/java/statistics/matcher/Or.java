package statistics.matcher;

import statistics.Player;

public class Or implements Matcher{
    
    private Matcher[] matchers;
    
    public Or(Matcher... m) {
        this.matchers = m;
        
    }
    
    @Override
    public boolean matches(Player p)    {
        for (Matcher m : matchers)  {
            if (m.matches(p))   {
                return true;
            }
        }
        return false;
    }
}
