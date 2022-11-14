import ba.unsa.etf.rpr.ExpressionEvaluator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {
    public ExpressionEvaluator evaluator = new ExpressionEvaluator();

    @Test
    public void testInvalidExpression1() {
        assertThrows(RuntimeException.class,()->evaluator.evaluate("( 1 + ( 2 )"));
    }
    @Test
        public void testInvalidExpression2() {
            assertThrows(RuntimeException.class,()->evaluator.evaluate("( 1 +  2 ) +"));
        }
        @Test
        public void testInvalidExpression3() {
            assertThrows(RuntimeException.class,()->evaluator.evaluate("( +  2 )"));
        }
        @Test
        public void testInvalidExpression4() {
            assertThrows(RuntimeException.class,()->evaluator.evaluate("sqrt 1 )"));
        }
        @Test
        public void testInvalidExpression5() {
            assertThrows(RuntimeException.class,()->evaluator.evaluate(" + 1 "));
        }

        @Test
        public void testEvaluator1() {
            assertEquals(101,evaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        }
        @Test
        public void testEvaluator2() {
            assertEquals(15.070522012751594,evaluator.evaluate("( ( sqrt 1 ) + ( ( ( sqrt 2 ) + ( sqrt 3 ) ) * ( ( sqrt 4 ) * ( sqrt 5 ) ) ) )"));
        }
        @Test
        public void testEvaluator4(){
            assertEquals(1.189207115002721,evaluator.evaluate("( sqrt ( sqrt 2 ) )"));
    }
}
