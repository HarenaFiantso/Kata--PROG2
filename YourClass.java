import java.util.List;

public class YourClass {
    public static int countByPromotion(int promotionYear, List<String> stdList) {
        int count = 0;
        String promotionPrefix = String.format("STD%02d", promotionYear % 100);

        for (String std : stdList) {
            if (std.startsWith(promotionPrefix)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<String> list = List.of("STD21001", "STD21002", "STD23005", "STD21015", "STD22088", "STD22103");

        System.out.println(countByPromotion(2021, list)); // Output: 3
        System.out.println(countByPromotion(2022, list)); // Output: 2
        System.out.println(countByPromotion(2023, list)); // Output: 1
    }
}