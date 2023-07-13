package wk16_TestAPI.bestbuy.categories;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.testbase.TestBaseBestBuyCategories;

import static io.restassured.RestAssured.given;

public class GetTestCategories extends TestBaseBestBuyCategories {

    static ValidatableResponse response;


    @Test
    public void getAllCategories(){
        response = given()
                .log().all()
                .when()
                .get()
                .then();
                response.statusCode(200);
    }

    @Test
    public void getSingleCategoriesInfo(){
        response = given()
                .log().all()
                .pathParam("id", "abcat0020004")
                .when()
                .get("/{id}")
                .then();
               response.statusCode(200);
    }

}
