package prog2425.dam1.calcbasica.repositorio

import java.io.File

class GestorCarpetas : IGestionCarpetas {

    private val carpeta = File("./log")

    override fun obtenerCarpetaLogs(): File {
        return carpeta
    }

    override fun buscarCarpeta(rutaCarpeta: String): Boolean {
        return carpeta.exists()
    }

    override fun crearCarpeta(): Boolean {
        return carpeta.mkdirs()
    }

    override fun listarArchivos(rutaCarpeta: String): List<File> {
        return carpeta.listFiles()?.toList() ?: emptyList()
    }
}
