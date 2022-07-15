package com.crm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.crm.Entity.AppointmentEntity;
import com.crm.Entity.CustomerEntity;
import com.crm.Entity.ReportEntity;
import com.crm.Entity.UserEntity;

public class Dao {
	
	
	public String userLogin(UserEntity obj) throws ClassNotFoundException, SQLException {
		
		Database db=new Database();
		ResultSet rs=db.getData("select * from tbl_user where username='"+obj.getUsername()+"' and password='"+obj.getPassword()+"'");
		while(rs.next()) {
			db.Closed();
			return "true";
		}
		db.Closed();
		return "false";
	}
	
	public boolean addUser(UserEntity obj) throws ClassNotFoundException, SQLException {
		
		Database db=new Database();
		boolean b=db.setData("insert into tbl_user (fullname,username,password,mobile) values ('"+obj.getFullname()+"','"+obj.getUsername()+"','"+obj.getPassword()+"','"+obj.getMobile()+"')");
		db.Closed();
		return b;
		
	}
	
public String listCustomer() throws ClassNotFoundException, SQLException, JSONException {
		
		Database db=new Database();
		ResultSet rs=db.getData("select * from tbl_customer");
		JSONArray ja=new JSONArray();
		while(rs.next()) {
			JSONObject obj=new JSONObject();
			obj.put("id", rs.getInt("id"));
			obj.put("fullname", rs.getString("fullname"));
			obj.put("address", rs.getString("address"));
			obj.put("city", rs.getString("city"));
			obj.put("country", rs.getString("country"));
			obj.put("pincode", rs.getString("pincode"));
			obj.put("mobile", rs.getString("mobile"));
			ja.put(obj);
		}
		db.Closed();
		return ja.toString();
	}
	

public boolean addCustomer(CustomerEntity obj) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("insert into tbl_customer (fullname,address,city,country,pincode,mobile) values ('"+obj.getFullname()+"','"+obj.getAddress()+"','"+obj.getCity()+"','"+obj.getCountry()+"','"+obj.getPincode()+"','"+obj.getMobile()+"')");
	db.Closed();
	return b;
	
}
	
public boolean updateCustomer(CustomerEntity obj) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("update tbl_customer set fullname='"+obj.getFullname()+"',address='"+obj.getAddress()+"',city='"+obj.getCity()+"',country='"+obj.getCountry()+"',pincode='"+obj.getPincode()+"',mobile='"+obj.getMobile()+"' where id= "+obj.getId()+"");
	db.Closed();
	return b;
	
}

public boolean deleteCustomer(CustomerEntity obj) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("delete from tbl_customer where id="+obj.getId()+"");
	db.Closed();
	return b;
	
}
	
public boolean deleteCustomerById(int id) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("delete from tbl_customer where id="+id+"");
	db.Closed();
	return b;
	
}


public String listAppointment() throws ClassNotFoundException, SQLException, JSONException {
		
		Database db=new Database();
		ResultSet rs=db.getData("select * from tbl_appointment");
		JSONArray ja=new JSONArray();
		while(rs.next()) {
			JSONObject obj=new JSONObject();
			obj.put("id", rs.getInt("id"));
			obj.put("fullname", rs.getString("fullname"));
			obj.put("subject", rs.getString("subject"));
			obj.put("description", rs.getString("description"));
			obj.put("location", rs.getString("location"));
			obj.put("adate", rs.getString("adate"));
			obj.put("starttime", rs.getString("starttime"));
			obj.put("endtime", rs.getString("endtime"));
			obj.put("mobile", rs.getString("mobile"));
			ja.put(obj);
		}
		db.Closed();
		return ja.toString();
	}
	

public boolean addAppointment(AppointmentEntity obj) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("insert into tbl_appointment (fullname,subject,description,location,mobile,adate,starttime,endtime) values ('"+obj.getFullname()+"','"+obj.getSubject()+"','"+obj.getDescription()+"','"+obj.getLocation()+"','"+obj.getMobile()+"','"+obj.getAdate()+"','"+obj.getStarttime()+"','"+obj.getEndtime()+"')");
	db.Closed();
	return b;
	
}
	
public boolean updateAppointment(AppointmentEntity obj) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("update tbl_appointment set fullname='"+obj.getFullname()+"',subject='"+obj.getSubject()+"',description='"+obj.getDescription()+"',location='"+obj.getLocation()+"',mobile='"+obj.getMobile()+"',adate='"+obj.getAdate()+"',starttime='"+obj.getStarttime()+"',endtime='"+obj.getEndtime()+"' where id= "+obj.getId()+"");
	db.Closed();
	return b;
	
}

public boolean deleteAppointment(AppointmentEntity obj) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("delete from tbl_appointment where id="+obj.getId()+"");
	db.Closed();
	return b;
	
}

public boolean deleteAppointmentById(int id) throws ClassNotFoundException, SQLException {
	
	Database db=new Database();
	boolean b=db.setData("delete from tbl_appointment where id="+id+"");
	db.Closed();
	return b;
	
}




public String reportAppointment(ReportEntity a) throws ClassNotFoundException, SQLException, JSONException {
		
		Database db=new Database();
		ResultSet rs=db.getData("select * from tbl_appointment where adate between '"+a.getFromdate()+"' and '"+a.getTodate()+"'");
		JSONArray ja=new JSONArray();
		while(rs.next()) {
			JSONObject obj=new JSONObject();
			obj.put("id", rs.getInt("id"));
			obj.put("fullname", rs.getString("fullname"));
			obj.put("subject", rs.getString("subject"));
			obj.put("description", rs.getString("description"));
			obj.put("location", rs.getString("location"));
			obj.put("adate", rs.getString("adate"));
			obj.put("starttime", rs.getString("starttime"));
			obj.put("endtime", rs.getString("endtime"));
			obj.put("mobile", rs.getString("mobile"));
			ja.put(obj);
		}
		db.Closed();
		return ja.toString();
	}



}
