package org.example;

public class Monom {

    private int exponent;
    private Double coeficient;

    public Monom(Double coeficient, int exponent) {
        this.exponent = exponent;
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public Double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }
}