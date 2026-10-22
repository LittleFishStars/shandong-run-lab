package com.zj.adlib;

import android.graphics.Point;
import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class aja extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        Pair<Float, IPoint> pairQ = zwa.q(this, this.mapConfig);
        if (pairQ == null) {
            return;
        }
        iGLMapState.setMapZoomer(((Float) pairQ.first).floatValue());
        Object obj = pairQ.second;
        iGLMapState.setMapGeoCenter(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y);
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
