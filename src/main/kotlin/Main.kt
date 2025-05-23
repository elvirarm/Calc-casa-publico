package prog2425.dam1.calcbasica

import prog2425.dam1.calcbasica.app.GestorMenu
import prog2425.dam1.calcbasica.data.dao.ErrorDAO
import prog2425.dam1.calcbasica.data.dao.OperacionDAO
import prog2425.dam1.calcbasica.service.OperacionService
import prog2425.dam1.calcbasica.service.ServiceCalculadora
import prog2425.dam1.calcbasica.service.ServiceError
import prog2425.dam1.calcbasica.ui.Consola

fun main(args: Array<String>) {
    val consola = Consola()
    val calculadora = ServiceCalculadora()
    val operacionDao = OperacionDAO()
    val errorDAO = ErrorDAO()
    val operacionService = OperacionService(operacionDao)
    val errorService = ServiceError(errorDAO)
    GestorMenu(consola, calculadora, operacionService, errorService).iniciar(args)
}

