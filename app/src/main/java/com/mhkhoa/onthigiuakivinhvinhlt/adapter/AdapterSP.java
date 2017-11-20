package com.mhkhoa.onthigiuakivinhvinhlt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhkhoa.onthigiuakivinhvinhlt.R;
import com.mhkhoa.onthigiuakivinhvinhlt.model.LoaiSanPham;
import com.mhkhoa.onthigiuakivinhvinhlt.model.SanPham;

import java.util.ArrayList;

/**
 * Created by thaim on 20/11/2017.
 */

public class AdapterSP extends BaseAdapter
{
    Context context;
    ArrayList<SanPham> sanPhamArrayList;
    LayoutInflater inflater;

    //constructor
    public AdapterSP(Context context , ArrayList<SanPham> sanPhamArrayList)
    {
        this.context = context;
        this.sanPhamArrayList = sanPhamArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return sanPhamArrayList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return sanPhamArrayList.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        //inflater là ép layout lên view . như adapter ép dữ liệu list lên listview
        view = inflater.inflate(R.layout.itemsinhvien,null);
        //anhxa
        TextView txtMaSo = view.findViewById(R.id.textten);
        TextView txtTen = view.findViewById(R.id.textlop);
        ImageView imgAnh = view.findViewById(R.id.imagehinh);
        //settext
        txtMaSo.setText(sanPhamArrayList.get(i).getMaSoSanPham());
        txtTen.setText(sanPhamArrayList.get(i).getTenSanPham());
        imgAnh.setImageResource(sanPhamArrayList.get(i).getHinhSanPham());
        return view;
    }
}
