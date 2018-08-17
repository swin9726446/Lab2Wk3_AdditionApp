package com.example.a9726446.lab2wk3_additionapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UITestAdd {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void uITestAdd() {
        //Espresso creates lots of extra stuff:
        //ViewInteraction appCompatEditText = onView( allOf(withId(R.id.etFirstNum), childAtPosition( childAtPosition( withId(android.R.id.content), 0), 1), isDisplayed()));
        //appCompatEditText.perform(replaceText("2"), closeSoftKeyboard());
        //ViewInteraction appCompatEditText2 = onView( allOf(withId(R.id.etSecondNum), childAtPosition( childAtPosition( withId(android.R.id.content), 0), 2), isDisplayed()));
        //appCompatEditText2.perform(replaceText("3"), closeSoftKeyboard());
        //ViewInteraction appCompatButton = onView(allOf(withId(R.id.btnAdd), withText("Add"),childAtPosition( childAtPosition( withId(android.R.id.content), 0), 3), isDisplayed()));
        //appCompatButton.perform(click());

        //Which may be distilled as:
        onView(withId(R.id.etFirstNum)).perform(click());
        onView(withId(R.id.etFirstNum)).perform(replaceText("2"));
        onView(withId(R.id.etSecondNum)).perform(click());
        onView(withId(R.id.etSecondNum)).perform(replaceText("3"));
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.txtAnswer)).check(matches(withText("5")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
