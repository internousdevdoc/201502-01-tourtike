/**
 *
 */
package jp.co.internous.action;
import java.util.ArrayList;
import java.util.Map;

import jp.co.internous.dao.CartDAO;
import jp.co.internous.dto.CartDTO;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internous
 *
 */
public class CartAction<CartBean> extends ActionSupport implements SessionAware{

	private int num;
	private String goods_name;
	private int sales_numbers;
	private int price;
	private int total_amount;
	private int item_price;
	private int item_id;
	private int sub_total;
	private int total;
	private String item_price_yen;
	private ArrayList<CartBean> itemlist = new ArrayList<CartBean>();
	private Map<String,Object> session;

		@SuppressWarnings("unchecked")
	public String execute() {

//		System.out.println("アイテムID:"+item_id);
//
//		//セッションに商品がセットされていればここでitemlistにつめる
//		if(session.containsKey("name_key")) {
//	    	itemlist=(ArrayList<CartBean>) session.get("name_key");
//		}

			
	        //DAOをインスタンス化
			CartDAO dao = new CartDAO();
			boolean i;
			try {
				i = dao.select(sql1,sql2);

				itemList.addAll(dao.getItemList());
				System.out.println("ItemList取得！！");

				System.out.println("ItemList確認"+itemList);
			
			
			
		//カートに何も入っていなければエラーページに飛ぶ
		System.out.println("アイテムリストサイズ:"+itemlist.size());
		if(item_id==0 && itemlist.size()==0){
			return "success";
		}


		if(session.containsKey("name_key")) {
    	System.out.println("セッションマップアイテムリスト格納後:"+itemlist);
    	ca.setItem_id(item_id);
    	//セッション内の商品の合計金額を計算
    	ca.sessionTtl(itemlist);
		}
		sub_total=ca.getSub_total();
		//合計金額を計算
		total=ca.getTotal();
		session.put("cart_ttl",total);


		//イテレーターでjspにリスト化するためにオブジェクトに値を詰める

		if(item_id!=0){
		CartDTO dto=new CartDTO();

		dto.setGoods_name(goods_name);
		dto.setSales_numbers(sales_numbers);
		dto.setPrice(price);
		dto.setTotal_amount(total_amount);
		itemlist.addAll(dto);
		session.put("name_key",itemlist);
		}
		return "success";
   }


	/**
	 * @return num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num セットする num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return goods_name
	 */
	public String getGoods_name() {
		return goods_name;
	}

	/**
	 * @param goods_name セットする goods_name
	 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	/**
	 * @return item_price
	 */
	public int getItem_price() {
		return item_price;
	}

	/**
	 * @param item_price セットする item_price
	 */
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	/**
	 * @return item_id
	 */
	public int getItem_id() {
		return item_id;
	}

	/**
	 * @param item_id セットする item_id
	 */
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	/**
	 * @return sub_total
	 */
	public int getSub_total() {
		return sub_total;
	}

	/**
	 * @param sub_total セットする sub_total
	 */
	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}

	/**
	 * @return total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total セットする total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return item_price_yen
	 */
	public String getItem_price_yen() {
		return item_price_yen;
	}

	/**
	 * @param item_price_yen セットする item_price_yen
	 */
	public void setItem_price_yen(String item_price_yen) {
		this.item_price_yen = item_price_yen;
	}

	/**
	 * @return itemlist
	 */
	public ArrayList<CartBean> getItemlist() {
		return itemlist;
	}

	/**
	 * @param itemlist セットする itemlist
	 */
	public void setItemlist(ArrayList<CartBean> itemlist) {
		this.itemlist = itemlist;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
}