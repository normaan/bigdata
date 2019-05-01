package com.itstaredu.assistranking;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/**
 * 
 * 类描述：辅助排序-天猫实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月23日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class OrderBean implements WritableComparable<OrderBean> {

	// 订单id
	private int order_id;
	// 价格
	private double price;
	
	public OrderBean() {
		
	}
	public OrderBean(int order_id, double price) {
		this.order_id = order_id;
		this.price = price;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * 反序列化
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		order_id = in.readInt();
		price = in.readDouble();
	}
	/**
	 * 序列化
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(order_id);
		out.writeDouble(price);
	}
	/**
	 * 排序:需要比较id,再比较价格
	 */
	@Override
	public int compareTo(OrderBean o) {
		int rs;
		// 根据id排序
		if (order_id > o.order_id) {
			// id大的往下排
			rs = 1;
		} else if (order_id < o.order_id) {
			// id小的往上排
			rs = -1;
		} else {
			// id相等,价格高的上排
			rs = price > o.getPrice() ? -1 : 1;
		}
		return rs;
	}
	
	@Override
	public String toString() {
		return order_id + "\t" + price;
	}
}
