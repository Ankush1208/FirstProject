package com.notification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="user_subscription")
@JsonInclude(Include.NON_NULL)
public class UserSubscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long subscriptionId;
	
	@JsonProperty("subscriptionType")
	@Column(name="type")
    private String subscriptionType;
	
	@JsonProperty("amount")
	@Column(name="amount")
	private double amount;
	
	@JsonProperty("isActive")
	@Column(name="is_active")
	private boolean status;
	
	@JsonProperty("userId")
	@Column(name="user_id")
    private long userId;

	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserSubscription [subscriptionId=" + subscriptionId + ", subscriptionType=" + subscriptionType
				+ ", amount=" + amount + ", status=" + status + ", userId=" + userId + "]";
	}
	
	
	

}
