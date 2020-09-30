package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;

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
    private ViewInterface nextView;

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

        buttonList.add(character1Button);
        buttonList.add(character2Button);
        buttonList.add(character3Button);
        buttonList.add(character4Button);


        for(int i = 0; i < buttonList.size(); i++){
            buttonList.get(i).setLayoutX(200);
            buttonList.get(i).setLayoutY(200 + 50*i);
            buttonList.get(i).setPrefSize(100, 30);
            buttonList.get(i).setText(characterNameList.get(i));
        }

        character1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(0,character1Button);
            }

        });

        character2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(1,character2Button);
            }
        });

        character3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(2,character3Button);
            }
        });

        character4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonHandler(3,character4Button);
            }
        });

    }

    private void buttonHandler(int index, Button button){
        game.getCurrentPlayer().setCharacter(game.getCharacterList().get(index));
        game.updateCurrentPlayer();
        deActivateButton(button);
        if (game.checkAllPlayersHaveChars())
            showNextView();
    }


    private void deActivateButton(Button button){
        button.setDisable(true);
    }

    private void showNextView() {
        //nextView.viewToFront();
        System.out.println("next view");
    }

    public void setNextView(ViewInterface nextView) {
        this.nextView = nextView;
    }




}
