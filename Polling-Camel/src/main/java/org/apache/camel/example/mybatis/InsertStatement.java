package org.apache.camel.example.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.jdbc.EmbeddedDriver;
import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;

public class InsertStatement {
	static Connection connection;
	final static Logger logger = Logger.getLogger(InsertStatement.class);
	public static void main(String[] args) throws IOException,SQLException{
	      Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
	      EmbeddedDriver driver = new EmbeddedDriver();
          connection = driver.connect("jdbc:derby:memory:mybatis" + ";create=true", null);
          String sql = "create table ORDERS (\n"
                  + "  ORD_ID integer primary key,\n"
                  + "  ITEM varchar(10),\n"
                  + "  ITEM_COUNT varchar(5),\n"
                  + "  ITEM_DESC varchar(30),\n"
                  + "  ORD_DELETED boolean\n"
                  + ")";
          execute(sql);
          
          String sqlInsert1 = "INSERT INTO ORDERS " +
                  "VALUES (1, 'Zara', '10', 'zara desc',true)";
          
          executeInsert(sqlInsert1);
          
          
          String sqlInsert2 = "INSERT INTO ORDERS " +
                  "VALUES (2, 'Zara', '10', 'zara3 des3c',true)";
          
          executeInsert(sqlInsert2);
          
          
          String sqlQuery = "SELECT * FROM ORDERS " ;

          
          executeQuery(sqlQuery);
          
	      //SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

//	      int id = 1;
//	      System.out.println("Going to read record.....");
//	      //Employee e = (Employee)smc.queryForObject ("Employee.useResultMap", id);
//
//	      System.out.println("ID:  " + e.getId());
//	      System.out.println("First Name:  " + e.getFirstName());
//	      System.out.println("Last Name:  " + e.getLastName());
//	      System.out.println("Salary:  " + e.getSalary());
//	      System.out.println("Record read Successfully ");
	   }
	
	   private static void execute(String sql) throws SQLException {
	        Statement stm = connection.createStatement();
	        stm.execute(sql);
	        // must commit connection
	        connection.commit();
	        stm.close();
	    }
	   
	    private static void executeInsert(String sql) throws SQLException {
	        Statement stm = connection.createStatement();
	        stm.execute(sql);
	        // must commit connection
	        logger.info("insert succes..");
	        connection.commit();
	        stm.close();
	    }
	    
	    private static void executeQuery(String sql) throws SQLException {
	       Statement stm = connection.createStatement();
	       ResultSet record = stm.executeQuery(sql);
	       logger.info("insert record.."+record.toString());
	       List<Order> orderList = new ArrayList<Order>();
	       Order order = new Order();
	       while(record.next()) {
	    	  order.setId(record.getInt("ORD_ID"));
	    	  logger.info("record1:"+order.getId());
	    	  
	    	  orderList.add(order);
	       }

	       logger.info("insert record.."+order.getId()+":size="+orderList.size());
	       
	       // must commit connection
	       logger.info("insert executeQuery..");
	       connection.commit();
	       stm.close();
	    }
}
