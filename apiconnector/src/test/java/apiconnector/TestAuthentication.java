package apiconnector;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.openml.apiconnector.algorithms.DateParser;
import org.openml.apiconnector.io.OpenmlConnector;
import org.openml.apiconnector.settings.Constants;
import org.openml.apiconnector.xml.Authenticate;

public class TestAuthentication {
	
	private static final String username = "janvanrijn@gmail.com";
	private static final String password = "Feyenoord2002";
	private static final String server = "http://localhost/openexpdb_v2/";
	
	@Test
	public void loginSucces() {
		try {
			OpenmlConnector con = new OpenmlConnector(server, username, password);
			Authenticate auth = con.authenticate();
			long validUntil = DateParser.mysqlDateToTimeStamp(auth.getValidUntil(),auth.getTimezone());
			Assert.assertTrue( validUntil > new Date().getTime() + Constants.DEFAULT_TIME_MARGIN );
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Login failed: " + e.getMessage() );
		}
	}
}
