package prog2425.dam1.calcbasica.repositorio

import java.io.File

interface IGestionCarpetas {

    fun buscarCarpeta(rutaCarpeta: String): Boolean

    fun crearCarpeta(): Boolean

    fun listarArchivos(rutaCarpeta: String): List<File>

}