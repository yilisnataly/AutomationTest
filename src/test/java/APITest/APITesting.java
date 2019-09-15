package APITest;

import io.restassured.http.ContentType;
import org.junit.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITesting {

    @Test
    public void validateResponse__checkStatusCode(){

        given().
                when().
                get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void validateResponse_checkContentType_expectApplicationJson(){

        given().
                when().
                get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker").
                then().
                assertThat().
                contentType(ContentType.JSON);
    }

    @Test
    public void validateResponse_logRequestAndResponseDetails(){
        given().
                when().
                get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker").
                then().
                log().body();

    }

    @Test
    public void validateResponse_check_Login_expectContainsmetrolab(){
        given().
                when().
                get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker?login=metrolab").
                then().
                assertThat().
                body("owner.'login'", equalTo("metrolab"));

    }
}
