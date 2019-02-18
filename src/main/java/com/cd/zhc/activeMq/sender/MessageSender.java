package com.cd.zhc.activeMq.sender;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender extends Thread  implements MessageCreator {
	
	private int num = 1;
	private JmsTemplate template;
	private Destination destination;

	public Message createMessage(Session session) throws JMSException {
		System.out.println("====这是第"+num+"段消息！====");
		return session.createTextMessage("this is "+(num++)+" message!");
	}
	
	public MessageSender(JmsTemplate template,Destination destination){
		this.template =template;
		this.destination = destination;
	}
	
	public void send(){
		template.send(destination,this);
	}

}
