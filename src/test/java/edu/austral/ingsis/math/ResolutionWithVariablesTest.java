package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.binary.*;
import edu.austral.ingsis.math.unary.Module;
import edu.austral.ingsis.math.unary.Parenthesis;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function function = new Sum(new Constant(1), new Variable("x"));
    final Double result = function.evaluate(Map.of("x", 3d));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function function = new Division(new Constant(12), new Variable("div"));
    final Double result = function.evaluate(Map.of("div", 4d));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function function =
        new Multiply(
            new Parenthesis(new Division(new Constant(9), new Variable("x"))), new Variable("y"));
    final Double result = function.evaluate(Map.of("x", 3d, "y", 4d));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function function =
        new Power(
            new Parenthesis(new Division(new Constant(27), new Variable("a"))), new Variable("b"));
    final Double result = function.evaluate(Map.of("a", 9d, "b", 3d));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function function = new Root(new Variable("z"), new Constant(2));
    final Double result = function.evaluate(Map.of("z", 36d));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function function = new Sub(new Module(new Variable("value")), new Constant(8));
    final Double result = function.evaluate(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function function =
        new Multiply(new Parenthesis(new Sub(new Constant(5), new Variable("i"))), new Constant(8));
    final Double result = function.evaluate(Map.of("i", 2d));

    assertThat(result, equalTo(24d));
  }
}
