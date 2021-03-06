/*
 *  OpenmlApiConnector - Java integration of the OpenML Web API
 *  Copyright (C) 2014 
 *  @author Jan N. van Rijn (j.n.van.rijn@liacs.leidenuniv.nl)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package apiconnector;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openml.apiconnector.io.OpenmlConnector;
import org.openml.apiconnector.xml.DataFeature;
import org.openml.apiconnector.xml.DataQuality;
import org.openml.apiconnector.xml.DataSetDescription;


public class TestDataFunctionality {

	private static final String username = "janvanrijn@gmail.com";
	private static final String password = "Feyenoord2002";
	private static final String server = "http://localhost/openexpdb_v2/";
	
	/**
	 * Queries all data id's, chooses one of those and obtains its 
	 * data set description, features and qualities. 
	 */
	@Test
	public void testApiDataDownload() {
		OpenmlConnector apiconnector = new OpenmlConnector(server,username,password);
		
		try {
			/*Data d = apiconnector.openmlData();
			
			System.err.println( XstreamXmlMapping.getInstance().toXML(d) );
			
			DataSet[] allDataIds = d.getData();
			System.err.println( "LENGTH: " + allDataIds.length );
			
			DataSet toCheck = allDataIds[Math.abs(r.nextInt() % allDataIds.length)];*/
			int probe = 1170;
			
			DataSetDescription dsd = apiconnector.dataDescription( probe );
			DataFeature features = apiconnector.dataFeatures( probe );
			DataQuality qualities = apiconnector.dataQuality( probe );
			
			// very easy checks, should all pass
			assertTrue( dsd.getId() == probe );
			assertTrue( features.getFeatures().length > 0 );
			assertTrue( qualities.getQualities().length > 0 );
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed: " + e.getMessage());
		}
	}

}
