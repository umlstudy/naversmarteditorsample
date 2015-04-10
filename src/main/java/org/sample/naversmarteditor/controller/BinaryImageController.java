package org.sample.naversmarteditor.controller;

import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.sample.naversmarteditor.service.UploadFileService;
import org.sample.naversmarteditor.util.ByteUtil;
import org.sample.naversmarteditor.vo.UploadedFileBinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/binaryImage")
public class BinaryImageController {

	@Autowired
	UploadFileService uploadFileService;
	
	@RequestMapping(method = RequestMethod.GET, value = "hello")
	public String hello(@RequestParam("world")String world) {
		return "AAAA";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "image")
	public ResponseEntity<byte[]> getImage(
				HttpServletResponse response
			  , @RequestParam("hashCode")String hashCode
			) throws Exception {
		UploadedFileBinary uploadedFileBinary = uploadFileService.selectUploadedFileBinary(hashCode);
		final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    return new ResponseEntity<byte[]>(uploadedFileBinary.getBlobData(), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping("uploadImages")
	public void uploadImages(HttpServletRequest request, HttpServletResponse response){
	    try {
	    	String fileName = request.getHeader("file-name");
	    	String fileNameExt = fileName.substring(fileName.lastIndexOf(".")+1);
	    	fileNameExt = fileNameExt.toLowerCase();
	    	String sessionId = request.getSession().getId();
	    	InputStream is = request.getInputStream();
	    	String hashCode = null;
	    	try {
	    		byte[] blob = ByteUtil.getBytes(is);
	    		hashCode = uploadFileService.insertTmpUploadedFileBinary(sessionId, fileName, fileNameExt, blob);
	    	} catch ( Exception e ) {
	    		IOUtils.closeQuietly(is);
	    		throw new RuntimeException(e);
	    	}
	    	PrintWriter print = response.getWriter();
    		print.print(hashCode);
    		print.flush();
    		print.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}
}
