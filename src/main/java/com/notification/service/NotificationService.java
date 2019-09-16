package com.notification.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.notification.model.User;
import com.notification.model.UserSubscription;

@Service
public interface NotificationService {
	
	

	UserSubscription checkSubscribtion(long userId);


	void saveUserSubscription(UserSubscription userSubscription);

	void sendNotification(User list);

}
