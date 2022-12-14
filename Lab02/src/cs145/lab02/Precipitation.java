package cs145.lab02;

import java.util.Scanner; // to read from a file
import java.io.File; // to create a file
import java.io.PrintWriter; // to write to a file
import java.io.IOException; // to use files
import java.text.DecimalFormat; // to format numbers for printing

/**
 * This class can be used to process precipitation data for 5 years. It will
 * read 5 years of monthly data from a data file called precip.dat containing 1
 * data point per line. It will create a report containing a table of the data
 * as well as monthly averages and yearly totals. It will also find the maximum
 * and minimum precipitation and display it with the table in the report.
 * Written by YOUR NAME HERE TODAY'S DATE HERE
 */
public class Precipitation {
	private final static int MONTHS = 12;
	private final static int YEARS = 5;
	private final static int STARTYEAR = 2015;
	private final String[] monthLabel = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };

	// DECLARE ARRAYS HERE FOR TASK #2
	double[][] precipitationAmount;
	double[] yearTotal;
	double[] monthlyAverage;

	public Precipitation() {
		// Constructors for setting array sizes
		precipitationAmount = new double[YEARS][MONTHS];
		yearTotal = new double[YEARS];
		monthlyAverage = new double[MONTHS];
	}

	public void readFile(Scanner infile) throws IOException {
		// CREATE A LOOPING STRUCTURE TO READ DATA FROM THE FILE AND
		// STORE IT INTO THE 2-D ARRAY FOR TASK #3
		for (int i = 0; i < YEARS; i++) {
			for (int j = 0; j < MONTHS; j++) {
				if (infile.hasNext()) {
					precipitationAmount[i][j] = Double.parseDouble(infile.next());
				}
			}
		}
		infile.close();
		calculateMonthlyAverage();
		calculateYearTotal();
	}

	private void calculateMonthlyAverage() {
		// CREATE A LOOPING STRUCTURE TO CALCULATE THE MONTHLY AVERAGE
		// FOR EACH COLUMN AND STORE IT INTO THE MONTHLY AVERAGE ARRAY
		// FOR TASK #3
		double temp = 0;
		for (int i = 0; i < MONTHS; i++) {
			for (int j = 0; j < YEARS; j++) {
				temp += precipitationAmount[j][i];
			}
			monthlyAverage[i] = temp / YEARS;
			temp = 0;
		}
	}

	private void calculateYearTotal() {
		// CREATE A LOOPING STRUCTURE TO CALCULATE THE YEAR TOTAL
		// FOR EACH ROW AND STORE IT INTO THE YEAR TOTAL ARRAY
		// FOR TASK #3
		double temp = 0;
		for (int i = 0; i < YEARS; i++) {
			for (int g = 0; g < MONTHS; g++) {
				temp += precipitationAmount[i][g];
			}
			yearTotal[i] = temp;
			temp = 0;
		}
	}

	public String findMax() {
		// TASK #4
		// SEARCH THE ARRAY FOR THE LARGEST AMOUNT OF PRECIPITAION
		// SAVE THE AMOUNT, MONTH, AND YEAR.
		int monthIndex = 0;
		int yearIndex = 0;
		double tempMaxValue = precipitationAmount[0][0];
		for (int i = 0; i < YEARS; i++) {
			for (int j = 0; j < MONTHS; j++) {
				if (tempMaxValue < precipitationAmount[i][j]) {
					tempMaxValue = precipitationAmount[i][j];
					monthIndex = j;
					yearIndex = i;
				}
			}
		}

		return "The maximum precipitation of " + tempMaxValue + " occurred in " + monthLabel[monthIndex] + " of "
				+ (STARTYEAR + yearIndex);
		// RETURN A STRING CONTAINING INFORMATION ABOUT THE MAXIMUM PRECIPITATION
	}

	public String findMin() {
		// TASK #4
		// SEARCH THE ARRAY FOR THE SMALLEST AMOUNT OF PRECIPITAION
		// SAVE THE AMOUNT, MONTH, AND YEAR.

		int monthIndex = 0;
		int yearIndex = 0;
		double tempMaxValue = precipitationAmount[0][0];
		for (int i = 0; i < YEARS; i++) {
			for (int j = 0; j < MONTHS; j++) {
				if (tempMaxValue > precipitationAmount[i][j]) {
					tempMaxValue = precipitationAmount[i][j];
					monthIndex = j;
					yearIndex = i;
				}
			}
		}
		return "The minimum precipitation of " + tempMaxValue + " occurred in " + monthLabel[monthIndex] + " of "
				+ (STARTYEAR + yearIndex);
		// RETURN A STRING CONTAINING INFORMATION ABOUT THE MINIMUM PRECIPITATION
	}

	public void printTable(PrintWriter outfile) {
		// OUTPUT THE TABLE USING NICELY FORMATTED NUMBERS #.##
		// AND NEAT COLUMNS FOR TASK #5
		DecimalFormat df = new DecimalFormat("0.00");
		
		// Labels 
		outfile.print("YEAR");

		for (int q = 0; q < MONTHS; q++) {
			outfile.print("\t" + monthLabel[q]);
		}

		outfile.println("\tTOTAL\n");

		// Precipitation Amount
		for (int i = 0; i < YEARS; i++) {
			outfile.print(STARTYEAR + i);
			for (int j = 0; j < MONTHS; j++) {
				outfile.print("\t" + df.format(precipitationAmount[i][j]));
			}
			outfile.println("\t" + df.format(yearTotal[i]));
		}

		outfile.print("AVE");

		for (int a = 0; a < MONTHS; a++) {
			outfile.print("\t" + df.format(monthlyAverage[a]));
		}
		
		outfile.println("\n");
		outfile.println(findMax());
		outfile.print("\n");
		outfile.print(findMin());

		outfile.close();

	}

	public static void main(String[] args) throws IOException {
		Precipitation wetStuff = new Precipitation();

		// TASK #1
		Scanner fileReader = new Scanner(new File("PRECIP.dat"));
		PrintWriter fileWriter = new PrintWriter("PRECIP.out");

		// UNCOMMENT THE LINES BELOW ONCE YOU HAVE CREATED YOUR OBJECTS
		wetStuff.readFile(fileReader);
		wetStuff.printTable(fileWriter);
	}
}