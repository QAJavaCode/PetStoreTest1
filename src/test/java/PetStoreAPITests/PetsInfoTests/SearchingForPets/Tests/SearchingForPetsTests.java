package PetStoreAPITests.PetsInfoTests.SearchingForPets.Tests;

import PetStoreAPITests.PetsInfoTests.SearchingForPets.Steps.SearchingForPetStepDefinitions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/main/resources/features/PetsInfoFeatures/SearchingForPets/FindingPets.feature",
        glue = "classpath:PetStoreAPITests.PetsInfoTests.SearchingForPets.Steps",
        plugin = {"pretty"})

public class SearchingForPetsTests {
        @Steps
        SearchingForPetStepDefinitions searchSteps = new SearchingForPetStepDefinitions();

        @Test
        @Title("Searching the pet by correct statuses")
        public void searchingForPetByCorrectStatuses(){searchSteps.searching_for_Pets_By_Statuses();}

        @Test
        @Title("Searching the pet by incorrect statuses")
        public void searchingForPetByIncorrectStatuses(){searchSteps.searching_for_Pets_By_Incorrect_Statuses();}
}
