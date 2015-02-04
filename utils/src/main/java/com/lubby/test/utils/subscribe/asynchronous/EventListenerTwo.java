package com.lubby.test.utils.subscribe.asynchronous;
/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 上午10:55:31  
 * 
 */
public class EventListenerTwo implements Listener{

	public void process(Event event) {
		System.out.println(EventListenerTwo.class.getSimpleName() + "---" + event.getEventName());
	}

}
