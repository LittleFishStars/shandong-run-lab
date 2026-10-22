package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class HoverGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;

    public HoverGestureMapMessage(int i, float f) {
        super(i);
        this.angleDelta = f;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static HoverGestureMapMessage obtain(int i, float f) {
        HoverGestureMapMessage hoverGestureMapMessageAcquire = M_POOL.acquire();
        if (hoverGestureMapMessageAcquire == null) {
            hoverGestureMapMessageAcquire = new HoverGestureMapMessage(i, f);
        } else {
            hoverGestureMapMessageAcquire.reset();
        }
        hoverGestureMapMessageAcquire.setParams(i, f);
        return hoverGestureMapMessageAcquire;
    }

    private void setParams(int i, float f) {
        setState(i);
        this.angleDelta = f;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 3;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000c A[PHI: r1
      0x000c: PHI (r1v8 float) = (r1v1 float), (r1v2 float) binds: [B:3:0x000a, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        float cameraDegree = gLMapState.getCameraDegree() + this.angleDelta;
        float f = 0.0f;
        if (cameraDegree < 0.0f) {
            cameraDegree = f;
        } else {
            f = 80.0f;
            if (cameraDegree > 80.0f) {
                cameraDegree = f;
            } else if (gLMapState.getCameraDegree() > 40.0f && cameraDegree > 40.0f && gLMapState.getCameraDegree() > cameraDegree) {
                cameraDegree = 40.0f;
            }
        }
        gLMapState.setCameraDegree(cameraDegree);
        gLMapState.recalculate();
    }
}
