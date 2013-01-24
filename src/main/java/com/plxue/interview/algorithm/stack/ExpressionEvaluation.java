/**
 * 
 */
package com.plxue.interview.algorithm.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 // @author matrix
 // Jan 23, 2013
 // 表达式求值(Expression Evaluation)
 // 基本规则
 // 1. 先乘除，后加减
 // 2. 从左算到右
 // 3. 先括号内，后括号外
 */
public class ExpressionEvaluation {
	private static Logger LOG = LoggerFactory
			.getLogger(ExpressionEvaluation.class);

	private static List<Character> ops = Arrays.asList('+', '-', '*', '/', '(',
			')', '[', ']', '{', '}', '#');

	// ------------------ 左操作符跟右操作符优先级关系表 -------------------
	// |------'+', '-', '*', '/', '(', ')', '[', ']', '{', '}', '#'--|
	// |-------------------------------------------------------------|
	private static char[][] prioTable = new char[][] {
			{ '>', '>', '<', '<', '<', '>', '<', '>', '<', '>', '>' }, // +
			{ '>', '>', '<', '<', '<', '>', '<', '>', '<', '>', '>' }, // -
			{ '>', '>', '>', '>', '<', '>', '<', '>', '<', '>', '>' }, // *
			{ '>', '>', '>', '>', '<', '>', '<', '>', '<', '>', '>' }, // /
			{ '<', '<', '<', '<', '<', '=', ' ', ' ', ' ', ' ', ' ' }, // (
			{ '>', '>', '>', '>', ' ', '>', ' ', ' ', ' ', ' ', '>' }, // )
			{ '<', '<', '<', '<', '<', ' ', '<', '=', ' ', ' ', ' ' }, // [
			{ '>', '>', '>', '>', ' ', ' ', '=', ' ', ' ', '>', '>' }, // ]
			{ '<', '<', '<', '<', '<', ' ', '<', ' ', '<', '=', ' ' }, // {
			{ '>', '>', '>', '>', ' ', ' ', ' ', ' ', '=', '>', '>' }, // }
			{ '<', '<', '<', '<', '<', ' ', '<', ' ', '<', ' ', '=' } }; // #

	public static char precede(char l, char r) {
		return prioTable[ops.indexOf(l)][ops.indexOf(r)];
	}

	public static double operate(double l, double r, char op) {
		switch (op) {
		case '+':
			return l + r;
		case '-':
			return l - r;
		case '*':
			return l * r;
		case '/':
			return l / r;
		}
		return 0;
	}

	public static double evaluation(String expression) {
		// process expression
		expression = expression.replaceAll("\\s+", "");
		expression += '#';

		Stack<Double> operands = new Stack<Double>();
		Stack<Character> operators = new Stack<Character>();

		operators.push('#');
		int index = 0;
		while (expression.charAt(index) != '#' || operators.peek() != '#') {
			if (!ops.contains(expression.charAt(index))) {
				int end = index;
				for (; end < expression.length(); ++end) {
					if (ops.contains(expression.charAt(end + 1)))
						break;
				}
				operands.push(Double.parseDouble(expression.substring(index,
						end + 1)));
				index = end + 1;
			} else {
				switch (precede(operators.peek(), expression.charAt(index))) {
				case '<':
					operators.push(expression.charAt(index++));
					break;
				case '=':
					operators.pop();
					index++;
					break;
				case '>':
					char op = operators.pop();
					double r = operands.pop();
					double l = operands.pop();
					operands.push(operate(l, r, op));
					break;
				default:
					throw new IllegalArgumentException(String.format(
							"操作符异常:%c, %c", operators.peek(),
							expression.charAt(index)));
				}
			}
		}
		return operands.pop();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] expressions = new String[] { "3*(7-2)", "12*(14-2)+5",
				"1.1 + 2.5 * 2.2 * (2 - 5)", "{[2+3*2/(1+1)]*3+5}",
				"3*5+2-4*[1+3*(2-5)]", "[)3*3]", "{(3+2)*5 + 3*2}",
				"3+3+"};
		for (String exp : expressions) {
			try {
				LOG.debug(String.format("exp:%s, result:%.2f", exp,
						evaluation(exp)));
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

}
