case class EjercicioIntegral(
                              id: Int,
                              funcion: Double => Double,
                              a: Double,
                              b: Double,
                              valorEsperado: Double
                            )

def integracion(f: Double => Double, a: Double, b: Double): Double =
  val x_medio = (a + b) / 2
  // Fórmula de Simpson 1/3 
  (b - a) * ((f(a) + 4 * f(x_medio) + f(b)) / 6)

def calcularError(esperado: Double, obtenido: Double): Double =
  Math.abs(esperado - obtenido)

@main def ejecutarTrabajo(): Unit =
  val ejercicios = List(
    EjercicioIntegral(1, x => -Math.pow(x, 2) + 8 * x - 12, 3, 5, 7.33),

    EjercicioIntegral(2, x => 3 * Math.pow(x, 2), 0, 2, 8.0),

    EjercicioIntegral(3, x => x + 2 * Math.pow(x, 2) - Math.pow(x, 3) + 5 * Math.pow(x, 4), -1, 1, 3.333),

    EjercicioIntegral(4, x => (2 * x + 1) / (Math.pow(x, 2) + x), 1, 2, 1.09861),

    EjercicioIntegral(5, x => Math.exp(x), 0, 1, 1.71828),

    EjercicioIntegral(6, x => 1 / Math.sqrt(x - 1), 2, 3, 0.828427),

    EjercicioIntegral(7, x => 1 / (1 + Math.pow(x, 2)), 0, 1, 0.785398)
  )

  println("--- Resultados usando Programación Funcional ---")

  val resultados = ejercicios.map { ej =>
    val valorObtenido = integracion(ej.funcion, ej.a, ej.b)
    val error = calcularError(ej.valorEsperado, valorObtenido)

    (ej.id, valorObtenido, ej.valorEsperado, error)
  }

  resultados.foreach { (id, obt, esp, err) =>
    println(s"Ejercicio $id | Esperado: $esp | Obtenido: $obt | Error: $err")
  }
