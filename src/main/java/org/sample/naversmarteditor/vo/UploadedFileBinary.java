package org.sample.naversmarteditor.vo;

public class UploadedFileBinary {
	private String hashCode;
	private byte[] blob;

	public byte[] getBlob() {
		return blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
}
