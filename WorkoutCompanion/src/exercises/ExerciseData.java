package exercises;
import java.io.Serializable;

import exercises.Exercise;
public class ExerciseData implements Serializable {
	 private static final long serialVersionUID = 1L; // Recommended for Serializable classes

	   


		private String exerciseName;
	    private int sets;
	    private int reps;
	    private int weight;

	    // Constructors, getters, and setters
	    public ExerciseData(String exerciseName, int sets, int reps, int weight) {
	 
	        this.exerciseName = exerciseName;
	        this.sets = sets;
	        this.reps = reps;
	        this.weight = weight;
	    }
	    
		public String getExerciseName() {
			return exerciseName;
		}
		public void checkfornegset()
		{
			if(sets < 0)
			{
				throw new IllegalArgumentException("sets less than zero");
			}
		}
		public void checkfornegreps()
		{
			if(reps < 0)
			{
				throw new IllegalArgumentException("reps less than zero");
			}
		}
		public void checkfornegweight()
		{
			if(weight < 0)
			{
				throw new IllegalArgumentException("weight less than zero");
			}
		}
		public void setExerciseName(String exerciseName) {
			this.exerciseName = exerciseName;
		}

		public int getSets() {
			return sets;
		}

		public void setSets(int sets) {
			this.sets = sets;
		}

		public int getReps() {
			return reps;
		}

		public void setReps(int reps) {
			this.reps = reps;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
