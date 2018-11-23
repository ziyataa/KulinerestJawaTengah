package com.ziyata.kulinerestjawatengah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailKulinerActivity extends AppCompatActivity {

    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);
        ButterKnife.bind(this);

        txtTitle.setText(getIntent().getStringExtra("kj"));
        txtDetail.setText(getIntent().getStringExtra("ik"));
        Glide.with(this).load(getIntent().getIntExtra("imgk", 0)).into(imgLogo);
    }
}
