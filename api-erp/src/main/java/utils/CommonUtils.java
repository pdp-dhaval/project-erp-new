package utils;

import java.util.Collection;

import com.erp.model.common.UserData;

public class CommonUtils {

	public static final Integer ACCOUNT_MASTER = 1;

	public static final String SOMETHING_WENT_WRONG = "Something went wrong";
	public static final String SUCCESS_MSG = "Success";
	public static final String INACTIVATED = "Successfully InActivated";
	public static final String INVALID_REQUEST = "Invalid Request";
	public static final String USER_DATA = "UD";

	public interface PersistanceContext {
		public static final String ERP_TM = "erpDataStoreTM";
		public static final String ERP_EM = "erpDataStoreEM";
		public static final String ERP_DS = "erpDataStore";
	}

	public static boolean isListNullOrEmpty(Collection<?> data) {
		return (data == null || data.isEmpty());
	}

	public static boolean isObjectNullOrEmpty(Object value) {
		return (value == null
				|| (value instanceof String
						? (((String) value).isEmpty() || "".equals(((String) value).trim()) || "null".equals(value)
								|| "undefined".equals(value))
						: false));
	}

	public interface Ignore {
		public static final String[] ACTIVITY_KEYS = { "createdBy", "orgId", "createdDate", "modifiedBy",
				"modifiedDate", "organizationId" };
	}

	public static Long getMainUserId(UserData data) {
		return isObjectNullOrEmpty(data.getParentId()) ? data.getUserId() : data.getParentId();
	}

	public enum Master {
		ACCOUNT_MASTER(1), ADDRERSS_MASTER(2), CATEGORY_MASTER(3), COMPANY_MASTER(4), CUSTMER_MASTER(5), PRODUCT_MASTER(
				6), ROUTE_MASTER(7);
		private int value;

		private Master(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static Master getType(Integer x) {
			switch (x) {
			case 1:
				return ACCOUNT_MASTER;
			case 2:
				return ADDRERSS_MASTER;
			case 3:
				return CATEGORY_MASTER;
			case 4:
				return COMPANY_MASTER;
			case 5:
				return CUSTMER_MASTER;
			case 6:
				return PRODUCT_MASTER;
			case 7:
				return ROUTE_MASTER;
			}
			return null;
		}

	}
}
