package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CredentialsValidator;
import model.PannaLoginException;
import model.UserData;
import utils.Configuration;
import utils.Constants;
import utils.Helper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
	private CredentialsValidator validator = new CredentialsValidator();
	@FXML private TextField loginField;
	@FXML private PasswordField passwordField;
	@FXML private Button signButton;

	@FXML
	void loginOnEnter(KeyEvent event)
	{
		if (event.getCode().equals(KeyCode.ENTER))
			trySignIntoApp(new ActionEvent());

	}

	@FXML
	void trySignIntoApp(ActionEvent event)
	{
		try
		{
			UserData data = validator.tryValidate(loginField.getText(), passwordField.getText());
			Configuration.getInstance().setUserData(data);
			openAppForUser(data);
			closeLoginWindow();

		}
		catch (PannaLoginException ex)
		{
			Helper.showExceptionAlertDialog(ex, Constants.LOGIN_FAILED_EXCEPTION_TITLE);
		}
		catch (Throwable e)
		{
			Helper.showDefaultExceptionAlertDialog(e);
		}
	}

	private void closeLoginWindow()
	{
		Stage stage = (Stage) loginField.getScene().getWindow();
		stage.close();
	}

	private void openAppForUser(UserData data) throws IOException
	{

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/mainPane.fxml"));
		BorderPane root = fxmlLoader.load();
		Stage stage = new Stage();

		stage.setScene(new Scene(root));

		SplitPane clubsPane;
		clubsPane = FXMLLoader.load(this.getClass().getResource("/view/footballClubsPane.fxml"));
		((BorderPane) root.getCenter()).setCenter(clubsPane);
		stage.setResizable(false);
		stage.setTitle(Constants.DEFUALT_TITLE + data.getLogin());
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	}
}
