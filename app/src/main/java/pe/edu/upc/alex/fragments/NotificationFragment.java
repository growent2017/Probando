package pe.edu.upc.alex.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import pe.edu.upc.alex.R;
import pe.edu.upc.alex.models.ProductRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    EditText nameTextInputEditText;
    EditText descriptionTextInputEditText;
    RatingBar rateRatingBar;
    TextView enterButton;

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        nameTextInputEditText = (EditText) view.findViewById(R.id.nameEditText);
        descriptionTextInputEditText= (EditText) view.findViewById(R.id.descriptionEditText);
        rateRatingBar =(RatingBar) view.findViewById(R.id.rate2RatingBar);
        enterButton = (TextView) view.findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductRepository.getInstance().
                        addProduct(nameTextInputEditText.getText().toString(),
                                descriptionTextInputEditText.getText().toString(),
                                (int)rateRatingBar.getRating(),
                                R.mipmap.ic_launcher);
            clearFields();


            }
        });
        return view;
    }

    private View.OnClickListener onClickListenerForAction(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        };
    }
    private void clearFields(){
        nameTextInputEditText.setText("");
        descriptionTextInputEditText.setText("");
        rateRatingBar.setRating(0);
    }
}
