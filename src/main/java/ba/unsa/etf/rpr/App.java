package ba.unsa.etf.rpr;

public class App {
    public static void main(String[] args) {
        String inputString = "";
        for (String arg : args) {
            inputString += arg;
        }
        if(inputString.isEmpty()) {
            throw new RuntimeException("Unijeli ste prazan string!");
        }
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        try{
            System.out.println(evaluator.evaluate(inputString));
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }

    }
}