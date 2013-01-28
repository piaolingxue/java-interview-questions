/**
 * 
 */
package com.plxue.interview.taobao;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

/*
 // @author libin
 // 假设有10亿个数字，找出前10万个数
 // 一个整数为4 个字节 
 // 即使使用数组也需要900,000,000 * 4byte = 3.7G 内存 
 // 对于32 位系统，访问2G 以上的内存非常困难，而且一般设备也没有这么多的物理内存 
 // 将数据完全导入到内存中的做法不现实 
 // 所以解决这种问题的思路基本上都是用堆
 */
public class FindPreTenThousandNumber {
	private static Logger LOG = LoggerFactory.getLogger(FindPreTenThousandNumber.class);
	
	
	public static void buildHeap(Long[] data) {
		int lastParentIndex = (data.length - 1) >> 1;
		for (int i = lastParentIndex; i >= 0; --i) {
			maxHeapify(data, data.length, i);
		}
	}
	
	public static void maxHeapify(Long[] data, int heapSize, int index) {
		int left = getLeftChild(index);
		int right = getRightChild(index);
		
		int largest = index;
		if (left < heapSize && data[left] > data[largest])
			largest = left;
		if (right < heapSize && data[right] > data[largest])
			largest = right;
		
		if (largest != index) {
			long tmp = data[index];
			data[index] = data[largest];
			data[largest] = tmp;
			
			maxHeapify(data, heapSize, largest);
		}
	}
	
	public static int getLeftChild(int index) {
		return (index << 1) + 1;
	}
	
	public static int getRightChild(int index) {
		return (index << 1) + 2;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Long> r = new HashSet<Long>((int)(100000/0.75)+1);
		Random random = new Random();
		Long[] data = new Long[100000];
		for (long i = 0; i < 1000000000; ++i) {
			long num = random.nextLong();
			if (r.size() < 100000) {
				if (!r.contains(num))
					r.add(num);
				
				if (r.size() == 100000) {
					// 达到10w,创建大顶堆
					r.toArray(data);
					FindPreTenThousandNumber.buildHeap(data);
				}
			}
			if (!r.contains(num) && num < data[0]) {
				data[0] = num;
				FindPreTenThousandNumber.maxHeapify(data, data.length, 0);
			}
			if (i % 100000 == 0) {
				LOG.debug(String.format("current i:%d", i));
			}
		}
		LOG.debug("over!");
		
	}

}
