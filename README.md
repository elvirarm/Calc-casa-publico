Este proyecto es una calculadora básica que se conecta a una base de datos H2 mediante Drive Manager, crear las tablas de Error y Operacion y almacena la información.

EJEMPLO DE CÓMO SE CREAN LAS TABLAS:

https://github.com/elvirarm/Calc-casa-publico/blob/f266cde7bf1f7d9589cf7194b50f25cfeb6bc81d/src/main/kotlin/data/dao/ErrorDAO.kt#L23-L34

https://github.com/elvirarm/Calc-casa-publico/blob/f266cde7bf1f7d9589cf7194b50f25cfeb6bc81d/src/main/kotlin/data/dao/OperacionDAO.kt#L69-L84


Ambas tablas se crean al inicializarse el dao tanto de Operación como de Error que en ambos casos se instancian en el main:

https://github.com/elvirarm/Calc-casa-publico/blob/f266cde7bf1f7d9589cf7194b50f25cfeb6bc81d/src/main/kotlin/Main.kt#L11-L19

Funciona muy parecido a la calculadora de ficheros, pero en este canso en vez de insertar una linea a través de appendText(), se hace a través de un INSERT en la tabla de la base de datos.

EJEMPLO DE CÓMO SE GUARDARÍA LA OPERACIÓN:

Así sería la llamada:

https://github.com/elvirarm/Calc-casa-publico/blob/f266cde7bf1f7d9589cf7194b50f25cfeb6bc81d/src/main/kotlin/app/GestorMenu.kt#L36-L38

Así sería la función desarrollada:

https://github.com/elvirarm/Calc-casa-publico/blob/f266cde7bf1f7d9589cf7194b50f25cfeb6bc81d/src/main/kotlin/data/dao/OperacionDAO.kt#L12-L23

EJEMPLO DE CÓMO SE GUARDARÍA EL ERROR:

Así sería la llamada:

https://github.com/elvirarm/Calc-casa-publico/blob/f266cde7bf1f7d9589cf7194b50f25cfeb6bc81d/src/main/kotlin/app/GestorMenu.kt#L45-L48

Así sería la función desarrollada:

https://github.com/elvirarm/Calc-casa-publico/blob/f266cde7bf1f7d9589cf7194b50f25cfeb6bc81d/src/main/kotlin/data/dao/ErrorDAO.kt#L12-L21
