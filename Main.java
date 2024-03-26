import java.util.Scanner;

//длина вводимой строки <= 10 символов
//вывод строки более 40 символов ...
//числа на ввод <= 10
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char character;
        String[] strings;
        
            if (input.contains(" + ")) {
                strings = input.split(" \\+ ");
                character = '+';
            } else if (input.contains(" - ")) {
                strings = input.split(" - ");
                character = '-';
            } else if (input.contains(" * ")) {
                strings = input.split(" \\* ");
                character = '*';
            } else if (input.contains(" / ")) {
                strings = input.split(" / ");
                character = '/';
            } else {
                throw new RuntimeException("Введен некорректный знак действия");
            }

            if (character == '*' || character == '/') {
                if (strings[1].contains("\"")) {
                    throw new RuntimeException("Строку можно делить или умножать только на число");
                }
                int number = Integer.parseInt(strings[1]);
                if(!(number >= 1  && number <= 10 )) {
                    throw new RuntimeException("Вы вышли за диапозон значений");
                }
            }
            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].replace("\"", "");
            }
        if (strings[0].length() > 10) {
            throw new RuntimeException("Неверный ввод");
        }

            if (character == '+') {
                result(strings[0] + strings[1]);
            } else if (character == '*') {
                String handledString = "";
                int number = Integer.parseInt(strings[1]);
                for (int i = 0; i < number; i++){
                    handledString += strings[0];
                }
                result(handledString);
            } else if (character == '-') {
                int index = strings[0].indexOf(strings[1]);
                if (index == -1) {
                    result(strings[0]);
                } else {
                    String handledString = strings[0].substring(0, index);
                    handledString += strings[0].substring(index + strings[1].length());
                    result(handledString);
                }
            } else {
                int newLine = strings[0].length() / Integer.parseInt(strings[1]);
                String handledString = strings[0].substring(0, newLine);
                result(handledString);
            }
    }
        static void result (String text){
            if (text.length() > 40){
                text = text.substring(0,40);
                text +="...";
            }
            System.out.println("\"" + text + "\"");
        }
}