package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Game;
import view.ViewInterface;
import java.util.HashMap;
import java.util.List;

/**
 * Controller for the characterSelectView
 */

public class CharacterSelectController extends AbstractController{
    private HashMap<Integer, Button> buttonMap;
    private List<Text> textList;
    private Button startGameButton;
    private Text text;




    public CharacterSelectController(Game game){
        super(game);
    }

    /**
     *
     * @param buttonMap
     */
    public void setButtonMap(HashMap<Integer, Button> buttonMap) {
        this.buttonMap = buttonMap;
        initButtons();
    }

    //Choose your character-> All players have chosen a character
    public void setTextAbove(Text text){
        this.text = text;
    }

    public void setTextList(List<Text> textList) {
        this.textList = textList;
    }
    public void setStartGameButton(Button newButton) {
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



        /*buttonMap.get(0).setOnAction(new EventHandler<ActionEvent>() {
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
        */

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
