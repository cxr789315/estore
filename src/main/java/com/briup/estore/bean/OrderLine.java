package com.briup.estore.bean;

/**
 * 订单项类
 */
public class OrderLine {
	private Integer id;
	private Integer num;
	private Double cost;
	private Book book;
	private OrderForm order;
	
	

	public OrderForm getOrder() {
		return order;
	}

	public void setOrder(OrderForm order) {
		this.order = order;
	}

	public OrderLine() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", cost=" + cost + ", book=" + book + "]";
	}

}
