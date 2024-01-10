package exercises;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DisplayProfile extends JFrame {
    private JTable profileTable;
    private DefaultTableModel tableModel;

    public DisplayProfile() {
        setTitle("View Profile");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize JTable
        tableModel = new DefaultTableModel();
        profileTable = new JTable(tableModel);

        // Set column names
        String[] columns = {"Field", "Value"};
        tableModel.setColumnIdentifiers(columns);
        profileTable.setRowHeight(30); // Set the desired height (e.g., 30 pixels)

        JScrollPane scrollPane = new JScrollPane(profileTable);

        // Set preferred size for the table
        profileTable.setPreferredScrollableViewportSize(profileTable.getPreferredSize());

        // Set auto-resize mode for the columns
        profileTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Adjust column widths
        profileTable.getColumnModel().getColumn(0).setPreferredWidth(150); // Field
        profileTable.getColumnModel().getColumn(1).setPreferredWidth(250); // Value

        // Add padding to the left and right of the table
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(scrollPane);
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

    public void viewProfile() {
        ProfileData profileInfo = readProfileInfo();
        displayProfile(profileInfo);
    }

    private ProfileData readProfileInfo() {
        ProfileData profileInfo = null;
        try (FileInputStream fileIn = new FileInputStream("profile.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            profileInfo = (ProfileData) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return profileInfo;
    }

    private void displayProfile(ProfileData profileInfo) {
        if (profileInfo != null) {
            // Clear existing data in the table
            tableModel.setRowCount(0);

            // Add profile information to the table
            addRowToTable("Name", profileInfo.getName());
            addRowToTable("Height", profileInfo.getHeight());
            addRowToTable("Weight", profileInfo.getWeight());
            addRowToTable("Age", profileInfo.getAge());

            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No profile information found.", "View Profile", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addRowToTable(String field, String value) {
        Object[] rowData = {field, value};
        tableModel.addRow(rowData);
    }

    public static void main(String[] args) {
        DisplayProfile displayProfile = new DisplayProfile();
        displayProfile.viewProfile();
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
