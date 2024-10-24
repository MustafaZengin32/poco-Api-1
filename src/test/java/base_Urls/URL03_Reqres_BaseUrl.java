package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class URL03_Reqres_BaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec= new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("https://reqres.in/api").build();
    }

}
