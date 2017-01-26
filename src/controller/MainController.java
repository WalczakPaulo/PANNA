package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import utils.Constants;

import java.io.IOException;
import java.net.URL;

public class MainController
{
	@FXML private BorderPane mainBorderPane;

	@FXML private Menu clubsMenu;

	@FXML private MenuItem clubsMenuItem;

	@FXML private Menu CountriesMenu;

	@FXML private Menu AddressesMenu;

	@FXML private MenuItem addressesMenuItem;

	@FXML
	void openAddressesBrowser(ActionEvent event)
	{

	}

	@FXML
	void openClubsBrowser(ActionEvent event) throws IOException
	{
		setNewBrowser(getClass().getResource("/view/footballClubsPane.fxml"));
		setBiggerWindowSize();
	}

	private void setNewBrowser(URL resource) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(resource);
		Region countriesBrowser = fxmlLoader.load();
		mainBorderPane.setCenter(countriesBrowser);
	}

	@FXML
	void openCountriesBrowser(ActionEvent event) throws IOException
	{

		setNewBrowser(getClass().getResource("/view/countriesPane.fxml"));
		setSmallerWindowSize();
	}

	private void setBiggerWindowSize()
	{
		Stage stage = (Stage) mainBorderPane.getScene().getWindow();
		stage.setMinWidth(Constants.WINDOW_WITH_OPTIONS_SIZE);
		stage.setMaxWidth(Constants.WINDOW_WITH_OPTIONS_SIZE);

	}

	private void setSmallerWindowSize()
	{
		Stage stage = (Stage) mainBorderPane.getScene().getWindow();
		stage.setMaxWidth(Constants.WINDOW_WITH_NO_OPTIONS_SIZE);
		stage.setMinWidth(Constants.WINDOW_WITH_NO_OPTIONS_SIZE);
	}

}
