public class Problem1 {

    static void checkDuplicateSeats(int[] seatNumbers) {

        boolean found = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {

                    System.out.println(
                        "Duplicate Seat Number Found: " + seatNumbers[i]
                    );

                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        int[] seats = {101, 102, 103, 102, 105};

        checkDuplicateSeats(seats);
    }
}