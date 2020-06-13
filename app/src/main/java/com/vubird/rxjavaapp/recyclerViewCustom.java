package com.vubird.rxjavaapp;

import android.content.ReceiverCallNotAllowedException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class recyclerViewCustom extends RecyclerView.Adapter<recyclerViewCustom.MyViewHolder>
{
    //RecyclreViewCustom class will use Cardview Layout and inflate it into acitivty_main RecyclerView view item
    //This is a cutom class to inflate cardview

    private final List<Entry> list = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     //called at the time of creation of View
     //No other code is needed.. 3 line code is sufficeint
    //Attach the cardLayout to the View Holder
     View myview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
     MyViewHolder myViewHolder = new MyViewHolder(myview);
        return myViewHolder;
        //Done
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //this method add the cardview layout  to relactive layout
        //holder contains the view
        //view inside holder is defined in MyViewHolder internal class which is also the child class
        //It is important to have MyViewHolder as internal chid class as it contains the cardview.xml file
        //And we can only access the content of cardview from there
        //It is also importnat to declare and findviewbyId all the required methods just like in any create funcitoin
        //other wise we will not find that elemnt in our MyHolder Class
        Entry entry = list.get(position);
        holder.setTextView(entry.getEntryName());
        holder.setTextViewDate(entry.getEntryDate());
        holder.setTextViewPrice(entry.getEntryPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addStringtoList(Entry value)
    {
        list.add(value);
        notifyItemInserted(list.size()-1);

    }

    //Another class
    public class  MyViewHolder extends  RecyclerView.ViewHolder
    {

        @BindView(R.id.txtview)  TextView textView;
        @BindView(R.id.txtDate) TextView textViewdate;
        @BindView(R.id.txtPrice) TextView textViewprice;

        private final NumberFormat ENTRY_PRICE_FORMAT = new DecimalFormat("$#0.00");

        public void setTextView(String textView) {
            this.textView.setText(textView);
        }

        public void setTextViewPrice(BigDecimal textViewprice ) {
            this.textViewdate.setText(ENTRY_PRICE_FORMAT.format(textViewprice));
        }

        public void setTextViewDate(Date textViewdate) {
            this.textViewprice.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm", textViewdate));
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }
    }
}


