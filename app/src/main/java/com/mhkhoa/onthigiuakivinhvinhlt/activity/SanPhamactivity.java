package com.mhkhoa.onthigiuakivinhvinhlt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.mhkhoa.onthigiuakivinhvinhlt.R;
import com.mhkhoa.onthigiuakivinhvinhlt.adapter.AdapterSP;
import com.mhkhoa.onthigiuakivinhvinhlt.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamactivity extends AppCompatActivity
{
    ArrayList<SanPham> sanPhamArrayList;
    AdapterSP adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_phamactivity);

        sanPhamArrayList = new ArrayList<>();
        ListView lstSanPham = findViewById(R.id.listviewsanpham);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        sanPhamArrayList = (ArrayList<SanPham>) bundle.getSerializable("listsp");

        adapter = new AdapterSP(getApplicationContext(),sanPhamArrayList);
        lstSanPham.setAdapter(adapter);// quen , chim ko co data

    }
}
