package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@JSONType(orders = {"type", "bbox", "geometries"}, typeName = "GeometryCollection")
public class GeometryCollection extends Geometry {
    private List<Geometry> geometries;

    public GeometryCollection() {
        super("GeometryCollection");
        this.geometries = new ArrayList();
    }

    public List<Geometry> getGeometries() {
        return this.geometries;
    }
}
