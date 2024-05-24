package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Division extends BinaryFunction {

  public Division(Function left, Function right) {
    super(left, right);
  }

  @Override
  public double evaluate(Map<String, Double> parameters) {
    return getLeft().evaluate(parameters) / getRight().evaluate(parameters);
  }

  @Override
  public List<String> getVariables() {
    List<String> leftVariables = getLeft().getVariables();
    List<String> rightVariables = getRight().getVariables();
    List<String> allVariables = new ArrayList<>(leftVariables);
    allVariables.addAll(rightVariables);
    return allVariables;
  }

  @Override
  public String print() {
    return getLeft().print() + " / " + getRight().print();
  }
}
