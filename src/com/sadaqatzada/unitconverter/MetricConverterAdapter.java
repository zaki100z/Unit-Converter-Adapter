package com.sadaqatzada.unitconverter;

public class MetricConverterAdapter implements UnitConverter {
    private MetricSystem metricSystem;

    public MetricConverterAdapter(MetricSystem metricSystem) {
        this.metricSystem = metricSystem;
    }

    @Override
    public double convertLength(double value, String fromUnit, String toUnit) {
        double meters = toMeters(value, fromUnit);
        return fromMeters(meters, toUnit);
    }

    @Override
    public double convertWeight(double value, String fromUnit, String toUnit) {
        double kilograms = toKilograms(value, fromUnit);
        return fromKilograms(kilograms, toUnit);
    }

    @Override
    public double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("celsius") && toUnit.equalsIgnoreCase("kelvin")) {
            return metricSystem.celsiusToKelvin(value);
        } else if (fromUnit.equalsIgnoreCase("kelvin") && toUnit.equalsIgnoreCase("celsius")) {
            return value - 273.15;
        }
        return value;
    }

    @Override
    public String getSystem() {
        return "Metric System";
    }

    private double toMeters(double value, String unit) {
        switch (unit.toLowerCase()) {
            case "km": return metricSystem.kilometersToMeters(value);
            case "m": return value;
            case "cm": return value / 100.0;
            default: return value;
        }
    }

    private double fromMeters(double meters, String unit) {
        switch (unit.toLowerCase()) {
            case "km": return metricSystem.metersToKilometers(meters);
            case "m": return meters;
            case "cm": return meters * 100.0;
            default: return meters;
        }
    }

    private double toKilograms(double value, String unit) {
        switch (unit.toLowerCase()) {
            case "kg": return value;
            case "g": return metricSystem.gramsToKilograms(value);
            default: return value;
        }
    }

    private double fromKilograms(double kilograms, String unit) {
        switch (unit.toLowerCase()) {
            case "kg": return kilograms;
            case "g": return metricSystem.kilogramsToGrams(kilograms);
            default: return kilograms;
        }
    }
}