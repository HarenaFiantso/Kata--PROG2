import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata3v1 {
    private static void calculateAverageScores(
            double[] judgeScores,
            int k,
            int start,
            double currentSum,
            double[] currentCombination, List<Double> averageScores
    ) {
        if (k == 0) {
            averageScores.add(currentSum / 9);
            return;
        }

        for (int i = start; i <= judgeScores.length - k; i++) {
            currentCombination[currentCombination.length - k] = judgeScores[i];
            calculateAverageScores(judgeScores, k - 1, i + 1, currentSum + judgeScores[i],
                    currentCombination, averageScores);
        }
    }

    private static double calculateAverage(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    private static double calculateMedian(List<Double> numbers) {
        int size = numbers.size();
        if (size % 2 == 0) {
            int midIndex = size / 2;
            return (numbers.get(midIndex - 1) + numbers.get(midIndex)) / 2.0;
        } else {
            int midIndex = size / 2;
            return numbers.get(midIndex);
        }
    }

    public static void main(String[] args) {
        //double[] judgeScores = new double[]{6.7, 4.2, 4.3, 7.0, 0.0, 2.8, 3.9, 1.3, 6.9, 6.0, 7.3, 3.2};
        double[] judgeScores = new double[]{7.1, 9.6, 0.9, 3.9, 7.4, 3.3, 7.5, 2.6, 2.9, 8.4, 6.4, 0.3};

        Arrays.sort(judgeScores);

        List<Double> averageScores = new ArrayList<>();
        calculateAverageScores(judgeScores, 9, 0, 0, new double[9], averageScores);

        averageScores.sort(null);

        double minScore = averageScores.get(0);
        double maxScore = averageScores.get(averageScores.size() - 1);
        double averageScore = calculateAverage(averageScores);
        double medianScore = calculateMedian(averageScores);

        System.out.println(Arrays.asList(minScore, averageScore, medianScore, maxScore));
    }
}
