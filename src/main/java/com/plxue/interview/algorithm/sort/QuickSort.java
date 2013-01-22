/**
 * 
 */
package com.plxue.interview.algorithm.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * QuickSort (快速排序)
 * 
 * @author libin
 * 
 */
public class QuickSort {
	private static Logger LOG = LoggerFactory.getLogger(QuickSort.class);

	/**
	 * quick sort 算法复杂度nlog(n)
	 * @param data
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] data, int start, int end) {
		if (start < end) {
			int i = start;
			int j = end;
			int num = data[i];
			while (i != j) {
				for (; j > i; j--) {
					if (data[j] <= num) {
						data[i++] = data[j];
						break;
					}
				}
				for (; i < j; i++) {
					if (data[i] > num) {
						data[j--] = data[i];
						break;
					}
				}
			}
			data[i] = num;
			LOG.debug(String.format("tmp:%s", Arrays.toString(data)));
			quickSort(data, start, i - 1);
			quickSort(data, i + 1, end);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 9, 8, 7, 4, 5, 4, 3, 2, 1 };
		quickSort(data, 0, data.length - 1);
		LOG.info(String.format("result:%s", Arrays.toString(data)));
	}

}
