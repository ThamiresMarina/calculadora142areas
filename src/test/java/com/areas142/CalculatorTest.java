package com.areas142;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.Calculator;

import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;



public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    
    @Test
    public void testAreaQuadrado() {
        assertEquals(25.0, calculator.calcularAreaQuadrado(5.0), 0.001);
    }
    
    @Test
    public void testAreaRetangulo() {
        assertEquals(24.0, calculator.calcularAreaRetangulo(4.0, 6.0), 0.001);
    }
    
    @ParameterizedTest
    @CsvSource({
        "5.0, 3.0, 15.0",    // base, altura, área esperada
        "2.0, 2.0, 4.0",     // quadrado especial
        "10.0, 5.0, 50.0",   // retângulo grande
        "1.5, 2.0, 3.0",     // números decimais
        "0.5, 1.0, 0.5",     // base menor que 1
        "100.0, 0.5, 50.0"   // altura menor que 1
    })
    public void testAreaRetanguloDataDriven(double base, double altura, double areaEsperada) {
        double resultado = calculator.calcularAreaRetangulo(base, altura);
        assertEquals(areaEsperada, resultado, 0.001,
            String.format("Base: %.1f, Altura: %.1f - Área esperada: %.1f, mas obteve: %.1f",
                base, altura, areaEsperada, resultado));
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/dados_triangulo.csv", numLinesToSkip = 1)
    public void testAreaTrianguloFromCSV(double base, double altura, double areaEsperada, String descricao) {
        double resultado = calculator.calcularAreaTriangulo(base, altura);
        assertEquals(areaEsperada, resultado, 0.001,
            String.format("Falha no teste do %s - Base: %.1f, Altura: %.1f - Área esperada: %.1f, mas obteve: %.1f",
                descricao, base, altura, areaEsperada, resultado));
    }
    
    @Test
    public void testAreaCirculo() {
        assertEquals(28.27433, calculator.calcularAreaCirculo(3.0), 0.001);
    }
}



