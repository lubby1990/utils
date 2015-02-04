package com.lubby.subcribe;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Test;

import com.lubby.subcribe.event.EatEvent;
import com.lubby.subcribe.event.Event;
import com.lubby.subcribe.event.SleepEvent;
import com.lubby.subcribe.listener.FatherListener;
import com.lubby.subcribe.listener.Listener;
import com.lubby.subcribe.listener.MotherListener;
import com.lubby.subcribe.processor.Container;

/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 下午1:28:13  
 * 
 */
public class ContainerTest {

	@Test
	public void test() {
		Event eatEvent = new EatEvent();
		eatEvent.setEventName("eat");
		
		Event sleepEvent = new SleepEvent();
		sleepEvent.setEventName("sleep");
		
		Listener fl = new FatherListener();
		Listener ml = new MotherListener();

		
		Container container = new Container();
		container.register(EatEvent.class, fl);
		container.register(EatEvent.class, ml);
		
		container.register(SleepEvent.class, fl);
		
		container.post(eatEvent);
//		container.post(eatEvent);
//		container.post(eatEvent);
//		container.post(eatEvent);
//		container.post(eatEvent);
//		container.post(sleepEvent);
		System.out.println("1111111111");
		
		
		
		/*final BlockingQueue<Object> bq = new	ArrayBlockingQueue<Object>(5);
		for(int i = 0 ;i< 10 ; i++){
			new Thread(new Runnable() {
				public void run() {
					try {
						bq.put(new Object());
						System.out.println("放鸡蛋");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}).start();
		}
		
		for(int i = 0 ;i< 10 ; i++){
			new Thread(new Runnable() {
				public void run() {
					try {
						bq.take();
						System.out.println("取鸡蛋");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}).start();
		}*/
		
		
	}

}
