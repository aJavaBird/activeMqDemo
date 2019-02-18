package com.cd.zhc.activeMq.receiver;

import javax.jms.Destination;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver {
	
	private JmsTemplate template;
	private Destination destination;
	
	public MessageReceiver(JmsTemplate template,Destination destination){
		this.template =template;
		this.destination = destination;
//		while(true){
//			receive();
//		}
	}
	
	public TextMessage receive(){
		return (TextMessage) template.receive(destination);
	}
}
