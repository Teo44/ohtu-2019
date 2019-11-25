package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    final private String player1Name;
    private String returnString;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        returnString = "";
        if (player1Score == player2Score)  {
            scoreEven();
        } else if (player1Score >= 4 || player2Score >= 4)  {
            advantageOrWin();
        } else   {
            otherCases();
        }
        return returnString;
    }
    
    private void otherCases()  {
        returnString += getScoreNaming(player1Score);
        returnString += "-";
        returnString += getScoreNaming(player2Score);
    }
    
    private String getScoreNaming(int score)   {
        switch(score)   {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }
    
    private void scoreEven()    {
        if (player1Score == 4)    {
            returnString = "Deuce";
            return;
        }
        returnString += getScoreNaming(player1Score);
        returnString += "-All";
    }
    
    private void advantageOrWin()   {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1)   {
            returnString = "Advantage player1";
        } else if (scoreDifference == -1)   {
            returnString = "Advantage player2";
        } else if  (scoreDifference >= 2)   {
            returnString = "Win for player1";
        } else  {
            returnString = "Win for player2";
        }
    }
}