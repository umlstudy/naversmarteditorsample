package org.sample.naversmarteditor.service;

import org.sample.naversmarteditor.mapper.TmpUploadedFileBinaryMapper;
import org.sample.naversmarteditor.mapper.UploadedFileBinaryMapper;
import org.sample.naversmarteditor.vo.TmpUploadedFileRef;
import org.sample.naversmarteditor.vo.UploadedFileBinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileService {

	@Autowired
	private UploadedFileBinaryMapper uploadedFileBinaryMapper;

	@Autowired
	private TmpUploadedFileBinaryMapper tmpUploadedFileBinaryMapper;

	public UploadedFileBinary selectUploadedFileBinary(String hashCode) {
		return uploadedFileBinaryMapper.selectUploadedFileBinary(hashCode);
	}

	public String insertTmpUploadedFileBinary(String sessionId, String fileName, String ext, byte[] blob) {
		UploadedFileBinary ufb = new UploadedFileBinary();
		ufb.init(blob);
		uploadedFileBinaryMapper.insertUploadedFileBinary(ufb);
		
		TmpUploadedFileRef tufr = new TmpUploadedFileRef();
		tufr.init(ufb.getHashCode(), sessionId, fileName, ext);
		tmpUploadedFileBinaryMapper.insertTmpUploadedFileBinary(tufr);
		
		return ufb.getHashCode();
	}
}
