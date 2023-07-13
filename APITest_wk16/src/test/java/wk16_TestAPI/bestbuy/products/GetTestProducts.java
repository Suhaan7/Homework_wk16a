package wk16_TestAPI.bestbuy.products;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.testbase.TestBaseBestBuyProducts;

import static io.restassured.RestAssured.given;

public class GetTestProducts extends TestBaseBestBuyProducts {

    static ValidatableResponse response;


    @Test
    public void getAllProducts(){
        response = given()
                .log().all()
                .when()
                .get("/products")
                .then();
                response.statusCode(200);
    }

    @Test
    public void getSingleProductInfo(){
        response = given()
                .log().all()
                .pathParam("id", 43900)
                .when()
                .get("/{id}")
                .then();
               response.statusCode(200);
    }

@Test
    public void getProductWithParameter(){
        response = given()
                .queryParam("manufacturer","Duracell")
                .when()
                .get()
                .then()
                .log().all();
        response.statusCode(200);
}

}
