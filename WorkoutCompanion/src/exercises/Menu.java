package exercises;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Exercise Tracker");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        JButton viewProfileBtn = new JButton("View Profile");
        JButton addExerciseBtn = new JButton("Add Exercise");
        JButton viewExerciseBtn = new JButton("View Exercise");

        // Add action listeners to buttons
        viewProfileBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayProfile();
                // Add code to view profile
            }
        });

        addExerciseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExercise();
                // Add code to add exercise
            }
        });

        viewExerciseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayExercise();
                // Add code to view exercise
            }
        });

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu exerciseMenu = new JMenu("Options");

        // Create menu items
        JMenuItem viewProfileItem = new JMenuItem("View Profile");
        JMenuItem addExerciseItem = new JMenuItem("Add Exercise");
        JMenuItem viewExerciseItem = new JMenuItem("View Exercise");

        // Add action listeners to menu items
        viewProfileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayProfile();
                // Add code to view profile
            }
        });

        addExerciseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExercise();
                // Add code to add exercise
            }
        });

        viewExerciseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayExercise();
                // Add code to view exercise
            }
        });

        // Add menu items to the menu
        exerciseMenu.add(viewProfileItem);
        exerciseMenu.add(addExerciseItem);
        exerciseMenu.add(viewExerciseItem);

        // Add the menu to the menu bar
        menuBar.add(exerciseMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Create a panel and add buttons to it
        JPanel panel = new JPanel();
        panel.add(viewProfileBtn);
        panel.add(addExerciseBtn);
        panel.add(viewExerciseBtn);

        // Add panel to the frame
        add(panel);

        // Set frame visibility
        setVisible(true);
    }

    private void addExercise() {
        Exercise frame = new Exercise();
        frame.setVisible(true);
    }

    public void displayExercise() {
        DataDisplayFrame frame = new DataDisplayFrame();
        frame.setVisible(true);
    }

    public void displayProfile() {
        DisplayProfile frame = new DisplayProfile();
        frame.viewProfile();
    }

   
}
