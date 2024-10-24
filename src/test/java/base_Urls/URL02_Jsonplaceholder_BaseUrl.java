package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class URL02_Jsonplaceholder_BaseUrl {

    protected RequestSpecification spec;
    @BeforeMethod
    public void setUp(){

        spec = new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri("https://jsonplaceholder.typicode.com").build();


    }
}
