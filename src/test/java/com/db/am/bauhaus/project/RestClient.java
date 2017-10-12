package com.db.am.bauhaus.project;


import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class RestClient {

    private static String URL = "https://www.etsy.com";
    public static Map<String, String> requestHeaders = new HashMap<String, String>();
    public static Response response;
    private static String responseString = "";


    public static void performGetRequest() {
        setContentType("application/json");
        response = SerenityRest.given().log().all().headers(requestHeaders).get(URL);

        responseString = response.asString();
    }

    public static void assertStatusCode(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    public static void setRequestHeader(String key, String value) {
        requestHeaders.put(key, value);
    }

    public static void setContentType(String contentType) {
        requestHeaders.put("Accept", contentType);
        requestHeaders.put("Content-Type", contentType);

    }

}

