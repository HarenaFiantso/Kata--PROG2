import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kata3 {
    public static List<Double> fetchScoreDetails(double[] scores) {
        Arrays.sort(scores);

        List<List<Double>> combinations = generatePossibleCombinations(scores, 9);

        double minScore = calculateMinScore(combinations);
        double averageScore = calculateAverageScore(combinations);
        double medianScore = calculateMedianScore(scores);
        double maxScore = calculateMaxScore(combinations);

        minScore = roundToThreeDecimalPlaces(minScore);
        averageScore = roundToThreeDecimalPlaces(averageScore);
        medianScore = roundToThreeDecimalPlaces(medianScore);
        maxScore = roundToThreeDecimalPlaces(maxScore);

        return Arrays.asList(minScore, averageScore, medianScore, maxScore);
    }

    private static List<List<Double>> generatePossibleCombinations(double[] array, int size) {
        List<List<Double>> combinations = new ArrayList<>();
        generate(combinations, new ArrayList<>(), array, size, 0);
        return combinations;
    }

    private static void generate(List<List<Double>> combinations, List<Double> current, double[] array, int size, int start) {
        if (current.size() == size) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < array.length; i++) {
            current.add(array[i]);
            generate(combinations, current, array, size, i + 1);
            current.remove(current.size() - 1);
        }
    }

    private static double calculateMinScore(List<List<Double>> combinations) {
        double minScore = Double.MAX_VALUE;
        for (List<Double> combination : combinations) {
            double average = calculateAverage(combination);
            if (average < minScore) {
                minScore = average;
            }
        }
        return minScore;
    }

    private static double calculateAverageScore(List<List<Double>> combinations) {
        double totalScore = 0;
        for (List<Double> combination : combinations) {
            double average = calculateAverage(combination);
            totalScore += average;
        }
        return totalScore / combinations.size();
    }

    private static double calculateMedianScore(double[] scores) {
        int size = scores.length;
        if (size % 2 == 0) {
            int midIndex = size / 2;
            double median = (scores[midIndex - 1] + scores[midIndex]) / 2.0;
            return median;
        } else {
            int midIndex = size / 2;
            return scores[midIndex];
        }
    }

    private static double calculateMaxScore(List<List<Double>> combinations) {
        double maxScore = Double.MIN_VALUE;
        for (List<Double> combination : combinations) {
            double average = calculateAverage(combination);
            if (average > maxScore) {
                maxScore = average;
            }
        }
        return maxScore;
    }

    private static double calculateAverage(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    private static double roundToThreeDecimalPlaces(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }

    public static void main(String[] args) {
        double[] input1 = new double[]{6.7, 4.2, 4.3, 7.0, 0.0, 2.8, 3.9, 1.3, 6.9, 6.0, 7.3, 3.2};
        double[] input2 = new double[]{7.1, 9.6, 0.9, 3.9, 7.4, 3.3, 7.5, 2.6, 2.9, 8.4, 6.4, 0.3};

        List<Double> scoreDetails1 = fetchScoreDetails(input1);
        System.out.println(scoreDetails1);

        List<Double> scoreDetails2 = fetchScoreDetails(input2);
        System.out.println(scoreDetails2);
    }
}
