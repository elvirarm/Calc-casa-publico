package prog2425.dam1.calcbasica.ui

import java.util.*

class Consola: IEntradaSalida {

    companion object{

        val OPERADORES_DISPONIBLES = arrayOf("+", "-", "/", "*")

    }
    private val scanner = Scanner(System.`in`)

    override fun pedirNum(msj: String): Double {

        var numCorrecto = false
        var num = 0.0

        do {
            mostrar(msj)
            try {
                num = scanner.nextDouble()
                numCorrecto = true
            } catch (e: InputMismatchException) {
                mostrarError("Debes introducir un número")
                scanner.nextLine()
            }catch(e: Exception){
                mostrarError("No se ha podido calcular")
                scanner.nextLine()
            }

        } while (!numCorrecto)

        return num
    }

    override fun pedirSigno(msj: String): String {

        var entrada = ""
        while(entrada !in OPERADORES_DISPONIBLES){
            mostrar(msj)
            try {
                entrada = scanner.next()
                require(entrada in OPERADORES_DISPONIBLES){"La entrada debe ser uno de los siguientes operadores('+', '-', '*', '/')"}

            } catch (e: IllegalArgumentException) {
                mostrarError("$e")
            }
        }
        return entrada
    }

    override fun pedirInfo(msj: String): String {
        mostrar(msj)
        return scanner.next()
    }


    override fun <T> mostrar(msj: T) {
        println(msj)
    }

    override fun mostrarError(msj: String) {
        println("ERROR $msj")
    }

    override fun limpiarPantalla(numSaltos:Int) {
        if (System.console() != null) {
            mostrar("\u001b[H\u001b[2J")
            System.out.flush()
        } else {
            repeat(numSaltos) {
                mostrar("")
            }
        }
    }
}