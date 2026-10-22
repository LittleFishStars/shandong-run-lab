package com.zj.adlib;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class cja extends AbstractCameraUpdateMessage {
    public static void a(IGLMapState iGLMapState, int i, int i2, Point point) {
        iGLMapState.screenToP20Point(i, i2, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float f = this.xPixel;
        float f2 = this.yPixel;
        float f3 = (this.width / 2.0f) + f;
        float f4 = (this.height / 2.0f) + f2;
        Point point = new Point();
        a(iGLMapState, (int) f3, (int) f4, point);
        iGLMapState.setMapGeoCenter(point.x, point.y);
    }
}
