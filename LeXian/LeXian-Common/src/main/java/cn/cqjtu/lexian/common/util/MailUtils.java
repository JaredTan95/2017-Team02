package cn.cqjtu.lexian.common.util;

import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {


	public static void sendMail(String to,String code){
		
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory"; 
		Properties props=new Properties();
		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtp.auth", "true");
        
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("1727078617@qq.com", "rjdvodppysludgbd");
			}
		});
		
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("1727078617@qq.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject("验证码");
			
			String mess="<!DOCTYPE html><html lang="+"en"+"><head><meta charset="+"UTF-8"+"><title>验证码</title></head><body><div ><h3>乐鲜小卖铺验证码</h3>"
					+ "<span>尊敬的用户您好，您的验证码为：</span>"+code+".</div></body></html>";
			
			System.out.println(mess);
			message.setContent(mess, "text/html;charset=utf-8");
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("邮件发送出错");
		}
	}

	public static void main(String [] args){
		sendMail("799243917@qq.com","908098");
	}
	

}
