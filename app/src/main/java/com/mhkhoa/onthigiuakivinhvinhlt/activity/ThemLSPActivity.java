package com.mhkhoa.onthigiuakivinhvinhlt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mhkhoa.onthigiuakivinhvinhlt.R;
import com.mhkhoa.onthigiuakivinhvinhlt.model.LoaiSanPham;

public class ThemLSPActivity extends AppCompatActivity
{
    EditText edtMaSo , edtTen;
    Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lsp);
        anhxa();
        control();
    }


    private void control()
    {
        //them
        btnThem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoaiSanPham a= new LoaiSanPham();
                a.setMaSoLoaiSanPham(edtMaSo.getText().toString());
                a.setTenLoaiSanPham(edtTen.getText().toString());
                a.setSanPhamArrayList(null);
                Intent intent = new Intent();
                intent.putExtra("lsp",a);//seriz
                setResult(123,intent);
                finish();
            }
        });

    }

    private void anhxa()
    {
        edtMaSo = findViewById(R.id.edittextmasolsp);
        edtTen = findViewById(R.id.edittexttenlsp);
        btnThem = findViewById(R.id.buttonthemlsp);
    }

}
