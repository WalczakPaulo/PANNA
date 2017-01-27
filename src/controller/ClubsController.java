package controller;

import database.connection.DataSearcher;
import database.models.FootbalClubsEntity;
import database.query.ClubsFromCountryQuerySupplier;
import database.query.ClubsFromDateQuerySupplier;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class ClubsController extends EntityTableViewController implements Initializable

{
	boolean isActionOngoing = false;
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
		clubsBrowserColumnNIP.setCellValueFactory(new PropertyValueFactory<>("nip"));
		clubsBrowserColumnREGON.setCellValueFactory(new PropertyValueFactory<>("regon"));
		ObservableList list = DataSearcher.obtainWholeDatabaseTable(FootbalClubsEntity.class);
		clubsBrowserTable.setItems(list);
	}

	@FXML
	void searchForClubByName()
	{
		if (isActionOngoing)
			return;
		isActionOngoing = true;
		clubCountrySelectBox.getSelectionModel().clearSelection();
		clubCreationDatePicker.setValue(null);
		QuerySupplier querySupplier = new ClubsNamePatternQuerySupplier(clubNameSearchField.getText());

		ObservableList list = DataSearcher
				.obtainDatabaseDataForQuery(querySupplier.supplyQuery(), querySupplier.supplyParams());
		clubsBrowserTable.setItems(list);
		isActionOngoing = false;
	}

	@FXML
	void findClubsFromCountry(ActionEvent event)
	{
		if (isActionOngoing)
			return;
		isActionOngoing = true;
		clubNameSearchField.clear();
		clubCreationDatePicker.setValue(null);
		String selectedCountry = clubCountrySelectBox.getSelectionModel().getSelectedItem();
		if (selectedCountry == null)
			return;
		findClubsFromGivenCountry(selectedCountry);
		isActionOngoing = false;
	}

	@FXML
	void findClubsOlderThan(ActionEvent event)
	{
		if (isActionOngoing)
			return;
		isActionOngoing = true;
		clubCountrySelectBox.getSelectionModel().clearSelection();
		LocalDate date = clubCreationDatePicker.getValue();

		findClubsFromDate(date);
		clubNameSearchField.clear();
		isActionOngoing = false;
	}

	private void findClubsFromDate(LocalDate date)
	{
		if (date == null)
		{
			ObservableList list = DataSearcher.obtainWholeDatabaseTable(FootbalClubsEntity.class);
			clubsBrowserTable.setItems(list);
		}
		else
		{
			QuerySupplier querySupplier = new ClubsFromDateQuerySupplier(date);
			ObservableList list = DataSearcher
					.obtainDatabaseDataForQuery(querySupplier.supplyQuery(), querySupplier.supplyParams());
			clubsBrowserTable.setItems(list);
		}
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

