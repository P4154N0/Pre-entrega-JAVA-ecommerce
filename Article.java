package ecommerceprojecthpg;

//  Author: H.P.G.

//  Clase base Articulo con encapsulamiento.
//  Base class Article with encapsulation.
public class Article {

    //  Atributos privados para aplicar el principio de encapsulamiento.
    //  Private attributes to apply the encapsulation principle.
    private int id;
    private String name;
    private double price;
    private int stock;

    //  Constructor para inicializar el objeto Articulo.
    //  Constructor to initialize the Article object.
    public Article(int id, String name, double price, int stock) {
        this.id = id;   //  'this' refiere al atributo del mismo objeto. 'this' refers to the attribute of the same object.
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    //  Getter para el atributo id (solo lectura)
    //  Getter for the id attribute (read-only)
    public int getId() {
        return id;
    }

    //  Getter para el atributo nombre (solo lectura)
    //  Getter for the name attribute (read-only)
    public String getName() {
        return name;
    }

    //  Getter para el atributo precio (solo lectura)
    //  Getter for the price attribute (read-only)
    public double getPrice() {
        return price;
    }

    //  Getter para el atributo stock (solo lectura)
    //  Getter for the stock attribute (read-only)
    public int getStock() {
        return stock;
    }    

    //  Setter para modificar el id
    //  Setter to modify the id
    //  Una vez acreditado un id a un producto no debe modificarse nunca más.
    //  Once an ID has been credited to a product, it should never be modified again.
    /*
    public void setId(int id) {
        this.id = id;
    }
    */

    //  Setter para modificar el nombre
    //  Setter to modify the name
    public void setName(String name) {
        this.name =name;
    }

    //  Setter para modificar el precio
    //  Setter to modify the price
    public void setPrice(double price) {
        this.price = price;
    }

    //  Setter para modificar el stock
    //  Setter to modify the stock
    public void setPrice(int stock) {
        this.stock = stock;
    }


    //  Método para mostrar la informacion del artículo.
    //  Method to display article information.
    public void show() {
        //  Este método puede ser sobrescrito por subclases (polimorfismo)
        //  This method can be overridden by subclasses (polymorphism)
        System.out.println("ID: " + id + " | Nombre: " + name + " | Precio: $" + price + " | Stock: " + stock);
    }
}