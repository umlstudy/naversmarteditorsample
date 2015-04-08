package org.sample.naversmarteditor.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.sample.naversmarteditor.mapper.UploadedFileBinaryMapper;
import org.sample.naversmarteditor.vo.UploadedFileBinary;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadFileService {

	@Autowired
	private UploadedFileBinaryMapper uploadedFileBinaryMapper;

	public UploadedFileBinary selectUploadedFileBinary(int hashCode) {
		return uploadedFileBinaryMapper.selectUploadedFileBinary(hashCode);
	}

	public int insertUploadedFileBinary(byte[] blob) {
		UploadedFileBinary vo = new UploadedFileBinary();
		vo.setBlob(blob);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.update(blob);
		byte[] digest = md.digest();
		vo.setHashCode(bytesToHex(digest));
		return uploadedFileBinaryMapper.insertUploadedFileBinary(vo);
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
