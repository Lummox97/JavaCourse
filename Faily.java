import java.util.Scanner;
public class Faily {
	public static void main(String [] argc) {
		Scanner scan = new Scanner("kebv 12,4 jwenv 5.4 esknv 2");
		double a = 0, sum = 0;
		while(scan.hasNext()) {
			if(scan.hasNextDouble()) {
				a = scan.nextDouble();
				sum += a;
			}
			else
				scan.next();
		}
		System.out.printf("%.6f", sum);
	}
}