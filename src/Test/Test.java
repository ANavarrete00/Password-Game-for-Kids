package Test;
import Game.Game;
/**
 *
 * @author Anav2
 */
public class Test extends Game{
    
    private int correct, incorrect;
    private int[] ans=new int[]{3,1,3,2};
    private String[] questions=new String[]{"How many characters should a strong password have? (select one below)","There is no need for numbers in your password.",
        "Which character should you have at least one of? (select one below)","Which of these passwords would be best?(select one below)"};
    private String[] ansOptions=new String[]{"5","8","10","15","True","False","Letter","Number","Special character","All the above","Snowiscool",
        "ILoveIceCre@m","MYDogIsC**l183","FishG0GlubbGlu66"};
    
    public Test(){
        this.correct=0;
        this.incorrect=0;
    }
    
    public String[] getQuestions(){
        return questions;
    }
    
    public String[] getAnsOptions(){
        return ansOptions;
    }
    
    public void addCorrect(){
        correct+=1;
        super.addScore();
    }
    
    public void addIncorrect(){
        incorrect+=1;
        super.addHackScore();
    }
    
    public int getCorrect(){
        return correct;
    }
    
    public int getIncorrect(){
        return incorrect;
    }
}