package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

        public class StartScreenView implements ViewInterface, HasNextView{
    private Pane pane;
    private ViewInterface nextView;


    public StartScreenView(Group root, int width, int height) {
        pane = new Pane();
        pane.setPrefSize(width, height);
        pane.setStyle("-fx-background-color: white");
        root.getChildren().add(pane);
    }


    @Override
    public void viewToFront() {
        pane.toFront();
    }

    @Override
    public void addNode(Node node) {
        pane.getChildren().add(node);
    }

    @Override
    public void close() {
        pane.toBack();

    }

    @Override
    public void setNextView(ViewInterface view) {
        nextView = view;
    }

    @Override
    public void nextView() {
        nextView.viewToFront();
    }
}
