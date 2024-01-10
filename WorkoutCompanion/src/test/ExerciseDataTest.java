package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.swing.BoxLayout;

import org.junit.Before;
import org.junit.Test;

import exercises.Exercise;
import exercises.ExerciseData;

public class ExerciseDataTest {

    private Exercise exercise;

    @Before
    public void setUp() {
        exercise = new Exercise();
    }

    
    @Test
    public void testCreateField() {
        exercise.createField("testKey", "Test Label");

        assertNotNull(exercise.fieldMap.get("testKey"));
    }

    @Test
    public void testConstructor() {
        assertNotNull(exercise.fieldMap);
        assertNotNull(exercise.save);
        assertNotNull(exercise.dataList);
        assertTrue(exercise.getContentPane().getLayout() instanceof BoxLayout);
    }
}
