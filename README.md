# Trabajo de Consulta: Programación Funcional y Reactiva

Este proyecto implementa una solución de **Integración Numérica** utilizando el **Método de Simpson 1/3**, desarrollado enteramente bajo el paradigma de **Programación Funcional** en **Scala 3**.

El objetivo principal es demostrar el uso de Funciones de Orden Superior (Higher Order Functions), inmutabilidad y transformaciones sobre colecciones.

## 1. Objetivos del Trabajo
* **Aplicar funciones de orden superior:** Pasar funciones matemáticas como parámetros a otras funciones.
* **Uso de Case Classes y Colecciones:** Modelar los datos de entrada de forma estructurada e inmutable.
* **Transformaciones Funcionales:** Utilizar métodos como `.map` para procesar lotes de ejercicios sin bucles imperativos.

## 2. Marco Teórico: Método de Simpson 1/3
La regla de Simpson 1/3 permite aproximar el valor de una integral definida mediante la siguiente fórmula:

$$\int_{a}^{b}f(x)dx \cong (b-a) \frac{f(a) + 4f(\bar{x}) + f(b)}{6}$$

Donde el punto medio $\bar{x}$ es:
$$\bar{x} = \frac{a+b}{2}$$

También se calcula el **Error Absoluto** comparando con el valor matemático esperado:
$$Error = |ValorEsperado - ValorObtenido|$$

## 3. Implementación Técnica

La solución se ha diseñado siguiendo los patrones de diseño funcionales vistos en clase:

### 3.1 Modelado de Datos (`case class`)
Se utiliza una `case class` para encapsular la definición de cada ejercicio (integral), lo que permite manejar una lista de objetos inmutables.

```scala
case class EjercicioIntegral(
    id: Int, 
    funcion: Double => Double, // La función matemática a integrar
    a: Double,                 // Límite inferior
    b: Double,                 // Límite superior
    valorEsperado: Double      // Valor real para cálculo de error
)
