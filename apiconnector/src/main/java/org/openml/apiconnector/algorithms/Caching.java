package org.openml.apiconnector.algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openml.apiconnector.settings.Settings;
import org.openml.apiconnector.xstream.XstreamXmlMapping;

public class Caching {
	
	public static void cache( Object o, String type, int identifier ) throws IOException {
		String directoryPath = Settings.CACHE_DIRECTORY + "/" + type;
		File directory = new File( directoryPath );
		directory.mkdirs();
		BufferedWriter bw = new BufferedWriter( new FileWriter( new File( directory.getAbsolutePath() + "/" + identifier ) ) );
		bw.append( XstreamXmlMapping.getInstance().toXML(o) );
		bw.close();
	}
	
	public static File cached( String type, int identifier ) throws IOException {
		File cached = new File( Settings.CACHE_DIRECTORY + "/" + type + "/" + identifier );
		
		if( cached.exists() == false ) {
			throw new IOException("Cache file of " + type + " #" + identifier + " not available, and only local operations are allowed. ");
		} else {
			return cached;
		}
	}

}
