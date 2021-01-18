package PetStoreAPITests.PetsInfoTests.UpdatingPetsInfo.Steps;

import MainAPILogic.BaseClass;
import MainAPILogic.RequestSpecifications;
import MainAPILogic.Vars;
import PetStoreAPITests.PetsInfoTests.SearchingForPets.Steps.SearchingForPetStepDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;

import static MainAPILogic.BaseClass.appJSONContentType;
import static MainAPILogic.BaseClass.urlEncodedContentType;
import static MainAPILogic.Vars.*;

public class UpdatingPetInfoStepDefinitions {
    BaseClass bc = new BaseClass();
    RequestSpecifications rSpecs = new RequestSpecifications();
    Vars vars = new Vars();
    SearchingForPetStepDefinitions searchSteps = new SearchingForPetStepDefinitions();

    @Before
    public void setUp(){
        bc.POSTRequest("v2/pet", rSpecs.requestBodySpec(addPetBody, appJSONContentType), "name", originalPetName);
    }

    @Step
    @Given("^I want to add new pet photos$")
    @When("^I add pet photo by sending its unique ID, photos and additional data$")
    @Then("^Pet photo should be successfully updated$")
    public void uploading_Pet_Photos(){
        bc.purePOSTRequest("v2/pet/" + petID + "/uploadImage", rSpecs.requestFormAndMultiPDataSpec(vars.initAddPhotosFormParams(ParamsList, metaData), petPhotoForUpdate,
                "image/jpeg"));
    }

    @Step
    @Given("^I want to add new incorrect pet photo$")
    @When("^I try to add pet photo by sending incorrect files$")
    @Then("^Pet photo shouldn't be successfully updated$")
    //Bug, there is no any server data validation
    public void incorrectly_adding_New_Pet_to_the_Store() {
        bc.purePOSTRequest("v2/pet/" + incorrectPetID + "/uploadImage", rSpecs.requestFormAndMultiPDataSpec(vars.initAddPhotosFormParams(ParamsList, emptyMetadata),
                textFile, "image/jpeg"));
    }

    @Step
    @Given("^I send new info$")
    @When("^It should be correctly applied$")
    @Then("^Pets information should correspond to the latest updates$")
    public void updating_Pet_Info(){
        bc.PUTRequest("v2/pet", rSpecs.requestBodySpec(updatingPetInfoBody, appJSONContentType), "name", updatedPetName);
    }

    @Step
    @Given("^I send new incorrect info$")
    @When("^It shouldn't be correctly applied$")
    @Then("^Pets information should remain the same$")
    public void incorrect_Updating_Pet_Info(){
        bc.PUTRequest("v2/pet", rSpecs.requestBodySpec("", appJSONContentType), "name", updatedPetName);
    }

    @Step
    @Given("^I should update pet store info with correct data$")
    @When("^I send request containing proper data$")
    @Then("^I can update pet store info$")
    public void updating_Pet_Store_Form_Info(){
        bc.purePOSTRequest("v2/pet/" + petID, rSpecs.requestFormDataSpec(vars.initUpdPetStoreInfoFormParams(ParamsList, updatedPetName, petStatuses[0]),
                urlEncodedContentType));
    }

    @Step
    @Given("^I should update pet store info with incorrect data$")
    @When("^I send request containing invalid data$")
    @Then("^I can't update pet store info$")
    public void updating_Pet_Store_Incorrect_Form_Info(){
        bc.POSTRequest("v2/pet/" + incorrectPetID, rSpecs.requestFormDataSpec(vars.initUpdPetStoreInfoFormParams(ParamsList, updatedPetName, petStatuses[0]), urlEncodedContentType),
                "status", petStatuses[0]);
    }

    @Step
    @Given("^I want to delete the pet$")
    @When("^I send request with proper data to delete the pet from store$")
    public void deleting_The_Pet(){
        bc.pureDELETERequest("v2/pet/" + petID, rSpecs.simpleSpec(urlEncodedContentType));
    }

    @Step
    @Then("^Pet should be deleted and couldn't be searched by its ID$")
    public void deletion_verification(){
        searchSteps.searching_for_Pets_By_ID();
    }
}
