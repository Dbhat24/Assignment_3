package mru.tsc.application;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class that runs application, includes logger code
 * @author Faizan and Raj
 */
public class Main extends Application {
	private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); // Logger Object

	/**
	 * javafx application start up class
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MainScene.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * logger and launches application
	 * @param args any number of values
	 */
	public static void main(String[] args) {
		try {
			LogManager.getLogManager().reset();
			FileHandler fh = new FileHandler("MyLogFile.log" , true);
			fh.setLevel(Level.ALL);
			LOGR.addHandler(fh);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		LOGR.log(Level.INFO , "This is where the application starts and this is my first log");
		launch(args);
	}
}
