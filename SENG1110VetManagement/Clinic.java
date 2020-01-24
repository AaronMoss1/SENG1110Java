//Name: Aaron Moss
//Student Number: c3282382
//date: 1/6/18
//SENG1110 Assignment2
//Program: this is a vet management system that allows a user add, delete, or edit doctors and pets in the system, objective of assignment was to use arrays

import java.util.*;
import java.io.*;

public class Clinic
{
    private Doctor[] doctorList = new Doctor[3]; // initialising the list to 3, this stores doctors
    private Pet[] petList = new Pet[3]; //initialising the list to 3, stores pets
    private int doctorCount = 0; //counts doctors
    private int doctorIndex = 0; //counts the index number of the doctor 
    private int petCount = 0; 
    private int petIndex = 0;
    Scanner key = new Scanner(System.in);
	
	public int chooseOption() //main menu prints
    {
        int optionChoice;
        System.out.println("\nPlease Enter A Number To Select An Option: ");
        System.out.println("Option 1: Add Doctor");
        System.out.println("Option 2: Add Pet");
        System.out.println("Option 3: Delete Doctor");
        System.out.println("Option 4: Delete Pet");
        System.out.println("Option 5: List Of Doctors");
        System.out.println("Option 6: List Of Pets");
        System.out.println("Option 7: Analyse Pet");
        System.out.println("Option 8: Assign Doctor To A Pet");
        System.out.println("Option 9: List Of Pets Under Doctor");
        System.out.println("Option 10: Edit Pet");
        System.out.println("Enter 11 to exit the system");
        optionChoice = key.nextInt(); //asks for number selection
        return optionChoice;
    }
	
	//This controls the system flow and what happens in the system, run in the main method, the main menu of the program for user selection
    private void run() 
    {
        int option;
        do
        {
            option = chooseOption(); //calls choose option method which returns an integer
            switch (option) //the int passed in by the user selects an option within the system
            {
                case 1: addDoctor();
                break;
                case 2: addPet();
                break;
                case 3: deleteDoctor();
                break;
                case 4: deletePet();
                break;
                case 5: listDoctors();
                break;
                case 6: listPets();
                break;
                case 7: analysePet();
                break;
                case 8: assignDoctor();
                break;
                case 9: listOfPetsUnderDoctor();
                break;
                case 10: editPet(); // allows the user to change a pets stats besides their name and doctor
                break;
                case 11: System.exit(0);
				break;
            }
        }
        while (option!=-1);
    }
	
    public static void main(String[] args)
    {
        System.out.println("Welcome To The Vet Management System!");
        Clinic clinic = new Clinic();
        clinic.run(); //calling the run method
    }
	
	//Adds a doctor in to the system
    public void addDoctor() //this method adds a doctor in to the system
    {
        String name, specialisation;
        System.out.println("\nAdd Doctor: ");
        System.out.println("What is your name? ");
        name = key.next();
        name = name.toLowerCase(); //adds everything as a lower case, so no matter on the text passed through, everything is checked in lower case
        for(int i = 0; i < doctorList.length; i++) //cycles through the whole list to see if the name inputted is already in the system
        {
            if(doctorList[i] != null)
			{
				while(name.equals(doctorList[i].getName())) //does a check if the name is in the system, if so repeats
                {
                    System.out.println("Name Already Exists In System, Please Enter New Name: ");
                    name = key.next();
                    name = name.toLowerCase();
                }
            }
        }
        System.out.print("what is your specialisation? (Cat Or Dog Only) ");
        specialisation = key.next();
        specialisation = specialisation.toLowerCase();
        while (! specialisation.equals("dog") && ! specialisation.equals("cat")) //ensures input is only cat or dog
        {
            System.out.print("Invalid! what is your specialisation? (Cat Or Dog Only)  ");
            specialisation = key.next();
            specialisation = specialisation.toLowerCase();
        }
        System.out.println("Congratulations! New Doctor Added!");
        Doctor doctor = new Doctor(name, specialisation); //adds a new doctor with the arguments inputted by the user
        if(doctorIndex >= doctorList.length)
        {
            resizeDoctor(doctor, doctorIndex); //resizes the list calling the resize function by the index count of the doctor
        }
        else
        {
            doctorList[doctorIndex] = doctor; //if there is space in the system it adds the doctor to the index location
        }
        doctorIndex++;
        doctorCount++; //adds count and index by 1 after a doctor is added
    }
	
