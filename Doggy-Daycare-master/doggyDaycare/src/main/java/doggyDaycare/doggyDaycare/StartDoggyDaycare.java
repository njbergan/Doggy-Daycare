package doggyDaycare.doggyDaycare;

import java.util.Date;
import java.util.Scanner;

public class StartDoggyDaycare {

		
	static Scanner in = new Scanner(System.in);
	static DogDao dogHelper = new DogDao();
		
		
	static private void insertDog()
	{
		System.out.print("Enter owner ID: ");
		String ownerId = in.nextLine();
		System.out.print("Enter the dog's name: ");
		String name = in.nextLine();
		System.out.print("Enter the dog's breed: ");
		String breed = in.nextLine();
		System.out.print("Enter the dog's gender: ");
		String gender = in.nextLine();
		System.out.print("Enter the date: ");
		String date = in.nextLine();
		System.out.print("Does the dog have vaccinations?(Y or N): ");
		String vaccinations = in.nextLine();
		System.out.print("Enter the last visit: ");
		String lastVisit = in.nextLine();
		System.out.print("Is the dog active?(Y or N): ");
		String activeFlag = in.nextLine();
		
		boolean bVaccinations = false;
		if (vaccinations.equals("Y"))
		{
			bVaccinations = true; 
		}
		
		boolean bActiveFlag = false;
		if (activeFlag.equals("Y"))
		{
			bActiveFlag = true;
		}
		
		
		//not sure how to add dates here to test
		Dog toAdd = new Dog(Integer.parseInt(ownerId),name, breed, gender, null, bVaccinations, null, bActiveFlag);
		dogHelper.insertDog(toAdd);
	}

	}



