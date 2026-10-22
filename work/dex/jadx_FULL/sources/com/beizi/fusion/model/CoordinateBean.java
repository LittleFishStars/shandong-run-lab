package com.beizi.fusion.model;

import android.text.TextUtils;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CoordinateBean {
    private String bottom;
    private String color;
    private String fontOrCorner;
    private String height;
    private String left;
    private String right;
    private String scale;
    private String top;
    private String width;

    public static CoordinateBean getCoordinate(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(u15.f19942b);
        CoordinateBean coordinateBean = new CoordinateBean();
        coordinateBean.setLeft(strArrSplit[0]);
        coordinateBean.setTop(strArrSplit[1]);
        coordinateBean.setRight(strArrSplit[2]);
        coordinateBean.setBottom(strArrSplit[3]);
        coordinateBean.setWidth(strArrSplit[4]);
        coordinateBean.setHeight(strArrSplit[5]);
        coordinateBean.setScale(strArrSplit[6]);
        coordinateBean.setFontOrCorner(strArrSplit[7]);
        coordinateBean.setColor(strArrSplit[8]);
        return coordinateBean;
    }

    public String getBottom() {
        return this.bottom;
    }

    public String getColor() {
        return this.color;
    }

    public String getFontOrCorner() {
        return this.fontOrCorner;
    }

    public String getHeight() {
        return this.height;
    }

    public String getLeft() {
        return this.left;
    }

    public String getRight() {
        return this.right;
    }

    public String getScale() {
        return this.scale;
    }

    public String getTop() {
        return this.top;
    }

    public String getWidth() {
        return this.width;
    }

    public void setBottom(String str) {
        this.bottom = str;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setFontOrCorner(String str) {
        this.fontOrCorner = str;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setLeft(String str) {
        this.left = str;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setScale(String str) {
        this.scale = str;
    }

    public void setTop(String str) {
        this.top = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }
}
