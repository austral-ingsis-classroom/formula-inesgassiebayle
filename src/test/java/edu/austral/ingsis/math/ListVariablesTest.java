package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.binary.*;
import edu.austral.ingsis.math.unary.Module;
import edu.austral.ingsis.math.unary.Parenthesis;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new Sum(new Constant(1), new Constant(6));
    final List<String> result = function.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new Division(new Constant(12), new Variable("div"));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function =
        new Multiply(
            new Parenthesis(new Division(new Constant(9), new Variable("x"))), new Variable("y"));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function =
        new Power(
            new Parenthesis(new Division(new Constant(27), new Variable("a"))), new Variable("b"));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function = new Root(new Variable("z"), new Constant(2));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new Sub(new Module(new Variable("value")), new Constant(8));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function =
        new Multiply(new Parenthesis(new Sub(new Constant(5), new Variable("i"))), new Constant(8));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
