package com.example.onkarpande.mp_project.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onkarpande.mp_project.Entity.ItemMenu;
import com.example.onkarpande.mp_project.R;

import java.util.List;

import static android.view.View.GONE;

public class HistoryFragment extends Fragment {

    public HistoryFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_history, container, false);

        List<ItemMenu> orderItems=((HomeActivity)getActivity()).getOrderFragment();

        if(orderItems!=null)
        {
            LinearLayout lt=root.findViewById(R.id.show_order);
            lt.setVisibility(View.VISIBLE);

            String order="Menu\t\t\t\t\t\t\tPrice\t\t\t\t\t\t\tQuantity\n";
            int grandTotal=0;

            for(ItemMenu itm:orderItems)
            {
                order+=itm.getName()+"\t\t\t\t\t"+itm.getPrice()+" ₹"+"\t\t\t\t\t"+itm.getQuantity()+"\n";
                grandTotal+=Integer.parseInt(itm.getPrice())*itm.getQuantity();
            }

            TextView orderText=root.findViewById(R.id.order_items);
            orderText.setText(order);

            TextView gT=root.findViewById(R.id.grand_total);
            gT.setText("Grand Total : "+grandTotal+" ₹");
        }
        else
        {
            TextView dev =root.findViewById(R.id.dev_credits);
            dev.setVisibility(View.VISIBLE);
            LinearLayout lt=root.findViewById(R.id.show_order);
            lt.setVisibility(GONE);
        }
        return root;
    }

}
