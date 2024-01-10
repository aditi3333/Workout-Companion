package exercises;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DataDisplayFrame extends JFrame {
    private List<ExerciseData> exerciseList;
 

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        return label;
    }

    public DataDisplayFrame() {
        super("Exercise Data");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        exerciseList = readExerciseDataFromFile("exercise.ser");

        if (exerciseList != null && !exerciseList.isEmpty()) {
            for (ExerciseData data : exerciseList) {
                add(createLabel("Exercise Name: " + data.getExerciseName()));
                add(createLabel("Number of Sets: " + data.getSets()));
                add(createLabel("Number of Reps: " + data.getReps()));
                add(createLabel("Weight: " + data.getWeight()));
                add(createLabel("")); // Empty space between exercises
            }
        } else {
            add(createLabel("No exercise data available"));
        }

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


        // Set frame visibility
        setVisible(true);
    }

    public List<ExerciseData> readExerciseDataFromFile(String fileName) {
        List<ExerciseData> exerciseList = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            exerciseList = (List<ExerciseData>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return exerciseList;
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
