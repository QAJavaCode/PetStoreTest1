package PetStoreAPITests.PetsInfoTests.SearchingForPets.Steps;

import MainAPILogic.BaseClass;
import MainAPILogic.RequestSpecifications;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;

import static MainAPILogic.BaseClass.appJSONContentType;
import static MainAPILogic.Vars.*;

public class SearchingForPetStepDefinitions {
    BaseClass bc = new BaseClass();
    RequestSpecifications rSpecs = new RequestSpecifications();

    @Before
    public void setUp(){
        bc.POSTRequest("v2/pet", rSpecs.requestBodySpec(addPetBody, appJSONContentType), "name", originalPetName);
    }

    @Step
    @Given("^I start searching pets by status$")
    @When("^I enter correct statuses$")
    @Then("^Pet I found have proper status$")
    public void searching_for_Pets_By_Statuses(){
        for (String petStatus : petStatuses) {
            bc.pureGETRequest("v2/pet/findByStatus?status=" + petStatus, rSpecs.simpleSpec(appJSONContentType));
        }
    }

    @Step
    @Given("^I start searching pets by incorrect status$")
    @When("^I enter incorrect statuses$")
    @Then("^Server should respond with an error$")
    public void searching_for_Pets_By_Incorrect_Statuses(){
        for (int i = 0; i < incorrectPetStatuses.length; i++) {
            bc.GETRequest("v2/pet/findByStatus?status=" + incorrectPetStatuses[i], rSpecs.simpleSpec(appJSONContentType), "status", incorrectPetStatuses[i]);
        }
    }

    @Step
    @Given("^I start searching pets by correct IDs$")
    @When("^I enter correct ID and send request$")
    @Then("^Proper pet should be found$")
    public void searching_for_Pets_By_ID(){
                bc.GETRequest("v2/pet/" + petID, rSpecs.simpleSpec(appJSONContentType), "status", petStatuses[0]);
            }

    @Step
    @Given("^I start searching pets by incorrect IDs$")
    @When("^I enter incorrect ID and send request$")
    @Then("^Pet shouldn't be found$")
    public void searching_for_Pets_By_Incorrect_ID(){
        for (int i=0; i <petStatuses.length; i++) {
            bc.GETRequest("v2/pet/" + incorrectPetID, rSpecs.simpleSpec(appJSONContentType), "status", petStatuses[0]);
        }
    }
}