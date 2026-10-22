package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class GL3DModelOptions extends BaseOptions {

    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;

    @JBindingInclude
    private LatLng latLng;

    @JBindingInclude
    private String modelData;

    @JBindingInclude
    private float rotate;

    @JBindingInclude
    private String snippet;

    @JBindingInclude
    private String title;
    private List<Float> vertextList = new ArrayList();
    private List<Float> textrueList = new ArrayList();

    @JBindingInclude
    private boolean isModeltUpdate = false;

    @JBindingInclude
    private int fixedLength = 50;

    @JBindingInclude
    private boolean visibile = true;

    public GL3DModelOptions() {
        this.type = "GL3DModelOptions";
    }

    public GL3DModelOptions angle(float f) {
        this.rotate = f;
        return this;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public GL3DModelOptions position(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int i) {
        this.fixedLength = i;
        return this;
    }

    public GL3DModelOptions setVisible(boolean z) {
        this.visibile = z;
        return this;
    }

    public GL3DModelOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public GL3DModelOptions title(String str) {
        this.title = str;
        return this;
    }

    public GL3DModelOptions vertexData(String str) {
        if (str != null && str.length() > 0) {
            this.modelData = str;
            this.isModeltUpdate = true;
        }
        return this;
    }

    public GL3DModelOptions vertexData(List<Float> list, List<Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        StringBuilder sb = new StringBuilder();
        if (this.vertextList != null) {
            for (int i = 0; i < this.vertextList.size() - 3; i += 3) {
                sb.append("v ");
                sb.append(this.vertextList.get(i));
                sb.append(" ");
                sb.append(this.vertextList.get(i + 1));
                sb.append(" ");
                sb.append(this.vertextList.get(i + 2));
                sb.append("\n");
            }
        }
        if (this.textrueList != null) {
            for (int i2 = 0; i2 < this.textrueList.size() - 2; i2 += 2) {
                sb.append("vt ");
                sb.append(this.textrueList.get(i2));
                sb.append(" ");
                sb.append(1.0f - this.textrueList.get(i2 + 1).floatValue());
                sb.append("\n");
            }
        }
        vertexData(sb.toString());
        return this;
    }
}
