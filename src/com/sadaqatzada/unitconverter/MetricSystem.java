package com.sadaqatzada.unitconverter;

public class MetricSystem {
    public double metersToKilometers(double meters) {
        return meters / 1000.0;
    }

    public double kilometersToMeters(double kilometers) {
        return kilometers * 1000.0;
    }

    public double gramsToKilograms(double grams) {
        return grams / 1000.0;
    }

    public double kilogramsToGrams(double kilograms) {
        return kilograms * 1000.0;
    }

    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}