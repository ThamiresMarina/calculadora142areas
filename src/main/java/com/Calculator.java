package com;


    
public class Calculator {
    // Calcula a área do quadrado (lado * lado)
    public double calcularAreaQuadrado(double lado) {
        return lado * lado;
    }
    
    // Calcula a área do retângulo (base * altura)
    public double calcularAreaRetangulo(double base, double altura) {
        return base * altura;
    }
    
    // Calcula a área do círculo (π * raio²)
    public double calcularAreaCirculo(double raio) {
        return Math.PI * raio * raio;
    }
    
    // Calcula a área do triângulo (base * altura / 2)
    public double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }
}
    

