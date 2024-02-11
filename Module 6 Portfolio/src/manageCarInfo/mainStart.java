package manageCarInfo;

import java.util.Scanner;

public class mainStart {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		autoMobiles autoMobile1 = new autoMobiles();
		
		String newModel;
		String newMake;
		String newColor;
		int newYear;
		int newMileage;
		String isDone;
		String updateWhat;
		int carNum;
		String updateString;
		int updateInteger;
		char printToFile;
		int optionSelect2;
		
		do {
			try {
			System.out.println("What would you like to do? Enter one of the option numbers: \n 1. Add \n 2. Remove \n 3. Inventory \n 4. Update \n Or enter \"Complete\" to stop program.");
			String optionSelect = scnr.next();
			
			if (optionSelect.equalsIgnoreCase("Complete")) {
				System.out.println("Would you like to save inventory in a text file? Enter Y or N");
				try {
				printToFile = scnr.next().charAt(0);
				if(printToFile == 'Y' || printToFile == 'y') {
					System.out.println("Name the file: ");
					String fileName = scnr.next();
					System.out.println(autoMobile1.saveToFile(fileName));
					System.out.println("End of program");
					break;
				}
				else if(printToFile == 'N' || printToFile == 'n') {
					System.out.println("End of program");
					break;
				}
				else {
					throw new Exception("Invalid option");
				}
				}catch(Exception j) {
					System.out.println(j.getMessage());
					System.out.println();
				}
			}
			else if (optionSelect.equals("1") || optionSelect.equals("2") || optionSelect.equals("3") || optionSelect.equals("4")){
				switch(optionSelect) {
					case("1")://Add option
						do {
							System.out.println("Enter car information in the following order: make, model, color, year, and mileage. Only separated by a space.");
							newMake = scnr.next();
							newModel = scnr.next();
							newColor = scnr.next();
							newYear = scnr.nextInt();
							newMileage = scnr.nextInt();
				
							autoMobile1.autoMobiles(newMake, newModel, newColor, newYear, newMileage);
					
							System.out.println("If you have no more vehicles to add type \"done\". Otherwise click any key to continue with prompts.");
							isDone = scnr.next();
							if (isDone.equalsIgnoreCase("done")) {
								break;
							}
						} while (true);
			
						System.out.println("Adding Complete.");
					break;
					case("2")://Removal Option
						try {
						if(autoMobile1.autoMake.size() == 0) {
							throw new Exception("No cars to remove.");
							
						}
						System.out.println("Enter car list number you want to remove");
							carNum = scnr.nextInt();
						
							autoMobile1.removeVehicle(carNum);
						
						}catch (Exception k) {
							System.out.println(k.getMessage());
							System.out.println();
						}
					break;
					case("3")://Printing out inventory option
						
							autoMobile1.getInventory();
					
					break;
					
					case("4")://Update option
						try {
						do {
								if(autoMobile1.autoMake.size() == 0) {
									throw new Exception("No vehicles in inventory"); //This is wrong
								}
								System.out.println("Enter car list number you want to update.");
								carNum = scnr.nextInt();
								if (carNum > autoMobile1.autoMake.size() || carNum == 0) {
									throw new Exception("Out of bounds of inventory");
								}
								System.out.println("Select what group of options you want 1 or 2. \n\t1: Make, Model, and Color\n\t2: Year and Mileage");
		
								optionSelect2 = scnr.nextInt();
								try {
									if (optionSelect2 == 1) {
										System.out.println("Enter what you want to update. Options are: \"Make\", \"Model\", or \"Color\" (case-sensitive)");
										updateWhat = scnr.next();
										
										autoMobile1.updateVehicleString(carNum, updateWhat);
									}
									else if(optionSelect2 == 2) {
										System.out.println("Enter what ou want to update: \"Year\" or \"Mileage\" ");
										updateWhat = scnr.next();
							
										
										autoMobile1.updateVehicleInteger(carNum, updateWhat);
									}
									else {
										throw new Exception("Invalid option.");
									}
								
								}catch(Exception p) {
									System.out.println(p.getMessage());
									System.out.println("Try again.");
									System.out.println();
								}
								System.out.println("If you are done updating vehicles type DONE. Otherwise click any key to continue with prompts.");
								isDone = scnr.next();
								if (isDone.equalsIgnoreCase("done")) {
									break;
								}
							
						} while(true);
						}catch(Exception e) {
							System.out.println(e.getMessage());
							System.out.println("Can't complete update process.");
							System.out.println();
						}
					break;
						
				}
			}
			else {
				throw new Exception("Invalid Option Selection. Try again");
			}
			
			}catch(Exception excpt) {
				System.out.println(excpt.getMessage());
				System.out.println();
			}
		} while(true);
		scnr.close();
	}

}