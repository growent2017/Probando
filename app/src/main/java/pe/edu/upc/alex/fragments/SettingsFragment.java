package pe.edu.upc.alex.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pe.edu.upc.alex.R;
import pe.edu.upc.alex.models.PreferencesRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    EditText maxResultsEditText;
    Button updateSettingsButton;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        maxResultsEditText = (EditText) view.findViewById(R.id.maxcantEditText);
        updateSettingsButton = (Button) view.findViewById(R.id.updateSettingsButton);
        final PreferencesRepository preferences = new PreferencesRepository(this.getContext());
        maxResultsEditText.setText(preferences.getMaxResultsAsString());
        updateSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentMaxResults = preferences.getMaxResults();
                int updatedMaxResults = Integer.parseInt(maxResultsEditText.getText().toString());
                int maxResults = updatedMaxResults < 1 ? currentMaxResults : updatedMaxResults;
                preferences.setMaxResults(maxResults);
            }
        });
        return view;
    }

}
