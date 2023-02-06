package com.demographics.demographicsapi.models;

public class Variable {
    private String variable;
    private double value;
    private String label;

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "variable{" +
                "variable='" + variable + '\'' +
                ", value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
