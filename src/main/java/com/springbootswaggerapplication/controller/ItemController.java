package com.springbootswaggerapplication.controller;

import com.springbootswaggerapplication.model.Item;
import com.springbootswaggerapplication.repository.InventoryRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation(value = "/items", tags = "Items Controller")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private InventoryRepository inventoryRepository;


    /**
     * get a List of inventory items list(item no, name, amount, inventory code)
     * @return list(item no, name, amount, inventory code)
     */
    @ApiOperation(value = "Fetch All Items", response = Iterable.class)
    @GetMapping("/items/fetch/all")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    /**
     * Read item details (by item no)
     * @param item_no is an index using to get a specific item
     * @return inventory item by item_no
     */
    @ApiOperation(value = "Read (Get) Item details by Item number", response = Item.class)
    @GetMapping("/items/fetch/{item_no}")
    public Item getItem(@PathVariable long item_no) {
        return itemService.getItem(item_no);
    }

    /**
     * Withdrawal quantity of a specific item from stock
     */
    @ApiOperation(value = "Withdrawal (Update) quantity of a specific Item from stock", response = Item.class)
    @ApiResponse(code = 500, message = "Error!, There is not enough amount to withdrawal")
    @RequestMapping(method = RequestMethod.PUT, value = "/items/withdrawal/{item_no}, {amount}")
    public void withdrawalItem(@PathVariable long item_no, @PathVariable int amount) {
        itemService.withdrawalItem(item_no, amount);
    }

    /**
     * Deposit quantity of a specific item to stock
     */
    @ApiOperation(value = "Deposit (Update) quantity of a specific Item to stock", response = Item.class)
    @RequestMapping(method = RequestMethod.PUT, value = "/items/deposit/{item_no}, {amount}")
    public void depositItem(@PathVariable long item_no, @PathVariable int amount) {
        itemService.depositItem(item_no, amount);
    }

    /**
     * Add item to stock
     */
    @ApiOperation(value = "Add Item to stock", response = Item.class)
    @RequestMapping(method = RequestMethod.POST, value = "/items/add")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
        //inventoryRepository.save(item);
    }

    /**
     * Delete an item from stock
     */
    @ApiOperation(value = "Delete an Item from stock  ", response = Item.class)
    @RequestMapping(method = RequestMethod.DELETE, value = "/items/delete/{item_no}")
    public void deleteItem(@PathVariable long item_no) {
        itemService.deleteItem(item_no);
    }


}