package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.binary.*;
import edu.austral.ingsis.math.unary.Module;
import edu.austral.ingsis.math.unary.Parenthesis;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  Map<String, Double> map = new HashMap<>();

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function function = new Sum(new Constant(1), new Constant(6));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function function = new Division(new Constant(12), new Constant(2));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function function =
        new Multiply(
            new Parenthesis(new Division(new Constant(9), new Constant(2))), new Constant(3));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function function =
        new Power(
            new Parenthesis(new Division(new Constant(27), new Constant(6))), new Constant(2));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function function = new Root(new Constant(36), new Constant(2));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function function = new Module(new Constant(136));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function function = new Module(new Constant(-136));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function function =
        new Multiply(new Parenthesis(new Sub(new Constant(5), new Constant(5))), new Constant(8));
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(0d));
  }
}
