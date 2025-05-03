package prog2425.dam1.calcbasica.repositorio

import prog2425.dam1.calcbasica.ui.IEntradaSalida
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GestorLogs( val carpetaLog: File) : IGestorLogs {

    fun obtenerArchivoLog(): File {
        if (!carpetaLog.exists()) {
            carpetaLog.mkdirs()
        }

        val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
        val nombreLog = "log${LocalDateTime.now().format(formatter)}.txt"

        val archivoLog = File(carpetaLog, "log.txt")

        return archivoLog
    }

    override fun guardarOperacion(num1: Double, num2: Double, signo: String, resultado: Double?) {
        val archivoLog = obtenerArchivoLog()

        val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        val linea = if (resultado != null) {
            "[$timestamp] $num1 $signo $num2 = $resultado\n"
        } else {
            "[$timestamp] $num1 $signo $num2 = ERROR\n"
        }

        archivoLog.appendText(linea)
    }

    override fun mostrarUltimoLog(consola: IEntradaSalida) {
        if (!carpetaLog.exists() || carpetaLog.listFiles().isNullOrEmpty()) {
            consola.mostrar("No existen ficheros de Log")
            return
        }

        val archivosLog = carpetaLog.listFiles { file ->
            file.isFile && file.name.startsWith("log") && file.name.endsWith(".txt")
        }

        val masReciente = archivosLog?.maxByOrNull { it.name }

        if (masReciente != null) {
            consola.mostrar("Mostrando contenido de: ${masReciente.name}")
            masReciente.forEachLine { consola.mostrar(it) }
        } else {
            consola.mostrar("No se ha encontrado un log válido.")
        }
    }
}
