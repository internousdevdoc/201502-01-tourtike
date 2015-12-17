package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * クラス名：CartDAO
 * クラスの説明：item_table(商品情報テーブル)に接続する
 *
 * @author
 * @version
 * @since
 */
public class CartDAO<AdminDTO> extends ActionSupport{

	Connection con = null;
	String sql = null;
	String sql2 = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet res = null;
	int item_id;
	String goods_name;
	int sales_namber;
	int price;
	int total_amount;
	int i;
	List<AdminDTO> itemlist = new ArrayList<AdminDTO>();

	/**
	 * メソッド名：item_del
	 * メソッドの説明：商品を削除する
	 *
	 * @author
	 * @version
	 * @since
	 * @param main.jsp(商品一覧画面)にて選択された商品ID(削除の基準とする)
	 * @throws SQLException
	 */
	public int delete(String inputid) throws SQLException{
	// 商品の削除
		con = DBconnector.getConnection();

		sql = "DELETE FROM item_table WHERE item_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputid);
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pstmt.close();
		con.close();
		return i;
	}


	/**
	 *
	 * @author
	 * @version
	 * @since
	 * @param main.jsp(商品登録画面)にて入力された商品名
	 * @param main.jspにて入力された値段
	 * @param main.jspにて入力された在庫
	 */
	public int insert(String good_name, int sales_numbers,
			int price, int total_amount) {

		try{
			// 商品の登録
			con = DBconnector.getConnection();
			sql = "INSERT INTO item_table (good_name, sales_numbers,price,total_amount) "
					+ "VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goods_name);
			pstmt.setInt(2, sales_namber);
			pstmt.setInt(3, price);
			pstmt.setInt(4, total_amount);

			i=pstmt.executeUpdate();

			pstmt.close();
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return i;

	}

	public List<AdminDTO> select_ALL(){
		return itemlist;
	}
}