	//Adds a pet to the system
    public void addPet()
    {
        String type, size, name, doctor;
        int age;
        double weight;
        System.out.println("\nAdd Pet: ");
        System.out.print("what is the name of this pet? ");
        name = key.next();
        name = name.toLowerCase();
        for(int i = 0; i < petList.length; i++) //cycles through a whole list to see if the name is already in the system
        {
            if(petList[i] != null)
            {
                while(name.equals(petList[i].getName())) //prompts the user until input is not matching to something stored in system
                {
                    System.out.println("Name Already Exists In System, Please Enter New Name: ");
                    name = key.next();
                    name = name.toLowerCase();
                }
            }
        }
        System.out.print("Size Of The Animal? (Note Small, Medium And Large Are The Only Accepted Inputs) ");
        size = key.next();
        size = size.toLowerCase();
        while (! size.equals("small") && ! size.equals("medium") && ! size.equals("large")) //size can only be small medium or large
        {
            System.out.print("Invalid! Size Of The Animal? (Note Small, Medium And Large Are The Only Accepted Inputs) ");
            size = key.next();
            size = size.toLowerCase();
        }
        System.out.print("What type of animal is your pet? (Dog or Cat) ");
        type = key.next();
        type = type.toLowerCase();
        while (! type.equals("dog") && ! type.equals("cat"))//does not allow anything hat is not a cat or dog
        {
            System.out.print("Invalid Input! What Type Of Animal Is Your Pet? (Dog or Cat) ");
            type = key.next();
            type = type.toLowerCase();
        }
        System.out.print("What is the weight of this pet? ");
        weight = key.nextDouble();
        while (weight < 0) //checks if weight is less than 0, ensures correct weight is added
        {
            System.out.print("Invalid Input! What is the weight of this pet? (below -1 not valid) ");
            weight = key.nextDouble();
        }
        System.out.print("what is the age of your pet? ");
        age = key.nextInt();
        while (age < 0) //checks age is less than 0
        {
            System.out.print("Invalid Input! what is the age of your pet? (below -1 not valid)");
            age = key.nextInt();
        }
        System.out.println("Congratulations Pet Added! ");
        Pet pet = new Pet(type, size, name, weight, age, "no doctor assigned"); // adds pets with following arguments
        if(petIndex >= petList.length)
        {
            resizePet(pet, petIndex); //calls the resize method with arguments if the index is above the length 
        }
        else
        {
            petList[petIndex] = pet; // if the index spot is available the pet will be added to this spot
        }
        petIndex++;
        petCount++;
    }
	
	//Resizes the doctor list by 1 when the method is called, if the list is required to go over the initial size this method is called
    public void resizeDoctor(Doctor doctor, int indexNum) 
    {
        Doctor[] doctorOverWrite = new Doctor[doctorList.length + 1]; //new list to overwrite
        for(int i = 0; i < doctorList.length; i++)
        {
            doctorOverWrite[i] = doctorList[i]; //copies the list
        }
        doctorList = doctorOverWrite; //giving doctorList the variable name of the new list so the program and list names are consistent
        doctorList[indexNum] = doctor; //adds the doctor
    }
	
	//Resizes the pet list by 1 when the method is called, if the list is required to go over the initial size this method is called
    public void resizePet(Pet pet, int indexNum)
    {
        Pet[] petOverWrite = new Pet[petList.length + 1];//new list to overwrite, makes the list larger by 1
        for(int i = 0; i < petList.length; i++)
        {
            petOverWrite[i] = petList[i];//copies the list
        }
        petList = petOverWrite; //giving petList the variable name of the list that was overwritten
        petList[indexNum] = pet; //adds the pet to the list
    }
	
	//Takes the input of a doctors name and then deletes the doctor if the doctor is in the system
    public void deleteDoctor() 
    {
        String docDeleteName; //name input
        if(doctorsNull()) //calls a method to check if everything in the array is null
        {
            System.out.println("No Doctors In The System! ");
            run();
        }
        else //doctors available
		{
			System.out.println("Enter Doctors Name To Be Deleted: ");
			docDeleteName = key.next();
			docDeleteName = docDeleteName.toLowerCase();
			for(int i = 0; i < petList.length; i++) //cycles through the pet list to see if the inputted name is associated with a pet
			{
				if(petList[i] != null && docDeleteName.equals(petList[i].getDoctor())) //if the name is associated with a pet
				{
					petList[i].setDoctor("no doctor assigned"); //if its found, set the pets doctor to nothing as the doctors removed
				}
			}
			for(int i = 0; i < doctorList.length; i ++)
			{
				if(doctorList[i] != null &&  docDeleteName.equals(doctorList[i].getName())) //if the name equals a doctor in the system after list cycle
				{
					System.out.println("Doctor Found And Removed! ");//shows the doctor is found
					doctorList[i] = null;
					doctorCount--;//sets doctor to null and brings down doctor count
					run();
				}
			}
			for(int i = 0; i < doctorList.length; i++)
			{
				if(doctorList[i] != null && ! docDeleteName.equals(doctorList[i].getName()))//if the name is not in the system 
				{
					System.out.println("No Doctors In The System Have That Name! "); 
					run();
				}
			}
        }
    }
	
