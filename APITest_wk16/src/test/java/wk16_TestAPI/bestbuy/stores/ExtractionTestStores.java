package wk16_TestAPI.bestbuy.stores;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionTestStores {

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

    // 1. Extract the limit
    @Test
    public void limit() {
        int limit = response.extract()
                .path("limit");
        System.out.println(limit);
    }

// 2. Extract the total

    @Test
    public void total() {
        int total = response.extract()
                .path("total");
        System.out.println(total);
    }

    // 3.   Extract the name of 5th store
    @Test
    public void name() {
        String name = response.extract()
                .path("data[4].name");
        System.out.println(name);
    }

    // 4.   Extract the names of all the store
    @Test
    public void names() {
        List<String> listOfNames = response.extract()
                .path("data.name");
        System.out.println(listOfNames);
    }

    //  5.  Extract the storeId of all the store
    @Test
    public void storeIDs() {
        List<Integer> storeIDs = response.extract().path("data.services.storeservices.storeId");
        System.out.println(storeIDs);
    }

    // 6. Print the size of the data list
    @Test
    public void size() {
        List<Integer> sizeOfData = response.extract().path("data");
        System.out.println(sizeOfData.size());
    }

    //   7.  Get all the value of the store where store name = St Cloud
    @Test
    public void valueStCloud() {
        List<Object> valueOfStore = response.extract().path("data.find{it.name =='St Cloud'}.value");
        System.out.println(valueOfStore);
    }

    // 8. Get the address of the store where store name = Rochester
    @Test
    public void address() {

        String addressOfStore = response.extract().path("data.find{it.name=='Rochester'}.address");
        System.out.println(addressOfStore);
    }

    //9. Get all the services of 8th store
    @Test
    public void services() {
        List<Object> listOfServices = response.extract().path("data[7].services");
        System.out.println(listOfServices);
    }

    //    10. Get storeservices of the store where service name = Windows Store
    @Test
    public void storeservices() {
        HashMap<String, String> storeServices = response.extract().path("data[0].services[5].storeservices");
        System.out.println(storeServices);
    }

    //   11. Get all the storeId of all the store
    @Test
    public void allStoreIDs() {
        List<Integer> allStoreIDs = response.extract().path("data.services.storeservices.storeId");
        System.out.println(allStoreIDs);
    }

    //   12.   Get id of all the store
    @Test
    public void id() {
        List<Integer> listOfIDs = response.extract().path("data.id");
        System.out.println(listOfIDs);
    }

    //13. Find the store names Where state = ND
    @Test
    public void stateND() {
        String storeName = response.extract().path("data.find{it.state=='ND'}.name");
        System.out.println(storeName);
    }

    //    14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void totalServices() {
        List<Object> services = response.extract().path("data.find{it.name == 'Rochester'}.services");
        System.out.println(services);
    }

    //    15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void createdAt() {
        List<Integer> allcreated = response.extract().path("data.services.flatten().findAll{it.name=='Windows Store'}.createdAt");
        System.out.println(allcreated);
    }

    //    16. Find the name of all services Where store name = “Fargo”
    @Test
    public void nameOfServices() {
        List<String> nameOfServices = response.extract().path("data.findAll{it.name == 'Fargo'}.services");
        System.out.println(nameOfServices);
    }


    //    17. Find the zip of all the store
    @Test
    public void zip() {
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println(zip);
    }


    //18. Find the zip of store name = Roseville
    @Test
    public void zipRoseville() {
        Object zip = response.extract().path("data.find{it.name == 'Roseville'}.zip");
        System.out.println(zip);

    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void storeServicesMagnolia() {
        List<String> allstoreServices = response.extract().path("data.services.flatten().findAll{it.name=='Magnolia Home Theater'}.storeservices");
        System.out.println(allstoreServices);
    }

    //20. Find the lat of all the stores
    @Test
    public void latitude() {
        List<Integer> latitude = response.extract().path("data.lat");
        System.out.println(latitude);
    }
}





