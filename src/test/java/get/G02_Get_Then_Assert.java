package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class G02_Get_Then_Assert {

    @Test
    public void test() {

        /*
 https://restful-booker.herokuapp.com/booking/34
 HTTP Status Code-->200
 Content Type --> "application/json; charset=utf-8"
 Status Line --> "HTTP/1.1 200 OK"
 Server --> "Cowboy"
 Connection -->"keep-alive"
       */

        Response response = given().get(" https://restful-booker.herokuapp.com/booking/34");

        response.prettyPrint();

        response.then().statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server", "Cowboy")
                .header("Connection","keep-alive");
    }
}
