package com.hpglab.products;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    
    public void addProduct(int id, String name, double price, int quantity) {
        products.add(new Product(id, name, price, quantity));
    }

    public void addProducts(List<Product> productsList) {
        products = productsList;
    }

    public List<Product> listProducts() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public boolean productExist(int id) {
        for (Product product : products) {
            if (product.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean updateProduct(int id, String name, double price, int quantity) {
        Product product = findById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            return true;
        } else {
            return false;
        }        
    }

    public boolean deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false; // No se encontró ningún producto con ese ID
    }

}