import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by andriusbaltrunas on 7/23/2018.
 */
public class JdbcSecondTask {

    public static void main(String[] args) {

        Connection connection = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite studento id");
        String id = sc.nextLine();
        System.out.println("Iveskite varda");
        String name = sc.nextLine();
        System.out.println("Iveskite pavarde");
        String surname = sc.nextLine();
        System.out.println("Iveskite telefona");
        String phone = sc.nextLine();
        System.out.println("Iveskite email");
        String email = sc.nextLine();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kcs", "root", "MySQL");
        } catch (SQLException e) {
            System.out.println("Klaida " + e);
        }

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE students set name='" + name + "', surname='" + surname + "', " +
                        "phone='" + phone + "', email='" + email + "' where id=" + id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}