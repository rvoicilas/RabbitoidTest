package net.getae.rabbitoid;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.test.AndroidTestCase;

public class RabbitoidProfilesTest extends AndroidTestCase {

    private StringReader getFixture(String fixtureName) {
    }

    public void testGetProfilesNoProfiles() throws IOException, XmlPullParserException {
	StringReader sr = new StringReader("<profiles></profiles>");
	RabbitoidProfiles rp = new RabbitoidProfiles(sr);
	ArrayList<String> profiles = rp.getProfiles();
	assertEquals(0, profiles.size());
    }

    public void testGetProfilesOne() throws IOException, XmlPullParserException {
	StringReader sr = new StringReader("<profiles><profile name=\"rc\" /></profiles>");
	RabbitoidProfiles rp = new RabbitoidProfiles(sr);
	ArrayList<String> profiles = rp.getProfiles();
	assertEquals(1, profiles.size());
	assertEquals("rc", profiles.get(0));
    }

    public void testGetProfilesMultiple() throws IOException, XmlPullParserException {
	StringReader sr = new StringReader("<profiles><profile name=\"dev-env1\" /><profile name=\"dev-env2\" /><profile name=\"dev-env3\" /></profiles>");
	RabbitoidProfiles rp = new RabbitoidProfiles(sr);
	ArrayList<String> profiles = rp.getProfiles();
	assertEquals(3, profiles.size());
	assertEquals("dev-env3", profiles.get(0));
	assertEquals("dev-env2", profiles.get(1));
	assertEquals("dev-env1", profiles.get(2));
    }

    public void testGetProfilesDuplicates() throws IOException, XmlPullParserException {
	StringReader sr = new StringReader("<profiles><profile name=\"dup\" /><profile name=\"dup\" /></profiles>");
	RabbitoidProfiles rp = new RabbitoidProfiles(sr);
	ArrayList<String> profiles = rp.getProfiles();
	assertEquals(1, profiles.size());
    }
}
