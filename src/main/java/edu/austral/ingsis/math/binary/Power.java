package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;
import java.util.List;
import java.util.Map;

public class Power extends BinaryFunction {

    public Power(Function left, Function right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> parameters) {
        return Math.pow(getLeft().evaluate(parameters), getRight().evaluate(parameters));
    }

    @Override
    public List<String> getVariables() {
        List<String> leftVariables = getLeft().getVariables();
        List<String> rightVariables = getRight().getVariables();
        leftVariables.addAll(rightVariables);
        return leftVariables;
    }

    @Override
    public String print() {
        return getLeft().print() + " ^ " + getRight().print();
    }
}