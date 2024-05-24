package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Constant implements Function{
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> parameters) {
        return value;
    }

    @Override
    public List<String> getVariables() {
        return Collections.emptyList();
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
