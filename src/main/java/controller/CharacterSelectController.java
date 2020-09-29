package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;
import model.Kharacter;
import model.Player;
import view.CharacterSelectView;
import view.GameView;
import view.ViewInterface;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class CharacterSelectController {
    private Game game;
    private Button character1Button;
    private Button character2Button;
    private Button character3Button;
    private Button character4Button;
    private List<Button> buttonList;
    private ViewInterface characterSelectView;
    private int currentIndex;

    public CharacterSelectController(Game game,  ViewInterface characterSelectView){
        this.game = game;
        this.characterSelectView = characterSelectView;
        initButton();
        for(Button b: buttonList){
            characterSelectView.addNode(b);
        }

    }

    private void initButton(){
        character1Button = new Button();
        character2Button = new Button();
        character3Button = new Button();
        character4Button = new Button();
        buttonList = new ArrayList<>();
        List<String> characterNameList = game.getCharacterNames();
        final List<Kharacter> characterList = game.getCharacterList();
        final List<Player> playerList = game.getPlayerList();

        buttonList.add(character1Button);
        buttonList.add(character2Button);
        buttonList.add(character3Button);
        buttonList.add(character4Button);


        for(int i = 0; i < buttonList.size(); i++){
            currentIndex = i;
            buttonList.get(i).setLayoutX(200);
            buttonList.get(i).setLayoutY(200 + 50*i);
            buttonList.get(i).setPrefSize(100, 30);
            buttonList.get(i).setText(characterNameList.get(i));
        }

        character1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.getCurrentPlayer().setCharacter(characterList.get(0));
                game.updateCurrentPlayer();
                deActivateButton(character1Button);
                if (game.checkAllPlayersHaveChars())
                    nextView();
            }
        });

        character2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.getCurrentPlayer().setCharacter(characterList.get(1));
                game.updateCurrentPlayer();
                deActivateButton(character2Button);
                if (game.checkAllPlayersHaveChars())
                    nextView();
            }
        });

        character3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.getCurrentPlayer().setCharacter(characterList.get(2));
                game.updateCurrentPlayer();
                deActivateButton(character3Button);
                if (game.checkAllPlayersHaveChars())
                    nextView();
            }
        });

        character4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.getCurrentPlayer().setCharacter(characterList.get(3));
                game.updateCurrentPlayer();
                deActivateButton(character4Button);
                if (game.checkAllPlayersHaveChars())
                    nextView();
            }
        });


    }


    private void deActivateButton(Button button){
        button.setDisable(true);
    }

    private void nextView() {
        characterSelectView.nextView();
    }



}
