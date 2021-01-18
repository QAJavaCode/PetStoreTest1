package PetStoreAPITests.OrderTests.Steps;

import MainAPILogic.BaseClass;
import MainAPILogic.RequestSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;

import static MainAPILogic.BaseClass.appJSONContentType;
import static MainAPILogic.Vars.*;

public class OrderingStepDefinitions {
        BaseClass bc = new BaseClass();
        RequestSpecifications rSpecs = new RequestSpecifications();

        @Step
        @Given("^I enter proper ID and quantity$")
        @When("^I send new request$")
        @Then("^I should receive proper order data$")
        public void placing_Correct_Order() {
            bc.purePOSTRequest("v2/store/order", rSpecs.requestBodySpec(placingOrderBody, appJSONContentType));
        }

        @Step
        @Given("^I enter improper ID and quantity$")
        @When("^I send bad request$")
        @Then("^I shouldn't receive proper order data$")
        public void placing_Incorrect_Order() {
            bc.POSTRequest("v2/store/order", rSpecs.requestBodySpec(placingIncorrectOrderBody, appJSONContentType), "status", placedOrderStatus);
        }

        @Step
        @Given("^I enter pet ID from 1 to 10$")
        @When("^I send proper request$")
        @Then("^I can get proper order data$")
        public void get_Order_Details_By_ID() {
                bc.GETRequest("v2/store/order/" + orderID, rSpecs.simpleSpec(appJSONContentType), "status", placedOrderStatus);
        }

        @Step
        @Given("^I enter wrong pet ID$")
        @When("^I send improper request$")
        @Then("^I can't get proper order data$")
        public void get_Improper_Order_Details_By_ID() {
                bc.GETRequest("v2/store/order/" + tooBigOrderID, rSpecs.simpleSpec(appJSONContentType), "status", approvedOrderStatus);
        }

        @Step
        @Given("^I enter order ID$")
        @When("^I send request to the server$")
        @Then("^Order doesn't exist after it's been deleted$")
        public void deleting_An_Order_By_ID() {
                bc.pureDELETERequest("v2/store/order/" + orderID, rSpecs.simpleSpec(appJSONContentType));
        }

        @Step
        @Given("^I enter negative order ID$")
        @When("^I send bad request to the server$")
        @Then("^Order couldn't be deleted$")
        public void improper_deleting_An_Order_By_ID() {
                bc.pureDELETERequest("v2/store/order/" + negativeOrderID, rSpecs.simpleSpec(appJSONContentType));
        }

        @Step
        @When("^I send request$")
        @Then("^I get the inventory data$")
        public void getting_inventory_data() {
                bc.pureGETRequest("v2/store/inventory", rSpecs.simpleSpec(appJSONContentType));
        }
}
