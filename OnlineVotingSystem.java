/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication12;

/**
 *
 * @author ramas
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineVotingSystem extends JFrame {
    private JTextField nameField, phoneField, idField;
    private JRadioButton genZButton, millennialsButton, genAlphaButton;
    private JButton submitButton, checkResultsButton;
    private int g1 = 0, g2 = 0, g3 = 0;

    public OnlineVotingSystem() {
        setTitle("Online Voting System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 25);
        add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(20, 60, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(120, 60, 200, 25);
        add(phoneField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 100, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 100, 200, 25);
        add(idField);

        genZButton = new JRadioButton("Generation Z");
        genZButton.setBounds(20, 140, 120, 25);
        add(genZButton);

        millennialsButton = new JRadioButton("Millennials");
        millennialsButton.setBounds(140, 140, 120, 25);
        add(millennialsButton);

        genAlphaButton = new JRadioButton("Generation Alpha");
        genAlphaButton.setBounds(260, 140, 120, 25);
        add(genAlphaButton);

        ButtonGroup group = new ButtonGroup();
        group.add(genZButton);
        group.add(millennialsButton);
        group.add(genAlphaButton);

        submitButton = new JButton("Submit Your Vote");
        submitButton.setBounds(20, 180, 150, 25);
        add(submitButton);

        checkResultsButton = new JButton("Check Results");
        checkResultsButton.setBounds(200, 180, 150, 25);
        add(checkResultsButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!genZButton.isSelected() && !millennialsButton.isSelected() && !genAlphaButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Select a Party");
                } else {
                    if (genZButton.isSelected()) {
                        g1++;
                    } else if (millennialsButton.isSelected()) {
                        g2++;
                    } else if (genAlphaButton.isSelected()) {
                        g3++;
                    }
                    JOptionPane.showMessageDialog(null, "Vote Submitted Successfully");
                }
            }
        });

        checkResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = "Generation Z: " + g1 + "\nMillennials: " + g2 + "\nGeneration Alpha: " + g3;
                String winner = "Winner: ";
                if (g1 > g2 && g1 > g3) {
                    winner += "Generation Z";
                } else if (g2 > g1 && g2 > g3) {
                    winner += "Millennials";
                } else if (g3 > g1 && g3 > g2) {
                    winner += "Generation Alpha";
                } else {
                    winner += "It's a tie!";
                }
                JOptionPane.showMessageDialog(null, result + "\n" + winner);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineVotingSystem().setVisible(true);
            }
        });
    }
}
