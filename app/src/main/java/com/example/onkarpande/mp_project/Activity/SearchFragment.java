package com.example.onkarpande.mp_project.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.onkarpande.mp_project.Adapter.MenuAdapter;
import com.example.onkarpande.mp_project.Entity.ItemMenu;
import com.example.onkarpande.mp_project.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ItemMenu> itemMenus;
    StringBuilder sb = new StringBuilder();

    public SearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView=root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        itemMenus=new ArrayList<>();
        adapter=new MenuAdapter(itemMenus,getContext());



        itemMenus.add(new ItemMenu("1","First Item","$1","https://vedh.000webhostapp.com/images/dow.png"));
        itemMenus.add(new ItemMenu("2","Second Item","$2","https://vedh.000webhostapp.com/images/dow.png"));
        itemMenus.add(new ItemMenu("3","Third Item","$3","https://vedh.000webhostapp.com/images/dow.png"));
        itemMenus.add(new ItemMenu("4","Four Item","$4","https://vedh.000webhostapp.com/images/dow.png"));
        itemMenus.add(new ItemMenu("5","Five Item","$5","https://vedh.000webhostapp.com/images/dow.png"));
        itemMenus.add(new ItemMenu("6","Six Item","$6","https://vedh.000webhostapp.com/images/dow.png"));

       // itemMenus.add(new ItemMenu("1","First Item","$123",""));

        recyclerView.setAdapter(adapter);
        return root;
    }

}
