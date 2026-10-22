package com.zj.adlib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class qja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f44223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f19119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f19120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseOverlay f19123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IInfoWindowAction f19124a;
    public TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public IInfoWindowAction f19128b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMap.InfoWindowAdapter f19122a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMap.CommonInfoWindowAdapter f19121a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19125a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f19118a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public AMap.InfoWindowAdapter f19127b = new a();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public AMap.CommonInfoWindowAdapter f19126b = new b();

    public class a implements AMap.InfoWindowAdapter {
        public a() {
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            try {
                if (qja.this.f19118a == null) {
                    qja qjaVar = qja.this;
                    qjaVar.f19118a = mwa.c(qjaVar.f44223a, "infowindow_bg.9.png");
                }
                if (qja.this.f19119a == null) {
                    qja.this.f19119a = new LinearLayout(qja.this.f44223a);
                    qja.this.f19119a.setBackground(qja.this.f19118a);
                    qja.this.f19120a = new TextView(qja.this.f44223a);
                    qja.this.f19120a.setText(marker.getTitle());
                    qja.this.f19120a.setTextColor(-16777216);
                    qja.this.b = new TextView(qja.this.f44223a);
                    qja.this.b.setTextColor(-16777216);
                    qja.this.b.setText(marker.getSnippet());
                    ((LinearLayout) qja.this.f19119a).setOrientation(1);
                    ((LinearLayout) qja.this.f19119a).addView(qja.this.f19120a);
                    ((LinearLayout) qja.this.f19119a).addView(qja.this.b);
                }
            } catch (Throwable th) {
                a7b.m(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return qja.this.f19119a;
        }
    }

    public class b implements AMap.CommonInfoWindowAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InfoWindowParams f44225a = null;

        public b() {
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f44225a == null) {
                    this.f44225a = new InfoWindowParams();
                    if (qja.this.f19118a == null) {
                        qja qjaVar = qja.this;
                        qjaVar.f19118a = mwa.c(qjaVar.f44223a, "infowindow_bg.9.png");
                    }
                    qja.this.f19119a = new LinearLayout(qja.this.f44223a);
                    qja.this.f19119a.setBackground(qja.this.f19118a);
                    qja.this.f19120a = new TextView(qja.this.f44223a);
                    qja.this.f19120a.setText("标题");
                    qja.this.f19120a.setTextColor(-16777216);
                    qja.this.b = new TextView(qja.this.f44223a);
                    qja.this.b.setTextColor(-16777216);
                    qja.this.b.setText("内容");
                    ((LinearLayout) qja.this.f19119a).setOrientation(1);
                    ((LinearLayout) qja.this.f19119a).addView(qja.this.f19120a);
                    ((LinearLayout) qja.this.f19119a).addView(qja.this.b);
                    this.f44225a.setInfoWindowType(2);
                    this.f44225a.setInfoWindow(qja.this.f19119a);
                }
                return this.f44225a;
            } catch (Throwable th) {
                a7b.m(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    }

    public qja(Context context) {
        this.f44223a = context;
    }

    public static void g(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !lwa.g()) {
            return;
        }
        String strY = zwa.Y(view);
        if (TextUtils.isEmpty(strY)) {
            return;
        }
        lwa.a().c(basePointOverlay.getPosition(), strY, "");
    }

    public static boolean t(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            return true;
        }
        Marker marker = new Marker(null, new MarkerOptions(), "check");
        return infoWindowAdapter.getInfoWindow(marker) == null && infoWindowAdapter.getInfoContents(marker) == null;
    }

    public final View c(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f19122a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            g(infoWindow, basePointOverlay);
            return infoWindow;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f19121a;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoWindow2 = infoWindowParams.getInfoWindow();
            g(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        InfoWindowParams infoWindowParams2 = this.f19126b.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public final BaseOverlay f(MotionEvent motionEvent) {
        IInfoWindowAction iInfoWindowActionY = y();
        if (iInfoWindowActionY == null || !iInfoWindowActionY.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.f19123a;
    }

    public final synchronized void h(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.f19121a = commonInfoWindowAdapter;
        this.f19122a = null;
        if (commonInfoWindowAdapter == null) {
            this.f19121a = this.f19126b;
            this.f19125a = true;
        } else {
            this.f19125a = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f19128b;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f19124a;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final synchronized void i(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.f19122a = infoWindowAdapter;
        this.f19121a = null;
        if (t(infoWindowAdapter)) {
            this.f19122a = this.f19127b;
            this.f19125a = true;
        } else {
            this.f19125a = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f19128b;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f19124a;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final void j(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction iInfoWindowActionY = y();
        if (iInfoWindowActionY == null || !(baseOverlay instanceof BasePointOverlay)) {
            return;
        }
        iInfoWindowActionY.showInfoWindow((BasePointOverlay) baseOverlay);
        this.f19123a = baseOverlay;
    }

    public final void k(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction iInfoWindowActionY = y();
        if (iInfoWindowActionY != null) {
            iInfoWindowActionY.showInfoWindow(baseOverlayImp);
        }
    }

    public final void l(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f19124a = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final void m(String str, String str2) {
        TextView textView = this.f19120a;
        if (textView != null) {
            textView.requestLayout();
            this.f19120a.setText(str);
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.requestLayout();
            this.b.setText(str2);
        }
        View view = this.f19119a;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final synchronized boolean n() {
        return this.f19125a;
    }

    public final View o(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f19122a;
        if (infoWindowAdapter != null) {
            View infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
            g(infoContents, basePointOverlay);
            return infoContents;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f19121a;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoContents2 = infoWindowParams.getInfoContents();
            g(infoContents2, basePointOverlay);
            return infoContents2;
        }
        InfoWindowParams infoWindowParams2 = this.f19126b.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public final void r() {
        IInfoWindowAction iInfoWindowActionY = y();
        if (iInfoWindowActionY != null) {
            iInfoWindowActionY.redrawInfoWindow();
        }
    }

    public final void s(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f19128b = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final long u(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f19122a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f19121a;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public final void w() {
        IInfoWindowAction iInfoWindowActionY = y();
        if (iInfoWindowActionY != null) {
            iInfoWindowActionY.hideInfoWindow();
        }
    }

    public final synchronized IInfoWindowAction y() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f19122a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.f19128b;
            }
            if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.f19128b;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f19121a;
        if (commonInfoWindowAdapter == null || commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() != 1) {
            return this.f19124a;
        }
        return this.f19128b;
    }
}
