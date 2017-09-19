package utils;

import java.util.Collection;

public class CommonUtils {

	public static final Integer ACCOUNT_MASTER = 1;
	
	public static final String SOMETHING_WENT_WRONG = "Something went wrong";
	public static final String DATA_SUCCESSFULLY_FETCHED = "Data Successfully Fetched";
	public static final String DATA_SUCCESSFULLY_INACTIVATED = "Data Successfully InActivated";
	public static final String LIST_SUCCESSFULLY_FETCHED = "List Successfully Fetched";

	public static boolean isListNullOrEmpty(Collection data) {
        return (data == null || data.isEmpty());
    }

    public static boolean isObjectNullOrEmpty(Object value) {
        return (value == null || (value instanceof String ? (((String) value).isEmpty() || "".equals(((String) value).trim()) || "null".equals(value) || "undefined".equals(value)) : false));
    }
    
}
