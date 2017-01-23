package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.CredentialsValidator;
import model.PannaLoginException;
import model.UserData;
import utils.Constants;
import utils.Helper;

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
			openAppForUser(data);
			closeLoginWindow();

		}
		catch (PannaLoginException ex)
		{
			Helper.showExceptionAlertDialog(ex, Constants.LOGIN_FAILED_EXCEPTION_TITLE);
		}
	}

	private void closeLoginWindow()
	{
		Stage stage = (Stage) loginField.getScene().getWindow();
		stage.close();
	}

	private void openAppForUser(UserData data)
	{

		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/clubsPane.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();

			stage.setScene(new Scene(root));
			stage.show();
		}
		catch (Exception e)
		{
			Helper.showDefaultExceptionAlertDialog(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	}
}
