package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parenthesis extends UnaryFunction {

    public Parenthesis(Function function) {
        super(function);
    }

    @Override
    public double evaluate(Map<String, Double> parameters) {
        return getFunction().evaluate(parameters);
    }

    @Override
    public List<String> getVariables() {
        return getFunction().getVariables();
    }

    @Override
    public String print() {
        return "(" + getFunction().print() + ")";
    }
}
