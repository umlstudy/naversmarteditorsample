--CREATE TABLE person (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255));

CREATE TABLE tmpUploadedFileBinary (
	sessionId VARCHAR(128) NOT NULL
	,hashCode VARCHAR(128) NOT NULL
	,fileName VARCHAR(256) NOT NULL
	,fileNameExt VARCHAR(12) NOT NULL
	,PRIMARY KEY (sessionId,hashCode)
);

CREATE TABLE uploadedFileBinary (
	hashCode VARCHAR(128) NOT NULL
	,blobData  VARBINARY(1000000)
	,PRIMARY KEY (hashCode)
);

CREATE TABLE uploadedFileRef (
	hashCode VARCHAR(128) NOT NULL
	,refCode VARCHAR(128) NOT NULL
	,fileName VARCHAR(256) NOT NULL
	,fileNameExt VARCHAR(12) NOT NULL
	,PRIMARY KEY (hashCode, refCode)
);

--ALTER TABLE uploadedFileDesc ADD FOREIGN KEY (hashCode) REFERENCES uploadedFileBinary (hashCode)