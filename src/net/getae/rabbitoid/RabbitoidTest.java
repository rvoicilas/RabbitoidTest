package net.getae.rabbitoid;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class net.getae.rabbitoid.RabbitoidTest \
 * net.getae.rabbitoid.tests/android.test.InstrumentationTestRunner
 */
public class RabbitoidTest extends ActivityInstrumentationTestCase2<Rabbitoid> {
    private Rabbitoid activity;
    private Button newProfileButton;
    private String expectedString;

    public RabbitoidTest() {
        super("net.getae.rabbitoid", Rabbitoid.class);
    }

    @Override
    protected void setUp() throws Exception {
	super.setUp();
	activity = this.getActivity();
	newProfileButton = (Button) activity.findViewById(net.getae.rabbitoid.R.id.new_profile_button);
    }

    public void testNewProfileButtonString() {
	expectedString = "Setup new profile!";
	assertEquals(expectedString, newProfileButton.getText());
    }
}
