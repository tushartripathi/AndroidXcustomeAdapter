package com.vubird.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.textboxFirst) TextView txtHi;

    @BindView(R.id.myrecyclerView)
    androidx.recyclerview.widget.RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private recyclerViewCustom recyclerViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustomAdapter = new recyclerViewCustom();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewCustomAdapter);

        final Entry entr1 = new Entry("Ross", BigDecimal.valueOf(1500.00),new Date());
        Entry entr2 = new Entry("Joye", BigDecimal.valueOf(2500.00),new Date());
        Entry entr3 = new Entry("Chandler", BigDecimal.valueOf(500.00),new Date());
        Entry entr4 = new Entry("Rachel", BigDecimal.valueOf(1900.00),new Date());
        Entry entr5 = new Entry("Monica", BigDecimal.valueOf(1200.00),new Date());
        Entry entr6 = new Entry("Pheobie", BigDecimal.valueOf(2200.00),new Date());
//
//        Observable.just("Joye","Chandler","rachel","Monica","Pheobe").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception
//            {
//                    recyclerViewCustomAdapter.addStringtoList(s);
//            }
//        });

        Observable.just(entr1,entr2,entr3,entr4,entr5,entr6).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Exception {
                recyclerViewCustomAdapter.addStringtoList(entry);
            }
        });

        Observable.just("Hello Frnds. How are you?").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                txtHi.setText(s);
            }
        });

    }
}
