package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dto.IteminCartDTO;

public class IteminCartDAO {


	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public List<IteminCartDTO> cartitem=new ArrayList<IteminCartDTO>();
	public boolean res;

	public boolean select(int id,int number)throws Exception{
		res=false;

		con=DBconnector.getConnection();

		try{
			String sql="select * from goods where goods_id=?";

			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			System.out.println("ps - "+ps);
			rs=ps.executeQuery();
			System.out.println("executeQuery - OK");
			while(rs.next()){
				res=true;

				IteminCartDTO dto=new IteminCartDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setNumber(number);

				cartitem.add(dto);//listに格納
				System.out.println("cartitem - "+cartitem);
			}//while
		}catch(Exception e){

		}finally{
			con.close();
		}//finally

		return res;
	}//select


	public void setCartitem2(List<IteminCartDTO> cartitem) {
		this.cartitem = cartitem;
	}


	public List<IteminCartDTO> getCartitem(){
		return cartitem;
	}

}//class
