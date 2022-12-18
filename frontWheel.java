package Session9;

public class frontWheel extends Car implements Discounts{
	private String brake;
	
	public frontWheel(String manufacturer, String cartype, String transmission, int year, int horsepower, String drivenwheel, String brake) {
		// TODO Auto-generated constructor stub
		super(manufacturer, cartype, transmission, year, horsepower, drivenwheel);
		this.brake = brake;
	}

	public String getBrake() {
		return brake;
	}

	public void setBrake(String brake) {
		this.brake = brake;
	}

	@Override
	public int calculatePrice() {
		int price = 0;
		
		if(this.brake.equals("Cakram")) {
			price = 250000000;
		}else if(this.brake.equals("Tromol")) {
			price = 150000000;
		}
		return price;
	}
	
	@Override
	public int getDiscounts() {
		// TODO Auto-generated method stub
		int price = 0;
		int discounts = 0;
		
		if(this.brake.equals("Mineral")) {
			price = 250000000;
			discounts = (int)(price * 0.2);
		}else if(this.brake.equals("Sintetic")) {
			price = 150000000;
			discounts = (int)(price * 0.3);
		}
		return discounts;
	}
}