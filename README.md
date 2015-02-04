A event subcribe module.
It can register the listener with event.
And it can buffer the event . then call the registered listener to do some thing you want . 
It is asynchronous. 
The project named subcribe is the demo telling you how to use this tool.

Use  Demo:


	public static void main(String[] args) {
		//create event
		Event eatEvent = new EatEvent();
		eatEvent.setEventName("eat");

		Event sleepEvent = new SleepEvent();
		sleepEvent.setEventName("sleep");
		
		//create listener
		Listener fl = new FatherListener();
		Listener ml = new MotherListener();
		
		//create center container   and set the thread pool size 4;
		Container container = new Container(4);
		//register the event with listener
		container.register(EatEvent.class, fl);
		container.register(EatEvent.class, ml);

		container.register(SleepEvent.class, fl);
		
		//trigger the event  
		container.post(eatEvent);
		container.post(sleepEvent);
		
		}
