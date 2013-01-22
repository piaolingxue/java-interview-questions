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
public class BubbleSort {
	private static Logger LOG = LoggerFactory.getLogger(BubbleSort.class);

	public static void sort(int[] data) {
		int flag = data.length;
		for (int i = 0; flag > 0 && i < data.length; ++i) {
			flag = 0;
			for (int j = 1; j < data.length - i; ++j) {
				if (data[j - 1] > data[j]) {
					int tmp = data[j - 1];
					data[j - 1] = data[j];
					data[j] = tmp;
					flag = j;
				}
			}
			LOG.debug(String.format("result:%s", Arrays.toString(data)));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort(data);
		LOG.info(String.format("result:%s", Arrays.toString(data)));
		data = new int[] { 1, 2, 3, 9, 5, 6, 7, 8};
		sort(data);
		LOG.info(String.format("result:%s", Arrays.toString(data)));
	}

}
