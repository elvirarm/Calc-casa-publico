package prog2425.dam1.calcbasica.repositorio

import prog2425.dam1.calcbasica.ui.IEntradaSalida
import java.io.File

interface IGestorLogs {

    fun obtenerArchivoLog(start: String): File

    fun guardarOperacion(num1: Double, num2: Double, signo: String, resultado: Double?)

    fun mostrarUltimoLog(consola: IEntradaSalida)

    fun guardarError(mensaje: String?)
}