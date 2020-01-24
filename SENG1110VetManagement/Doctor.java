//Name: Aaron Moss
//Student Number: c3282382
//date: 1/6/18
//SENG1110 Assignment2- this is a vet management system that allows a user add, delete, or edit doctors and pets in the system
//Doctor Class: Constructors And Getters/Setters for creating and editing a doctor

import java.util.*;
import java.io.*;
public class Doctor implements Serializable 
{
    private String name;    // the name of the doctor
    private String specialisation;  // the specialisation of the doctor (it can be cat or dog)
    
	//Empty constructor
    public Doctor()
    {
        name = "";
        specialisation = "";
    }
    
	//Doctor constructor
	public Doctor(String name, String specialisation) //has name and specialisation to be set
    {
        this.name = name;
        this.specialisation = specialisation;
    }
    
	//Sets name of doctor
    public void setName(String name)
    {
        this.name = name;
    }
	
    //Returns name of the doctor
    public String getName()
    {
        return name;
    }
	
	// sets specialisation of the doctor
    public void setSpecialisation(String specialisation)
    {
        this.specialisation = specialisation;
    }
	
	//Gets the specialisation of the doctor
    public String getSpecialisation()
    {
        return specialisation;
    }
	
	//Creates a generic doctor string 
    public String toString() 
    {
        return "Doctor Name: " + getName() + "\nDoctor Specialisation: " + getSpecialisation();
    }
}
