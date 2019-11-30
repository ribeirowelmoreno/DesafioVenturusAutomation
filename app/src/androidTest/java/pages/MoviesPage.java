package pages;

import androidx.test.espresso.ViewAction;
import androidx.test.uiautomator.UiDevice;
import com.example.favoritemovies.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.StringContains.containsString;

public class MoviesPage {
    private UiDevice mDevice;
    public MoviesPage(UiDevice mDevice) {this.mDevice = mDevice;}

    public MoviesPage AddToFavoritesButton(){
        onView(withId(R.id.movie_add_favorite))
                .check(matches(withId(R.id.movie_add_favorite)))
                .perform(click());

        return this;
    }

    public TrailerPage ClickInWatchTrailer() {

        onData(anything()).inAdapterView(withChild(withId(R.id.content))).atPosition(2).perform(click());
        //onView(withId(R.id.view_container))
        //        .check(matches(withText(containsString(movie))))
       //         .perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.movie_trailer))
                .check(matches(withId(R.id.movie_trailer)))
                .perform(click());

        return new TrailerPage(mDevice);

    }
}
