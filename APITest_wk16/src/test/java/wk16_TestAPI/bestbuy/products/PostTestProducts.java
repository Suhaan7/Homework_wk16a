package wk16_TestAPI.bestbuy.products;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.model.ProductsPojo;
import wk16_TestAPI.testbase.TestBaseBestBuyProducts;

import static io.restassured.RestAssured.given;

public class PostTestProducts extends TestBaseBestBuyProducts {

    static ValidatableResponse response;

    @Test
    public void createProducts() {
        ProductsPojo PP = new ProductsPojo();
        PP.setName("RudraShiv Batteries");
        PP.setType("VeryGood");
        PP.setPrice(312);
        PP.setShipping(7);
        PP.setUpc("12345");
        PP.setDescription("5V High Power, Long-Life");
        PP.setManufacturer("HS Powers");
        PP.setModel("HS197");
        PP.setUrl("http://www.bestbuy.com/site/duracell-ultra-cr123-battery-black-orange/2451224.p?id=1051384047188&skuId=2451224&cmp=RMXCC");

        response = given()
                .log().all()
                .header("Content-Type","application/json")
                .body(PP)
                .when()
                .post()
                .then();
        response.statusCode(201);


    }


}
