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




/*
* Un nouveau séminaire chez HEI va prendre place, on demande dans HEI tribu la liste des STD des élèves intéressés. Pour arranger
* les salles, vous avez la tâche de compter le nombre des L1(2021) et des L2(2022) dans cette liste.
* Créez une méthode pour le faire. On prendra en paramètre l'année d'entrée de la promotion recherchée et la liste de STD des
* élèves intéressés.
*
* Signature de la méthode:
* public static String countByPromotion(int promotionYear, List<String> stdList);
*
* Exemples:
* List<String> list = List.of("STD21001", "STD21002", "STD23005", "STD21015", "STD22088", "STD22103");
*
* YourClass.countByPromotion(2021, list) => 3
* YourClass.countByPromotion(2022, list) => 2
* */