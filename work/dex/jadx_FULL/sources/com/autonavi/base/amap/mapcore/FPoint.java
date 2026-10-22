package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;
import com.autonavi.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FPoint extends PointF {
    private static final Pools.SynchronizedPool<FPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public FPoint() {
    }

    public static FPoint obtain() {
        FPoint fPointAcquire = M_POOL.acquire();
        if (fPointAcquire == null) {
            return new FPoint();
        }
        fPointAcquire.set(0.0f, 0.0f);
        return fPointAcquire;
    }

    @Override // android.graphics.PointF
    public boolean equals(Object obj) {
        FPoint fPoint = (FPoint) obj;
        return fPoint != null && ((PointF) this).x == ((PointF) fPoint).x && ((PointF) this).y == ((PointF) fPoint).y;
    }

    @Override // android.graphics.PointF
    public int hashCode() {
        Float.floatToIntBits(((PointF) this).x);
        return Float.floatToIntBits(((PointF) this).y) * 37;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public FPoint(float f, float f2) {
        ((PointF) this).x = f;
        ((PointF) this).y = f2;
    }

    public static FPoint obtain(float f, float f2) {
        FPoint fPointAcquire = M_POOL.acquire();
        if (fPointAcquire == null) {
            return new FPoint(f, f2);
        }
        fPointAcquire.set(f, f2);
        return fPointAcquire;
    }
}
