package model;

import database.models.CountriesEntity;
import javafx.stage.Stage;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */
public class TableActionData
{
	private final int action;
	private final Object tableObject;
	private Stage stage;

	public TableActionData(int action, CountriesEntity item)
	{
		this.action = action;
		this.tableObject = item;
	}

	public int getAction()
	{
		return action;
	}

	public Stage getStage()
	{
		return stage;
	}

	public void setStage(Stage stage)
	{
		this.stage = stage;
	}

	public Object getTableObject()
	{
		return tableObject;
	}

}
