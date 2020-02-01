import java.util.Scanner;

public class BMICalculator {
	private double weight; //in kilograms
	private double height; //in meters
	private double bmi;
	private String bmi_category;
	private int mode; //0:imperial, 1:metric
	private Scanner scanner;
	
	public BMICalculator() {
		weight = 0;
		height = 0;
		bmi = 0;
		mode = 0;
		scanner = new Scanner(System.in);
	}
	
	private void readUnitType() {
		//ask for imperial or metric mode
		System.out.printf("Do you want to use imperial or metric? (i/m): ");
		String input = scanner.next();
		//check input
		if (input.equalsIgnoreCase("i")){
			mode = 0;
		} else if (input.equalsIgnoreCase("m")) {
			mode = 1;
		} else {
			//bad input, try again
			readUnitType();
		}
	}
	
	private void readMeasurementData() {
		if (mode == 0) {
			readImperialData();
		} else if (mode == 1) {
			readMetricData();
		}
	}
	
	private void readMetricData() {
		//ask for weight
		System.out.printf("Enter weight in kilograms: ");
		double weight_in = scanner.nextDouble();
		setWeight(weight_in);
		
		//ask for height
		System.out.printf("Enter height in meters: ");
		double height_in = scanner.nextDouble();
		setHeight(height_in);
	}
	
	private void readImperialData() {
		//ask for weight
		System.out.printf("Enter weight in pounds: ");
		double weight_in = scanner.nextDouble();
		setWeight(weight_in / 2.205);
		
		//ask for height
		System.out.printf("Enter height in inches: ");
		double height_in = scanner.nextDouble();
		setHeight(height_in / 39.37);
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double input) {
		if (input < 0.0)
			System.exit(0);
		weight = input;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double input) {
		if (input < 0.0)
			System.exit(0);
		height = input;
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public String getBmiCategory() {
		return bmi_category;
	}
	
	public void readUserData() {
		//ask for units
		readUnitType();
		//ask for measurement
		readMeasurementData();
	}
	
	public void calculateBmi() {
		if (height != 0.0) {
			bmi = weight / height / height;
		}
		if (bmi < 18.5) 
			bmi_category = "Underweight";
		else if (bmi < 24.9) 
			bmi_category = "Normal weight";
		else if (bmi < 29.9) 
			bmi_category = "Overweight";
		else
			bmi_category = "Obese";
	}

	public void displayBmi() {
		//print bmi and category
		System.out.printf("BMI is: %.1f, which is: %s", bmi, bmi_category);
	}
}
