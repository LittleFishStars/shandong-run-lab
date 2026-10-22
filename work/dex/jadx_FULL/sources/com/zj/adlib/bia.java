package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.ImageOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bia implements IGlOverlayLayer, AMapNativeGlOverlayLayer.NativeFunCallListener {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f15529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f15531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nsa f15533a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40757a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f15534a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BitmapDescriptor f15530a = null;
    public BitmapDescriptor b = null;
    public BitmapDescriptor c = null;
    public BitmapDescriptor d = null;
    public BitmapDescriptor e = null;
    public BitmapDescriptor f = null;
    public BitmapDescriptor g = null;
    public BitmapDescriptor h = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15538a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f15536a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, BaseOverlay> f15537a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Pair<BaseOverlay, BaseOptions>> f15535a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapNativeGlOverlayLayer f15532a = new AMapNativeGlOverlayLayer();

    public bia(IAMapDelegate iAMapDelegate, Context context) {
        this.f15531a = iAMapDelegate;
        this.f15529a = context;
        this.f15533a = new nsa(iAMapDelegate);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng) {
        if (latLng != null && circleOptions != null) {
            try {
                synchronized (circleOptions) {
                    List<BaseHoleOptions> holeOptions = circleOptions.getHoleOptions();
                    if (holeOptions != null && holeOptions.size() > 0) {
                        Iterator<BaseHoleOptions> it = holeOptions.iterator();
                        while (it.hasNext()) {
                            if (zwa.K(it.next(), latLng)) {
                                return false;
                            }
                        }
                    }
                    return circleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleOptions.getCenter(), latLng));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        try {
            List<BaseHoleOptions> holeOptions = polygonOptions.getHoleOptions();
            if (holeOptions != null && holeOptions.size() > 0) {
                Iterator<BaseHoleOptions> it = holeOptions.iterator();
                while (it.hasNext()) {
                    if (zwa.K(it.next(), latLng)) {
                        return false;
                    }
                }
            }
            return zwa.M(latLng, polygonOptions.getPoints());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final BitmapDescriptor a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.f15529a != null) {
            LinearLayout linearLayout = new LinearLayout(this.f15529a);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return BitmapDescriptorFactory.fromBitmap(zwa.n(view));
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay addOverlayObject(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        c(str, baseOverlay, baseOptions);
        return baseOverlay;
    }

    public final void b(String str, BaseOptions baseOptions) {
        try {
            this.f15532a.createOverlay(str, baseOptions);
        } catch (Throwable th) {
            a7b.m(th, "GlOverlayLayer", "addOverlay");
            th.printStackTrace();
            Log.d("amapApi", "GlOverlayLayer addOverlay error:" + th.getMessage());
        }
    }

    public final void c(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        b(str, baseOptions);
        synchronized (this.f15537a) {
            this.f15537a.put(str, baseOverlay);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void changeOverlayIndex() {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean checkInBounds(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "checkInBounds", new Object[]{str});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return true;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void clear(String... strArr) {
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
            if (aMapNativeGlOverlayLayer != null && strArr != null) {
                aMapNativeGlOverlayLayer.clear(strArr);
            }
            synchronized (this.f15537a) {
                try {
                    if (strArr != null) {
                        Iterator<Map.Entry<String, BaseOverlay>> it = this.f15537a.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String, BaseOverlay> next = it.next();
                            boolean z = false;
                            for (String str : strArr) {
                                if (str != null && str.equals(next.getKey())) {
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                it.remove();
                            }
                        }
                    } else {
                        this.f15537a.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            synchronized (this.f15535a) {
                this.f15535a.clear();
            }
        } catch (Throwable th2) {
            a7b.m(th2, "GlOverlayLayer", "clear");
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearOverlayByType(String str) {
        synchronized (this.f15537a) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, BaseOverlay>> it = this.f15537a.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key.contains(str)) {
                    it.remove();
                    arrayList.add(key);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                removeOverlay((String) it2.next());
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearTileCache() {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "clearTileCache", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final String createId(String str) {
        String str2;
        synchronized (this.f15534a) {
            this.f40757a++;
            str2 = str + this.f40757a;
        }
        return str2;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void destroy() {
        try {
            if (this.f15532a == null) {
                return;
            }
            synchronized (this.f15537a) {
                this.f15537a.clear();
            }
            synchronized (this.f15535a) {
                this.f15535a.clear();
            }
            this.f15532a.clear("");
            this.f15532a.destroy();
            this.f15532a = null;
        } catch (Throwable th) {
            a7b.m(th, "GlOverlayLayer", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized boolean draw(int i, int i2, boolean z) {
        boolean z2 = false;
        try {
            nsa nsaVar = this.f15533a;
            if (nsaVar != null) {
                nsaVar.a();
            }
            if (this.f15531a.getMapConfig() == null) {
                return false;
            }
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
            if (aMapNativeGlOverlayLayer != null) {
                aMapNativeGlOverlayLayer.render(i, i2, z);
            }
            z2 = true;
        } catch (Throwable th) {
            a7b.m(th, "GlOverlayLayer", MediationConstant.RIT_TYPE_DRAW);
        }
        return z2;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getBuildInImageData(int i) {
        try {
            switch (i) {
                case 0:
                    BitmapDescriptor bitmapDescriptor = this.f15530a;
                    if (bitmapDescriptor == null || bitmapDescriptor.getBitmap().isRecycled()) {
                        this.f15530a = BitmapDescriptorFactory.fromBitmap(zwa.l(this.f15529a, "amap_sdk_lineTexture.png"));
                    }
                    return this.f15530a;
                case 1:
                    BitmapDescriptor bitmapDescriptor2 = this.d;
                    if (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap().isRecycled()) {
                        this.d = BitmapDescriptorFactory.fromBitmap(zwa.l(this.f15529a, "amap_sdk_lineTexture.png"));
                    }
                    return this.d;
                case 2:
                    BitmapDescriptor bitmapDescriptor3 = this.c;
                    if (bitmapDescriptor3 == null || bitmapDescriptor3.getBitmap().isRecycled()) {
                        this.c = BitmapDescriptorFactory.fromBitmap(zwa.l(this.f15529a, "amap_sdk_lineDashTexture_circle.png"));
                    }
                    return this.c;
                case 3:
                    BitmapDescriptor bitmapDescriptor4 = this.b;
                    if (bitmapDescriptor4 == null || bitmapDescriptor4.getBitmap().isRecycled()) {
                        this.b = BitmapDescriptorFactory.fromBitmap(zwa.l(this.f15529a, "amap_sdk_lineDashTexture_square.png"));
                    }
                    return this.b;
                case 4:
                    BitmapDescriptor bitmapDescriptor5 = this.e;
                    if (bitmapDescriptor5 == null || bitmapDescriptor5.getBitmap().isRecycled()) {
                        this.e = BitmapDescriptorFactory.defaultMarker();
                    }
                    return this.e;
                case 5:
                    BitmapDescriptor bitmapDescriptor6 = this.f;
                    if (bitmapDescriptor6 == null || bitmapDescriptor6.getBitmap().isRecycled()) {
                        this.f = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
                    }
                    return this.f;
                case 6:
                    BitmapDescriptor bitmapDescriptor7 = this.g;
                    if (bitmapDescriptor7 == null || bitmapDescriptor7.getBitmap().isRecycled()) {
                        this.g = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
                    }
                    return this.g;
                case 7:
                    BitmapDescriptor bitmapDescriptor8 = this.h;
                    if (bitmapDescriptor8 == null || bitmapDescriptor8.getBitmap().isRecycled()) {
                        this.h = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
                    }
                    return this.h;
                default:
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final int getCurrentParticleNum(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getCurrentParticleNum(str);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getCustomImageData(ImageOptions imageOptions) {
        if (imageOptions == null) {
            return null;
        }
        if (imageOptions.type == ImageOptions.ShapeType.CIRCLE.value()) {
            float f = imageOptions.radius;
            if (f == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return null;
            }
            float fA = twa.a(this.f15529a, (int) f);
            int i = ((int) fA) * 2;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Path path = new Path();
            path.addCircle(fA, fA, fA, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawColor(imageOptions.color);
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
            return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
        }
        if (imageOptions.type == ImageOptions.ShapeType.TEXT.value()) {
            String str = imageOptions.content;
            int i2 = imageOptions.fontSize;
            if (str.isEmpty()) {
                return null;
            }
            float fA2 = twa.a(this.f15529a, i2);
            Paint paint2 = new Paint();
            paint2.setTextSize(fA2);
            paint2.setFakeBoldText(true);
            paint2.setColor(imageOptions.color);
            float fMeasureText = paint2.measureText(str);
            Rect rect = new Rect();
            paint2.getTextBounds(str, 0, str.length(), rect);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap((int) fMeasureText, rect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            canvas2.save();
            canvas2.drawColor(0);
            canvas2.drawText(str, 0.0f, -rect.top, paint2);
            canvas2.restore();
            return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap2);
        }
        if (imageOptions.type != ImageOptions.ShapeType.DEFAULT.value()) {
            return null;
        }
        float f2 = imageOptions.radius;
        if (f2 == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return null;
        }
        float fA3 = twa.a(this.f15529a, (int) f2);
        int i3 = (int) fA3;
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        Canvas canvas3 = new Canvas(bitmapCreateBitmap3);
        Path path2 = new Path();
        path2.addRect(0.0f, 0.0f, fA3, fA3, Path.Direction.CW);
        canvas3.clipPath(path2);
        double[] dArr = imageOptions.rgba;
        canvas3.drawColor(Color.argb((float) dArr[3], (float) dArr[0], (float) dArr[1], (float) dArr[2]));
        canvas3.drawBitmap(bitmapCreateBitmap3, 0.0f, 0.0f, paint3);
        return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap3);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized BaseOverlay getHitBaseOverlay(LatLng latLng, int i) {
        BaseOverlay baseOverlay;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer == null) {
            return null;
        }
        String strContain = aMapNativeGlOverlayLayer.contain(latLng, i);
        if (TextUtils.isEmpty(strContain)) {
            return null;
        }
        synchronized (this.f15537a) {
            baseOverlay = this.f15537a.get(strContain);
        }
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized Polyline getHitOverlay(LatLng latLng, int i) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        Polyline polyline = null;
        if (aMapNativeGlOverlayLayer != null) {
            String strContain = aMapNativeGlOverlayLayer.contain(latLng, i);
            if (TextUtils.isEmpty(strContain)) {
                return null;
            }
            synchronized (this.f15537a) {
                BaseOverlay baseOverlay = this.f15537a.get(strContain);
                polyline = baseOverlay instanceof Polyline ? (Polyline) baseOverlay : null;
            }
        }
        return polyline;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoContents(String str) {
        qja infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f15531a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f15537a.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.o((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindow(String str) {
        qja infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f15531a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f15537a.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.c((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindowClick(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final long getInfoWindowUpdateOffsetTime(String str) {
        qja infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f15531a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return 0L;
        }
        BaseOverlay baseOverlay = this.f15537a.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return infoWindowDelegate.u((BasePointOverlay) baseOverlay);
        }
        return 0L;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final IAMapDelegate getMap() {
        return this.f15531a;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final List<Marker> getMapScreenMarkers() {
        if (this.f15532a == null) {
            return null;
        }
        this.f15536a.clear();
        this.f15532a.getNativeProperties("", "getMapScreenOverlays", new Object[]{this.f15536a});
        if (this.f15536a.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f15536a) {
            if (str != null && str.contains("MARKER")) {
                arrayList.add((Marker) this.f15537a.get(str));
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getMarkerInfoWindowOffset(String str, FPoint fPoint) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "getMarkerInfoWindowOffset", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final MultiPointItem getMultiPointItem(LatLng latLng) {
        List<MultiPointItem> items;
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
            if (aMapNativeGlOverlayLayer == null) {
                return null;
            }
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties("", "getMultiPointItem", new LatLng[]{latLng});
            if (!(nativeProperties instanceof MultiPointItemHitTest)) {
                return null;
            }
            MultiPointItemHitTest multiPointItemHitTest = (MultiPointItemHitTest) nativeProperties;
            if (multiPointItemHitTest.index == -1) {
                return null;
            }
            BaseOverlay baseOverlay = this.f15537a.get(multiPointItemHitTest.overlayName);
            if (!(baseOverlay instanceof MultiPointOverlay) || (items = ((MultiPointOverlay) baseOverlay).getItems()) == null) {
                return null;
            }
            int size = items.size();
            int i = multiPointItemHitTest.index;
            if (size > i) {
                return items.get(i);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final Object getNativeProperties(String str, String str2, Object[] objArr) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getNativeProperties(str, str2, objArr);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        List<LatLng> points;
        if (latLng != null && polylineOptions != null && (points = polylineOptions.getPoints()) != null && points.size() != 0) {
            float fCalculateLineDistance = 0.0f;
            int i = 0;
            for (int i2 = 0; i2 < points.size(); i2++) {
                try {
                    if (i2 == 0) {
                        fCalculateLineDistance = AMapUtils.calculateLineDistance(latLng, points.get(i2));
                    } else {
                        float fCalculateLineDistance2 = AMapUtils.calculateLineDistance(latLng, points.get(i2));
                        if (fCalculateLineDistance > fCalculateLineDistance2) {
                            i = i2;
                            fCalculateLineDistance = fCalculateLineDistance2;
                        }
                    }
                } catch (Throwable th) {
                    a7b.m(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getOverlayScreenPos(String str, FPoint fPoint) {
        if (this.f15537a.get(str) instanceof BasePointOverlay) {
            Object nativeProperties = this.f15532a.getNativeProperties(str, "getMarkerScreenPos", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindow(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindowClick(String str) {
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void hideInfoWindow(String str) {
        if (this.f15532a != null) {
            this.f15531a.hideInfoWindow();
            this.f15532a.getNativeProperties(str, "setInfoWindowShown", new Object[]{Boolean.FALSE});
        }
        setRunLowFrame(false);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean isGLTFAnimated() {
        for (Map.Entry<String, BaseOverlay> entry : this.f15537a.entrySet()) {
            String key = entry.getKey();
            BaseOverlay value = entry.getValue();
            if (key.contains("GLTFOVERLAY") && ((GLTFOverlay) value).isAnimated()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void onCreateAMapInstance() {
        if (this.f15532a == null) {
            this.f15532a = new AMapNativeGlOverlayLayer();
        }
        this.f15532a.setEngineId(this.f15531a.getNativeEngineID());
        this.f15532a.createNative(this.f15531a.getGLMapEngine().getNativeInstance());
        this.f15532a.setNativeFunCallListener(this);
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onRedrawInfowindow() {
        IAMapDelegate iAMapDelegate = this.f15531a;
        if (iAMapDelegate != null) {
            iAMapDelegate.redrawInfoWindow();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onSetRunLowFrame(boolean z) {
        setRunLowFrame(z);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str) {
        boolean z;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.removeOverlay(str);
            z = true;
        } else {
            z = false;
        }
        synchronized (this.f15537a) {
            this.f15537a.remove(str);
        }
        return z;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str, boolean z) {
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void set2Top(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties(str, "set2Top", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setFlingState(boolean z) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f15532a;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "setFlingState", new Object[]{Boolean.valueOf(z)});
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setRunLowFrame(boolean z) {
        IAMapDelegate iAMapDelegate = this.f15531a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void showInfoWindow(String str) {
        Map<String, BaseOverlay> map;
        if (this.f15532a == null || (map = this.f15537a) == null) {
            return;
        }
        try {
            this.f15531a.showInfoWindow(map.get(str));
            setRunLowFrame(false);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void updateOption(String str, BaseOptions baseOptions) {
        try {
            if (this.f15532a == null) {
                return;
            }
            setRunLowFrame(false);
            this.f15532a.updateOptions(str, baseOptions);
        } catch (Throwable th) {
            a7b.m(th, "GlOverlayLayer", "updateOption");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay getHitBaseOverlay(MotionEvent motionEvent, int i) {
        if (this.f15531a == null) {
            return null;
        }
        DPoint dPointObtain = DPoint.obtain();
        this.f15531a.getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), dPointObtain);
        LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
        dPointObtain.recycle();
        return getHitBaseOverlay(latLng, i);
    }
}
