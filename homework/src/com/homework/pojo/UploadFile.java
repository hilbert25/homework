package com.homework.pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setImage(MultipartFile file) {
		this.file = file;
	}

	public String getFileType() {
		switch (file.getContentType()) {
		case "application/pdf":
			return ".pdf";
		case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
			return ".docx";
		case "application/msword":
			return ".doc";
		default:
			return ".null";
		}
	}

}