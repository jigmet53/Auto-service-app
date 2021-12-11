package com.example.autoserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    private Button bt_location;

    //a list to store all the products
    List<serviceCenteres> serviceCenteresList;

    //the recyclerview
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // connecting our activity with layout using inflater
        View view = inflater.inflate(R.layout.activity_home,container,false);

        //getting the recyclerView from xml
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        //initializing the productList
        serviceCenteresList = new ArrayList<>();

        serviceCenteresList.add( new serviceCenteres(1,
                "Bhogal Motor Garage",
                "Phagwara, Punjab",
                4.4,
                "Avg - 500 & above",
                R.drawable.service1));

        serviceCenteresList.add( new serviceCenteres(2,
                "Raj Auto Service",
                "Jalandhar, Punjab",
                4.0,
                "Avg - 200 & above",
                R.drawable.service2));

        serviceCenteresList.add( new serviceCenteres(3,
                "Honda Service Station",
                "Jalandhar, Punjab",
                5.0,
                "Avg - 600 & above",
                R.drawable.service4));

        serviceCenteresList.add( new serviceCenteres(4,
                "Ravindra Auto Service",
                "Phagwara, Punjab",
                4.0,
                "Avg - 250 & above",
                R.drawable.service6));

        serviceCenteresList.add( new serviceCenteres(5,
                "Tata Motor Servive Center",
                "Jalandhar, Punjab",
                4.7,
                "Avg - 700 & above",
                R.drawable.service5));

        serviceCenteresList.add( new serviceCenteres(6,
                "Balwinder Motor Garage",
                "Phagwara, Punjab",
                4.3,
                "Avg - 400 & above",
                R.drawable.service3));



        // creating recylerView adapter
        shopAdapter adapter = new shopAdapter(this.getActivity(),serviceCenteresList);

        // setting adapter to recyclerView
        recyclerView.setAdapter(adapter);

        // initialization of views in fragment
        bt_location = view.findViewById(R.id.btLocation);

        bt_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // A fragment can get the activity via the getActivity() function.
                Intent intent = new Intent(getActivity(),myLocation.class);
                startActivity(intent);
            }
        });

        return view;

    }
}
