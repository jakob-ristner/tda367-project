package controller;

import model.Game;
import view.ViewInterface;

public abstract class AbstractController {
    protected Game game;
    private ViewInterface nextView;

    AbstractController(Game game) {
        this.game = game;

    }

    void showNextView() {
        nextView.viewToFront();
    }

    void setNextView(ViewInterface nextView) {
        this.nextView = nextView;
    }

}
