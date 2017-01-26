package controller;

import database.connection.DataSearcher;
import database.models.FootbalClubsEntity;
import database.query.ClubsNamePatternQuerySupplier;
import database.query.QuerySupplier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class ClubsController extends EntityTableViewController implements Initializable

{
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

	public void searchClubsForCountry(MouseEvent mouseEvent)
	{
	}
}

