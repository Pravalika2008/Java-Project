import java.util.Scanner;
public class PrimeNumber {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter Number: ");
int num = sc.nextInt();
Boolean is prime = true;
if (num<= 1) {
is prime = false;
} else {
for(int i=2;i<= num/ 2;i++) {
if (num%i == 0) {
is prime = false;
break;
}
}
}



