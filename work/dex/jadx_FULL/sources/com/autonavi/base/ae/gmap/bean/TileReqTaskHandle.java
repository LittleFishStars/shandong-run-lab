package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class TileReqTaskHandle {

    @JBindingInclude
    long nativeObj;

    @JBindingInclude
    int status;

    @JBindingInclude
    Tile tile;

    @JBindingInclude
    public TileReqTaskHandle() {
    }

    public void finish(Tile tile) {
        this.tile = tile;
    }
}
