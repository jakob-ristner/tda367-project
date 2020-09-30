package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.util.Stack;


public class CharacterSelectView implements ViewInterface, HasNextView{
    private Pane pane;
    private Text text;
    private Text playerText;
    private ViewInterface nextView;
    private Stack<Text> textStack;




    public CharacterSelectView(Group root, int width, int height){
        textStack = new Stack<>();
        pane = new Pane();
        text = new Text("Choose your character");
        text.setStyle("-fx-font-size: 40px;");
        text.setWrappingWidth(300);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setLayoutX(width / 2 - text.getWrappingWidth() / 2);
        text.setLayoutY(50);
        addNode(text);

        playerText = new Text();
        playerText.setText("It's Player 1:s turn!");
        playerText.setWrappingWidth(300);
        playerText.setTextAlignment(TextAlignment.CENTER);
        playerText.setLayoutX(width / 2 - text.getWrappingWidth() / 2);
        playerText.setLayoutY(150);
        addNode(playerText);

        root.getChildren().add(pane);

        pane.setPrefSize(width, height);
        pane.setStyle("-fx-background-color: green");
    }

    @Override
    public void viewToFront() {
        pane.toFront();
    }

    public void setCurrentPlayerText(int index) {
        playerText.setText("It's Player " + (index+1) + ":s turn!");
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
        //nextView.viewToFront();
        System.out.println("Next View");
    }
}
