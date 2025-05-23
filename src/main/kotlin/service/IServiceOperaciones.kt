package prog2425.dam1.calcbasica.service

import prog2425.dam1.calcbasica.model.Operacion

interface IServiceOperaciones {
    fun insertar( numero1: Double, operador: String, numero2: Double, operacion: Double )
    fun consultarOperacion(): Operacion?

}