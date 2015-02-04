package com.lubby.subcribe.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lubby.subcribe.event.Event;
import com.lubby.subcribe.listener.Listener;

/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 下午12:52:36  
 * 
 */
public class Container {
	private BlockingQueue<Event> eventQueue ;
	private Map<Class<? extends Event>, List<Listener>> eventListenerList ;
	private int threadPoolSize = 3;
	  ExecutorService es ;
	public Container() {
		eventQueue = new ArrayBlockingQueue<Event>(10);
		eventListenerList = new HashMap<Class<? extends Event>, List<Listener>>();
		es = Executors.newFixedThreadPool(threadPoolSize);
		eventQueueHandler();
	}
	public Container(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
		eventQueue =  new ArrayBlockingQueue<Event>(10);
		eventListenerList = new HashMap<Class<? extends Event>, List<Listener>>();
		es = Executors.newFixedThreadPool(threadPoolSize);
		eventQueueHandler();
	}


	/** create the list of Listener and register the listener with event */
	public void register(Class<? extends Event> clazz , Listener listerner){
		if(!eventListenerList.containsKey(clazz)){
			eventListenerList.put(clazz, new ArrayList<Listener>());
		}
		List<Listener> el = eventListenerList.get(clazz);
		el.add(listerner);
		
	}
	
	
	/** call the Listener registing with the event process*/
	public void post(final Event event){
		
		try {
			eventQueue.put(event);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	public void eventQueueHandler(){
		Thread t = new Thread(new Runnable() {
			public void run() {
				while(true){
					Event event = null;
					try {
							event = eventQueue.take();
							callTheadOfListener(event);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		});
		//set the thread being not daemon thread
		t.setDaemon(false);
		t.start();
	}
	
	
	public void callTheadOfListener(final Event event){
		Class<? extends Event> eventClazz = event.getClass();
		
		List<Listener> eventListener = eventListenerList.get(eventClazz);
		   
	  
	    
	    
	    if(eventListener == null){
	    	System.out.println("no Listerner register to this event : " + event.getClass().getName());
	    	return;
	    }
	    
	    //thread pool execute the listener
	    for(final Listener listener : eventListener){
	    	es.execute(new Runnable() {
				public void run() {
					listener.process(event);
				}
			});
	    }
	}


}
