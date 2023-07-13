package wk16_TestAPI.bestbuy.stores;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class AssertionTestStores {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";

        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    //    Verify if the total is equal to 1561
    @Test
    public void verifyTotal() {
        response.body("total", equalTo(1561));
    }

    //    Verify if the stores of limit is equal to 10
    @Test
    public void storesLimit() {
        response.body("limit", equalTo(10));
    }

    //            Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void name() {
        given()
                .when()
                .get("/6")
                .then()
                .body("name", equalTo("Inver Grove Heights"));
    }

//    Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void multipleNames(){
        response.extract().path("data.name", String.valueOf(hasItems("Roseville", "Burnsville", "Maplewood")));
    }

//    Verify the storeid=7 inside storeservices of the third store of second services
    @Test
    public void storeServices(){
        response.extract().path("x.data[2].services[3].storeservices.storeId", String.valueOf(equalTo(7)));
    }

//    Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void createdAt(){

        HashMap <String, Object> stores = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path("data[2].services[7].storeservices");
        String services = (String)stores.get("createdAt");
        System.out.println(services);
        }
//Verify the state = MN of forth store
    @Test
    public void state(){
        response.extract().path("data[4].state",String.valueOf(equalTo("MN")));
    }

//Verify the store name = Rochester of 9th store

    @Test
    public void storeName(){
        response.extract().path("data[8].name",String.valueOf(equalTo("Rochester")));
    }

//    Verify the storeId = 11 for the 6th store
    @Test
    public void storeID(){
        response.extract().path("data[5].id", String.valueOf(equalTo("11")));
    }

//    Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void serviceID(){
        response.extract().path("data[6].services[3].id",String.valueOf(equalTo("4")));
    }
        }

