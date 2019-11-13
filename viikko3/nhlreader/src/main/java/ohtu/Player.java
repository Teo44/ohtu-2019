
package ohtu;

public class Player {
    private String name;
    private Integer goals;
    private Integer assists;
    private Integer penalties;
    private String team;
    private String nationality;
    private String birhthDate;

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirhthDate() {
        return birhthDate;
    }

    public void setBirhthDate(String birhthDate) {
        this.birhthDate = birhthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return padRight(name, 20) + padRight(nationality, 6) + 
                padRight(Integer.toString(goals), 2) + " + " +
                padLeft(Integer.toString(assists), 2) + " = " +
                padLeft(Integer.toString(goals + assists), 2);
    }
    
    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);  
    }
    
    private  String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);  
    }

      
}
