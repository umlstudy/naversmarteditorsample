package org.sample.naversmarteditor.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ByteUtil {

	public static byte[] getBytes(InputStream is) throws IOException {
		ByteArrayOutputStream os=null;
		try {
			os = new ByteArrayOutputStream();
			int numRead;
			byte buf[] = new byte[8192];
			while((numRead = is.read(buf,0,buf.length)) != -1){
				os.write(buf,0,numRead);
			}
			os.flush();
			return os.toByteArray();
		} finally {
			IOUtils.closeQuietly(os);
		} 
	}
	
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
}
