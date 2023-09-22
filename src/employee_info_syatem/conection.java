package employee_info_syatem;

import java.sql.*;

public class conection {
    public static Connection getConnection() {
    	Connection con =null;
    	
    	try {
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/venkat",
                    "root", "9865271790a");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return con;
    }
}
