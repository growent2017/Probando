package pe.edu.upc.alex.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import pe.edu.upc.alex.R;
import pe.edu.upc.alex.models.Source;

public class AboutActivity extends AppCompatActivity {

    TextView nameText;
    TextView descriptionText;
    ANImageView imageANIImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.enterButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        try {
            Bundle bundle = getIntent().getExtras();
            Source source = new Source();
            source = source.from(bundle);
            nameText = (TextView) findViewById(R.id.nameTextView);
            nameText.setText(source.getName());
            descriptionText = (TextView) findViewById(R.id.descriptionText);
            descriptionText.setText(source.getDescription());
            imageANIImage = (ANImageView) findViewById(R.id.sourceANImage);

            imageANIImage.setDefaultImageResId(R.mipmap.ic_launcher);
            imageANIImage.setErrorImageResId(R.mipmap.ic_launcher);
            String url = source.getUrlToLogo();
            imageANIImage.setImageUrl(source.getUrlToLogo());

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

