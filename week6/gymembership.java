class GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended;

    GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4)
            throw new IllegalArgumentException();

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        sessionsAttended = 0;
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signed = 0, rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signed++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signed + " | Rejected: " + rejected;
    }
}