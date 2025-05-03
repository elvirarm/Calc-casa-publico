package prog2425.dam1.calcbasica.repositorio

import prog2425.dam1.calcbasica.ui.IEntradaSalida

interface IGestorLogs {

    fun guardarOperacion(num1: Double, num2: Double, signo: String, resultado: Double?)

    fun mostrarUltimoLog(consola: IEntradaSalida)
}