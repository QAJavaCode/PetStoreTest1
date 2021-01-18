package PetStoreAPITests.PetsInfoTests.AddingNewOne.Tests;

import PetStoreAPITests.PetsInfoTests.AddingNewOne.Steps.AddingThePetStepDefinitions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/main/resources/features/PetsInfoFeatures/AddingPets/AddingNewPet.feature",
        glue = "classpath:PetStoreAPITests.PetsInfoTests.AddingNewOne.Steps",
        plugin = {"pretty"}
)
public class AddingThePetTest{

    @Steps
    AddingThePetStepDefinitions addSteps = new AddingThePetStepDefinitions();

    @Test
    @Title("Correctly Adding Pet Test")
    public void addingPetTest(){
        addSteps.adding_New_Pet_to_the_Store();
    }

    @Test
    @Title("Incorrectly Adding Pet Test")
    public void incorrectlyAddingPetTest(){
        addSteps.incorrectly_adding_New_Pet_to_the_Store();
    }
}
