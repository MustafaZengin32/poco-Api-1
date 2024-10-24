package get;

import base_Urls.URL04_RestCountries_BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class G08_PathParams02 extends URL04_RestCountries_BaseUrl {

    @Test
    public void test() {
         /*
            Given
                s
            When
                User sends a GET Request to the url
            Then
                HTTP Status Code should be 200
            And
                Content Type should be "application/json"
           And
                official name should be "Republic of Turkey",
           And
                capital should be "Ankara"
           And
                region should be "Asia"
           And
                continents should be "Europe", "Asia"
         */

        //https://restcountries.com/v3.1/lang/turkish

        spec.pathParams("first","lang","second","turkish");

        Response response = given(spec).get("{first}/{second}");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("name.common",hasItem("Cyprus"));

    }
}
