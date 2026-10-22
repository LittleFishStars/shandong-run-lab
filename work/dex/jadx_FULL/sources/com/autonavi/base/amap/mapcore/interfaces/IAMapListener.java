package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i, GLMapState gLMapState);

    void afterDrawLabel(int i, GLMapState gLMapState);

    void afterRendererOver(int i, GLMapState gLMapState);

    void beforeDrawLabel(int i, GLMapState gLMapState);

    void onMapBlankClick(double d, double d2);

    void onMapPOIClick(MapPoi mapPoi);
}
