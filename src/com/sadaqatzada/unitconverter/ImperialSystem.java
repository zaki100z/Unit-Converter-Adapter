package com.sadaqatzada.unitconverter;

public class ImperialSystem {
    public double feetToMiles(double feet) {
        return feet / 5280.0;
    }

    public double milesToFeet(double miles) {
        return miles * 5280.0;
    }

    public double ouncesToPounds(double ounces) {
        return ounces / 16.0;
    }

    public double poundsToOunces(double pounds) {
        return pounds * 16.0;
    }

    public double fahrenheitToRankine(double fahrenheit) {
        return fahrenheit + 459.67;
    }
}