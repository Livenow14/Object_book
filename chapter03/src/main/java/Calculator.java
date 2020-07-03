import domain.Equation;
import view.InputView;

public class Calculator {

    public void run(){
        Equation equation = new Equation(InputView.getInputEquation());
    }
}
