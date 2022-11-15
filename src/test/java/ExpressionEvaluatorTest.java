import ba.unsa.etf.rpr.ExpressionEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {

    @Test
    public void testEvaluator1() {
        ExpressionEvaluator  evaluator = new ExpressionEvaluator();
        assertEquals(101,evaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }
    @Test
    public void testEvaluator2() {
        ExpressionEvaluator  evaluator = new ExpressionEvaluator();
        assertEquals(15.070522012751594,evaluator.evaluate("( ( sqrt 1 ) + ( ( ( sqrt 2 ) + ( sqrt 3 ) ) * ( ( sqrt 4 ) * ( sqrt 5 ) ) ) )"));
    }
    @Test
    public void testEvaluator4(){
        ExpressionEvaluator  evaluator = new ExpressionEvaluator();
        assertEquals(1.189207115002721,evaluator.evaluate("( sqrt ( sqrt 2 ) )"));
    }
    @Test
    public void testInvalidExpression1() {
        ExpressionEvaluator  evaluator = new ExpressionEvaluator();
        assertThrows(RuntimeException.class,()->evaluator.evaluate("( 1 + ( 2 )"));
    }
    @Test
    public void testInvalidExpression2() {
        ExpressionEvaluator  evaluator = new ExpressionEvaluator();
            assertThrows(RuntimeException.class,()->evaluator.evaluate("( 1 +  2 ) +"));
        }
        @Test
        public void testInvalidExpression3() {
            ExpressionEvaluator  evaluator = new ExpressionEvaluator();
            assertThrows(RuntimeException.class,()->evaluator.evaluate("( +  2 )"));
        }
        @Test
        public void testInvalidExpression4() {
            ExpressionEvaluator  evaluator = new ExpressionEvaluator();
            assertThrows(RuntimeException.class,()->evaluator.evaluate("sqrt 1 )"));
        }
        @Test
        public void testInvalidExpression5() {

            ExpressionEvaluator  evaluator = new ExpressionEvaluator();assertThrows(RuntimeException.class,()->evaluator.evaluate(" + 1 "));
        }


}
