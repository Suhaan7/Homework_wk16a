package wk16_TestAPI.bestbuy.stores;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import wk16_TestAPI.model.StoresPojo;

import static io.restassured.RestAssured.given;

public class CRUDTestStores {

    static int storeID;
    static ValidatableResponse response;

    @BeforeClass
    public static void inIT() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
    }

    @Test
    public void getAllStores() {
        response = given()
                .log().all()
                .when()
                .get()
                .then();
        response.statusCode(200);
    }

    @Test
    public void createStores() {
        StoresPojo SP = new StoresPojo();
        SP.setName("Baskin Robins");
        SP.setType("Ice Cream Store");
        SP.setAddress("150D Green Street");
        SP.setAddress2("Harrow");
        SP.setCity("London");
        SP.setState("England");
        SP.setZip("HA2 3SQ");
        SP.setLat(88.8888);
        SP.setLng(26.5478);

        Response response = (Response) given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(SP)
                .when()
                .post();
        response.then().statusCode(201);
        storeID=response.then().extract().path("id");
        System.out.println(storeID);
        }

        @Test
        public void updateStores(){
            StoresPojo SP = new StoresPojo();

            SP.setAddress("173 Golden Road");
            Response response = given()
                    .log().all()
                    .header("Content-Type","application/json")
                    .pathParam("id","8924")
                    .when()
                    .body(SP)
                    .patch("/{id}");
            response.then().statusCode(200);
}

@Test
    public void deleteStores(){
    Response response = given()
            .log().all()
            .header("Content-Type","application/json")
            .pathParam("id","8924")
            .when()
            .delete("/{id}");
    response.then().statusCode(200);
    }
}