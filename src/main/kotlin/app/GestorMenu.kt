package prog2425.dam1.calcbasica.app

import prog2425.dam1.calcbasica.model.Operacion
import prog2425.dam1.calcbasica.service.IServiceCalculadora
import prog2425.dam1.calcbasica.service.IServiceError
import prog2425.dam1.calcbasica.service.IServiceOperaciones
import prog2425.dam1.calcbasica.ui.IEntradaSalida
import java.lang.Exception
import java.sql.SQLException



class GestorMenu(val consola: IEntradaSalida,
                 val calculadora: IServiceCalculadora,
                 val operacionService: IServiceOperaciones,
                 val errorService: IServiceError) {

    fun iniciarCalculadora(){

        var salir = false

        while (!salir){
            try {
                val num1 = consola.pedirNum("Introduce el primer número: ")
                if (num1 == null) {
                    throw IllegalArgumentException("Introduce un número válido")
                }

                val signo = consola.pedirSigno("Introduce el operador (+, -, *, /): ")
                val num2 = consola.pedirNum("Introduce el segundo número: ")
                if (num2 == null){
                    throw IllegalArgumentException("Introduce un número válido")
                }


                val resultado = realizarCalculo(num1, num2, signo)
                mostrarResultado(resultado)
                guardarOperacion(num1, signo, num2, resultado)

                if(!preguntarRecalcular()){
                    salir = true
                }else{
                    salir = false
                }
            } catch(e: IllegalArgumentException){
                consola.mostrarError("${e.message}")
                guardarError("${e.message}")
            }
                catch (e: Exception) {
                    consola.mostrarError("${e.message}")
                    guardarError("${e.message}")
                }
            }
        }



    private fun realizarCalculo(num1: Double, num2: Double, signo: String): Double {
        return calculadora.calcular(num1, num2, signo)
    }




    fun mostrarResultado(resultado: Double?){
        if (resultado != null){
            consola.mostrar("Resultado: $resultado")
        }else{
            consola.mostrarError("Error en el cálculo")
        }
    }

    fun preguntarRecalcular(): Boolean{

        val respuestasValidas = arrayOf("sí", "s", "no", "n")
        var entradaUsuario: String

        do {
            entradaUsuario = consola.pedirInfo("¿Deseas hacer otro cálculo? (sí / s / no / n)").trim().lowercase()
            if (entradaUsuario !in respuestasValidas) {
                consola.mostrarError("La respuesta no es válida")
            }
        } while (entradaUsuario !in respuestasValidas)

        return when (entradaUsuario) {
            "sí", "s" -> {
                consola.limpiarPantalla(20)
                true
            }
            else -> {
                consola.mostrar("Saliendo...")
                false
            }
        }
    }

    fun iniciar(args: Array<String>) {
    try{
        when (args.size){
        0 -> {
            consola.mostrar(consultarOperacion())
            iniciarCalculadora()
        }
        3 -> {
            val numero1 = args[0].toDouble()
            val signo = args[1].lowercase()
            val numero2 = args[2].toDouble()
            val resultado = calculadora.calcular(numero1, numero2, signo)
            guardarOperacion(numero1, signo, numero2, resultado)
            consola.mostrar(consultarOperacion())
            iniciarCalculadora()
        }
        else -> consola.mostrarError("Debes introducir un argumento o cuatro o ninguno.")
    }
    }catch (e: SQLException){
        consola.mostrar("Error, ${e.message}")
        errorService.guardarError(e.message.toString())
    }catch (e: Exception){
        consola.mostrar("Error, ${e.message}")
        errorService.guardarError(e.message.toString())
    }

}

    private fun guardarOperacion(numero1: Double, signo: String, numero2: Double, resultado: Double){
        operacionService.insertar(numero1,signo,numero2, resultado)
    }

    private fun consultarOperacion(): Operacion? {
        return operacionService.consultarOperacion()
    }

    private fun guardarError(mensaje: String) {
    errorService.guardarError(mensaje)
    }
}