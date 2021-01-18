package PetStoreAPITests.PetsInfoTests.AddingNewOne.Steps;

import MainAPILogic.BaseClass;
import MainAPILogic.RequestSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;

import static MainAPILogic.BaseClass.appJSONContentType;
import static MainAPILogic.Vars.*;

public class AddingThePetStepDefinitions{
    BaseClass bc = new BaseClass();
    RequestSpecifications rSpecs = new RequestSpecifications();

    @Step
    @Given("^I want to add new pet by sending relevant info$")
    @When("^I add pet by sending its unique ID, name, photos and status in request body$")
    @Then("^Pet should be successfully added to the pet store$")
    public void adding_New_Pet_to_the_Store(){
        bc.POSTRequest("v2/pet", rSpecs.requestBodySpec(addPetBody, appJSONContentType), "name", originalPetName);
    }

    @Step
    @Given("^I want to add new pet by sending irrelevant info$")
    @When("^I add pet by sending its wrong ID, name, photos and status in request body$")
    @Then("^Pet shouldn't be successfully added to the pet store$")
    public void incorrectly_adding_New_Pet_to_the_Store() {
        bc.POSTRequest("v2/pet", rSpecs.requestBodySpec("", appJSONContentType), "name", originalPetName);
    }
}
