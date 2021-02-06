package lesson4.MiniExc.SwapString;

public class Main {
    public static void main(String[] args) {
        LamdaSwapString swap = (String oldString) -> {
          StringBuilder newString= new StringBuilder();
            for (int i = oldString.length()-1; i >= 0; i--) {
                newString.append(oldString.charAt(i));
            }
            return newString.toString();
        };
        System.out.println(swap.swapString("java interview"));
    }
}
