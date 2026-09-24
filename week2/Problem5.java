import java.util.*;

public class Problem5 {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a",
            "is", "of", "in"
        };

        HashMap<String, Integer> frequency =
            new HashMap<>();

        feedback = feedback
            .toLowerCase()
            .replace(".", "")
            .replace(",", "");

        String[] words = feedback.split("\\s+");

        for (String word : words) {

            boolean isStopWord = false;

            for (String stop : stopWords) {

                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        List<Map.Entry<String, Integer>> entries =
            new ArrayList<>(frequency.entrySet());

        entries.sort(
            (a, b) -> b.getValue() - a.getValue()
        );

        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                entry.getKey() + ": " +
                entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        printFilteredWordFrequency(
            "The mentor was great, the session was great and clear."
        );
    }
}