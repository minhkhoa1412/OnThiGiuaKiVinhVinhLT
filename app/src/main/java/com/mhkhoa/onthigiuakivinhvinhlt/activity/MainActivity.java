package com.mhkhoa.onthigiuakivinhvinhlt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.mhkhoa.onthigiuakivinhvinhlt.R;
import com.mhkhoa.onthigiuakivinhvinhlt.adapter.AdapterLoaiSP;
import com.mhkhoa.onthigiuakivinhvinhlt.model.LoaiSanPham;
import com.mhkhoa.onthigiuakivinhvinhlt.model.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    ListView lstLoaiSanPham;
    AdapterLoaiSP adapter;
    ArrayList<LoaiSanPham> loaiSanPhamArrayList;
    ArrayList<SanPham> sanPhamArrayList;
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
        event();//test github commit
    }

    private void event()
    {
        //them
        btnThem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //có nhan du lieu tra ve -> startactivityforresult .
                startActivityForResult(new Intent(MainActivity.this,ThemLSPActivity.class),123);
            }
        });

        //sua
        lstLoaiSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
//                loaiSanPhamArrayList.remove(i);//ua du , roi chut goi may thang sp nho bang clg. thoi xoa biet r tu lam nha
//                adapter.notifyDataSetChanged();//ez
                //de danh cai long click de goi sp con len

                Intent intent = new Intent(MainActivity.this,SanPhamactivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("listsp",sanPhamArrayList);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        //xoa
        lstLoaiSanPham.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                LoaiSanPham b = loaiSanPhamArrayList.get(i);
                int index = i ;
                Intent intent = new Intent(MainActivity.this , SuaLSPActivity.class);
                Bundle bundle = new Bundle();//tạo bundle để chưa nhiều dữ liệu
                bundle.putSerializable("lspsua",b);//bỏ object b vào bundle
                bundle.putInt("lspsuaindex",index);//bỏ vị trí mình sửa vào bundle
                intent.putExtra("bundle",bundle);//bỏ bundle vào intent
                startActivityForResult(intent,234);//day de 234

                return true;
            }
        });
    }

    private void init()
    {
        loaiSanPhamArrayList = new ArrayList<>();
        sanPhamArrayList = new ArrayList<>();
        //add data
        sanPhamArrayList.add(new SanPham("GA001","Gà móng đỏ",R.drawable.img_test));
        sanPhamArrayList.add(new SanPham("GA002","Gà móng vàng",R.drawable.img_test));
        loaiSanPhamArrayList.add(new LoaiSanPham("GA","Gà",sanPhamArrayList));
        loaiSanPhamArrayList.add(new LoaiSanPham("CHIM","Chim",null));
        //adapter
        adapter = new AdapterLoaiSP(getApplicationContext(),loaiSanPhamArrayList);
        //set adapter
        lstLoaiSanPham.setAdapter(adapter);
    }

    private void anhxa()
    {
        lstLoaiSanPham = findViewById(R.id.listviewloaisanpham);
        btnThem = findViewById(R.id.buttonthemlsp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 123 && data != null )
        {
            LoaiSanPham a = (LoaiSanPham) data.getSerializableExtra("lsp");
            loaiSanPhamArrayList.add(a);
            adapter.notifyDataSetChanged();
        }
        if(requestCode == 234 && data != null)//day nhan ve 234
        {
            Bundle bundle = data.getBundleExtra("bundletrave");
            int i = bundle.getInt("indexlsptrave");
            Log.d("AAA",String.valueOf(i));
            loaiSanPhamArrayList.remove(i);
            LoaiSanPham a = (LoaiSanPham) bundle.getSerializable("lsptrave");
            loaiSanPhamArrayList.add(a);
            adapter.notifyDataSetChanged();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
