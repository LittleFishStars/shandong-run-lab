package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@JSONType(seeAlso = {GeometryCollection.class, LineString.class, MultiLineString.class, Point.class, MultiPoint.class, Polygon.class, MultiPolygon.class, Feature.class, FeatureCollection.class}, typeKey = "type")
public abstract class Geometry {
    private double[] bbox;
    private final String type;

    public Geometry(String str) {
        this.type = str;
    }

    public double[] getBbox() {
        return this.bbox;
    }

    public String getType() {
        return this.type;
    }

    public void setBbox(double[] dArr) {
        this.bbox = dArr;
    }
}