	//Deletes a pet
    public void deletePet() 
    {
        String petDeleteName;
        if(petsNull())
        {
            System.out.println("No Pets In The System! ");
        }
        else
		{
			System.out.println("Enter Pets Name To Be Deleted: ");
			petDeleteName = key.next();
			for(int i = 0; i < petList.length; i ++)//cycles through pet list
			{
				if(petList[i] != null &&  petDeleteName.equals(petList[i].getName())) //if the name is in the system
				{
					System.out.println("Pet Found And Removed! ");
					petList[i] = null;
					petCount--;//if the name is found make the pet null and bring the count down
					run();
				}
			}
			for(int i = 0; i < petList.length; i ++)
			{
				if(petList[i] != null && ! petDeleteName.equals(petList[i].getName())) //if the inputted name is not in the system it shows a message
				{
					System.out.println("No Pets In The System Have That Name! ");
					run();
				}
			}
        }
    }
	
	//Prints out doctors and their information
    public void listDoctors() 
    {
        if(doctorsNull())
        {
            System.out.println("No Doctors In The System! "); //checks if something is in the system
        }
        else
        {
            for(int i = 0; i < doctorList.length; i++)//cycles through doctor list
            {
                if(doctorList[i] != null)//if the element is not null it will print out the element in the list until the for loop is over
                    System.out.println(doctorList[i] + "\n");
            }
        }
    }
	
	//Lists pets and their details in the system
    public void listPets() 
    {
        if(petsNull())
        {
			System.out.println("No Pets In The System! "); //checks if their are pets in the system
        }
        else
        {
            for(int i = 0; i < petList.length; i++)//cycles through pet list
            {
                if(petList[i] != null)//whatever is not null will print the element specified until the for loop is over
                    System.out.println(petList[i] + "\n");
            }
        } 
    }
	
	//A method that checks if there are pets in the system
    public boolean petsNull()
    {
        boolean empty = true;
        for(int i = 0; i < petList.length; i++)
        {
            if(petList[i] != null)//if something in the list is not null, boolean will be false
            {
                empty = false;
            }
        }
        return empty;//returns boolean
    }
	
	//A method that checks if there are doctors in the system
    public boolean doctorsNull()
    {
        boolean empty = true;
        for(int i = 0; i < doctorList.length; i++)
        {
            if(doctorList[i] != null)//if something in the list is not null, the boolean will be false
            {
                empty = false;
            }
        }
        return empty;//returns boolean
    }
	
