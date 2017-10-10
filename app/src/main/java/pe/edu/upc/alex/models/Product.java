package pe.edu.upc.alex.models;


import android.os.Bundle;

public class Product {
    private String name;
    private String description;
    private int rate;
    private int pictureId;

    public Product() {
    }

    public Product(String name, String description, int rate, int pictureId) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.pictureId = pictureId;
    }


    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public Product setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public int getPictureId() {
        return pictureId;
    }

    public Product setPictureId(int pictureId) {
        this.pictureId = pictureId;
        return this;
    }
    public Bundle toBunlde(){
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        bundle.putString("description",description);
        bundle.putInt("rating",rate);
        bundle.putInt("pictureId",pictureId);
        return bundle;

    }
    public static Product fromBundle(Bundle bundle){
        Product product = new Product();
        return product.setName(bundle.getString("name"))
                .setDescription(bundle.getString("description"))
                .setRate(bundle.getInt("rating"))
                .setPictureId(bundle.getInt("picture_id"));
    }
}
