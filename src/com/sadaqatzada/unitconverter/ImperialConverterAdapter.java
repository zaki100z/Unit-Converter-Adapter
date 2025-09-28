package com.sadaqatzada.unitconverter;

public class ImperialConverterAdapter implements UnitConverter {
    private ImperialSystem imperialSystem;

    public ImperialConverterAdapter(ImperialSystem imperialSystem) {
        this.imperialSystem = imperialSystem;
    }

    @Override
    public double convertLength(double value, String fromUnit, String toUnit) {
        double feet = toFeet(value, fromUnit);
        return fromFeet(feet, toUnit);
    }

    @Override
    public double convertWeight(double value, String fromUnit, String toUnit) {
        double pounds = toPounds(value, fromUnit);
        return fromPounds(pounds, toUnit);
    }

    @Override
    public double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("fahrenheit") && toUnit.equalsIgnoreCase("rankine")) {
            return imperialSystem.fahrenheitToRankine(value);
        } else if (fromUnit.equalsIgnoreCase("rankine") && toUnit.equalsIgnoreCase("fahrenheit")) {
            return value - 459.67;
        }
        return value;
    }

    @Override
    public String getSystem() {
        return "Imperial System";
    }

    private double toFeet(double value, String unit) {
        switch (unit.toLowerCase()) {
            case "mi": return imperialSystem.milesToFeet(value);
            case "ft": return value;
            case "in": return value / 12.0;
            default: return value;
        }
    }

    private double fromFeet(double feet, String unit) {
        switch (unit.toLowerCase()) {
            case "mi": return imperialSystem.feetToMiles(feet);
            case "ft": return feet;
            case "in": return feet * 12.0;
            default: return feet;
        }
    }

    private double toPounds(double value, String unit) {
        switch (unit.toLowerCase()) {
            case "lb": return value;
            case "oz": return imperialSystem.ouncesToPounds(value);
            default: return value;
        }
    }

    private double fromPounds(double pounds, String unit) {
        switch (unit.toLowerCase()) {
            case "lb": return pounds;
            case "oz": return imperialSystem.poundsToOunces(pounds);
            default: return pounds;
        }
    }
}