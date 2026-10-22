package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdglMapAnimFlingP20 extends AbstractAdglAnimation {
    private boolean hasCheckParams;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

    public AdglMapAnimFlingP20(int i) {
        reset();
        this.duration = i;
    }

    public void commitAnimation(Object obj) {
        boolean z;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f = this.velocityScreenX;
        int i = this.duration;
        float f2 = (f * i) / 2000.0f;
        float f3 = (this.velocityScreenY * i) / 2000.0f;
        if (Math.abs(f2) == 0.0f || Math.abs(f3) == 0.0f) {
            z = true;
        } else {
            this.isOver = false;
            IPoint iPointObtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(iPointObtain);
            this.moveParam.setFromValue(((Point) iPointObtain).x, ((Point) iPointObtain).y);
            float mapLenWithWin = gLMapState.getMapLenWithWin(1);
            double mapAngle = (((double) gLMapState.getMapAngle()) * 3.141592653589793d) / 180.0d;
            double d = mapLenWithWin;
            double d2 = f2;
            double d3 = f3;
            this.moveParam.setToValue(((double) ((Point) iPointObtain).x) - (((Math.cos(mapAngle) * d2) - (Math.sin(mapAngle) * d3)) * d), ((double) ((Point) iPointObtain).y) - (d * ((d2 * Math.sin(mapAngle)) + (d3 * Math.cos(mapAngle)))));
            this.needMove = this.moveParam.needToCaculate();
            iPointObtain.recycle();
            z = true;
        }
        this.hasCheckParams = z;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = jUptimeMillis;
        float f = jUptimeMillis / this.duration;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        }
        if (f < 0.0f || f > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f);
        gLMapState.setMapGeoCenter(this.moveParam.getCurXValue(), this.moveParam.getCurYValue());
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityScreenX = 0.0f;
        this.velocityScreenY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f, float f2) {
        this.moveParam = null;
        this.velocityScreenX = f;
        this.velocityScreenY = f2;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
