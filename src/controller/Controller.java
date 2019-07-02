package controller;

import gui.FormEvent;
import model.*;

import java.util.List;

public class Controller {
    Database db = new Database();

    public void addPerson(FormEvent event) {
        String name = event.getName();
        String occupation = event.getOccupation();
        int ageCategoryId = event.getAgeCategory() != null ? event.getAgeCategory().getId() : 0;
        AgeCategory ageCategory;
        EmploymentCategory empCategory = EmploymentCategory.fromString(event.getEmpCategory());
        boolean isUsCitizen = event.isUsCitizen();
        String taxId = event.getTaxId();
        Gender gender = Gender.fromString(event.getGender());

        switch (ageCategoryId) {
            case 1:
                ageCategory = AgeCategory.child;
                break;
            case 2:
                ageCategory = AgeCategory.adult;
                break;
            case 3:
                ageCategory = AgeCategory.senior;
                break;
            default:
                ageCategory = null;
        }

        Person person = new Person(name, occupation, ageCategory, empCategory, isUsCitizen, taxId, gender);
        db.add(person);
    }

    public List<Person> getPeople() {
        return db.getPeople();
    }
}
