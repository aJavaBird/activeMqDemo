package com.cd.zhc.sender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cd.zhc.activeMq.sender.MessageSender;

public class MessageSendTest {
    public static void main(String args[]) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/Beans.xml");
        MessageSender sender = (MessageSender) ctx.getBean("MessageSenderBean");
        for (int i = 0; i < 2; i++) {
            sender.send();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
