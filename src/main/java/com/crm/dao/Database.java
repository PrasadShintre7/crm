package com.crm.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
	
	 Connection connection=null;
     public Connection connect() throws ClassNotFoundException
     {
        String  DBURL="jdbc:mysql://localhost:3306/crmdb";
        String  DBUSER="root";
        String  DBPASS="P3b@mysql";

        connection=null;
         
        try {
            
           Class.forName("com.mysql.jdbc.Driver");
           connection = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
           
            
            
        } catch (SQLException ex) {
        System.out.println(ex);   
        }
        return connection;
    }
     
   
     public ResultSet getData(String query) throws SQLException{
         ResultSet result=null;
             Statement stmt=null;
              String sql=query;
             connection=null;
         try {
             
              connection=connect();
              stmt=connection.createStatement();
              result=stmt.executeQuery(sql);
              
         } catch (ClassNotFoundException ex) {
            
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
          
             return result;
    }
     
     
     public void Closed() throws SQLException{
         
         connection.close();
     }
     
    public boolean setData(String query) throws SQLException {
             Boolean return_value=false;
             ResultSet result=null;
             Statement stmt=null;
             String sql=query;
             int i=0;
            connection=null;
         try {
             
             connection=connect();
             stmt=connection.createStatement();
             i=stmt.executeUpdate(sql);
             if(i>0)
                 return_value=true;
             else
                 return_value=false;
            connection.close();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return return_value;
    }

}
