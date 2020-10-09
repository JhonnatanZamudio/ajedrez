# Aplicación para prueba de ingreso como desarollador senior Android

Para el diseño de esta aplicación se divide en 3 Etapas, que a continuación se describen:

1. ETAPA DE DISEÑO
   - Se propuso una colorimetria para la aplicación.
   - Se diseñaron los iconos cuadrado y redondos para la aplicación.
   - Se propuso el diseño de una pantalla de Home
   - Se propuso el diseño de una pantalla de configuración.
   - Se propuso el diseño de una pantalla tipo tablero de ajedrez.

2. ETAPA DE IMPLEMENTACIÓN
   
   Para el desarrollo de esta aplicación móvil se empleo el IDE Android Studio 4.0.1, con nombre de aplicación ajedrez y nombre de paquete: com.jhonnatan.ajedrez, todo se programa en lenguaje JAVA y disponible para API 21 en adelante, a continuación se mencionana alguna de las funciones mas relevantes para la implementación de la aplicación en ANDROID:
   - Se define un Background general y se crea un archivo botón_redondo.xml con el fin de dar forma circular a los botones, se agregaron las fuentes tipográficas, se integra un elemento tipo Button y un TextView.
   - Se configuro la función del botón atrás, declaración de variables, definición de instancias, creación de funciones al dar clic en cualquiera de los casos redirigiendo a la pantalla Tablero y se implementaron animaciones en la transición de pantallas.
   - Primero se define la forma de identificar las casillas en el tablero de forma dinámica.
   - Se crea una función para capturar los datos del activity anterior con el fin de enviar el número del Caso, posición del Alfil y posición de la Torre.
   - La función de condiciones iniciales, convierte el valor de la posición de las fichas en números enteros y verifica si esta en una casilla blanca o Negra (Estado 0 = Negra y Estado 1 = Blanca).
   - Se implemento una función que realiza el calculo de las posibles posiciones que puede tener la ficha en caso de alfil (Se verificaron las diagonales) y en caso de la torre (Se verificaron horizontales y verticales.)
   - Se implemento función para mostrar las celdas que puede desplazarse según sea el caso que corresponda. (Alfil o Torre)
   - Se creo función para detectar cuando un usuario da clic en cualquier celda del tablero de ajedrez.
   - Se implemento una función para validar si en el caso 1 el Alfil captura o no la Torre al dar clic.
   - Se implementa un AlertDialog para mostrar los mensajes personalizados de la aplicación.
   - Se realizo una función para dar continuidad al juego en el tercer caso hasta que el alfil o la torre capture la otra ficha.

3. ETAPA DE PRUEBAS

    Para verificar el correcto funcionamiento de la aplicación se realizó la instalación de la aplicación en un dispositivo Trimble TDC-100 cuya versión de sistema es Android 6.0.1
  
