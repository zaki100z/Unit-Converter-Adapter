package com.sadaqatzada.unitconverter;

public class UniversalUnitConverter implements UnitConverter {
    private MetricConverterAdapter metricAdapter;
    private ImperialConverterAdapter imperialAdapter;

    public UniversalUnitConverter() {
        this.metricAdapter = new MetricConverterAdapter(new MetricSystem());
        this.imperialAdapter = new ImperialConverterAdapter(new ImperialSystem());
    }

    @Override
    public double convertLength(double value, String fromUnit, String toUnit) {
        if (isMetric(fromUnit) && isMetric(toUnit)) {
            return metricAdapter.convertLength(value, fromUnit, toUnit);
        } else if (isImperial(fromUnit) && isImperial(toUnit)) {
            return imperialAdapter.convertLength(value, fromUnit, toUnit);
        } else {
            return convertCrossSystemLength(value, fromUnit, toUnit);
        }
    }

    @Override
    public double convertWeight(double value, String fromUnit, String toUnit) {
        if (isMetric(fromUnit) && isMetric(toUnit)) {
            return metricAdapter.convertWeight(value, fromUnit, toUnit);
        } else if (isImperial(fromUnit) && isImperial(toUnit)) {
            return imperialAdapter.convertWeight(value, fromUnit, toUnit);
        } else {
            return convertCrossSystemWeight(value, fromUnit, toUnit);
        }
    }

    @Override
    public double convertTemperature(double value, String fromUnit, String toUnit) {
        if (isMetricTemperature(fromUnit) && isMetricTemperature(toUnit)) {
            return metricAdapter.convertTemperature(value, fromUnit, toUnit);
        } else if (isImperialTemperature(fromUnit) && isImperialTemperature(toUnit)) {
            return imperialAdapter.convertTemperature(value, fromUnit, toUnit);
        } else {
            return convertCrossSystemTemperature(value, fromUnit, toUnit);
        }
    }

    @Override
    public String getSystem() {
        return "Universal Converter (Metric ↔ Imperial)";
    }

    private boolean isMetric(String unit) {
        return unit.equalsIgnoreCase("km") || unit.equalsIgnoreCase("m") ||
                unit.equalsIgnoreCase("cm") || unit.equalsIgnoreCase("kg") ||
                unit.equalsIgnoreCase("g");
    }

    private boolean isImperial(String unit) {
        return unit.equalsIgnoreCase("mi") || unit.equalsIgnoreCase("ft") ||
                unit.equalsIgnoreCase("in") || unit.equalsIgnoreCase("lb") ||
                unit.equalsIgnoreCase("oz");
    }

    private boolean isMetricTemperature(String unit) {
        return unit.equalsIgnoreCase("celsius") || unit.equalsIgnoreCase("kelvin");
    }

    private boolean isImperialTemperature(String unit) {
        return unit.equalsIgnoreCase("fahrenheit") || unit.equalsIgnoreCase("rankine");
    }

    private double convertCrossSystemLength(double value, String fromUnit, String toUnit) {
        double meters;
        if (isMetric(fromUnit)) {
            meters = metricAdapter.convertLength(value, fromUnit, "m");
        } else {
            double feet = imperialAdapter.convertLength(value, fromUnit, "ft");
            meters = feet * 0.3048;
        }

        if (isMetric(toUnit)) {
            return metricAdapter.convertLength(meters, "m", toUnit);
        } else {
            double feet = meters / 0.3048;
            return imperialAdapter.convertLength(feet, "ft", toUnit);
        }
    }

    private double convertCrossSystemWeight(double value, String fromUnit, String toUnit) {
        double kilograms;
        if (isMetric(fromUnit)) {
            kilograms = metricAdapter.convertWeight(value, fromUnit, "kg");
        } else {
            double pounds = imperialAdapter.convertWeight(value, fromUnit, "lb");
            kilograms = pounds * 0.453592;
        }

        if (isMetric(toUnit)) {
            return metricAdapter.convertWeight(kilograms, "kg", toUnit);
        } else {
            double pounds = kilograms / 0.453592;
            return imperialAdapter.convertWeight(pounds, "lb", toUnit);
        }
    }

    private double convertCrossSystemTemperature(double value, String fromUnit, String toUnit) {
        double celsius;
        if (fromUnit.equalsIgnoreCase("celsius")) {
            celsius = value;
        } else if (fromUnit.equalsIgnoreCase("kelvin")) {
            celsius = value - 273.15;
        } else if (fromUnit.equalsIgnoreCase("fahrenheit")) {
            celsius = (value - 32) * 5/9;
        } else {
            celsius = (value - 491.67) * 5/9;
        }

        if (toUnit.equalsIgnoreCase("celsius")) {
            return celsius;
        } else if (toUnit.equalsIgnoreCase("kelvin")) {
            return celsius + 273.15;
        } else if (toUnit.equalsIgnoreCase("fahrenheit")) {
            return (celsius * 9/5) + 32;
        } else {
            return (celsius + 273.15) * 9/5;
        }
    }
}
