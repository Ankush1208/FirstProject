package com.notification.service.impl;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notification.exceptions.InvalidNumberException;
import com.notification.model.User;
import com.notification.model.UserSubscription;
import com.notification.repositories.UserSubscriptionRepo;
import com.notification.service.NotificationService;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class NotificaitonServiceImpl implements NotificationService {

	private static Logger log = Logger.getLogger(NotificaitonServiceImpl.class.getName());

	@Autowired
	UserSubscriptionRepo userSubscribeRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public UserSubscription checkSubscribtion(long userId) {
		return userSubscribeRepo.findOne(userId);
	}

	@Override
	public void saveUserSubscription(UserSubscription userSubscription) {

		userSubscribeRepo.save(userSubscription);
	}

	@Override
	public void sendNotification(User list) {
		
		/***
		 * 
		 * create thread pool which contains only 10 threads 
		 * 
		 *
		**/
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());

		String checkSubscriptionType = null;
		UserSubscription u1 = userSubscribeRepo.findOne(list.getUserId());
		/**
		 * 
		 * check user subscription type
		 * 
	    **/
		if (null != u1)
			checkSubscriptionType = u1.getSubscriptionType();
		/**
		 * 
		 * checking if  user is subscribed to silver edition
		 * */
		if (checkSubscriptionType.equalsIgnoreCase("silver")){
			executor.execute(new Runnable() {
				@Override
				public void run() {
					log.info("Sending only email for silver client");
					sendEmail(list);
				}
			});
		}
		/**
		 * 
		 * checking if user is subscribed to gold then send both sms and email
		 * 
		 * ***/
		
		if (checkSubscriptionType.equalsIgnoreCase("gold")) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					log.info("Sending email for gold client");
					sendEmail(list);
				}
			});
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						log.info("Sending sms for gold client");
						sendSMS(list);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		}
		/**
		 * 
		 * checking if user is subscribed to platinum then send all SMS , email and
		 * pushnotification 
		 * 
		 * ***/
		if (checkSubscriptionType.equalsIgnoreCase("platinum")) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					sendEmail(list);
				}
			});
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						log.info("Sending sms in a separate thread");
						sendSMS(list);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}

	
	
	/*
	 * 
	 * user third party jar twilio to send sms
	 * **/

	private void sendSMS(User user) throws Exception {

		try {

			Message.creator(new PhoneNumber(user.getPhoneNumber().toString()), new PhoneNumber("+18056670776"),
					"Message from Spring Boot Application").create();
		} catch (TwilioException e) {
			throw new InvalidNumberException(e.getMessage());
		}

	}
	
	/**
	 * 
	 * Method to send email using javamail spring template
	 * 
	 * **/

	private void sendEmail(User user) {

		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setTo(user.getEmail());

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);
	}

}
