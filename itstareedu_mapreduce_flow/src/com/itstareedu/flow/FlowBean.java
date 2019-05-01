package com.itstareedu.flow;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 * 
 * 类描述：流量实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月16日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class FlowBean implements Writable {
	
	// 上传流量
	private long upFlow;
	
	// 下载流量
	private long dfFlow;
	
	// 上传与下载总流量
	private long flowSum;

	public FlowBean() {
		
	}

	public FlowBean(long upFlow, long dfFlow) {
		this.upFlow = upFlow;
		this.dfFlow = dfFlow;
		// 上传与下载总流量
		this.flowSum = upFlow + dfFlow;
	}

	public long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	public long getDfFlow() {
		return dfFlow;
	}

	public void setDfFlow(long dfFlow) {
		this.dfFlow = dfFlow;
	}

	public long getFlowSum() {
		return flowSum;
	}

	public void setFlowSum(long flowSum) {
		this.flowSum = flowSum;
	}

	/**
	 * 反序列化
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		upFlow = in.readLong();
		dfFlow = in.readLong();
		flowSum = in.readLong();
	}

	/**
	 * 序列化
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(upFlow);
		out.writeLong(dfFlow);
		out.writeLong(flowSum);
	}

	@Override
	public String toString() {
		return upFlow +"\t"+ dfFlow +"\t"+ flowSum;
	}
}
