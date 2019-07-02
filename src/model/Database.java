package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Person> people;

    public Database() {
        people = new ArrayList<>();
    }

    public void add(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}
