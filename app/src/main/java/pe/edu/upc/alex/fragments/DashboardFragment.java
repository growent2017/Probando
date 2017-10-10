package pe.edu.upc.alex.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.upc.alex.R;
import pe.edu.upc.alex.adapter.AdapterDashboard;
import pe.edu.upc.alex.models.Product;
import pe.edu.upc.alex.models.ProductRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    RecyclerView productsRecyclerView;
    AdapterDashboard productsAdapter;
    RecyclerView.LayoutManager productsLayoutManager;
    List<Product> products;
    ProductRepository repository;
    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard,container,false);


        productsRecyclerView = view.findViewById(R.id.dashboardRecyclerView);
        productsAdapter = new AdapterDashboard(ProductRepository.getInstance().getProducts());
        productsLayoutManager = new LinearLayoutManager(this.getContext());
        productsRecyclerView.setAdapter(productsAdapter);
        productsRecyclerView.setLayoutManager(productsLayoutManager);

        return view;
    }

}
