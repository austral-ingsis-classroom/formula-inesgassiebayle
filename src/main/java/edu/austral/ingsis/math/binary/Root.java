package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;
import java.util.List;
import java.util.Map;

public class Root extends BinaryFunction {

    public Root(Function left, Function right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> parameters) {
        return Math.pow(getLeft().evaluate(parameters), 1/getRight().evaluate(parameters));
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
        return getLeft().print() + " ^ (1/" + getRight().print() + ")";
    }
}