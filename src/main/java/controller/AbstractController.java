package controller;

import model.Game;
import view.ViewInterface;

public abstract class AbstractController {
    protected Game game;
    private ViewInterface nextView;

    protected AbstractController(Game game) {
        this.game = game;

    }

    public void showNextView() {
        nextView.viewToFront();
    }

    public void setNextView(ViewInterface nextView) {
        this.nextView = nextView;
    }

}
