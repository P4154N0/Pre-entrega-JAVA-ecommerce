package com.hpglab.orders;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    private int id;
    private List<OrderItem> items;

    public Order() {
        this.id = counter++;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.calculateSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido ID: " + id + "\n");
        for (OrderItem item : items) {
            sb.append("  ").append(item).append("\n");
        }
        sb.append("Total: $").append(calculateTotal());
        return sb.toString();
    }
}