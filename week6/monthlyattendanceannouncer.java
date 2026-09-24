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

    void displayInfo(StringBuilder sb) {
        sb.append("Standard | Sessions: ")
          .append(sessionsAttended);
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo(StringBuilder sb) {
        sb.append("Premium | Trainer: ")
          .append(trainerName)
          .append(" | Sessions: ")
          .append(sessionsAttended);
    }
}

class Main {

    static String batchPrint(GymMember[] members) {

        StringBuilder sb = new StringBuilder();

        for (GymMember m : members) {

            m.displayInfo(sb);

            if (m instanceof PremiumMember) {
                PremiumMember p = (PremiumMember) m;

                sb.append(" [Trainer via downcast: ")
                  .append(p.trainerName)
                  .append("]");
            }

            sb.append(" | ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}