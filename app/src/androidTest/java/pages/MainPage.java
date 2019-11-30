package pages;

import androidx.test.espresso.ViewAction;
import androidx.test.uiautomator.UiDevice;
import com.example.favoritemovies.R;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class MainPage {
    private UiDevice mDevice;

    public MainPage (UiDevice mDevice){this.mDevice = mDevice;}

    public MainPage InsertEmail(final String email){
        onView(withId(R.id.sign_in_email))
                .check(matches(withId(R.id.sign_in_email)))
                .perform(typeText(email));

        return this;
    }

    public MainPage InsertPassword(final String password){
        onView(withId(R.id.sign_in_password))
                .check(matches(withId(R.id.sign_in_password)))
                .perform(typeText(password));

        return this;
    }

    public RegisterPage ClickInRegisterButton(){
        onView(withId(R.id.sign_in_register_btn))
                .check(matches(withId(R.id.sign_in_register_btn)))
                .perform(click());

        return new RegisterPage(mDevice);
    }

    public MainPage SignInErrorMessage(){

        try {
            onView(withId(R.id.sign_in_error_message))
                    .check(matches(withId(R.id.sign_in_error_message)))
                    .perform((ViewAction) isDisplayed());
            System.out.println("Invalid email or password");
        } catch (Exception e){}


        return new MainPage(mDevice);
    }

    public MoviesPage PressEntrarButton(){
        onView(withId(R.id.sign_in_login_btn))
                .check(matches(withId(R.id.sign_in_login_btn)))
                .perform(click());

        return new MoviesPage(mDevice);
    }

    public MainPage CheckIfLoginButtonIsCheckable(){
        onView(withId(R.id.sign_in_login_btn))
                .check(matches(withId(R.id.sign_in_login_btn)))
                .perform((ViewAction) isChecked());

        return this;
    }

}
