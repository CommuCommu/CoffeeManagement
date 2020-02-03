package dto;

public class CoffeeOrderListDto {
	private String name;
	private String syrup;
	private String ordersize;
	private int shot;	//1은 추가, 0은 추가 안함
	private int cream;  //1은 추가, 0은 추가 안함
	private int ordercount;
	private int price;
	private String date;
	
	public CoffeeOrderListDto() {
		
	}
	public CoffeeOrderListDto(String name, String syrup, String ordersize, int shot, int cream, int ordercount,
			int price, String date) {
		super();
		this.name = name;
		this.syrup = syrup;
		this.ordersize = ordersize;
		this.shot = shot;
		this.cream = cream;
		this.ordercount = ordercount;
		this.price = price;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "CoffeeOrderListDto [name=" + name + ", syrup=" + syrup + ", ordersize=" + ordersize + ", shot=" + shot
				+ ", cream=" + cream + ", ordercount=" + ordercount + ", price=" + price + ", date=" + date + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSyrup() {
		return syrup;
	}
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}
	public String getOrdersize() {
		return ordersize;
	}
	public void setOrdersize(String ordersize) {
		this.ordersize = ordersize;
	}
	public int getShot() {
		return shot;
	}
	public void setShot(int shot) {
		this.shot = shot;
	}
	public int getCream() {
		return cream;
	}
	public void setCream(int cream) {
		this.cream = cream;
	}
	public int getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}


