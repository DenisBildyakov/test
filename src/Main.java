import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of(
                "(((()", ")()", "(()",
                ")()())", ")(()())", ")(",
                "())", "(()())()", "[]",
                "(())", ")(()", "(((())))",
                "(((()))");

        for (String s : list) {
            validBrackets(s);
        }
    }

    public static void validBrackets(String brackets) {
        int open = 0;
        int close = 0;
        char[] bracket = brackets.toCharArray();
        StringBuilder validBracket = new StringBuilder();

        for (int i = 0; i < bracket.length; i++) {
            if (bracket[i] == '(') {
                open++;
            } else if (bracket[i] == ')') {
                close++;
            }
            if (open-close < 0) {
                bracket[i] = 0;
                close--;
            }
        }

        open = open - (open - close);

        for (int i = 0; i < bracket.length; i++) {
            if (bracket[i] == '(' && open != 0) {
                validBracket.append(bracket[i]);
                open--;
            }
            if (bracket[i] == ')' && close != 0) {
                validBracket.append(bracket[i]);
                close--;
            }
        }

        System.out.println("Вывод: " + validBracket.length() + " - " + validBracket);
    }
}
