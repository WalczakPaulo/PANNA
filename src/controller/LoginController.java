package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.CredentialsValidator;
import model.PannaLoginException;
import model.UserData;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
	private CredentialsValidator validator = new CredentialsValidator();

	@FXML private PasswordField passwordField;

	@FXML private Button signButton;

	@FXML private TextField loginField;

	@FXML
	void trySignIntoApp(ActionEvent event)
	{
		try
		{
			UserData data = validator.tryValidate(loginField.getText(), passwordField.getText());
			openAppForUser(data);
		}
		catch (PannaLoginException ex)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);

			alert.setTitle("Login failed!");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());
			alert.showAndWait();

		}
	}

	private void openAppForUser(UserData data)
	{

	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{

	}
}
