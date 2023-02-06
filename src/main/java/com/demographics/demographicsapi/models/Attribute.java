package com.demographics.demographicsapi.models;

import java.util.ArrayList;

public class Attribute {
    public String label;
    public String type;

    //not a map because no need for key valued pairs
    private ArrayList<Variable> variables;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "commute_mode{" +
                "label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", variables=" + variables +
                '}';
    }
}
