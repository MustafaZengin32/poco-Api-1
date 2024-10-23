package get;

import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class G05_Get_StringDataAssert {

    @Test
    public void test1() {

          /*
    https://jsonplaceholder.typicode.com/todos/gfhrr756
    User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 404
    todos should be empty
     */

        Response response = given().get("https://jsonplaceholder.typicode.com/todos/gfhrr756");

        response.prettyPrint();

        response.then()
                .contentType("application/json")
                .statusCode(404);

        Assert.assertTrue(response.asString().contains(""));

    }

    @Test
    public void test2() {

         /*
    https://restful-booker.herokuapp.com/booking/123437
    User send GET Request to the URL
    Response format should be “text/plain”
    HTTP Status Code should be 404
    HTTP Status Line should be "HTTP/1.1 404 Not Found"
    todos should be "Not Found"
     */

        Response response = given().get("https://restful-booker.herokuapp.com/booking/123437");

        response.prettyPrint();

        response.then()
                .contentType("text/plain")
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found");

        //response.asString().contains("Not Found");

        Assert.assertEquals("Not Found", response.asString());

    }
}
