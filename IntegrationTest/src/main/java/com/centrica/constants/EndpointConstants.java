package com.centrica.constants;

public class EndpointConstants {
	public static String URL_HOST_BASE = "https://api1.bgdigitaltest.co.uk";
	public static String URL_APPOINTMENT_ORIGIN = "http://www.britishgas.co.uk";
public static String URL_PAYMENT_COLLECTION="https://payments-test.worldpay.com/app/hpp/integration/wpg/corporate?OrderKey=RSDC%5E%7B%7Bcustomer%7D%7D-RSDC-20190115220728625&Ticket=00154801844883602RlnHbiSvb-GBJTQyhmvx3Q";
	
	
	public static String ENDPOINT_ADDRESS_SEARCH = "/v1/addresses?postcode=";
	public static String ENDPOINT_APPOINTMENTS = "/v1/appointments";
	public static String ENDPOINT_SERVICE_PRODUCT = "/v1/services-products";
	public static String ENDPOINT_RESERVE_APPOINTMENT="/v1/appointments/{{appointment}}";
	public static String ENDPOINT_BOOK_APPOINTMENT="/v1/appointments/{{appointment}}";
	public static String ENDPOINT_SERVICE_ONE_OF_ACCOUNT="/v1/services-one-off-accounts";
	public static String ENDPOINT_ORDER_PAYMENT="/v1/payment-orders";
	public static String ENDPOINT_PAYMENT_STATUS="/v1/payment-orders/{{PaymentOrder}}";
}
