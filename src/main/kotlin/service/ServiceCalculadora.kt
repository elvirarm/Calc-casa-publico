package prog2425.dam1.calcbasica.service

class ServiceCalculadora: IServiceCalculadora {

    override fun calcular(num1: Double, num2: Double, signo: String): Double  {
        return when (signo) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            else -> num1 / num2

        }
    }
}