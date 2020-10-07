package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Game;
import utilities.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainGameView implements ViewInterface{
    private int width;
    private int height;
    private Pane rootPane;
    private AnchorPane mapPane;
    private AnchorPane statsPane;
    private AnchorPane playersPane;
    private AnchorPane inventoryPane;
    private AnchorPane floorPane;

    //model representations
    private List<Circle> playerReps;
    List<Text> allPlayersList;
    Text currentplayer;
    Text currentPlayerStats;
    List<Coord> playerCoords;

    private Game game;
    List<List<Rectangle>> tileViews;




    public MainGameView(Group root, int width, int height, Game game) {
        rootPane = new Pane();
        rootPane.setPrefSize(width, height);
        root.getChildren().add(rootPane);
        this.width = width;
        this.height = height;
        this.game = game;
        initPanes();
        initTileViews();
        game.notifyGameEvent();
    }

    private void initPanes() {

        mapPane = new AnchorPane();
        mapPane.setPrefSize(height - 150, height - 150);
        mapPane.setLayoutY(0);
        mapPane.setLayoutX(width / 2 - (height - 150) / 2);

        statsPane = new AnchorPane();
        statsPane.setPrefSize((width - (height - 150)) / 2, height - 150);
        statsPane.setLayoutY(0);
        statsPane.setLayoutX(width - (width - (height - 150))/2);
        statsPane.setStyle("-fx-background-color: gray");

        playersPane = new AnchorPane();
        playersPane.setPrefSize((width - (height - 150)) / 2, (height - 150)/ 2);
        playersPane.setLayoutY(0);
        playersPane.setLayoutX(0);
        playersPane.setStyle("-fx-background-color: green");

        inventoryPane = new AnchorPane();
        inventoryPane.setPrefSize((width - (height - 150)) / 2, height - (height - 150)/2);
        inventoryPane.setLayoutY((height - 150) / 2);
        inventoryPane.setLayoutX(0);
        inventoryPane.setStyle("-fx-background-color: blue");

        floorPane = new AnchorPane();
        floorPane.setPrefSize(width - (height - 150) / 2, 150);
        floorPane.setLayoutX((height - 150)/2);
        floorPane.setLayoutY(height - 150);
        floorPane.setStyle("-fx-background-color: pink");

        addNode(inventoryPane);
        addNode(playersPane);
        addNode(statsPane);
        addNode(mapPane);
        addNode(floorPane);
    }

    private void initTileViews() {
        tileViews = new ArrayList<>();
        Rectangle currentRect;
        int rectSize = (height - 150) / 6;
        for(int i = 0; i < 6; i++) {
            tileViews.add(new ArrayList<Rectangle>());
            for (int k = 0; k < 6; k++) {
                currentRect = new Rectangle(rectSize, rectSize);
                currentRect.setX(i * rectSize);
                currentRect.setY(k * rectSize);
                currentRect.setStyle(" -fx-fill: black; -fx-stroke: white; -fx-stroke-width: 5;");
                mapPane.getChildren().add(currentRect);
                tileViews.get(i).add(currentRect);
            }
        }

    }

    public void updateMapData() {

    }


    @Override
    public void viewToFront() {
        rootPane.toFront();
    }

    @Override
    public void addNode(Node node) {
        rootPane.getChildren().add(node);
    }

    @Override
    public void close() {

    }
}
