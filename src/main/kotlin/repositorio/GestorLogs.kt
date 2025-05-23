package prog2425.dam1.calcbasica.repositorio

import prog2425.dam1.calcbasica.ui.IEntradaSalida
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GestorLogs( val carpetaLog: File) : IGestorLogs {

    override fun obtenerArchivoLog(start: String): File {
        if (!carpetaLog.exists()) {
            carpetaLog.mkdirs()
        }

        val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
        val nombreLog = "${start}${LocalDateTime.now().format(formatter)}.txt"

        return File(carpetaLog, nombreLog)
    }

    override fun guardarOperacion(num1: Double, num2: Double, signo: String, resultado: Double?) {
        val archivoLog = obtenerArchivoLog("log")

        val fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        val linea = if (resultado != null) {
            "[$fecha] $num1 $signo $num2 = $resultado\n"
        } else {
            "[$fecha] $num1 $signo $num2 = ERROR\n"
        }

        archivoLog.appendText(linea)
    }

    override fun guardarError(mensaje: String?) {
        val archivoLog = obtenerArchivoLog("error")
        val fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        val linea = "[$fecha] ERROR: ${mensaje}\n"
        archivoLog.appendText(linea)
    }

    override fun mostrarUltimoLog(consola: IEntradaSalida) {
        if (!carpetaLog.exists() || carpetaLog.listFiles().isNullOrEmpty()) {
            consola.mostrar("No existen ficheros de Log")
            return
        }

        val archivosLog = carpetaLog.listFiles { file ->
            // Ya lo he hecho pero no tiene sentido que incluya los errores porque nunca va a ser el último el error a no ser que se saliese del programa, en mi caso se queda en bucle hasta que el cálculo es correcto
            file.isFile && file.name.startsWith("log") || file.name.startsWith("error")  && file.name.endsWith(".txt")
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
