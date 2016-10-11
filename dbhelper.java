/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prana
 */

public class dbhelper {
    Connection con;
    String pass="zzzz";
    
    //public void close()
    
    
    
    public void createdb(String dbname)
    {
    
try{
Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost/","root",pass);
        PreparedStatement ta = con.prepareStatement("create database "+dbname+";");
             
        
//        ta.setString(1, userc);
//        ta.setString(2, passc);
       ta.execute();
          con.close();
        }catch(Exception e){System.out.println(e);}
    }
    //query
    public ResultSet dbcallq(String que,String dbname)
    {
        
try{
Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection("jdbc:mysql://localhost/"+dbname,"root",pass);
        PreparedStatement ta = con.prepareStatement(que);
                
         ResultSet rs= ta.executeQuery();
          
         // con.close();
          return rs;
        }catch(Exception e){System.out.println(e);}
return null;

    }
    //update
     public void dbcallup(String que,String dbname)
    {
        
try{
Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection("jdbc:mysql://localhost/"+dbname,"root",pass);
        PreparedStatement ta = con.prepareStatement(que);
                
          ta.executeUpdate();
//con.close();
        }catch(Exception e){System.out.println(e);}


    }
}
