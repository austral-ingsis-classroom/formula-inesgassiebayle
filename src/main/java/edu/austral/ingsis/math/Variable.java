package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public class Variable implements Function {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public double evaluate(Map<String, Double> parameters) {
    return parameters.get(name);
  }

  @Override
  public List<String> getVariables() {
    return List.of(name);
  }

  @Override
  public String print() {
    return name;
  }
}
