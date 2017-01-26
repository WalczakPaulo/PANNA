package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import utils.Configuration;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */
public class EntityTableViewController
{
	@FXML private Button addCountryButton;
	@FXML private Button removeCountryButton;
	@FXML private Button modifyCountryButton;

	protected void initializeUserSpecificFeatures()
	{
		if (!Configuration.getInstance().getUserData().isFullVersion())
		{
			addCountryButton.setDisable(true);
			removeCountryButton.setDisable(true);
			modifyCountryButton.setDisable(true);
		}
	}
}
