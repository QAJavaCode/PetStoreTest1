package MainAPILogic;

import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.is;

public class BaseClass {
    public static final String BASE_URI = "https://petstore.swagger.io/";

    public static String appJSONContentType = "application/json";
    public static String multiPartContentType = "multipart/form-data";
    public static String urlEncodedContentType = "application/x-www-form-urlencoded";

    public void GETRequest(String basePath, RequestSpecification ReqSpec, String Key, String Value){
        ReqSpec
                .baseUri(BASE_URI)
                .when().get(basePath).then()
                .body(Key, is(Value));
    }
    public void pureGETRequest(String basePath, RequestSpecification ReqSpec){
        ReqSpec
                .baseUri(BASE_URI)
                .when().get(basePath);
    }

    public void POSTRequest(String basePath, RequestSpecification ReqSpec, String Key, String Value){
        ReqSpec
                .baseUri(BASE_URI)
                .when().post(basePath)
                .then().body(Key, is(Value));
    }

    public void purePOSTRequest(String basePath, RequestSpecification ReqSpec){
        ReqSpec
                .baseUri(BASE_URI)
                .when().post(basePath);
    }
    public void PUTRequest(String basePath, RequestSpecification ReqSpec, String Key, String Value){
        ReqSpec
                .baseUri(BASE_URI)
                .when().put(basePath)
                .then().body(Key, is(Value));
    }
    public void purePUTRequest(String basePath, RequestSpecification ReqSpec){
        ReqSpec
                .baseUri(BASE_URI)
                .when().put(basePath);
    }
    public void pureDELETERequest(String basePath, RequestSpecification ReqSpec){
        ReqSpec
                .baseUri(BASE_URI)
                .when().delete(basePath);
    }
}
