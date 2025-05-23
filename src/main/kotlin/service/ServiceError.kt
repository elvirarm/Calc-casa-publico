package prog2425.dam1.calcbasica.service

import prog2425.dam1.calcbasica.data.dao.IErrorDAO

class ServiceError(val errorDAO: IErrorDAO): IServiceError {

    override fun guardarError(mensajeError: String){
        require (mensajeError.isNotEmpty()){"El mensaje de error no puede estar vacío"}
        errorDAO.guardarError(mensajeError)
    }

}