package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class URL01_GoRest_BaseUrl1 {

    public static RequestSpecification setupUri(){

        RequestSpecification spec=new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri("https://gorest.co.in/public/v2").build();

        return spec;
    }
}
