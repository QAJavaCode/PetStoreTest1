package PetStoreAPITests.UserFunctionality.Steps;

import MainAPILogic.BaseClass;
import MainAPILogic.RequestSpecifications;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;

import static MainAPILogic.BaseClass.appJSONContentType;
import static MainAPILogic.Vars.*;

public class UserInfoStepDefinitions {
    BaseClass bc = new BaseClass();
    RequestSpecifications rSpecs = new RequestSpecifications();

    @Before
    public void setUp(){
        bc.POSTRequest("v2/pet", rSpecs.requestBodySpec(addPetBody, appJSONContentType), "name", originalPetName);
    }

    @Step
    @Given("^I enter proper data$")
    @When("^I send new POST request$")
    @Then("^I should have new user created$")
    public void creating_Correct_User() {
        bc.purePOSTRequest("v2/user", rSpecs.requestBodySpec(creatingUser, appJSONContentType));
    }

    @Step
    @Given("^I enter incorrect data$")
    @When("^I send a request$")
    @Then("^The user shouldn't be created$")
    public void creating_Incorrect_User() {
        bc.purePOSTRequest("v2/user", rSpecs.requestBodySpec(creatingIncorrectUser, appJSONContentType));
    }

    @Step
    @When("^I try to send new info$")
    @Then("^It should change user info$")
    public void updating_User() {
        bc.purePUTRequest("v2/user" + userName, rSpecs.requestBodySpec(userUpdate, appJSONContentType));
    }

    @Step
    @When("^I try to find user by username$")
    @Then("^I should get user info$")
    public void getting_User_Details_By_Username() {
        bc.GETRequest("v2/user" + userName, rSpecs.simpleSpec(appJSONContentType), "firstName", userFirstName);
    }

    @Step
    @When("^I try to create lists with array/list$")
    @Then("^Users should be created$")
    public void create_Users_By_Array_List() {
        bc.POSTRequest("v2/user/createWithList", rSpecs.requestBodySpec(creatingUser2, appJSONContentType), "message", "ok");
        bc.POSTRequest("v2/user/createWithArray", rSpecs.requestBodySpec(creatingUser3, appJSONContentType), "message", "ok");
    }

    @Step
    @When("^I send username and password$")
    @Then("^I should be successfully logged in$")
    public void successful_Login_And_Logout() {
        bc.purePOSTRequest("v2/user/login?username=" + userName + "&password=" + userPassword, rSpecs.simpleSpec(appJSONContentType));
        bc.purePOSTRequest("v2/user/logout", rSpecs.simpleSpec(appJSONContentType));
    }

    @Step
    @When("^I send username to delete user$")
    @Then("^User should be successfully deleted$")
    public void successful_User_Deletion() {
        bc.pureDELETERequest("v2/user/" + userName, rSpecs.simpleSpec(appJSONContentType));
    }

    @Step
    @When("^I send incorrect username to delete the user$")
    @Then("^There should be an error$")
    public void unsuccessful_User_Deletion() {
        bc.pureDELETERequest("v2/user/" + "!@#!@$", rSpecs.simpleSpec(appJSONContentType));
    }
}
