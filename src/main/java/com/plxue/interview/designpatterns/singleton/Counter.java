/**
 * 
 */
package com.plxue.interview.designpatterns.singleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author libin
 * 
 */
public class Counter {
	private static Logger LOG = LoggerFactory.getLogger(Counter.class);

	private static Counter singleton = null;

	private int count;
	
	private Counter() {
		count = 0;
	}

	public static Counter getInstance() {
		if (null == singleton) {
			synchronized (Counter.class) {
				if (null == singleton)
					singleton = new Counter();
			}
		}
		return singleton;
	}

	public int inc() {
		// 这里延迟1毫秒，使得结果明显
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
		}

		synchronized (Counter.class) {
			++count;
		}
		
		return count;
	}

	public int value() {
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		for (int time = 0; time < 10; ++time) {
			List<Thread> ts = new ArrayList<Thread>();
			for (int i = 0; i < 10; ++i) {
				Thread t = new Thread(new Runnable() {

					public void run() {
						Counter counter = Counter.getInstance();
						counter.inc();
						counter.inc();
						counter.inc();
						counter.inc();
						counter.inc();
						counter.inc();
						counter.inc();
						counter.inc();
						counter.inc();
						counter.inc();
//						LOG.debug(String.format("###count:%d", counter.value()));
					}
				});
				t.start();
				ts.add(t);
			}
			// wait for threads exit the process
			while (!ts.isEmpty()) {
				Iterator<Thread> iter = ts.iterator();
				while(iter.hasNext()) {
					Thread t = iter.next();
					if (!t.isAlive()) {
						iter.remove();
					}
				}
			}
			LOG.debug(String.format("count:%d", Counter.getInstance().value()));
		}
	}

}
