public class Kata {
    public static int findEvenIndex(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }


    public static void main(String[] args) {
        // SHOULD RETURN 3 ✅️
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));

        // SHOULD RETURN 1 ✅️
        System.out.println(findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));

        // SHOULD RETURN 0 ✅️
        System.out.println(findEvenIndex(new int[]{20, 10, -80, 10, 10, 15, 35}));
    }
}
