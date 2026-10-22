package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.zj.adlib.a7b;
import com.zj.adlib.mwa;
import com.zj.adlib.qja;
import com.zj.adlib.s0b;
import com.zj.adlib.swa;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class eh extends ViewGroup implements ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ed f803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ee f804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ef f805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public eg f806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ek f807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public el f808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IGlOverlayLayer f810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BasePointOverlay f811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    s0b f813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f814a;
    public View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    qja f815b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f816b;
    public boolean c;
    public boolean d;

    public class a implements AMapWidgetListener {

        /* JADX INFO: renamed from: com.amap.api.col.3l.eh$a$a, reason: collision with other inner class name */
        public class RunnableC0247a implements Runnable {
            public RunnableC0247a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f807a.b();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f804a.b();
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ float f25927a;

            public c(float f) {
                this.f25927a = f;
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f809a.c(this.f25927a);
            }
        }

        public a() {
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateCompassView() {
            if (eh.this.f804a == null) {
                return;
            }
            eh.this.f804a.post(new b());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateScaleView() {
            if (eh.this.f807a == null) {
                return;
            }
            eh.this.f807a.post(new RunnableC0247a());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateZoomController(float f) {
            if (eh.this.f809a == null) {
                return;
            }
            eh.this.f809a.post(new c(f));
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void setFrontViewVisibility(boolean z) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (eh.this.f802a != null) {
                eh.this.f802a.clearFocus();
                eh ehVar = eh.this;
                ehVar.removeView(ehVar.f802a);
                zwa.C(eh.this.f802a.getBackground());
                zwa.C(eh.this.f801a);
                eh.f(eh.this);
            }
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25929a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public FPoint f818a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f819a;
        public int b;
        public int c;

        public c(FPoint fPoint, int i) {
            this(-2, -2, ((PointF) fPoint).x, ((PointF) fPoint).y, 0, 0, i);
        }

        public c(int i, int i2, float f, float f2, int i3, int i4, int i5) {
            super(i, i2);
            FPoint fPoint = new FPoint();
            this.f818a = fPoint;
            this.f819a = false;
            ((PointF) fPoint).x = f;
            ((PointF) fPoint).y = f2;
            this.f25929a = i3;
            this.b = i4;
            this.c = i5;
        }
    }

    public eh(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        this.f801a = null;
        int i = 1;
        this.f814a = true;
        this.c = true;
        this.d = true;
        try {
            this.f810a = iGlOverlayLayer;
            this.f812a = iAMapDelegate;
            this.f25923a = context;
            this.f813a = new s0b();
            this.f803a = new ed(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f812a.getGLMapView() != null) {
                addView(this.f812a.getGLMapView(), 0, layoutParams);
            } else {
                i = 0;
            }
            addView(this.f803a, i, layoutParams);
            if (this.c) {
                return;
            }
            c(context);
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
    }

    public static /* synthetic */ View f(eh ehVar) {
        ehVar.f802a = null;
        return null;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void g(Boolean bool) {
        el elVar = this.f808a;
        if (elVar == null) {
            this.f813a.b(this, bool);
            return;
        }
        if (elVar != null && bool.booleanValue()) {
            this.f808a.a(true);
            return;
        }
        el elVar2 = this.f808a;
        if (elVar2 != null) {
            elVar2.a(false);
        }
    }

    public final void h(View view, c cVar) {
        int[] iArr = new int[2];
        f(view, ((ViewGroup.LayoutParams) cVar).width, ((ViewGroup.LayoutParams) cVar).height, iArr);
        if (view instanceof j) {
            e(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), cVar.c);
            return;
        }
        if (view instanceof eg) {
            e(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], cVar.c);
            return;
        }
        if (view instanceof ee) {
            e(view, iArr[0], iArr[1], 0, 0, cVar.c);
            return;
        }
        if (cVar.f818a != null) {
            IPoint iPointObtain = IPoint.obtain();
            MapConfig mapConfig = this.f812a.getMapConfig();
            GLMapState mapProjection = this.f812a.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                FPoint fPoint = cVar.f818a;
                ((Point) iPointObtain).x = (int) ((PointF) fPoint).x;
                ((Point) iPointObtain).y = (int) ((PointF) fPoint).y;
            }
            int i = ((Point) iPointObtain).x + cVar.f25929a;
            ((Point) iPointObtain).x = i;
            int i2 = ((Point) iPointObtain).y + cVar.b;
            ((Point) iPointObtain).y = i2;
            e(view, iArr[0], iArr[1], i, i2, cVar.c);
            iPointObtain.recycle();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void hideInfoWindow() {
        try {
            IAMapDelegate iAMapDelegate = this.f812a;
            if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
                return;
            }
            this.f812a.getMainHandler().post(new b());
            BasePointOverlay basePointOverlay = this.f811a;
            if (basePointOverlay != null) {
                this.f810a.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
            }
            this.f811a = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void i(Boolean bool) {
        ef efVar = this.f805a;
        if (efVar == null) {
            this.f813a.b(this, bool);
        } else {
            efVar.a(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final View j() {
        return this;
    }

    public final void k() {
        ek ekVar = this.f807a;
        if (ekVar == null) {
            this.f813a.b(this, new Object[0]);
        } else {
            if (ekVar == null || ekVar.getVisibility() != 0) {
                return;
            }
            this.f807a.postInvalidate();
        }
    }

    public final void l() {
        j jVar = this.f809a;
        if (jVar != null) {
            jVar.b();
        }
        ek ekVar = this.f807a;
        if (ekVar != null) {
            ekVar.a();
        }
        el elVar = this.f808a;
        if (elVar != null) {
            elVar.a();
        }
        eg egVar = this.f806a;
        if (egVar != null) {
            egVar.a();
        }
        ee eeVar = this.f804a;
        if (eeVar != null) {
            eeVar.a();
        }
        ef efVar = this.f805a;
        if (efVar != null) {
            efVar.a();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.f802a == null || this.f811a == null || !zwa.J(new Rect(this.f802a.getLeft(), this.f802a.getTop(), this.f802a.getRight(), this.f802a.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof c) {
                        h(childAt, (c) childAt.getLayoutParams());
                    } else {
                        g(childAt, childAt.getLayoutParams());
                    }
                }
            }
            el elVar = this.f808a;
            if (elVar != null) {
                elVar.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        try {
            BasePointOverlay basePointOverlay = this.f811a;
            if (basePointOverlay == null || !this.f810a.checkInBounds(basePointOverlay.getId())) {
                View view = this.f802a;
                if (view == null || view.getVisibility() != 0) {
                    return;
                }
                this.f802a.setVisibility(8);
                return;
            }
            if (this.f814a) {
                FPoint fPointObtain = FPoint.obtain();
                this.f810a.getMarkerInfoWindowOffset(this.f811a.getId(), fPointObtain);
                int i = (int) ((PointF) fPointObtain).x;
                int i2 = (int) (((PointF) fPointObtain).y + 2.0f);
                fPointObtain.recycle();
                View viewB = b(this.f811a);
                if (viewB == null) {
                    View view2 = this.f802a;
                    if (view2 == null || view2.getVisibility() != 0) {
                        return;
                    }
                    hideInfoWindow();
                    return;
                }
                FPoint fPointObtain2 = FPoint.obtain();
                this.f810a.getOverlayScreenPos(this.f811a.getId(), fPointObtain2);
                d(viewB, (int) ((PointF) fPointObtain2).x, (int) ((PointF) fPointObtain2).y, i, i2);
                View view3 = this.f802a;
                if (view3 != null) {
                    c cVar = (c) view3.getLayoutParams();
                    if (cVar != null) {
                        cVar.f818a = FPoint.obtain(((PointF) fPointObtain2).x, ((PointF) fPointObtain2).y);
                        cVar.f25929a = i;
                        cVar.b = i2;
                    }
                    onLayout(false, 0, 0, 0, 0);
                    if (this.f815b.n()) {
                        this.f815b.m(this.f811a.getTitle(), this.f811a.getSnippet());
                    }
                    if (this.f802a.getVisibility() == 8) {
                        this.f802a.setVisibility(0);
                    }
                }
                fPointObtain2.recycle();
            }
        } catch (Throwable th) {
            a7b.m(th, "MapOverlayViewGroup", "redrawInfoWindow");
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(qja qjaVar) {
        this.f815b = qjaVar;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            qja qjaVar = this.f815b;
            if (!(qjaVar != null && qjaVar.n() && basePointOverlay.getTitle() == null && basePointOverlay.getSnippet() == null) && basePointOverlay.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay2 = this.f811a;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.f815b != null) {
                    this.f811a = basePointOverlay;
                    this.f816b = true;
                    this.f810a.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Boolean bool) {
        ef efVar = this.f805a;
        if (efVar == null) {
            this.f813a.b(this, bool);
        } else if (efVar != null && bool.booleanValue() && this.f812a.canShowIndoorSwitch()) {
            this.f805a.a(true);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void b(Boolean bool) {
        j jVar = this.f809a;
        if (jVar == null) {
            this.f813a.b(this, bool);
        } else {
            jVar.e(bool.booleanValue());
        }
    }

    public final void c(Context context) {
        el elVar = new el(context);
        this.f808a = elVar;
        elVar.c(this.d);
        this.f807a = new ek(context, this.f812a);
        this.f805a = new ef(context);
        this.f809a = new j(context, this.f812a);
        this.f806a = new eg(context, this.f812a);
        this.f804a = new ee(context, this.f812a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f808a, layoutParams);
        addView(this.f807a, layoutParams);
        addView(this.f805a, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f809a, new c(new FPoint(0.0f, 0.0f), 83));
        addView(this.f806a, new c(FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.f804a, new c(FPoint.obtain(0.0f, 0.0f), 51));
        this.f804a.setVisibility(8);
        this.f812a.setMapWidgetListener(new a());
        try {
            if (this.f812a.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.f806a.setVisibility(8);
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void d(Boolean bool) {
        ee eeVar = this.f804a;
        if (eeVar == null) {
            this.f813a.b(this, bool);
        } else {
            eeVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void e(Boolean bool) {
        ek ekVar = this.f807a;
        if (ekVar == null) {
            this.f813a.b(this, bool);
        } else {
            ekVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void f(Boolean bool) {
        el elVar = this.f808a;
        if (elVar == null) {
            this.f813a.b(this, bool);
        } else {
            elVar.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void i() {
        Context context;
        if (!this.c || (context = this.f25923a) == null) {
            return;
        }
        c(context);
        s0b s0bVar = this.f813a;
        if (s0bVar != null) {
            s0bVar.a();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void b(Integer num) {
        el elVar = this.f808a;
        if (elVar == null) {
            this.f813a.b(this, num);
        } else if (elVar != null) {
            elVar.a(num.intValue());
            this.f808a.postInvalidate();
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void d(Integer num) {
        el elVar = this.f808a;
        if (elVar == null) {
            this.f813a.b(this, num);
        } else if (elVar != null) {
            elVar.c(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final ef e() {
        return this.f805a;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final el f() {
        return this.f808a;
    }

    public final void e(View view, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i5 & 7;
        int i8 = i5 & 112;
        if (i7 == 5) {
            i3 -= i;
        } else if (i7 == 1) {
            i3 -= i / 2;
        }
        if (i8 == 80) {
            i4 -= i2;
        } else {
            if (i8 == 17) {
                i6 = i2 / 2;
            } else if (i8 == 16) {
                i4 /= 2;
                i6 = i2 / 2;
            }
            i4 -= i6;
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
        if (view instanceof IGLSurfaceView) {
            this.f812a.changeSize(i, i2);
        }
    }

    public final void f(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(String str, Boolean bool, Integer num) {
        if (this.f808a == null) {
            this.f813a.b(this, str, bool, num);
            return;
        }
        if (num.intValue() == 2) {
            this.f808a.b(bool.booleanValue());
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f808a.a(str, num.intValue());
            this.f808a.d(bool.booleanValue());
        }
    }

    public final void g(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        f(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof ef) {
            e(view, iArr[0], iArr[1], 20, (this.f812a.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            e(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final ed d() {
        return this.f803a;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final boolean b() {
        el elVar = this.f808a;
        if (elVar != null) {
            return elVar.d();
        }
        return false;
    }

    public final void d(View view, int i, int i2, int i3, int i4) throws RemoteException {
        int i5;
        int i6;
        if (view == null) {
            return;
        }
        View view2 = this.f802a;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.f802a);
        }
        this.f802a = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.f802a.setDrawingCacheEnabled(true);
        this.f802a.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            int i7 = layoutParams.width;
            i6 = layoutParams.height;
            i5 = i7;
        } else {
            i5 = -2;
            i6 = -2;
        }
        addView(this.f802a, new c(i5, i6, i, i2, i3, i4, 81));
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            qja qjaVar = this.f815b;
            if (!(qjaVar != null && qjaVar.n() && baseOverlayImp.getTitle() == null && baseOverlayImp.getSnippet() == null) && baseOverlayImp.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay = this.f811a;
                if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.f815b != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.f816b = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final View b(BasePointOverlay basePointOverlay) throws RemoteException {
        View viewC;
        View viewC2;
        View viewC3 = null;
        if (basePointOverlay instanceof Marker) {
            try {
                if (this.f801a == null) {
                    this.f801a = mwa.c(this.f25923a, "infowindow_bg.9.png");
                }
            } catch (Throwable th) {
                a7b.m(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            try {
                if (this.f816b) {
                    viewC = this.f815b.c(basePointOverlay);
                    if (viewC == null) {
                        try {
                            viewC = this.f815b.o(basePointOverlay);
                        } catch (Throwable th2) {
                            th = th2;
                            viewC3 = viewC;
                            a7b.m(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                        }
                    }
                    this.b = viewC;
                    this.f816b = false;
                } else {
                    viewC = this.b;
                }
                if (viewC != null) {
                    viewC3 = viewC;
                } else {
                    if (!this.f815b.n()) {
                        return null;
                    }
                    viewC3 = this.f815b.c(basePointOverlay);
                }
                if (viewC3 != null && viewC3.getBackground() == null) {
                    viewC3.setBackground(this.f801a);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.f801a == null) {
                    this.f801a = mwa.c(this.f25923a, "infowindow_bg.9.png");
                }
            } catch (Throwable th4) {
                a7b.m(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            try {
                if (this.f816b) {
                    viewC2 = this.f815b.c(basePointOverlay);
                    if (viewC2 == null) {
                        try {
                            viewC2 = this.f815b.o(basePointOverlay);
                        } catch (Throwable th5) {
                            th = th5;
                            viewC3 = viewC2;
                            a7b.m(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return viewC3;
                        }
                    }
                    this.b = viewC2;
                    this.f816b = false;
                } else {
                    viewC2 = this.b;
                }
                if (viewC2 != null) {
                    viewC3 = viewC2;
                } else {
                    if (!this.f815b.n()) {
                        return null;
                    }
                    viewC3 = this.f815b.c(basePointOverlay);
                }
                if (viewC3.getBackground() == null) {
                    viewC3.setBackground(this.f801a);
                }
                return viewC3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return viewC3;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void g() {
        hideInfoWindow();
        zwa.C(this.f801a);
        l();
        removeAllViews();
        this.b = null;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Float f) {
        j jVar = this.f809a;
        if (jVar == null) {
            this.f813a.b(this, f);
        } else if (jVar != null) {
            jVar.c(f.floatValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Integer num) {
        j jVar = this.f809a;
        if (jVar == null) {
            this.f813a.b(this, num);
        } else if (jVar != null) {
            jVar.d(num.intValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final float a(int i) {
        if (this.f808a == null) {
            return 0.0f;
        }
        k();
        return this.f808a.d(i);
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void h() {
        ee eeVar = this.f804a;
        if (eeVar == null) {
            this.f813a.b(this, new Object[0]);
        } else {
            eeVar.b();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Integer num, Float f) {
        el elVar = this.f808a;
        if (elVar != null) {
            this.f813a.b(this, num, f);
        } else if (elVar != null) {
            elVar.a(num.intValue(), f.floatValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void h(Boolean bool) {
        eg egVar = this.f806a;
        if (egVar == null) {
            this.f813a.b(this, bool);
        } else {
            egVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final Point a() {
        el elVar = this.f808a;
        if (elVar == null) {
            return null;
        }
        return elVar.b();
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(CameraPosition cameraPosition) {
        if (this.f808a == null) {
            this.f813a.b(this, cameraPosition);
            return;
        }
        if (this.f812a.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!swa.a(latLng.latitude, latLng.longitude)) {
                    this.f808a.setVisibility(8);
                    return;
                }
            }
            if (this.f812a.getMaskLayerType() == -1) {
                this.f808a.setVisibility(0);
            }
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void c(Boolean bool) {
        if (this.f806a == null) {
            this.f813a.b(this, bool);
        } else if (bool.booleanValue()) {
            this.f806a.setVisibility(0);
        } else {
            this.f806a.setVisibility(8);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void c(Integer num) {
        el elVar = this.f808a;
        if (elVar == null) {
            this.f813a.b(this, num);
        } else if (elVar != null) {
            elVar.b(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(boolean z) {
        el elVar = this.f808a;
        if (elVar != null) {
            elVar.c(z);
        }
        this.d = z;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void c() {
        el elVar = this.f808a;
        if (elVar == null) {
            this.f813a.b(this, new Object[0]);
        } else if (elVar != null) {
            elVar.c();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.f802a;
        if (view == null || this.f811a == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.f802a.getLeft(), this.f802a.getTop(), new Paint());
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(ef.a aVar) {
        ef efVar = this.f805a;
        if (efVar == null) {
            this.f813a.b(this, aVar);
        } else {
            efVar.a(aVar);
        }
    }
}
