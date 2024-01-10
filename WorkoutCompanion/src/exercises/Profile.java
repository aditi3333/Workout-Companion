package exercises;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Profile extends JFrame {
	 private JTextField nameField, heightField, weightField, ageField;
	 public Map<String, JTextField> fieldMap;
	 public Profile() {
	        setTitle("Profile Form ");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        fieldMap = new HashMap<>();
			  createField("nameField", "Name: ");
			  createField("heightField", "Height: ");
			  createField("ageField", "Age ");
			  createField("weightField", "Weight: ");
	        JButton submitButton = new JButton("Submit");
	        submitButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                handleSubmitButton();
	            }
	    	
	        });

	        // Create a new panel with FlowLayout to center the button
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set layout to center
	        
	        buttonPanel.add(submitButton); // Add the save button to this panel
	        
	        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));


		    add(buttonPanel);

	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(500, 400);
	 }
	 public void createField(String key,String labelText) {
		 JLabel label = new JLabel(labelText);
		    JTextField textField = new JTextField(10);
		    fieldMap.put(key, textField);
		    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		    panel.add(label);
		    panel.add(textField);
		    add(panel);
	    }
	 private void handleSubmitButton() {
		 	String name = fieldMap.get("nameField").getText();
	        String height = fieldMap.get("heightField").getText();
	        String weight = fieldMap.get("ageField").getText();
	        String age = fieldMap.get("weightField").getText();
		       
			
	        addProfile(name, height, weight, age);
	        // Create a ProfileInfo object with the entered profile information
	        
	    }
	 
	 private void serializeProfileInfo(ProfileData profile) {
	        try (FileOutputStream fileOut = new FileOutputStream("profile.ser");
	             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
	            objectOut.writeObject(profile);
	            System.out.println("Profile information serialized and stored.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void addProfile(String name, String height, String weight, String age) {
		 	ProfileData profile = new ProfileData(name, height, weight, age);

	        // Serialize the ProfileInfo object and store it in a file
	        serializeProfileInfo(profile);

	        Menu frame = new Menu();
	        frame.setVisible(true);
	 }
	 
	 public static void main(String[] args) {
			String filepath = "C:\\Users\\ASUS\\Desktop\\Eclipse Projects\\WorkoutCompanion\\profile.ser"; 
			Path path = Paths.get(filepath);
			if(Files.exists(path)) {
				Menu frame = new Menu();
				frame.setVisible(true);
			}
			else {
				Profile frame = new Profile();
				frame.setVisible(true);
			}
		
		}
	 
	 

}
