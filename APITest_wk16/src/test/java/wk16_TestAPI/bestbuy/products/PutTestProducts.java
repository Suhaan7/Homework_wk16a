package wk16_TestAPI.bestbuy.products;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.model.ProductsPojo;
import wk16_TestAPI.testbase.TestBaseBestBuyProducts;

import static io.restassured.RestAssured.given;

public class PutTestProducts extends TestBaseBestBuyProducts {

    static ValidatableResponse response;

    @Test
    public void updateProductsWithPut(){
        ProductsPojo PP = new ProductsPojo();
        PP.setName("HSRS Batteries");
        PP.setType("Excellent");
        PP.setPrice(33333333);
        PP.setShipping(10);
        PP.setUpc("123456478");
        PP.setDescription("10V X-tra Power");
        PP.setManufacturer("HSR Powers");
        PP.setModel("HSHS");
        PP.setUrl("http://www.bestbuy.com/site/duracell-ultra-cr123-battery-black-orange/2451224.p?id=1051384047188&skuId=2451224&cmp=RMXCC");

        response = given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",9999682)
                .body(PP)
                .when()
                .put("/{id}")
                .then();
        response.statusCode(200);
    }
}
