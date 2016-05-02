package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dto.Go2ItemDTO;
/*
 * DBから取得
 * itemlistに格納
 *
 */
public class Go2ItemDAO {

	Connection con;
	PreparedStatement ps;

	List<Go2ItemDTO> itemlist= new ArrayList<Go2ItemDTO>();
	boolean res;


	public boolean select()throws Exception{
		res=false;

		con=DBconnector.getConnection();

		try{
			String sql="select * from goods";
			ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				res=true;

				Go2ItemDTO dto=new Go2ItemDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt(3));

				itemlist.add(dto);


			}//while

		}catch(Exception e){

		}finally{
			con.close();
		}//finally

		return res;
	}//select


	public List<Go2ItemDTO> getItemlist(){
		return itemlist;
	}
}//class
