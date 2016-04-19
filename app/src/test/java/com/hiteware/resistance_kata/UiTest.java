package com.hiteware.resistance_kata;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created on 4/18/16.
 */
@RunWith(RobolectricCustomTestRunner.class)
@Config(constants = BuildConfig.class)
public class UiTest {

    MainActivity CreatedActivity;

    @Before
    public void Setup()
    {
        ActivityController controller = Robolectric.buildActivity(MainActivity.class).create().start();
        CreatedActivity = (MainActivity) controller.get();
        controller.resume();
    }

    @Test
    public void ButtonsHaveProperCaptions()
    {
        assertThat(((Button)CreatedActivity.findViewById(R.id.solution1_button)).getText().toString(), equalTo("Solution1"));
        assertThat(((Button)CreatedActivity.findViewById(R.id.solution2_button)).getText().toString(), equalTo("Solution2"));
        assertThat(((Button)CreatedActivity.findViewById(R.id.solution3_button)).getText().toString(), equalTo("Solution3"));
    }

    @Test
    public void ClickingOnSolutionOneGeneratesTheSolution()
    {
        CreatedActivity.findViewById(R.id.solution1_button).callOnClick();
        assertThat(((TextView)CreatedActivity.findViewById(R.id.textView1)).getText().toString(), equalTo("[3, 4, 1, 2, 8, 6]"));
        assertThat(((TextView)CreatedActivity.findViewById(R.id.textView2)).getText().toString(), equalTo("[6, 1, 8, 2, 7, 4]"));
        assertThat(((TextView)CreatedActivity.findViewById(R.id.textView3)).getText().toString(), equalTo("[5, 9, 3, 9, 9, 5]"));
        assertThat(((TextView)CreatedActivity.findViewById(R.id.textView4)).getText().toString(), equalTo("[8, 4, 1, 3, 2, 6]"));
        assertThat(((TextView)CreatedActivity.findViewById(R.id.textView5)).getText().toString(), equalTo("[3, 7, 2, 8, 6, 4]"));

        assertThat(((TextView)CreatedActivity.findViewById(R.id.Path_Completed)).getText().toString(), equalTo("Yes"));
        assertThat(((TextView)CreatedActivity.findViewById(R.id.Resistance)).getText().toString(), equalTo("16"));
        assertThat(((TextView)CreatedActivity.findViewById(R.id.Path)).getText().toString(), equalTo("[1, 2, 3, 4, 4, 5]"));
    }

}
