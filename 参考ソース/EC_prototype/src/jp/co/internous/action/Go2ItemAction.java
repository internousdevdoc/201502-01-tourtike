package jp.co.internous.action;

import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dao.Go2ItemDAO;
import jp.co.internous.dto.Go2ItemDTO;

import com.opensymphony.xwork2.ActionSupport;

public class Go2ItemAction extends ActionSupport{

	public String result;
	public List<Go2ItemDTO> itemlist = new ArrayList<Go2ItemDTO>();

	public String execute()throws Exception{
		result=ERROR;

		Go2ItemDAO dao=new Go2ItemDAO();

		if(dao.select()){

			itemlist.addAll(dao.getItemlist());

			result=SUCCESS;
		}//if

		return result;
	}//execute
}//class
