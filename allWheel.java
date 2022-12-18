package Session9;

public class allWheel extends Car implements Advantage{
	private String busi;
	
	public allWheel(String manufacturer, String cartype, String transmission, int year, int horsepower, String drivenwheel, String busi) {
		// TODO Auto-generated constructor stub
		super(manufacturer, cartype, transmission, year, horsepower, drivenwheel);
		this.busi = busi;
	}

	public String getBusi() {
		return busi;
	}

	public void setBusi(String busi) {
		this.busi = busi;
	}

	@Override
	public int calculatePrice() {
		int price = 0;
		
		if(this.busi.equals("Standard")) {
			price = 200000000;
		}else if(this.busi.equals("Platinum")) {
			price = 250000000;
		}else if(this.busi.equals("Iridium")) {
			price = 300000000;
		}
		return price;
	}

	@Override
	public void getAdvantage() {
		// TODO Auto-generated method stub
		if(this.busi.equals("Standard")) {
			System.out.println("Congratulations!");
			System.out.println("You get a warranty for 1 years");
		}else if(this.busi.equals("Platinum")) {
			System.out.println("Congratulations!");
			System.out.println("You get a warranty for 2 years");
		}else if(this.busi.equals("Iridium")) {
			System.out.println("Congratulations!");
			System.out.println("You get a warranty for 5 years");
		}
	}
}