package com.hpglab.data;

import java.util.ArrayList;
import java.util.List;

import com.hpglab.products.Product;

public class Data {
    private List<Product> listOfProducts;

    public Data() {
        this.listOfProducts = new ArrayList<>();
        uploadItems(); // Llama al método para cargar los artículos
    }

    private void uploadItems() {
        // Agregar los artículos al ArrayList con ID, nombre, precio y cantidad (stock)
        listOfProducts.add(new Product(1, "coffee", 10.20, 100));
        listOfProducts.add(new Product(2, "tea", 8.50, 150));
        listOfProducts.add(new Product(3, "sugar", 5.00, 200));
        listOfProducts.add(new Product(4, "milk", 7.00, 80));
        listOfProducts.add(new Product(5, "bread", 12.00, 50));
        listOfProducts.add(new Product(6, "butter", 15.50, 75));
        listOfProducts.add(new Product(7, "eggs", 9.75, 120));
        listOfProducts.add(new Product(8, "salt", 3.00, 300));
        listOfProducts.add(new Product(9, "pepper", 4.25, 180));
        listOfProducts.add(new Product(10, "water", 2.00, 250));
        listOfProducts.add(new Product(11, "chicken", 25.00, 40));
        listOfProducts.add(new Product(12, "beef", 30.00, 30));
        listOfProducts.add(new Product(13, "pork", 20.00, 60));
        listOfProducts.add(new Product(14, "fish", 18.00, 35));
        listOfProducts.add(new Product(15, "rice", 6.00, 200));
        listOfProducts.add(new Product(16, "pasta", 7.50, 180));
        listOfProducts.add(new Product(17, "tomatoes", 4.00, 90));
        listOfProducts.add(new Product(18, "lettuce", 3.50, 60));
        listOfProducts.add(new Product(19, "onions", 2.50, 110));
        listOfProducts.add(new Product(20, "potatoes", 3.00, 130));
        listOfProducts.add(new Product(21, "apples", 2.00, 100));
        listOfProducts.add(new Product(22, "bananas", 1.50, 120));
        listOfProducts.add(new Product(23, "oranges", 2.50, 95));
        listOfProducts.add(new Product(24, "grapes", 5.00, 70));
        listOfProducts.add(new Product(25, "strawberries", 6.00, 85));
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }    
}