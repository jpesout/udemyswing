package model;

public enum EmploymentCategory {
    employed,
    selfEmployed,
    unemployed,
    other;

    public static EmploymentCategory fromString(String empCategory) {
        switch(empCategory) {
            case "employed":
                return EmploymentCategory.employed;
            case "self-employed":
                return EmploymentCategory.selfEmployed;
            case "unemployed":
                return EmploymentCategory.unemployed;
            default:
                return EmploymentCategory.other;
        }
    }
}
