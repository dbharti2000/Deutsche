package com.db.am.bauhaus.project;


import java.util.HashMap;
import java.util.Map;

import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.mockito.internal.matchers.Contains;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class RestClient {

    private static String requestURL = "https://www.etsy.com";
    public static Map<String, String> requestHeaders = new HashMap<String, String>();
    public static Response response;
    private static String responseString = "";


    public static void setRequestURL(String url) {
        requestURL = url;
    }

    public static void performGetRequest() {
        setContentType("text/html");
        response = SerenityRest.given().log().all().headers(requestHeaders).get(requestURL);
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

    public static void performSearch(String searchKeyword){
        requestURL = requestURL + "/uk/search?q=";
        setRequestURL(requestURL + searchKeyword);
        performGetRequest();
    }

    public static void verifySearchResults(String searchResultItem){
        assertTrue("Expected Search Result Item: " + searchResultItem + " Does Not Exist in Actual Search Results", responseString.contains(searchResultItem));
    }

}

