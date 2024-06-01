package behavioural.interpreter;
// Abstract Expression
interface Expression {
    int interpret();
}

// Terminal Expression
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

// Non-Terminal Expression
class AdditionExpression implements Expression {
    private Expression left;
    private Expression right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

// Client
public class Interpreter {
    public static void main(String[] args) {
        // Build the abstract syntax tree
        Expression expression = new AdditionExpression(
                new NumberExpression(2),
                new AdditionExpression(
                        new NumberExpression(3),
                        new NumberExpression(4)
                )
        );

        // Interpret the expression
        int result = expression.interpret();
        System.out.println("Result: " + result); // Output: Result: 9
    }
}
