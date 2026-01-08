package model;

public class Passenger {
    private String name;
    private int age;
    private String gender;
    private String phone;
   

    public Passenger(String name, int age, String gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
    
    
	public void displayPassengerInfo() {
        System.out.println("Passenger: " + name + ", Age: " + age + ", Gender: " + gender + ", Phone: " + phone);
    }
}