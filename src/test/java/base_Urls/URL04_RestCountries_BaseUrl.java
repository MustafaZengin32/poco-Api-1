package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class URL04_RestCountries_BaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {

        spec=new  RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://restcountries.com/v3.1").build();



    }
}
