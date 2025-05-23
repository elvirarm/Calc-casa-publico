package prog2425.dam1.calcbasica.data.dao

import prog2425.dam1.calcbasica.data.db.DataBaseCalculadora


class ErrorDAO(): IErrorDAO {

    init{
        crearTablaError()
    }

    override fun guardarError(mensajeError: String) {
        val sql = """
            INSERT INTO Error (mensaje) VALUES (?)
            """.trimIndent()
        DataBaseCalculadora.abrirConexion().use{conn ->
            val stmt = conn.prepareStatement(sql)
            stmt.setString(1, mensajeError)
            stmt.executeUpdate()
        }
    }

    private fun crearTablaError(){
        val sql =  """
                   CREATE OR REPLACE TABLE IF NOT EXISTS Error (
                  id INT AUTO_INCREMENT PRIMARY KEY,
                  mensaje VARCHAR(500) NOT NULL
            );
        """.trimIndent()
        DataBaseCalculadora.abrirConexion().use { conn ->
            val stmt = conn.createStatement()
            stmt.executeUpdate(sql)
        }
    }

}