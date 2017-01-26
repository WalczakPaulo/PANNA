package controller.country;

import database.connection.DataSearcher;
import database.models.CountriesEntity;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.TableActionData;
import utils.Constants;
import utils.Helper;

import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Antoni Rozanski on 25.01.2017.
 */

public class CountriesController implements Initializable
{
	@FXML private TableView<?> countriesBrowserTable;

	@FXML private TableColumn<CountriesEntity, String> countriesBrowserId;

	@FXML private TableColumn<CountriesEntity, String> countriesBrowserName;

	@FXML private TableColumn<CountriesEntity, String> countriesBrowserCode;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		initializeTable();

	}

	private void initializeTable()
	{
		countriesBrowserId.setCellValueFactory(new PropertyValueFactory<>("idCountry"));
		countriesBrowserName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		countriesBrowserCode.setCellValueFactory(new PropertyValueFactory<>("shortName"));
		countriesBrowserTable.setRowFactory(param ->
		{
			TableRow<CountriesEntity> row = new TableRow<>();
			row.setOnMouseClicked(event ->
			{
				if (event.getClickCount() == 2 && (!row.isEmpty()))
					showCountryDetailedView(row.getItem());
			});
			return (TableRow) row;
		});
		refreshTable();
	}

	private void refreshTable()
	{
		ObservableList list = DataSearcher.obtainWholeDatabaseTable(CountriesEntity.class);
		countriesBrowserTable.setItems(list);
		countriesBrowserTable.getColumns().get(0).setVisible(false);
		countriesBrowserTable.getColumns().get(0).setVisible(true);
	}

	private boolean showCountryPopup(TableActionData data)
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/countryDetails.fxml"));
		try
		{
			BorderPane page = loader.load();
			Stage dialogStage = new Stage();
			dialogStage.initOwner(countriesBrowserTable.getScene().getWindow());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			CountryPopupController controller = loader.getController();

			data.setStage(dialogStage);
			controller.setActionData(data);
			dialogStage.showAndWait();
			return controller.isCountryAccepted();
		}
		catch (IOException e)
		{

			Helper.showDefaultExceptionAlertDialog(e);
		}
		return false;
	}

	private void showCountryDetailedView(CountriesEntity item)
	{
		TableActionData data = new TableActionData(Constants.ACTION_VIEW, item);
		showCountryPopup(data);
	}

	@FXML
	void addCountry(ActionEvent event)
	{
		CountriesEntity country = new CountriesEntity();
		country.setIdCountry(DataSearcher.obtainSequenceNextVal(Constants.COUNTRIES_SEQ));
		TableActionData data = new TableActionData(Constants.ACTION_INSERT, country);
		if (showCountryPopup(data))
		{
			DataSearcher.save((CountriesEntity) data.getTableObject());
			refreshTable();
		}
	}

	@FXML
	void modifyCountry(ActionEvent event)
	{
		CountriesEntity selectedCountry =
				(CountriesEntity) countriesBrowserTable.getSelectionModel().getSelectedItem();
		TableActionData data = new TableActionData(Constants.ACTION_MODIFY, selectedCountry);
		if (showCountryPopup(data))
		{
			DataSearcher.saveOrUpdate((CountriesEntity) data.getTableObject());
			refreshTable();
		}
	}

	@FXML
	void removeCountry(ActionEvent event)
	{
		CountriesEntity selectedCountry =
				(CountriesEntity) countriesBrowserTable.getSelectionModel().getSelectedItem();
		TableActionData data = new TableActionData(Constants.ACTION_DELETE, selectedCountry);
		if (showCountryPopup(data))
		{
			try
			{
				DataSearcher.delete((CountriesEntity) data.getTableObject());
				refreshTable();
			}
			catch (RuntimeException ex)
			{
				Helper.showExceptionAlertDialog(
						new ValidationException(Constants.CONSTRAINTS_EXIST_VALIDATE_WARNING));
			}
		}
	}

}
