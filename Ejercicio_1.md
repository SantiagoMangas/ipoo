# Apuntes: Java - Identificadores, Tipos y Casting

### A. Averigüe las reglas que impone Java para los nombres de los identificadores.
- Tienen que arrancar con una letra, el signo peso (`$`) o guion bajo (`_`). Después le podés meter números.
- Ojo con las mayúsculas: `Variable` y `variable` son dos cosas distintas (case sensitive).
- No podés usar palabras reservadas del lenguaje (como `class`, `int`, `while`, `true`, `null`).

* Clases e Interfaces: Utilizan *UpperCamelCase* (PascalCase). Comienzan con mayúscula.
  * *Ejemplos:* `CuentaBancaria`, `Alumno`, `ListaPersona`.
* Variables y Métodos: Utilizan *lowerCamelCase*. Comienzan con minúscula.
  * *Ejemplos:* `saldoActual`, `calcularPromedio()`, `nombreEstudiante`.
* Constantes: Van completamente en MAYÚSCULAS, con palabras separadas por guiones bajos.
  * *Ejemplos:* `VALOR_MAXIMO`, `PI`, `TAMANIOS_DEFAULT`.

### B. Confeccione una tabla que muestre para cada uno de los tipos elementales el conjunto de valores que permite representar y el valor que toma por omisión.
*(Nota: el valor por defecto solo aplica si son variables de clase/atributos, no en variables locales dentro de un método).*

| Tipo Primitivo | Tamaño (Bits) | Conjunto / Rango de Valores Representables | Valor por Omisión (Atributos) |
| :--- | :---: | :--- | :---: |
| `byte` | 8 bits | Ente entero con signo: $[-128 	ext{ a } 127]$ | `0` |
| `short` | 16 bits | Ente entero con signo: $[-32.768 	ext{ a } 32.767]$ | `0` |
| `int` | 32 bits | Entero con signo: $[-2.147.483.648 	ext{ a } 2.147.483.647]$ | `0` |
| `long` | 64 bits | Entero con signo: $[-9.223.372.036.854.775.808 	ext{ a } 2^{63}-1]$ | `0L` |
| `float` | 32 bits | Puntos flotantes IEEE 754 (Precisión simple $ pprox \pm 1.4	imes 10^{-45}$ a $\pm 3.4	imes 10^{38}$) | `0.0f` |
| `double` | 64 bits | Puntos flotantes IEEE 754 (Precisión doble $ pprox \pm 4.9	imes 10^{-324}$ a $\pm 1.8	imes 10^{308}$) | `0.0d` |
| `char` | 16 bits | Carácter Unicode no firmado (` ` a `?` / $0$ a $65.535$) | `' '` (Carácter Nulo) |
| `boolean` | 1 bit* | Lógico: `true` o `false` | `false` |

### C. Describa las reglas de compatibilidad de los tipos de Java y el mecanismo de casting para los tipos elementales. 
- **Automática (Widening):** Pasa sola cuando metés un tipo de dato chico en uno más grande (ej. de `int` a `long`). Como hay espacio de sobra, Java lo hace sin que le digas nada.
- **Forzada (Casting / Narrowing):** Cuando querés meter algo grande en un contenedor más chico (ej. de `double` a `int`). Java te obliga a confirmarlo explícitamente poniendo el tipo destino entre paréntesis, por ejemplo: `int numero = (int) 8.99;`. Ojo porque acá perdés información (el número te queda en `8` porque recorta los decimales).
* **Ejemplo con pérdida de decimales:**
  ```java
  double pi = 3.14159;
  int enteroPi = (int) pi; // enteroPi tomará el valor 3 (se trunca la parte decimal)
  ```
* **Ejemplo con desbordamiento (*Overflow*):**
  ```java
  int grande = 130;
  byte pequenio = (byte) grande; // byte soporta hasta 127. 'pequenio' resultará en -126
  ```
  
- **Boolean:** Va por su cuenta. No podés convertir un número a boolean ni un boolean a número, son totalmente incompatibles con el resto.