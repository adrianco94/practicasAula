# practicasAula

# Opcion Registro

En el archivo Registro.java creo un array de String con 4 posiciones (con valor null al principio), donde guardaré
los mensajes de error de los cuatro posibles en caso de que existan.
Un array de enteros con el número de días de cada mes. Cambiaré el valor de la posición de febrero en caso que el año sea bisiesto con la función esBisiesto().
Comprebo si hay uno o varios mensajes que no sean nulos del array de errores, si hay alguno quiere decir que existen errores. En caso
contrario mostraré los datos.
Si hay errores muestros los mensajes de error del array de erroes, sin mostrar los valores null. Luego en salidas out.println escribo de nuevo
el documento html embebido, pero esta vez dándole el valor introducido anteriormente en los atributos value. Un checked en el caso del sexo y 
un selected en el caso de los tres valores de la fecha.
*No he podido todavía recuperar los valores de las aficiones guardados

En el caso de que no haya fallos creo un array con los nombres de los meses para la fecha, además de un String vacío para almacenar el texto de 
la fecha a mostrar. Recorro con un Enumeration los valores de los datos introducidos. A excepción de un par de casos muestro por cada ejecución del bucle los valores de los atributos name y value. En el caso de la fecha tengo tres condiciones en el bucle, uno para si es dia, otra para mes, y otra para el año. Cuando llega al dia añado su valor al string, cuando llega el mes añado su valor en letras ayudandome del arrya antes creado y cuando llega el año lo añado al texto y muestro la fecha completa. En el caso de las aficiones extraigo todos los valores y con un bucle recorro el array de valores y los añado a un String que al acabar la ejecución del bucle muestro.

#Opcion EdadPersona
Dos inputs tipo texto y date.
Utilizando la función substring sobre el valor de la fecha, almaceno en tres enteros el día , el mes y la fecha de nacimiento.
Utilizando el método of() de la clase LocalDate me creo un objeto de esta pasandole los tres enteros anteriormente creados.
Utilizando el metodo between() de la clase Period me creo un objeto de esta pasandole la fecha anteriormente creada y la actual (metodo now())
Creo una cadena donde almacenaré el texto a mostrar.
Dependiendo del valor en cada uno de los casos:  no añado nada si el valor es 0, si el valor es uno añado 1 dia/mes/año depende del caso, y si es dos obtengo el valor con el request y añado  dias/meses/años  depende del caso.

#Opcion Calculadora
Al principio no debe aparecer un mensaje de respuesta, por ello controlo que el boton eliminar no se nulo.
Creo un String donde guardare lo que saldrá al enviar los datos.
Primero compruebo que no hay ningún campo vacío. Si lo hay guardaré en lo habré guardado en la cadena y se mostrará el mensaje pertinente.
Si no están vacío comprobaré si son números enteros con el parseFloat, si no lo son capturaré la excepción y mostraré el mensjae pertienente al enviar los datos.
En el caso de que se puedan convertir a tipo Float compruebo la opción de operación que ha elegido el usuario, en cada casa realizaré la operación pedida y guardaré el texto en el string que luego mostraré.
