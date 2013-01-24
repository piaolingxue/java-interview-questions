/**
 * 
 */
package com.plxue.interview.algorithm.stack;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 // @author matrix
 // Jan 24, 2013
 //
 */
public class ExpressionEvaluationTest {
	private Logger LOG = LoggerFactory.getLogger(ExpressionEvaluation.class);
	
	@Test
	public void test_postfix_transform() {
		LOG.debug(ExpressionEvaluation.transform("a+(b+(c/d-e))*f"));
	}

}

