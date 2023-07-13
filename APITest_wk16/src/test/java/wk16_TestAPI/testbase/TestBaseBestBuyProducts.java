package wk16_TestAPI.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBaseBestBuyProducts {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath ="/products";

    }
}
