package wk16_TestAPI.bestbuy.products;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.model.ProductsPojo;
import wk16_TestAPI.testbase.TestBaseBestBuyProducts;

import static io.restassured.RestAssured.given;

public class PatchTestProducts extends TestBaseBestBuyProducts {

    static ValidatableResponse response;

    @Test
    public void updateProductsWithPatch(){
        ProductsPojo PP = new ProductsPojo();
        PP.setName("RudShi Batts");
        PP.setPrice(444555666);
        PP.setType("ExtremelyGood");

        response = given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",9999682)
                .body(PP)
                .when()
                .patch("/{id}")
                .then();
        response.statusCode(200);
    }
}
