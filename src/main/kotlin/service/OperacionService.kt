package prog2425.dam1.calcbasica.service

import prog2425.dam1.calcbasica.data.dao.IOperacionDAO
import prog2425.dam1.calcbasica.model.Operacion
import prog2425.dam1.calcbasica.utils.Fecha

class OperacionService(val operacionDao: IOperacionDAO): IServiceOperaciones {

    override fun insertar( numero1: Double, operador: String, numero2: Double, operacion: Double ) {
        val id = Fecha.obtenerFechaActual()
        operacionDao.insertar( id, numero1, operador, numero2, operacion )
    }

    override fun consultarOperacion(): Operacion? {
        return operacionDao.consultarOperacion()
    }
}