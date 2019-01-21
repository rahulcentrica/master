package com.test.centrica.api;

import static com.centrica.constants.EndpointConstants.ENDPOINT_APPOINTMENTS;
import static com.centrica.constants.EndpointConstants.ENDPOINT_RESERVE_APPOINTMENT;
import static com.centrica.constants.EndpointConstants.ENDPOINT_BOOK_APPOINTMENT;
import static com.centrica.constants.EndpointConstants.URL_APPOINTMENT_ORIGIN;
import static com.centrica.constants.EndpointConstants.URL_HOST_BASE;
import static com.centrica.constants.ServiceConstants.X_CLIENT_ID;
import static io.restassured.RestAssured.given;

import com.centrica.types.ReCapechaTokenType;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AppointmentApiCall {

	public static Response findAppointment(String addressId) {
		String body = BodyContentForHttp.getAppointmentBodyContent().replace("{{addressIdOne}}", addressId);

		return given()
				.headers("Content-Type", "application/vnd.api+json", "X-Client-ID", X_CLIENT_ID, "Origin",
						URL_APPOINTMENT_ORIGIN, "X-reCAPTCHA-Token",
						BodyContentForHttp.getReCapechaToken(ReCapechaTokenType.APPOINTMENT.getType()),
						"x-skip-reCAPTCHA-check", "true")
				.body(body).when().post(URL_HOST_BASE + ENDPOINT_APPOINTMENTS).then().contentType(ContentType.JSON)
				.extract().response();

	}

	public static Response reserveAppointment(String appointmentId) {
		String body = BodyContentForHttp.getReserveAppointmentBodyContent().replace("{{first_available_slot_id}}",
				appointmentId);
		String appointmentApiEndpoint = ENDPOINT_RESERVE_APPOINTMENT.replace("{{appointment}}", appointmentId);
		return given()
				.headers("Content-Type", "application/vnd.api+json", "X-Client-ID", X_CLIENT_ID, "Origin",
						URL_APPOINTMENT_ORIGIN)
				.body(body).when().post(URL_HOST_BASE + appointmentApiEndpoint).then().contentType(ContentType.TEXT)
				.extract().response();
	}

	public static Response bookAppointment(String appointmentId, String appointmentRefNumber, String serviceProductID,
			String paymentOrderCode, String customerId, String serviceAccountId) {
		String body = BodyContentForHttp.getReserveAppointmentBodyContent().replace("{{appointment}}", appointmentId)
				.replace("{{addressSearchReferenceNumber}}", appointmentRefNumber)
				.replace("{{ServiceProducts_id}}", serviceProductID).replace("{{paymentOrderID}}", paymentOrderCode).replace("{{customer}}", customerId).replace("{{serviceAccountId}}", serviceAccountId);

		String appointmentApiEndpoint = ENDPOINT_BOOK_APPOINTMENT.replace("{{appointment}}", appointmentId);
		return given()
				.headers("Content-Type", "application/vnd.api+json", "X-Client-ID", X_CLIENT_ID, "Origin",
						URL_APPOINTMENT_ORIGIN)
				.body(body).when().patch(URL_HOST_BASE + appointmentApiEndpoint).then().contentType(ContentType.JSON)
				.extract().response();
	}

}
