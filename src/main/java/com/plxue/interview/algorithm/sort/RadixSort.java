/**
 * 
 */
package com.plxue.interview.algorithm.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 //  @author matrix
 // 基数排序(RadixSort)
 */
public class RadixSort {
	private static Logger LOG = LoggerFactory.getLogger(RadixSort.class);
	
	/**
	 * 
	 * @param data
	 * @param r radix number
	 * @param m bucket number
	 */
	public static void sort(int[] data, int r, int m) {
		int[][] tmp = new int[m][data.length];
		int[] order = new int[data.length];
		
		int n = 1;
		while (r-- > 0) {
			int k = 0;
			for (int i = 0; i < data.length; ++i) {
				int lsd = (data[i]/n) % 10;
				tmp[lsd][order[lsd]++] = data[i];
			}
			
			for (int i = 0; i < data.length; ++i) {
				if (order[i] > 0) {
					for (int j = 0; j < order[i]; j++) {
						data[k++] = tmp[i][j]; 
					}
					order[i] = 0;
				}
			}

			n *= 10;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int data[] = new int[] {
				73, 22, 93, 43, 55, 14, 28, 65, 39, 81
		};
		sort(data, 2, 10);
		LOG.info(String.format("result:%s", Arrays.toString(data)));
	}

}
