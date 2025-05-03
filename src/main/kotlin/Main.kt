package prog2425.dam1.calcbasica

import prog2425.dam1.calcbasica.app.GestorMenu
import prog2425.dam1.calcbasica.repositorio.GestorLogs
import prog2425.dam1.calcbasica.service.Operar
import prog2425.dam1.calcbasica.ui.Consola
import java.io.File

fun main(args: Array<String>) {
    val consola = Consola()
    val calculadora = Operar()

    val carpetaLog = when (args.size) {
        0 -> File("./log")
        1 -> File(args[0])
        4 -> File(args[0])
        else -> {
            consola.mostrarError("Debe tener 0, 1 o 4 argumentos")
            return }
    }
    val gestorLogs = GestorLogs(carpetaLog)

    if (!carpetaLog.exists()) {
        carpetaLog.mkdirs()
        consola.mostrar("Ruta ${carpetaLog.path} creada")
    }

    if (args.size == 0 || args.size == 1) {
        gestorLogs.mostrarUltimoLog(consola)
    }

    if (args.size == 4) {
        val num1 = args[1].toDoubleOrNull()
        val signo = args[2]
        val num2 = args[3].toDoubleOrNull()
        if (num1 == null || num2 == null) {
            consola.mostrarError("Los números no son válidos")
            return
        }
        val resultado = calculadora.calcular(num1, num2, signo)
        if (resultado == null){
            consola.mostrarError("Operación inválida")
        }
        else{
            consola.mostrar("Resultado: $resultado")
        }
        gestorLogs.guardarOperacion(num1, num2, signo, resultado)
    }

    consola.pausa()
    consola.limpiarPantalla(20)

    GestorMenu(consola, calculadora, gestorLogs).iniciarCalculadora()
}
