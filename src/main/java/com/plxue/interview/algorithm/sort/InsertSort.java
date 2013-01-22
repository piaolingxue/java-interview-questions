/**
 * 
 */
package com.plxue.interview.algorithm.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author libin
 * 插入排序
 */
public class InsertSort {
	private static Logger LOG = LoggerFactory.getLogger(InsertSort.class);
	
	public static void sort(int[] data) {
		for (int i = 1; i < data.length; ++i) {
			int tmp = data[i];
			int j;
			for (j = i-1; j >= 0 && data[j] > tmp; j--) {
				data[j + 1] = data[j];
			}
			data[++j] = tmp;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
		sort(data);
		LOG.debug(String.format("result:%s", Arrays.toString(data)));
	}

}
