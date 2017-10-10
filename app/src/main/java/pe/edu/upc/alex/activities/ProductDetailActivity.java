package pe.edu.upc.alex.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import pe.edu.upc.alex.R;
import pe.edu.upc.alex.models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView picturedetailImageView;
    TextView nameTextView;
    TextView descriptionTextView;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);


        picturedetailImageView = (ImageView) findViewById(R.id.picturedetailImageView);
        nameTextView = (TextView) findViewById(R.id.namedetailTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptiondetailTextView);
        ratingBar = (RatingBar) findViewById(R.id.ratedetailRatingBar);

        Product product = Product.fromBundle(getIntent().getExtras());

        nameTextView.setText(product.getName());
        descriptionTextView.setText(product.getDescription());
        picturedetailImageView.setImageResource(product.getPictureId());
        ratingBar.setRating(product.getRate());
    }
}
