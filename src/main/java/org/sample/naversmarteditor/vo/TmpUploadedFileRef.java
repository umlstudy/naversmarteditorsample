package org.sample.naversmarteditor.vo;

import org.springframework.http.MediaType;

public class TmpUploadedFileRef {
	private String sessionId;
	private String hashCode;
	private String fileName;
	private MediaType fileNameExt;

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileNameExt() {
		return fileNameExt.getType();
	}

	public void setFileNameExt(String ext) {
		fileNameExt = MediaType.valueOf(ext);
	}

	public MediaType getFileMediaType() {
		return fileNameExt;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public void init(String hashCode, String sessionId, String fileName, String ext) {
		this.setSessionId(sessionId);
		this.setHashCode(hashCode);
		this.setFileName(fileName);
		this.setFileNameExt(ext);
	}
}
