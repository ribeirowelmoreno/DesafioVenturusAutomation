package tests;

import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;
import com.example.favoritemovies.screens.sign.SignActivity;
import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;

public class  TestLogin {
    private UiDevice mDevice;


    @Rule
    public ActivityTestRule<SignActivity> activityRule = new ActivityTestRule<>(SignActivity.class);

    @Test
    public void testInsertLoginAndPassword(){
        new MainPage(mDevice)
                .ClickInRegisterButton()
                .InsertFullName("Wellynton Moreno")
                .InsertCpfNumber("39272644828")
                .InsertMobileNumber("19998983716")
                .InsertEmail("ribeirowelmoreno@gmail.com")
                .EmailConfirmation("ribeirowelmoreno@gmail.com")
                .InsertPassword("Wel421563@")
                .ConfirmPassword("Wel421563@")
                .PressConfirmButton();
    }

    @Test
    public void testCheckIfLoginButtonIsCheckable(){
        new MainPage(mDevice)
                .ClickInRegisterButton()
                .InsertFullName("Wellynton Ribeiro Moreno")
                .InsertCpfNumber("39272644828")
                .InsertEmail("ribeirowelmoreno@gmail.com")
                .EmailConfirmation("ribeirowelmoreno@gmail.com")
                .InsertPassword("Wel421563@")
                .ConfirmPassword("Wel421563@")
                .PressConfirmButton()
                .InsertEmail("ribeirowelmoreno@gmail.com")
                .InsertPassword("ribeirowelmoreno@gmail.com")
                .CheckIfLoginButtonIsCheckable()
                .PressEntrarButton();

    }

    @Test
    public void testWatchTrailerMovie(){
        new MainPage(mDevice)
                .InsertEmail("ribeirowelmoreno@gmail.com")
                .InsertPassword("Wel421563@")
                .PressEntrarButton()
                .ClickInWatchTrailer();


    }
}
