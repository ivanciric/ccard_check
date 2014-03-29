/**
* Credit card validation application based on
* the Luhn checksum algorithm (mod 10).
* 
* @author  Ivan emcode
* @version 1.0
* @since   2014-03-30 
*/

import java.util.Scanner;

public class Ccard_check {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int even_sum = 0;
		int doubled_sum = 0;
		int doubled_extracted_sum = 0;
		int total_sum = 0;
		String even[] = new String[8];
		String odd[] = new String[8];
		String doubled[] = new String[8];
		String doubled_extracted[] = new String[8];
		String ccard;
		
		System.out.print("enter credit card number: ");
		ccard = input.nextLine();
		
		if(ccard.length() == 16){
			int c = 0;
			for(int counter = 0; counter < 16; counter++){
				if(counter %2 != 0){
					even[c] = String.valueOf(ccard.charAt(counter));
					c++;
				}
			}
			int cu = 0;
			for(int counter = 0; counter < 16; counter++){
				if(counter %2 == 0){
					odd[cu] = String.valueOf(ccard.charAt(counter));
					cu++;
				}
			}
			for(int counter = 0; counter < 8; counter++){
					int odd_position_number = Integer.parseInt(odd[counter]);
					doubled[counter] = String.valueOf(odd_position_number * 2);
			}
			for(int counter = 0; counter < even.length; counter++){
				even_sum += Integer.parseInt(even[counter]);
			}
			int de = 0;
			for(int counter = 0; counter < 8; counter++){
				if(doubled[counter].length() == 1){
					doubled_extracted[de] = String.valueOf(doubled[counter]);
					de++;
				}else if(doubled[counter].length() == 2){
					doubled_extracted[de] = String.valueOf(Integer.parseInt(String.valueOf(doubled[counter].charAt(0))) + Integer.parseInt(String.valueOf(doubled[counter].charAt(1))));
					de++;
				}
			}
			for(int counter = 0; counter < 8; counter++){
				doubled_extracted_sum += Integer.parseInt(doubled_extracted[counter]);
			}

			total_sum = even_sum + doubled_extracted_sum;
			
			if(total_sum % 10 == 0){
				System.out.println("cc number is genuine.");
			}else{
				System.out.println("cc number is fake.");
			}

		}else{
			System.out.println("cc number is fake.");
		}
	}
}
