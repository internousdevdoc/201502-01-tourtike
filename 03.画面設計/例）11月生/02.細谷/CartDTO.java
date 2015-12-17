package jp.co.internous.dto;

public class CartDTO {
	String goods_name;
	int sales_numbers,price,total_amount;
	/**
	 * @return goods_name
	 */
	public String getGoods_name() {
		return goods_name;
	}
	/**
	 * @param goods_name セットする goods_name
	 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	/**
	 * @return sales_numbers
	 */
	public int getSales_numbers() {
		return sales_numbers;
	}
	/**
	 * @param sales_numbers セットする sales_numbers
	 */
	public void setSales_numbers(int sales_numbers) {
		this.sales_numbers = sales_numbers;
	}
	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return total_amount
	 */
	public int getTotal_amount() {
		return total_amount;
	}
	/**
	 * @param total_amount セットする total_amount
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}


}