package com.plxue.interview.taobao;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 // 数学宝塔
 //  数学宝塔，从最顶上走到最底层，每次只能走到下一层的左边或右边的数字，求出使所走到的所有数字之和为60的途径。 
 //　　　　　　　　7
 //　　　　　　　4　　6
 //　　　　　　6　　9　　3
 //　　　　　6　　3　　7　　1
 //　　　　2　　5　　3　　2　　8
 //　　　5　　9　　4　　7　　 3　　2
 //　　6　　4　　1　　8　　5　　6　　3
 //　3　　9　　7　　6　　8　　4　　1　　5
 // 2　　5　　7　　3　　5　　7　　8　　4　　2
 */
public class MathmaticsPagoda {
	private static Logger LOG = LoggerFactory.getLogger(MathmaticsPagoda.class);
	
	private static final int HEIGHT = 9;
	
	private static int[] date = new int[] {
		7,
		4, 6,
		6, 9, 3,
		6, 3, 7, 1,
		2, 5, 3, 2, 8,
		5, 9, 4, 7, 3, 2,
		6, 4, 1, 8, 5, 6, 3,
		3, 9, 7, 6, 8, 4, 1, 5,
		2, 5, 7, 3, 5, 7, 8, 4, 2
	};
	
	private static int[][] pagoda = new int[HEIGHT][];
	
	public static void fromTopToDown(int h, int index, ArrayList<Integer> queue) {
		queue.add(pagoda[h][index]);
		if (h + 1 == HEIGHT) {
			int sum = 0;
			for (int i = 0; i < queue.size(); ++i) {
				sum += queue.get(i);
			}
			if (sum == 60) {
				LOG.info(String.format("hit! %s", queue.toString()));
			}
			return;
		}
		fromTopToDown(h+1, index, new ArrayList<Integer>(queue) );
		fromTopToDown(h+1, index+1, new ArrayList<Integer>(queue));
	}
		
	public static void main(String[] args) {
		// read data to pagoda
		for (int i = 0; i < HEIGHT; ++i) {
			int from = (i + 1)  * i / 2;
			int to = from + i + 1;
			pagoda[i] = Arrays.copyOfRange(date, from,  to);
			LOG.debug(String.format("HEIGHT:%d, from:%d, to:%d, date:%s", i, 
					from,to,
					Arrays.toString(pagoda[i])));
		}
		
		fromTopToDown(0, 0, new ArrayList<Integer>());
	}
}
