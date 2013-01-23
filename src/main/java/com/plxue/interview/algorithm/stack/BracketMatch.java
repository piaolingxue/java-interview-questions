/**
 * 
 */
package com.plxue.interview.algorithm.stack;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author matrix
 * 
 */
public class BracketMatch {
	private static Logger LOG = LoggerFactory.getLogger(BracketMatch.class);
	
	public static boolean match(String exp) {
		Stack<Character> stack = new Stack<Character>();
		for (char ch : exp.toCharArray()) {
			switch (ch) {
			case '{':
			case '[':
			case '(':
				stack.push(ch);
				break;
			case '}':
				if (!stack.empty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
				break;
			case ']':
				if (!stack.empty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
				break;
			case ')':
				if (!stack.empty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
				break;
			default:
				break;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] expressions = new String[] {
				"{ 2 + 3 * [3 + (2-1)]",
				"{ 2 + 3 * [3 + (2-1)]}",
				"{{{{[[[[]]]}}",
				"{()}",
				"(([[}}]",
				"(()[]))",
				"[([])",
				"(()]",
				"[(])",
				"([())",
				"{{[(())]}}"
		};
		for (String expression : expressions) {
			LOG.debug(String.format("exp:%s, result:%s", expression, match(expression)));
		}
	}

}
