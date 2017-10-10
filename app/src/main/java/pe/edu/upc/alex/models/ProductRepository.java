package pe.edu.upc.alex.models;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.alex.R;

/**
 * Created by Usuario on 1/10/2017.
 */

public class ProductRepository {

    static ProductRepository productRepository;
    List<Product> products;


    public  ProductRepository(){
        this.products = new ArrayList<>();
        products.add(new Product("Alexander","Machazo",4, R.mipmap.ic_launcher));
        products.add(new Product("Giovani","Machazo2",3, R.mipmap.ic_launcher));
        products.add(new Product("Gamarra","Machazo3",2, R.mipmap.ic_launcher));
        products.add(new Product("Tafur","Machazo4",5, R.mipmap.ic_launcher));

    }

    public static ProductRepository getInstance() {
        if (productRepository == null){
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    public List<Product> getProducts(){
        return products;
    }

    public boolean addProduct(String name, String description, int rating, int pictureId){
        if (name.isEmpty()) return false;
        products.add(new Product(name,description,rating,pictureId));
        return true;
    }
}





