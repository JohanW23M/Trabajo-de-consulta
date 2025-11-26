# Trabajo de Consulta: Programación Funcional y Reactiva

**Tema:** Funciones de Orden Superior y Método de Simpson 1/3  
**Lenguaje:** Scala 3

## 1. Descripción del Proyecto
Este repositorio contiene la resolución del trabajo de consulta sobre **Funciones de Orden Superior (Higher Order Functions)**. El objetivo principal es implementar el método de integración numérica de Simpson 1/3 aplicando estrictamente el paradigma de Programación Funcional, evitando el uso de bucles imperativos y variables mutables.

### Objetivos
1.  **Aplicar Funciones de Orden Superior:** Pasar funciones matemáticas como parámetros a otras funciones.
2.  **Modelado de Datos:** Utilizar `case classes` para estructurar la información.
3.  **Transformación de Datos:** Utilizar operaciones funcionales como `.map` para procesar colecciones.

---

## 2. Marco Teórico: Método de Simpson 1/3

La regla de Simpson 1/3 es un método de integración numérica que permite aproximar el área bajo una curva. La fórmula utilizada es:

$$\int_{a}^{b}f(x)dx \cong (b-a) \frac{f(a) + 4f(\bar{x}) + f(b)}{6}$$

Donde los componentes son:
* $a$: Límite inferior de la integral.
* $b$: Límite superior de la integral.
* $\bar{x}$: Punto medio del intervalo, calculado como $\bar{x} = \frac{a+b}{2}$.
* $f(x)$: La función a integrar evaluada en distintos puntos.

Adicionalmente, se calcula el **Error Absoluto** respecto al valor esperado:
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
