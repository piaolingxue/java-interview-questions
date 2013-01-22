/**
 * 
 */
package com.plxue.interview.algorithm.microsoft;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 // 在一个排列中，如果一对数的前后位置与大小顺序相反，
 //	即前面的数大于后面的数，那么它们就称为一个逆序数对。
 // 一个排列中逆序的总数就称为这个排列的逆序数。
 // 如{2，4，3，1}中，2和1，4和3，4和1，3和1是逆序数对，
 // 因此整个数组的逆序数对个数为4，现在给定一数组，要求统计出该数组的逆序数对个数。
 //
 */
public class ReversedOrder {
	private static Logger LOG = LoggerFactory.getLogger(ReversedOrder.class);

	/**
	 * 该算法时间复杂度n^2
	 * 
	 * @param data
	 * @return
	 */
	public static int first(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length - 1; ++i) {
			for (int j = i + 1; j < data.length; ++j) {
				if (data[j] < data[i])
					sum++;
			}
		}
		return sum;
	}

	public static int second(int[] data) {
		return sort(data, 0, data.length - 1, new int[data.length]);
	}

	public static int sort(int[] data, int start, int end, int[] tmp) {
		int sum = 0;
		if (start < end) {
			int mid = start + ((end - start) >> 1);
			sum += sort(data, start, mid, tmp);
			sum += sort(data, mid + 1, end, tmp);
			sum += merge(data, start, mid, end, tmp);
		}
		return sum;
	}

	public static int merge(int[] data, int start, int mid, int end, int[] tmp) {
		int sum = 0;
		int i = start;
		int j = mid + 1;
		int index = 0;
		while (true) {
			if (data[i] <= data[j])
				tmp[index++] = data[i++];
			else {
				tmp[index++] = data[j++];
				sum += mid - i + 1;
			}
			
			if (i > mid) {
				for (; j <= end;)
					tmp[index++] = data[j++];
				break;
			}
			if (j > end) {
				for (; i <= mid;)	
					tmp[index++] = data[i++];
				break;
			}
		}
		while(--index >= 0) {
			data[start + index] = tmp[index];
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 2, 4, 3, 1 };
		LOG.debug(String.format("result:%d", first(data)));
		LOG.debug(String.format("result:%d", second(data)));
		LOG.debug(String.format("data:%s", Arrays.toString(data)));
	}

}
