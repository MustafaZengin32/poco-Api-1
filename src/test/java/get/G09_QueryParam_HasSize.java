package get;

import base_Urls.URL05_PetStore;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class G09_QueryParam_HasSize extends URL05_PetStore {

    @Test
    public void test() {

        /*
 "available" -->"pet" more than 100

      */

        spec.pathParams("a", "pet", "b", "findByStatus")
                .queryParam("status", "available");

        Response response= given(spec).get("{a}/{b}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());

        response.then()
                .statusCode(200)
                .body("id", hasSize(greaterThan(100)));

        /*
        int availablePet= response.jsonPath().getList("id").size();
        System.out.println("availablePet = " + availablePet);
        assertTrue(availablePet>100);
         */












    }
}
