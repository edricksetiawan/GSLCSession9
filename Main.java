package Session9;

// Program ini adalah program untuk para Dealer Mobil
// Tujuan dari program ini adalah untuk menambahkan mobil baru supaya terdaftar di dalam data
// Yang kemudian nantinya bisa kita lihat semua list mobil yang telah kita tambahkan
// Dan pada akhirnya kita dapat membeli mobil tersebut dengan memasukkan jumlah payment
// Nantinya program akan menghitung jumlah diskon dan jumlah kembalian yang didapat

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Car> carList = new ArrayList<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		// Function untuk memilih menu
		int choose;
		do {
			Menu();
			choose = scan.nextInt();
			scan.nextLine();
			
			if(choose == 1) {
				addCar();
			}else if(choose == 2) {
				showCar();
			}else if(choose == 3) {
				buyCar();
			}
		}while(choose != 4);
		
		System.out.println("Thank you for using this app!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public void Menu() {
		System.out.println("CAR DEALER");
		System.out.println("1. Add Car");
		System.out.println("2. Show Car");
		System.out.println("3. Buy Car");
		System.out.println("4. Exit");
		System.out.print(">> ");
	}
	
	// Menambahkan mobil baru ke dalam sebuah arraylist
	public void addCar() {
		String manufacturer;
		String cartype;
		String transmission;
		int year;
		int horsepower;
		String drivenwheel;
		String oil;
		String brake;
		String busi;
		
		// validasi manufacturer harus BMW / Chevrolet / Honda / Hyundai
		do {
			System.out.print("Input car manufacturer [BMW | Chevrolet | Honda | Hyundai ] : ");
			manufacturer = scan.nextLine();
		}while(!(manufacturer.equals("BMW") || manufacturer.equals("Chevrolet") || manufacturer.equals("Honda") || manufacturer.equals("Hyundai")));
		
		// validasi type harus Passenger / Car
		do {
			System.out.print("Input car type [Passenger | Car] : ");
			cartype = scan.nextLine();
		}while(!(cartype.equals("Passenger") || cartype.equals("Car")));
		
		// validasi transmission harus Automatic / Manual
		do {
			System.out.print("Input car transmission [Automatic | Manual] : ");
			transmission = scan.nextLine();
		}while(!(transmission.equals("Automatic") || transmission.equals("Manual")));
		
		// validasi year harus dari rentang antara 1 - 15
		do {
			System.out.print("Input car year [1-15] : ");
			year = scan.nextInt();
			scan.nextLine();
		}while(year < 1 || year > 15);
		
		// validasi horsepower harus dari rentang antara 100 - 450
		do {
			System.out.print("Input car horsepower [100-450] : ");
			horsepower = scan.nextInt();
			scan.nextLine();
		}while(horsepower < 100 || horsepower > 450);
		
		// validasi drivenwheel harus Rear Wheel / Front Wheel / All Wheel
		do {
			System.out.print("Input car driven wheels [Rear Wheel | Front Wheel | All Wheel ] : ");
			drivenwheel = scan.nextLine();
		}while(!(drivenwheel.equals("Rear Wheel") || drivenwheel.equals("Front Wheel") || drivenwheel.equals("All Wheel")));
		
		// apabila drivenwheel merupakan rear wheel, maka akan diminta validasi oli
		if(drivenwheel.equals("Rear Wheel")) {
			// validasi oil harus Mineral / Sintetic
			do {
				System.out.print("Input car oil [Mineral | Sitentic] : ");
				oil = scan.nextLine();
			}while(!(oil.equals("Mineral") || oil.equals("Sintetic")));
			
			carList.add(new rearWheel(manufacturer, cartype, transmission, year, horsepower, drivenwheel, oil));
		}
		// apabila drivenwheel merupakan front wheel, maka akan diminta validasi break
		else if(drivenwheel.equals("Front Wheel")) {
			// validasi brake harus Cakram / Tromol
			do {
				System.out.print("Input car brake [Cakram | Tromol] : ");
				brake = scan.nextLine();
			}while(!(brake.equals("Cakram") || brake.equals("Tromol")));
			
			carList.add(new frontWheel(manufacturer, cartype, transmission, year, horsepower, drivenwheel, brake));
		}
		// apabila drivenwheel merupakan all wheel, maka akan diminta validasi busi
		else if(drivenwheel.equals("All Wheel")) {
			// validasi busi harus Standard / Platinum / Iridium
			do {
				System.out.print("Input car busi [Standard | Platinum | Iridium] : ");
				busi = scan.nextLine();
			}while(!(busi.equals("Standard") || busi.equals("Platinum") || busi.equals("Iridium")));
			
			carList.add(new allWheel(manufacturer, cartype, transmission, year, horsepower, drivenwheel, busi));
		}
		
		System.out.println("Car successfully added");
		scan.nextLine();
	}
	
	// Menampilkan car yang sudah diadd sebelumnya
	public void showCar() {
		// apabila list car tidak ada / kosong, maka akan menampilkan tulisan "No Data"
		if(carList.isEmpty()) {
			System.out.println("No Data");
			scan.nextLine();
		}else {
			// menampilkan list car yang sudah diadd berdasarkan jenis driven wheel
			int no = 0;
			System.out.println("Car List");
			System.out.println("=====================================");
			for(Car car: carList) {
				no++;
				if(car instanceof rearWheel) {
					System.out.println("Number : " + no);
					System.out.println("Car Driven Wheel : Rear Wheel");
					
					System.out.print("Car Manufacturer : ");
					System.out.println(car.getManufacturer());
					
					System.out.print("Car Type : ");
					System.out.println(car.getCartype());
					
					System.out.print("Car Transmission : ");
					System.out.println(car.getTransmission());
					
					System.out.print("Year of the Car : ");
					System.out.println(car.getYear());
					
					System.out.print("Car Horse Power : ");
					System.out.println(car.getHorsepower());
					
					System.out.print("Car Oil : ");
					System.out.println(((rearWheel)car).getOil());
				}else if(car instanceof frontWheel) {
					System.out.println("Number : " + no);
					System.out.println("Car Driven Wheel : Front Wheel");
					
					System.out.print("Car Manufacturer : ");
					System.out.println(car.getManufacturer());
					
					System.out.print("Car Type : ");
					System.out.println(car.getCartype());
					
					System.out.print("Car Transmission : ");
					System.out.println(car.getTransmission());
					
					System.out.print("Year of the Car : ");
					System.out.println(car.getYear());
					
					System.out.print("Car Horse Power : ");
					System.out.println(car.getHorsepower());
					
					System.out.print("Car Brake : ");
					System.out.println(((frontWheel)car).getBrake());
				}else if(car instanceof allWheel) {
					System.out.println("Number : " + no);
					System.out.println("Car Driven Wheel : All Wheel");
					
					System.out.print("Car Manufacturer : ");
					System.out.println(car.getManufacturer());
					
					System.out.print("Car Type : ");
					System.out.println(car.getCartype());
					
					System.out.print("Car Transmission : ");
					System.out.println(car.getTransmission());
					
					System.out.print("Year of the Car : ");
					System.out.println(car.getYear());
					
					System.out.print("Car Horse Power : ");
					System.out.println(car.getHorsepower());
					
					System.out.print("Car Busi : ");
					System.out.println(((allWheel)car).getBusi());
				}
				System.out.println("=====================================");
			}
			System.out.println("Press enter to continue");
			scan.nextLine();
		}
	}
	
	// Membeli mobil yang sudah ada di dalam list
	public void buyCar() {
		// apabila list car tidak ada / kosong, maka akan menampilkan tulisan "No Data"
		if(carList.isEmpty()) {
			System.out.println("No Data");
			scan.nextLine();
		}else {
			// menampilkan list car yang sudah diadd berdasarkan jenis driven wheel
			int no = 0;
			System.out.println("Car List");
			System.out.println("=====================================");
			for(Car car: carList) {
				no++;
				if(car instanceof rearWheel) {
					System.out.println("Number : " + no);
					System.out.println("Car Driven Wheel : Rear Wheel");
					
					System.out.print("Car Manufacturer : ");
					System.out.println(car.getManufacturer());
					
					System.out.print("Car Type : ");
					System.out.println(car.getCartype());
					
					System.out.print("Car Transmission : ");
					System.out.println(car.getTransmission());
					
					System.out.print("Year of the Car : ");
					System.out.println(car.getYear());
					
					System.out.print("Car Horse Power : ");
					System.out.println(car.getHorsepower());
					
					System.out.print("Car Oil : ");
					System.out.println(((rearWheel)car).getOil());
				}else if(car instanceof frontWheel) {
					System.out.println("Number : " + no);
					System.out.println("Car Driven Wheel : Front Wheel");
					
					System.out.print("Car Manufacturer : ");
					System.out.println(car.getManufacturer());
					
					System.out.print("Car Type : ");
					System.out.println(car.getCartype());
					
					System.out.print("Car Transmission : ");
					System.out.println(car.getTransmission());
					
					System.out.print("Year of the Car : ");
					System.out.println(car.getYear());
					
					System.out.print("Car Horse Power : ");
					System.out.println(car.getHorsepower());
					
					System.out.print("Car Brake : ");
					System.out.println(((frontWheel)car).getBrake());
				}else if(car instanceof allWheel) {
					System.out.println("Number : " + no);
					System.out.println("Car Driven Wheel : All Wheel");
					
					System.out.print("Car Manufacturer : ");
					System.out.println(car.getManufacturer());
					
					System.out.print("Car Type : ");
					System.out.println(car.getCartype());
					
					System.out.print("Car Transmission : ");
					System.out.println(car.getTransmission());
					
					System.out.print("Year of the Car : ");
					System.out.println(car.getYear());
					
					System.out.print("Car Horse Power : ");
					System.out.println(car.getHorsepower());
					
					System.out.print("Car Busi : ");
					System.out.println(((allWheel)car).getBusi());
				}
				System.out.println("=====================================");
				System.out.println("");
				
				int buy = 0;
				do {
					System.out.print("Input the book that you want to buy [1 - " + carList.size() + "]: ");
					buy = scan.nextInt();
					scan.nextLine();
				}while(buy < 1 || buy > carList.size());
				
				// menampilkan detail parameter dalam mobil
				System.out.println("Car Manufacturer  : " + carList.get(buy-1).getManufacturer());
				System.out.println("Car Type          : " + carList.get(buy-1).getCartype());
				System.out.println("Car Transmission  : " + carList.get(buy-1).getTransmission());
				System.out.println("Year of the Car   : " + carList.get(buy-1).getYear());
				System.out.println("Car Horse Power   : " + carList.get(buy-1).getHorsepower());
				
				// menampilkan atribut lain dari masing-masing subclass
				if(carList.get(buy-1) instanceof rearWheel) {
					System.out.println("Oil Type     : " + ((rearWheel)carList.get(buy-1)).getOil());
					System.out.println("Price        : " + ((rearWheel)carList.get(buy-1)).calculatePrice());
				}else if(carList.get(buy-1) instanceof frontWheel) {
					System.out.println("Brake Type   : " + ((frontWheel)carList.get(buy-1)).getBrake());
					System.out.println("Price        : " + ((frontWheel)carList.get(buy-1)).calculatePrice());
				}else if(carList.get(buy-1) instanceof allWheel) {
					System.out.println("Busi Type    : " + ((allWheel)carList.get(buy-1)).getBusi());
					System.out.println("Price        : " + ((allWheel)carList.get(buy-1)).calculatePrice());	
				}
				
				int payment = 0;
				int change = 0;
				int discount = 0;
				
				if(carList.get(buy-1) instanceof rearWheel) {
					// untuk type rear wheel mendapatkan diskon
					System.out.println("Yayy, You got a discount!");
					Discounts disc = new rearWheel(carList.get(buy-1).getManufacturer(), carList.get(buy-1).getCartype(), carList.get(buy-1).getTransmission(),
							carList.get(buy-1).getYear(), carList.get(buy-1).getHorsepower(), ((rearWheel)carList.get(buy-1)).getOil(), null);
					System.out.println("");
					discount = disc.getDiscounts();
					System.out.println("Discount     : " + discount);
				}else if(carList.get(buy-1) instanceof frontWheel) {
					// untuk type front wheel mendapatkan diskon 
					System.out.println("Yayy, You got a discount!");
					Discounts disc = new frontWheel(carList.get(buy-1).getManufacturer(), carList.get(buy-1).getCartype(), carList.get(buy-1).getTransmission(),
							carList.get(buy-1).getYear(), carList.get(buy-1).getHorsepower(), ((frontWheel)carList.get(buy-1)).getBrake(), null);
					System.out.println("");
					discount = disc.getDiscounts();
					System.out.println("Discount     : " + discount);
				}else if(carList.get(buy-1) instanceof allWheel) {
					// untuk type all wheel mendapatkan advantage
					Advantage adv = new allWheel(carList.get(buy-1).getManufacturer(), carList.get(buy-1).getCartype(), carList.get(buy-1).getTransmission(),
							carList.get(buy-1).getYear(), carList.get(buy-1).getHorsepower(), ((allWheel)carList.get(buy-1)).getBusi(), null);
					System.out.println("");
					adv.getAdvantage();
				}
				
				// menampilkan jumlah harga yang harus dibayar oleh customer
				do {
					System.out.print("Input payment : " );
					payment = scan.nextInt();
					scan.nextLine();
				}while(payment < (carList.get(buy-1).calculatePrice()-discount));
				
				// menghitung jumlah kembalian 
				change = payment - (carList.get(buy-1).calculatePrice()-discount);
				
				// menampilkan jumlah kembalian yang akan dikembalikan kepada customer
				System.out.println("Here's the change : " + change);
			
				carList.remove(buy-1);
				
				System.out.println("");
				System.out.println("Thank you for bought this car!");
				scan.nextLine();
			}
		}
	}
}