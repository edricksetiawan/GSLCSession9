package Session9;

public abstract class Car {
	private String manufacturer;
	private String cartype;
	private String transmission;
	private int year;
	private int horsepower;
	private String drivenwheel;
	
	public Car(String manufacturer, String cartype, String transmission, int year, int horsepower, String drivenwheel) {
		// TODO Auto-generated constructor stub
		this.manufacturer = manufacturer;
		this.cartype = cartype;
		this.transmission = transmission;
		this.year = year;
		this.horsepower = horsepower;
		this.drivenwheel = drivenwheel;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public String getDrivenwheel() {
		return drivenwheel;
	}

	public void setDrivenwheel(String drivenwheel) {
		this.drivenwheel = drivenwheel;
	}
	
	public abstract int calculatePrice();
}