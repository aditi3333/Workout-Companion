package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercises.Exercise;
import exercises.ExerciseData;

public class Negative {
	 private ExerciseData ex ;
	 
	//testing for exercise
		 @Test
		    @DisplayName("Error when sets is negative")
		    public void testforSetsnegativevalue() {
			
		    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    		ex = new ExerciseData("name", -1, 9 , 9);
		           
		           ex.checkfornegset();
		        });
		    }
		 @Test
		    @DisplayName("Error when reps is negative")
		    public void testforRepsnegativevalue() {
			
		    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    		ex = new ExerciseData("name", 1, -9 , 9);
		           
		           ex.checkfornegreps();
		        });
		    }
		 @Test
		    @DisplayName("Error when weight is negative")
		    public void testforWeightsnegativevalue() {
			
		    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    		ex = new ExerciseData("name", 1, 9 , -9);
		           
		           ex.checkfornegweight();
		        });
		    }
}
