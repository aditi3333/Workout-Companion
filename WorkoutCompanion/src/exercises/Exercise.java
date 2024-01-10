package exercises;
import exercises.DataDisplayFrame;
import exercises.Menu;
import java.awt.BorderLayout;
import exercises.ExerciseData;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import exercises.Profile;
public class Exercise extends JFrame implements ActionListener{
	 public Map<String, JTextField> fieldMap;
	public JButton save;
	public List<ExerciseData> dataList;
	
	public Exercise()
	{
		super("Add Exercise");
		  fieldMap = new HashMap<>();
		  createField("exname", "Enter the exercise name: ");
		  createField("sets", "Enter the number of sets: ");
		  createField("reps", "Enter the number of reps: ");
		  createField("weight", "Enter the weight: ");
	      save = new JButton("Save");
	      dataList = new ArrayList<>();
	      save.addActionListener(this);

	        // Create a new panel with FlowLayout to center the button
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set layout to center
	        
	        buttonPanel.add(save); // Add the save button to this panel
	        
	        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));


		    add(buttonPanel);

	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(500, 400);
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
	 public void createField(String key,String labelText) {
		 JLabel label = new JLabel(labelText);
		    JTextField textField = new JTextField(10);
		    fieldMap.put(key, textField);
		    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		    panel.add(label);
		    panel.add(textField);
		    add(panel);
	    }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			
	       
			String exname = fieldMap.get("exname").getText();
			int sets = 0;
			int reps = 0;
			int weight = 0;
			try {
			sets = Integer.parseInt(fieldMap.get("sets").getText());
			reps = Integer.parseInt(fieldMap.get("reps").getText());
			weight = Integer.parseInt(fieldMap.get("weight").getText());
			
			}
			catch(NumberFormatException eq)
			{
				//eq.printStackTrace();
				if((Character.isDigit(sets)) == false) {
					sets = 0;
				}
				else if((Character.isDigit(reps))== false) {
					reps = 0;
				}
				else if((Character.isDigit(weight))==false) {
					weight = 0;
				}
				System.out.println("enter a number");
				
			}
	        
			
			addExercise(exname, sets, reps, weight);
	        fieldMap.get("exname").setText("");
	        fieldMap.get("sets").setText("");
	        fieldMap.get("reps").setText("");
	        fieldMap.get("weight").setText("");
       
	       
	}
	
	public void addExercise(String ex, int sets, int reps, int weight) {
		
		List<ExerciseData> exerciseList = new ArrayList<>();
		
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("exercise.ser"))) {
            exerciseList = (List<ExerciseData>) objectInputStream.readObject();
            System.out.println("Exercise data loaded successfully.");
        } catch (IOException | ClassNotFoundException e1) {
            System.out.println("No existing exercise data found.");
        }
		
		ExerciseData exercise = new ExerciseData(ex, sets, reps, weight);
		
		exerciseList.add(exercise);
		
		 try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("exercise.ser"))) {
	            objectOutputStream.writeObject(exerciseList);
	            System.out.println("Exercise data saved to exercise.ser.");
	        } catch (IOException e2) {
	            e2.printStackTrace();
	        }
		
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
