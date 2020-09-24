
import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import view.GameView;

public class Gastuen extends Application
{

	public static final String PROJECT_WINDOW_TEXT = "ProjectTemplate";
	public static final String PROJECT_BUTTON_TEXT = "Press me!";
	public static final int WINDOW_H = 500;
	public static final int WINDOW_W = 500;


	private GameView view;
	private Game game;
	private GameController controller;
	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage stage) {
		modelInit();
		viewInit(stage);
		controllerInit();	//Testing if this placement works
		stage.show();
	}

	public void controllerInit(){
		controller = new GameController(view, game);
	}

	public void viewInit(Stage stage) {
		setView();
		stage.setTitle(PROJECT_WINDOW_TEXT);
		stage.setScene(new Scene(view.getRoot(), WINDOW_W, WINDOW_H));
	}

	public void setView() {
		this.view = new GameView(game);
	}

	public void modelInit() {
		game = new Game();
	}
}