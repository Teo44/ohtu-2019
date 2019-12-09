package statistics.matcher;

public class QueryBuilder {
    
    Matcher m;
    //Matcher[] matchers;
    
    public QueryBuilder()   {
        m = new All();
    }
    
    public Matcher build()  {
        return m;
    }
    
    public QueryBuilder playsIn(String team)   {
        this.m = new And( new PlaysIn(team), m);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category)  {
        this.m = new And( new HasAtLeast(value, category), m);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category)    {
        this.m = new And( new HasFewerThan(value, category), m);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.m = new Or(matchers);
        return this;
    }
    
}
