package CreatePassword;

import java.util.Random;
import Game.Game;
/**
 *
 * @author Anav2
 */
public class CreatePassword extends Game implements PasswordManager{
    private String pword;
    private final int minLength=15;
    
    public CreatePassword(){
        pword="";
    }
    
    public void setPassword(String pword){
        this.pword=pword;
    }
    
    public boolean testPass(){
        if(this.pword.length()>=minLength){
            this.addScore();
            return true;
        }
        this.addHackScore();
        return false;
    }
    
    public String CreateNewPass(){
        char[] special= ("!@#$%^&*?").toCharArray();
        Random rand=new Random();
        char[] pass=this.pword.toCharArray();
        StringBuilder sb=new StringBuilder();
        
        for(int i=this.pword.length()-1;i>=0;i--){
            if(pass[i]==' '){
                pass[i]=special[rand.nextInt(special.length)];
            }
            sb.append(pass[i]);
        }
        return sb.toString();
    }
    
    public String tooShort(){
        return "Phrase is too short! try again";
    }
    
    public String goodPass(){
        return "Phrase looks good!";
    }
}