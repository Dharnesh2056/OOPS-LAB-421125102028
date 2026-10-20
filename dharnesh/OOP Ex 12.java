import java.util.Scanner;
class Room {
 int roomNo;
 String type;
 double price;
 boolean available;
 Room(int roomNo, String type, double price) {
 this.roomNo = roomNo;
 this.type = type;
 this.price = price;
 this.available = true;
 }
 void displayRoom() {
 System.out.println(roomNo + "\t" + type + "\t₹" + price +
 "\t" + (available ? "Available" : "Booked"));
 }
}
class Customer {
 String name;
 String phone;
 Customer(String name, String phone) {
 this.name = name;
 this.phone = phone;
 }
}
public class HotelManagement {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 Room r1 = new Room(101, "Single", 1500);
Room r2 = new Room(102, "Double", 2500);
 Room r3 = new Room(103, "Suite", 4000);
 System.out.println("===== HOTEL MANAGEMENT SYSTEM =====");
 System.out.print("Enter Customer Name: ");
 String name = sc.nextLine();
 System.out.print("Enter Phone Number: ");
 String phone = sc.nextLine();
 Customer c = new Customer(name, phone);
 System.out.println("\nAvailable Rooms");
 System.out.println("Room No\tType\tPrice\tStatus");
 r1.displayRoom();
 r2.displayRoom();
 r3.displayRoom();
 System.out.print("\nEnter Room Number to Book: ");
 int roomNo = sc.nextInt();
 Room selectedRoom = null;
 if (roomNo == 101)
 selectedRoom = r1;
 else if (roomNo == 102)
 selectedRoom = r2;
 else if (roomNo == 103)
 selectedRoom = r3;
 if (selectedRoom != null && selectedRoom.available) {
 selectedRoom.available = false;
 // Number of days
 System.out.print("Enter Number of Days: ");
 int days = sc.nextInt();
 // Food order
 System.out.println("\nFood Menu");
 System.out.println("1. Breakfast - ₹200");
System.out.println("2. Lunch - ₹300");
 System.out.println("3. Dinner - ₹400");
 System.out.println("4. No Food");
 System.out.print("Enter Food Choice: ");
 int foodChoice = sc.nextInt();
 double foodPrice = 0;
 String food = "No Food";
 if (foodChoice == 1) {
 foodPrice = 200;
 food = "Breakfast";
 } 
 else if (foodChoice == 2) {
 foodPrice = 300;
 food = "Lunch";
 } 
 else if (foodChoice == 3) {
 foodPrice = 400;
 food = "Dinner";
 }
 double roomTotal = selectedRoom.price * days;
 double totalBill = roomTotal + foodPrice;
 System.out.println("\n===== BOOKING CONFIRMED =====");
 System.out.println("Customer Name : " + c.name);
 System.out.println("Phone Number : " + c.phone);
 System.out.println("Room Number : " + selectedRoom.roomNo);
 System.out.println("Room Type : " + selectedRoom.type);
 System.out.println("Number of Days: " + days);
 System.out.println("Food Order : " + food);
 System.out.println("Room Cost : ₹" + roomTotal);
 System.out.println("Food Cost : ₹" + foodPrice);
 System.out.println("Total Bill : ₹" + totalBill);
 System.out.println("Status : Booked");
 // Booking cancellation
 System.out.print("\nDo you want to cancel the booking? (yes/no): ");
 String cancel = sc.next();
if (cancel.equalsIgnoreCase("yes")) {
 selectedRoom.available = true;
 System.out.println("\n===== BOOKING CANCELLED =====");
 System.out.println("Booking for Room " +
 selectedRoom.roomNo + " has been cancelled.");
 System.out.println("Room is now Available.");
 } else {
 System.out.println("\nBooking remains Confirmed.");
 }
 } else {
 System.out.println("\nInvalid or Already Booked Room!");
 }
 sc.close();
 }
}