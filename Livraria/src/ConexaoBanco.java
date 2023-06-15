import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {


    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDlivrariaUniversitaria", "user", "admin");
            return conexao;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não localizado!");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + e.getMessage());
        }

        return null;
    }
}
