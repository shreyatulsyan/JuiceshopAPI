import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Registration {

    @Test
    public void registration()
    {
        RestAssured.baseURI="http://localhost:3000";
        Gson gson = new Gson();
        System.out.println("result"+gson.toJson(customerDetailsBuilder()));

        given()
                .log().all()
                .body(gson.toJson(customerDetailsBuilder()))
                .header("Content-Type","application/json")
                .when().post("/api/Users")
                .then().log().all().statusCode(201);
    }
    @Test
    public void login()
    {
        RestAssured.baseURI="http://localhost:3000";
       Response res =  given()
                .log().all()
                .body("{\"email\":\"shreya8@gmail.com\",\"password\":\"ShreyaTW@01\"}")
                .header("Content-Type","application/json")
                .when().post("/rest/user/login")
                .then().log().all().statusCode(200).extract().response();
    }

    @Test
    public void addItemToCart()
    {
        RestAssured.baseURI="http://localhost:3000";
        given()
                .log().all()
                .body("{\"quantity\":2}")
                .header("Content-Type","application/json")
                .when().post("/api/BasketItems/6")
                .then().log().all().statusCode(200);
    }

    @Test
    public void updateQuantity()
    {

    }

    private CustomerDetails customerDetailsBuilder()
    {
    return CustomerDetails.builder()
            .email("shreya12@gmail.com")
            .password("ShreyaTW@01")
            .repeatPassword("ShreyaTW@01")
            .secutyQues(
                    SecurityQuestion
                            .builder()
                            .question("Maternal grandmother's first name?")
                            .id(5)
                            .createdAt("2021-12-01T04:53:33.957Z")
                            .updatedAt("2021-12-01T04:53:33.957Z")
                            .build())
            .securityAns("abc")
            .build();
    }
}
