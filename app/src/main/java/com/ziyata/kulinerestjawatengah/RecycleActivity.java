package com.ziyata.kulinerestjawatengah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {
    @BindView(R.id.myRecycleView)
    RecyclerView myRecyclerView;

    String[] kulinerJawa, isiKuliner;
    int[] imgKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        kulinerJawa = getResources().getStringArray(R.array.kuliner_jawa);
        isiKuliner = getResources().getStringArray(R.array.isi_kuliner);
        imgKuliner = new int[]{R.drawable.gudeg,R.drawable.lontongcapgomeh,R.drawable.kupat_glabed,R.drawable.garangasem};

        Adapter adapter = new Adapter(RecycleActivity.this,kulinerJawa,isiKuliner,imgKuliner);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter(adapter);
    }
}
