package pages;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.EspressoException;
import androidx.test.uiautomator.UiDevice;
import com.example.favoritemovies.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class RegisterPage {
    private UiDevice mDevice;

    public RegisterPage(UiDevice mDevice) {this.mDevice = mDevice;}

    public RegisterPage InsertFullName(final String fullName){
        onView(withId(R.id.register_name))
                .check(matches(withId(R.id.register_name)))
                .perform(typeText(fullName));
        Espresso.pressBack();

        return this;
    }

    public RegisterPage InsertCpfNumber(final String docNumber){
        onView(withId(R.id.register_document))
                .check(matches(withId(R.id.register_document)))
                .perform(typeText(docNumber));

        Espresso.pressBack();

        return this;
    }

    public RegisterPage InsertMobileNumber(final String phoneNumber){
        onView(withId(R.id.register_phone))
                .check(matches(withId(R.id.register_phone)))
                .perform(typeText(phoneNumber));

        Espresso.pressBack();

        return this;
    }

    public RegisterPage InsertEmail(final String registerEmail){
        onView(withId(R.id.register_email))
                .check(matches(withId(R.id.register_email)))
                .perform(typeText(registerEmail));

        Espresso.pressBack();

        return this;
    }

    public RegisterPage EmailConfirmation(final String emailConfirmation){
        onView(withId(R.id.register_email_confirm))
                .check(matches(withId(R.id.register_email_confirm)))
                .perform(typeText(emailConfirmation));

        Espresso.pressBack();

        return this;
    }

    public RegisterPage InsertPassword(final String registerPassword){
        onView(withId(R.id.register_password))
                .check(matches(withId(R.id.register_password)))
                .perform(typeText(registerPassword));

        Espresso.pressBack();

        return this;
    }

    public RegisterPage ConfirmPassword(final String confirmPassword){
        onView(withId(R.id.register_password_confirm))
                .check(matches(withId(R.id.register_password_confirm)))
                .perform(typeText(confirmPassword));
        Espresso.pressBack();

        return this;
    }

    public MainPage PressCancelButton(){
        onView(withId(R.id.sign_up_cancel_btn))
                .check(matches(withId(R.id.sign_up_cancel_btn)))
                .perform(click());

        Espresso.pressBack();

        return new MainPage(mDevice);
    }

    public MainPage PressConfirmButton(){
        onView(withId(R.id.sign_in_register_btn))
                .check(matches(withId(R.id.sign_in_register_btn)))
                .perform(click());

        return new MainPage(mDevice);
    }
}
