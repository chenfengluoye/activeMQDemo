package com.ckj.projects.provider;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

    @Resource(name = "jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    public void send(String topicName,final String msg){
        jmsTemplate.send(topicName, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}