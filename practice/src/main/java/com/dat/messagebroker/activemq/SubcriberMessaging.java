package com.dat.messagebroker.activemq;

import jakarta.jms.Connection;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageConsumer;

import java.util.Scanner;

public class SubcriberMessaging {
    private static String BROKER_URL = "tcp://localhost:61616";
    private static String BROKER_USERNAME = "admin";
    private static String BROKER_PASSWORD = "admin";
    public static ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        connectionFactory.setUserName(BROKER_USERNAME);
        connectionFactory.setPassword(BROKER_PASSWORD);

        return connectionFactory;
    }

    //Tên Topic
    private static String subject = "TESTQUEUE1";
    public static void main(String[] args) throws JMSException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = connectionFactory().createConnection();
        connection.start();
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageConsumer consumer = session.createConsumer(destination);

        try {

            while(true){
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println("Received message: " + message.getText());

            }

        } finally {
            connection.close();
            session.close();
        }
    }
}
