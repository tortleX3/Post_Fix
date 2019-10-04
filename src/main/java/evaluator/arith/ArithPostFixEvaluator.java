package evaluator.arith;

import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;
import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;


/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

  /**
   * <p></p>
   * stack stores operands.
   */
  private final StackInterface<Operand<Integer>> stack;

  /**
   * Constructs an {@link ArithPostFixEvaluator}.
   */
  public ArithPostFixEvaluator() {
    this.stack = new LinkedStack<>(); }

  /**
   * Evaluates a postfix expression.
   * @return the result 
   */
  @Override
  public Integer evaluate(String expr) {
    // TODO Use all of the things they've built so far to 
    // create the algorithm to do post fix evaluation

    ArithPostFixParser parser = new ArithPostFixParser(expr);
    while (parser.hasNext()) {
      switch (parser.nextType()) { 
        case OPERAND:
          stack.push(parser.nextOperand());
          break;
        case OPERATOR:
          Operator operate = parser.nextOperator();
          if (stack.isEmpty() || (operate.getNumberOfArguments() == 2 && stack.size() == 1))
            throw new IllegalPostFixExpressionException("There is not a valid number of operands to operate on");

          if (operate.getNumberOfArguments() == 1) {
            Operand<Integer> op0 = stack.pop();

            operate.setOperand(0,op0);
            stack.push(operate.performOperation());
          } else {
            Operand<Integer> op1 = stack.pop();
            Operand<Integer> op0 = stack.pop();

            operate.setOperand(0, op0);
            operate.setOperand(1, op1);
            stack.push(operate.performOperation());
          }
          break;
        default:
      }
    }
    if(stack.size() > 1)
      throw new IllegalPostFixExpressionException("There is more operands than operators");

    return stack.pop().getValue();
  }

}
