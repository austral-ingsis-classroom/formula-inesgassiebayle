package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Function;
import java.util.List;
import java.util.Map;

public class Module extends UnaryFunction {

  public Module(Function function) {
    super(function);
  }

  @Override
  public double evaluate(Map<String, Double> parameters) {
    return Math.abs(getFunction().evaluate(parameters));
  }

  @Override
  public List<String> getVariables() {
    return getFunction().getVariables();
  }

  @Override
  public String print() {
    return "|" + getFunction().print() + "|";
  }
}
