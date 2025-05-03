package prog2425.dam1.calcbasica.app

import prog2425.dam1.calcbasica.repositorio.IGestorLogs
import prog2425.dam1.calcbasica.service.IOperaciones
import prog2425.dam1.calcbasica.ui.IEntradaSalida

class GestorMenu(val consola: IEntradaSalida, val calculadora: IOperaciones, val gestorLogs: IGestorLogs? = null) {

    fun iniciarCalculadora(){

        val num1 = consola.pedirNum("Introduce el primer número: ")
        val signo = consola.pedirSigno("Introduce el operador (+, -, *, /): ")
        val num2 = consola.pedirNum("Introduce el segundo número: ")
        val resultado = obtenerResultado(num1, num2, signo)
        mostrarResultado(resultado)
        gestorLogs?.guardarOperacion(num1, num2, signo, resultado)
        preguntarRecalcular()

    }

    fun obtenerResultado(num1: Double, num2: Double, signo: String): Double?{
        return calculadora.calcular(num1, num2, signo)
    }

    fun mostrarResultado(resultado: Double?){
        if (resultado != null){
            consola.mostrar("Resultado: $resultado")
        }else{
            consola.mostrarError("Error en el cálculo")
        }
    }

    fun preguntarRecalcular(){

        val respuestasValidas = arrayOf("sí", "s", "no", "n")
        var entradaUsuario: String

        do {
            entradaUsuario = consola.pedirInfo("¿Deseas hacer otro cálculo? (Respuestas válidas: sí / s / no / n )").trim().lowercase()
            if (entradaUsuario !in respuestasValidas){
                consola.mostrarError("La respuesta no es válida")
            }
        }while(entradaUsuario !in respuestasValidas)

        when (entradaUsuario){

            "sí", "s" -> {
                consola.limpiarPantalla(20)
                iniciarCalculadora()
            }
            "no", "n" -> consola.mostrar("Saliendo...")
        }

        }

    }
