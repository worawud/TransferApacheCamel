package org.apache.camel.example.mybatis;

import java.util.ArrayList;

public class Order {
	 
    private int id;
    private String item;
    private int amount;
    private String description;
    private boolean processed;
    private ArrayList<Order> rsOrder;

 
    public ArrayList<Order> getRsOrder() {
		return rsOrder;
	}

	public void setRsOrder(ArrayList<Order> rsOrder) {
		this.rsOrder = rsOrder;
	}

	public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getItem() {
        return item;
    }
 
    public void setItem(String item) {
        this.item = item;
    }
 
    public int getAmount() {
        return amount;
    }
 
    public void setAmount(int amount) {
        this.amount = amount;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public boolean isProcessed() {
        return processed;
    }
 
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}