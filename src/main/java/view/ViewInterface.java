package view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.View;

public interface ViewInterface {
    void viewToFront();
    void addNode(Node node);
    void close();

}
