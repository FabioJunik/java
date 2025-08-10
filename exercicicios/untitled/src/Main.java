import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Stack<Integer> numbers = new Stack<>();

       numbers.push(10);
       numbers.push(20);
       numbers.push(30);

       for (Integer i : numbers) {
           System.out.println(i);
       }
    }
}