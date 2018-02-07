package java01;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {

	public static void main(String[] args) {
		//ConcurrentHashMap   多线程环境下
		ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
		
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					map.put(i+"", i+"线程一");
				}
			}
		});
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					map.put(i+"", i+"线程二");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (Entry<String, Object> obj : map.entrySet()) {
					System.out.println(obj.getValue());
					System.out.println(obj.getKey());
				}
			}
		});
		
		t.start();
		t1.start();
		t2.start();

		
	
	}
	
	
	
	
}
