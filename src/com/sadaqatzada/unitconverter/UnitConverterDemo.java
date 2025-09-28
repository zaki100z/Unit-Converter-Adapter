package com.sadaqatzada.unitconverter;

public class UnitConverterDemo {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern: Unit Conversion System ===\n");

        UnitConverter converter = new UniversalUnitConverter();

        System.out.println("LENGTH CONVERSIONS:");
        demonstrateLengthConversions(converter);

        System.out.println("\nWEIGHT CONVERSIONS:");
        demonstrateWeightConversions(converter);

        System.out.println("\nTEMPERATURE CONVERSIONS:");
        demonstrateTemperatureConversions(converter);

        System.out.println("\nCROSS-SYSTEM CONVERSIONS:");
        demonstrateCrossSystemConversions(converter);
    }

    private static void demonstrateLengthConversions(UnitConverter converter) {
        double kmToM = converter.convertLength(5, "km", "m");
        System.out.println("5 km = " + kmToM + " m");

        double milesToFeet = converter.convertLength(2, "mi", "ft");
        System.out.println("2 miles = " + milesToFeet + " feet");
    }

    private static void demonstrateWeightConversions(UnitConverter converter) {
        double kgToG = converter.convertWeight(2.5, "kg", "g");
        System.out.println("2.5 kg = " + kgToG + " g");

        double lbToOz = converter.convertWeight(3, "lb", "oz");
        System.out.println("3 lb = " + lbToOz + " oz");
    }

    private static void demonstrateTemperatureConversions(UnitConverter converter) {
        double celsiusToKelvin = converter.convertTemperature(25, "celsius", "kelvin");
        System.out.println("25°C = " + celsiusToKelvin + " K");

        double fahrToRankine = converter.convertTemperature(75, "fahrenheit", "rankine");
        System.out.println("75°F = " + fahrToRankine + " °R");
    }

    private static void demonstrateCrossSystemConversions(UnitConverter converter) {
        double kmToMiles = converter.convertLength(10, "km", "mi");
        System.out.println("10 km = " + kmToMiles + " miles");

        double kgToPounds = converter.convertWeight(1, "kg", "lb");
        System.out.println("1 kg = " + kgToPounds + " pounds");

        double celsiusToFahr = converter.convertTemperature(20, "celsius", "fahrenheit");
        System.out.println("20°C = " + celsiusToFahr + " °F");

        System.out.println("\nConverter System: " + converter.getSystem());
    }
}