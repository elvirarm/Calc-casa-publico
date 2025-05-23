package prog2425.dam1.calcbasica.data.dao

import prog2425.dam1.calcbasica.data.db.DataBaseCalculadora
import prog2425.dam1.calcbasica.model.Operacion
import java.sql.ResultSet

class OperacionDAO: IOperacionDAO {
    init {
        crearTablaOperacion()
    }

    override fun insertar(id: String, numero1: Double, operador: String, numero2: Double, resultado: Double) {
        val sql = "INSERT INTO Operacion (id, numero1, operador, numero2, resultado) VALUES (?,?,?,?,?)"
        DataBaseCalculadora.abrirConexion().use { conn ->
            val stmt = conn.prepareStatement(sql)
            stmt.setString(1, id)
            stmt.setDouble(2, numero1)
            stmt.setString(3, operador)
            stmt.setDouble(4, numero2)
            stmt.setDouble(5, resultado)
            stmt.executeUpdate()
        }
    }

    override fun consultarOperacion(): Operacion? {

        var operacion: Operacion? = null
        val sql = """
                    SELECT * FROM Operacion
                     ORDER BY id DESC
                     LIMIT 1;
        """.trimIndent()
        DataBaseCalculadora.abrirConexion().use { conn ->
            val stmt = conn.createStatement()
            val rs = stmt?.executeQuery(sql)
            if (rs != null) {
                operacion = obtenerOperacionH2(rs)
            } else {
                null
            }
        }
        return operacion
    }


    /**
     * Esta función consulta la base de datos y convierte las filas en una operación para poder trabajar con ella.
     * @param rs son las filas que se obtienen tras la consulta
     * @return una operación construida con todos los valores de la fila de tipo Operación que puede ser nulable
     */
    private fun obtenerOperacionH2(rs: ResultSet): Operacion? {
        var operacion: Operacion? = null
        while (rs.next()) {
            operacion = Operacion(
                id = rs.getString("id"),
                numero1 = rs.getDouble("numero1"),
                signo = rs.getString("operador"),
                numero2 = rs.getDouble("numero2"),
                resultado = rs.getDouble("resultado")
            )
        }
        return operacion
    }

    /**
     * Esta función crea una tabla Operacion para guardar las operaciones que se realicen en la base de datos
     *
     */
    private fun crearTablaOperacion() {
        val sql = """
                   CREATE OR REPLACE TABLE IF NOT EXISTS Operacion (
                  id VARCHAR(200) PRIMARY KEY,
                  numero1 NUMERIC NOT NULL,
                  operador VARCHAR(5) NOT NULL,
                  numero2 NUMERIC NOT NULL,
                  resultado NUMERIC NOT NULL
            );
        """.trimIndent()
        DataBaseCalculadora.abrirConexion().use { conn ->
            val stmt = conn.createStatement()
            stmt?.executeUpdate(sql)
        }

    }
}