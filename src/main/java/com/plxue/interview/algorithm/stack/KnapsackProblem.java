/**
 * 
 */
package com.plxue.interview.algorithm.stack;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 // @author matrix
 // Jan 23, 2013
 // 背包问题(Knapsack Problem)
 // 假设有一个能装入总体积为T的背包和n件体积分别为w1, w2, ... , wn的物品
 // 能否从n件物品中挑选若干件恰好装满背包,即使wi1 + wi2 + .. + wik = T,
 // 要球找出所有满足上述条件的解.
 // e.g.
 // 当T = 10, 各件体积为{1, 8, 4, 3, 5, 2}时,可找到下列4组解
 // (1, 4, 3, 2) (1, 4, 5) (8, 2) 和 (3, 5, 2)
 // 解题思路:回溯法
 */
public class KnapsackProblem {
	private static Logger LOG = LoggerFactory.getLogger(KnapsackProblem.class);
	
	public static void knapsack(int[] data, int T) {
		Stack<Integer>  stack = new Stack<Integer>();
		int k = 0;
		do {
			while (T > 0 && k < data.length) {
				if (T - data[k] >= 0) {
					stack.push(k);
					T -= data[k];
				}
				k++;
			}
			
			if (T == 0) {
				// got it
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < stack.size(); ++i) {
					sb.append(String.format("%d,", data[stack.get(i)]));
				}
				LOG.debug(sb.toString());
			}
			
            k = stack.pop();            
			T += data[k];
			++k;
		} while (!stack.empty() || k < data.length);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		knapsack(new int[] {1, 8, 4, 3, 5, 2}, 10);
	}

}
