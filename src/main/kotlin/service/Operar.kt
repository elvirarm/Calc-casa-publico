package prog2425.dam1.calcbasica.service

class Operar: IOperaciones {

    override fun calcular(num1: Double, num2: Double, signo: String): Double?  {
        return when (signo) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> null
        }
    }
}