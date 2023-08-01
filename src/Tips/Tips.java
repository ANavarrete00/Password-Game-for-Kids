package Tips;

/**
 *
 * @author Anav2
 */
public class Tips {
    private String[] tips=new String[4];
    
    public Tips(){
        tips[0]="It is always a good idea to make sure that your password is long enough to be \nsecure. "
                + "When a password is too short, it is vulnerable in being decrypted in a short \namount of time. "
                + "We recommend that you make your password at least 15 characters long.";
        tips[1]="Adding number into your password is a good way to increase the strengh of it. \n"
                + "Typically people add numbers at the end of their password, but it might be a \ngood idea to spread the numbers throught"
                + "your password.";
        tips[2]="Special characters will increase your passwords strength greatly. You can \nuse them to fill in gaps or replace other letters "
                + "such as S to $. It's highly \nrecommended that you have at least one of them in your password";
        tips[3]="It is always good to store your passwords somewhere safe. A great way to \ndo that is by writing them down on a piece of paper. "
                + "There are also encrypted \nfiles that you can score them in with an additional password.";
    }
    
    public String getTip1(){
        return tips[0];
    }
    
    public String getTip2(){
        return tips[1];
    }
    
    public String getTip3(){
        return tips[2];
    }
    
    public String getTip4(){
        return tips[3];
    }
}
