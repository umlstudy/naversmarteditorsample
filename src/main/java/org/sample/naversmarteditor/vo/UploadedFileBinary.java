package org.sample.naversmarteditor.vo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.sample.naversmarteditor.util.ByteUtil;

public class UploadedFileBinary extends UploadedFileRef {
	
	private byte[] blobData;

	public byte[] getBlobData() {
		return blobData;
	}

	public void setBlobData(byte[] blobData) {
		this.blobData = blobData;
	}
	
	public void init(byte[] blob) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.update(blob);
		byte[] digest = md.digest();
		
		setBlobData(blob);
		setHashCode(ByteUtil.bytesToHex(digest));
	}
	
	public void init(byte[] blob, String fileName, String ext) {
		init(blob);
		setFileName(fileName);
		setFileNameExt(ext);
	}
}
