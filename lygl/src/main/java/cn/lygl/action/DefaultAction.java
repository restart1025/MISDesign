package cn.lygl.action;

import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport {
	private static final long serialVersionUID = -4467006658529474481L;
	//JQuery easyui发送过来的时间戳
	private String timestamp;
	private String realUrl;
	
	
	public String getRealUrl() {
		return realUrl;
	}
	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
