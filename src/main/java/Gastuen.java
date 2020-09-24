
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import view.ProjectView;

public class Gastuen extends Application
{

	public static final String PROJECT_WINDOW_TEXT = "ProjectTemplate";
	public static final String PROJECT_BUTTON_TEXT = "Press me!";
	public static final int WINDOW_H = 500;
	public static final int WINDOW_W = 500;


	ProjectView view;
	Game game;

	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage stage) {
		stageInit(stage);
		stage.show();
	}

	public void stageInit(Stage stage) {
		setView();
		stage.setTitle(PROJECT_WINDOW_TEXT);
		stage.setScene(new Scene(view.getRoot(), WINDOW_W, WINDOW_H));
	}

	public void setView() {
		this.view = new ProjectView(new Game());
	}
}