	//Allows the user to edit all information of a pet besides name and doctor
    public void editPet()
    {
        if(petsNull()) //checks if there are pets in the system
        {
            System.out.println("No Pets In The System! ");
            run(); 
        } 
        String petName, size, type, doctor;
        int age;
        double weight;
        System.out.println("Enter Name Of Pet To Be Edited: ");
        petName = key.next();
        petName = petName.toLowerCase();
        for(int i = 0; i < petList.length; i++)//cycles through pet array
        {
            if(petList[i] != null && petName.equals(petList[i].getName())) //if the name inputted is in the system it runs this to edit all information
            {
                System.out.println("Edit information for " + petList[i].getName() + ":");
                System.out.println("Size Of The Animal? (Note Small, Medium And Large Are The Only Accepted Inputs) ");
                size = key.next();
                size = size.toLowerCase();
                while (! size.equals("small") && ! size.equals("medium") && ! size.equals("large")) //size can only be small medium or large
                {
                    System.out.print("Invalid! Size Of The Animal? (Note Small, Medium And Large Are The Only Accepted Inputs) ");
                    size = key.next();
                    size = size.toLowerCase();
                }
                System.out.println("What Type Of Animal Is Your Pet? (Dog or Cat) ");
                type = key.next();
                type = type.toLowerCase();
                while (! type.equals("dog") && ! type.equals("cat"))//does not allow anything not cat or dog
                {
                    System.out.print("Invalid Input! What Type Of Animal Is Your Pet? (Dog or Cat) ");
                    type = key.next();
                    type = type.toLowerCase();
                }
                System.out.println("What is the weight of this pet? ");
                weight = key.nextDouble();
                while (weight < 0) //checks weight is above 0
                {
                    System.out.print("Invalid Input! What is the weight of this pet? (below -1 not valid) ");
                    weight = key.nextDouble();
                }
                System.out.println("Age: ");
                age = key.nextInt();
                while (age < 0) //checks age is above 0
                {
                    System.out.print("Invalid Input! what is the age of your pet? (below -1 not valid)");
                    age = key.nextInt();
                }
                System.out.println("Congratulations! Pet Details Updated!");
                if(petList[i].getDoctor().equals("no doctor assigned"))//if no doctos is assigned it adds the information of the pet with following arguments
                {
                    Pet pet = new Pet(type, size, petName, weight, age, "no doctor assigned");
                    petList[i] = pet; //makes element new pet, overwrites
                }
                else //if doctor is assigned
                {
                    doctor = petList[i].getDoctor();//gets name and variable doctor
                    Pet pet = new Pet(type, size, petName, weight, age, doctor);
                    petList[i] = pet; //pet is updated and placed in the element specified with arguments as listed above
                }
                System.out.println(petList[i] + "\n");
                run();
            }
        }
        for(int i = 0; i < petList.length; i ++) //checks if the name isnt in the system
        {
            if(petList[i] != null && ! petName.equals(petList[i].getName()))
            {
                System.out.println("That Name Does Not Exist In The System! "); 
                run();
            }
        }
    }
	
	//List pets under a certain doctor
    public void listOfPetsUnderDoctor() 
    {
        if (petsNull() && doctorsNull()) //checks if their is anything in the system
        {
            System.out.println("Nothing in the system!");
            run();
        }
        else if (petsNull())
        {
            System.out.println("No Pets In The System!");
            run();
        }
        else if (doctorsNull())
        {
            System.out.println("No Doctors In The System!");
            run();
        }
        String inputDocName;
        System.out.println("Enter Doctor Name: ");
        inputDocName = key.next();
        inputDocName = inputDocName.toLowerCase();
        for(int i = 0; i < doctorList.length; i ++) //loops through all doctors
        {
            if(doctorList[i] != null && inputDocName.equals(doctorList[i].getName()))//checks input
            {
                System.out.println("Doctor " + inputDocName + ":"); //checks if the doctor is in the system and prints this out
            }
        }
        for(int i = 0; i < petList.length; i ++) //loops over pets
        {
            if(petList[i] != null && petList[i].getDoctor().equals(inputDocName))
            {
                System.out.println("This Doctor Treats: " + petList[i].getName());//displays the pets the doctor treats
                run();
            }
        }
        for(int i = 0; i < petList.length; i ++)
        {
            if(petList[i] != null && ! petList[i].getDoctor().equals(inputDocName))
            {
                System.out.println("This Doctor Does Not Treat Any pet or has not been registered in the system, please retry! ");
                run();//shows if the doctor isnt in the system or doesnt treat a pet
            }
        }
    }
	
