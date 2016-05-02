package jp.co.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/*
 * カート画面に遷移。
 * 同時にsessionを送る。
 *
 *
 */
public class Go2CartAction extends ActionSupport implements SessionAware{

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
