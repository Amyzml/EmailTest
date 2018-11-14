package com.zml.test;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 *
 */

	class MyAuth extends Authenticator{
	   
	   String userName = null;
	   String passWord = null;
	
	   public MyAuth(){}
	   public MyAuth (String userName,String passWord) {
		
		 this.userName = userName;
		this.passWord = passWord;
	}
	   
	   @Override
	   protected PasswordAuthentication getPasswordAuthentication() {  
	        return new PasswordAuthentication(userName, passWord);  
	    }  
	   
}

	class SendEmailMagess{
		public boolean sendemail(Entitys entitys){
			
			MyAuth myAuth = null;
			Properties properties = entitys.getProperties();
			//是否认证
			if (entitys.isValidate()) {
				myAuth = new MyAuth(entitys.getUserName(),entitys.getPassWord());	
			}
			
			Session session = Session.getDefaultInstance(properties, myAuth);
			//根据session创建message
			Message emaiMessage = new MimeMessage(session);
			
			try {
				//设置邮件的发送者
				Address from = new InternetAddress(entitys.getFromAddress());
				emaiMessage.setFrom(from);
				//设置邮件的接受者
				Address to = new InternetAddress(entitys.getToAddress());
				emaiMessage.setRecipient(Message.RecipientType.TO,to);
				
				emaiMessage.setSentDate(new Date());
				emaiMessage.setText(entitys.getContent());
				
				Transport.send(emaiMessage);
				
				return true;
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
					
			
			return false;
			
		}
	}

public class App {
    public static void main( String[] args ){
    /*	
    	Entitys entity = new Entitys("smtp.qq.com", "465", "414073453@qq.com", "1136196872@qq.com", 
    			"414073453@qq.com", "nwqxxqtiuuuwcbci","测试", true);
    	
    	SendEmailMagess sendMagess = new SendEmailMagess();
    	if (sendMagess.sendemail(entity)) {
			System.out.println("发送成功");
		}
    	*/
    	
    }
}
