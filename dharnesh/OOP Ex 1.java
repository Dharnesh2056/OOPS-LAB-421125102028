import java.util.Scanner;
class ElectricityBill {
int consumerNo;
String consumerName;
int prevReading;
int currReading;
String connectionType;
double billAmount;
void input() {
Scanner sc = new Scanner(System.in);
System.out.print("Enter Consumer Number: ");
consumerNo = sc.nextInt();
sc.nextLine(); 
System.out.print("Enter Consumer Name: ");
consumerName = sc.nextLine();
System.out.print("Enter Previous Month Reading: ");
prevReading = sc.nextInt();
System.out.print("Enter Current Month Reading: ");
currReading = sc.nextInt();
sc.nextLine(); 
System.out.print("Enter Connection Type (Domestic/Commercial): ");
connectionType = sc.nextLine();
}
void calculateBill() {
int units = currReading - prevReading;
if (connectionType.equalsIgnoreCase("Domestic")) {
if (units <= 100)
billAmount = units * 1.5;
else if (units <= 200)
billAmount = (100 * 1.5) + (units - 100) * 3;
else if (units <= 500)
billAmount = (100 * 1.5) + (100 * 3) + (units - 200) * 4.5;
else
billAmount = (100 * 1.5) + (100 * 3) + (300 * 4.5) + (units - 500) * 7;
}
else if (connectionType.equalsIgnoreCase("Commercial")) {
if (units <= 100)
billAmount = units * 2.5;
else if (units <= 200)
billAmount = (100 * 2.5) + (units - 100) * 5;
else if (units <= 500)
billAmount = (100 * 2.5) + (100 * 5) + (units - 200) * 6.5;
else
billAmount = (100 * 2.5) + (100 * 5) + (300 * 6.5) + (units - 500) * 9;
}
else {
System.out.println("Invalid Connection Type!");
}
}
void display() {
System.out.println("\n----- Electricity Bill -----");
System.out.println("Consumer Number : " + consumerNo);
System.out.println("Consumer Name : " + consumerName);
System.out.println("Units Consumed : " + (currReading - prevReading));
System.out.println("Connection Type : " + connectionType);
System.out.println("Bill Amount : Rs. " + billAmount);
}
}
public class Main {
public static void main(String[] args) {
ElectricityBill obj = new ElectricityBill();
obj.input();
obj.calculateBill();
obj.display();
}
}