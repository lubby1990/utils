package com.lubby.test.utils.subscribe.asynchronous;
/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 上午10:55:18  
 * 
 */
public class EventListenerOne implements Listener{

	public void process(Event event) {
		System.out.println(EventListenerOne.class.getSimpleName() + "---" + event.getEventName());
	}

}
