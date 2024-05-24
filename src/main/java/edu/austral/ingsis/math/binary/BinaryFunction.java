package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;

public abstract class BinaryFunction implements Function {
    private final Function left;
    private final Function right;

    public BinaryFunction(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }
}
