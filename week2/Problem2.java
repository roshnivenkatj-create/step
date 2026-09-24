public class Problem2 {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversed =
                new StringBuilder(words[i]);

            result.append(reversed.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(
            reverseEachWord("hello club")
        );
    }
}