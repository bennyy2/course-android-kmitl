package kmitl.lab08.benjarat58070079.espresso;


import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }


    @Test
    public void mainActivityTest() {
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
    }

    @Test
    public void Test2() {
        onView(allOf(withId(R.id.editTextAge), isDisplayed())).perform(replaceText("20"));
        closeSoftKeyboard();
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed())).perform(click());
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
    }

    @Test
    public void Test3() {
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        onView(withId(R.id.textNotFound)).check(matches(withText("Not Found")));
    }

    @Test
    public void Test4() {
        onView(allOf(withId(R.id.editTExtName), isDisplayed())).perform(replaceText("Ying"));
        closeSoftKeyboard();
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed())).perform(click());
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));

    }

    @Test
    public void Test5() {
        onView(allOf(withId(R.id.editTExtName))).perform(replaceText("Ying"));
        onView(allOf(withId(R.id.editTextAge))).perform(replaceText("20"));
        closeSoftKeyboard();
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textName)).check(matches(withText("Ying")));
        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textAge)).check(matches(withText("20")));
    }

    @Test
    public void Test6() {
        onView(allOf(withId(R.id.editTExtName))).perform(replaceText("Ladarat"));
        onView(allOf(withId(R.id.editTextAge))).perform(replaceText("20"));
        closeSoftKeyboard();
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        onView(withRecyclerView(R.id.list).atPositionOnView(1, R.id.textName)).check(matches(withText("Ladarat")));
        onView(withRecyclerView(R.id.list).atPositionOnView(1, R.id.textAge)).check(matches(withText("20")));
    }

    @Test
    public void Test7(){
        onView(allOf(withId(R.id.editTExtName))).perform(replaceText("Somkait"));
        onView(allOf(withId(R.id.editTextAge))).perform(replaceText("80"));
        closeSoftKeyboard();
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        onView(withRecyclerView(R.id.list).atPositionOnView(2, R.id.textName)).check(matches(withText("Somkait")));
        onView(withRecyclerView(R.id.list).atPositionOnView(2, R.id.textAge)).check(matches(withText("80")));
    }

    @Test
    public void Test8() {
        onView(allOf(withId(R.id.editTExtName))).perform(replaceText("Prayoch"));
        onView(allOf(withId(R.id.editTextAge))).perform(replaceText("60"));
        closeSoftKeyboard();
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        onView(withRecyclerView(R.id.list).atPositionOnView(3, R.id.textName)).check(matches(withText("Prayoch")));
        onView(withRecyclerView(R.id.list).atPositionOnView(3, R.id.textAge)).check(matches(withText("60")));
    }



    @Test
    public void Test9() {
        onView(allOf(withId(R.id.editTExtName))).perform(replaceText("Prayoch"));
        onView(allOf(withId(R.id.editTextAge))).perform(replaceText("50"));
        closeSoftKeyboard();
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        onView(withRecyclerView(R.id.list).atPositionOnView(4, R.id.textName)).check(matches(withText("Prayoch")));
        onView(withRecyclerView(R.id.list).atPositionOnView(4, R.id.textAge)).check(matches(withText("50")));
    }








}
