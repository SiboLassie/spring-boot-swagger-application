package com.springbootswaggerapplication;

import com.springbootswaggerapplication.model.Item;
import com.springbootswaggerapplication.repository.InventoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootSwaggerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(SpringBootSwaggerApplication.class, args);
		InventoryRepository inventoryRepository =
				configurableApplicationContext.getBean(InventoryRepository.class);

		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item(1,"item1", 10, 1111),
				new Item(2, "item2", 22, 22222),
				new Item(3, "item3", 30, 33333),
				new Item(4, "item4", 44, 4444),
				new Item(5, "item5", 52, 55555)
		));
		for (Item value : items) {
			inventoryRepository.save(value);
		}

	}

}
