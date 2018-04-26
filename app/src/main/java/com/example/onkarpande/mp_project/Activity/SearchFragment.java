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

        itemMenus.add(new ItemMenu("1","First Item","$123","https://s7.postimg.cc/or72ps3wr/test2.jpg"));
        itemMenus.add(new ItemMenu("1","First Item","$123","https://s7.postimg.cc/or72ps3wr/test2.jpg"));
        itemMenus.add(new ItemMenu("1","First Item","$123","https://s7.postimg.cc/or72ps3wr/test2.jpg"));
        itemMenus.add(new ItemMenu("1","First Item","$123","https://s7.postimg.cc/or72ps3wr/test2.jpg"));
        itemMenus.add(new ItemMenu("1","First Item","$123","https://s7.postimg.cc/or72ps3wr/test2.jpg"));
        itemMenus.add(new ItemMenu("1","First Item","$123","https://s7.postimg.cc/or72ps3wr/test2.jpg"));

        //itemMenus.add(new ItemMenu("1","First Item","$123",""));

        adapter=new MenuAdapter(itemMenus,getContext());
        recyclerView.setAdapter(adapter);

        return root;
    }

}
