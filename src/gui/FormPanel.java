package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okButton;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLabel;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    public FormPanel() {
        Dimension dimension = getPreferredSize();
        dimension.width = 250;
        setPreferredSize(dimension);

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(10);
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);

        occupationLabel = new JLabel("Occupation: ");
        occupationField = new JTextField(10);
        ageList = new JList();

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(1, "Under 18"));
        ageModel.addElement(new AgeCategory(2, "18 to 65"));
        ageModel.addElement(new AgeCategory(3, "Over 65"));
        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(110, 70));
        ageList.setBorder(BorderFactory.createEtchedBorder());

        empCombo = new JComboBox();
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(2);
        empCombo.setEditable(true);

        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);
        taxLabel = new JLabel("Tax ID: ");

        taxLabel.setEnabled(false);
        taxField.setEnabled(false);

        citizenCheck.addActionListener(arg0 -> {
            boolean isTicked = citizenCheck.isSelected();
            taxLabel.setEnabled(isTicked);
            taxField.setEnabled(isTicked);
        });

        maleRadio = new JRadioButton("male");
        maleRadio.setSelected(true);
        maleRadio.setActionCommand(maleRadio.getText());
        femaleRadio = new JRadioButton("female");
        femaleRadio.setActionCommand(femaleRadio.getText());
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        okButton = new JButton("OK");
        okButton.setMnemonic(KeyEvent.VK_O);
        okButton.addActionListener(actionEvent -> {
            String name = nameField.getText();
            String occupation = occupationField.getText();
            AgeCategory ageCategory = (AgeCategory)ageList.getSelectedValue();
            String empCategory = (String)empCombo.getSelectedItem();
            Boolean usCitizen = citizenCheck.isSelected();
            String taxId = taxField.getText();

            String gender = genderGroup.getSelection().getActionCommand();

            FormEvent event = new FormEvent(this, name, occupation, ageCategory, empCategory, usCitizen, taxId, gender);
            if(this.formListener != null) {
                formListener.formEventOccurred(event);
            }
        });


        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age category: "), gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ageList, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Emp. status: "), gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(empCombo, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("US Citizen: "), gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(citizenCheck, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        add(taxLabel, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(taxField, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Gender: "), gc);

        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        add(maleRadio, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 7;
        gc.weighty = 0.2;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.LINE_END;

        gc.gridx = 1;
        gc.gridy = 7;
        gc.anchor = GridBagConstraints.LINE_START;
        add(femaleRadio, gc);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 1;
        gc.gridy = 8;
        gc.weighty = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, gc);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

}
