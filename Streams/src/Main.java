import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,1,2,5,8};

        int min = Arrays.stream(array)
                .min()
                .getAsInt();

        int max = Arrays.stream(array)
                .max().getAsInt();

        Set<Integer> set = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet());

        List<Integer> missingNumbers = IntStream.rangeClosed(min, max)
                .boxed()
                .filter(i -> !set.contains(i))
                .toList();
        System.out.println("Missing numbers in the array:"+missingNumbers);
    }
}