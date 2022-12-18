package Session9;

public class rearWheel extends Car implements Discounts{
	private String oil;
	
	public rearWheel(String manufacturer, String cartype, String transmission, int year, int horsepower, String drivenwheel, String oil) {
		// TODO Auto-generated constructor stub
		super(manufacturer, cartype, transmission, year, horsepower, drivenwheel);
		this.oil = oil;
	}

	public String getOil() {
		return oil;
	}

	public void setOil(String oil) {
		this.oil = oil;
	}
	
	@Override
	public int calculatePrice() {
		int price = 0;
		
		if(this.oil.equals("Mineral")) {
			price = 200000000;
		}else if(this.oil.equals("Sintetic")) {
			price = 100000000;
		}
		return price;
	}
	
	@Override
	public int getDiscounts() {
		// TODO Auto-generated method stub
		int price = 0;
		int discounts = 0;
		
		if(this.oil.equals("Mineral")) {
			price = 200000000;
			discounts = (int)(price * 0.5);
		}else if(this.oil.equals("Sintetic")) {
			price = 100000000;
			discounts = (int)(price * 0.7);
		}
		return discounts;
	}
}