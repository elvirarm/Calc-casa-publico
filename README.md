[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/6POAAJRN)
# CalcBasica_POO

Crea una calculadora básica que pida dos números y un operador (+, -, *, /) con las operaciones de cálculo básicas: suma, resta, multiplicación y división.

Podéis partir del siguiente ejemplo "simple" de programación estructurada:

```kotlin
fun main() {
    val scanner = Scanner(System.`in`)

    println("Introduce el primer número:")
    val numero1 = scanner.nextDouble()
    println("Introduce el operador (+, -, *, /):")
    val operador = scanner.next()[0]
    println("Introduce el segundo número:")
    val numero2 = scanner.nextDouble()

    val resultado = when (operador) {
        '+' -> numero1 + numero2
        '-' -> numero1 - numero2
        '*' -> numero1 * numero2
        '/' -> numero1 / numero2
        else -> "Operador no válido"
    }

    println("Resultado: $resultado")
}
```

* El programa debe mostrar los errores de forma controlada en consola o el resultado de la operación. Por último siempre preguntará si desea realizar otro cálculo (si contesta en positivo vuelve a realizar un nuevo cálculo, sino sale de la aplicación).

* El proyecto debe ser de tipo "Gradle" y solucionarse mediante la POO *(utilizando los principios SOLID, en este caso básicamente DIP)*

* **Debe cumplir** La función `main()` solo puede tener una línea de código!!!
