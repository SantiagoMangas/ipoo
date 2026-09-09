EJERCICIO 1.

• Describa el modelo computacional de la programación orientada a objetos.

El modelo computacional que propone la POO es un mundo poblado de objetos que se comunican a traves de mensajes. A diferencia del paradigma estructurado (donde los datos y los procedimientos están separados), en la POO los datos y la lógica que los manipula se encuentran encapsulados dentro de una misma unidad funcional. El cómputo avanza cuando los objetos reciben peticiones de servicio (mensajes), ejecutan sus métodos asociados para responder y, de ser necesario, modifican su estado interno o solicitan servicios a otros objetos.
Tiene 2 perspectivas:
Perspectiva Dinamica: Durante la ejecucion de un programa, el computo se inicia cunaod un objeto recibe un mensaje y, en respuesta a el, envia mensajes a otros objetos para solicitar o brindar servicios
Perspectiva Estatica: Desde un punto de vista estatico, un sistema poo consiste en una coleccion de clases relaciadas. 

• Defina los conceptos de objeto, clase, comando y consulta.

Objeto: 
El término se utiliza para referirse a dos conceptos relacionados:  
Objeto del problema: Entidad física o conceptual (identificada en los requerimientos o diseño) caracterizada a través de atributos y comportamiento (servicios que brinda y responsabilidades que asume). 
Objeto de software: Modelo o representación en memoria de un objeto del problema durante la ejecución. Tiene una identidad y un estado interno (mantiene los valores de los atributos) y responde a mensajes ejecutando servicios.  
Clase:
Desde el diseño, es un patrón o molde que establece los atributos y el comportamiento de un conjunto de objetos.  
Desde la implementación, es un módulo de software que puede construirse, verificarse y depurarse con cierta independencia de los demás. Define además un tipo de dato a partir del cual se pueden declarar variables.  
Comando: Es un método (servicio) que, al ejecutarse, modifica el valor de uno o más atributos del objeto que recibió el mensaje.  
Consulta: Es un método (servicio) que, al ejecutarse, no modifica el valor de ningún atributo del objeto que recibió el mensaje. Por lo general, calcula o retorna un valor.  

• Explique qué es un constructor, cómo se define y usa en Java y para qué sirve.

Un constructor es un servicio especial provisto por la clase que se invoca especificamente para crear un objeto. Habitualmente sirve para inicializar los valores de los atributos de instancia y reservar la memoria requerida por el objeto de software.
Se caracteriza por recibir exactamente el mismo nombre que la clase, no lleva tipo de retorno y una clase puede ofrecer multiples constructores siempre que tengan diferente numero o tipo de parametros. Si no se define ninguno de forma explicita, el compilador crea automaticamente uno por omision.
Se invoca externamente mediante la palabra clave new seguida del nombre de la clase y los argumentos requeridos

• Explique por qué la programación orientada a objetos favorece la productividad del software.

Descomposición e Integración Modular: Permite dividir problemas complejos de gran escala en subproblemas más simples (módulos/clases). Cada clase se puede construir, probar, verificar y depurar de manera independiente antes de integrarse a la solución global.  
Reusabilidad a través de Paquetes: Los paquetes permiten agrupar clases con características comunes para ser reutilizadas en otros sistemas sin tener que reimplementarlas ni conocer su código interno. 
Mantenibilidad y Ocultamiento de Información: Al declarar los atributos como privados (private), los valores solo pueden ser accedidos o modificados a través de los servicios públicos de la clase. Si cambia la representación interna de una clase, el impacto se aísla sin alterar a las clases clientes. 

• ¿Qué es la programación basada en eventos? 

Es un modelo de ejecución en el que el flujo del programa no sigue una secuencia fija o lineal, sino que se desencadena en respuesta a eventos o estímulos.  
Un evento es una acción (como la entrada de datos por consola, la lectura de un archivo o la interacción a través de una Interfaz Gráfica de Usuario / GUI). El sistema permanece a la espera de dicho suceso y, cuando ocurre, ejecuta el método asociado al servicio solicitado.  