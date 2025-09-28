package com.sadaqatzada.unitconverter;

public interface UnitConverter{
    double convertLength(double value, String fromUnit, String toUnit);
    double convertWeight(double value, String fromUnit, String toUnit);
    double convertTemperature(double value, String fromUnit, String toUnit);
    String getSystem();

}
