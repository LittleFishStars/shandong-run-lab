package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public interface TileSourceProvider extends TileProvider {
    @JBindingInclude
    void cancel(TileSourceReq tileSourceReq);

    @JBindingInclude
    Tile getTile(TileSourceReq tileSourceReq);
}
