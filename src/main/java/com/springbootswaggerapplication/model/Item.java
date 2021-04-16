package com.springbootswaggerapplication.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
@ApiModel(description = "Item Model")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Item_number of the Item", name = "item_no", required = true, value = "")
    private long item_no;
    @ApiModelProperty(notes = "Name of the Item", name = "name", required = true, value = "")
    private String name;
    @ApiModelProperty(notes = "Amount of the Item", name = "amount", required = true, value = "")
    private int amount;
    @ApiModelProperty(notes = "Inventory_code of the Item", name = "inventory_code", required = true, value = "")
    private long inventory_code;

    public Item(long item_no, String name, int amount, long inventory_code) {
        this.item_no = item_no;
        this.name = name;
        this.amount = amount;
        this.inventory_code = inventory_code;
    }

    public Item() {
    }

    public long getItem_no() {
        return item_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getInventory_code() {
        return inventory_code;
    }

    public void setInventory_code(long inventory_code) {
        this.inventory_code = inventory_code;
    }

}
