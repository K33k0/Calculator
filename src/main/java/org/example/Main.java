package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    // This is the main content of the window
    JFrame mainFrame;
    // This is a label, which will name the app
    JLabel titleLabel;
    // This is an input box, for the user to enter a string
    JTextField userInputField;
    // This is the output label, containing the response for the users string
    JLabel outputField;
    // This is the button that kicks it all in;
    JButton runButton;
    // This is a Panel, which groups together elements
    JPanel interactionPanel;

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
        userInputField = new JTextField();
        // As above set the label to be centered.
        outputField = new JLabel("",JLabel.CENTER);
        runButton = new JButton("Submit");

        interactionPanel = new JPanel();

        // Add specified components to the main frame
        mainFrame.add(titleLabel);
        mainFrame.add(interactionPanel);
        mainFrame.add(outputField);

    }

    private void prepareInteractionPanel(){
        interactionPanel.setSize(300, 100);
        GridLayout panelGrid = new GridLayout(2,2);
        interactionPanel.setLayout(panelGrid);
        // Use the gbc to assign rows and columns
        GridBagConstraints gbc = new GridBagConstraints();

        // Not actually sure on the line below
        // TODO: Get reading. GridBagContstraints.Horizontal
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Grid X is row number
        gbc.gridx = 0;
        // Grid Y is column number
        gbc.gridy = 0;
        // add component to panel, 2nd argument is the constraints.
        interactionPanel.add(userInputField, gbc);

        gbc.gridy = 1;
        interactionPanel.add(runButton, gbc);

    }
}
