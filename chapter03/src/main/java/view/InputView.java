package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_EQUATION = "연산을 입력하세요.";

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = " ";

    public static List<String> getInputEquation(){
        System.out.println(INPUT_EQUATION);
        return Arrays.asList(SCANNER.nextLine().split(DELIMITER));
    }
}
