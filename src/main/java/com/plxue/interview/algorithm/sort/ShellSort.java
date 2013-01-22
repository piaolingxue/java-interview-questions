/**
 * 
 */
package com.plxue.interview.algorithm.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author libin 希尔排序(ShellSort)
 */
public class ShellSort {
	private static Logger LOG = LoggerFactory.getLogger(ShellSort.class);

	private static int[] gaps = new int[] { 701, 301, 132, 57, 23, 10, 4, 1 };

	public static void sort(int[] data) {
		for(int gap : gaps) {
			for (int j = gap; j < data.length; ++j) {
				int tmp = data[j];
				int k = j - gap; 
				for (; k >= 0 && data[k] > tmp; k -= gap) {
					data[k + gap] = data[k];
				}
				data[k + gap] = tmp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort(data);
		LOG.debug(String.format("result:%s", Arrays.toString(data)));
	}

}
