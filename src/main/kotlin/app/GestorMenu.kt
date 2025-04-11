package prog2425.dam1.calcbasica.app

import prog2425.dam1.calcbasica.service.IOperaciones
import prog2425.dam1.calcbasica.ui.IEntradaSalida

class GestorMenu(val consola: IEntradaSalida, val calculadora: IOperaciones) {

    fun iniciarCalculadora(){

        val num1 = consola.pedirNum("Introduce el primer número: ")
        val signo = consola.pedirSigno("Introduce el operador (+, -, *, /): ")
        val num2 = consola.pedirNum("Introduce el segundo número: ")
        val resultado = obtenerResultado(num1, num2, signo)
        mostrarResultado(resultado)
        preguntarRecalcular()

    }

    fun obtenerResultado(num1: Double, num2: Double, signo: String): Double{
        return calculadora.calcular(num1, num2, signo)
    }

    fun mostrarResultado(resultado: Double){
        consola.mostrar("Resultado: $resultado")
    }

    fun preguntarRecalcular(){

        val respuestasValidas = arrayOf("s","n")

        val entradaUsuario = consola.pedirInfo("¿Deseas hacer otro cálculo? (s/n)")

        when (entradaUsuario){
            "s" -> {
                consola.limpiarPantalla(20)
                iniciarCalculadora()
            }
            "n" -> consola.mostrar("Saliendo...")
            else -> while(entradaUsuario !in respuestasValidas){

                consola.mostrarError("La entrada debe ser s/n")
                preguntarRecalcular()
        }





        }

    }
}
