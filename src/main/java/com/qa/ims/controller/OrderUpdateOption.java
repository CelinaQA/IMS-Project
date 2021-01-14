package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum OrderUpdateOption {
	
	A("Add new item to order"), B("Delete item from order"),
	C("Update quantity of item in order"), STOP("To close the application");
	
	public static final Logger LOGGER = LogManager.getLogger();

	private String description;
	
	OrderUpdateOption(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	public static void printOrderUpdateOptions() {
		for (OrderUpdateOption option : OrderUpdateOption.values()) {
			LOGGER.info(option.getDescription());
		}
	}
	
	public static OrderUpdateOption getOrderUpdateOptions() {
		OrderUpdateOption option = null;
		do {
			try {
				option = OrderUpdateOption.valueOf(Utils.getInstance().getInput().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (option == null);
		return option;
	}


	

}
