package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import model.Game;
import utilities.Coord;

import java.util.ArrayList;
import java.util.HashMap;
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

    private static final int X = 0;
    private static final int Y = 1;


    private int rectSize;
    private int doorButtonSize;
    private int doorButtonOffset;
    private HashMap<Integer, int[]> doorOffsetMap;

    //model representations
    private List<Circle> playerSprites;
    private List<Circle> playersSpritesCurrentFloor;
    private List<Text> allPlayersList;
    private Text currentPlayerIindicator;
    private Text currentplayer;
    private List<Text> currentPlayerStats;
    private List<Coord> playerCoords;
    private int currentPlayerIndex;
    private Text currentFloor;

    private HashMap<Integer, Boolean> currentTileDoors;
    private List<Button> doorButtons;

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
        rectSize = (height - 150) / 6;
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

    public void initMapData() {
        currentPlayerIndex = game.getCurrentPlayerIndex();
        initPlayerSprites();
        initPlayersPaneData();
        initStatsPane();
        initFloorPane();
        initButtons();
    }

    private void initPlayerSprites() {
        Circle currCircle;
        playerSprites = new ArrayList<>();
        playersSpritesCurrentFloor = new ArrayList<>();
        playerCoords = game.getPlayerPositions();
        for (int i = 0; i < game.getPlayerAmount(); i++) {
            currCircle = new Circle();
            currCircle.setCenterX(playerCoords.get(i).getX() * rectSize + rectSize / 2);
            currCircle.setCenterY(playerCoords.get(i).getY() * rectSize + rectSize / 2);
            currCircle.setRadius(15);
            currCircle.setFill(Color.BLUE);
            playerSprites.add(currCircle);
        }
        for (Integer index: game.getPlayerIndicesOnCurrentFloor()) {
            playersSpritesCurrentFloor.add(playerSprites.get(index));
            mapPane.getChildren().add(playerSprites.get(index));
        }
        playerSprites.get(currentPlayerIndex).setStyle("-fx-stroke: #ff0000; -fx-stroke-width: 2");
    }

    private void initPlayersPaneData() {
        allPlayersList = new ArrayList<>();
        currentPlayerIindicator = new Text("->");
        playersPane.getChildren().add(currentPlayerIindicator);
        Text currText;
        for (int i = 0; i < game.getPlayerAmount(); i++) {
           currText = new Text("Player " + (i + 1));
           currText.setWrappingWidth((width - (height - 150)) / 2);
           currText.setTextAlignment(TextAlignment.CENTER);
           currText.setLayoutX(0);
           currText.setLayoutY(50 + i * ((height - 150) / 2)/ game.getPlayerAmount());
           playersPane.getChildren().add(currText);
           allPlayersList.add(currText);
        }
        currentPlayerIindicator.setLayoutX(50);
        currentPlayerIindicator.setLayoutY(allPlayersList.get(currentPlayerIndex).getLayoutY());
    }

    private void initStatsPane() {
        currentplayer = new Text(game.getCurrentPlayersCharacterName());
        currentplayer.setWrappingWidth((width - (height - 150)) / 2);
        currentplayer.setTextAlignment(TextAlignment.CENTER);
        currentplayer.setLayoutX(0);
        currentplayer.setLayoutY(50);
        currentplayer.setStyle("-fx-font-size: 30");

        currentPlayerStats = new ArrayList<>();
        List<String> playerStatStrings = game.getCurrentPlayerStatsAsStrings();
        Text currStatText;
        for (int i = 0; i < playerStatStrings.size(); i++) {
            currStatText = new Text(playerStatStrings.get(i));
            currStatText.setWrappingWidth((width - (height - 150)) / 2);
            currStatText.setTextAlignment(TextAlignment.CENTER);
            currStatText.setLayoutX(0);
            currStatText.setLayoutY(100 + i * 50);
            currStatText.setStyle("-fx-font-size: 20");
            currentPlayerStats.add(currStatText);
            statsPane.getChildren().add(currStatText);
        }
        statsPane.getChildren().add(currentplayer);
    }

    private void initFloorPane() {
        currentFloor = new Text("Showing Floor: " + (game.getCurrentFloorNumber() + 1));
        currentFloor.setWrappingWidth(height - 150);
        currentFloor.setTextAlignment(TextAlignment.CENTER);
        currentFloor.setLayoutX(0);
        currentFloor.setLayoutY(50);
        currentFloor.setStyle("-fx-font-size: 20");
        floorPane.getChildren().add(currentFloor);
    }

    private void initButtons() {
        currentTileDoors = game.getCurrentTileDoors();
        doorButtonOffset = rectSize / 4;
        doorButtonSize = 10;
        doorOffsetMap = new HashMap<>();
        doorOffsetMap.put(0, new int[]{0, -doorButtonOffset});
        doorOffsetMap.put(1, new int[]{doorButtonOffset, 0});
        doorOffsetMap.put(2, new int[]{0, doorButtonOffset});
        doorOffsetMap.put(3, new int[]{-doorButtonOffset, 0});

        doorButtons = new ArrayList<>();
        Button currButton;
        for (int i = 0; i < 4; i++) { // 4 directions to walk
            currButton = new Button();
            currButton.setPrefSize(doorButtonSize, doorButtonSize);
            currButton.setLayoutX(getCurrentPlayerCenterX() + doorOffsetMap.get(i)[X] - doorButtonSize);
            currButton.setLayoutY(getCurrentPlayerCenterY() + doorOffsetMap.get(i)[Y] - doorButtonSize);
            currButton.setDisable(!currentTileDoors.get(i));
            doorButtons.add(currButton);
            mapPane.getChildren().add(currButton);
        }
    }

    public void updateMapData() {
        currentPlayerIndex = game.getCurrentPlayerIndex();
        updatePlayerSprites();
        updatePlayersPaneData();
        updateStatsPane();
        updateFloorPane();
        updateButtons();
    }

    private void updateButtons() {
        for (int i = 0; i < doorButtons.size(); i++) {
            doorButtons.get(i).setLayoutX(getCurrentPlayerCenterX() + doorOffsetMap.get(i)[X] - doorButtonSize);
            doorButtons.get(i).setLayoutY(getCurrentPlayerCenterY() + doorOffsetMap.get(i)[Y] - doorButtonSize);
            doorButtons.get(i).setDisable(!currentTileDoors.get(i));
        }
    }

    private void updateFloorPane() {
        currentFloor.setText("Showing Floor: " + (game.getCurrentFloorNumber() + 1));
    }

    private void updateStatsPane() {

        //updates the big character name in teh statspane
        currentplayer.setText(game.getCurrentPlayersCharacterName());

        //updates the stat texts
        List<String> playerStatStrings = game.getCurrentPlayerStatsAsStrings();
        for (int i = 0; i < playerStatStrings.size(); i++) {
            currentPlayerStats.get(i).setText(playerStatStrings.get(i));
        }
    }

    private void updatePlayersPaneData() {
        currentPlayerIindicator.setLayoutY(allPlayersList.get(currentPlayerIndex).getLayoutY());
    }

    private void updatePlayerSprites() {
        //reset players that are shown
        for (Circle playerSprite: playersSpritesCurrentFloor) {
            playerSprite.setStyle("-fx-stroke-width: none; -fx-stroke: none"); // one of these will be the last currentplayer
            mapPane.getChildren().remove(playerSprite);
        }
        playersSpritesCurrentFloor = new ArrayList<>();

        //update position of all players
        for (int i = 0; i < playerSprites.size(); i++) {
           playerSprites.get(i).setCenterX(playerCoords.get(i).getX() * rectSize + rectSize / 2);
           playerSprites.get(i).setCenterY(playerCoords.get(i).getY() * rectSize + rectSize / 2);
        }

        //update currentplayer indicator
        playerSprites.get(currentPlayerIndex).setStyle("-fx-stroke: red; -fx-stroke-width: 2");

        //show players on current floor
        for (Integer index: game.getPlayerIndicesOnCurrentFloor()) {
            playersSpritesCurrentFloor.add(playerSprites.get(index));
            mapPane.getChildren().add(playerSprites.get(index));
        }
    }


    private int getCurrentPlayerCenterX() {
        return (int) playerSprites.get(currentPlayerIndex).getCenterX();
    }

    private int getCurrentPlayerCenterY() {
        return (int) playerSprites.get(currentPlayerIndex).getCenterY();
    }

    List<Button> getDoorButtons() {
        return doorButtons;
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
