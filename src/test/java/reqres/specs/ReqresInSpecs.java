package reqres.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.JSON;
import static reqres.tests.TestBase.api_key;
import static reqres.tests.TestBase.api_value;

public class ReqresInSpecs {

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .header(api_key, api_value)
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification responseCreateUserSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(ALL)
            .build();

    public static ResponseSpecification responseWithStatusCode200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public static ResponseSpecification responseDeleteUserSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(ALL)
            .build();

    public static ResponseSpecification responseGetUserNotFoundSpec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(ALL)
            .build();

}
