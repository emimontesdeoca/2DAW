package web.utils;

import web.controllers.clienteController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class servletUtils {

    public static String dbUrl = "jdbc:mysql://localhost/consumoelectrico?profileSQL=true";
    public static String dbUser = "2daw";
    public static String dbPassword = "2daw";
    public static Integer dbPageSize = 10;
    public static Integer DEFAULT_PAGESIZE = 10;
    public static String driverClassName = "com.mysql.jdbc.Driver";

    public static List<clienteController> getAllClientes(Integer skip, Integer take) throws Exception {

        /// Lista para devolver clientes
        ArrayList<clienteController> res = new ArrayList<>();
        Connection conexion = null;
        try {
            Class.forName(driverClassName);
            conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from misclientes limit " + skip + "," + take);
            while (rs.next()) {
                /// Crea un clIente con los datos que recibe de la bases de datos y lo agrega a la lista
                clienteController newcliente = new clienteController(rs.getInt("Id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("NombreCalle"), rs.getInt("numero"), rs.getInt("CodPostal"), rs.getString("Poblacion"), rs.getString("Provincia"));
                res.add(newcliente);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception();
        } finally { // Se cierra la conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                throw new Exception();
            }
        }
        return res;
    }

}
