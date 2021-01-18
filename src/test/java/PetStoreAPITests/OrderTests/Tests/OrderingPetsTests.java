package PetStoreAPITests.OrderTests.Tests;

import PetStoreAPITests.OrderTests.Steps.OrderingStepDefinitions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/main/resources/features/OrderInfoFeatures/OrderFunctionality.feature",
        glue = "classpath:PetStoreAPITests.OrderTests.Steps",
        plugin = {"pretty"})
public class OrderingPetsTests {
        @Steps
        OrderingStepDefinitions ordSteps = new OrderingStepDefinitions();

        @Test
        @Title("Placing an order")
        public void placingCorrectOrder(){ordSteps.placing_Correct_Order();}

        @Test
        @Title("Placing an incorrect order")
        public void placingAnIncorrectOrder(){ordSteps.placing_Incorrect_Order();}

        @Test
        @Title("Getting Order details by ID")
        public void getOrderDetails(){ordSteps.get_Order_Details_By_ID();}

        @Test
        @Title("Incorrectly getting details by ID")
        public void getIncorrectOrderData(){ordSteps.get_Improper_Order_Details_By_ID();}

        @Test
        @Title("Deleting an order")
        public void orderDeletion(){ordSteps.deleting_An_Order_By_ID();}

        @Test
        @Title("Improper deletion of an order")
        public void improperOrderDeletion(){ordSteps.improper_deleting_An_Order_By_ID();}

        @Test
        @Title ("Getting inventory data")
        public void gettingInvData(){ordSteps.getting_inventory_data();}
}