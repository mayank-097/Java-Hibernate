package com.rapipay.task3.beans;



import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MainClass {
	
	public static void main(String[] args) {
		
        MainClass eventcase = new MainClass();
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session hibernate = factory.openSession();
		
		Feedback f1 =new Feedback(1 , "Good", LocalDate.now());
		hibernate.save(f1);
		Feedback f2 =new Feedback(2 , "Bad", LocalDate.of(2021, 10, 11));
		hibernate.save(f2);
		Feedback f3 =new Feedback(3 , "Can Be Better", LocalDate.of(2020, 12, 29));
		hibernate.save(f3);
		List<Feedback> f  = Arrays.asList(f1,f2,f3);
		
		Event event = new Event("Freshers","Q-Tower,Sector-68,Noida");
		event.setFeedback(f);
		
		eventcase.saveEvent(event,hibernate);
		
        Event e = eventcase.getEventById(1,hibernate);
        System.out.println(e);
        hibernate.close();
	}

	private Event getEventById(int i, Session hibernate) {
		// TODO Auto-generated method stub
		
		Event e = null;
		
		e = (Event)hibernate.get(Event.class, i);
		
		
		List<Feedback> feed = e.getFeedback();
		
		System.out.println(feed.size());
		
		
		return e;
		
	}

	private void saveEvent(Event event, Session hibernate) {
		// TODO Auto-generated method stub
		
		Transaction T = hibernate.beginTransaction();
		
		int savedId = (int)hibernate.save(event);
		System.out.println("event saved!! event name"+event.getEventName()+" event id "+savedId);
		
		T.commit();
	
		
	}

}
