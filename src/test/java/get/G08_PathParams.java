package get;

import base_Urls.URL03_Reqres_BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class G08_PathParams extends URL03_Reqres_BaseUrl{

    @Test
    public void test(){
        /*
        Given
            https://reqres.in/api/users/5
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json; charset=utf-8"
        And
            Status Line should be "HTTP/1.1 200 OK"
       And
            email should be "charles.morris@reqres.in",
       And
            text should be "To keep ReqRes free, contributions towards server costs are appreciated!"
     */


        spec.pathParams("first","users","second",5);

        Response response = given(spec).get("{first}/{second}");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .body("data.email",equalTo("charles.morris@reqres.in"),"support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}
