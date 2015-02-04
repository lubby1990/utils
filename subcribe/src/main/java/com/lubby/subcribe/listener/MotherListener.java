package com.lubby.subcribe.listener;

import com.lubby.subcribe.event.Event;

/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 下午1:26:04  
 * 
 */
public class MotherListener implements Listener{

	public void process(Event event) {
		System.out.println("Mother cares :" + event.getEventName());
	}

}
