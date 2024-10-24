package get;

import base_Urls.URL02_Jsonplaceholder_BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class G07_Assert_Datum extends URL02_Jsonplaceholder_BaseUrl {

    @Test
    public void test() {
          /*
            https://jsonplaceholder.typicode.com/users
            User sends a GET Request to the url
            HTTP Status Code should be 200
            Content Type should be "application/json"
            Status Line should be HTTP/1.1 200 OK
            name should be "Leanne Graham"
            email should be "Sincere@april.biz"
            city should be "Gwenborough"
            company names should be "Romaguera-Crona", "Deckow-Crist"
     */

    spec.pathParam("first","users");

        Response response = given(spec).get("{first}");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK")
                .body("name",hasItem("Leanne Graham"),"email",hasItem("Sincere@april.biz")
                        ,"address.city",hasItem("Gwenborough"));




    }
}
