package com.ckj.projects;

import com.ckj.projects.provider.QueueProducer;
import com.ckj.projects.provider.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:springProvider.xml")
public class ProducerTest {
    @Autowired
    private QueueProducer queueProducer;

    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void testProduce(){
        queueProducer.send("springQueue", "这是一个队列消息!");
//        topicProducer.send("springTopic", "这是一个广播/话题消息!");
    }
}