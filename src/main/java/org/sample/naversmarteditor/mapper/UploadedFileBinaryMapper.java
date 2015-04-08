package org.sample.naversmarteditor.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sample.naversmarteditor.vo.UploadedFileBinary;

public interface UploadedFileBinaryMapper {

	@Select("SELECT * FROM UploadedFileBinary WHERE hashCode = #{hashCode}")
	public UploadedFileBinary selectUploadedFileBinary(@Param("hashCode") int hashCode);

	@Insert("INSERT INTO UploadedFileBinary (hashCode, blob) VALUES (#{hashCode}, #{blob}")
	public int insertUploadedFileBinary(UploadedFileBinary uploadedFileBinary);
}
