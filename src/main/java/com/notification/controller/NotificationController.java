package com.notification.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notification.exceptions.UserSubscriptionExceptions;
import com.notification.model.User;
import com.notification.model.UserSubscription;
import com.notification.service.NotificationService;

import org.apache.log4j.Logger;

@RestController
public class NotificationController {

	private static Logger log = Logger.getLogger(NotificationController.class.getName());

	@Autowired
	NotificationService notificationService;

	/**
	 *
	 * Subscription api by which a user can subscribe to any of three mentioned subscription
	 * model
	 * 
	 * @RequestBody accepts all usersubscription information including subscription
	 *              type such as gold,platinum,silver with amount.
	 * 
	 * 
	 **/
	@RequestMapping(value = "/subscription", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<UserSubscription> subscribe(@RequestBody UserSubscription userSubscription) {
		log.info("inside subscription method");
		UserSubscription checkIfsubscribed = notificationService.checkSubscribtion(userSubscription.getUserId());
		Optional<UserSubscription> o1 = Optional.ofNullable(checkIfsubscribed);
		if (o1.isPresent() && checkIfsubscribed.isStatus()) {
			log.error("User is already subscribed");
			throw new UserSubscriptionExceptions("already subscibed");
		} else
			notificationService.saveUserSubscription(userSubscription);
		return new ResponseEntity<UserSubscription>(userSubscription, HttpStatus.OK);
	}

	/**
	 * 
	 * A notification service to send notification to users
	 * 
	 * @RequestBody accept user information like userid, phonenumber,email to send
	 *              emails and sms . This information can also be fetched from
	 *              database user table by sending userId in request param
	 **/
	@RequestMapping(value = "/sendNotifications", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> subscribe(@RequestBody User users) {
		log.info("Inside sendNotificaitons method");
		Optional<User> o1 = Optional.ofNullable(users);
		if (o1.isPresent()) {
			notificationService.sendNotification(o1.get());
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
