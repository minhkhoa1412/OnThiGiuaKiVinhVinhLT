package com.mhkhoa.onthigiuakivinhvinhlt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mhkhoa.onthigiuakivinhvinhlt.R;
import com.mhkhoa.onthigiuakivinhvinhlt.model.LoaiSanPham;

import java.util.ArrayList;

/**
 * Created by thaim on 20/11/2017.
 */

public class AdapterLoaiSP extends BaseAdapter
{
    Context context;
    ArrayList<LoaiSanPham> loaiSanPhamArrayList;
    LayoutInflater inflater;

    //constructor
    public AdapterLoaiSP(Context context ,  ArrayList<LoaiSanPham> loaiSanPhamArrayList)
    {
        this.context = context;
        this.loaiSanPhamArrayList = loaiSanPhamArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return loaiSanPhamArrayList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return loaiSanPhamArrayList.get(i);
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
        view = inflater.inflate(R.layout.item_loai_san_pham,null);
        //anhxa
        TextView txtMaSo = view.findViewById(R.id.textviewmasolsp);
        TextView txtTen = view.findViewById(R.id.textviewtenlsp);
        //settext
        txtMaSo.setText(loaiSanPhamArrayList.get(i).getMaSoLoaiSanPham());
        txtTen.setText(loaiSanPhamArrayList.get(i).getTenLoaiSanPham());
        return view;
    }
}
