package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

/**
 * Created by Antoni Rozanski on 21.01.2017.
 */
public class Main extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			SplitPane root;
			root = FXMLLoader.load(this.getClass().getResource("/view/loginPane.fxml"));

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Panna Football App");
			primaryStage.setResizable(false);
			root.setDividerPosition(0, 0.7);
			primaryStage.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}