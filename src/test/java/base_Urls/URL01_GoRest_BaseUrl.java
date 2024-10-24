package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class URL01_GoRest_BaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void testName() {

        spec=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://gorest.co.in/public/v2").build();


    }
}
