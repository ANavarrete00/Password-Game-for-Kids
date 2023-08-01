package PasswordGame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import CreatePassword.CreatePassword;
import Test.Test;
import Tips.Tips;
/**
 *
 * @author Anav2
 */
public class PasswordGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label header=new Label("Let's create a super string password!");
        Label instruction=new Label("Enter any phrase: ");
        Label score=new Label("Hacker Score: 0\nYour Score: 0");
        Label result=new Label();
        TextField phrase=new TextField();
        TextField newpass=new TextField();
        Button btn = new Button("Get a strong password");
        Button Nextbtn=new Button("Next");
        Button Nextbtn2=new Button("Next");
        Button Nextbtn3=new Button("Next");
        Button submit=new Button("Submit test");
        CreatePassword cp=new CreatePassword();
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cp.setPassword(phrase.getText());
                //if good phrase, then create new password
                if(cp.testPass()){
                    result.setText(cp.goodPass());
                    newpass.setText(cp.CreateNewPass());
                }
                else{
                    result.setText(cp.tooShort());
                }
                score.setText("Hacker Score: "+cp.getHackerScore()+"\nYour Score: "+cp.getScore());
            }
        });
        
        Nextbtn.setOnAction((ActionEvent event) -> {
            Test ts=new Test();
            
            String[] str=ts.getQuestions();
            String[] ansStr=ts.getAnsOptions();
            Label[] question=new Label[4];
            RadioButton[] radio=new RadioButton[14];
            ToggleGroup radioGroup=new ToggleGroup();
            ToggleGroup radioGroup2=new ToggleGroup();
            ToggleGroup radioGroup3=new ToggleGroup();
            ToggleGroup radioGroup4=new ToggleGroup();
            header.setText("Let's test your knowledge");
            //adds question strings to the questions label
            for(int i=0;i<question.length;i++){
                question[i]=new Label(str[i]);
            }
            //adds answer options to radio buttons
            for(int i=0;i<radio.length;i++){
                radio[i]=new RadioButton(ansStr[i]);
            }
            //adds radios in a group based on the questions and adds them to an VBox
            radio[0].setToggleGroup(radioGroup);
            radio[1].setToggleGroup(radioGroup);
            radio[2].setToggleGroup(radioGroup);
            radio[3].setToggleGroup(radioGroup);
            VBox radioVbox=new VBox(radio[0],radio[1],radio[2],radio[3]);
            radio[4].setToggleGroup(radioGroup2);
            radio[5].setToggleGroup(radioGroup2);
            VBox radioVbox2=new VBox(radio[4],radio[5]);
            radio[6].setToggleGroup(radioGroup3);
            radio[7].setToggleGroup(radioGroup3);
            radio[8].setToggleGroup(radioGroup3);
            radio[9].setToggleGroup(radioGroup3);
            VBox radioVbox3=new VBox(radio[6],radio[7],radio[8],radio[9]);
            radio[10].setToggleGroup(radioGroup4);
            radio[11].setToggleGroup(radioGroup4);
            radio[12].setToggleGroup(radioGroup4);
            radio[13].setToggleGroup(radioGroup4);
            VBox radioVbox4=new VBox(radio[10],radio[11],radio[12],radio[13]);
            
            submit.setOnAction((ActionEvent event1) -> {
                if(radio[0].isSelected() || radio[1].isSelected() || radio[2].isSelected()){
                    ts.addIncorrect();
                }
                else if(radio[3].isSelected()){
                    ts.addCorrect();
                }
                if(radio[4].isSelected()){
                    ts.addIncorrect();
                }
                else if(radio[5].isSelected()){
                    ts.addCorrect();
                }
                if(radio[6].isSelected() || radio[7].isSelected() || radio[8].isSelected()){
                    ts.addIncorrect();
                }
                else if(radio[9].isSelected()){
                    ts.addCorrect();
                }
                if(radio[10].isSelected() || radio[11].isSelected() || radio[13].isSelected()){
                    ts.addIncorrect();
                }
                else if(radio[12].isSelected()){
                    ts.addCorrect();
                }
                ts.addPoints(cp.getScore());
                ts.addHackPoints(cp.getHackerScore());
                score.setText("Hacker Score: "+ts.getHackerScore()+"\nYour Score: "+ts.getScore());
            });
            
            Nextbtn2.setOnAction((ActionEvent event3) -> {
                if(ts.getScore()>ts.getHackerScore()){
                    header.setText("Congratulations you beat the Hacker!");
                }
                else{
                    header.setText("Oh no! the hacker won!");
                }
                Label uScore=new Label("Your Score was\n\t\t"+ts.getScore());
                Label hScore=new Label("The Hacker's Score was\n\t\t"+ts.getHackerScore());
                HBox scores=new HBox(20,uScore,hScore);
                scores.setAlignment(Pos.CENTER);
                VBox mainbox=new VBox(20,header,scores,Nextbtn3);
                mainbox.setAlignment(Pos.CENTER);
                StackPane root = new StackPane();
                root.getChildren().add(mainbox);

                Scene scene = new Scene(root, 600, 500);
                primaryStage.setTitle("Password Game!");
                primaryStage.setScene(scene);
                primaryStage.show();
                
            });
            
            VBox leftbox=new VBox(20,question[0],radioVbox,question[1],radioVbox2,question[2],radioVbox3,question[3],radioVbox4);
            VBox rightbox=new VBox(20,score,submit,Nextbtn2);
            rightbox.setAlignment(Pos.CENTER);
            HBox body=new HBox(20,leftbox,rightbox);
            body.setAlignment(Pos.CENTER);
            VBox mainbox=new VBox(10,header,body);
            mainbox.setAlignment(Pos.CENTER);
            StackPane root = new StackPane();
            root.getChildren().add(mainbox);
            
            Scene scene = new Scene(root, 600, 500);
            primaryStage.setTitle("Password Game!");
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        Nextbtn3.setOnAction((ActionEvent event) -> {
            header.setText("Some Tips and Tricks");
            Label display=new Label();
            Tips tip=new Tips();
            Button tip1=new Button("Tip 1");
            Button tip2=new Button("Tip 2");
            Button tip3=new Button("Tip 3");
            Button tip4=new Button("Tip 4");
            
            tip1.setOnAction((ActionEvent event1) -> {display.setText(tip.getTip1());});
            tip2.setOnAction((ActionEvent event1) -> {display.setText(tip.getTip2());});
            tip3.setOnAction((ActionEvent event1) -> {display.setText(tip.getTip3());});
            tip4.setOnAction((ActionEvent event1) -> {display.setText(tip.getTip4());});
            
            VBox vTips=new VBox(20,tip1,tip2,tip3,tip4);
            vTips.setAlignment(Pos.CENTER);
            HBox body=new HBox(30,vTips,display);
            body.setAlignment(Pos.CENTER);
            VBox mainbox=new VBox(20,header,body);
            mainbox.setAlignment(Pos.CENTER);
            
            StackPane root = new StackPane();
            root.getChildren().add(mainbox);

            Scene scene = new Scene(root, 600, 500);
            primaryStage.setTitle("Password Game!");
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        VBox leftbox=new VBox(20,instruction,result,btn);
        VBox rightbox=new VBox(20,phrase,newpass,score,Nextbtn);
        rightbox.setAlignment(Pos.CENTER);
        HBox body=new HBox(20,leftbox,rightbox);
        body.setAlignment(Pos.CENTER);
        VBox mainbox=new VBox(10,header,body);
        mainbox.setAlignment(Pos.CENTER);
        StackPane root = new StackPane();
        root.getChildren().add(mainbox);
        
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Password Game!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}