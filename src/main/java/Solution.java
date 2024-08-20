import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(";");
            String operation = input[0];
            String type = input[1];
            String text = input[2];

            System.out.println(operation.equals("S") ? split(text, type) : combine(text, type));
        }
    }

    private static String combine(String text, String type) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.split(" ");
        sb.append(type.equals("C") ? capitalize(words[0]) : words[0]);
        for (int i = 1; i < words.length; i++) sb.append(capitalize(words[i]));

        if (type.equals("M")) sb.append("()");
        return sb.toString();
    }

    private static String split(String text, String type) {
        StringBuilder sb = new StringBuilder();
        if (type.equals("M")) text = text.substring(0, text.length() - 2);
        sb.append(Character.toLowerCase(text.charAt(0)));
        for (int i = 1; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) sb.append(" ");
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    public static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);

    }
}