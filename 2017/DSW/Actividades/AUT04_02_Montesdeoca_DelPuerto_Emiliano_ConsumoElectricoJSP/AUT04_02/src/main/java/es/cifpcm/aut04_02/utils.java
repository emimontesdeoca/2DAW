package es.cifpcm.aut04_02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class utils {

    public static String dbUrl;
    public static String dbUser;
    public static String dbPassword;
    public static Integer dbPageSize;
    public static Integer DEFAULT_PAGESIZE = 10;
    public static String driverClassName;
    public static String classForName;

    public static void loadProperties() {

        try {
            //String configBundleName = config.getInitParameter("app.config");
            ResourceBundle rb = ResourceBundle.getBundle("consumoelectrico");
            dbUrl = rb.getString("database.url");
            dbUser = rb.getString("database.user");
            dbPassword = rb.getString("database.password");
            dbPageSize = rb.getString("database.pageSize") == null ? DEFAULT_PAGESIZE : Integer.parseInt(rb.getString("database.pageSize"));
            driverClassName = rb.getString("database.driver");
            Class.forName(driverClassName);
        } catch (ClassNotFoundException ex) {

        }
    }

    public static List<cliente> getAllClientes() throws Exception {

        /// Si no hay valores precargados de los properties
        if (dbUrl == null || dbPassword == null) {
            loadProperties();
        }

        /// Lista para devolver clientes
        List<cliente> res = new ArrayList<>();
        Connection conexion = null;
        try {
            Class.forName(driverClassName);
            conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from misclientes limit 0," + dbPageSize);
            while (rs.next()) {
                /// Crea un clIente con los datos que recibe de la bases de datos y lo agrega a la lista
                cliente newcliente = new cliente(rs.getInt("Id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("NombreCalle"), rs.getInt("numero"), rs.getInt("CodPostal"), rs.getString("Poblacion"), rs.getString("Provincia"));
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
