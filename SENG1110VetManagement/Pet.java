//Name: Aaron Moss
//Student Number: c3282382
//date: 1/6/18
//SENG1110 Assignment2- this is a vet management system that allows a user add, delete, or edit doctors and pets in the system
//Pet Class: Constructors And Getters/Setters for creating and editing a pet

import java.io.*;
public class Pet implements Serializable
{
    private String type;    // the type of the pet. It can be only cat or dog
    private String size;    // the size of the pet. It can be only small, medium or large
    private String name;    // the name of the pet. 
    private double weight;  //the weight of the pet.
    private int age;        //the age of the pet.
    private String doctor;  // the doctor of the pet.
       
    //Empty Constructor
    public Pet()
    {
        type = "";
        size = "";
        name = "";
        weight = 0;
        age = 0;
        doctor = "no doctor assigned";
    }
	
	//Pet Constructor
    public Pet(String type, String size, String name, double weight, int age, String doctor)//all inputs are equal to specified section
    {
        this.type = type;
        this.size = size;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.doctor = doctor;
    }
	
	//Sets the type
    public void setType(String type) //sets type
    {
        this.type = type;
    }
    
	//Returns type
    public String getType()
    {
        return type;
    }
	
	//Set Size
    public void setSize(String size)
    {
        this.size = size;
    }
	
	//Return Size
    public String getSize()
    {
        return size;
    }
	
	//Set Name
    public void setName(String name)
    {
        this.name = name;
    }
	
	//Returns Name
    public String getName()
    {
        return name;
    }
	
	//Sets the weight
    public void setWeight(double weight) //sets weight as a double
    {
        this.weight = weight;
    }
	
	//Returns Weight
    public double getWeight()
    {
        return weight;
    }
	
	//Sets Age
    public void setAge(int age) //sets age as an integer
    {
        this.age = age;
    }
	
	//Returns Age
    public int getAge()
    {
        return age;
    }
	
	//Sets the Doctor of the pet
    public void setDoctor(String doctor)
    {
        this.doctor = doctor;
    }
	
	//Returns the name of the doctor of the pet
    public String getDoctor() 
    {
        return doctor;
    }
	
	//Creates a generic Pet String
    public String toString()
    {
        return "Pet Name: " + getName() + "\nPet Type: " + getType() + "\nPet Size: " + getSize() + "\nPet Weight: " + getWeight() + "kg" + "\nPet Age: " + getAge() + "\nPet Doctor: " + getDoctor();
    }
}
