package com.crm.controller;

import java.sql.SQLException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.Entity.AppointmentEntity;
import com.crm.Entity.CustomerEntity;
import com.crm.Entity.ReportEntity;
import com.crm.Entity.UserEntity;
import com.crm.dao.Dao;


@RestController
public class MainController {
	
	
	Dao dao=new Dao();
	
	
	@GetMapping("/welcome")
	public String index() {
		return 	"Welcome to CRM";	
	}
	
	@PostMapping(path="/login",consumes = "application/json")
	public String userLogin(@RequestBody UserEntity obj) throws ClassNotFoundException, SQLException {
		return dao.userLogin(obj);
	}
	
	@PostMapping(path="/adduser",consumes = "application/json")
	public boolean addUser(@RequestBody UserEntity obj) throws ClassNotFoundException, SQLException {
		return dao.addUser(obj);
	}
	
	
	
	@GetMapping("/listcustomer")
	public String listCustomer() throws ClassNotFoundException, SQLException, JSONException {
		return dao.listCustomer();
	}
	
	@PostMapping(path="/addcustomer",consumes = "application/json")
	public boolean addCustomer(@RequestBody CustomerEntity obj) throws ClassNotFoundException, SQLException {
		return dao.addCustomer(obj);
	}
	
	
	@PostMapping(path="/updatecustomer",consumes = "application/json")
	public boolean updateCustomer(@RequestBody CustomerEntity obj) throws ClassNotFoundException, SQLException {
		return dao.updateCustomer(obj);
	}
	
	
	@GetMapping(path="/deletecustomer/{id}")
	public boolean deleteCustomerbyid(@PathVariable int id) throws ClassNotFoundException, SQLException {
		return dao.deleteCustomerById(id);
	}
	
	
	@PostMapping(path="/deletecustomer",consumes = "application/json")
	public boolean deleteCustomer(@RequestBody CustomerEntity obj) throws ClassNotFoundException, SQLException {
		return dao.deleteCustomer(obj);
	}
	
	
	@GetMapping("/listappointment")
	public String listAppointment() throws ClassNotFoundException, SQLException, JSONException {
		return dao.listAppointment();
	}
	
	@PostMapping(path="/addappointment",consumes = "application/json")
	public boolean addAppointment(@RequestBody AppointmentEntity obj) throws ClassNotFoundException, SQLException {
		return dao.addAppointment(obj);
	}
	
	
	@PostMapping(path="/updateappointment",consumes = "application/json")
	public boolean updateAppointment(@RequestBody AppointmentEntity obj) throws ClassNotFoundException, SQLException {
		return dao.updateAppointment(obj);
	}
	
	
	@GetMapping(path="/deleteappointment/{id}")
	public boolean deleteAppointmentbyid(@PathVariable int id) throws ClassNotFoundException, SQLException {
		return dao.deleteAppointmentById(id);
	}
	
	@PostMapping(path="/deleteappointment",consumes = "application/json")
	public boolean deleteAppointment(@RequestBody AppointmentEntity obj) throws ClassNotFoundException, SQLException {
		return dao.deleteAppointment(obj);
	}
	
	
	@PostMapping(path="/reportappointment",consumes = "application/json")
	public String deleteAppointment(@RequestBody ReportEntity obj) throws ClassNotFoundException, SQLException, JSONException {
		return dao.reportAppointment(obj);
	}
	
	
	
	

}
