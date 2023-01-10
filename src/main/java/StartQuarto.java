import java.sql.*;
import java.util.ArrayList;

public class StartQuarto {

    public static void main(String[] args) {

        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "passwordhere";

            con = DriverManager.getConnection(url, user, password);

            Statement s = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";


            s.executeUpdate(sql);
            System.out.println("Table created.");



            String sqlAlter = "ALTER TABLE student ADD country VARCHAR(30);";
            s.executeUpdate(sqlAlter);
            s.executeUpdate("UPDATE student SET country = \"Italy\" WHERE student_id = 1;" );
            s.executeUpdate("UPDATE student SET country = \"Germany\" WHERE student_id = 2;" );
            s.executeUpdate("UPDATE student SET country = \"Italy\" WHERE student_id = 3;" );
            s.executeUpdate("UPDATE student SET country = \"Germany\" WHERE student_id = 4;" );



        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(con != null)
                    con.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
