package controller;

import database.connection.DataSearcher;
import database.models.FootbalClubsEntity;
import database.query.ClubsFromCountryQuerySupplier;
import database.query.ClubsNamePatternQuerySupplier;
import database.query.QuerySupplier;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.Constants;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class ClubsController extends EntityTableViewController implements Initializable

{
	String lastCountry = Constants.CLUBS_PANE_NO_COUNTRY_SELECTED;
	@FXML private TextField clubNameSearchField;
	@FXML private ComboBox<String> clubCountrySelectBox;
	@FXML private DatePicker clubCreationDatePicker;
	@FXML private TableView<?> clubsBrowserTable;
	@FXML private TableColumn<FootbalClubsEntity, Integer> clubsBrowserColumnId;
	@FXML private TableColumn<FootbalClubsEntity, String> clubsBrowserColumnName;
	@FXML private TableColumn<FootbalClubsEntity, String> clubsBrowserColumnNickname;
	@FXML private TableColumn<FootbalClubsEntity, String> clubsBrowserColumnDate;
	@FXML private TableColumn<FootbalClubsEntity, String> clubsBrowserColumnNIP;
	@FXML private TableColumn<FootbalClubsEntity, String> clubsBrowserColumnREGON;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{

		initializeTable();
		initializeUserSpecificFeatures();
		initializeCountriesSelectBox();
	}

	private void initializeCountriesSelectBox()
	{
		QuerySupplier querySupplier = new CountriesNamesQuerySupplier();
		ObservableList list = DataSearcher
				.obtainDatabaseDataForQuery(querySupplier.supplyQuery(), querySupplier.supplyParams());
		list.add(0, Constants.CLUBS_PANE_NO_COUNTRY_SELECTED);
		clubCountrySelectBox.setItems(list);
	}

	private void initializeTable()
	{
		clubsBrowserColumnId.setCellValueFactory(new PropertyValueFactory<>("IdClub"));
		clubsBrowserColumnName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
		clubsBrowserColumnNickname.setCellValueFactory(new PropertyValueFactory<>("Nickname"));
		clubsBrowserColumnDate.setCellValueFactory(new PropertyValueFactory<>("CreationDate"));
		clubsBrowserColumnNIP.setCellValueFactory(new PropertyValueFactory<>("NIP"));
		clubsBrowserColumnREGON.setCellValueFactory(new PropertyValueFactory<>("REGON"));
		ObservableList list = DataSearcher.obtainWholeDatabaseTable(FootbalClubsEntity.class);
		clubsBrowserTable.setItems(list);
	}

	@FXML
	void searchForClub()
	{
		QuerySupplier querySupplier = new ClubsNamePatternQuerySupplier(clubNameSearchField.getText());

		ObservableList list = DataSearcher
				.obtainDatabaseDataForQuery(querySupplier.supplyQuery(), querySupplier.supplyParams());
		clubsBrowserTable.setItems(list);
	}

	@FXML
	void findClubsFromCountry(ActionEvent event)
	{
		String selectedCountry = clubCountrySelectBox.getSelectionModel().getSelectedItem();
		if (selectedCountry == null || selectedCountry.equals(lastCountry))
			return;
		lastCountry = selectedCountry;
		findClubsFromGivenCountry(selectedCountry);

	}

	private void findClubsFromGivenCountry(String selectedCountry)
	{
		if (selectedCountry.equals(Constants.CLUBS_PANE_NO_COUNTRY_SELECTED))
		{
			ObservableList list = DataSearcher.obtainWholeDatabaseTable(FootbalClubsEntity.class);
			clubsBrowserTable.setItems(list);
		}
		else
		{
			QuerySupplier querySupplier = new ClubsFromCountryQuerySupplier(selectedCountry);
			ObservableList list = DataSearcher
					.obtainDatabaseDataForQuery(querySupplier.supplyQuery(), querySupplier.supplyParams());
			clubsBrowserTable.setItems(list);
		}
	}
}

