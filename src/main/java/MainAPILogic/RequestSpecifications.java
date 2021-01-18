package MainAPILogic;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;
import java.util.Map;

public class RequestSpecifications extends BaseClass{
    public RequestSpecification requestFormDataSpec(Map<String, String> formParams, String contentType){
        RequestSpecification ReqSpec = SerenityRest.expect().statusCode(200).given().formParams(formParams).contentType(contentType);
        return ReqSpec;
    }

    public RequestSpecification simpleSpec(String contentType){
        RequestSpecification ReqSpec = SerenityRest.expect().statusCode(200).given().contentType(contentType);
        return ReqSpec;
    }

    public RequestSpecification requestFormAndMultiPDataSpec(Map<String, String> formParams, File petFile, String fileType){
        RequestSpecification ReqSpec = SerenityRest.expect().statusCode(200).given().formParams(formParams).multiPart("file", petFile, fileType).contentType(multiPartContentType).accept(appJSONContentType);
        return ReqSpec;
    }

    public RequestSpecification requestBodySpec(String body, String ContentType){
        RequestSpecification ReqSpec = SerenityRest.expect().statusCode(200).given().body(body).contentType(ContentType);
        return ReqSpec;
    }
}