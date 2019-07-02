package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());

        controller = new Controller();

        textPanel = new TextPanel();

        tablePanel = new TablePanel();
        tablePanel.setData(controller.getPeople());
        tablePanel.refresh();

        formPanel = new FormPanel();
        formPanel.setFormListener(event -> {
            controller.addPerson(event);
            tablePanel.refresh();
        });

        toolbar = new Toolbar();
        toolbar.setStringListener(text -> textPanel.appendText(text));

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        var menuBar = new JMenuBar();

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var exportDataItem = new JMenuItem("Export data...");
        exportDataItem.addActionListener(event -> {
            if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(fileChooser.getSelectedFile());
            }
        });


        var importDataItem = new JMenuItem("Import data...");
        importDataItem.addActionListener(event -> {
            if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(fileChooser.getSelectedFile());
            }
        });


        var exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> {
            int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure?", "Confirm exit", JOptionPane.OK_CANCEL_OPTION);
            if(action == JOptionPane.OK_OPTION) {
                this.dispose();
            }
        });
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        var windowMenu = new JMenu("Window");
        var showMenu = new JMenu("Show");
        var showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);

        showFormItem.addActionListener(event -> {
            boolean isSelected = ((JCheckBoxMenuItem)event.getSource()).isSelected();
            formPanel.setVisible(isSelected);
        });

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        menuBar.add(windowMenu);

        return menuBar;
    }
}
