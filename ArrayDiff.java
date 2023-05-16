import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDiff {
    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();

        for (int numberInFirstArray: a) {
            boolean isNumberInSecondArray = false;

            for (int numberInSecondArray: b) {
                if (numberInFirstArray == numberInSecondArray) {
                    isNumberInSecondArray = true;
                    break;
                }
            }

            if (!isNumberInSecondArray) {
                result.add(numberInFirstArray);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // SHOULD RETURN "[2]"
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2}, new int[]{1})));

        // SHOULD RETURN "[1, 3]"
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2, 2, 2, 3}, new int[]{2})));
    }
}