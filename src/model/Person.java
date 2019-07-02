package model;

import lombok.Data;

@Data
public class Person {
    private static int count = 0;

    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory empCategory;
    private boolean usCitizen;
    private String taxId;
    private Gender gender;

    public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory empCategory, boolean usCitizen, String taxId, Gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.usCitizen = usCitizen;
        this.taxId = taxId;
        this.gender = gender;

        count++;
        this.id = count;
    }

}
