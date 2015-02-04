package com.lubby.subcribe.event;
/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 下午12:55:29  
 * 
 */
public abstract class Event {
	
	private String eventName;
	
	

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(String eventName) {
		super();
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	

}
