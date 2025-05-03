package prog2425.dam1.calcbasica.ui

interface IEntradaSalida {

    fun pedirNum(msj: String = "Introduce un número"): Double

    fun pedirSigno(msj: String = "Introduce un operador"): String

    fun pedirInfo(msj: String): String

    fun <T> mostrar(msj: T)

    fun mostrarError(msj: String)

    fun limpiarPantalla(numSaltos:Int)

    fun pausa()
    }
