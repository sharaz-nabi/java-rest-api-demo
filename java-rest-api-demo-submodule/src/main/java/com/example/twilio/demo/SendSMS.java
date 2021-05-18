package com.example.twilio.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SendSMS {

	// Find your Account Sid and Auth Token at twilio.com/console
	public static final String ACCOUNT_SID = "AC7f6b1f9e702f8c854bf98b93b9f18359";
	public static final String AUTH_TOKEN = "fe43e65a9452bee5b29978f30d563b11";

	/*
	 * public static void main(String[] args) { Twilio.init(ACCOUNT_SID,
	 * AUTH_TOKEN);
	 * 
	 * Message message = Message.creator(new PhoneNumber("+919891416979"), // to new
	 * PhoneNumber("+14243533164"), // from
	 * "Test message sunny received?").create();
	 * 
	 * System.out.println(message.getSid()); }
	 */
}
