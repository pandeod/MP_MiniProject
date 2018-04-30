package com.example.onkarpande.mp_project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.onkarpande.mp_project.Activity.CartFragment;
import com.example.onkarpande.mp_project.Activity.HomeActivity;
import com.example.onkarpande.mp_project.Entity.ItemMenu;
import com.example.onkarpande.mp_project.R;
import com.example.onkarpande.mp_project.SplashActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<ItemMenu> itemMenus;
    private Context context;
    private int position;
    public final List<ItemMenu> cartItems=new ArrayList<>();


    public MenuAdapter(List<ItemMenu> itemMenus,Context context)
    {
        this.itemMenus=itemMenus;
        this.context=context;
    }
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemMenu itemMenu=itemMenus.get(position);
            holder.mPrice.setText("Price : "+itemMenu.getPrice()+" ₹");
            holder.mName.setText(itemMenu.getName());
            holder.itm = itemMenu;

            Glide.with(this.context)
                    .load(itemMenu.getUrl())
                    .placeholder(R.drawable.ic_person_black_24dp)    // any placeholder to load at start
                    .error(R.drawable.ic_lock_black_24dp)            // any image in case of error
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return itemMenus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mPrice;
        TextView mName;
        ImageView mImage;
        Button cart;
        String mId;
        ItemMenu itm;

        public ViewHolder(final View itemView) {
            super(itemView);
            mPrice=itemView.findViewById(R.id.menu_price);
            mName=itemView.findViewById(R.id.menu_name);
            mImage=itemView.findViewById(R.id.menu_image);
            cart=itemView.findViewById(R.id.add_to_cart);

            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent=new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(mId));
//                    itemView.getContext().startActivity(intent);
                    ((HomeActivity)context).setDefaults(itm);
                }
            });
        }
    }


}
