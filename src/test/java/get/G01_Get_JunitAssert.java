package get;

import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class G01_Get_JunitAssert {

    @Test
    public void test(){

         /*
        https://petstore.swagger.io/v2/pet/2
        StatusCode 200
        Content-Type application/json
        statusLine HTTP/1.1 200 OK
        Connection keep-alive
        Time less than 3 sn-->3000 ms
         */

        //1- End point creation

        String endpoint="https://petstore.swagger.io/v2/pet/1";

        //2- GET request creation

        //given().get(endpoint); //Restassuered import //given()-->like driver

        //3- Response creation

        Response response=given().get(endpoint);

        //4- Response print

        response.prettyPrint();

        //5-StatusCode 200 validation

        int expectedStatusCode= 200;
        int actualStatusCode=response.statusCode();

        Assert.assertEquals(expectedStatusCode,actualStatusCode);

        //6- Content-Type'ın application/json validation

        String expectedContentType = "application/json";

        String actualContentType = response.contentType();

        Assert.assertTrue(actualContentType.equals(expectedContentType));

        //7- statusLine'ın HTTP/1.1 200 OK

        String expectedStatusLine="OK";

        String actualStatusLine = response.statusLine();

        Assert.assertTrue(actualStatusLine.contains(expectedStatusLine));

        //8- Connection --> keep-alive

        String expectedConnection="keep-alive";

        String actualConnection = response.header("Connection");

        Assert.assertEquals(expectedConnection, actualConnection);

        //9-Time less than 500

        long expectedTime = 3000;
        long actualTime = response.time();

        System.out.println("actualTime = " + actualTime);

        Assert.assertTrue(actualTime<=expectedTime);




    }

}
