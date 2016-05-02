package jp.co.internous.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.internous.dao.IteminCartDAO;
import jp.co.internous.dto.IteminCartDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


/*
 * jspからの値をDBで検索、取得
 * Listに格納
 * Sessionに格納 sessionMapの中にList型変数名cartitemを格納
 *
 */
public class IteminCartAction extends ActionSupport implements SessionAware{


	public int id;
	public int number;

	public String result;
	public Map<String,Object>sessionMap;
	public List<IteminCartDTO> cartitem=new ArrayList<IteminCartDTO>();

	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		result=ERROR;

		IteminCartDAO dao=new IteminCartDAO();


		if(dao.select(id, number)){

			if(sessionMap.containsKey("cartitem")){//sessionのKey-cartitemがからではない場合。
				cartitem=(List<IteminCartDTO>) sessionMap.get("cartitem");
			}
			cartitem.addAll(dao.getCartitem());

			sessionMap.put("cartitem",cartitem);
			result=SUCCESS;

		}

		System.out.println("result - "+result);
		return result;
	}//execute

	public List<IteminCartDTO> getCartitem() {
		return cartitem;
	}

	public void setCartitem(List<IteminCartDTO> cartitem) {
		this.cartitem = cartitem;
	}

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}

	public void setNumber(int number){
		this.number=number;
	}

	public int getNumber(){
		return number;
	}


	public Map<String,Object> getSessionMap(){
		return sessionMap;
	}

	public void setSession(Map<String,Object>sessionMap){
		this.sessionMap=sessionMap;
	}

}//class



