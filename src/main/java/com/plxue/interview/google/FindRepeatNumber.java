/**
 * 
 */
package com.plxue.interview.google;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 // @author libin
 // 一个大小为n的数组，里面的数都属于范围[0, n-1]，有不确定的重复元素，
 // 找到至少一个重复元素，要求O(1)空间和O(n)时间。
 */
public class FindRepeatNumber {
	private static Logger LOG = LoggerFactory.getLogger(FindRepeatNumber.class);
	
	public static int hasRepeatNumber(int[] data) {
		int n = data.length;
		for (int i = 0; i < n; ++i) {
			while (data[i] != i) {
				int tmp = data[i];
				if (data[tmp] == tmp) {
					return tmp;
				}
				
				// swap
				data[i] = data[tmp];
				data[tmp] = tmp;
			}
		}
		return -1;
	}
	
	public static int getRepeatNumber1(int[] data) {
		int n = data.length;
		for (int i = 0; i < n; ++i) {
			int nRepeatIndex = data[i] >= n ? data[i] - n : data[i];
		}
		
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.debug(String.format("[4, 3, 2, 1, 2]%d", hasRepeatNumber(new int[] {4, 3, 2, 1, 2})));
		LOG.debug(String.format("[4, 3, 2, 1, 0]%d", hasRepeatNumber(new int[] {4, 3, 2, 1, 0})));

	}

}
