package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	String getInput() {
		return Utils.getInstance().getInput();
	}

	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter an item name");
		String name = getInput();
		LOGGER.info("Please enter amount of stock");
		Integer stock = Integer.valueOf(getInput());
		LOGGER.info("Please enter price of item");
		Float price = Float.valueOf(getInput());
		Item item = itemService.create(new Item(name, stock, price));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter an item name");
		String name = getInput();
		LOGGER.info("Please enter amount of stock");
		Integer stock = Integer.valueOf(getInput());
		LOGGER.info("Please enter price of item");
		Float price = Float.valueOf(getInput());
		Item item = itemService.update(new Item(id, name, stock, price));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);
		LOGGER.info("Item deleted");
	}
	
}
