package utils;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class Helper
{
	public static void showExceptionAlertDialog(Exception e, String title)
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);

		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(e.getMessage());
		alert.showAndWait();
	}

	public static void showDefaultExceptionAlertDialog(Throwable e)
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);

		alert.setTitle(Constants.DEFAULT_EXCEPTION_TITLE);
		alert.setHeaderText(null);
		alert.setContentText(Constants.DEFAULT_EXCEPTION_MESSAGE);
		alert.getDialogPane().setExpandableContent(prepareExpandableTextField(e));
		alert.showAndWait();

	}

	private static Node prepareExpandableTextField(Throwable e)
	{
		TextArea textArea = new TextArea(prepareStackTraceString(e));
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane gp = new GridPane();
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		gp.add(textArea, 0, 0);
		return gp;
	}

	private static String prepareStackTraceString(Throwable e)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
}
