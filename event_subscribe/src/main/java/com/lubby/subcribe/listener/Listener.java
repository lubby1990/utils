package com.lubby.subcribe.listener;

import com.lubby.subcribe.event.Event;

/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 下午12:54:28  
 * 
 */
public interface Listener {
	
	public void process(Event event);
}
