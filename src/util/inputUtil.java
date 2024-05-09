package util;

import java.util.Scanner;

public class inputUtil {
    private static Scanner scanner = new Scanner(System.in);
    public static String input(String info){
        System.out.print(info + " : ");
        String dataUser = scanner.nextLine();
        return dataUser;
    }
}
