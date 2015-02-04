package com.lubby.test.utils.subscribe.asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 上午10:59:35  
 * 
 */
public class Container {
	
	private List<Listener> listernerList = new ArrayList<Listener>();
	
	public void add(Listener listener){
		listernerList.add(listener);
	}
	
	
	
	
	
	public void access(final Event event){
		ExecutorService  es = Executors.newFixedThreadPool(2);
	
		for(final Listener l : listernerList){
			es.execute(new Runnable() {
				
				public void run() {
					l.process(event);
				}
			});
			
		}
		
	}

}
