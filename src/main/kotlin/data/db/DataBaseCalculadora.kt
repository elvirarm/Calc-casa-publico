package prog2425.dam1.calcbasica.data.db
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DataBaseCalculadora {
    private const val JDBC_URL = "jdbc:h2:./data/calculadora"
    private const val USUARIO = "sa"
    private const val CONTRASENIA = ""

    fun abrirConexion(): Connection {

        try {
            Class.forName("org.h2.Driver")
            return DriverManager.getConnection(JDBC_URL, USUARIO, CONTRASENIA)
        }catch (e: SQLException) {
            throw IllegalArgumentException("Error al realizar la conexión con la base de datos. ${e.message}")
        }catch (e: Exception){
            throw Exception("Error inesperado: ${e.message}")
        }
    }

    fun cerrarConexion(conn: Connection) {
        try {
            conn.close()
        }catch (e: SQLException) {
            throw IllegalArgumentException("Error al cerrar la conexión.")
        }catch (e: Exception){
            throw Exception("Error inesperado: ${e.message}")
        }
    }
}
