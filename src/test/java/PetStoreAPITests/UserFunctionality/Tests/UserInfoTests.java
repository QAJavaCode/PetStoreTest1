package PetStoreAPITests.UserFunctionality.Tests;

import PetStoreAPITests.UserFunctionality.Steps.UserInfoStepDefinitions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/main/resources/features/UserFunctionality/UserScenarios.feature",
        glue = "classpath:PetStoreAPITests.UserFunctionality.Steps",
        plugin = {"pretty"})
public class UserInfoTests {
    @Steps
    UserInfoStepDefinitions userInfoSteps = new UserInfoStepDefinitions();

    @Test
    @Title("Creating correct user")
    public void placingCorrectOrder(){userInfoSteps.creating_Correct_User();}

    @Test
    @Title("Creating incorrect user")
    public void placingAnIncorrectOrder(){userInfoSteps.updating_User();}

    @Test
    @Title("Getting user details by username")
    public void gettingUserDetailsByUsername(){userInfoSteps.getting_User_Details_By_Username();}

    @Test
    @Title("Creating users with arrays/lists")
    public void creatingUsersWithLists(){userInfoSteps.create_Users_By_Array_List();}

    @Test
    @Title("Successful login and logout")
    public void successfulLogInAndOut(){userInfoSteps.successful_Login_And_Logout();}

    @Test
    @Title("Successful user deletion")
    public void successfulUserDeletion(){userInfoSteps.successful_User_Deletion();}

    @Test
    @Title("Unsuccessful user deletion")
    public void unsuccessfulUserDeletion(){userInfoSteps.unsuccessful_User_Deletion();}
}
