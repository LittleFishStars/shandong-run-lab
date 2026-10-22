package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.zj.adlib.a7b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GestureDetector f760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ap f761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public aq f762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public as f763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public at f764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapGestureListener f765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f766a;
    public int f;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f767a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25900a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f768b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f769c = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f770d = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f759a = new Handler(Looper.getMainLooper());

    public c0(IAMapDelegate iAMapDelegate) {
        byte b2 = 0;
        this.f758a = iAMapDelegate.getContext();
        this.f766a = iAMapDelegate;
        a aVar = new a(this, b2);
        GestureDetector gestureDetector = new GestureDetector(this.f758a, aVar, this.f759a);
        this.f760a = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.f763a = new as(this.f758a, new d(this, b2));
        this.f762a = new aq(this.f758a, new c(this, b2));
        this.f761a = new ap(this.f758a, new b(this, b2));
        this.f764a = new at(this.f758a, new e(this, b2));
    }

    public static /* synthetic */ int o(c0 c0Var) {
        int i = c0Var.b;
        c0Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int p(c0 c0Var) {
        int i = c0Var.c;
        c0Var.c = i + 1;
        return i;
    }

    public static /* synthetic */ int t(c0 c0Var) {
        int i = c0Var.f25900a;
        c0Var.f25900a = i + 1;
        return i;
    }

    public static /* synthetic */ int u(c0 c0Var) {
        int i = c0Var.d;
        c0Var.d = i + 1;
        return i;
    }

    public static /* synthetic */ boolean v(c0 c0Var) {
        c0Var.f770d = true;
        return true;
    }

    public final void b() {
        this.f25900a = 0;
        this.c = 0;
        this.b = 0;
        this.d = 0;
        this.e = 0;
    }

    public final void c(int i, int i2) {
        this.f = i;
        this.g = i2;
        as asVar = this.f763a;
        if (asVar != null) {
            asVar.d(i, i2);
        }
        aq aqVar = this.f762a;
        if (aqVar != null) {
            aqVar.b(i, i2);
        }
        ap apVar = this.f761a;
        if (apVar != null) {
            apVar.b(i, i2);
        }
        at atVar = this.f764a;
        if (atVar != null) {
            atVar.b(i, i2);
        }
    }

    public final void d(AMapGestureListener aMapGestureListener) {
        this.f765a = aMapGestureListener;
    }

    public final boolean e(MotionEvent motionEvent) {
        if (this.e < motionEvent.getPointerCount()) {
            this.e = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.f769c = false;
            this.f770d = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.f769c = true;
        }
        if (this.f768b && this.e >= 2) {
            this.f768b = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.f766a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.f766a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.f765a != null) {
                if (motionEvent.getAction() == 0) {
                    this.f765a.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f765a.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f760a.onTouchEvent(motionEvent);
            this.f761a.e(motionEvent, iArr[0], iArr[1]);
            if (!this.f767a || this.d <= 0) {
                this.f764a.e(motionEvent, iArr[0], iArr[1]);
                if (!this.f768b) {
                    this.f763a.e(motionEvent);
                    this.f762a.e(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int g() {
        return this.f;
    }

    public final int j() {
        return this.g;
    }

    public class b implements ap.a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EAMapPlatformGestureInfo f774a;

        public b() {
            this.f774a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.ap.a
        public final boolean a(ap apVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f774a;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{apVar.f().getX(), apVar.f().getY()};
            try {
                if (!c0.this.f766a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f774a);
                if (c0.this.f766a.isLockMapCameraDegree(engineIDWithGestureInfo) || c0.this.c > 3) {
                    return false;
                }
                float f = apVar.j().x;
                float f2 = apVar.j().y;
                if (!c0.this.f767a) {
                    PointF pointFH = apVar.h(0);
                    PointF pointFH2 = apVar.h(1);
                    float f3 = pointFH.y;
                    if ((f3 > 10.0f && pointFH2.y > 10.0f) || (f3 < -10.0f && pointFH2.y < -10.0f)) {
                        z = true;
                    }
                    if (z && Math.abs(f2) > 10.0f && Math.abs(f) < 10.0f) {
                        c0.this.f767a = true;
                    }
                }
                if (c0.this.f767a) {
                    c0.this.f767a = true;
                    float f4 = f2 / 6.0f;
                    if (Math.abs(f4) > 1.0f) {
                        c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f4));
                        c0.u(c0.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.ap.a
        public final boolean b(ap apVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f774a;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{apVar.f().getX(), apVar.f().getY()};
            try {
                if (!c0.this.f766a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f774a);
                if (c0.this.f766a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                    return false;
                }
                IAMapDelegate iAMapDelegate = c0.this.f766a;
                iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                return true;
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.ap.a
        public final void c(ap apVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f774a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{apVar.f().getX(), apVar.f().getY()};
            try {
                if (c0.this.f766a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f774a);
                    if (c0.this.f766a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (c0.this.f766a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && c0.this.d > 0) {
                        c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    c0.this.f767a = false;
                    IAMapDelegate iAMapDelegate = c0.this.f766a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }

        public /* synthetic */ b(c0 c0Var, byte b) {
            this();
        }
    }

    public class c implements aq.a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EAMapPlatformGestureInfo f775a;

        public c() {
            this.f775a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.aq.a
        public final void a(aq aqVar) {
            try {
                if (c0.this.f766a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f775a;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{aqVar.f().getX(), aqVar.f().getY()};
                    int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f775a);
                    if (c0.this.f25900a > 0) {
                        c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, aqVar.f().getX(), aqVar.f().getY()));
                }
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.3l.aq.a
        public final boolean b(aq aqVar) {
            try {
                if (!c0.this.f766a.getUiSettings().isScrollGesturesEnabled()) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f775a;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{aqVar.f().getX(), aqVar.f().getY()};
                c0.this.f766a.addGestureMapMessage(c0.this.f766a.getEngineIDWithGestureInfo(this.f775a), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, aqVar.f().getX(), aqVar.f().getY()));
                return true;
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.aq.a
        public final boolean c(aq aqVar) {
            if (c0.this.f767a) {
                return true;
            }
            try {
                if (c0.this.f766a.getUiSettings().isScrollGesturesEnabled() && !c0.this.f769c) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f775a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{aqVar.f().getX(), aqVar.f().getY()};
                    int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f775a);
                    PointF pointFG = aqVar.g();
                    float f = c0.this.f25900a == 0 ? 4.0f : 1.0f;
                    if (Math.abs(pointFG.x) <= f && Math.abs(pointFG.y) <= f) {
                        return false;
                    }
                    if (c0.this.f25900a == 0) {
                        c0.this.f766a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                    }
                    c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, pointFG.x, pointFG.y, aqVar.f().getX(), aqVar.f().getY()));
                    c0.t(c0.this);
                }
                return true;
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        public /* synthetic */ c(c0 c0Var, byte b) {
            this();
        }
    }

    public class e extends at.b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EAMapPlatformGestureInfo f783a;

        public e() {
            this.f783a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.at.b, com.amap.api.col.3l.at.a
        public final void a(at atVar) {
            try {
                if (c0.this.f766a.getUiSettings().isZoomGesturesEnabled() && Math.abs(atVar.j()) <= 10.0f && Math.abs(atVar.k()) <= 10.0f && atVar.c() < 200) {
                    c0.v(c0.this);
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f783a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{atVar.f().getX(), atVar.f().getY()};
                    int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f783a);
                    c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 4);
                    c0.this.f766a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }

        public /* synthetic */ e(c0 c0Var, byte b) {
            this();
        }
    }

    public class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f25901a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f771a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EAMapPlatformGestureInfo f773a;

        public a() {
            this.K = 0;
            this.f25901a = 0.0f;
            this.f773a = new EAMapPlatformGestureInfo();
            this.f771a = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            c0.this.f760a.setIsLongpressEnabled(false);
            this.K = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = c0.this.f765a;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.K < motionEvent.getPointerCount()) {
                this.K = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.K != 1) {
                return false;
            }
            try {
                if (!c0.this.f766a.getUiSettings().isZoomGesturesEnabled()) {
                    return false;
                }
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f773a;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 9;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f773a);
                this.f25901a = motionEvent.getY();
                c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.f771a = SystemClock.uptimeMillis();
                return true;
            }
            if (action == 2) {
                c0.this.f768b = true;
                float y = this.f25901a - motionEvent.getY();
                if (Math.abs(y) < 20.0f) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.f773a;
                eAMapPlatformGestureInfo2.mGestureState = 2;
                eAMapPlatformGestureInfo2.mGestureType = 9;
                eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                c0.this.f766a.addGestureMapMessage(c0.this.f766a.getEngineIDWithGestureInfo(this.f773a), ScaleGestureMapMessage.obtain(101, (y * 4.0f) / c0.this.f766a.getMapHeight(), 0, 0));
                this.f25901a = motionEvent.getY();
                return true;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.f773a;
            eAMapPlatformGestureInfo3.mGestureState = 3;
            eAMapPlatformGestureInfo3.mGestureType = 9;
            eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo2 = c0.this.f766a.getEngineIDWithGestureInfo(this.f773a);
            c0.this.f760a.setIsLongpressEnabled(true);
            c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (action != 1) {
                c0.this.f768b = false;
                return true;
            }
            c0.this.f766a.setGestureStatus(engineIDWithGestureInfo2, 3);
            long jUptimeMillis = SystemClock.uptimeMillis() - this.f771a;
            if (!c0.this.f768b || jUptimeMillis < 200) {
                return c0.this.f766a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
            }
            c0.this.f768b = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            c0.this.f768b = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = c0.this.f765a;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f, f2);
            }
            try {
                if (c0.this.f766a.getUiSettings().isScrollGesturesEnabled() && c0.this.d <= 0 && c0.this.b <= 0 && c0.this.c == 0 && !c0.this.f770d) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f773a;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f773a);
                    c0.this.f766a.onFling();
                    c0.this.f766a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            if (c0.this.e == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f773a;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                c0.this.f766a.onLongPress(c0.this.f766a.getEngineIDWithGestureInfo(this.f773a), motionEvent);
                AMapGestureListener aMapGestureListener = c0.this.f765a;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = c0.this.f765a;
            if (aMapGestureListener == null) {
                return false;
            }
            aMapGestureListener.onScroll(f, f2);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f773a;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                c0.this.f766a.getGLMapEngine().clearAnimations(c0.this.f766a.getEngineIDWithGestureInfo(this.f773a), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c0.this.e != 1) {
                return false;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f773a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f773a);
            AMapGestureListener aMapGestureListener = c0.this.f765a;
            if (aMapGestureListener != null) {
                try {
                    aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return c0.this.f766a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        public /* synthetic */ a(c0 c0Var, byte b) {
            this();
        }
    }

    public class d extends as.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f25904a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Point f776a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EAMapPlatformGestureInfo f778a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f779a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public float[] f780a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f781b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public float[] f782b;
        public boolean c;

        public d() {
            this.f779a = false;
            this.f781b = false;
            this.c = false;
            this.f776a = new Point();
            this.f780a = new float[10];
            this.f25904a = 0.0f;
            this.f782b = new float[10];
            this.b = 0.0f;
            this.f778a = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:41:0x0110  */
        /* JADX WARN: Code duplicated, block: B:70:0x0171 A[Catch: all -> 0x01a2, TRY_LEAVE, TryCatch #1 {all -> 0x01a2, blocks: (B:46:0x011c, B:48:0x012a, B:50:0x0134, B:52:0x0138, B:54:0x0142, B:56:0x014a, B:57:0x014c, B:59:0x0150, B:70:0x0171, B:65:0x0162), top: B:82:0x011c }] */
        @Override // com.amap.api.col.3l.as.a
        public final boolean d(as asVar) {
            Throwable th;
            boolean z;
            boolean z2;
            float fS;
            boolean z3;
            boolean z4;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f778a;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z5 = true;
            eAMapPlatformGestureInfo.mLocation = new float[]{asVar.c().getX(), asVar.c().getY()};
            int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f778a);
            float fN = asVar.n();
            float fO = asVar.o();
            int iF = (int) asVar.f();
            int i = (int) asVar.i();
            float fAbs = Math.abs(iF - this.f776a.x);
            float fAbs2 = Math.abs(i - this.f776a.y);
            Point point = this.f776a;
            point.x = iF;
            point.y = i;
            float fLog = (float) Math.log(fN);
            if (c0.this.b <= 0 && Math.abs(fLog) > 0.2f) {
                this.c = true;
            }
            try {
                if (!c0.this.f766a.getUiSettings().isZoomGesturesEnabled()) {
                    z = false;
                    z2 = z;
                } else if (!this.f779a) {
                    try {
                        if (0.06f < Math.abs(fLog)) {
                            this.f779a = true;
                        }
                        if (this.f779a || 0.01f >= Math.abs(fLog)) {
                            z = false;
                        } else {
                            if (fAbs > 2.0f || fAbs2 > 2.0f) {
                                try {
                                    if (Math.abs(fLog) < 0.02f) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = true;
                                    a7b.m(th, "GLMapGestrureDetector", "onScaleRotate");
                                    th.printStackTrace();
                                }
                            } else {
                                z4 = false;
                            }
                            if (!z4 && fO > 0.0f) {
                                float f = fLog / fO;
                                this.f25904a = f;
                                this.f780a[c0.this.b % 10] = Math.abs(f);
                                c0.o(c0.this);
                                c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(101, fLog, iF, i));
                                if (fLog > 0.0f) {
                                    c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 1);
                                    z2 = true;
                                } else {
                                    c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 2);
                                }
                            }
                            z = true;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z = false;
                        a7b.m(th, "GLMapGestrureDetector", "onScaleRotate");
                        th.printStackTrace();
                        z2 = z;
                        if (c0.this.f766a.getUiSettings().isRotateGesturesEnabled()) {
                            fS = asVar.s();
                            if (!this.f781b) {
                                this.f781b = true;
                            }
                            if (this.f781b) {
                                z3 = fAbs > 4.0f ? true : true;
                                if (!z3) {
                                    float f2 = fS / fO;
                                    this.b = f2;
                                    this.f782b[c0.this.c % 10] = Math.abs(f2);
                                    c0.p(c0.this);
                                    c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(101, fS, iF, i));
                                    try {
                                        c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 6);
                                        return true;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        a7b.m(th, "GLMapGestrureDetector", "onScaleRotate");
                                        th.printStackTrace();
                                        return z5;
                                    }
                                }
                            }
                        }
                        return z2;
                    }
                    z2 = z;
                } else if (this.f779a) {
                    z = false;
                    z2 = z;
                } else {
                    z = false;
                    z2 = z;
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
            try {
                if (c0.this.f766a.getUiSettings().isRotateGesturesEnabled() && !c0.this.f766a.isLockMapAngle(engineIDWithGestureInfo) && !this.c) {
                    fS = asVar.s();
                    if (!this.f781b && Math.abs(fS) >= 4.0f) {
                        this.f781b = true;
                    }
                    if (this.f781b && 1.0f < Math.abs(fS)) {
                        if ((fAbs > 4.0f && fAbs2 <= 4.0f) || Math.abs(fS) >= 2.0f) {
                            z3 = false;
                        }
                        if (!z3) {
                            float f3 = fS / fO;
                            this.b = f3;
                            this.f782b[c0.this.c % 10] = Math.abs(f3);
                            c0.p(c0.this);
                            c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(101, fS, iF, i));
                            c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 6);
                            return true;
                        }
                    }
                }
                return z2;
            } catch (Throwable th6) {
                th = th6;
                z5 = z2;
            }
        }

        @Override // com.amap.api.col.3l.as.a
        public final boolean e(as asVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f778a;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{asVar.c().getX(), asVar.c().getY()};
            int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f778a);
            int iF = (int) asVar.f();
            int i = (int) asVar.i();
            this.c = false;
            Point point = this.f776a;
            point.x = iF;
            point.y = i;
            this.f779a = false;
            this.f781b = false;
            c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, iF, i));
            try {
                if (c0.this.f766a.getUiSettings().isRotateGesturesEnabled() && !c0.this.f766a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = c0.this.f766a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), iF, i));
                }
            } catch (Throwable th) {
                a7b.m(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:49:0x0121  */
        @Override // com.amap.api.col.3l.as.a
        public final void f(as asVar) {
            float f;
            float f2;
            float preciseLevel;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f778a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{asVar.c().getX(), asVar.c().getY()};
            int engineIDWithGestureInfo = c0.this.f766a.getEngineIDWithGestureInfo(this.f778a);
            this.c = false;
            c0.this.f766a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (c0.this.b > 0) {
                int i = c0.this.b > 10 ? 10 : c0.this.b;
                float f3 = 0.0f;
                for (int i2 = 0; i2 < 10; i2++) {
                    float[] fArr = this.f780a;
                    f3 += fArr[i2];
                    fArr[i2] = 0.0f;
                }
                float f4 = f3 / i;
                if (0.004f <= f4) {
                    float f5 = f4 * 300.0f;
                    if (f5 >= 1.5f) {
                        f5 = 1.5f;
                    }
                    if (this.f25904a < 0.0f) {
                        f5 = -f5;
                    }
                    preciseLevel = c0.this.f766a.getPreciseLevel(engineIDWithGestureInfo) + f5;
                } else {
                    preciseLevel = -9999.0f;
                }
                this.f25904a = 0.0f;
                f = preciseLevel;
            } else {
                f = -9999.0f;
            }
            if (c0.this.f766a.isLockMapAngle(engineIDWithGestureInfo)) {
                f2 = -9999.0f;
            } else {
                try {
                    if (c0.this.f766a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = c0.this.f766a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    a7b.m(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (c0.this.c > 0) {
                    c0.this.f766a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i3 = c0.this.c > 10 ? 10 : c0.this.c;
                    float f6 = 0.0f;
                    for (int i4 = 0; i4 < 10; i4++) {
                        float[] fArr2 = this.f782b;
                        f6 += fArr2[i4];
                        fArr2[i4] = 0.0f;
                    }
                    float f7 = f6 / i3;
                    if (0.1f <= f7) {
                        float f8 = f7 * 200.0f;
                        int mapAngle = ((int) c0.this.f766a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f8 >= 60.0f) {
                            f8 = 60.0f;
                        }
                        if (this.b < 0.0f) {
                            f8 = -f8;
                        }
                        f2 = ((int) (mapAngle + f8)) % 360;
                    } else {
                        f2 = -9999.0f;
                    }
                } else {
                    f2 = -9999.0f;
                }
                this.f25904a = 0.0f;
            }
            if ((f == -9999.0f && f2 == -9999.0f) ? false : true) {
                c0.this.f766a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f776a, f, (int) f2, 500);
            }
        }

        public /* synthetic */ d(c0 c0Var, byte b) {
            this();
        }
    }
}
