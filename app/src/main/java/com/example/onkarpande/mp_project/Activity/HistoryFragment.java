package com.example.onkarpande.mp_project.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ItemMenu> orderItems;

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

        recyclerView=root.findViewById(R.id.order_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        orderItems=((HomeActivity)getActivity()).getOrderFragment();

        setRecyclerAdapter(orderItems);

        if(orderItems!=null)
        {
            LinearLayout lt=root.findViewById(R.id.show_order);
            lt.setVisibility(View.VISIBLE);

            int grandTotal=0;

            for(ItemMenu itm:orderItems)
            {
                grandTotal+=Integer.parseInt(itm.getPrice())*itm.getQuantity();
            }

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

    public void setRecyclerAdapter(List<ItemMenu> orderIms)
    {
        if(orderIms==null)
        {
            recyclerView.setVisibility(View.GONE);
        }
        else
        {
            adapter=new OrderAdapter(orderIms,getContext());
            recyclerView.setAdapter(adapter);
        }
    }

    class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

        private List<ItemMenu> orderMenus;
        private Context context;

        public OrderAdapter(List<ItemMenu> orderMenus,Context context)
        {
            this.orderMenus=orderMenus;
            this.context=context;
        }

        @Override
        public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(OrderAdapter.ViewHolder holder, int position) {
            ItemMenu orderMenu=orderMenus.get(position);
            holder.mName.setText(orderMenu.getName());
            holder.mPrice.setText(orderMenu.getPrice()+" ₹");
            holder.mQuantity.setText(""+orderMenu.getQuantity());
        }

        @Override
        public int getItemCount() {
                return orderMenus.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            TextView mPrice;
            TextView mName;
            TextView mQuantity;

            ViewHolder(final View itemView) {
                super(itemView);
                mName=itemView.findViewById(R.id.menu_name);
                mPrice=itemView.findViewById(R.id.menu_price);
                mQuantity=itemView.findViewById(R.id.menu_qt);
            }
        }
    }

}
