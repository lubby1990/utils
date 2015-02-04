package com.lubby.subcribe.listener;

import com.lubby.subcribe.event.Event;

/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 下午1:24:32  
 * 
 */
public class FatherListener implements Listener{

	public void process(Event event) {
		System.out.println("Father cares :" + event.getEventName());
	}

}
