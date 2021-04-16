package com.springbootswaggerapplication.controller;

import com.springbootswaggerapplication.model.Item;
import com.springbootswaggerapplication.repository.InventoryRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private InventoryRepository inventoryRepository;

    /**
     * get a List of inventory items list(item no, name, amount, inventory code)
     * @return list(item no, name, amount, inventory code)
     */
    public List<Item> getAllItems(){
        List<Item> inventory = new ArrayList<>();
        inventoryRepository.findAll().forEach(inventory::add);
        return inventory;
    }

    /**
     * Read item details (by item no)
     * @param item_no is an index using to get a specific item
     * @return inventory item by item_no
     */
    public Item getItem(long item_no) {
        return inventoryRepository.findById(item_no).get();
    }

    /**
     * Add item to stock
     */
    public void addItem(Item item) {
        inventoryRepository.save(item);
    }

    /**
     * Withdrawal quantity of a specific item from stock
     */
    public void withdrawalItem(long item_no, int amount) {
        if (inventoryRepository.findById(item_no).get().getAmount() >= amount) {
            inventoryRepository.findById(item_no).get().setAmount(inventoryRepository.findById(item_no).get().getAmount() - amount);
            inventoryRepository.save(inventoryRepository.findById(item_no).get());
        }else System.console().printf("There is not enough");
    }

    /**
     * Deposit quantity of a specific item to stock
     */
    public void depositItem(long item_no, int amount) {
        inventoryRepository.findById(item_no).get().setAmount(inventoryRepository.findById(item_no).get().getAmount() + amount);
        inventoryRepository.save(inventoryRepository.findById(item_no).get());
    }

    /**
     * Delete an item from stock
     */
    public void deleteItem(long item_no) {
        inventoryRepository.deleteById(item_no);
    }
}
