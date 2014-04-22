/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.print;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 申
 */
public class J2EEProPrintClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
               
        System.out.println("Hello JMS Receiver");
        Context ctx = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/Factory");
        Destination destination = (Destination) ctx.lookup("jms/Queue");
        Connection connection = null;

        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
             
                @Override
                public void onMessage(Message message) {
                    TextMessage receivedMessage = (TextMessage) message;
                    try {
                        System.out.println(receivedMessage.getText());
                    } catch (JMSException ex) {
                        Logger.getLogger(J2EEProPrintClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            connection.start();  
            System.out.println("After start");
            
        } catch (JMSException e) {
            e.printStackTrace();
        } 
    }
}
