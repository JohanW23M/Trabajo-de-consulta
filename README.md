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
Lógica: La case class nos permite crear objetos que contienen no solo los datos numéricos (a, b), sino también el comportamiento (la funcion).Detalle: El campo funcion es de tipo Double => Double, lo que significa que guardamos la ecuación matemática misma como un dato.3.2. Función de Orden Superior (integracion)Esta es el núcleo del trabajo. Es una "Higher Order Function" porque recibe otra función como argumento.Scaladef integracion(f: Double => Double, a: Double, b: Double): Double =
  val x_medio = (a + b) / 2
  (b - a) * ((f(a) + 4 * f(x_medio) + f(b)) / 6)
Lógica: La función no "sabe" qué ecuación está resolviendo. Simplemente aplica la fórmula de Simpson invocando la función f que se le pasa como parámetro en los puntos $a$, $\bar{x}$ y $b$. Esto permite reutilizar la misma lógica de integración para infinitas ecuaciones diferentes.3.3. Procesamiento Funcional (.map)Para resolver los 7 ejercicios, no se utilizan bucles for o while. Se utiliza el concepto de Mapeo.Scalaval resultados = ejercicios.map { ej =>
    val valorObtenido = integracion(ej.funcion, ej.a, ej.b)
    // ... cálculo de error y retorno de tupla
}
Lógica: El método .map toma la lista de problemas (List[EjercicioIntegral]) y aplica una transformación a cada elemento, devolviendo una nueva lista con los resultados. Es una forma declarativa de decir "transforma estos problemas en soluciones".4. Ejercicios ResueltosEl sistema resuelve automáticamente las siguientes integrales definidas propuestas en el trabajo:$\int_{3}^{5}(-x^2 + 8x - 12)dx$$\int_{0}^{2}3x^2 dx$$\int_{-1}^{1}(x + 2x^2 - x^3 + 5x^4)dx$$\int_{1}^{2}\frac{2x + 1}{x^2 + x} dx$$\int_{0}^{1}e^x dx$$\int_{2}^{3}\frac{1}{\sqrt{x-1}} dx$$\int_{0}^{1}\frac{1}{1+x^2} dx$5. Resultados y Análisis de ErrorAl ejecutar el programa, se obtiene la siguiente tabla comparativa que valida la precisión del algoritmo implementado:EjercicioValor EsperadoValor Obtenido (Simpson 1/3)Error Absoluto17.337.3333333333333330.003333333333333189728.08.00.033.3334.6666666666666671.33366666666666741.098611.098612288668112.2886681096375056E-651.718281.718861151876595.811518765928732E-460.8284270.832401490264020.00397449026402102170.7853980.783333333333330.0020646666666666667AnálisisExactitud: El método muestra exactitud perfecta en polinomios de grado 2 (Ejercicio 2).Aproximación: En funciones trascendentes (exponenciales, racionales), el método presenta un margen de error muy pequeño (del orden de milésimas o millonésimas).
