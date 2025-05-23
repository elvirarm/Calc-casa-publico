package prog2425.dam1.calcbasica.data.dao

import prog2425.dam1.calcbasica.model.Operacion

interface IOperacionDAO {

    fun insertar(id: String, numero1: Double, operador: String, numero2: Double, resultado: Double)
    fun consultarOperacion(): Operacion?

}