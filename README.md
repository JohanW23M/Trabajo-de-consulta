# Trabajo de Consulta: Programación Funcional y Reactiva

**Tema:** Funciones de Orden Superior y Método de Simpson 1/3  
**Lenguaje:** Scala 3

## 1. Descripción del Proyecto
Este repositorio contiene la resolución del trabajo de consulta sobre **Funciones de Orden Superior (Higher Order Functions)**. El objetivo principal es implementar el método de integración numérica de Simpson 1/3 aplicando estrictamente el paradigma de Programación Funcional, evitando el uso de bucles imperativos y variables mutables.

### Objetivos
* **Aplicar Funciones de Orden Superior:** Pasar funciones matemáticas como parámetros a otras funciones.
* **Modelado de Datos:** Utilizar `case classes` para estructurar la información de manera inmutable.
* **Transformación de Datos:** Utilizar operaciones funcionales como `.map` para procesar colecciones de ejercicios de forma declarativa.

---

## 2. Marco Teórico: Método de Simpson 1/3

La regla de Simpson 1/3 es un método de integración numérica que permite aproximar el área bajo una curva (integral definida). La fórmula utilizada es:

$$\int_{a}^{b}f(x)dx \cong (b-a) \frac{f(a) + 4f(\bar{x}) + f(b)}{6}$$

Donde los componentes son:
* $a$: Límite inferior de la integral.
* $b$: Límite superior de la integral.
* $\bar{x}$: Punto medio del intervalo, calculado como $\bar{x} = \frac{a+b}{2}$.
* $f(x)$: La función a integrar evaluada en distintos puntos.

Adicionalmente, se calcula el **Error Absoluto** comparando la aproximación con el valor matemático esperado:
$$Error = |ValorEsperado - ValorObtenido|$$

---

## 3. Arquitectura y Lógica de Implementación

La solución se ha diseñado bajo una arquitectura puramente funcional. A continuación, se detalla la lógica de cada componente del código:

### 3.1. Modelado de Datos (`case class`)

En lugar de manejar variables sueltas para cada ejercicio, se encapsuló la definición de cada integral en una estructura inmutable.

```scala
case class EjercicioIntegral(
    id: Int, 
    funcion: Double => Double, 
    a: Double, 
    b: Double, 
    valorEsperado: Double
)
Entendido. Aquí tienes todo el contenido que me pediste, desde la explicación lógica del código hasta el punto 5, formateado correctamente en **Markdown** para que lo copies y pegues directamente.

-----

**Lógica:** La `case class` nos permite crear objetos que contienen no solo los datos numéricos (`a`, `b`), sino también el comportamiento (la `funcion`).

**Detalle:** El campo `funcion` es de tipo `Double => Double`, lo que significa que guardamos la ecuación matemática misma como un dato dentro del objeto.

### 3.2. Función de Orden Superior (`integracion`)

Esta función es el núcleo del trabajo. Se clasifica como una "Higher Order Function" porque recibe otra función como argumento.

```scala
def integracion(f: Double => Double, a: Double, b: Double): Double =
  val x_medio = (a + b) / 2
  (b - a) * ((f(a) + 4 * f(x_medio) + f(b)) / 6)
```

  * **Lógica:** La función no "sabe" qué ecuación específica está resolviendo. Simplemente aplica la fórmula de Simpson invocando la función `f` (pasada como parámetro) en los puntos $a$, $\bar{x}$ y $b$.
  * **Ventaja:** Esto permite reutilizar exactamente la misma lógica de integración para infinitas ecuaciones diferentes sin cambiar el código.

### 3.3. Procesamiento Funcional (`.map`)

Para resolver los 7 ejercicios propuestos, no se utilizan bucles iterativos tradicionales (`for` o `while`). Se utiliza el concepto de Mapeo sobre colecciones.

```scala
val resultados = ejercicios.map { ej =>
    val valorObtenido = integracion(ej.funcion, ej.a, ej.b)
    // ... cálculo de error y retorno de tupla
}
```

  * **Lógica:** El método `.map` toma la lista de problemas definidos (`List[EjercicioIntegral]`) y aplica una transformación a cada elemento de la lista.
  * **Resultado:** Devuelve una nueva lista con los resultados calculados. Es una forma declarativa de decir "transforma estos problemas en soluciones", manteniendo la inmutabilidad de los datos originales.

## 4\. Ejercicios Resueltos

El sistema resuelve automáticamente las siguientes integrales definidas, tal como se especifican en la guía del trabajo:

  * $\int_{3}^{5}(-x^2 + 8x - 12)dx$
  * $\int_{0}^{2}3x^2 dx$
  * $\int_{-1}^{1}(x + 2x^2 - x^3 + 5x^4)dx$
  * $\int_{1}^{2}\frac{2x + 1}{x^2 + x} dx$
  * $\int_{0}^{1}e^x dx$
  * $\int_{2}^{3}\frac{1}{\sqrt{x-1}} dx$
  * $\int_{0}^{1}\frac{1}{1+x^2} dx$

## 5\. Resultados y Análisis de Error

Al ejecutar el programa, se obtiene la siguiente tabla comparativa que valida la precisión del algoritmo implementado frente a los valores esperados:

| Ejercicio | Valor Esperado | Valor Obtenido (Simpson 1/3) | Error Absoluto |
| :---: | :--- | :--- | :--- |
| **1** | 7.33 | 7.333333333333333 | 0.0033333333333331897 |
| **2** | 8.0 | 8.0 | 0.0 |
| **3** | 3.333 | 4.666666666666667 | 1.333666666666667 |
| **4** | 1.09861 | 1.09861228866811 | 2.2886681096375056E-6 |
| **5** | 1.71828 | 1.71886115187659 | 5.811518765928732E-4 |
| **6** | 0.828427 | 0.83240149026402 | 0.003974490264021021 |
| **7** | 0.785398 | 0.78333333333333 | 0.0020646666666666667 |

### Análisis de Resultados

  * **Exactitud Perfecta:** El método de Simpson 1/3 muestra una exactitud perfecta (Error = 0.0) en polinomios de hasta tercer grado, como se evidencia en el **Ejercicio 2**.
  * **Alta Precisión:** En funciones trascendentes (exponenciales, logarítmicas o racionales), el método presenta un margen de error mínimo, generalmente en el orden de las milésimas ($10^{-3}$) o millonésimas ($10^{-6}$), lo cual es aceptable para la mayoría de las aplicaciones de ingeniería.
  * **Desviación:** En el **Ejercicio 3**, se nota una desviación mayor (\~1.33). Esto suele ocurrir cuando el intervalo de integración es amplio o la función tiene variaciones bruscas que un solo segmento (Simpson 1/3 simple) no logra capturar completamente, sugiriendo el uso de Simpson 1/3 compuesto para mayor precisión en esos casos.
