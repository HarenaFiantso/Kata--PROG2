import java.util.List;

public class YourClass {
    public static String countByPromotion(int promotionYear List<String> stdList) {
        for (String std: stdList) {
            String debutOfTheStd = std.substring(3, 5);
            return debutOfTheStd;
        }

        return null;
    }

    public static void main(String[] args) {
        List<String> list = List.of("STD21001", "STD21002", "STD23005", "STD21015", "STD22088", "STD22103");

        // SHOULD RETURN 3
        System.out.println(countByPromotion(list));

        // SHOULD RETURN 2
        //System.out.println(countByPromotion(2022, list));

        // SHOULD RETURN 1
        //System.out.println(countByPromotion(2023, list));
    }
}