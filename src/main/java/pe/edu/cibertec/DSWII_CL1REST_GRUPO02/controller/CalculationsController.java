package pe.edu.cibertec.DSWII_CL1REST_GRUPO02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationsController {

    @GetMapping("/calcularSalario/{horasTrabajadas}")
    public double calcularSalario(@PathVariable int horasTrabajadas) {
        double salario = 0;
        if (horasTrabajadas <= 40) {
            salario = horasTrabajadas * 16;
        } else {
            salario = (40 * 16) + ((horasTrabajadas - 40) * 20);
        }
        return salario;
    }

    @GetMapping("/calcularPromedio/{nota1}/{nota2}/{nota3}/{nota4}")
    public double calcularPromedio(@PathVariable double nota1,
                                   @PathVariable double nota2,
                                   @PathVariable double nota3,
                                   @PathVariable double nota4) {
        // Encuentra la nota mínima
        double notaMinima = Math.min(Math.min(nota1, nota2), Math.min(nota3, nota4));

        // Calcula el promedio eliminando la nota mínima
        double promedio = (nota1 + nota2 + nota3 + nota4 - notaMinima) / 3;
        return promedio;
    }

    @GetMapping("/segundosAMinutos/{segundos}")
    public double segundosAMinutos(@PathVariable int segundos) {
        return segundos / 60.0;
    }

    @GetMapping("/sumaSerie/{limite}")
    public int sumaSerie(@PathVariable int limite) {
        int suma = 0;
        for (int i = 1; i <= limite; i++) {
            suma += i;
        }
        return suma;
    }

    @GetMapping("/cuadradoMitad/{inicio}/{fin}")
    public String cuadradoMitad(@PathVariable int inicio, @PathVariable int fin) {
        StringBuilder resultado = new StringBuilder();
        for (int i = inicio; i <= fin; i++) {
            double cuadrado = i * i;
            double mitad = i / 2.0;
            resultado.append("Número: ").append(i).append(", Cuadrado: ").append(cuadrado).append(", Mitad: ").append(mitad).append("\n");
        }
        return resultado.toString();
    }

}

