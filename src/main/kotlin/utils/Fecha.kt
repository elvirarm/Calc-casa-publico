package prog2425.dam1.calcbasica.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Fecha {
    companion object{
        fun obtenerFechaActual(): String{
            return DateTimeFormatter.ofPattern("YYYYMMddhhmmss").format(LocalDateTime.now())
        }
    }
}