package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Game;
import java.util.HashMap;
import java.util.List;

/**
 * Controller for the characterSelectView
 */

public class CharacterSelectController extends AbstractController{
    private HashMap<Integer, Button> buttonMap;
    private List<Text> textList;
    private Button startGameButton;




    CharacterSelectController(Game game){
        super(game);
    }

    void setButtonMap(HashMap<Integer, Button> buttonMap) {
        this.buttonMap = buttonMap;
        initButtons();
    }

    //Choose your character-> All players have chosen a character

    void setTextList(List<Text> textList) {
        this.textList = textList;
    }
    void setStartGameButton(Button newButton) {
        startGameButton = newButton;
        startGameButton.setDisable(true);
    }

   private void initButtons(){
        for(int i = 0; i < buttonMap.size(); i++){
            final int tmp = i;
            buttonMap.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    buttonHandler(tmp, buttonMap.get(tmp));
                }
            });
        }
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showNextView();
            }
        });

    }


    private void buttonHandler(int index, Button button){
        game.setCurrentPlayersCharacter(index);
        textList.get(index).setText("Chosen by Player " + (game.getCurrentPlayerIndex() + 1));
        game.updateCurrentPlayer();
        button.setDisable(true);
        if (game.checkAllPlayersHaveChars()) {
            gameIinitMapData();
            for(int i = 0; i<buttonMap.size(); i++){
                buttonMap.get(i).setDisable(true);
            }
            startGameButton.setDisable(false);
        }
    }

    private void gameIinitMapData() {
        game.notifyGameStart();
    }


}
