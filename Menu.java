package ecommerceprojecthpg;

import java.util.List;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    // Crear una instancia de la clase Data
    static Data data = new Data();

    public void showMenu() {
        Cleanconsoleosdetected.cleanConsole();
        
        String input;        

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("--------------- Menú de Articulos ----------------");
            System.out.println("1 - Crear un artículo nuevo");
            System.out.println("2 - Consultar un artículo");
            System.out.println("3 - Listar artículos");
            System.out.println("4 - Modificar un artículo");
            System.out.println("5 - Borrar un artículo");
            System.out.println("6 - Salir");
            System.out.println("--------------------------------------------------");
            System.out.print("Opción: ");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Cargemos un artículo nuevo. ");
                    createArticle();
                    break;
                case "2":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Su consulta por el artículo: ");
                    showArticle();
                    break;
                case "3":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Lista de artículos. ");
                    System.out.println("--------------------------------------------------");
                    showArticles();
                    break;
                case "4":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Modifique el artículo: ");
                    modifyArticle();
                    break;
                case "5":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Que artículo desea borrar?");
                    deleteArticle();
                    break;
                case "6":
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Programa finalizado.\n");
                    break;
                default:
                    Cleanconsoleosdetected.cleanConsole();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Por favor elija una opción del 1 al 6");
                    break;
            }
            
        } while (!input.equals("6"));
        
    }

    public static void createArticle() {    //  Option1
        boolean exists;
        int maxID = 0;
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: " );
        String name = sc.nextLine();
        System.out.print("Precio: $");
        double price = sc.nextDouble();
        sc.nextLine();

        //-------------------------------------------------------------------------
        //  Verificar si un valor se encuentra contenido.
        List<Article> articulos = data.getListOfItems();
        System.out.println("--------------------------------------------------");
        // Imprimir la lista de artículos
        exists = false;
        for (Article articulo : articulos) {
            if (articulo.getId()==id) {
                exists = true;
            }                
            maxID = articulo.getId();
        }
        if (exists) {
            System.out.println("El Artículo " + id + " ya existe!");
            System.out.println("Pruebe con un ID igual o superio a: " + (maxID+1));
        } else {
            Article newArticle = new Article(id, name, price);
            data.addArticulo(newArticle);
            System.out.println("Artículo agregado con exito!");
            System.out.println("--------------------------------------------------");
        }
        
        
        //-------------------------------------------------------------------------

        
    }

    public static void showArticle() {    //  Option2
        System.out.println("Ingrese el id del articulo que quiere ver,");
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        data.showArticle(id);
        System.out.println("--------------------------------------------------");
    }

    public static void showArticles() {    //  3
        // Obtener la lista de artículos
        List<Article> articulos = data.getListOfItems();
        System.out.println("ID    | Nombre         | Precio");
        System.out.println("--------------------------------------------------");
        // Imprimir la lista de artículos
        for (Article articulo : articulos) {
            articulo.show();
        }
        System.out.println("--------------------------------------------------");
    }

    public static void modifyArticle() {    //  Option4
        System.out.println("Id: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.println("Nombre: " );
        String name = sc.nextLine();
        System.out.println("Precio: $");
        double price = sc.nextDouble();
        data.modifyAnArticle(id, name, price);
        System.out.println("--------------------------------------------------");
    }

    public static void deleteArticle() {    //  Option5
        System.out.println("Ingrese el id del articulo que quiere ver, Id: ");
        int id = sc.nextInt(); sc.nextLine();
        data.eliminarArticulo(id);
        System.out.println("--------------------------------------------------");
    }
}