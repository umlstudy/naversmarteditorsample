package org.sample.naversmarteditor.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sample.naversmarteditor.vo.UploadedFileBinary;
import org.sample.naversmarteditor.vo.UploadedFileRef;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedFileBinaryMapper {

	@Insert("INSERT INTO UploadedFileBinary "
			+ " (hashCode, blobData) "
			+ " VALUES "
			+ " (#{hashCode}, #{blobData})")
	public int insertUploadedFileBinary(UploadedFileBinary uploadedFileBinary);

	@Insert("INSERT INTO UploadedFileRef "
			+ " (hashCode, fileName, fileNameExt, refCode) "
			+ " VALUES "
			+ " (#{hashCode}, #{fileName}, #{fileNameExt}, #{refCode})")
	public int insertUploadedFileRef(UploadedFileRef uploadedFileRef);

//	@Select("SELECT ufb.*, ufr.blobData "
//			+ " FROM UploadedFileBinary ufb, UploadedFileRef ufr "
//			+ " WHERE ufb.hashCode = #{hashCode} and ufb.hashCode = ufr.hashCode")
//	public UploadedFileBinary selectUploadedFileBinary(@Param("hashCode") String hashCode);
	@Select("SELECT "
			+ " FROM UploadedFileBinary ufb "
			+ " WHERE ufb.hashCode = #{hashCode}")
	public UploadedFileBinary selectUploadedFileBinary(@Param("hashCode") String hashCode);
}