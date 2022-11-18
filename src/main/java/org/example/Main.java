package org.example;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

public class Main {
    // This is the main content of the window
    JFrame mainFrame;
    // This is a label, which will name the app
    JLabel titleLabel;
    // This is an input box, for the user to enter a number
    JTextField userInputField1;
    // This is an input box, for the user to enter a number
    JTextField userInputField2;
    // This is the output label, containing the response for the users string
    JLabel outputField;
    // This is the button that kicks it all in;
    JButton runButton;
    // This is a Panel, which groups together elements
    JPanel interactionPanel;
    // Dummy component to fix span
    JLabel __DummyLabel;

    public Main(){
        // I think this will run before main()
        // so in theory, I could initialize the whole thing here. then set the specifics within main.
        prepareMainFrame();
    }

    public static void main(String[] args){
        Main main = new Main();
        main.mainFrame.setVisible(true);
        main.prepareInteractionPanel();
    }

    private void prepareMainFrame(){
        // set up all class variables

        // when initializing a frame set its size
        mainFrame = new JFrame("Calculator");
        mainFrame.setSize(350,200);
        // Set the grid up and attach it to the main frame.
        // This frame consists of 3 rows and 1 column
        GridLayout mainFrameGrid = new GridLayout(3,1);
        mainFrame.setLayout(mainFrameGrid);
        // Set up the on close event to kill the app when closed
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // We want the window to kill the app cleanly.
                System.exit(0);
            }
        });


        // Set JLabel.Center below will align the component to the center of its column
        titleLabel = new JLabel("A calculator for toddler's", JLabel.CENTER);
        userInputField1 = new JTextField();
        userInputField2 = new JTextField();
        // As above set the label to be centered.
        outputField = new JLabel("value",JLabel.CENTER);
        runButton = new JButton("Submit");

        interactionPanel = new JPanel();

        // Add specified components to the main frame
        mainFrame.add(titleLabel);
        mainFrame.add(interactionPanel);
        mainFrame.add(outputField);

        __DummyLabel = new JLabel();

    }

    private void prepareInteractionPanel(){
        interactionPanel.setSize(300, 100);
        GridBagLayout panelGrid = new GridBagLayout();
        interactionPanel.setLayout(panelGrid);
        // Use the gbc to assign rows and columns
        GridBagConstraints gbc = new GridBagConstraints();
        userInputField1.setSize(50,100);
        userInputField2.setSize(50,100);

        // Not actually sure on the line below
        // TODO: Get reading. GridBagConstraints.fill:GridBagContstraints.Horizontal
        setComponentInLayout(interactionPanel, userInputField1, 0,0,1,1,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START, 0.5, 0.5);

        setComponentInLayout(interactionPanel, userInputField2, 1, 0, 1,1,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_END, 0.5,0.5);

        setComponentInLayout(interactionPanel,runButton,0,1,2,1,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 0,0);

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumbersFromInputs();
            }
        });
    }

    private void setComponentInLayout(@NotNull JPanel panel, JComponent component, int row, int column,
                                      int span_columns, int span_rows, int fill, int anchor,
                                      double weightx, double weighty){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = fill;
        gbc.gridy = column;
        gbc.gridx = row;
        gbc.gridwidth = span_columns;
        gbc.gridheight = span_rows;
        gbc.anchor = anchor;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        panel.add(component,gbc);


    }

    private void addNumbersFromInputs(){
        BigInteger num1 = BigInteger.valueOf(Long.parseLong(userInputField1.getText()));
        BigInteger num2 = BigInteger.valueOf(Long.parseLong(userInputField2.getText()));
        outputField.setText(String.valueOf(num1.add(num2)));
    }
}
