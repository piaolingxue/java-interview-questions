/**
 * 
 */
package com.plxue.interview.taobao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author matrix
// 1、淘宝新产品研发中心目前有109位店小二，每位小二有一个武侠花名，都出自经典武侠小说，如笑傲江湖等。 
// 假设：花名已知，而且每个花名出处明确，数据存放文本文件（格式自拟）； 
// 问题：用JAVA和注释型的伪码写程序，计算每类出处有多少花名。 
 */
public class TaobaoShopSellerNameClassify {
	private static Logger LOG = LoggerFactory.getLogger(TaobaoShopSellerNameClassify.class);
	
	private static Map<String, Set<String>> location2names  = new HashMap<String, Set<String>>();
	
	private static final String DATABASE = "data/taoseller.txt";
	
	private static void loadData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(DATABASE));
		while (br.ready()) {
			String[] w = br.readLine().split(",");
			String location = w[1].trim();
			String name = w[2].trim();
			if (location2names.containsKey(location)) {
				Set<String> names = location2names.get(location);
				if (!names.contains(name))
					names.add(name);
			}
			else {
				Set<String> names = new HashSet<String>();
				names.add(name);
				location2names.put(location, names);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// load data
		loadData();
		for (Entry<String, Set<String>> entry : location2names.entrySet()) {
			LOG.info(String.format("cat:%s, num:%d", entry.getKey(), entry.getValue().size()));
		}
	}

}
