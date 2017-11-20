package com.mhkhoa.onthigiuakivinhvinhlt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mhkhoa.onthigiuakivinhvinhlt.R;
import com.mhkhoa.onthigiuakivinhvinhlt.model.LoaiSanPham;

public class SuaLSPActivity extends AppCompatActivity
{
    EditText edtMaSo , edtTen;
    Button btnThem;
    int INDEX = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_lsp);

        anhxa();
        control();
        nhandata();

    }

    private void nhandata()
    {
        Intent intent = getIntent();
        if(intent != null)
        {
            Bundle bundle = intent.getBundleExtra("bundle");
            LoaiSanPham a = (LoaiSanPham) bundle.getSerializable("lspsua");
            INDEX = bundle.getInt("lspsuaindex");
            edtMaSo.setText(a.getMaSoLoaiSanPham());
            edtTen.setText(a.getTenLoaiSanPham());
        }
    }

    private void control()
    {
        btnThem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoaiSanPham a = new LoaiSanPham();
                a.setMaSoLoaiSanPham(edtMaSo.getText().toString());
                a.setTenLoaiSanPham(edtTen.getText().toString());
                a.setSanPhamArrayList(null);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("lsptrave",a);
                bundle.putInt("indexlsptrave",INDEX);
                intent.putExtra("bundletrave",bundle);
                setResult(234,intent);
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
