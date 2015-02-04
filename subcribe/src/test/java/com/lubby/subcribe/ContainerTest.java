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
	public static void main(String[] args) {
		//create event
		Event eatEvent = new EatEvent();
		eatEvent.setEventName("eat");

		Event sleepEvent = new SleepEvent();
		sleepEvent.setEventName("sleep");
		
		//create listener
		Listener fl = new FatherListener();
		Listener ml = new MotherListener();
		
		//create center container
		Container container = new Container();
		//register the event with listener
		container.register(EatEvent.class, fl);
		container.register(EatEvent.class, ml);

		container.register(SleepEvent.class, fl);
		
		//trigger the event  
		container.post(eatEvent);
		container.post(sleepEvent);


	}

}
