import java.sql.*;

/**
 * Created by andriusbaltrunas on 7/23/2018.
 */
public class JdbcExample {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            //1. pirmas zingsnis sukurti connection`a
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "MySQL");
        } catch (SQLException e) {
            System.out.println("Iviko klaida " + e);
        }

        if (connection != null) {
            System.out.println("Prisijungeme!!!!");

            try {
                //2. zingsnis sukurti statement
                Statement st = connection.createStatement();
                //3. executinti statement
                ResultSet resultSet = st.executeQuery("SELECT * from students");

                while (resultSet.next()){
                    System.out.println(resultSet.getString("name") +" "+ resultSet.getString("SURNAME"));
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
