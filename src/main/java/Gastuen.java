
import XMLParser.XMLParser;
import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.EventFactory;
import model.Game;
import view.GameView;

public class Gastuen extends Application
{

	private GameView view;
	private Game game;
	private GameController controller;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
	//	EventFactory.setObserver(controller);
		modelInit();
		viewInit(stage);
		controllerInit();	//Testing if this placement works
		game.setObserver(controller);
		stage.show();
	}

	public void controllerInit(){
		controller = new GameController(view, game);
	}

	public void viewInit(Stage stage) {
		setView();
		stage.setTitle("Gastuen: Spooky House");
		stage.setScene(new Scene(view.getRoot(), GameView.WINDOW_W, GameView.WINDOW_H));
	}

	public void setView() {
		this.view = new GameView(game);
	}

	public void modelInit() {
		game = Game.getInstance();
	}
}