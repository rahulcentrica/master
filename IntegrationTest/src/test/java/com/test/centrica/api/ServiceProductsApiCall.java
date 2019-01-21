package com.test.centrica.api;

import static com.centrica.constants.EndpointConstants.ENDPOINT_SERVICE_PRODUCT;
import static com.centrica.constants.EndpointConstants.URL_HOST_BASE;
import static com.centrica.constants.ServiceConstants.X_CLIENT_ID;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServiceProductsApiCall {

	
	
	public static Response reteriveServiceProducts() {
	return	given().headers("Content-Type", "application/vnd.api+json", "X-Client-ID", X_CLIENT_ID).when()
				.get(URL_HOST_BASE + ENDPOINT_SERVICE_PRODUCT).then().contentType(ContentType.JSON).extract()
				.response();
	}
	
}
