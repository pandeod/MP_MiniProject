package com.example.onkarpande.mp_project.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.onkarpande.mp_project.Adapter.MenuAdapter;
import com.example.onkarpande.mp_project.Entity.ItemMenu;
import com.example.onkarpande.mp_project.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ItemMenu> itemMenus;

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

        EditText searchText=root.findViewById(R.id.search_bar);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });


        return root;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public void filter(String text)
    {
        List<ItemMenu> filterList=new ArrayList<>();
        for(ItemMenu item: itemMenus)
        {
            if((item.getName().toLowerCase().contains(text.toLowerCase())) || (item.getName().toLowerCase().contains(text.toLowerCase())) )
            {
                filterList.add(item);
            }
        }
        adapter=new MenuAdapter(filterList,getContext());
        recyclerView.setAdapter(adapter);
    }
}