	//Allows the user to assign a doctor to a pet
    public void assignDoctor()
    {
        if (petsNull() && doctorsNull()) //checks if their is anything in the system
        {
            System.out.println("Nothing in the system to add!");
            run();
        }
        else if (doctorsNull()) //if there are no doctors in the system
        {
            System.out.println("No Doctors in the system!");
            run();
        }
        else if (petsNull()) //if there are no pets in the system
        {
            System.out.println("No Pets To Add!");
            run();
        }
        System.out.println("Name Of The Pet To Be Worked On: ");
        String petName = key.next();
        petName = petName.toLowerCase();
        System.out.println("Name Of The Doctor: ");
        String docName = key.next();
        docName = docName.toLowerCase();
        for(int i = 0; i < petList.length; i++)//cycles pets
        {
            if(petList[i] != null && petList[i].getName().equals(petName))//if pet name input in system
            {
                for(int j = 0; j < doctorList.length; j++)//cycles doctors
                {
                    if(doctorList[j] != null && doctorList[j].getName().equals(docName))//if doctor in system
                    {
                        if(petList[i].getDoctor().equals("no doctor assigned"))//if no doctor assigned
                        {
                            if(petList[i].getType().equals(doctorList[j].getSpecialisation()))//if the doctor spec equals pet type
                            {
                                petList[i].setDoctor(docName);
                                System.out.println("Doctor Assigned!");
                                run();
                            }
                            else
                            {
                                System.out.println("This Doctor Can Not Work On This Pet");
                                run();
                            }
                        }
                        else //if pet has doctor
                        {
                            if(docName.equals(petList[i].getDoctor()))//if doctor already working on pet
                            {
                                System.out.println("This doctor is already Assigned to this pet! ");
                                run();
                            }
                            else//offers option to replace current doctor with integer input
                            {
                                System.out.println("Do you want to replace the current doctor? If so press 1, press any other key for no ");
                                int n = key.nextInt();
                                if(n ==1)
                                {
                                    System.out.println("Previous Doctor Removed, The New Doctor Working On This Pet Is Doctor " + docName + "!");
                                    petList[i].setDoctor(docName);
                                    run();//replaces
                                }
                                else
                                {
                                    System.out.println("You Selected No! ");
                                    run();//does not replace
                                }
                            }
                        }
                    } //ends if doctor is in system
                } //end doctor cycle
            } //end if pet is in system
        } //end pet cycle
        for(int i = 0; i < petList.length; i ++)
        {
            if(petList[i] != null && ! petName.equals(petList[i].getName()))
            {
                System.out.println("No Pet In The System Matches That Name! ");//checks if pets in system
            }
        }
        for(int i = 0; i < doctorList.length; i ++)
        {
            if(doctorList[i] != null && ! docName.equals(doctorList[i].getName()))
            {
                System.out.println("No Doctor In The System Matches That Name! ");//checks if pet is in system
            }
        }
        run();
    }
	
	//allows user to see pet details and determine if the the animal is overweight
    public void analysePet() 
    {
		if(petsNull()) //checks to see if pets exist in the system
	    {
			System.out.println("No Pets In The System! ");
            run();
		} 
		String analysePetName;
		System.out.println("Enter Pet Name To Analyse! ");
		analysePetName = key.next();
		analysePetName = analysePetName.toLowerCase();
		for(int i = 0; i < petList.length; i++)//cycles pet array
		{
			if(petList[i] != null && analysePetName.equals(petList[i].getName())) //checks if it is equal to the name
			{
				if(petList[i].getType().equals("cat"))//if the type is cat
				{
					System.out.println(petList[i]);
					if(petList[i].getSize().equals("small")) //if its small check weight and does the same for medium and large
					{
						if(petList[i].getWeight() > 4.00)
						{
							System.out.print("We have found that the cat is overweight\n");
						}
						else {System.out.print("We have found that the cat is a healthy weight\n");}
					} //end of small cat
					if (petList[i].getSize().equals("medium"))//if size is medium
					{
						if(petList[i].getWeight() > 6.00)
						{
							System.out.println("We have found that the cat is overweight\n");
						}
						else {System.out.println("We have found that the cat is healthy weight\n");}
					}
					if (petList[i].getSize().equals("large\n"))//large cat
					{
						if(petList[i].getWeight() > 8.00)
						{
							System.out.println("We have found that the cat is overweight\n");
						}
						else { System.out.println("We have found that the cat is healthy Weight\n"); }
					}//end of pet large
				}//end of pet type cat
				if(petList[i].getType().equals("dog")) //now if pet is dog
				{
					System.out.println(petList[i]);
					if(petList[i].getSize().equals("small")) //checks weight for small medium and large, firstly small is checked
					{
						if(petList[i].getWeight() > 6.00)
						{
							System.out.print("We have found that the dog is overweight\n");
						}
						else {System.out.print("We have found that the dog is a healthy weight\n");}
					}//end of small dog
					if (petList[i].getSize().equals("medium")) //medium dog
					{
						if(petList[i].getWeight() > 9.00)
						{
							System.out.println("We have found that the dog is overweight\n");
						}
						else {System.out.println("We have found that the dog is healthy weight\n");}
					} //end of medium dog
					if (petList[i].getSize().equals("large")) //large dog
					{
						if(petList[i].getWeight() > 12.00)//checks integer to determine output
						{
							System.out.println("We have found that the dog is overweight\n");
						}
						else { System.out.println("We have found that the dog is healthy Weight\n"); }
					}//end of pet large
				}//end of pet type dog
				run();
			}//end of pet analysis if name found
		}
		for(int i = 0; i < petList.length; i++) //runs through the pet array
	    {
			if(petList[i] != null && ! analysePetName.equals(petList[i].getName()))//if the inputted name is not in the system
			{
				System.out.println("That Name Does Not Exist In The System! ");
				run();
			}
		}
    } //end analyse pet
}//end program


