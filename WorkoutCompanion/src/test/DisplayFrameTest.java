package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exercises.DataDisplayFrame;
import exercises.ExerciseData;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class DisplayFrameTest {



	private DataDisplayFrame dataDisplayFrame;
    private Path testFilePath;

    @Before
    public void setUp() {
        testFilePath = createTestFile();
        dataDisplayFrame = new DataDisplayFrame();
    }

    @After
    public void tearDown() {
        deleteTestFile();
    }

    @Test
    public void testReadExerciseDataFromFile() {
        List<ExerciseData> exerciseList = dataDisplayFrame.readExerciseDataFromFile(testFilePath.toString());

        assertTrue(exerciseList != null && !exerciseList.isEmpty());
    }

  

    // Helper method to create a test file with sample data
    private Path createTestFile() {
        List<ExerciseData> testData = new ArrayList<>();
        testData.add(new ExerciseData("Test", 3, 12, 50));

        try {
            Path filePath = Files.createTempFile("exercise", ".ser");
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(filePath))) {
                objectOutputStream.writeObject(testData);
            }
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("Error creating test file", e);
        }
    }

    // Helper method to delete the test file
    private void deleteTestFile() {
        try {
            Files.deleteIfExists(testFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
