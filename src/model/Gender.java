package model;

public enum Gender {
    male,
    female;

    public static Gender fromString(String gender) {
        switch (gender) {
            case "male":
                return Gender.male;
            case "female":
                return Gender.female;
            default:
                throw new IllegalArgumentException("gender");
        }
    }
}
