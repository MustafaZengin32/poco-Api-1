package get;

import base_Urls.URL01_GoRest_BaseUrl1;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static base_Urls.URL01_GoRest_BaseUrl1.setupUri;
import static io.restassured.RestAssured.given;
import static org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment.setup;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class G06_BaseUrl02 {

    @Test
    public static void test() {
           /*
https://gorest.co.in/public/v2/users
User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 200
    name contains "Bhadraksh Gupta"
    id should be 5913978, 5913979, 5913980
    gender should be male and female

            */

        RequestSpecification spec=setupUri();

        spec.pathParam("first","users");

        Response response = given(spec).get("{first}");

        response.prettyPrint();

        response.then()
                .contentType("application/json")
                .statusCode(200)
                .body("name",hasItem("Chandramauli Kapoor LLD"),"id",hasItems(7484337, 7484338));





    }
}
