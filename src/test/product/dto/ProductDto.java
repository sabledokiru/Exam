package test.product.dto;

public class ProductDto {
	private int productNum;
	private String productName;
	private String brand;
	private String delivery;
	private String regdate;
	
	public ProductDto(){};

	public ProductDto(int productNum, String productName, String brand, String delivery, String regdate) {
		this.productNum = productNum;
		this.productName = productName;
		this.brand = brand;
		this.delivery = delivery;
		this.regdate = regdate;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	};
}
