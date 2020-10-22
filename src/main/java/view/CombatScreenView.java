package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CombatScreenView implements ViewInterface {
    private Pane rootPane;
    private int width;
    private int height;
    private Text header;
    private List<Text> toRemove = new ArrayList<>();

    private Button combatButton;
    private Button exitButton;

    private List<Button> combatButtonList;
    private HashMap<String, Circle> playerCircles;


    public CombatScreenView(Group root, int width, int height) {
        this.width = width;
        this.height = height;
        playerCircles = new HashMap<>();
        combatButtonList = new ArrayList<>();

        rootPane = new Pane();
        rootPane.setPrefSize(width, height);
        rootPane.setStyle("-fx-background-color: black");
        root.getChildren().add(rootPane);

        combatButton = new Button();
        combatButton.setPrefSize(width / 5, height / 16);
        combatButton.setLayoutX(width / 2 - combatButton.getPrefWidth() / 2);
        combatButton.setLayoutY(height - combatButton.getPrefHeight() - 50);
        combatButton.setText("Battle!");
        combatButton.setFont(Font.font("Ink Free", 25));
        addNode(combatButton);
        combatButtonList.add(combatButton);

        exitButton = new Button();
        exitButton.setPrefSize(width / 10, height / 10);
        exitButton.setLayoutX(width - exitButton.getPrefWidth() - 10);
        exitButton.setLayoutY(10);
        exitButton.setText("Exit battle");
        exitButton.setFont(Font.font("Ink Free", 20));
        combatButtonList.add(exitButton);
        exitButton.setDisable(true);
        addNode(exitButton);


        header = new Text("The insane one is about to strike you");
        header.setFont(Font.font("Ink Free", 45));
        header.setWrappingWidth(400);
        header.setLayoutX(width / 2 - header.getWrappingWidth() / 2);
        header.setLayoutY(50);
        header.setFill(Color.WHITE);
        header.setTextAlignment(TextAlignment.CENTER);
        addNode(header);
    }

    public void setStaminaText(HashMap<String, Integer> staminaNameMap, HashMap<String, Integer> damageMap) {
        removeTextLabels();

        Text staminaText;
        Text damageText;


        for (String s : staminaNameMap.keySet()) {
            staminaText = new Text();
            staminaText.setLayoutY(playerCircles.get(s).getCenterY() + 30);
            staminaText.setLayoutX(playerCircles.get(s).getCenterX() - 30);
            staminaText.setText("Stamina: " + staminaNameMap.get(s).toString());
            staminaText.setFont(Font.font("Ink Free", 15));
            staminaText.setFill(Color.WHITE);
            addNode(staminaText);
            toRemove.add(staminaText);

            if (!damageMap.isEmpty() && damageMap.get(s) != 0) {
                damageText = new Text();
                damageText.setLayoutX(playerCircles.get(s).getCenterX() + 20);

                damageText.setLayoutY(playerCircles.get(s).getCenterY());
                damageText.setText("Damage: -" + damageMap.get(s).toString());
                damageText.setFont(Font.font("Ink Free", 20));
                damageText.setFill(Color.RED);
                addNode(damageText);
                toRemove.add(damageText);
            }

        }
    }

    void removeTextLabels() {
        for (Text t : toRemove) {
            rootPane.getChildren().remove(t);
        }
        toRemove.clear();
    }

    public void initPlayerCircles(List<String> nonHauntedNames, List<String> hauntedNames) {
        int xDelta = 50;
        int yDelta = 40;

        removeCircles();
        Circle currentCircle;

        for (int i = 0; i < nonHauntedNames.size(); i++) {
            currentCircle = new Circle(10);
            currentCircle.setCenterX(width / 2 + xDelta);
            currentCircle.setCenterY(height / 2 - yDelta * (nonHauntedNames.size() - 1) / 2 + yDelta * i);
            currentCircle.setFill(Color.BLUE);
            playerCircles.put(nonHauntedNames.get(i), currentCircle);
            addNode(currentCircle);
        }
        for (int i = 0; i < hauntedNames.size(); i++) {
            currentCircle = new Circle(10);
            currentCircle.setCenterX(width / 2 - xDelta);
            currentCircle.setCenterY(height / 2 + 30 * i);
            currentCircle.setFill(Color.RED);
            playerCircles.put(hauntedNames.get(i), currentCircle);
            addNode(currentCircle);
        }
    }

    private void removeCircles() {
        Collection<Circle> removableCircles = playerCircles.values();
        for (Circle c : removableCircles) {
            rootPane.getChildren().remove(c);
        }
        playerCircles.clear();
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
