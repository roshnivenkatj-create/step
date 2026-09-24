class GymMember {

    static int membersEnrolled = 0;
    static int nextNumber = 2000;

    final String membershipNumber;

    int monthlyFee;
    int feesPaid;

    GymMember(int monthlyFee) {
        membersEnrolled++;
        nextNumber++;

        membershipNumber = "GYM-" + nextNumber;
        this.monthlyFee = monthlyFee;
    }

    void payFee(int amount) {
        feesPaid += amount;
    }

    void payFee(int amount, String mode) {
        System.out.println("Payment Mode: " + mode);
        payFee(amount);
    }

    int getFeesPaid() {
        return feesPaid;
    }

    static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4)
            return false;

        if (code.charAt(0) != 'G')
            return false;

        if (!Character.isDigit(code.charAt(1)))
            return false;

        if (!Character.isDigit(code.charAt(2)))
            return false;

        if (!Character.isUpperCase(code.charAt(3)))
            return false;

        return true;
    }

    static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class GroupClassMember extends GymMember {

    String className;

    GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

class Main {

    static String processWeeklyCheckIn(GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember m : members) {

            if (m == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (m instanceof GroupClassMember)
                group++;
            else
                individual++;
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               group + " group | " +
               individual + " individual";
    }

    public static void main(String[] args) {

        GymMember m1 = new GymMember(1000);

        System.out.println(m1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(m1.getFeesPaid());

        GymMember[] members = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };

        System.out.println(processWeeklyCheckIn(members));
    }
}