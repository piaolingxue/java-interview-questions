/**
 * 
 */
package com.plxue.interview.algorithm.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * // @author matrix // 堆排序 // 主要思路:
 */
public class HeapSort {
	private static Logger LOG = LoggerFactory.getLogger(HeapSort.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 40, 55, 73, 12, 98, 27 };
		buildMaxHeap(data);

		for (int i = data.length - 1; i >= 0; i--) {
			LOG.debug(String.format("top:%d", data[0]));
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;
			maxHeapify(data, i, 0);
		}

		LOG.info(String.format("result:%s", Arrays.toString(data)));
	}

	private static void buildMaxHeap(int[] data) {
		int lastParentIndex = (data.length - 1) >> 1;
		for (int index = lastParentIndex; index >= 0; index--)
			maxHeapify(data, data.length, index);
	}

	/**
	 * if current node less than child then swap them.
	 * 
	 * @param data
	 * @param heapSize
	 * @param index
	 */
	private static void maxHeapify(int[] data, int heapSize, int index) {
		int left = getLeftChildIndex(index);
		int right = getRightChildIndex(index);

		int largest = index;
		if (left < heapSize && data[left] > data[largest])
			largest = left;
		if (right < heapSize && data[right] > data[largest])
			largest = right;

		if (largest != index) {
			int tmp = data[index];
			data[index] = data[largest];
			data[largest] = tmp;
			// after swap, current node 'data[largest]'
			// may not be the max node.
			maxHeapify(data, heapSize, largest);
		}
	}

	/**
	 * get left child's index
	 * 
	 * @param index
	 * @return
	 */
	private static int getLeftChildIndex(int index) {
		return (index << 1) + 1;
	}

	/**
	 * get right child's index
	 * 
	 * @param index
	 * @return
	 */
	private static int getRightChildIndex(int index) {
		return (index << 1) + 2;
	}

}
