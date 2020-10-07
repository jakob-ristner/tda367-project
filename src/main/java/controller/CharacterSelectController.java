package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Game;
import view.ViewInterface;
import java.util.HashMap;
import java.util.List;

public class CharacterSelectController extends AbstractController{
    private HashMap<Integer, Button> buttonMap;
    private List<Text> textList;

    public CharacterSelectController(Game game, ViewInterface view){
        super(game, view);
    }

    public void setButtonMap(HashMap<Integer, Button> buttonMap) {
        this.buttonMap = buttonMap;
        initButtons();
    }

    public void setTextList(List<Text> textList) {
        this.textList = textList;
    }

   private void initButtons(){
        buttonMap.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(0, buttonMap.get(0));
            }
        });
        buttonMap.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(1, buttonMap.get(1));
            }
        });
        buttonMap.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(2, buttonMap.get(2));
            }
        });
        buttonMap.get(3).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(3, buttonMap.get(3));
            }
        });
    }

    private void buttonHandler(int index, Button button){
        game.getCurrentPlayer().setCharacter(game.getCharacterList().get(index));
        textList.get(index).setText("Chosen by Player " + (game.getCurrentPlayerIndex()+1));
        game.updateCurrentPlayer();
        button.setDisable(true);
        if (game.checkAllPlayersHaveChars()) {
            gameIinitMapData();
            showNextView();
        }
    }

    private void gameIinitMapData() {
        game.notifyGameStart();
    }


}
