package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercises.Profile;

public class ProfileTest {
	private Profile profile;
    //Test when name is null
    @Test
    @DisplayName("Error when name is null")
    public void testNameNull() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            profile.addProfile(null, "183", "75", "21");
        });
    }
    
  //Test when height is null
    @Test
    @DisplayName("Error when height is null")
    public void testHeightNull() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            profile.addProfile("Jack", null, "75", "21");
        });
    }
    
  //Test when weight is null
    @Test
    @DisplayName("Error when weightis null")
    public void testWeightNull() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            profile.addProfile("Jack", "183", null, "21");
        });
    }
    
    
  //Test when age is null
    @Test
    @DisplayName("Error when Exercise name is null")
    public void testAgeNull() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            profile.addProfile("Jack", "183", "75", null);
        });
    }
    
    
  //Test when all are null
    @Test
    @DisplayName("Error when all input is null")
    public void allNull() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
            profile.addProfile(null, null, null, null);
        });
    }
    
    
}
