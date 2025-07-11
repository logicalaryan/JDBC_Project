package Logining;
import java.sql.*;
public class DbConnection  //use refractor from left side to rename the file name dont keep class name as connection
{
    java.sql.Connection c;//  if i write connection c which means c is the class2.here  to make java understand that jdbc connection not my class
    Statement s;
    
    public DbConnection()
    {
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");//driver is class name in the jdbc
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "codeforinterview");
        s=c.createStatement();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
}
