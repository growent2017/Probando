package pe.edu.upc.alex.adapter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.alex.R;
import pe.edu.upc.alex.activities.AboutActivity;
import pe.edu.upc.alex.models.Source;

/**
 * Created by Usuario on 2/10/2017.
 */

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.ViewHolder> {
    private List<Source> sources;

    public SourcesAdapter(List<Source> sources) {
        this.sources = sources;
    }

    public SourcesAdapter() {
    }

    @Override
    public SourcesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.card_source,parent,false));

    }

    @Override
    public void onBindViewHolder(SourcesAdapter.ViewHolder holder, int position) {
        final Source source = sources.get(position);
        holder.sourceImage.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.sourceImage.setErrorImageResId(R.mipmap.ic_launcher);
        holder.sourceImage.setImageUrl(source.getUrlToLogo());
        holder.nameText.setText(source.getName());
        holder.descriptionText.setText(source.getDescription());
        holder.aboutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent mIntent = new Intent(view.getContext(), AboutActivity.class);
                    Bundle bundle = source.toBundle();
                    mIntent.putExtras(bundle);
                    view.getContext().startActivity(mIntent);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sources.size();
    }
    public List<Source> getSources(){
        return sources;
    }
    public SourcesAdapter setSources(List<Source> sources){
        this.sources = sources;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ANImageView sourceImage;
        TextView nameText;
        TextView descriptionText;
        TextView aboutText;
        TextView newsText;
        public ViewHolder(View itemView) {
            super(itemView);
            sourceImage = (ANImageView) itemView.findViewById(R.id.sourceANImageView);
            nameText = (TextView) itemView.findViewById(R.id.nameTextView);
            descriptionText = (TextView) itemView.findViewById(R.id.descriptionTextView);
            aboutText = (TextView) itemView.findViewById(R.id.aboutTextView);
            newsText = (TextView) itemView.findViewById(R.id.newsTextView);
        }
    }
}
