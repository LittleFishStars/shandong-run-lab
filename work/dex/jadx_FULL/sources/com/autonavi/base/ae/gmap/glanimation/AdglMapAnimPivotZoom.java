package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdglMapAnimPivotZoom extends AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    AbstractAdglAnimationParam1V zoomParam = null;

    public AdglMapAnimPivotZoom(int i) {
        reset();
        this.duration = i;
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        float mapZoomer = gLMapState.getMapZoomer();
        if (Math.abs(this.mapLevelTo - mapZoomer) < 1.0E-6d) {
            this.isOver = true;
            this.hasCheckParams = true;
            return;
        }
        this.zoomParam.setFromValue(mapZoomer);
        this.zoomParam.setToValue(this.mapLevelTo);
        if (!this.zoomCenter) {
            IPoint iPointObtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(iPointObtain);
            this.beginCenterGeoX = ((Point) iPointObtain).x;
            this.beginCenterGeoY = ((Point) iPointObtain).y;
            IPoint iPointObtain2 = IPoint.obtain();
            gLMapState.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, iPointObtain2);
            this.pivotGeoX = ((Point) iPointObtain2).x;
            this.pivotGeoY = ((Point) iPointObtain2).y;
            iPointObtain.recycle();
            iPointObtain2.recycle();
        }
        this.hasCheckParams = true;
        this.isOver = false;
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
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        this.zoomParam.setNormalizedTime(f);
        float curValue = this.zoomParam.getCurValue();
        if (curValue > 20.0f) {
            this.isOver = true;
            curValue = 20.0f;
        }
        if (curValue < 3.0f) {
            this.isOver = true;
            curValue = 3.0f;
        }
        if (!this.zoomCenter) {
            float fPow = (float) Math.pow(2.0d, curValue - this.zoomParam.getFromValue());
            int i = this.pivotGeoX;
            int i2 = this.beginCenterGeoX;
            float f2 = 1.0f - (1.0f / fPow);
            int i3 = (int) ((i - i2) * f2);
            int i4 = this.pivotGeoY;
            int i5 = this.beginCenterGeoY;
            gLMapState.setMapGeoCenter(i2 + i3, i5 + ((int) ((i4 - i5) * f2)));
        }
        gLMapState.setMapZoomer(curValue);
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void setToMapZoomAndPivot(float f, int i, Point point) {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = new AbstractAdglAnimationParam1V();
        this.zoomParam = abstractAdglAnimationParam1V;
        abstractAdglAnimationParam1V.setInterpolatorType(i, 1.0f);
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 3.0f) {
            f = 3.0f;
        }
        this.mapLevelTo = f;
        if (point != null) {
            this.winPivotX = point.x;
            this.winPivotY = point.y;
            this.zoomCenter = false;
        }
    }
}
