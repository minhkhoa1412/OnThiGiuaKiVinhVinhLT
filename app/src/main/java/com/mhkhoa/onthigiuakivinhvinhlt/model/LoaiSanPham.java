package com.mhkhoa.onthigiuakivinhvinhlt.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by thaim on 20/11/2017.
 */

public class LoaiSanPham implements Serializable
{
    private String maSoLoaiSanPham;
    private String tenLoaiSanPham;
    private ArrayList<SanPham> sanPhamArrayList;

    public LoaiSanPham()
    {
    }

    public LoaiSanPham(String maSoLoaiSanPham, String tenLoaiSanPham, ArrayList<SanPham> sanPhamArrayList)
    {
        this.maSoLoaiSanPham = maSoLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.sanPhamArrayList = sanPhamArrayList;
    }

    public String getMaSoLoaiSanPham()
    {
        return maSoLoaiSanPham;
    }

    public void setMaSoLoaiSanPham(String maSoLoaiSanPham)
    {
        this.maSoLoaiSanPham = maSoLoaiSanPham;
    }

    public String getTenLoaiSanPham()
    {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham)
    {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public ArrayList<SanPham> getSanPhamArrayList()
    {
        return sanPhamArrayList;
    }

    public void setSanPhamArrayList(ArrayList<SanPham> sanPhamArrayList)
    {
        this.sanPhamArrayList = sanPhamArrayList;
    }
}
