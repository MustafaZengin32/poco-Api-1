package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class G04_Get_HarmMatcher_List_Test {

    @Test
    public void test() {

          /*
    https://jsonplaceholder.typicode.com/todos
    User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 200
    todos should be 200
    “userId” is 10
    "id": 189, 156, 57
    “title” is “quis eius est sint explicabo”,
    “completed” contains false
    “id” contains 1 and 200
   */

        Response response = given().get(" https://jsonplaceholder.typicode.com/todos");

        response.prettyPrint();

        response.then()
                .contentType("application/json")
                .statusCode(200)
                .body("id",hasSize(200)
                             ,"userId",hasItem(10)
                             ,"id",hasItems(189, 156, 57)
                             ,"title",hasItem("quis eius est sint explicabo")
                             ,"completed",hasItem(false)
                             ,"id",hasItems(1,200));




    }
}
