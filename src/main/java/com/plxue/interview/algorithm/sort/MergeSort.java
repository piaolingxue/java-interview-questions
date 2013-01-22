package com.plxue.interview.algorithm.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Merge Sort(归并排序)
 * @author libin
 *
 */
public class MergeSort {
	private static Logger LOG = LoggerFactory.getLogger(MergeSort.class);
	
	/**
	 * merge data[start ... mid] and a[mid +1, end]
	 * both data[start ... mid] and a[mid +1, end] are in order
	 * @param data
	 * @param start
	 * @param mid
	 * @param end
	 */
	public static void merge(int[] data, int start, int mid, int end, int[] tmp) {
		int i = start;
		int j = mid+1;
		int index = 0;
		while (true) {
			tmp[index++] = data[i] >= data[j] ? data[j++] : data[i++];

			if (i > mid) {
				while (j <= end) {
					tmp[index++] = data[j++];
				}
				break;
			}
			if (j > end) {
				while (i <= mid) {
					tmp[index++] = data[i++];
				}
				break;
			}
		}
		while (--index >= 0) {
			data[start+index] = tmp[index];
		}
	}
	
	public static void sort(int[] data, int start, int end, int[] tmp) {
		if (start < end) {
			int mid = start + ((end - start) >> 1);
			sort(data, start, mid, tmp);
			sort(data, mid+1, end, tmp);
			merge(data, start, mid, end, tmp);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 9, 8,  7, 6, 5, 4, 3, 2, 1};
		sort(data, 0, data.length-1, new int[data.length]);
		LOG.info(String.format("result:%s", Arrays.toString(data)));
	}

}
