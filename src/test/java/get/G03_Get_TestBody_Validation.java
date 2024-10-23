package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class G03_Get_TestBody_Validation {

    @Test
    public void test() {

        /*
    https://jsonplaceholder.typicode.com/posts/1 send a GET request to the Url
    HTTP Status Code should be 200
    Response format (contentType) should be "application/json"
    "id" should be 1
    "title" should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body" should be "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
*/

        Response response = given().get(" https://jsonplaceholder.typicode.com/posts/1");

        response.prettyPrint();

//        response.then()
//                .statusCode(200)
//                .contentType("application/json")
//                .body("id",equalTo(1))
//                .body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
//                .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));



        //Valid all body
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("id", equalTo(1)
                        ,"title",equalTo( "sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
                        ,"body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));


    }
}
