package ba.unsa.etf.rpr;

public class App {
    public static void main(String[] args) {
        String inputString = "";
        for(int i = 0; i < args.length; i++){
            inputString += args[i];
        }
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        try{
            System.out.println(evaluator.evaluate(inputString));
        }catch (RuntimeException exception){
            System.out.println(exception);
        }

    }
}