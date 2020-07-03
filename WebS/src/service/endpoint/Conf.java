package service.endpoint;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Conf {
	public void lauch(String[] messageToSend) {
		try {
			Context context = getInitialContext();
			Queue queue01 =(Queue)context.lookup("Queue01");
			JMSContext jmsContext = ((ConnectionFactory) context.lookup("GFConnectionFactory")).createContext();
			JMSProducer jmsProducer = jmsContext.createProducer();
			MapMessage mapMessage = null;
			mapMessage = jmsContext.createMapMessage();
			mapMessage.setString("FilePath", messageToSend[0]);
			mapMessage.setString("Key", messageToSend[1]);
			mapMessage.setString("FileContentDecrypted", messageToSend[2]);
			jmsProducer.send(queue01, mapMessage);
			
					
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public Context getInitialContext() throws JMSException, NamingException{
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.provider.url", "iiop://localhost:3700");
		return new InitialContext(properties);
		
	}
	
	public int launchProcess(String[] messageToSend) {
		String[] contentTab = Parser.ParserProcess(messageToSend[2]);
		System.out.println("NbrDeMots"+ contentTab.length);
		int fiability = 0;
		try {
			fiability = EchoParser.TauxDeConfiance(contentTab);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fiability;
	}
}
