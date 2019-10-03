package language.arith;

import language.UnaryOperator;
import language.Operand;


/**
 * The {@code PlusOperator} is an operator that performs addition on two
 * integers.
 * @author jcollard, jddevaug
 *
 */
public class NegateOperator extends UnaryOperator<Integer> {

  /**
   * {@inheritDoc}.
   */
  @Override
  public Operand<Integer> performOperation() {
    Operand<Integer> op0 = this.getOp();
    if (op0 == null) {
      throw new IllegalStateException("Could not perform operation prior to operand being set.");
    }
    Integer result = op0.getValue() * -1;
    return new Operand<Integer>(result);
  }

}
