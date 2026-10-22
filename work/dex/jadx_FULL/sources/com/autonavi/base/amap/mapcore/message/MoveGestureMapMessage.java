package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(1024);
    static int newCount;
    public float touchDeltaX;
    public float touchDeltaY;
    public int touchX;
    public int touchY;

    public MoveGestureMapMessage(int i, float f, float f2) {
        super(i);
        this.touchX = 0;
        this.touchY = 0;
        this.touchDeltaX = f;
        this.touchDeltaY = f2;
        newCount++;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized MoveGestureMapMessage obtain(int i, float f, float f2, float f3, float f4) {
        MoveGestureMapMessage moveGestureMapMessageAcquire;
        moveGestureMapMessageAcquire = M_POOL.acquire();
        if (moveGestureMapMessageAcquire == null) {
            moveGestureMapMessageAcquire = new MoveGestureMapMessage(i, f, f2);
        } else {
            moveGestureMapMessageAcquire.reset();
            moveGestureMapMessageAcquire.setParams(i, f, f2);
        }
        moveGestureMapMessageAcquire.touchX = (int) f3;
        moveGestureMapMessageAcquire.touchY = (int) f4;
        return moveGestureMapMessageAcquire;
    }

    private void setParams(int i, float f, float f2) {
        setState(i);
        this.touchDeltaX = f;
        this.touchDeltaY = f2;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        int i = (int) this.touchDeltaX;
        int i2 = (int) this.touchDeltaY;
        int i3 = this.touchX - i;
        int i4 = this.touchY - i2;
        IPoint iPointObtain = IPoint.obtain();
        win2geo(gLMapState, this.touchX, this.touchY, iPointObtain);
        IPoint iPointObtain2 = IPoint.obtain();
        win2geo(gLMapState, i3, i4, iPointObtain2);
        IPoint iPointObtain3 = IPoint.obtain();
        gLMapState.getMapGeoCenter(iPointObtain3);
        gLMapState.setMapGeoCenter(((Point) iPointObtain3).x + (((Point) iPointObtain2).x - ((Point) iPointObtain).x), ((Point) iPointObtain3).y + (((Point) iPointObtain2).y - ((Point) iPointObtain).y));
        gLMapState.recalculate();
        iPointObtain3.recycle();
        iPointObtain.recycle();
        iPointObtain2.recycle();
    }
}
