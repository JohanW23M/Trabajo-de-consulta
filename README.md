# Trabajo de Consulta: Implementación Funcional del Método de Simpson 1/3

Este proyecto implementa una solución para la integración numérica utilizando el **Método de Simpson 1/3**. [cite_start]El desarrollo se ha realizado estrictamente bajo el paradigma de **Programación Funcional** utilizando **Scala 3**, enfocándose en el uso de Funciones de Orden Superior (HOFs), inmutabilidad y transformación de colecciones[cite: 1, 2, 4, 6].

A continuación, se describe la arquitectura de la solución, detallando la lógica de cada función y componente implementado.

---

## 1. Modelado de Datos: `case class EjercicioIntegral`

Para manejar los 7 ejercicios propuestos de manera ordenada y evitar el uso de variables sueltas, se optó por modelar la estructura de un problema de integración mediante una `case class`.

### Lógica y Propósito
En Scala, una `case class` es ideal para modelar datos inmutables. Nos permite agrupar todos los parámetros necesarios para definir una integral definida específica en un solo objeto.

### Definición
```scala
case class EjercicioIntegral(
    id: Int,                   // Identificador del ejercicio (ej. 1, 2, 3...)
    funcion: Double => Double, // La función matemática 'f(x)' a integrar
    a: Double,                 // Límite inferior de integración
    b: Double,                 // Límite superior de integración
    valorEsperado: Double      // El resultado matemático real para comparar
)
