package com.lubby.test.utils.subscribe.asynchronous;
/**  
 * 
 * @author liubin   
 * @version 创建时间：2015年2月4日 上午11:10:37  
 * 
 */
public class Test {
	
	public static void main(String[] args){
		Container con = new Container();
		EventListenerOne elOne = new EventListenerOne();
		EventListenerTwo elTwo = new EventListenerTwo();
		con.add(elOne);
		con.add(elTwo);
		con.access(new Event("ClickEvent"));
		System.out.println("------------");
	}

}
