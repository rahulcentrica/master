package com.centrica.constants;

public class JsonPathConstants {

	public final static String ID = "id";
	public final static String DATA = "data";
	public final static String ATTRIBUTES = "attributes";
	public final static String RELATIONSHIPS = "relationships";
	public final static String SERVICES = "services";
	public final static String ACCOUNT = "account";
	public final static String ORDER_CODE = "order-code";
	public final static String SERVICES_ACCOUNT = "services-account";
	public final static String URL = "url";
	public final static String DATA_AT_0 = "data[0]";
	public final static String INCLUDED_AT_0 = "included[0]";
	public final static String INCLUDED = "included";
	public final static String PATH_SERVICE_ACCOUNT_ID = "data.relationships.services-account.data.id";
	public final static String PATH_WORLD_PAY_PAYMENT_URL = "data.attributes.url";
	public final static String PATH_PAYMENT_ORDER_CODE = "data.attributes.order-code";
	public static final String PATH_DATA_ID = "data.id";
	
	public final static String PATH_APPOINTMENT_REFERENCE_NUMBER = "data.attributes.reference";
	public static final String PATH_CUSTOMER_ID = "data.relationships.customer.data.id";

}
