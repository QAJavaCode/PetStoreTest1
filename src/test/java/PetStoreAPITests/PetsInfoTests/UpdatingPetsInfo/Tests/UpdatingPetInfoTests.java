package PetStoreAPITests.PetsInfoTests.UpdatingPetsInfo.Tests;

import PetStoreAPITests.PetsInfoTests.UpdatingPetsInfo.Steps.UpdatingPetInfoStepDefinitions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/main/resources/features/PetsInfoFeatures/EditingPetsInfo/UpdatingPetsInfo.feature",
        glue = "classpath:PetStoreAPITests.PetsInfoTests.UpdatingPetsInfo.Steps",
        plugin = {"pretty"})

public class UpdatingPetInfoTests {
        @Steps
        UpdatingPetInfoStepDefinitions updSteps = new UpdatingPetInfoStepDefinitions();

        @Before
        public void setUp(){
                updSteps.setUp();
        }

        @Test
        @Title("Uploading Pet Test")
        public void uploadingPetPhotosTest(){updSteps.uploading_Pet_Photos();}

        @Test
        @Title("Incorrectly Uploading Adding Pet Test")
        public void incorrectlyAddingPetPhotosTest(){updSteps.uploading_Pet_Photos();}

        @Test
        @Title("Updating Pet Info")
        public void updatingPetTest(){updSteps.updating_Pet_Info();}

        @Test
        @Title("Incorrectly updating Pet Info")
        public void incorrectlyUpdatingPetTest(){updSteps.incorrectly_adding_New_Pet_to_the_Store();}

        @Test
        @Title("Updating Pet Info with correct form data")
        public void formUpdatesPetTest(){updSteps.updating_Pet_Store_Form_Info();}

        @Test
        @Title("Incorrectly updating Pet Info with correct form data")
        public void invalidFormUpdatesPetTest(){updSteps.updating_Pet_Store_Incorrect_Form_Info();}

        @Test
        @Title("Deleting the pet")
        public void deletingThePetTest(){
                updSteps.deleting_The_Pet();
                updSteps.deletion_verification();
        }



}