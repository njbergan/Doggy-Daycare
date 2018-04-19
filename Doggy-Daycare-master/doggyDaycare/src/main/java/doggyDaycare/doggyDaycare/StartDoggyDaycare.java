package doggyDaycare.doggyDaycare;

import java.util.Date;
import java.util.Scanner;

public class StartDoggyDaycare {

		
	static Scanner in = new Scanner(System.in);
	static DogDao dogHelper = new DogDao();
	
	public static void main(String[] args)
	{
		insertDog();
		insertDog();
		insertDog();
		findDog();
		updateDog();
		listAllDogs();
		listActiveDogs();
	}
		
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
	static private Dog findDog()
	{
		System.out.print("Enter dog ID: ");
		String dogId = in.nextLine();
		return dogHelper.searchForDogById(Integer.parseInt(dogId));
	}
	static private void updateDog()
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
		Dog toUpdate = new Dog(Integer.parseInt(ownerId),name, breed, gender, null, bVaccinations, null, bActiveFlag);
		dogHelper.updateDog(toUpdate);
	}
	static private void listAllDogs()
	{
		System.out.print(dogHelper.viewAllDogs());
	}
	static private void listActiveDogs()
	{
		System.out.print(dogHelper.viewOnlyActive());
	}

}



