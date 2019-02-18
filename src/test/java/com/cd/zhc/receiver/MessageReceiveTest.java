package com.cd.zhc.receiver;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cd.zhc.activeMq.receiver.MessageReceiver;


public class MessageReceiveTest {
	public static void main(String args[]) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/Beans.xml");
		MessageReceiver receiver = (MessageReceiver) ctx.getBean("MessageReceiverBean");
		while(true){
			TextMessage message = receiver.receive();
			try {
				System.out.println("消息接受："+message.getText());
//				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
