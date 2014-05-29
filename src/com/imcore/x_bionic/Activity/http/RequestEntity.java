package com.imcore.x_bionic.Activity.http;

import java.util.Map;

import android.R;

public class RequestEntity {

	private String url;
	private int method = HttpMethod.POST;
	private Map<String, Object> textFields;

	public RequestEntity() {

	}

	public RequestEntity(String url) {
		this.url = url;
	}

	public RequestEntity(String url, Map<String, Object> textFields) {
		this.url = url;
		this.textFields = textFields;
	}

	public RequestEntity(String url, int method, Map<String, Object> textFields) {

		this.url = url;
		this.textFields = textFields;
		this.method = method;

	}

	public String getUrl(){
		
		return url;
	}
	public void setUrl(String url){
		
		this.url =url;
		
	}
	
	
	public int getMethod(){
		
		return method;
		
	}
	
	public void setMethod(int method) {
		this.method = method;
	}

	/**
	 * 获取请求参数
	 * 
	 * @return
	 */
	public Map<String, Object> getTextFields() {
		return textFields;
	}

	/**
	 * 设置请求参数
	 * 
	 * @param textFields
	 */
	public void setTextFields(Map<String, Object> textFields) {
		this.textFields = textFields;
	}
	
	
}
