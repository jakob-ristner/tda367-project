package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombatScreenView implements ViewInterface{
    private Pane rootPane;
    private int width;
    private int height;
    private Text header;
    private List<Text> toRemove = new ArrayList<>();

    private Button combatButton;
    private Button exitButton;

    private List<Button> combatButtonList;
    private HashMap<String, Circle> playerCircles;



    public CombatScreenView(Group root, int width, int height){
        this.width = width;
        this.height = height;
        playerCircles = new HashMap<>();
        combatButtonList = new ArrayList<>();

        rootPane = new Pane();
        rootPane.setPrefSize(width,height);
        rootPane.setStyle("-fx-background-color: black");
        root.getChildren().add(rootPane);

        combatButton = new Button();
        combatButton.setPrefSize(width/5,height/16);
        combatButton.setLayoutX(width/2 - combatButton.getPrefWidth()/2);
        combatButton.setLayoutY(height - combatButton.getPrefHeight() - 50);
        combatButton.setText("Battle!");
        combatButton.setStyle("-fx-font-size: 15px;");
        addNode(combatButton);
        combatButtonList.add(combatButton);

        exitButton = new Button();
        exitButton.setPrefSize(width/10, height/10);
        exitButton.setLayoutX(width - exitButton.getPrefWidth() - 10);
        exitButton.setLayoutY(10);
        exitButton.setText("Exit");
        combatButtonList.add(exitButton);

        header = new Text("Combat");
        header.setWrappingWidth(100);
        header.setLayoutX(width/2 - header.getWrappingWidth()/2);
        header.setLayoutY(50);
        header.setFill(Color.WHITE);
        header.setTextAlignment(TextAlignment.CENTER);
        header.setStyle("-fx-font-size: 16px;");
        addNode(header);
    }

    public void setStaminaText(HashMap<String, Integer> damageMap, HashMap<String, Integer> staminaNameMap){
        removeTextLabels();

        Text staminaText;
        Text damageText;


        for(String s : staminaNameMap.keySet()){
            staminaText = new Text();
            staminaText.setLayoutY(playerCircles.get(s).getCenterY()+20); //Hämtar jag verkligen ut playerCircles här????
            staminaText.setLayoutX(playerCircles.get(s).getCenterX() - 10);
            staminaText.setText("Stamina: " + staminaNameMap.get(s).toString());
            staminaText.setFill(Color.WHITE);
            addNode(staminaText);
            toRemove.add(staminaText);

            if(!damageMap.isEmpty() && damageMap.get(s) != 0){
                System.out.println("DAMaGEOOOOOOOOOOO");
                damageText = new Text();
                damageText.setLayoutX(playerCircles.get(s).getCenterX() + 20);

                damageText.setLayoutY(playerCircles.get(s).getCenterY());
                damageText.setText("Damage: -" + damageMap.get(s).toString());
                damageText.setFill(Color.RED);
                addNode(damageText);
                toRemove.add(damageText);

                System.out.println(playerCircles.get(s).getCenterX() + 20);
                System.out.println(playerCircles.get(s).getCenterY()-10);
            }else System.out.println("Damage is zero");

        }
    }

    void removeTextLabels(){
        for (Text t: toRemove) {
            rootPane.getChildren().remove(t);
        }
        toRemove.clear();
    }

    public void initPlayerCircles(List<String> nonHauntedNames, List<String> hauntedNames){
        int xDelta = 50;
        int yDelta = 40;

        Circle currentCircle;
        for (int i = 0; i < nonHauntedNames.size(); i++){
            currentCircle = new Circle(10);
            currentCircle.setCenterX(width/2 + xDelta);
            currentCircle.setCenterY(height/2 - yDelta*(nonHauntedNames.size()-1)/2 + yDelta*i);
            currentCircle.setFill(Color.BLUE);
            playerCircles.put(nonHauntedNames.get(i), currentCircle);
            addNode(currentCircle);
        }
        for (int i = 0; i < hauntedNames.size(); i++){
            currentCircle = new Circle(10);
            currentCircle.setCenterX(width/2 - xDelta);
            currentCircle.setCenterY(height/2 + 30*i);
            currentCircle.setFill(Color.RED);
            playerCircles.put(hauntedNames.get(i), currentCircle);
            addNode(currentCircle);
        }
    }

    public List<Button> getCombatButton() {
        return combatButtonList;
    }



    @Override
    public void viewToFront() {
        rootPane.toFront();
    }

    @Override
    public void addNode(Node node) {
        rootPane.getChildren().add(node);
    }
}
