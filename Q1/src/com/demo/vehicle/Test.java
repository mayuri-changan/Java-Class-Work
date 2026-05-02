/*package com.demo.vehicle;

import java.util.*;

public class Test {

    static Scanner sc = new Scanner(System.in);
    static HashSet<Vehicle> vehicles = new HashSet<>();

    public static void main(String[] args) {

        char choice;

        do {
            System.out.println("\n--- Vehicle Menu ---");
            System.out.println("a. Add Vehicle");
            System.out.println("b. Remove Vehicle");
            System.out.println("c. Update Price");
            System.out.println("d. Sell Vehicle");
            System.out.println("e. Purchase Vehicle");
            System.out.println("f. Display All");
            System.out.println("g. Display By Type");
            System.out.println("h. Display By Price Range");
            System.out.println("i. Sort By Price");
            System.out.println("j. Search By Name");
            System.out.println("k. Exit");

            choice = Character.toLowerCase(sc.next().charAt(0));

            switch (choice) {
                case 'a': addVehicle(); break;
                case 'b': removeVehicle(); break;
                case 'c': updatePrice(); break;
                case 'd': changeStatus("sold"); break;
                case 'e': changeStatus("available"); break;
                case 'f': displayAll(); break;
                case 'g': displayByType(); break;
                case 'h': displayByPriceRange(); break;
                case 'i': sortByPrice(); break;
                case 'j': searchByName(); break;
                case 'k': System.out.println("Exit"); break;
                default: System.out.println("Invalid choice");
            }

        }
         while (choice != 'k');
    }

    // ================= ADD =================
    static void addVehicle() {

        System.out.println("1. Electric  2. Petrol");
        int type = sc.nextInt();

        System.out.println("Enter id:");
        int id = sc.nextInt();

        sc.nextLine(); // buffer clear
        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter price:");
        double price = sc.nextDouble();

        Vehicle v;

        if (type == 1) {
            System.out.println("Enter battery & charging time:");
            double b = sc.nextDouble();
            double c = sc.nextDouble();

            v = new ElectricVehicle(id, name, price, "available", b, c);

        } else if (type == 2) {
            System.out.println("Enter fuelType & mileage:");
            String f = sc.next();
            double m = sc.nextDouble();

            v = new PetrolVehicle(id, name, price, "available", f, m);

        } else {
            System.out.println("Invalid vehicle type");
            return;
        }

        if (vehicles.add(v)) {
            System.out.println("Vehicle Added Successfully");
        } else {
            System.out.println("Duplicate ID! Not added");
        }
    }

    // ================= REMOVE =================
    static void removeVehicle() {
        System.out.println("Enter id:");
        int id = sc.nextInt();

        boolean removed = vehicles.removeIf(v -> v.getVehicleId() == id);

        if (removed)
            System.out.println("Vehicle removed");
        else
            System.out.println("Vehicle not found");
    }

    // ================= UPDATE =================
    static void updatePrice() {
        System.out.println("Enter id:");
        int id = sc.nextInt();

        boolean found = false;

        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                System.out.println("Enter new price:");
                v.setPrice(sc.nextDouble());
                found = true;
            }
        }

        if (!found)
            System.out.println("Vehicle not found");
    }

    // ================= STATUS =================
    static void changeStatus(String status) {
        System.out.println("Enter id:");
        int id = sc.nextInt();

        boolean found = false;

        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                v.setStatus(status);
                found = true;
                   // 🔴 SELL
            if (status.equals("sold")) {
                if (v.getStatus().equals("sold")) {
                    System.out.println("Vehicle already sold!");
                } else {
                    v.setStatus("sold");
                    System.out.println("Vehicle sold successfully");
                }
            }

            // 🟢 PURCHASE
            else if (status.equals("available")) {
                if (v.getStatus().equals("available")) {
                    System.out.println("Vehicle already available!");
                } else {
                    v.setStatus("available");
                    System.out.println("Vehicle purchased successfully");
                }
            }
        }
    }
            }
        }

        if (!found)
            System.out.println("Vehicle not found");
    }

    // ================= DISPLAY =================
    static void displayAll() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available");
        } else {
            vehicles.forEach(System.out::println);
        }
    }

    static void displayByType() {
        System.out.println("1. Electric  2. Petrol");
        int type = sc.nextInt();

        boolean found = false;

        for (Vehicle v : vehicles) {
            if (type == 1 && v instanceof ElectricVehicle) {
                System.out.println(v);
                found = true;
            } else if (type == 2 && v instanceof PetrolVehicle) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found)
            System.out.println("No vehicles found");
    }

    static void displayByPriceRange() {
        System.out.println("Enter min & max:");
        double min = sc.nextDouble();
        double max = sc.nextDouble();

        if (min > max) {
            System.out.println("Invalid range");
            return;
        }

        boolean found = false;

        for (Vehicle v : vehicles) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found)
            System.out.println("No vehicles in this range");
    }

    static void sortByPrice() {
        List<Vehicle> list = new ArrayList<>(vehicles);

        list.sort(Comparator.comparingDouble(Vehicle::getPrice));

        list.forEach(System.out::println);
    }

    static void searchByName() {
        sc.nextLine(); // buffer clear
        System.out.println("Enter name:");
        String name = sc.nextLine();

        boolean found = false;

        for (Vehicle v : vehicles) {
            if (v.getvehicleName().equalsIgnoreCase(name)) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found)
            System.out.println("Vehicle not found");
    }
}*/


