# Conversor de Monedas

- Importar  los paquetes: Importa las clases necesarias para manejar la entrada y salida, realizar solicitudes HTTP y manejar las respuestas HTTP.
- Declaración de la clase ConversorApp: Definir la clase principal del programa.
- Método main: Es el punto de entrada de la aplicación. Puede lanzar excepciones de entrada/salida y de interrupción.
- Creación de un objeto Scanner: Crea un objeto Scanner para leer la entrada del usuario desde la consola.
- Bucle while para el menú: Inicia un bucle infinito para que el programa pueda realizar múltiples conversiones sin necesidad de reiniciar.
- Imprime el menú y solicita la entrada del usuario: Muestra el menú y solicita al usuario que ingrese el monto a convertir.
- Imprime las opciones del menú: Muestra las opciones de conversión disponibles.
- Lee la opción seleccionada por el usuario: Lee la opción seleccionada por el usuario.
- Verifica si el usuario quiere salir: Si el usuario selecciona la opción 7, el programa muestra un mensaje de despedida y sale del bucle.
- Prepara y realiza la solicitud HTTP a la API de tasas de cambio: Construye y envía una solicitud HTTP GET a la API de exchangerate-api.com para obtener las tasas de cambio.
- Manejo de la respuesta de la API: Si la respuesta de la API es exitosa (código de estado HTTP 200), guarda el cuerpo de la respuesta en responseBody. De lo contrario, muestra un mensaje de error.
- Extracción de la tasa de cambio correspondiente: Llama a la función obtenerTasaDeCambio para obtener la tasa de cambio correspondiente a la moneda seleccionada.
- Convierte la moneda según la opción seleccionada: Utiliza un switch para seleccionar la operación de conversión y mostrar el resultado.
- Función obtenerTasaDeCambio: Extrae la tasa de cambio de la respuesta JSON de la API para la moneda especificada.
- Fin del bucle y del método main: Si no se selecciona la opción para salir, el bucle continuará ejecutándose. Una vez que se selecciona la opción de salida, el programa finaliza.

- # Probando este editor

![](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png)

![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg) ![](https://img.shields.io/github/tag/pandao/editor.md.svg) ![](https://img.shields.io/github/release/pandao/editor.md.svg) ![](https://img.shields.io/github/issues/pandao/editor.md.svg) ![](https://img.shields.io/bower/v/editor.md.svg)
