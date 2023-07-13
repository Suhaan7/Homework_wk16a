package wk16_TestAPI.bestbuy.products;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import wk16_TestAPI.model.ProductsPojo;

import static io.restassured.RestAssured.given;

public class CRUDTestProducts {

    static int productID;
    static ValidatableResponse response;

    @BeforeClass
    public static void inIT (){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
    }

    @Test
    public void getAllProducts(){
        response = given()
                .log().all()
                .when()
                .get()
                .then();
        response.statusCode(200);
       }

       @Test
    public void createProducts(){
           ProductsPojo PP = new ProductsPojo();
           PP.setName("Audi Cars AC");
           PP.setType("Excellent-SuperHit");
           PP.setPrice(50000);
           PP.setShipping(00);
           PP.setUpc("12345");
           PP.setDescription("Audi Cars, Series Q");
           PP.setManufacturer("Audi Pvt Ltd.");
           PP.setModel("Q7");
           PP.setUrl("http://www.bestbuy.com/site/duracell-ultra-cr123-battery-black-orange/2451224.p?id=1051384047188&skuId=2451224&cmp=RMXCC");

           Response response = (Response) given()
             .log().all()
             .header("Content-Type","application/json")
             .body(PP)
             .when()
             .post();
           response.then().statusCode(201);
           productID=response.then().extract().path("id");
           System.out.println(productID);
       }

    @Test
    public void updateProducts(){
        ProductsPojo PP = new ProductsPojo();
        PP.setManufacturer("Merc");
        Response response = given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id","9999691")
                .when()
                .body(PP)
                .patch("/{id}");
        response.then().statusCode(200);
    }

    @Test
    public void deleteStores(){
        Response response = given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id","9999691")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
    }
}


