package com.autohero.api.tests;

import com.autohero.models.Example;
import com.autohero.utilities.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


import static com.autohero.enums.EndPoints.searchTemplate;
import static com.autohero.utilities.Headers.getHeaders;
import static io.restassured.RestAssured.given;

public class BaseTest {
    RequestSpecification spec;
    Example example = null;
    String response = null;
    ConfigFileReader configFileReader = null;
    @BeforeSuite
    public void baseSetUp() throws IOException {

        configFileReader = new ConfigFileReader();
        String baseURL = configFileReader.getBaseURL();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

            spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(baseURL)
                .addHeaders(getHeaders())
                .build();

        ObjectMapper mapper = new ObjectMapper();

        example = mapper.readValue(new File("src/test/resources/meta.json"), Example.class);

    }

    String postRequest()
    {
        return given().relaxedHTTPSValidation()
                .spec(spec)
                .body(example)
                .post(searchTemplate)
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }

}
