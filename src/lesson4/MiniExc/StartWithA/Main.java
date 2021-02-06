package lesson4.MiniExc.StartWithA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InterfaceForMyString myLambdaString = (String str) -> str.startsWith("a") && str.length()==3;
        List<String> list = new ArrayList<>();
        list = setList(10);
        outputList(list);
        System.out.println("Слова начинающиеся с <<a>> и длиной 3:");
        outputList(search(list,myLambdaString));

    }
    public static List<String> setList(int n){
        Random forSetString = new Random();
        List<String> newList = new ArrayList<>();
        StringBuilder element= new StringBuilder();
        for (int i = 0; i < n; i++) {
            element.delete(0,element.length());
            if (i % 3 != 0){
                for (int j = 0; j < forSetString.nextInt(7)+1; j++) {
                    element.append((char)('A'+forSetString.nextInt(26)));
                }
                newList.add(element.toString());
            }
            else {
                element.append('a');
                for (int j = 0; j < forSetString.nextInt(3)+1; j++) {
                    element.append((char)('A'+forSetString.nextInt(53)));
                }
                newList.add(element.toString());
            }
        }
        return newList;
    }
    public static void outputList(List<String> list){
        System.out.println("Список: ");
        for (String str: list) {
            System.out.println(str);
        }
        System.out.println("--------");
    }
    public static List<String> search (List<String> list,InterfaceForMyString lambda){
        List<String> newList = new ArrayList<>();
        for (String str: list) {
            if (lambda.forFindString(str)) newList.add(str);
        }
        return newList;
    }
}
