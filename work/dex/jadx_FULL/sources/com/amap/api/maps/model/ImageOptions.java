package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class ImageOptions {

    @JBindingInclude
    public int color;

    @JBindingInclude
    public String content;

    @JBindingInclude
    public int fontSize;

    @JBindingInclude
    public float radius;

    @JBindingInclude
    public double[] rgba;

    @JBindingInclude
    public int type;

    public enum ShapeType {
        DEFAULT(0),
        CIRCLE(1),
        TEXT(2);

        private int index;

        ShapeType(int i) {
            this.index = i;
        }

        public final int value() {
            return this.index;
        }
    }

    @JBindingInclude
    public ImageOptions() {
    }
}
