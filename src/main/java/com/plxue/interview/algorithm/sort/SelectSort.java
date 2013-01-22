/**
 * 
 */
package com.plxue.interview.algorithm.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author libin
 *
 */
public class SelectSort {
	private static Logger LOG = LoggerFactory.getLogger(SelectSort.class);
	
	public static void sort(int[] data) {
		for (int i = 0; i < data.length; ++i) {
			int index = i;
			for (int j = i + 1; j < data.length; ++j) {
				if (data[j] < data[index])
					index = j;
			}
			if (index != i) {
				int tmp = data[index];
				data[index] = data[i];
				data[i] = tmp;
			}
		}
	}
	
	/**
	 * @param args
	 * 直接选择排序
	 */
	public static void main(String[] args) {
		int[] data = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
		sort(data);
		LOG.info(String.format("result:%s", Arrays.toString(data)));
	}

}
