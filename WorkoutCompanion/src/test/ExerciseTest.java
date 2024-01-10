package test;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercises.Exercise;
import exercises.ExerciseData;
import exercises.Profile;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExerciseTest {

	private Exercise exercise;

	//Test when sets is 0
    @Test
    @DisplayName("Error when sets is 0")
    public void testSetsNotZero() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            exercise.addExercise("Deadlift", 0, 8, 50);
        });
    }
    
    
  //Test when reps is 0
    @Test
    @DisplayName("Error when reps is 0")
    public void testRepsNotZero() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            exercise.addExercise("Deadlift", 4, 0, 50);
        });
    }
    
    
  //Test when weight is 0
    @Test
    @DisplayName("Error when weight is 0")
    public void testWeightNotZero() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            exercise.addExercise("Deadlift", 4, 8, 0);
        });
    }
    
    
  //Test when Exercise name is null
    @Test
    @DisplayName("Error when Exercise name is null")
    public void testExNameNotNull() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            exercise.addExercise(null, 4, 8, 50);
        });
    }
    
    
  //Test when all fields are empty or 0
    @Test
    @DisplayName("Error when all fields are empty or 0")
    public void testEmptyInput() {
    	Assertions.assertThrows(Exception.class, () -> {
            exercise.addExercise("", 0, 0, 0); 
        });
    }
    
}

    




