package com.autonavi.amap.mapcore.interfaces;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IMapConfig {
    int getAbroadState();

    int getAnchorX();

    int getAnchorY();

    int getMapHeight();

    int getMapWidth();

    float getMapZoomScale();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    double getSX();

    double getSY();

    float getSZ();

    boolean isAbroadEnable();

    boolean isTerrainEnable();

    void setAbroadEnable(boolean z);

    void setAbroadState(int i);

    void setTerrainEnable(boolean z);
}
