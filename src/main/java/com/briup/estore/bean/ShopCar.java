package com.briup.estore.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author matingting
 * 购物车类
 */
public class ShopCar {
	//key代表的是书籍id
	//value代表的是（购物车项）订单项
	private Map<Integer, OrderLine> map = new HashMap<>();
	
	//添加购物车
	public void addShopCar(OrderLine line) {
		/*如何确定是第一次添加到购物车呢？
		每次执行添加购物车功能的时候  先判断一下 map集合中有没有对应的这本书的orderline记录
		如果有 那就说明不是第一次添加，反之，就说明是第一次添加
		*/
		
		//1.获取想要添加到购物车的书籍id
		Integer bookId = line.getBook().getId();
		//2.去map集合中找这个bookId有没有存在过
		if(map.containsKey(bookId)) {
			//3.拿出之前的旧值
			OrderLine orderLine = map.get(bookId);
			//4.新旧值叠加  1  +   4  = 5 
			orderLine.setNum(orderLine.getNum()+line.getNum());
			orderLine.setCost(orderLine.getCost()+line.getCost());
		}else {
			map.put(line.getBook().getId(),line);
		}
	}
	
	//返回购物车中的数据
	public Map<Integer,OrderLine> getOrderLines(){
		return map;
	}
	
	//获取购物车总件数
	public int getSumNum() {        
		return map.size();
	}
	
	//获取购物车的总价钱
	public double getCost() {
		Set<Integer> set = map.keySet();
		double sum  = 0.0;
		for(Integer bookId:set) {
			OrderLine orderLine = map.get(bookId);
			//sum = sum +orderLine.getCost();
			sum+=orderLine.getCost();
		}
		return sum;
	}
}
