package com.notification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.notification.model.UserSubscription;

@Repository
public interface UserSubscriptionRepo  extends JpaRepository<UserSubscription,Long>{
	
	
	

}
