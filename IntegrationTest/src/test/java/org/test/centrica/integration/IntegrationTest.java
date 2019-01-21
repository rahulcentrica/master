package org.test.centrica.integration;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

import com.centrica.constants.JsonPathConstants;
import com.test.centrica.api.AccountApiCall;
import com.test.centrica.api.AddressSearchApiCall;
import com.test.centrica.api.AppointmentApiCall;
import com.test.centrica.api.PaymentApiCall;
import com.test.centrica.api.ServiceProductsApiCall;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IntegrationTest {

	@Test
	public void makeSureServicesAreRunning() {

		// fetch the address details
		Object addressOne = AddressSearchApiCall.findAddresses( "NG97ES").jsonPath().getMap(JsonPathConstants.DATA_AT_0)
				.get(JsonPathConstants.ID);

		// find service products
		String serviceProductID = ServiceProductsApiCall.reteriveServiceProducts().jsonPath()
				.getMap(JsonPathConstants.DATA_AT_0).get(JsonPathConstants.ID).toString();

		// find appointment for address
		Response appointmentsResponse = AppointmentApiCall.findAppointment(addressOne.toString());

		String first_available_slot_id = getAvialableAppointmentSlot(appointmentsResponse);

		String appointmentId = (String) appointmentsResponse.jsonPath().getString(JsonPathConstants.PATH_DATA_ID);

		String appointmentRefNumber = (String) appointmentsResponse.jsonPath()
				.getString(JsonPathConstants.PATH_APPOINTMENT_REFERENCE_NUMBER);

		// reserve the appointment
		AppointmentApiCall.reserveAppointment(first_available_slot_id);

		// service one of the account
		String serviceAccountId = AccountApiCall.serviceOneOfAccounts(addressOne.toString()).jsonPath()
				.getString(JsonPathConstants.PATH_SERVICE_ACCOUNT_ID);
		String customerId = AccountApiCall.serviceOneOfAccounts(addressOne.toString()).jsonPath()
				.getString(JsonPathConstants.PATH_CUSTOMER_ID);

		// make the payment
		Response orderPaymentResponse = PaymentApiCall.orderPayment(customerId);
		String paymentOrderCode = orderPaymentResponse.jsonPath().getString(JsonPathConstants.PATH_PAYMENT_ORDER_CODE);
		String paymentOrderID = orderPaymentResponse.jsonPath().getString(JsonPathConstants.PATH_DATA_ID);

		// verify Payment status
		String paymentId = PaymentApiCall.verifyPaymentStatus(paymentOrderID, paymentOrderCode).jsonPath()
				.getString(JsonPathConstants.PATH_DATA_ID);
		
		//Book Appointment
		String bookingId = AppointmentApiCall.bookAppointment(appointmentId, appointmentRefNumber, serviceProductID,
				paymentId, customerId, serviceAccountId).jsonPath().get(JsonPathConstants.PATH_DATA_ID);

		System.out.println("bookingId : " + bookingId);

	}

	private String getAvialableAppointmentSlot(Response appointmentsResponse) {

		JsonPath json = appointmentsResponse.jsonPath();

		List<Map<String, String>> availableSlots = json.get(JsonPathConstants.INCLUDED);

		Optional<Map<String, String>> found = availableSlots.stream().filter(x -> x.toString().contains("true"))
				.findFirst();

		return found.get().get("id").toString();
	}

}
