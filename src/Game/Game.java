package Game;
/**
 *
 * @author Anav2
 */
public class Game implements GameManager{
    private int userScore;
    private int hackerScore;

    public Game(){
    }
    
    public void addScore(){
        userScore+=1;
    }
    
    public void addHackScore(){
        hackerScore+=1;
    }
    
    public void addPoints(int points){
        userScore+=points;
    }
    
    public void addHackPoints(int points){
        hackerScore+=points;
    }
    
    public int getScore(){
        return userScore;
    }
    
    public int getHackerScore(){
        return hackerScore;
    }
}
