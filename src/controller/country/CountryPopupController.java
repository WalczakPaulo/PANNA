package controller.country;

import database.models.CountriesEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CountryValidator;
import model.PannaValidateException;
import model.TableActionData;
import model.Validator;
import utils.Constants;
import utils.Helper;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */

public class CountryPopupController
{
	private boolean isOk = false;
	private Stage stage;
	private CountriesEntity country;

	@FXML private TextField countryId;
	@FXML private TextField countryName;
	@FXML private TextField countryCode;
	@FXML private Button acceptButton;
	@FXML private Button cancelButton;

	public boolean isCountryAccepted()
	{
		return isOk;
	}

	@FXML
	void accept(ActionEvent event) throws PannaValidateException
	{
		Validator val = new CountryValidator();
		try
		{
			val.tryValidate(prepareEntityWithFieldsToCheck());
		}
		catch (PannaValidateException ex)
		{
			Helper.showInfoAlertDialog(ex, "Action failed");
			return;
		}
		country.setIdCountry(Long.parseLong(countryId.getText()));
		country.setFullName(countryName.getText().trim());
		country.setShortName(countryCode.getText().trim().toUpperCase());
		isOk = true;
		stage.close();
	}

	private CountriesEntity prepareEntityWithFieldsToCheck()
	{
		CountriesEntity country = new CountriesEntity();
		country.setIdCountry(Long.parseLong(countryId.getText()));
		country.setFullName(countryName.getText());
		country.setShortName(countryCode.getText());
		return country;

	}

	@FXML
	void cancel(ActionEvent event)
	{
		stage.close();
	}

	public void setCountry(CountriesEntity item)
	{
		this.country = item;
		countryId.setText(String.valueOf(item.getIdCountry()));
		countryName.setText(item.getFullName());
		countryCode.setText(item.getShortName());
	}

	public void setActionData(TableActionData data)
	{
		stage = data.getStage();
		setCountry((CountriesEntity) data.getTableObject());
		initFields(data.getAction());
	}

	private void initFields(int action)
	{
		cancelButton.requestFocus();
		if (action == Constants.ACTION_VIEW)
			initActionView();
		if (action == Constants.ACTION_INSERT)
			initActionInsert();
		if (action == Constants.ACTION_MODIFY)
			initActionModify();
		if (action == Constants.ACTION_DELETE)
			initActionDelete();
	}

	private void initActionDelete()
	{
		countryName.setEditable(false);
		countryCode.setEditable(false);
		acceptButton.setText("Delete");
	}

	private void initActionModify()
	{
		stage.setTitle("Modify country details");
		acceptButton.setText("Modify");
	}

	private void initActionInsert()
	{
		stage.setTitle("Add new country");
		acceptButton.setText("Add");

	}

	private void initActionView()
	{
		disableFields();
		stage.setTitle("Country details view");
	}

	private void disableFields()
	{
		countryName.setEditable(false);
		countryCode.setEditable(false);
		acceptButton.setVisible(false);
	}
}
