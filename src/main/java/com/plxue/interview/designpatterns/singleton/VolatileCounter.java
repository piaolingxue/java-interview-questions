/**
 * 
 */
package com.plxue.interview.designpatterns.singleton;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 // @author libin
 // 当变量的值由其他变量的值决定的时候，该变量前面加上volatile才是原子操作.
 // 否则，如果该变量的值由自身的值决定的时候，不是原子操作
 */
public class VolatileCounter {
	private static Logger LOG = LoggerFactory.getLogger(VolatileCounter.class);

	private static VolatileCounter counter = null;

	private int m;
	
	private volatile boolean stop;

	private VolatileCounter() {
		m = 0;
		stop = false;
	}

	public static VolatileCounter getInstance() {
		if (null == counter) {
			synchronized (VolatileCounter.class) {
				if (null == counter)
					counter = new VolatileCounter();
			}
		}
		return counter;
	}

	public synchronized void incM() {
		try {
			Thread.sleep(2);
		} catch (Exception e) {

		}
		m++;
	}

	public void stop() {
		stop = true;
	}
	
	public boolean isStop() {
		return stop;
	}

	public void display() {
		LOG.debug(String.format("m:%d", m));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		for (int time = 0; time < 10; ++time) {
			Set<Thread> ts = new HashSet<Thread>();
			for (int i = 0; i < 10; ++i) {
				Thread t = new Thread(new Runnable() {
					
					public void run() {
						VolatileCounter counter = VolatileCounter.getInstance();
						while(!counter.isStop()) {
							counter.incM();
						}
					}
				});
				t.start();
				ts.add(t);
			}
			Thread.sleep(200);
			VolatileCounter.getInstance().stop();
			while(!ts.isEmpty()) {
				Iterator<Thread> iter = ts.iterator();
				while(iter.hasNext()) {
					Thread t = iter.next();
					if (!t.isAlive())
						iter.remove();
				}
			}
			VolatileCounter.getInstance().display();
		}
	}

}
