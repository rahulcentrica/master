package com.test.centrica.api;

import static com.centrica.constants.EndpointConstants.ENDPOINT_ORDER_PAYMENT;
import static com.centrica.constants.EndpointConstants.ENDPOINT_PAYMENT_STATUS;
import static com.centrica.constants.EndpointConstants.URL_APPOINTMENT_ORIGIN;
import static com.centrica.constants.EndpointConstants.URL_HOST_BASE;
import static com.centrica.constants.ServiceConstants.X_CLIENT_ID;
import static io.restassured.RestAssured.given;

import com.centrica.types.ReCapechaTokenType;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PaymentApiCall {

	
	
	public static Response orderPayment(String customerId) {
		String body = BodyContentForHttp.getOrderPaymentBodyContent().replace("{{customer}}", customerId);

		return given()
				.headers("Content-Type", "application/vnd.api+json", "X-Client-ID", X_CLIENT_ID, "Origin",
						URL_APPOINTMENT_ORIGIN, "X-reCAPTCHA-Token", BodyContentForHttp.getReCapechaToken(ReCapechaTokenType.PAYMENT.getType()), "x-skip-reCAPTCHA-check",
						"true")
				.body(body).when().post(URL_HOST_BASE + ENDPOINT_ORDER_PAYMENT).then().contentType(ContentType.JSON)
				.extract().response();
	}
	
	public static Response verifyPaymentStatus(String paymentOrderId, String paymentOrderCode) {
		String paymentStatusApiAddress = ENDPOINT_PAYMENT_STATUS.replace("{{PaymentOrder}}", paymentOrderId);

		String body = BodyContentForHttp.paymentStatusBodyContent().replace("{{PaymentOrderId}}", paymentOrderId);
		body = body.replace("{{customer-payment-order-id}}", paymentOrderCode);

		return given()
				.headers("Content-Type", "application/vnd.api+json", "X-Client-ID", X_CLIENT_ID, "Origin",
						URL_APPOINTMENT_ORIGIN)
				.body(body).when().patch(URL_HOST_BASE + paymentStatusApiAddress).then().contentType(ContentType.JSON)
				.extract().response();
	}

	
}
