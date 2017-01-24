package controller;

import database.connection.EntityListSupplier;
import database.models.FootbalClubsEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class ClubsController implements Initializable
{
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
		clubsBrowserColumnId.setCellValueFactory(new PropertyValueFactory<>("IdClub"));
		clubsBrowserColumnName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
		clubsBrowserColumnNickname.setCellValueFactory(new PropertyValueFactory<>("Nickname"));
		clubsBrowserColumnDate.setCellValueFactory(new PropertyValueFactory<>("CreationDate"));
		clubsBrowserColumnNIP.setCellValueFactory(new PropertyValueFactory<>("NIP"));
		clubsBrowserColumnREGON.setCellValueFactory(new PropertyValueFactory<>("REGON"));
		ObservableList list = EntityListSupplier.obtainDatabaseTable(FootbalClubsEntity.class);
		clubsBrowserTable.setItems(list);

	}
}

