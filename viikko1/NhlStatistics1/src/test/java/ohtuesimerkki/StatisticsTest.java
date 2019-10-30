package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("a", "A", 1, 10));
            players.add(new Player("b", "A", 4, 11));
            players.add(new Player("c",   "B", 5, 12));
            players.add(new Player("d", "C", 6, 13));
            players.add(new Player("e", "B", 7, 14));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void searchName()  {
        Player p = stats.search("a");
        assertEquals("a", p.getName());
    }
    
    @Test
    public void searchGoals()   {
        Player p = stats.search("a");
        assertEquals(1, p.getGoals());
    }
    
    @Test
    public void searchUnexistingPlayer()    {
        Player p = stats.search("x");
        assertNull(p);
    }
    
    @Test
    public void teamA() {
        List<Player> team = stats.team("B");
        assertEquals("c", team.get(0).getName());
    }
    
    @Test
    public void teamA2() {
        List<Player> team = stats.team("B");
        assertEquals("e", team.get(1).getName());
    }
    
    @Test
    public void nonExistingTeam()   {
        List<Player> team = stats.team("D");
        assertEquals(0, team.size());
    }
    
    @Test
    public void topScorers()    {
        List<Player> top = stats.topScorers(2);
        assertEquals("e", top.get(0).getName());
    }
    
    @Test
    public void topScorers2()    {
        List<Player> top = stats.topScorers(2);
        assertEquals("d", top.get(1).getName());
    }
    
    // 4 gets you 5 players, intended?
    @Test
    public void topScorersCorrectAmount()   {
        List<Player> top = stats.topScorers(4);
        assertEquals(5, top.size());
    }
}
