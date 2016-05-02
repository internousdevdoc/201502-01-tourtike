package jp.co.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Go2FixedAction extends ActionSupport implements SessionAware{

	public String result;
	public Map<String,Object>sessionMap;

	public String execute(){
		result=SUCCESS;


		return result;
	}//execute

	public Map<String,Object> getSessionMap(){
		return sessionMap;
	}

	public void setSession(Map<String,Object>sessionMap){
		this.sessionMap=sessionMap;
	}

}
