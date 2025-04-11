package prog2425.dam1.calcbasica

import prog2425.dam1.calcbasica.app.GestorMenu
import prog2425.dam1.calcbasica.service.Operar
import prog2425.dam1.calcbasica.ui.Consola

fun main(args: Array<String>) {
    val consola = Consola()
    val calculadora = Operar()

// TODO: Tengo que crear las funciones aún :c

    when (args.size){
        0 -> {
            val carpetaLog = buscarCarpeta("./log")
            if (!carpetaLog){
                crearCarpeta()
                consola.mostrar("Ruta ./log creada")
            }else{
                //mostrar la más reciente"
            }
        }
        1->{
            val carpetaEncontrada = buscarCarpeta(args[0])
            if (!carpetaLog){
                crearCarpeta()
                consola.mostrar("Ruta ./log creada")
            }
            else if(carpetaEncontrada && file.exists()){
                //mostrar la más reciente"
            }
            else{
                consola.mostrar("No existen ficheros de Log")
            }
        }

        4-> {
            val rutaLog = args[0]
            val num1 = args[1].toDouble()
            val num2 = args[3].toDouble()
            val operador = args[2]

            val resultado = calculadora.calcular(num1, num2, operador)
            consola.mostrar(resultado)
            // almacenar fichero logYYYYMMDDHHMMSS.txt creado con formato val fich =
        }

        else -> {
            consola.mostrarError("Los argumentos deben ser(0,1,4)")
            return
        }
    }

    consola.pausa()
    consola.limpiarPantalla(20)
    GestorMenu(consola, calculadora).iniciarCalculadora()



}