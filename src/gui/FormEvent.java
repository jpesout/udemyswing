package gui;

import java.util.EventObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private String empCategory;
    private boolean usCitizen;
    private String taxId;
    private String gender;

    public FormEvent(Object source, String name, String occupation, AgeCategory ageCategory, String empCategory, boolean usCitizen, String taxId, String gender) {
        super(source);

        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.usCitizen = usCitizen;
        this.taxId = taxId;
        this.gender = gender;
    }

}
