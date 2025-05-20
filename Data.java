package ecommerceprojecthpg;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Article> listOfArticles;

    public Data() {
        this.listOfArticles = new ArrayList<>();
        uploadItems(); // Llama al método para cargar los artículos
    }

    private void uploadItems() {
        // Agregar los artículos al ArrayList
        listOfArticles.add(new Article(1, "coffee", 10.20));
        listOfArticles.add(new Article(2, "tea", 8.50));
        listOfArticles.add(new Article(3, "sugar", 5.00));
        listOfArticles.add(new Article(4, "milk", 7.00));
        listOfArticles.add(new Article(5, "bread", 12.00));
        listOfArticles.add(new Article(6, "butter", 15.50));
        listOfArticles.add(new Article(7, "eggs", 9.75));
        listOfArticles.add(new Article(8, "salt", 3.00));
        listOfArticles.add(new Article(9, "pepper", 4.25));
        listOfArticles.add(new Article(10, "water", 2.00));
        listOfArticles.add(new Article(11, "chicken", 25.00));
        listOfArticles.add(new Article(12, "beef", 30.00));
        listOfArticles.add(new Article(13, "pork", 20.00));
        listOfArticles.add(new Article(14, "fish", 18.00));
        listOfArticles.add(new Article(15, "rice", 6.00));
        listOfArticles.add(new Article(16, "pasta", 7.50));
        listOfArticles.add(new Article(17, "tomatoes", 4.00));
        listOfArticles.add(new Article(18, "lettuce", 3.50));
        listOfArticles.add(new Article(19, "onions", 2.50));
        listOfArticles.add(new Article(20, "potatoes", 3.00));
        listOfArticles.add(new Article(21, "apples", 2.00));
        listOfArticles.add(new Article(22, "bananas", 1.50));
        listOfArticles.add(new Article(23, "oranges", 2.50));
        listOfArticles.add(new Article(24, "grapes", 5.00));
        listOfArticles.add(new Article(25, "strawberries", 6.00));
    }

    //  Agregar un artículo
    public void addArticulo(Article articulo) {
        listOfArticles.add(articulo);
    }

    //  Mostrar un artículo 'N'
    public void showArticle(int id) {
        for (Article articulo : listOfArticles) {
            if (articulo.getId() == id) {
                articulo.show();
                return; // Importante: Salir del método después de mostrar el artículo.
            }
        }
        System.out.println("Error: No se encontró ningún artículo con el ID " + id);
    }

    //  Obtener Lista De Artículos (se puede utilizar para mostrar).
    public List<Article> getListOfItems() {
        return listOfArticles;
    }

    //  
    public void modifyAnArticle(int id, String newName, Double newPrice) {
        for (Article article : listOfArticles) {
            if (article.getId() == id) {
                if (newName != null) {
                    article.setName(newName);
                }
                if (newPrice != null) {
                    article.setPrice(newPrice);
                }
                return; // Importante: Salir del método después de modificar el artículo
            }
        }
        System.out.println("Error: No se encontró ningún artículo con el ID " + id);
    }

    public void eliminarArticulo(int id) {
        for (int i = 0; i < listOfArticles.size(); i++) {
            if (listOfArticles.get(i).getId() == id) {
                listOfArticles.remove(i);
                System.out.println("Artículo con ID " + id + " eliminado correctamente.");
                return; // Importante: Salir del método después de eliminar el artículo
            }
        }
        System.out.println("Error: No se encontró ningún artículo con el ID " + id);
    }
}