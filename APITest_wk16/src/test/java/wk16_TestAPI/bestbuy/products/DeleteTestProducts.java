package wk16_TestAPI.bestbuy.products;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.testbase.TestBaseBestBuyProducts;

import static io.restassured.RestAssured.given;

public class DeleteTestProducts extends TestBaseBestBuyProducts {

   static ValidatableResponse response;

   @Test
    public void deleteProducts(){

       response = given()
               .log().all()
               .header("Content-Type","application/json")
               .pathParam("id",9999682)
               .when()
               .delete("/{id}")
               .then();
       response.statusCode(200);
   }

}
