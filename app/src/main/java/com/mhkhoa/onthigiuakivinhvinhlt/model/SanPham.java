package com.mhkhoa.onthigiuakivinhvinhlt.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by thaim on 20/11/2017.
 */

public class SanPham implements Serializable
{
    private String maSoSanPham;
    private String tenSanPham;
    private int hinhSanPham;

    public SanPham()
    {
    }

    public SanPham(String maSoSanPham, String tenSanPham, int hinhSanPham)
    {
        this.maSoSanPham = maSoSanPham;
        this.tenSanPham = tenSanPham;
        this.hinhSanPham = hinhSanPham;
    }

    public String getMaSoSanPham()
    {
        return maSoSanPham;
    }

    public void setMaSoSanPham(String maSoSanPham)
    {
        this.maSoSanPham = maSoSanPham;
    }

    public String getTenSanPham()
    {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham)
    {
        this.tenSanPham = tenSanPham;
    }

    public int getHinhSanPham()
    {
        return hinhSanPham;
    }

    public void setHinhSanPham(int hinhSanPham)
    {
        this.hinhSanPham = hinhSanPham;
    }
}
