package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombatScreenView implements ViewInterface{
    private Pane rootPane;
    private int width;
    private int height;

    private Button combatButton;
    private HashMap<String, Circle> playerCircles;



    public CombatScreenView(Group root, int width, int height){
        this.width = width;
        this.height = height;
        playerCircles = new HashMap<>();

        rootPane = new Pane();
        rootPane.setPrefSize(width,height);
        rootPane.setStyle("-fx-background-color: black");
        root.getChildren().add(rootPane);

        combatButton = new Button();
        combatButton.setPrefSize(width/5,height/16);
        combatButton.setLayoutX(width/2 - combatButton.getPrefWidth()/2);
        combatButton.setLayoutY(height - combatButton.getPrefHeight() - 50);
        addNode(combatButton);
    }

    public void setStaminaText(HashMap<String, Integer> staminaNameMap){
        Text playerText;
        for(String s : staminaNameMap.keySet()){
            playerText = new Text();
            playerText.setLayoutY(playerCircles.get(s).getLayoutY()); //Hämtar jag verkligen ut playerCircles här????
            playerText.setLayoutX(playerCircles.get(s).getLayoutX() - 10);
            playerText.setText("Stamina: " + staminaNameMap.get(s).toString());
            addNode(playerText);
        }
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

    @Override
    public void viewToFront() {
        rootPane.toFront();
    }

    @Override
    public void addNode(Node node) {
        rootPane.getChildren().add(node);
    }
}
