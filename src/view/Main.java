package view;
	
import client.ClientModel;
import javafx.application.Application;
import javafx.stage.Stage;
import model.PipeGameModel;
import viewModel.PipeGameViewModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	MediaPlayer mediaPlayer;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			PipeGameModel pgm = new PipeGameModel();
			ClientModel client = new ClientModel();
			PipeGameViewModel vm = new PipeGameViewModel(pgm, client);
			
			FXMLLoader fxl=new FXMLLoader();
			BorderPane root= fxl.load(getClass().getResource("MainWindow.fxml").openStream());
			MainWindowController mwc=fxl.getController(); // View
			mwc.setViewModel(vm);
			Media audio = new Media(getClass().getResource("BackroundTheme.wav").toString());
			mediaPlayer = new MediaPlayer(audio);
			mediaPlayer.setAutoPlay(true);
			mediaPlayer.setCycleCount(10);

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
