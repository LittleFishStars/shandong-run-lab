package com.amap.api.maps.utils.overlay;

import android.graphics.Point;
import androidx.camera.video.AudioStats;
import com.amap.api.col.p0003l.i;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class MovingPointOverlay {
    private BasePointOverlay baseOverlay;
    private AMap mAMap;
    private z mThreadPools;
    private MoveListener moveListener;
    private long pauseMillis;
    private long duration = 10000;
    private long mStepDuration = 20;
    private LinkedList<LatLng> points = new LinkedList<>();
    private LinkedList<Double> eachDistance = new LinkedList<>();
    private double totalDistance = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double remainDistance = AudioStats.AUDIO_AMPLITUDE_NONE;
    private Object mLock = new Object();
    private int index = 0;
    private boolean useDefaultDescriptor = false;
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    private a STATUS = a.ACTION_UNKNOWN;
    private long mAnimationBeginTime = System.currentTimeMillis();

    public interface MoveListener {
        void move(double d);
    }

    public enum a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    public class b extends it {
        private b() {
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                MovingPointOverlay.this.mAnimationBeginTime = System.currentTimeMillis();
                MovingPointOverlay.this.STATUS = a.ACTION_START;
                MovingPointOverlay.this.exitFlag.set(false);
                while (!MovingPointOverlay.this.exitFlag.get() && MovingPointOverlay.this.index <= MovingPointOverlay.this.points.size() - 1) {
                    synchronized (MovingPointOverlay.this.mLock) {
                        if (MovingPointOverlay.this.exitFlag.get()) {
                            return;
                        }
                        if (MovingPointOverlay.this.STATUS != a.ACTION_PAUSE) {
                            MovingPointOverlay.this.baseOverlay.setGeoPoint(MovingPointOverlay.this.getCurPosition(System.currentTimeMillis() - MovingPointOverlay.this.mAnimationBeginTime));
                            MovingPointOverlay.this.STATUS = a.ACTION_RUNNING;
                        }
                    }
                    Thread.sleep(MovingPointOverlay.this.mStepDuration);
                }
                MovingPointOverlay.this.STATUS = a.ACTION_STOP;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public /* synthetic */ b(MovingPointOverlay movingPointOverlay, byte b) {
            this();
        }
    }

    public MovingPointOverlay(AMap aMap, BasePointOverlay basePointOverlay) {
        this.baseOverlay = null;
        if (aMap == null || basePointOverlay == null) {
            return;
        }
        this.mAMap = aMap;
        this.mThreadPools = i.b("AMapMoveSmoothThread");
        this.baseOverlay = basePointOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPoint getCurPosition(long j) {
        double d;
        CameraPosition cameraPosition;
        MoveListener moveListener;
        long j2 = this.duration;
        int i = 0;
        if (j > j2) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            LatLng latLng = this.points.get(size);
            int i2 = this.index - 1;
            this.index = i2;
            this.index = Math.max(i2, 0);
            this.remainDistance = AudioStats.AUDIO_AMPLITUDE_NONE;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener2 = this.moveListener;
            if (moveListener2 != null) {
                moveListener2.move(this.remainDistance);
            }
            return iPoint;
        }
        double d2 = this.totalDistance;
        double d3 = (j * d2) / j2;
        this.remainDistance = d2 - d3;
        int i3 = 0;
        while (true) {
            d = 1.0d;
            if (i3 >= this.eachDistance.size()) {
                break;
            }
            double dDoubleValue = this.eachDistance.get(i3).doubleValue();
            if (d3 <= dDoubleValue) {
                d = dDoubleValue > AudioStats.AUDIO_AMPLITUDE_NONE ? d3 / dDoubleValue : 1.0d;
                i = i3;
                break;
            }
            d3 -= dDoubleValue;
            i3++;
        }
        if (i != this.index && (moveListener = this.moveListener) != null) {
            moveListener.move(this.remainDistance);
        }
        this.index = i;
        LatLng latLng2 = this.points.get(i);
        LatLng latLng3 = this.points.get(i + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i4 = ((Point) iPoint3).x - ((Point) iPoint2).x;
        int i5 = ((Point) iPoint3).y - ((Point) iPoint2).y;
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 1.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.baseOverlay.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        return new IPoint((int) (((double) ((Point) iPoint2).x) + (((double) i4) * d)), (int) (((double) ((Point) iPoint2).y) + (((double) i5) * d)));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d = ((Point) iPoint2).y;
        return (float) ((Math.atan2(((double) ((Point) iPoint2).x) - ((double) ((Point) iPoint).x), ((Point) iPoint).y - d) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            a aVar = this.STATUS;
            if (aVar == a.ACTION_RUNNING || aVar == a.ACTION_PAUSE) {
                this.exitFlag.set(true);
                this.mThreadPools.a(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
                this.baseOverlay.setAnimation(null);
                this.STATUS = a.ACTION_UNKNOWN;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            removeMarker();
            this.mThreadPools.f();
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getIndex() {
        return this.index;
    }

    public BasePointOverlay getObject() {
        return this.baseOverlay;
    }

    public LatLng getPosition() {
        BasePointOverlay basePointOverlay = this.baseOverlay;
        if (basePointOverlay != null) {
            return basePointOverlay.getPosition();
        }
        return null;
    }

    public void removeMarker() {
        try {
            reset();
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.remove();
                this.baseOverlay = null;
            }
            this.points.clear();
            this.eachDistance.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setMoveListener(MoveListener moveListener) {
        this.moveListener = moveListener;
    }

    public void setPoints(List<LatLng> list) {
        synchronized (this.mLock) {
            if (list != null) {
                try {
                    if (list.size() >= 2) {
                        stopMove();
                        this.points.clear();
                        for (LatLng latLng : list) {
                            if (latLng != null) {
                                this.points.add(latLng);
                            }
                        }
                        this.eachDistance.clear();
                        this.totalDistance = AudioStats.AUDIO_AMPLITUDE_NONE;
                        int i = 0;
                        while (i < this.points.size() - 1) {
                            LatLng latLng2 = this.points.get(i);
                            i++;
                            double dCalculateLineDistance = AMapUtils.calculateLineDistance(latLng2, this.points.get(i));
                            this.eachDistance.add(Double.valueOf(dCalculateLineDistance));
                            this.totalDistance += dCalculateLineDistance;
                        }
                        this.remainDistance = this.totalDistance;
                        this.baseOverlay.setPosition(this.points.get(0));
                        reset();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setPosition(latLng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRotate(float f) {
        AMap aMap;
        CameraPosition cameraPosition;
        try {
            if (this.baseOverlay == null || (aMap = this.mAMap) == null || (cameraPosition = aMap.getCameraPosition()) == null) {
                return;
            }
            this.baseOverlay.setRotateAngle((360.0f - f) + cameraPosition.bearing);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTotalDuration(int i) {
        this.duration = i * 1000;
    }

    public void setVisible(boolean z) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setVisible(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startSmoothMove() {
        a aVar = this.STATUS;
        if (aVar == a.ACTION_PAUSE) {
            this.STATUS = a.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((aVar == a.ACTION_UNKNOWN || aVar == a.ACTION_STOP) && this.points.size() > 0) {
            byte b2 = 0;
            this.index = 0;
            try {
                this.mThreadPools.b(new b(this, b2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void stopMove() {
        synchronized (this.mLock) {
            if (this.STATUS == a.ACTION_RUNNING) {
                this.STATUS = a.ACTION_PAUSE;
                this.pauseMillis = System.currentTimeMillis();
            }
        }
    }
}