package com.demo.vehicle;

import java.util.*;

public class Test {
	static Scanner sc=new Scanner (System.in);
	static HashSet<Vehicle>vehicles=new HashSet<>();

    public static void main(String[] args) {
    	char choice;
        do {
            System.out.println("\n--- Vehicle Menu ---");
            System.out.println("a. Add Vehicle");
            System.out.println("b. Remove Vehicle");
            System.out.println("c. Update Price");
            System.out.println("d. Sell Vehicle");
            System.out.println("e. Purchase Vehicle");
            System.out.println("f. Display All");
            System.out.println("g. Display By Type");
            System.out.println("h. Display By Price Range");
            System.out.println("i. Sort By Price");
            System.out.println("j. Search By Name");
            System.out.println("k. Exit");
            choice=Character.toLowerCase(sc.next().charAt(0));
    		switch(choice)
    		{
    	   	case'a':addVehicle(); break;
    		 case'b':removeVehicle();break;
              case 'c': updatePrice(); break;
              case 'd': changeStatus("sold"); break;
              case 'e': changeStatus("available"); break;
              case 'f': displayAll(); break;
              case 'g': displayByType(); break;
              case 'h': displayByPriceRange(); break;
              case 'i': sortByPrice(); break;
              case 'j': searchByName(); break;
              case 'k': System.out.println("Exit"); break;
              default: System.out.println("Invalid choice");
    	    } 
        }
    		while (choice!= 'k');	
    		}

	 static void searchByName() {
		// TODO Auto-generated method stub
		
	}

	static void sortByPrice() {
		// TODO Auto-generated method stub
		
	}

	 static void displayByPriceRange() {
		// TODO Auto-generated method stub
		
	}

	
	static void displayAll() {
		// TODO Auto-generated method stub
		
	}

	static void updatePrice() 
	{
		// TODO Auto-generated method stub
		System.out.println("enter id");
		int id=sc.nextInt();
		boolean found=false;
		for(Vehicle v:vehicles) {
			if(v.getVehicleId()==id)
			{
				System.out.println("enter new price");
				v.setPrice(sc.nextDouble());
				found =true;
			}
		}
				
			if(!found)
			{
				System.out.println("not found");
				
			}
		
	}

	 static void changeStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	 static void removeVehicle() {
		// TODO Auto-generated method stub
		 System.out.println(" enter id");
		 int id=sc.nextInt();
		boolean removed=vehicles.removeIf(v->v.getVehicleId()==id);
		if(removed) {
			System.out.println("remove successful");
		}else
		{
			System.out.println("not found");
		}
	}

	 static void addVehicle() {
		// TODO Auto-generated method stub
		 System.out.println("1.electric,2.petrol");
		 int type=sc.nextInt();
		 System.out.println("enter id");
		 int id=sc.nextInt();
		 System.out.println("enter name");
		 String name=sc.nextLine();
		 System.out.println(" enter price");
		 double price=sc.nextDouble();
		 Vehicle v;
		 if(type==1) {
			 System.out.println("batteryCapacity & chargingTime");
			 double b=sc.nextDouble();
			 double c=sc.nextDouble();
			 v=new ElectricVehicle(id,name,price,"available",b,c);
		 }
		 else if(type==2){
			 System.out.println("fuleType & mileage");
			 String f=sc.next();
			 Double m=sc.nextDouble();
			 v=new PetrolVehicle(id,name,price,"available",f,m);
		 }
		 else {
			 System.out.println("invalid v type");
			 return;
		 }
		 if(vehicles.add(v)){
			 System.out.println("added sucessful");
			 
		 }
		 else {
			 System.out.println("duplicate id");
		 }
		
	}

	 static void displayByType() {
		// TODO Auto-generated method stub
		
	}
    	
    
    	
    	
    }





