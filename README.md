Este proyecto se trata de una calculadora que almacena las operaciones y los errores en ficheros de texto.

¿Cómo lo he hecho?

Desde el main llamo a iniciar que es una función que según el número de argumentos que tengas hace una cosa u otra:

- 0/1 argumentos: te muestra el último log registrado e inicia la calculadora.
- 4 hace los cálculos directamente.

https://github.com/elvirarm/Calc-casa-publico/blob/8ca108ed4dc18eaf243bd22e03931fa1d1864a14/src/main/kotlin/app/GestorMenu.kt#L82-L120

Al iniciarCalculadora() que se repite hasta que el usuario elija la opción de salir.

https://github.com/elvirarm/Calc-casa-publico/blob/8ca108ed4dc18eaf243bd22e03931fa1d1864a14/src/main/kotlin/app/GestorMenu.kt#L9-L80

Por cada vuelta del bucle, el programa pide:

- Primer número (debe ser un entero)

- Signo (debe estar en la lista de operadores disponibles)

- Segundo número (misma comprobación)

Después llama a la función obtenerResultado() que llama a la calculadora para que haga el cálculo y a mostrar el resultado, después se guarda la operación.


CÓMO SE GUARDA LA OPERACIÓN:

https://github.com/elvirarm/Calc-casa-publico/blob/8ca108ed4dc18eaf243bd22e03931fa1d1864a14/src/main/kotlin/repositorio/GestorLogs.kt#L21-L33

Finalmente pregunta si quieres realizar otro cálculo que devuelve un booleano y esto lo recojo en la variable que he configurado para gestionar la salida.

Esto está envuelto en un try, por eso se guarda la operación, si fallase la operación en algún momento lo recogería el catch que muestra el error y además guarda el error con el mensaje de error que se haya producido en la excepción.

CÓMO SE GUARDA EL ERROR:
https://github.com/elvirarm/Calc-casa-publico/blob/8ca108ed4dc18eaf243bd22e03931fa1d1864a14/src/main/kotlin/repositorio/GestorLogs.kt#L35-L40
