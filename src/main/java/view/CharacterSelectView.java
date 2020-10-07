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

public class CharacterSelectView implements ViewInterface{
    private Pane pane;

    private int width;
    private int height;
    private int buttonSpacing;

    private Text text;
    private Text playerText;
    private List<Text> textsPlayer;
    private List<Text> textsStats;
    private List<HashMap<Stat, Integer>> statList;
    private HashMap<Integer, Button> buttonMap;

    public CharacterSelectView(Group root, int width, int height){
        this.width = width;
        this.height = height;
        buttonSpacing = 70;

        pane = new Pane();
        pane.setPrefSize(width, height);
        pane.setStyle("-fx-background-color: green"); // temporary
        root.getChildren().add(pane);
    }


    public void initButton(List<String> characterNames){
        buttonMap = new HashMap<>();        //HashMap for access to buttons in Controller

        Button currButton;
        for (int i = 0; i < characterNames.size(); i++) {
            currButton = new Button();
            currButton.setLayoutX(width / 2);
            currButton.setLayoutY(height / 2 + i * buttonSpacing);
            currButton.setPrefSize(200, 30);
            currButton.setText(characterNames.get(i));
            addNode(currButton);
            buttonMap.put(i, currButton);//One button for each char
        }
    }

    public void initText(List< HashMap<Stat, Integer>> statList){
        this.statList = statList;

        playerText = new Text();
        playerText.setText("It's Player 1:s turn!");
        playerText.setWrappingWidth(300);
        playerText.setTextAlignment(TextAlignment.CENTER);
        playerText.setLayoutX(width / 2 - playerText.getWrappingWidth() / 2);
        playerText.setLayoutY(150);
        addNode(playerText);

        text = new Text("Choose your character");
        text.setStyle("-fx-font-size: 40px;");
        text.setWrappingWidth(300);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setLayoutX(width / 2 - text.getWrappingWidth() / 2);
        text.setLayoutY(50);
        addNode(text);

        textsPlayer = new ArrayList<>();
        textsStats = new ArrayList<>();

        Text currPlayerText;
        Text currStatText;
        int refButtonX;
        int refButtonY;
        for (int i = 0; i < buttonMap.size(); i++) {
            refButtonX = (int) buttonMap.get(i).getLayoutX();
            refButtonY = (int) buttonMap.get(i).getLayoutY();


            currPlayerText = new Text();
            currPlayerText.setWrappingWidth(200);
            currPlayerText.setTextAlignment(TextAlignment.CENTER);
            currPlayerText.setLayoutX(refButtonX + 200);
            currPlayerText.setLayoutY(refButtonY + 20);
            addNode(currPlayerText);
            textsPlayer.add(currPlayerText);

            currStatText = new Text();
            currStatText.setWrappingWidth(180);
            currStatText.setTextAlignment(TextAlignment.CENTER);
            currStatText.setLayoutX(refButtonX - 180);
            currStatText.setLayoutY(refButtonY + 20);
            currStatText.setText(getAllStatsAsString(i));
            addNode(currStatText);
            textsStats.add(currStatText);
        }
    }

    private String getStatAsString(int statListIndex, Stat stat) {
        return statList.get(statListIndex).get(stat).toString();
    }

    private String getAllStatsAsString(int statListIndex) {
        String allStats= "";
        allStats += ("Str: " + getStatAsString(statListIndex, Stat.STRENGTH));
        allStats += ("  Spe: " + getStatAsString(statListIndex, Stat.SPEED));
        allStats += ("  San: " + getStatAsString(statListIndex, Stat.SANITY));
        allStats += ("  Stam: " + getStatAsString(statListIndex, Stat.STRENGTH));
        return allStats;
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
