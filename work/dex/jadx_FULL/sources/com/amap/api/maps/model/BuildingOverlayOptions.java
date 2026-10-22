package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class BuildingOverlayOptions extends BaseOptions {
    private int[] buildingLatlngsPoints;
    private float zindex;
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private int buildingTopColor = -7829368;
    private int buildingSideColor = -7829368;
    private boolean isVisible = true;
    private List<LatLng> buildingLatlngs = new ArrayList();

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public synchronized int[] getPoints() {
        List<LatLng> list = this.buildingLatlngs;
        if (list == null || list.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[this.buildingLatlngs.size() * 2];
        int i = 0;
        for (int i2 = 0; i2 < this.buildingLatlngs.size(); i2++) {
            LatLng latLng = this.buildingLatlngs.get(i2);
            if (latLng != null) {
                Point pointLatLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i3 = i + 1;
                iArr[i] = pointLatLongToPixels.x;
                i = i3 + 1;
                iArr[i3] = pointLatLongToPixels.y;
            }
        }
        return iArr;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i) {
        this.buildingHeight = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i) {
        this.buildingHeightScale = i;
        return this;
    }

    public synchronized BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[list.size() * 2];
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                LatLng latLng = list.get(i2);
                Point pointLatLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int[] iArr = this.buildingLatlngsPoints;
                int i3 = i + 1;
                iArr[i] = pointLatLongToPixels.x;
                i = i3 + 1;
                iArr[i3] = pointLatLongToPixels.y;
            }
        }
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i) {
        this.buildingSideColor = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i) {
        this.buildingTopColor = i;
        return this;
    }

    public void setVisible(boolean z) {
        this.isVisible = z;
    }

    public void setZIndex(float f) {
        this.zindex = f;
    }
}
