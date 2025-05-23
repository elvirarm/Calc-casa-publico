package prog2425.dam1.calcbasica.app

import prog2425.dam1.calcbasica.repositorio.IGestorLogs
import prog2425.dam1.calcbasica.service.IOperaciones
import prog2425.dam1.calcbasica.ui.IEntradaSalida

class GestorMenu(val consola: IEntradaSalida, val calculadora: IOperaciones, val gestorLogs: IGestorLogs) {

    fun iniciarCalculadora(){

        var salir = false

        while (!salir){
            try{
                val num1 = consola.pedirNum("Introduce el primer número: ")

                val signo = consola.pedirSigno("Introduce el operador (+, -, *, /): ")

                val num2 = consola.pedirNum("Introduce el segundo número: ")

                val resultado = obtenerResultado(num1, num2, signo)
                mostrarResultado(resultado)
                gestorLogs.guardarOperacion(num1, num2, signo, resultado)
                if(!preguntarRecalcular()){
                    salir = true
                }else{
                    salir = false
                }

            }catch(e: IllegalArgumentException){
                consola.mostrarError("${e.message}")
                gestorLogs.guardarError("${e.message}")

            }
            catch(e:Exception){
                consola.mostrarError("${e.message}")
                gestorLogs.guardarError("${e.message}")
            }
        }


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

    fun preguntarRecalcular(): Boolean{

        val respuestasValidas = arrayOf("sí", "s", "no", "n")
        var entradaUsuario: String

        do {
            entradaUsuario = consola.pedirInfo("¿Deseas hacer otro cálculo? (Respuestas válidas: sí / s / no / n )").trim().lowercase()
            if (entradaUsuario !in respuestasValidas){
                consola.mostrarError("La respuesta no es válida")
            }
        }while(entradaUsuario !in respuestasValidas)

        return when (entradaUsuario){

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

    fun iniciar(args: Array<String>){
        try{
            when (args.size) {
                0, 1 -> {
                    gestorLogs.mostrarUltimoLog(consola)
                    consola.pausa()
                    consola.limpiarPantalla(20)
                    iniciarCalculadora()
                }
                4 -> {
                    val num1 = args[1].toDoubleOrNull()
                    val signo = args[2]
                    val num2 = args[3].toDoubleOrNull()

                    if (num1 == null || num2 == null) {
                        consola.mostrarError("Los números no son válidos")
                        return
                    }

                    val resultado = calculadora.calcular(num1, num2, signo)

                    if (resultado == null) {
                        consola.mostrarError("Operación inválida")
                    } else {
                        consola.mostrar("Resultado: $resultado")
                    }

                    gestorLogs.guardarOperacion(num1, num2, signo, resultado)
                }
            }
        }catch(e: IllegalArgumentException){
            consola.mostrarError("${e.message}")
            gestorLogs.guardarError("${e.message}")
        }
        catch (e:Exception){
            consola.mostrarError("${e.message}")
            gestorLogs.guardarError("${e.message}")
        }
    }

    }
