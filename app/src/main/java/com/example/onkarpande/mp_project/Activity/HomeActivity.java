package com.example.onkarpande.mp_project.Activity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.onkarpande.mp_project.Entity.ItemMenu;
import com.example.onkarpande.mp_project.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public final List<ItemMenu> cartItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = new HistoryFragment();
                                break;
                            case R.id.action_item2:
                                selectedFragment = new SearchFragment();
                                break;
                            case R.id.action_item3:
                                selectedFragment = new CartFragment();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new SearchFragment());
        transaction.commit();

        //Used to select an item programmatically
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
    }

    public List<ItemMenu> getDefaults()
    {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Gson gson = new Gson();

        String json = appSharedPrefs.getString("MyCart","");

        Type type = new TypeToken<List<ItemMenu>>(){}.getType();

        List<ItemMenu> itemMenus= gson.fromJson(json, type);

        return itemMenus;

    }
    public void setDefaults(ItemMenu itemMenu)
    {
        int qt=0;

            for(ItemMenu it:cartItems)
            {
                if(it.getId().equals(itemMenu.getId()))
                {
                    qt=it.getQuantity();
                    cartItems.remove(it);
                    break;
                }
            }
            itemMenu.setQuantity(qt+1);
            cartItems.add(itemMenu);

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();

        Gson gson = new Gson();

        String jsonCart= gson.toJson(cartItems);

        prefsEditor.putString("MyCart", jsonCart);

        prefsEditor.commit();
    }

    public void setCartItemsNull()
    {
        cartItems.clear();
    }
    public void setClear()
    {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = appSharedPrefs.edit();
        editor.remove("MyCart");
        editor.apply();
    }

    public void setWholeArray(List<ItemMenu> itemMenuWhole)
    {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();

        Gson gson = new Gson();

        String jsonCart= gson.toJson(itemMenuWhole);

        prefsEditor.putString("MyCart", jsonCart);

        prefsEditor.apply();
    }

    public void setOrderFragment(List<ItemMenu> itemMenuOrdered)
    {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();

        Gson gson = new Gson();

        String jsonCart= gson.toJson(itemMenuOrdered);

        prefsEditor.putString("MyOrders", jsonCart);

        prefsEditor.apply();
    }

    public List<ItemMenu> getOrderFragment()
    {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Gson gson = new Gson();

        String json = appSharedPrefs.getString("MyOrders","");

        Type type = new TypeToken<List<ItemMenu>>(){}.getType();

        List<ItemMenu> itemOrders= gson.fromJson(json, type);

        return itemOrders;
    }

}
