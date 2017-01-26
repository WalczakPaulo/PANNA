package utils;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class Constants
{
	public static final String DEMO_VERSION_LOGIN = "demo";
	public static final String DEMO_VERSION_PASSWORD = "demo";
	public static final String PRO_VERSION_LOGIN = "pro";
	public static final String PRO_VERSION_PASSWORD = "pro";
	public static final String EMPTY_LOGIN_PASS_EXCEPTION_MESSAGE = "Please fill out both required fields.";
	public static final String INCORRECT_LOGIN_PASS_EXCEPTION_MESSAGE =
			"Incorrect username or password. Try again.";
	public static final String DEFAULT_EXCEPTION_MESSAGE = "Unexpected problem has occurred!";
	public static final String DEFAULT_EXCEPTION_TITLE = "Operation failed";
	public static final String LOGIN_FAILED_EXCEPTION_TITLE = "Login failed!";
	public static final String QUERY_SELECT = " select ";
	public static final String QUERY_FROM = " from ";
	public static final String QUERY_WHERE = " where ";
	public static final String QUERY_LIKE = " like ";
	public static final String QUERY_ORDER_BY = " order by ";
	public static final String QUERY_ASC = " asc ";
	public static final int WINDOW_WITH_NO_OPTIONS_SIZE = 1000;
	public static final int WINDOW_WITH_OPTIONS_SIZE = 1300;
	public static final String DEFUALT_TITLE = "Panna Football Analytics App: ";
	public static final int ACTION_VIEW = 1;
	public static final int ACTION_INSERT = 2;
	public static final int ACTION_MODIFY = 3;
	public static final int ACTION_DELETE = 666;
	public static final String COUNTRIES_SEQ = "Countries_seq";

	public static final String FIELDS_MUST_BE_FILLED_VALIDATE_WARNING =
			"Please provide value to all fields with blue background.";
	public static final String COUNTRY_CODE_TOO_LONG_VALIDATE_WARNING =
			"Country code must be no longer than 3 characters.";
	public static final String COUNTRY_NAME_TOO_LONG_VALIDATE_WARNING =
			"Country name must be no longer than 30 characters.";
	public static final String CONSTRAINTS_EXIST_VALIDATE_WARNING =
			"This record can't be deleted - some other instances are using it.";
	public static final String CLUBS_PANE_NO_COUNTRY_SELECTED = "No country selected";
}
