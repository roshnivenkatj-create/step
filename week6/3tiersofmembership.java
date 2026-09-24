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

    void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName +
                           " | Sessions: " + sessionsAttended);
    }
}

class EliteMember extends PremiumMember {
    String lockerNumber;

    EliteMember(String memberId, int monthlyFee, String trainerName,
                String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    void displayInfo() {
        System.out.println("Elite Member | Trainer: " + trainerName +
                           " | Locker: " + lockerNumber +
                           " | Sessions: " + sessionsAttended);
    }
}

class GroupClassMember extends GymMember {
    String className;

    GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    void displayInfo() {
        System.out.println("Group Class Member | Class: " + className +
                           " | Sessions: " + sessionsAttended);
    }
}

class Main {
    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";

        return "Standard/Premium Member";
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        for (GymMember m : members)
            total += m.getSessionsAttended();

        return total;
    }

    public static void main(String[] args) {
        GymMember m1 = new GymMember("MEM1", 1000);
        PremiumMember m2 = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember m3 = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember m4 = new GroupClassMember("MEM4", 1500, "Zumba");

        m1.displayInfo();
        m2.displayInfo();
        m3.displayInfo();
        m4.displayInfo();

        System.out.println(classifyGeneration(m3));
        System.out.println(classifyGeneration(m4));

        m2.attendSession();
        m2.attendSession();
        m2.attendSession();

        m3.attendSession();
        m3.attendSession();

        m4.attendSession();
        m4.attendSession();
        m4.attendSession();
        m4.attendSession();

        GymMember[] members = {m2, m3, m4};

        System.out.println(getTotalSessionsAttended(members));
    }
}
