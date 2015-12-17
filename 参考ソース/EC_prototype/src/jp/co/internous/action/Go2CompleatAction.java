package jp.co.internous.action;

import java.util.List;
import java.util.Map;

import jp.co.internous.dao.Go2CompleatDAO;
import jp.co.internous.dto.IteminCartDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/*カートから確定画面へ
 * パスワードを入力し、selectからtrueが帰ってきた場合、cartからsessionで値を受け取って格納
 *
 *
 *
 *
 * */
public class Go2CompleatAction extends ActionSupport implements SessionAware{

	public String password;
	public String result;

	public Map<String,Object>sessionMap;
	 public List<IteminCartDTO> cartitem;
	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		System.out.println("jspからの入力"+password);
		result=ERROR;

		Go2CompleatDAO dao=new Go2CompleatDAO();

		if(dao.select(password)){//パスワードが正しい場合、if文の中に入る


			System.out.println("selectでまわした　Ok");
			System.out.println("cartitem"+cartitem);
			System.out.println("sessionMap"+sessionMap);

		 cartitem=(List<IteminCartDTO>)sessionMap.get("cartitem");//sessionの中から値を取り出して、ここのcartitemに格納
		 System.out.println("cartitem"+cartitem);
//for文でcartitemに格納されている値を一つずつとりだして、DAOに入れる
		 for(int i =0 ;i<cartitem.size(); i++){//cartitemの格納数をチェック
		int id=cartitem.get(i).getId();
		System.out.println("id - "+id);

		String name = cartitem.get(i).getName();
		System.out.println("name - "+name);

		int price=cartitem.get(i).getPrice();
		System.out.println("price - "+price);

		int number=cartitem.get(i).getNumber();
		System.out.println("number - "+number);

		System.out.println("number"+number);
		int resdao=dao.insert(id,number);
		if(resdao>0){
			result=SUCCESS;
		}//if
			}//for
		}//if

		return result;
	}//execute

	public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return password;
	}


	public Map<String,Object> getSessionMap(){
		return sessionMap;
	}

	public void setSession(Map<String,Object>sessionMap){
		this.sessionMap=sessionMap;
	}


}
