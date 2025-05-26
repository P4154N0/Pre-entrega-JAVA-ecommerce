package com.hpglab.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hpglab.data.Data;
import com.hpglab.exeptions.InsufficientStockException;
import com.hpglab.orders.Order;
import com.hpglab.orders.OrderItem;
import com.hpglab.products.Product;
import com.hpglab.products.ProductService;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    // Crear una instancia de la clase Data
    static Data data = new Data();

    static ProductService productService = new ProductService();

    private static List<Order> orders = new ArrayList<>();
    
    public void showMenu() {
        Cleanconsoleosdetected.cleanConsole();
        
        String input;        

        do {
            System.out.println("==================================================");
            System.out.println("           SISTEMA DE GESTIÓN - HPGLAB            ");
            System.out.println("==================================================");                                      
            System.out.println("1) Agregar Producto");
            System.out.println("2) Consultar Producto");
            System.out.println("3) Listar Artículos");
            System.out.println("4) Actualizar Producto");
            System.out.println("5) Eliminar Producto");
            System.out.println("6) Crear un Pedido");
            System.out.println("7) Listar Pedidos");
            System.out.println("8) Salir");
            System.out.println("--------------------------------------------------");
            System.out.print("Elija una opción: ");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("1) Agregar Producto");
                    System.out.println("--------------------------------------------------");
                    createProduct();
                    break;
                case "2":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("2) Consultar Producto");
                    System.out.println("--------------------------------------------------");
                    showProduct();
                    break;
                case "3":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("3) Listar Artículos");
                    System.out.println("--------------------------------------------------");
                    showProducts();
                    break;
                case "4":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("4) Actualizar Producto");
                    System.out.println("--------------------------------------------------");
                    modifyProduct();
                    break;
                case "5":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("5) Eliminar Producto");
                    System.out.println("--------------------------------------------------");
                    deleteProduct();
                    break;
                case "6":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("6) Crear un Pedido");
                    System.out.println("--------------------------------------------------");
                    createOrder(sc);
                    break;
                case "7":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("7) Listar Pedidos");
                    System.out.println("--------------------------------------------------");
                    listOrders();
                    break;
                case "8":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Programa finalizado.\n");
                    System.out.println("--------------------------------------------------");
                    break;
                default:
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Por favor elija una opción del 1 al 8");
                    System.out.println("--------------------------------------------------");
                    break;
            }
        } while (!input.equals("8"));
    }

    public static void createProduct() {    //  Option1
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
                
        productService.addProducts(data.getListOfProducts()); // los pasa correctamente
        //  Verificar si un producto existe / Si ya se encuentra contenido en los productos ya cargados.
        boolean exists = productService.productExist(id);
                
        if (exists) {
            System.out.println("El Producto " + id + " ya existe!");
        } else {
            System.out.print("Nombre: " );
            String name = sc.nextLine();
            System.out.print("Precio: $");
            double price = sc.nextDouble(); sc.nextLine();
            System.out.print("Stock: ");
            int quantity = sc.nextInt(); sc.nextLine();
            productService.addProduct(id, name, price, quantity);
            System.out.println("El Producto fue agregado con exito!");
            System.out.println("--------------------------------------------------");
        }
    }

    public static void showProduct() {    //  Option2
        System.out.println("Ingrese el id del producto por el que quiere consultar!");
        System.out.println("--------------------------------------------------");
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.println("--------------------------------------------------");
        productService.addProducts(data.getListOfProducts()); // los pasa correctamente
        Product product = productService.findById(id);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("El Producto: " + id + ", no se encuentra contenido!");
        }
        System.out.println("--------------------------------------------------");
    }

    public static void showProducts() {    //  3
        System.out.println("ID    | Nombre         | Precio        | Stock");
        System.out.println("--------------------------------------------------");
        // Obtener la lista de artículos
        productService.addProducts(data.getListOfProducts()); // los pasa correctamente

        for (Product product : productService.listProducts()) {
            System.out.println(product);
        }
        System.out.println("--------------------------------------------------");
    }

    public static void modifyProduct() {    //  Option4
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        
        productService.addProducts(data.getListOfProducts());
        boolean exists = productService.productExist(id);
                
        if (exists) {
            System.out.println("--------------------------------------------------");
            System.out.print("Nombre: " );
            String name = sc.nextLine();
            System.out.print("Precio: $");
            double price = sc.nextDouble(); sc.nextLine();
            System.out.print("Stock: ");
            int stock = sc.nextInt(); sc.nextLine();
            productService.updateProduct(id, name, price, stock);
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("El Producto: " + id + ", no se pudo modificar porque no se encuentra contenido!");
            System.out.println("--------------------------------------------------");
        }        
    }

    public static void deleteProduct() {    //  Option5
        System.out.println("Ingrese el id del product que quiere eliminar, ID: ");
        System.out.println("--------------------------------------------------");
        int id = sc.nextInt(); sc.nextLine();

        productService.addProducts(data.getListOfProducts());
        boolean exists = productService.productExist(id);

        if (exists) {
            productService.deleteProduct(id);
            System.out.println("El producto ID: " + id + ", fue eliminado exitosamente!");
        } else {
            System.out.println("El producto ID: " + id + ", NO existe!");
        }
        System.out.println("--------------------------------------------------");
    }

    private static void createOrder(Scanner scanner) {
        Order order = new Order();
        String continuar;

        do {
            System.out.print("ID del producto: ");
            int id = Integer.parseInt(scanner.nextLine());

            Product product = productService.findById(id);
            if (product == null) {
                System.out.println("Producto no encontrado.");
            } else {
                System.out.print("Cantidad: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                try {
                    if (product.getQuantity() < quantity) {
                        throw new InsufficientStockException("Stock insuficiente para el producto: " + product.getName());
                    }

                    product.setQuantity(product.getQuantity() - quantity);
                    order.addItem(new OrderItem(product, quantity));
                    System.out.println("Producto agregado al pedido.");
                } catch (InsufficientStockException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Validación de entrada para continuar
            do {
                System.out.print("¿Desea agregar otro producto al pedido? (s/n): ");
                continuar = scanner.nextLine().trim().toLowerCase();
            } while (!continuar.equals("s") && !continuar.equals("n"));

        } while (continuar.equals("s"));

        // Mostrar resumen antes de finalizar
        System.out.println("\nResumen del pedido:");
        System.out.println(order);

        orders.add(order);
        System.out.println("Pedido creado exitosamente.");
    }

    private static void listOrders() {
        orders.forEach(System.out::println);
    }
}