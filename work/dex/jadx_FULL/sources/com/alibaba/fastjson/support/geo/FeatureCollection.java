package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "FeatureCollection")
public class FeatureCollection extends Geometry {
    private List<Feature> features;

    public FeatureCollection() {
        super("FeatureCollection");
        this.features = new ArrayList();
    }

    public List<Feature> getFeatures() {
        return this.features;
    }
}
