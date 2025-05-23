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
        1, 4 -> File(args[0])
        else -> {
            consola.mostrarError("Debe tener 0, 1 o 4 argumentos")
            return
        }
    }

    if (!carpetaLog.exists()) {
        carpetaLog.mkdirs()
        consola.mostrar("Ruta ${carpetaLog.path} creada")
    }

    val gestorLogs = GestorLogs(carpetaLog)
    val menu = GestorMenu(consola, calculadora, gestorLogs)
    menu.iniciar(args)


}
