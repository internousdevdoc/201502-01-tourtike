package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import jp.co.internous.dto.Go2CompleatDTO;

public class Go2CompleatDAO {

	Connection con;
	PreparedStatement ps;
	public Map<String,Object>sessionMap;
	public int rsCount;

	public boolean select(String password)throws Exception{
		boolean res=false;
		System.out.println("パスワードチェック");
		con=DBconnector.getConnection();

		try{
			String sql="select * from customer_info where customer_pass=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,password);

			System.out.println("select - パスワード"+ps);
			ResultSet rs=ps.executeQuery();
			System.out.println("パスワードチェックOK");
			while(rs.next()){
				res=true;

				Go2CompleatDTO dto=new Go2CompleatDTO();
				dto.setPassword(rs.getString(1));

			}//while
		}catch(Exception e){

		}finally{
			con.close();
		}
		System.out.println("resは"+res);
		return res;
	}

	public int insert(int id,int number)throws Exception{

		con=DBconnector.getConnection();

		try{
			String sql="insert into order_info(goods_id,order_count) values(?,?)";
			System.out.println("insert中");
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2,number);
			System.out.println("insert - "+ps);
			rsCount=ps.executeUpdate();
			System.out.println("insert - "+rsCount);
			if(rsCount>0){

				System.out.println("インサートOk");

			}//if



		}catch(Exception e){

		}finally{
			con.close();
		}



		return rsCount;

	}

	public Map<String,Object> getSessionMap(){
		return sessionMap;
	}

	public void setSession(Map<String,Object>sessionMap){
		this.sessionMap=sessionMap;
	}
}
