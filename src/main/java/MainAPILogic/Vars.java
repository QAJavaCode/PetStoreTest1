package MainAPILogic;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Vars {

    public static String creatingUser = "{\n" +
            "  \"id\": 0,\n" +
            "  \"username\": \"QR\",\n" +
            "  \"firstName\": \"AF\",\n" +
            "  \"lastName\": \"AB\",\n" +
            "  \"email\": \"a@asf.com\",\n" +
            "  \"password\": \"AF2\",\n" +
            "  \"phone\": \"123\",\n" +
            "  \"userStatus\": 0\n" +
            "}";
    public static String creatingUser2 = "{\n" +
            "  \"id\": 2,\n" +
            "  \"username\": \"QRA\",\n" +
            "  \"firstName\": \"AFA\",\n" +
            "  \"lastName\": \"AB\",\n" +
            "  \"email\": \"a@asf.com\",\n" +
            "  \"password\": \"AF2A\",\n" +
            "  \"phone\": \"123234\",\n" +
            "  \"userStatus\": 0\n" +
            "}";
    public static String creatingUser3 = "{\n" +
            "  \"id\": 3,\n" +
            "  \"username\": \"QRAA\",\n" +
            "  \"firstName\": \"AFAA\",\n" +
            "  \"lastName\": \"ABA\",\n" +
            "  \"email\": \"a@asfa.com\",\n" +
            "  \"password\": \"AF2AA\",\n" +
            "  \"phone\": \"123234234\",\n" +
            "  \"userStatus\": 0\n" +
            "}";
    public static String userUpdate = "{\n" +
            "  \"id\": 13,\n" +
            "  \"username\": \"String1\",\n" +
            "  \"firstName\": \"String2\",\n" +
            "  \"lastName\": \"string\",\n" +
            "  \"email\": \"string\",\n" +
            "  \"password\": \"string\",\n" +
            "  \"phone\": \"123123213\",\n" +
            "  \"userStatus\": 13\n" +
            "}";
    public static String creatingIncorrectUser = "{\n" +
            "  \"id\": -1,\n" +
            "  \"username\": \"\",\n" +
            "  \"firstName\": \"\",\n" +
            "  \"lastName\": \"\",\n" +
            "  \"email\": \"a@asf.com\",\n" +
            "  \"password\": \"\",\n" +
            "  \"phone\": \"ASDASDF\",\n" +
            "  \"userStatus\": !@E@Q\n" +
            "}";
    public static String addPetBody = "{\n" +
            "  \"id\": 7,\n" +
            "  \"category\": {\n" +
            "    \"id\": 7,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"GreatDog1\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
    public static String updatingPetInfoBody = "{\n" +
            "  \"id\": 13,\n" +
            "  \"category\": {\n" +
            "    \"id\": 13,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"MyBestOne1\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
    public static String placingOrderBody = "{\n" +
            "  \"id\": 7,\n" +
            "  \"petId\": 7,\n" +
            "  \"quantity\": 1,\n" +
            "  \"shipDate\": \"2021-01-17T21:47:30.594Z\",\n" +
            "  \"status\": \"placed\",\n" +
            "  \"complete\": true\n" +
            "}";
    public static String placingIncorrectOrderBody = "{\n" +
            "  \"id\": dmb,\n" +
            "  \"petId\": 1sssqwr,\n" +
            "  \"quantity\": -1,\n" +
            "  \"shipDate\": \"2015-01-17T21:47:30.594Z\",\n" +
            "  \"status\": \"placed\",\n" +
            "  \"complete\": true\n" +
            "}";

    public static String orderID = "7";
    public static String tooBigOrderID = "213";
    public static String negativeOrderID = "-213";

    public static String placedOrderStatus = "placed";
    public static String approvedOrderStatus = "approved";

    public static String[] petStatuses = {"available", "pending", "sold"};
    public static String[] incorrectPetStatuses = {"12", "WEFJO@#", "A)SVCI"};

    public static String originalPetName = "GreatDog1";
    public static String updatedPetName = "MyBestOne1";

    public static String userName = "QR";
    public static String userFirstName = "AF";
    public static String userPassword = "AF2";

    public static String petID = "7";
    public static String incorrectPetID = "-a13";
    public static String metaData = "NewPhoto";
    public static String emptyMetadata = "";

    public static Map<String, String> ParamsList = new HashMap<>();

    public static File petPhotoForUpdate = new File("src\\main\\resources\\PetPhotos\\UpdatedDogPhoto.jpg");
    public static File textFile = new File("src\\main\\resources\\textFiles\\Pet.txt");

    public Map<String, String> initAddPhotosFormParams(Map<String, String> ParamsList, String Metadata){
        ParamsList.put("additionalMetadata", Metadata);
        return ParamsList;
    }

    public Map<String, String> initUpdPetStoreInfoFormParams(Map<String, String> ParamsList, String name, String status){
        ParamsList.put("name", name);
        ParamsList.put("status", status);
        return ParamsList;
    }
}
