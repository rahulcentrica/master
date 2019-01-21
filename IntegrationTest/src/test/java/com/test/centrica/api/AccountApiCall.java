package com.test.centrica.api;

import static com.centrica.constants.EndpointConstants.ENDPOINT_SERVICE_ONE_OF_ACCOUNT;
import static com.centrica.constants.EndpointConstants.URL_HOST_BASE;
import static com.centrica.constants.ServiceConstants.X_CLIENT_ID;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccountApiCall {

	
	
	public static Response serviceOneOfAccounts(String addressIdOne) {
		String body = BodyContentForHttp.getServiceOneOfAccountBodyContent().replace("{{addressIdOne}}", addressIdOne);

		return given().headers("Content-Type", "application/vnd.api+json", "X-Client-ID", X_CLIENT_ID).body(body).when()
				.post(URL_HOST_BASE + ENDPOINT_SERVICE_ONE_OF_ACCOUNT).then().contentType(ContentType.JSON).extract()
				.response();
	}
	
	
}
