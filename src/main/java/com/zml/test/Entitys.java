package com.zml.test;
import java.util.Properties;

public class Entitys {
	private String host;
	private String port;
	private String fromAddress;
	private String toAddress;
	private String userName;
	private String passWord;
	private String content;
	private boolean validate;
	
   public Properties getProperties(){
	   Properties properties = new Properties();
	   properties.put("mail.smtp.host", this.host);
	   properties.put("mail.smtp.port", this.port);
	   properties.put("mail.smtp.ssl.enable", "true");
	   properties.put("mail.smtp.auth", validate ? "true" : "false");
	   
	   
	return properties;
	   
   }
  

public String getHost() {
	return host;
}

public void setHost(String host) {
	this.host = host;
}

public String getPort() {
	return port;
}

public void setPort(String port) {
	this.port = port;
}

public String getFromAddress() {
	return fromAddress;
}

public void setFromAddress(String fromAddress) {
	this.fromAddress = fromAddress;
}

public String getToAddress() {
	return toAddress;
}

public void setToAddress(String toAddress) {
	this.toAddress = toAddress;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassWord() {
	return passWord;
}

public void setPassWord(String passWord) {
	this.passWord = passWord;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public boolean isValidate() {
	return validate;
}

public void setValidate(boolean validate) {
	this.validate = validate;
}

public Entitys(String host, String port, String fromAddress, String toAddress,
		String userName, String passWord, String content, boolean validate) {
	super();
	this.host = host;
	this.port = port;
	this.fromAddress = fromAddress;
	this.toAddress = toAddress;
	this.userName = userName;
	this.passWord = passWord;
	this.content = content;
	this.validate = validate;
}


public Entitys() {
	super();
}


@Override
public String toString() {
	return "Entitys [host=" + host + ", port=" + port + ", fromAddress="
			+ fromAddress + ", toAddress=" + toAddress + ", userName="
			+ userName + ", passWord=" + passWord + ", content=" + content
			+ ", validate=" + validate + "]";
}
   
	
 //sys-----------------------
   
   
}
