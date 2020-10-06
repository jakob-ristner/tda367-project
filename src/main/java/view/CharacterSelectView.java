package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Stat; //Måste lyfta ut från packet?

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


public class CharacterSelectView implements ViewInterface{
    private Pane pane;
    private Text text;
    private Text playerText;
    private Button character1Button;
    private Button character2Button;
    private Button character3Button;
    private Button character4Button;
    private HashMap<Integer, Button> buttonMap;

    private Text textNextToButton1;
    private Text textNextToButton2;
    private Text textNextToButton3;
    private Text textNextToButton4;
    private List<Text> textsPlayer;

    private Text statsNextToButton1;
    private Text statsNextToButton2;
    private Text statsNextToButton3;
    private Text statsNextToButton4;
    private List<Text> textsStats;






    public CharacterSelectView(Group root, int width, int height, List<String> characterNames, List< HashMap<Stat, Integer>> stats){

        pane = new Pane();
        text = new Text("Choose your character");
        text.setStyle("-fx-font-size: 40px;");
        text.setWrappingWidth(300);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setLayoutX(width / 2 - text.getWrappingWidth() / 2);
        text.setLayoutY(50);
        addNode(text);

        initButton(characterNames);

        initText(stats);

        playerText = new Text();
        playerText.setText("It's Player 1:s turn!");
        playerText.setWrappingWidth(300);
        playerText.setTextAlignment(TextAlignment.CENTER);
        playerText.setLayoutX(width / 2 - text.getWrappingWidth() / 2);
        playerText.setLayoutY(150);
        addNode(playerText);

        root.getChildren().add(pane);

        pane.setPrefSize(width, height);
        pane.setStyle("-fx-background-color: green");
    }

    private void initButton(List<String> characterNames){
        character1Button = new Button();
        character2Button = new Button();
        character3Button = new Button();
        character4Button = new Button();
        buttonMap = new HashMap<>();        //HashMap for access to buttons in Controller

        buttonMap.put(0,character1Button);  //With the Integer Key the controller knows which button is which.
        buttonMap.put(1,character2Button);
        buttonMap.put(2,character3Button);
        buttonMap.put(3,character4Button);


        for(int i = 0; i < buttonMap.size(); i++){
            buttonMap.get(i).setLayoutX(200);
            buttonMap.get(i).setLayoutY(200 + 50*i);
            buttonMap.get(i).setPrefSize(100, 30);
            buttonMap.get(i).setText(characterNames.get(i));
            addNode(buttonMap.get(i));
        }
    }
    private void initText(List< HashMap<Stat, Integer>> stats){
        textNextToButton1 = new Text();
        textNextToButton2 = new Text();
        textNextToButton3 = new Text();
        textNextToButton4 = new Text();
        textsPlayer = new ArrayList<>();

        textsPlayer.add(textNextToButton1);
        textsPlayer.add(textNextToButton2);
        textsPlayer.add(textNextToButton3);
        textsPlayer.add(textNextToButton4);


        for(int i = 0; i<textsPlayer.size(); i++){
            textsPlayer.get(i).setLayoutX(buttonMap.get(i).getLayoutX() + 120);
            textsPlayer.get(i).setLayoutY(buttonMap.get(i).getLayoutY());
            addNode(textsPlayer.get(i));
        }
        statsNextToButton1 = new Text();
        statsNextToButton2 = new Text();
        statsNextToButton3 = new Text();
        statsNextToButton4 = new Text();
        textsStats = new ArrayList<>();

        textsStats.add(statsNextToButton1);
        textsStats.add(statsNextToButton2);
        textsStats.add(statsNextToButton3);
        textsStats.add(statsNextToButton4);

        for(int i = 0; i<textsStats.size(); i++){
            textsStats.get(i).setLayoutX(buttonMap.get(i).getLayoutX() - 180);
            textsStats.get(i).setLayoutY(buttonMap.get(i).getLayoutY() + 20);
            textsStats.get(i).setText("Str: "+(stats.get(i).get(Stat.STRENGTH).toString())+ "  " +"Spe: "+stats.get(i).get(Stat.SPEED).toString()+ "  "+ "San " + stats.get(i).get(Stat.SANITY).toString()+ "  "+ "Stam: " + stats.get(i).get(Stat.STRENGTH).toString());
            addNode(textsStats.get(i));
        }



    }


    @Override
    public void viewToFront() {
        pane.toFront();
    }

    public void setCurrentPlayerText(int index) {
        playerText.setText("It's Player " + (index+1) + ":s turn!");
    }

    @Override
    public void addNode(Node node) {
        pane.getChildren().add(node);
    }

    @Override
    public void close() {
        pane.toBack();

    }

    public HashMap<Integer, Button> getButtonMap(){
        return buttonMap;
    }

    public List<Text> getTexts(){
        return textsPlayer;
    }

}
