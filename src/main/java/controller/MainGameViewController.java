package controller;

import javafx.scene.control.Button;
import model.Game;
import view.ViewInterface;

import java.util.HashMap;

public class MainGameViewController extends AbstractController{
    private Game game;
    private HashMap<Integer, Button> buttonMap;
    private ViewInterface mainGameView;
    private ViewInterface nextView;


    protected MainGameViewController(Game game, ViewInterface view) {
        super(game, view);
    }
}
