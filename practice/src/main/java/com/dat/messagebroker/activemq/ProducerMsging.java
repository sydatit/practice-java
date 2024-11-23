package com.dat.messagebroker.activemq;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.ActiveMQProducer;

import java.util.Scanner;

public class ProducerMsging {
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
        MessageProducer producer = session.createProducer(destination);

        try {

            while(true){
                String command = scanner.nextLine();
                if (command.equals("exit")) {
                    break;
                }

                TextMessage message = session.createTextMessage(command);


                // Here we are sending the message!

                producer.send(message);

                System.out.println("‘" + command + "‘ has been send.");

                //Delay 1s

                Thread.sleep(1000);

            }

        } catch (InterruptedException e) {

            System.out.println("Error when during sent message: " + e.getMessage());
        } finally {
            connection.close();
            session.close();
        }
    }

}
