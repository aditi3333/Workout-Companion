package exercises;

import java.io.Serializable;

public class ProfileData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String Name;
    private String Height;
    private String Weight;
    private String Age;
    
    public ProfileData(String Name, String Height, String Weight, String Age) {
        this.Name = Name;
        this.Height = Height;
        this.Weight = Weight;
        this.Age = Age;
    }
    
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
