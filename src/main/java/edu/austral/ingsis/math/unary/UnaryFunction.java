package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Function;

public abstract class UnaryFunction implements Function {
    private final Function function;

    public UnaryFunction(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
