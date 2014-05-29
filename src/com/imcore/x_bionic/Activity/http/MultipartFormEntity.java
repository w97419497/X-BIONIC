package com.imcore.x_bionic.Activity.http;

import java.io.File;

public class MultipartFormEntity extends RequestEntity {
	private String fileFieldName;
	private File fileField;

	/**
	 * 构�?函数
	 */
	public MultipartFormEntity() {
	}

	/**
	 * 构�?函数
	 * 
	 * @param url
	 *            指定的请求地�?
	 */
	public MultipartFormEntity(String url) {
		super(url);
	}

	/**
	 * 获得文件域的名称
	 * 
	 * @return
	 */
	public String getFileFieldName() {
		return fileFieldName;
	}

	/**
	 * 设置文件域的名称
	 * 
	 * @param fileFieldName
	 */
	public void setFileFieldName(String fileFieldName) {
		this.fileFieldName = fileFieldName;
	}

	/**
	 * 获得文件�?
	 * 
	 * @return
	 */
	public File getFileField() {
		return fileField;
	}

	/**
	 * 设置文件�?
	 * 
	 * @param fileField
	 */
	public void setFileField(File fileField) {
		this.fileField = fileField;
	}

}
