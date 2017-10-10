package pe.edu.upc.alex.adapter;

import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.alex.R;
import pe.edu.upc.alex.activities.ProductDetailActivity;
import pe.edu.upc.alex.models.Product;

/**
 * Created by Usuario on 1/10/2017.
 */

public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.ViewHolder>{

    private List<Product> products;

    public AdapterDashboard(List<Product> products) {
        this.setProducts(products);
    }

    public AdapterDashboard() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_products,parent,false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.nameTextView.setText(product.getName());
        holder.descriptionTextView.setText(product.getDescription());
        holder.rateRatingBar.setRating(product.getRate());
        holder.pictureImageView.setImageResource(product.getPictureId());
        holder.moreinfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ProductDetailActivity.class);
                intent.putExtras(product.toBunlde());
                view.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }

    public AdapterDashboard setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView  nameTextView;
        TextView  descriptionTextView;
        ImageView pictureImageView;
        RatingBar rateRatingBar;
        TextView moreinfoTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            pictureImageView =(ImageView) itemView.findViewById(R.id.pictureImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            rateRatingBar = (RatingBar) itemView.findViewById(R.id.rateRatingBar);
             moreinfoTextView = (TextView) itemView.findViewById(R.id.moreinfoTextView);
        }
    }
}
