package com.plxue.interview.taobao;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindPreTenThousandNumberTest {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void test() {
		Long[] data = new Long[] {20L, 18L, 2L, 19L, 32L, 40L};
		FindPreTenThousandNumber.buildHeap(data);
		
		for (int i = data.length - 1; i >= 0; i--) {
			long tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;
			FindPreTenThousandNumber.maxHeapify(data, i, 0);
		}
		
		LOG.debug(String.format("heap:%s", Arrays.toString(data)));
	}

}
