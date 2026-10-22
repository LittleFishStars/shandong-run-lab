package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;
    public int pivotX;
    public int pivotY;

    public RotateGestureMapMessage(int i, float f, int i2, int i3) {
        super(i);
        this.pivotX = 0;
        this.pivotY = 0;
        this.angleDelta = 0.0f;
        setParams(i, f, i2, i3);
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static RotateGestureMapMessage obtain(int i, float f, int i2, int i3) {
        RotateGestureMapMessage rotateGestureMapMessageAcquire = M_POOL.acquire();
        if (rotateGestureMapMessageAcquire == null) {
            return new RotateGestureMapMessage(i, f, i2, i3);
        }
        rotateGestureMapMessageAcquire.reset();
        rotateGestureMapMessageAcquire.setParams(i, f, i2, i3);
        return rotateGestureMapMessageAcquire;
    }

    private void setParams(int i, float f, int i2, int i3) {
        setState(i);
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 2;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint iPointObtain;
        IPoint iPointObtain2;
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        int i = this.pivotX;
        int i2 = this.pivotY;
        if (this.isUseAnchor) {
            i = this.anchorX;
            i2 = this.anchorY;
        }
        if (i > 0 || i2 > 0) {
            iPointObtain = IPoint.obtain();
            iPointObtain2 = IPoint.obtain();
            win2geo(gLMapState, i, i2, iPointObtain);
            gLMapState.setMapGeoCenter(((Point) iPointObtain).x, ((Point) iPointObtain).y);
        } else {
            iPointObtain = null;
            iPointObtain2 = null;
        }
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
        if (i > 0 || i2 > 0) {
            win2geo(gLMapState, i, i2, iPointObtain2);
            if (iPointObtain != null) {
                gLMapState.setMapGeoCenter((((Point) iPointObtain).x * 2) - ((Point) iPointObtain2).x, (((Point) iPointObtain).y * 2) - ((Point) iPointObtain2).y);
            }
            gLMapState.recalculate();
        }
        if (iPointObtain != null) {
            iPointObtain.recycle();
        }
        if (iPointObtain2 != null) {
            iPointObtain2.recycle();
        }
    }
}
