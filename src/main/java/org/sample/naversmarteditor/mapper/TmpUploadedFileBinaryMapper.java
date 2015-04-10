package org.sample.naversmarteditor.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sample.naversmarteditor.vo.TmpUploadedFileRef;
import org.springframework.stereotype.Repository;

@Repository
public interface TmpUploadedFileBinaryMapper {

	@Select("SELECT * FROM TmpUploadedFileBinary WHERE hashCode = #{hashCode}")
	public TmpUploadedFileRef selectTmpUploadedFileBinary(@Param("hashCode") String hashCode);

	@Insert("INSERT INTO TmpUploadedFileBinary (hashCode, fileName, fileNameExt) VALUES (#{hashCode}, #{fileName}, #{fileNameExt})")
	public int insertTmpUploadedFileBinary(TmpUploadedFileRef tmpUploadedFileBinary);
}
