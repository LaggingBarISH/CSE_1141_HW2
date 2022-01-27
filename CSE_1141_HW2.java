//------------------------------------------------WARNING----------------------------------------
// This version of the program solely uses values given in the spec sheet. It does not calculate anything more than necessary.
// And it uses given values AS IS. This means even though it is wrong, given tax value for 2019 - 500,000Tl: "163,460" is used.
// If needed, uncomment line 15 to correct this value to 159,460.

//Attention
//This file will be compiled using openjdk-11-jdk. Equivalent of Sun Java JDK 11. Lower versions of java will refuse run this file.

//This program will calculate how much tax will be cut from income for the given income on year 2017 to 2020 in Turkey.
public class CSE_1141_HW2 {
	static java.util.Scanner _Scanner= new java.util.Scanner(System.in);
	public static void main(String[] args) {
		//Instead of calculating tax for higher quantities, just access precalculated values given in Spec Sheet (hw2.pdf).
		int[][][] tax_map = {{{110000,26950,35},{30000,5350,27},{13000,1950,20},{0,0,15},{0,0,0}}/*2017*/, {{120000,29280,35},{34000,6060,27},{14800,2220,20},{0,0,15},{0,0,0}}/*2018*/, {{500000,163460,40},{148000,36260,35},{40000,7100,27},{18000,2700,20},{0,0,15}}/*2019*/, {{600000,191070,40},{180000,44070,35},{49000,8700,27},{22000,3300,20},{0,0,15}}/*2020*/};
		//tax_map[2][0][1]=159460;
		//Waiting and acquiring required inputs to process.
		int yearin= _Scanner.nextInt()-2017;
		double tax=0,inc= _Scanner.nextDouble();
		//Testing if income input is positive.
		if(inc <= (double)0) System.out.println("Income must be > 0!");
		else {
			//Check for year range.
			if ((yearin < 4 && yearin >= 0)) {
				System.out.println("Income: " + inc);
				//Accessing correct child then calculating tax amount to be paid for that year.
				if (tax_map[yearin][0][0]<=inc) tax=tax_map[yearin][0][1]+tax_map[yearin][0][2]/100.0*(inc-tax_map[yearin][0][0]);
				else if (tax_map[yearin][1][0]<=inc) tax=tax_map[yearin][1][1]+tax_map[yearin][1][2]/100.0*(inc-tax_map[yearin][1][0]);
					else if (tax_map[yearin][2][0]<=inc) tax=tax_map[yearin][2][1]+tax_map[yearin][2][2]/100.0*(inc-tax_map[yearin][2][0]);
						else if (tax_map[yearin][3][0]<=inc) tax=tax_map[yearin][3][1]+tax_map[yearin][3][2]/100.0*(inc-tax_map[yearin][3][0]);
							else if (tax_map[yearin][4][0]<=inc) tax=tax_map[yearin][4][1]+tax_map[yearin][4][2]/100.0*(inc-tax_map[yearin][4][0]);
				//Printing results.
				System.out.println("Tax amount: " + (int)(tax*100)/100.0 + "\nIncome after tax: " + (int)((inc-tax)*100)/100.0 + "\nReal tax rate: " + (int)((1-(inc-tax)/inc)*10000)/100.0 + "%");
			} /*Input year is not in 2017-2020 range.*/ else System.out.println("Undefined year value!");}}}