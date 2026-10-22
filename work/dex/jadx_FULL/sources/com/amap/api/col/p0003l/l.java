package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.GLTFOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.zj.adlib.a7b;
import com.zj.adlib.ava;
import com.zj.adlib.axa;
import com.zj.adlib.bia;
import com.zj.adlib.bmb;
import com.zj.adlib.bxa;
import com.zj.adlib.cnb;
import com.zj.adlib.dva;
import com.zj.adlib.eob;
import com.zj.adlib.hia;
import com.zj.adlib.j4b;
import com.zj.adlib.jsa;
import com.zj.adlib.kja;
import com.zj.adlib.lwa;
import com.zj.adlib.pia;
import com.zj.adlib.pja;
import com.zj.adlib.psa;
import com.zj.adlib.pwa;
import com.zj.adlib.qja;
import com.zj.adlib.qsa;
import com.zj.adlib.qwa;
import com.zj.adlib.qwb;
import com.zj.adlib.ssa;
import com.zj.adlib.svb;
import com.zj.adlib.swa;
import com.zj.adlib.sxb;
import com.zj.adlib.wia;
import com.zj.adlib.wsa;
import com.zj.adlib.xwa;
import com.zj.adlib.yua;
import com.zj.adlib.zwa;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class l implements cu.a, com.amap.api.col.3l.k.a, IAMapDelegate, IAMapListener {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Point f960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.amap.api.col.p0003l.c0 f963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cs f964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cu f965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ei f966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.amap.api.col.p0003l.k f967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r0 f969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMap.OnMultiPointClickListener f970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CustomRenderer f971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationSource f972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public UiSettings f973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IGlOverlayLayer f974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapGestureListener f975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GLTFOverlay f976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Marker f977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MyTrafficStyle f978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GLMapEngine f979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GLMapRender f980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EAMapPlatformGestureInfo f981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IGLSurfaceView f982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IProjectionDelegate f983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MapConfig f984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.autonavi.extra.b f985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bmb f986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cnb f987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jsa f988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pja f989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qja f990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qwa f991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ssa f992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public svb f993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wia f994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Thread f997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<hia> f998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicBoolean f999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Lock f1000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f1002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IPoint[] f1003a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1004b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f1005b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public a f1006b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public pja f1007b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f1008b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Thread f1009b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1010b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float[] f1011b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f1012c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f1013c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public a f1014c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f1015c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1016c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float[] f1017c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public a f1018d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f1019d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1020d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public float[] f1021d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public a f1022e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f1023e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1024e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public a f1025f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f1026f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public a f1027g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f1028g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public a f1029h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f1030h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public a f1031i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f1032i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public a f1033j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f1034j;
    public int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public a f1035k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f1036k;
    public int l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public a f1037l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f1038l;
    public int m;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public a f1039m;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public boolean f1040m;
    public a n;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public boolean f1041n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public volatile boolean u;
    public volatile boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class a0 implements Runnable {
        public a0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVar = l.this;
            GLMapEngine gLMapEngine = lVar.f979a;
            if (gLMapEngine != null) {
                int i = lVar.f957a;
                pja pjaVar = l.this.f989a;
                gLMapEngine.setIndoorBuildingToBeActive(i, pjaVar.activeFloorName, pjaVar.activeFloorIndex, pjaVar.poiid);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f25990a;
        public final /* synthetic */ double b;

        public b(double d, double d2) {
            this.f25990a = d;
            this.b = d2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message messageObtain = Message.obtain();
            messageObtain.what = 19;
            messageObtain.arg1 = (int) this.f25990a;
            messageObtain.arg2 = (int) this.b;
            l.this.f962a.sendMessage(messageObtain);
        }
    }

    public class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (l.this.f969a != null) {
                l.this.f969a.a(l.this.f1007b);
            }
        }
    }

    public class c extends a {
        public c() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setTrafficEnabled(this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class c0 implements Runnable {
        public c0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l lVar = l.this;
                lVar.destroySurface(lVar.f957a);
                if (l.this.f974a != null) {
                    l.this.f974a.destroy();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                zwa.D(th);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ed f25994a;

        public d(ed edVar) {
            this.f25994a = edVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (l.this.f1020d) {
                return;
            }
            try {
                l lVar = l.this;
                pja pjaVar = lVar.f989a;
                if (pjaVar != null) {
                    lVar.setIndoorBuildingInfo(pjaVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f25994a.a();
        }
    }

    public class d0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CrossVectorOverlay f1046a;

        public d0(CrossVectorOverlay crossVectorOverlay) {
            this.f1046a = crossVectorOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            l lVar = l.this;
            GLMapEngine gLMapEngine = lVar.f979a;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(lVar.f957a)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f1046a);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int K;

        public e(int i) {
            this.K = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine;
            if (!l.this.u || (gLMapEngine = l.this.f979a) == null) {
                return;
            }
            gLMapEngine.setHighlightSubwayEnable(this.K, false);
        }
    }

    public class e0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BaseMapOverlay f1047a;

        public e0(BaseMapOverlay baseMapOverlay) {
            this.f1047a = baseMapOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVar = l.this;
            lVar.f979a.getOverlayBundle(lVar.f957a).removeOverlay(this.f1047a);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;
        public final /* synthetic */ int M;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1048a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ StyleItem[] f1049a;

        public f(int i, int i2, int i3, boolean z, StyleItem[] styleItemArr) {
            this.K = i;
            this.L = i2;
            this.M = i3;
            this.f1048a = z;
            this.f1049a = styleItemArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l.this.f979a.setMapModeAndStyle(this.K, this.L, this.M, this.f1048a, this.f1049a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class f0 extends a {
        public f0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            l.this.setMapCustomEnable(this.b);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ int K;

        public g(int i) {
            this.K = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l.this.f979a.clearAllMessages(this.K);
                l.this.f979a.clearAnimations(this.K, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class g0 extends a {
        public g0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            l.this.k(this.M, this.b);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1050a;

        public h(int i, boolean z) {
            this.K = i;
            this.f1050a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l.this.f979a.setBuildingEnable(this.K, this.f1050a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class h0 extends a {
        public h0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setTrafficStyleWithTextureData(((a) this).f1043a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1051a;

        public i(boolean z, int i) {
            this.f1051a = z;
            this.K = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine = l.this.f979a;
            if (gLMapEngine != null) {
                if (this.f1051a) {
                    gLMapEngine.setAllContentEnable(this.K, true);
                } else {
                    gLMapEngine.setAllContentEnable(this.K, false);
                }
                l.this.f979a.setSimple3DEnable(this.K, false);
            }
        }
    }

    public class i0 extends a {
        public i0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setMapTextEnable(this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1052a;

        public j(boolean z, int i) {
            this.f1052a = z;
            this.K = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f1052a) {
                    l.this.f979a.setBuildingTextureEnable(this.K, true);
                } else {
                    l.this.f979a.setBuildingTextureEnable(this.K, false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class j0 extends a {
        public j0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setRoadArrowEnable(this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ LatLngBounds.Builder f1053a;

        public k(LatLngBounds.Builder builder) {
            this.f1053a = builder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l.this.moveCamera(kja.i(this.f1053a.build(), 50));
            } catch (Throwable unused) {
            }
        }
    }

    public class k0 extends a {
        public k0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setNaviLabelEnable(this.b, this.N, this.O);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.amap.api.col.3l.l$l, reason: collision with other inner class name */
    public class HandlerC0248l extends Handler {
        public HandlerC0248l(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            el elVarF;
            if (message == null || l.this.f999a.get()) {
                return;
            }
            try {
                int i = message.what;
                if (i == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Key验证失败：[");
                    Object obj = message.obj;
                    if (obj != null) {
                        sb.append(obj);
                    } else {
                        sb.append(fh.f839a);
                    }
                    sb.append("]");
                    Log.w("amapsdk", sb.toString());
                    return;
                }
                int i2 = 0;
                switch (i) {
                    case 10:
                        CameraPosition cameraPosition = (CameraPosition) message.obj;
                        try {
                            List listA = l.this.f987a.a(AMap.OnCameraChangeListener.class.hashCode());
                            if (cameraPosition != null && listA != null && listA.size() > 0) {
                                synchronized (listA) {
                                    try {
                                        Iterator it = listA.iterator();
                                        while (it.hasNext()) {
                                            ((AMap.OnCameraChangeListener) it.next()).onCameraChange(cameraPosition);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                            break;
                        } catch (Throwable th2) {
                            zwa.D(th2);
                        }
                        l.this.f984a.addChangedCounter();
                        return;
                    case 11:
                        try {
                            CameraPosition cameraPosition2 = l.this.getCameraPosition();
                            if (cameraPosition2 != null && l.this.f966a != null) {
                                l.this.f966a.a(cameraPosition2);
                            }
                            l.this.B(cameraPosition2);
                            if (l.this.t) {
                                l.U(l.this);
                                if (l.this.f974a != null) {
                                    l.this.f974a.setFlingState(false);
                                }
                                l.this.w();
                            }
                            if (l.this.f1038l) {
                                l.this.redrawInfoWindow();
                                l.e0(l.this);
                            }
                            l.this.a(cameraPosition2);
                            return;
                        } catch (Throwable th3) {
                            a7b.m(th3, "AMapDelegateImp", "CameraUpdateFinish");
                            zwa.D(th3);
                            return;
                        }
                    case 12:
                        if (l.this.f966a != null) {
                            l.this.f966a.a(Float.valueOf(l.this.getZoomLevel()));
                            return;
                        }
                        return;
                    case 13:
                        if (l.this.f966a != null) {
                            l.this.f966a.h();
                            return;
                        }
                        return;
                    case 14:
                        try {
                            List listA2 = l.this.f987a.a(AMap.OnMapTouchListener.class.hashCode());
                            if (listA2 == null || listA2.size() <= 0) {
                                return;
                            }
                            synchronized (listA2) {
                                try {
                                    Iterator it2 = listA2.iterator();
                                    while (it2.hasNext()) {
                                        ((AMap.OnMapTouchListener) it2.next()).onTouch((MotionEvent) message.obj);
                                    }
                                } catch (Throwable th4) {
                                    throw th4;
                                }
                                break;
                            }
                            return;
                        } catch (Throwable th5) {
                            a7b.m(th5, "AMapDelegateImp", "onTouchHandler");
                            th5.printStackTrace();
                            return;
                        }
                    case 15:
                        Bitmap bitmap = (Bitmap) message.obj;
                        int i3 = message.arg1;
                        if (bitmap == null || l.this.f966a == null) {
                            try {
                                List listA3 = l.this.f987a.a(AMap.onMapPrintScreenListener.class.hashCode());
                                ArrayList arrayList = listA3 != null ? new ArrayList(listA3) : null;
                                List listA4 = l.this.f987a.a(AMap.OnMapScreenShotListener.class.hashCode());
                                ArrayList arrayList2 = listA4 != null ? new ArrayList(listA4) : null;
                                l.this.f987a.d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                l.this.f987a.d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                if (arrayList != null && arrayList.size() > 0) {
                                    synchronized (arrayList) {
                                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                            ((AMap.onMapPrintScreenListener) arrayList.get(i4)).onMapPrint(null);
                                        }
                                        break;
                                    }
                                }
                                if (arrayList2 == null || arrayList2.size() <= 0) {
                                    return;
                                }
                                synchronized (arrayList2) {
                                    while (i2 < arrayList2.size()) {
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i2)).onMapScreenShot(null);
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i2)).onMapScreenShot(null, i3);
                                        i2++;
                                    }
                                    break;
                                }
                                return;
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                                return;
                            }
                        }
                        Canvas canvas = new Canvas(bitmap);
                        if (l.this.f1040m && (elVarF = l.this.f966a.f()) != null) {
                            elVarF.onDraw(canvas);
                        }
                        l.this.f966a.a(canvas);
                        try {
                            List listA5 = l.this.f987a.a(AMap.onMapPrintScreenListener.class.hashCode());
                            ArrayList arrayList3 = listA5 != null ? new ArrayList(listA5) : null;
                            List listA6 = l.this.f987a.a(AMap.OnMapScreenShotListener.class.hashCode());
                            ArrayList arrayList4 = listA6 != null ? new ArrayList(listA6) : null;
                            l.this.f987a.d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                            l.this.f987a.d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                            if (arrayList3 != null && arrayList3.size() > 0) {
                                synchronized (arrayList3) {
                                    for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                                        ((AMap.onMapPrintScreenListener) arrayList3.get(i5)).onMapPrint(new BitmapDrawable(l.this.f959a.getResources(), bitmap));
                                    }
                                    break;
                                }
                            }
                            if (arrayList4 == null || arrayList4.size() <= 0) {
                                return;
                            }
                            synchronized (arrayList4) {
                                while (i2 < arrayList4.size()) {
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i2)).onMapScreenShot(bitmap);
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i2)).onMapScreenShot(bitmap, i3);
                                    i2++;
                                }
                                break;
                            }
                            return;
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                            return;
                        }
                    case 16:
                        try {
                            List listA7 = l.this.f987a.a(AMap.OnMapLoadedListener.class.hashCode());
                            if (listA7 != null) {
                                synchronized (listA7) {
                                    while (i2 < listA7.size()) {
                                        try {
                                            ((AMap.OnMapLoadedListener) listA7.get(i2)).onMapLoaded();
                                            i2++;
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                            }
                            break;
                        } catch (Throwable th9) {
                            a7b.m(th9, "AMapDelegateImp", "onMapLoaded");
                            th9.printStackTrace();
                            zwa.D(th9);
                        }
                        if (l.this.f966a != null) {
                            l.this.f966a.i();
                            return;
                        }
                        return;
                    case 17:
                        l lVar = l.this;
                        if (!lVar.f979a.isInMapAnimation(lVar.f957a) || l.this.f974a == null) {
                            return;
                        }
                        l.this.f974a.setFlingState(false);
                        return;
                    case 18:
                        if (l.this.f990a != null) {
                            l.this.f990a.r();
                            return;
                        }
                        return;
                    case 19:
                        List listA8 = l.this.f987a.a(AMap.OnMapClickListener.class.hashCode());
                        if (listA8 != null) {
                            DPoint dPointObtain = DPoint.obtain();
                            l.this.getPixel2LatLng(message.arg1, message.arg2, dPointObtain);
                            try {
                                synchronized (listA8) {
                                    Iterator it3 = listA8.iterator();
                                    while (it3.hasNext()) {
                                        ((AMap.OnMapClickListener) it3.next()).onMapClick(new LatLng(dPointObtain.y, dPointObtain.x));
                                    }
                                    break;
                                }
                                dPointObtain.recycle();
                                return;
                            } catch (Throwable th10) {
                                a7b.m(th10, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                                th10.printStackTrace();
                                return;
                            }
                        }
                        return;
                    case 20:
                        try {
                            List listA9 = l.this.f987a.a(AMap.OnPOIClickListener.class.hashCode());
                            if (listA9 == null || listA9.size() <= 0) {
                                return;
                            }
                            synchronized (listA9) {
                                while (i2 < listA9.size()) {
                                    try {
                                        ((AMap.OnPOIClickListener) listA9.get(i2)).onPOIClick((Poi) message.obj);
                                        i2++;
                                    } catch (Throwable th11) {
                                        throw th11;
                                    }
                                    break;
                                }
                                break;
                            }
                            return;
                        } catch (Throwable th12) {
                            a7b.m(th12, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                            th12.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
                a7b.m(th, "AMapDelegateImp", "handleMessage");
                th.printStackTrace();
            } catch (Throwable th13) {
                a7b.m(th13, "AMapDelegateImp", "handleMessage");
                th13.printStackTrace();
            }
        }
    }

    public class l0 extends a {
        public l0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setTrafficStyleWithTexture(((a) this).f1043a, ((a) this).f25988a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVar = l.this;
            if (lVar.f979a == null || lVar.f999a.get()) {
                return;
            }
            l lVar2 = l.this;
            lVar2.f979a.removeNativeAllOverlay(lVar2.f957a);
        }
    }

    public class m0 extends a {
        public m0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            l.this.y(this.M, this.b);
        }
    }

    public class n extends a {
        public n() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l lVar = l.this;
                lVar.setCenterToPixel(lVar.j, l.this.k);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class n0 extends a {
        public n0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setIndoorEnabled(this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1054a;
        public final /* synthetic */ boolean b;

        public o(boolean z, boolean z2) {
            this.f1054a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (l.this.f984a.isTrafficEnabled() != this.f1054a) {
                    l.this.f984a.setTrafficEnabled(this.b);
                    l.this.f980a.setTrafficMode(this.f1054a);
                    l lVar = l.this;
                    lVar.f979a.setTrafficEnable(lVar.f957a, this.f1054a);
                    l.this.resetRenderTime();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                zwa.D(th);
            }
        }
    }

    public class o0 implements Runnable {
        public o0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            el elVarF;
            if (l.this.f966a == null || (elVarF = l.this.f966a.f()) == null) {
                return;
            }
            elVarF.c();
        }
    }

    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1055a;

        public p(boolean z) {
            this.f1055a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f1055a) {
                l.this.showIndoorSwitchControlsEnabled(true);
            } else if (l.this.f966a != null) {
                l.this.f966a.i(Boolean.FALSE);
            }
        }
    }

    public class p0 extends a {
        public p0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            l.this.G(this.M, this.b);
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1056a;

        public q(boolean z) {
            this.f1056a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVar = l.this;
            GLMapEngine gLMapEngine = lVar.f979a;
            if (gLMapEngine != null) {
                gLMapEngine.setOfflineDataEnable(lVar.f957a, this.f1056a);
            }
        }
    }

    public class q0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionEvent f26021a;

        public q0(MotionEvent motionEvent) {
            this.f26021a = motionEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l.this.f979a.addGestureSingleTapMessage(this.f26021a.getX(), this.f26021a.getY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1058a;

        public r(boolean z) {
            this.f1058a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l lVar = l.this;
                lVar.f979a.setLabelEnable(lVar.f957a, this.f1058a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class r0 {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ef f26024a;

            public a(ef efVar) {
                this.f26024a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f26024a.a(false);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ef f26025a;

            public b(ef efVar) {
                this.f26025a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f26025a.a(l.this.f989a.floor_names);
                    this.f26025a.a(l.this.f989a.activeFloorName);
                    if (this.f26025a.b()) {
                        return;
                    }
                    this.f26025a.a(true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public r0() {
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x00c9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(pja pjaVar) {
            List listA;
            List listA2;
            pja pjaVar2;
            pja pjaVar3;
            int[] iArr;
            String[] strArr;
            MapConfig mapConfig = l.this.f984a;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            ef efVarE = l.this.f966a.e();
            if (pjaVar == null) {
                try {
                    List listA3 = l.this.f987a.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (listA3 != null && listA3.size() > 0) {
                        synchronized (listA3) {
                            for (int i = 0; i < listA3.size(); i++) {
                                try {
                                    ((AMap.OnIndoorBuildingActiveListener) listA3.get(i)).OnIndoorBuilding(pjaVar);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                pja pjaVar4 = l.this.f989a;
                if (pjaVar4 != null) {
                    pjaVar4.f18867a = null;
                }
                if (efVarE.b()) {
                    l.this.f962a.post(new a(efVarE));
                }
                MapConfig mapConfig2 = l.this.f984a;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? l.this.f984a.getMaxZoomLevel() : 20.0f;
                if (!l.this.f994a.isZoomControlsEnabled() || (listA = l.this.f987a.a(AMapWidgetListener.class.hashCode())) == null || listA.size() <= 0) {
                    return;
                }
                synchronized (listA) {
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        try {
                            ((AMapWidgetListener) listA.get(i2)).invalidateZoomController(l.this.f984a.getSZ());
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
                return;
            }
            if (pjaVar != null && (iArr = pjaVar.floor_indexs) != null && (strArr = pjaVar.floor_names) != null && iArr.length == strArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = pjaVar.floor_indexs;
                    if (i3 >= iArr2.length) {
                        break;
                    }
                    if (pjaVar.activeFloorIndex == iArr2[i3]) {
                        pjaVar.activeFloorName = pjaVar.floor_names[i3];
                        break;
                    }
                    i3++;
                }
            }
            if (pjaVar == null || (pjaVar3 = l.this.f989a) == null || pjaVar3.activeFloorIndex == pjaVar.activeFloorIndex || !efVarE.b()) {
                if (pjaVar != null && ((pjaVar2 = l.this.f989a) == null || !pjaVar2.poiid.equals(pjaVar.poiid) || l.this.f989a.f18867a == null)) {
                    l lVar = l.this;
                    lVar.f989a = pjaVar;
                    if (lVar.f984a != null) {
                        if (pjaVar.f18867a == null) {
                            pjaVar.f18867a = new Point();
                        }
                        DPoint mapGeoCenter = l.this.f984a.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            Point point = l.this.f989a.f18867a;
                            point.x = (int) mapGeoCenter.x;
                            point.y = (int) mapGeoCenter.y;
                        }
                    }
                }
                try {
                    List listA4 = l.this.f987a.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (listA4 != null && listA4.size() > 0) {
                        synchronized (listA4) {
                            for (int i4 = 0; i4 < listA4.size(); i4++) {
                                ((AMap.OnIndoorBuildingActiveListener) listA4.get(i4)).OnIndoorBuilding(pjaVar);
                            }
                        }
                    }
                    MapConfig mapConfig3 = l.this.f984a;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? l.this.f984a.getMaxZoomLevel() : 20.0f;
                    if (l.this.f994a.isZoomControlsEnabled() && (listA2 = l.this.f987a.a(AMapWidgetListener.class.hashCode())) != null && listA2.size() > 0) {
                        synchronized (listA2) {
                            for (int i5 = 0; i5 < listA2.size(); i5++) {
                                ((AMapWidgetListener) listA2.get(i5)).invalidateZoomController(l.this.f984a.getSZ());
                            }
                        }
                    }
                    if (l.this.f994a.isIndoorSwitchEnabled()) {
                        if (!efVarE.b()) {
                            l.this.f994a.setIndoorSwitchEnabled(true);
                        }
                        l.this.f962a.post(new b(efVarE));
                    } else {
                        if (l.this.f994a.isIndoorSwitchEnabled() || !efVarE.b()) {
                            return;
                        }
                        l.this.f994a.setIndoorSwitchEnabled(false);
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        }
    }

    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1061a;

        public s(boolean z) {
            this.f1061a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l lVar = l.this;
                lVar.f979a.setRoadArrowEnable(lVar.f957a, this.f1061a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class s0 implements ef.a {
        public s0() {
        }

        @Override // com.amap.api.col.3l.ef.a
        public final void a(int i) {
            l lVar = l.this;
            pja pjaVar = lVar.f989a;
            if (pjaVar != null) {
                pjaVar.activeFloorIndex = pjaVar.floor_indexs[i];
                pjaVar.activeFloorName = pjaVar.floor_names[i];
                try {
                    lVar.setIndoorBuildingInfo(pjaVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        public /* synthetic */ s0(l lVar, byte b) {
            this();
        }
    }

    public class t implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1062a;

        public t(boolean z, int i, int i2) {
            this.f1062a = z;
            this.K = i;
            this.L = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l lVar = l.this;
                lVar.f979a.setNaviLabelEnable(lVar.f957a, this.f1062a, this.K, this.L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class t0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f26029a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public AMap.OnCacheRemoveListener f1064a;

        public t0(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f26029a = context;
            this.f1064a = onCacheRemoveListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof t0;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0033  */
        /* JADX WARN: Code duplicated, block: B:19:0x003d  */
        /* JADX WARN: Code duplicated, block: B:22:0x0046 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0002, B:5:0x001b, B:20:0x003e, B:22:0x0046), top: B:57:0x0002 }] */
        @Override // java.lang.Runnable
        public final void run() {
            AMap.OnCacheRemoveListener onCacheRemoveListener;
            AMap.OnCacheRemoveListener onCacheRemoveListener2;
            boolean z = true;
            Context applicationContext = this.f26029a.getApplicationContext();
            String strF0 = zwa.f0(applicationContext);
            String strV = zwa.v(applicationContext);
            File file = new File(strF0);
            boolean zDeleteFile = file.exists() ? FileUtil.deleteFile(file) : true;
            if (!zDeleteFile) {
                zDeleteFile = false;
                if (zDeleteFile) {
                }
                if (l.this.f974a != null) {
                    l.this.f974a.clearTileCache();
                }
                if (l.this.f979a != null) {
                    return;
                } else {
                    return;
                }
            }
            try {
                if (FileUtil.deleteFile(new File(strV))) {
                    zDeleteFile = true;
                } else {
                    zDeleteFile = false;
                }
                z = !zDeleteFile && zwa.i0(applicationContext);
                if (l.this.f974a != null) {
                    l.this.f974a.clearTileCache();
                }
                try {
                    if (l.this.f979a != null || (onCacheRemoveListener2 = this.f1064a) == null) {
                        return;
                    }
                    onCacheRemoveListener2.onRemoveCacheFinish(z);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                z = zDeleteFile;
            }
            try {
                zwa.D(th);
                a7b.m(th, "AMapDelegateImp", "RemoveCacheRunnable");
                try {
                    if (l.this.f979a == null || r1 == null) {
                        return;
                    }
                    this.f1064a.onRemoveCacheFinish(false);
                } catch (Throwable th3) {
                }
            } finally {
                try {
                    if (l.this.f979a != null && (onCacheRemoveListener = this.f1064a) != null) {
                        onCacheRemoveListener.onRemoveCacheFinish(z);
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        }
    }

    public class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1065a;

        public u(boolean z) {
            this.f1065a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l.this.f979a.setMapOpenLayerEnable(this.f1065a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MyTrafficStyle f1066a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ byte[] f1067a;

        public v(byte[] bArr, MyTrafficStyle myTrafficStyle) {
            this.f1067a = bArr;
            this.f1066a = myTrafficStyle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l lVar = l.this;
                lVar.f979a.setTrafficStyleWithTexture(lVar.f957a, this.f1067a, this.f1066a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class w extends a {
        public w() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                l.this.setConstructingRoadEnable(this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ byte[] f1068a;

        public x(byte[] bArr) {
            this.f1068a = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l lVar = l.this;
                lVar.f979a.setTrafficStyleWithTextureData(lVar.f957a, this.f1068a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l lVar = l.this;
                lVar.f984a.setAnchorX(Math.max(0, Math.min(lVar.j, l.this.g)));
                l lVar2 = l.this;
                lVar2.f984a.setAnchorY(Math.max(0, Math.min(lVar2.k, l.this.h)));
                l lVar3 = l.this;
                lVar3.f979a.setProjectionCenter(lVar3.f957a, l.this.f984a.getAnchorX(), l.this.f984a.getAnchorY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class z extends a {
        public z() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
        public final void run() {
            super.run();
            l.this.g(this.M, this.K, this.L);
        }
    }

    public l(IGLSurfaceView iGLSurfaceView, Context context) {
        this(iGLSurfaceView, context, false);
    }

    public static /* synthetic */ boolean U(l lVar) {
        lVar.t = false;
        return false;
    }

    public static /* synthetic */ boolean e0(l lVar) {
        lVar.f1038l = false;
        return false;
    }

    public static boolean t(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    public final void A(MotionEvent motionEvent) {
        if (!this.f1030h || this.f976a == null) {
            return;
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) (motionEvent.getY() - 60.0f);
        if (this.f976a.getLatlng() != null) {
            DPoint dPointObtain = DPoint.obtain();
            getPixel2LatLng(x2, y2, dPointObtain);
            LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
            dPointObtain.recycle();
            this.f976a.setLatLng(latLng);
        }
    }

    public final void B(CameraPosition cameraPosition) {
        if (!this.f984a.getMapLanguage().equals(AMap.ENGLISH)) {
            if (this.f1041n) {
                return;
            }
            this.f1041n = true;
            y(this.f957a, true);
            return;
        }
        boolean zI = I(cameraPosition);
        if (zI != this.f1041n) {
            this.f1041n = zI;
            y(this.f957a, zI);
        }
    }

    public final void C(boolean z2) {
        this.r = z2;
    }

    public final float D() {
        if (this.f984a != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    public final void F(int i2) {
        GLMapRender gLMapRender = this.f980a;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        S(i2);
    }

    public final void G(int i2, boolean z2) {
        if (this.u && this.v) {
            resetRenderTime();
            queueEvent(new j(z2, i2));
        } else {
            a aVar = this.n;
            aVar.b = z2;
            aVar.f1042a = true;
            aVar.M = i2;
        }
    }

    public final void H(MotionEvent motionEvent) {
        queueEvent(new q0(motionEvent));
    }

    public final boolean I(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        MapConfig mapConfig = this.f984a;
        if (mapConfig == null) {
            return false;
        }
        try {
            return !swa.c(mapConfig.getGeoRectangle().getClipRect());
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
            return false;
        }
    }

    public final void J() {
        if (this.u) {
            this.f963a.b();
            this.q = true;
            this.s = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
        }
    }

    public final void K(int i2) {
        S(i2);
        GLMapRender gLMapRender = this.f980a;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    public final boolean L(MotionEvent motionEvent) {
        try {
            List listA = this.f987a.a(AMap.OnPolylineClickListener.class.hashCode());
            if (listA != null && listA.size() > 0) {
                DPoint dPointObtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), dPointObtain);
                LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
                dPointObtain.recycle();
                Polyline hitOverlay = this.f974a.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (listA) {
                        Iterator it = listA.iterator();
                        while (it.hasNext()) {
                            ((AMap.OnPolylineClickListener) it.next()).onPolylineClick(hitOverlay);
                        }
                    }
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final void N() {
        this.q = true;
        this.s = false;
        if (this.f1034j) {
            this.f1034j = false;
        }
        if (this.f1032i) {
            this.f1032i = false;
        }
        if (this.f1036k) {
            this.f1036k = false;
        }
        try {
            if (this.f1028g) {
                List listA = this.f987a.a(AMap.OnMarkerDragListener.class.hashCode());
                if (listA != null && listA.size() > 0 && this.f977a != null) {
                    synchronized (listA) {
                        for (int i2 = 0; i2 < listA.size(); i2++) {
                            ((AMap.OnMarkerDragListener) listA.get(i2)).onMarkerDragEnd(this.f977a);
                        }
                    }
                    this.f977a = null;
                }
                this.f1028g = false;
            }
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
        if (this.f1030h) {
            if (this.f976a != null) {
                this.f976a = null;
            }
            this.f1030h = false;
        }
    }

    public final void O(int i2) {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            if (i2 == 0) {
                if (eiVar.b()) {
                    this.f966a.g(Boolean.FALSE);
                    this.f966a.c();
                    return;
                }
                return;
            }
            if (eiVar.b()) {
                return;
            }
            this.f966a.g(Boolean.TRUE);
            this.f966a.c();
        }
    }

    public final boolean P(MotionEvent motionEvent) throws RemoteException {
        LatLng position;
        DPoint dPointObtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), dPointObtain);
        LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
        dPointObtain.recycle();
        boolean z2 = true;
        BaseOverlay hitBaseOverlay = this.f974a.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.f974a.set2Top(marker.getId());
                List listA = this.f987a.a(AMap.OnMarkerClickListener.class.hashCode());
                if (listA != null && listA.size() > 0) {
                    synchronized (listA) {
                        if (listA.size() == 1) {
                            boolean zOnMarkerClick = ((AMap.OnMarkerClickListener) listA.get(0)).onMarkerClick(marker);
                            if (zOnMarkerClick) {
                                return true;
                            }
                            z2 = zOnMarkerClick;
                        } else {
                            Iterator it = listA.iterator();
                            boolean zOnMarkerClick2 = false;
                            while (it.hasNext()) {
                                zOnMarkerClick2 |= ((AMap.OnMarkerClickListener) it.next()).onMarkerClick(marker);
                            }
                            if (zOnMarkerClick2) {
                                return true;
                            }
                            z2 = zOnMarkerClick2;
                        }
                    }
                }
                this.f974a.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    IPoint iPointObtain = IPoint.obtain();
                    latlon2Geo(position.latitude, position.longitude, iPointObtain);
                    moveCamera(kja.e(iPointObtain));
                }
                return z2;
            } catch (Throwable th) {
                a7b.m(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    public final void R() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine == null || (gLMapState = (GLMapState) gLMapEngine.getNewMapState(this.f957a)) == null) {
            return;
        }
        IPoint iPointObtain = IPoint.obtain();
        gLMapState.recalculate();
        gLMapState.getMapGeoCenter(iPointObtain);
        this.f984a.setSX(((Point) iPointObtain).x);
        this.f984a.setSY(((Point) iPointObtain).y);
        this.f984a.setSZ(gLMapState.getMapZoomer());
        this.f984a.setSC(gLMapState.getCameraDegree());
        this.f984a.setSR(gLMapState.getMapAngle());
        gLMapState.recycle();
        iPointObtain.recycle();
    }

    public final void S(int i2) {
        queueEvent(new g(i2));
    }

    public final boolean T(MotionEvent motionEvent) {
        DPoint dPointObtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), dPointObtain);
        LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
        dPointObtain.recycle();
        BaseOverlay hitBaseOverlay = this.f974a.getHitBaseOverlay(latLng, 3);
        if (!(hitBaseOverlay instanceof GLTFOverlay)) {
            return false;
        }
        GLTFOverlay gLTFOverlay = (GLTFOverlay) hitBaseOverlay;
        if (!gLTFOverlay.isClickable()) {
            return false;
        }
        try {
            this.f974a.set2Top(gLTFOverlay.getId());
            gLTFOverlay.tapClick();
            return true;
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "onGLTFTap");
            th.printStackTrace();
            return false;
        }
    }

    public final LatLng W() {
        MapConfig mapConfig = this.f984a;
        if (mapConfig == null) {
            return null;
        }
        DPoint dPointPixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.f984a.getSY(), 20);
        LatLng latLng = new LatLng(dPointPixelsToLatLong.y, dPointPixelsToLatLong.x, false);
        dPointPixelsToLatLong.recycle();
        return latLng;
    }

    public final boolean X(int i2) {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i2, 7);
        }
        return false;
    }

    public final boolean Y(MotionEvent motionEvent) {
        if (this.f974a != null && this.f970a != null) {
            DPoint dPointObtain = DPoint.obtain();
            if (this.f979a != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), dPointObtain);
                MultiPointItem multiPointItem = this.f974a.getMultiPointItem(new LatLng(dPointObtain.y, dPointObtain.x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean zOnPointClick = this.f970a.onPointClick(multiPointItem);
                dPointObtain.recycle();
                return zOnPointClick;
            }
        }
        return false;
    }

    public final synchronized void Z() {
        synchronized (this.f998a) {
            int size = this.f998a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f998a.get(i2).a().recycle();
            }
            this.f998a.clear();
        }
    }

    public final void a(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.s && this.f979a.getAnimateionsCount() == 0 && this.f979a.getStateMessageCount() == 0) {
                AMapGestureListener aMapGestureListener = this.f975a;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                if (this.f982a.isEnabled()) {
                    try {
                        List listA = this.f987a.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (listA != null && listA.size() != 0) {
                            if (cameraPosition == null) {
                                try {
                                    cameraPosition = getCameraPosition();
                                } catch (Throwable th) {
                                    a7b.m(th, "AMapDelegateImp", "cameraChangeFinish");
                                    th.printStackTrace();
                                }
                            }
                            synchronized (listA) {
                                Iterator it = listA.iterator();
                                while (it.hasNext()) {
                                    ((AMap.OnCameraChangeListener) it.next()).onCameraChangeFinish(cameraPosition);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    this.f984a.resetChangedCounter();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            zwa.D(th2);
        }
    }

    public final void a0(int i2) {
        int i3;
        int i4;
        this.f1012c = i2;
        if (i2 == 1) {
            i4 = 0;
            i3 = 0;
        } else {
            i3 = 2;
            if (i2 == 2) {
                i3 = 1;
            } else if (i2 == 3) {
                i4 = 1;
                i3 = 0;
            } else if (i2 != 4) {
                if (i2 == 5) {
                    i4 = 0;
                    i3 = 3;
                } else {
                    try {
                        this.f1012c = 1;
                        i4 = 0;
                        i3 = 0;
                    } catch (Throwable th) {
                        a7b.m(th, "AMapDelegateImp", "setMaptype");
                        th.printStackTrace();
                        zwa.D(th);
                        return;
                    }
                }
            }
            i4 = 0;
        }
        this.f984a.setMapStyleMode(i3);
        this.f984a.setMapStyleTime(i4);
        if (this.f984a.isCustomStyleEnable()) {
            com.amap.api.col.p0003l.k kVar = this.f967a;
            if (kVar == null || !kVar.o()) {
                g(this.f957a, i3, i4);
                this.f984a.setCustomStyleEnable(false);
            } else {
                this.f967a.p();
            }
            this.f994a.setLogoEnable(true);
        } else {
            if (this.f984a.getMapLanguage().equals(AMap.ENGLISH)) {
                setMapLanguage("zh_cn");
            }
            g(this.f957a, i3, i4);
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void accelerateNetworkInChinese(boolean z2) {
        com.autonavi.extra.b bVar = this.f985a;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions arcOptionsM152clone = arcOptions.m152clone();
            String strCreateId = this.f974a.createId("ARC");
            Arc arc = new Arc(this.f974a, arcOptionsM152clone, strCreateId);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            return iGlOverlayLayer != null ? (Arc) iGlOverlayLayer.addOverlayObject(strCreateId, arc, arcOptionsM152clone) : arc;
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final BuildingOverlay addBuildingOverlay() {
        try {
            xwa.u(this.f959a);
            String strCreateId = this.f974a.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.f974a, strCreateId);
            Field declaredField = BuildingOverlay.class.getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            return (iGlOverlayLayer == null || !(obj instanceof BaseOptions)) ? buildingOverlay : (BuildingOverlay) iGlOverlayLayer.addOverlayObject(strCreateId, buildingOverlay, (BaseOptions) obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            zwa.D(e2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            CircleOptions circleOptionsM154clone = circleOptions.m154clone();
            String strCreateId = this.f974a.createId("CIRCLE");
            Circle circle = new Circle(this.f974a, circleOptionsM154clone, strCreateId);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            return iGlOverlayLayer != null ? (Circle) iGlOverlayLayer.addOverlayObject(strCreateId, circle, circleOptionsM154clone) : circle;
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(this.f957a, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        queueEvent(new d0(crossVectorOverlay));
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String strCreateId = this.f974a.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.f974a, gL3DModelOptions, strCreateId);
        this.f974a.addOverlayObject(strCreateId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) throws RemoteException {
        try {
            if (sxb.a().d() && !sxb.a().c("feature_gltf")) {
                zwa.D(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
                return null;
            }
            resetRenderTime();
            GLTFOverlayOptions gLTFOverlayOptionsM155clone = gLTFOverlayOptions.m155clone();
            String strCreateId = this.f974a.createId("GLTFOVERLAY");
            GLTFOverlay gLTFOverlay = new GLTFOverlay(this.f974a, gLTFOverlayOptionsM155clone, strCreateId);
            this.f974a.addOverlayObject(strCreateId, gLTFOverlay, gLTFOverlayOptionsM155clone);
            return gLTFOverlay;
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addGestureMapMessage(int i2, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.u || this.f979a == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.f1024e;
            abstractGestureMapMessage.anchorX = this.f984a.getAnchorX();
            abstractGestureMapMessage.anchorY = this.f984a.getAnchorY();
            this.f979a.addGestureMessage(i2, abstractGestureMapMessage, this.f994a.isGestureScaleByMapCenter(), this.f984a.getAnchorX(), this.f984a.getAnchorY());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            GroundOverlayOptions groundOverlayOptionsM156clone = groundOverlayOptions.m156clone();
            String strCreateId = this.f974a.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.f974a, groundOverlayOptionsM156clone, strCreateId);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            return iGlOverlayLayer != null ? (GroundOverlay) iGlOverlayLayer.addOverlayObject(strCreateId, groundOverlay, groundOverlayOptionsM156clone) : groundOverlay;
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapGridLayerOptions == null) {
                return null;
            }
            String strCreateId = this.f974a.createId("HEATMAPGRIDLAYER");
            return (HeatMapGridLayer) this.f974a.addOverlayObject(strCreateId, new HeatMapGridLayer(this.f974a, heatMapGridLayerOptions, strCreateId), heatMapGridLayerOptions);
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            String strCreateId = this.f974a.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.f974a.addOverlayObject(strCreateId, new HeatMapLayer(this.f974a, heatMapLayerOptions, strCreateId), heatMapLayerOptions);
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) throws RemoteException {
        try {
            if (sxb.a().d() && !sxb.a().c("feature_mvt")) {
                zwa.D(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
                return null;
            }
            String strCreateId = this.f974a.createId("MVTTILEOVERLAY");
            MVTTileOverlay mVTTileOverlay = new MVTTileOverlay(this.f974a, mVTTileOverlayOptions, strCreateId);
            this.f974a.addOverlayObject(strCreateId, mVTTileOverlay, mVTTileOverlayOptions);
            return mVTTileOverlay;
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions markerOptionsM158clone = markerOptions.m158clone();
            String strCreateId = this.f974a.createId("MARKER");
            Marker marker = new Marker(this.f974a, markerOptionsM158clone, strCreateId);
            this.f974a.addOverlayObject(strCreateId, marker, markerOptionsM158clone);
            return marker;
        } catch (Throwable th) {
            zwa.D(th);
            bxa.f(axa.b, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z2) throws RemoteException {
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                MarkerOptions markerOptions = arrayList.get(i2);
                if (arrayList.get(i2) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z2 && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new k(builder), 50L);
            }
            return arrayList2;
        } catch (Throwable th) {
            zwa.D(th);
            bxa.i(axa.b, "addMarkers failed " + th.getMessage(), arrayList);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            MultiPointOverlayOptions multiPointOverlayOptionsM159clone = multiPointOverlayOptions.m159clone();
            String strCreateId = this.f974a.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.f974a, multiPointOverlayOptionsM159clone, strCreateId);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            return iGlOverlayLayer != null ? (MultiPointOverlay) iGlOverlayLayer.addOverlayObject(strCreateId, multiPointOverlay, multiPointOverlayOptionsM159clone) : multiPointOverlay;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions navigateArrowOptionsM160clone = navigateArrowOptions.m160clone();
            String strCreateId = this.f974a.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.f974a, navigateArrowOptionsM160clone, strCreateId);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            return iGlOverlayLayer != null ? (NavigateArrow) iGlOverlayLayer.addOverlayObject(strCreateId, navigateArrow, navigateArrowOptionsM160clone) : navigateArrow;
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.e(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addOverlayTexture(int i2, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.f979a;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i2)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.f979a.addOverlayTexture(i2, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            xwa.n(this.f959a);
            String strCreateId = this.f974a.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.f974a.addOverlayObject(strCreateId, new ParticleOverlay(this.f974a, particleOverlayOptions, strCreateId), particleOverlayOptions);
        } catch (Throwable th) {
            zwa.D(th);
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            PolygonOptions polygonOptionsM161clone = polygonOptions.m161clone();
            String strCreateId = this.f974a.createId("POLYGON");
            Polygon polygon = new Polygon(this.f974a, polygonOptionsM161clone, strCreateId);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            return iGlOverlayLayer != null ? (Polygon) iGlOverlayLayer.addOverlayObject(strCreateId, polygon, polygonOptionsM161clone) : polygon;
        } catch (Throwable th) {
            zwa.D(th);
            bxa.g(axa.b, "addPolygon failed " + th.getMessage(), polygonOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            String strCreateId = this.f974a.createId("POLYLINE");
            return (Polyline) this.f974a.addOverlayObject(strCreateId, new Polyline(this.f974a, polylineOptions, strCreateId), polylineOptions);
        } catch (Throwable th) {
            zwa.D(th);
            bxa.h(axa.b, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String strCreateId = this.f974a.createId("TEXT");
            TextOptions textOptionsM162clone = textOptions.m162clone();
            MarkerOptions markerOptionsB = qsa.b(textOptionsM162clone);
            Marker marker = new Marker(this.f974a, markerOptionsB, strCreateId);
            marker.setObject(textOptionsM162clone.getObject());
            this.f974a.addOverlayObject(strCreateId, marker, markerOptionsB);
            return new Text(marker, textOptionsM162clone);
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                xwa.c(this.f959a);
            }
            String strCreateId = this.f974a.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.f974a, tileOverlayOptions, strCreateId);
            this.f974a.addOverlayObject(strCreateId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawFrame(int i2, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.f979a;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i2) || this.f979a.isInMapAnimation(i2)))) {
            int i3 = this.f;
            if (i3 != -1) {
                this.f980a.setRenderFps(i3);
            } else {
                this.f980a.setRenderFps(15.0f);
            }
            if (this.f25987a != mapZoomer) {
                this.f25987a = mapZoomer;
            }
        }
        if (this.x) {
            return;
        }
        this.x = true;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawLabel(int i2, GLMapState gLMapState) {
        g0();
        com.autonavi.extra.b bVar = this.f985a;
        if (bVar != null) {
            bVar.e();
        }
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.l = this.f974a.draw(1, this.d, this.y) ? this.l : this.l + 1;
        GLMapEngine gLMapEngine2 = this.f979a;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterRendererOver(int i2, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f974a.draw(2, this.d, this.y);
        GLMapEngine gLMapEngine2 = this.f979a;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.f971a;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(null);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j2, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j2, cancelableCallback);
    }

    public final int b(int i2, Rect rect, int i3, int i4) {
        int engineIDWithType;
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine == null || i2 < 0) {
            engineIDWithType = 0;
        } else {
            engineIDWithType = gLMapEngine.getEngineIDWithType(i2);
            if (this.f979a.isEngineCreated(engineIDWithType)) {
                h(engineIDWithType, rect.left, rect.top, rect.width(), rect.height(), i3, i4);
            } else {
                int i5 = this.f959a.getResources().getDisplayMetrics().densityDpi;
                float f2 = this.f959a.getResources().getDisplayMetrics().density;
                NativeTextGenerate.getInstance().setDensity(f2);
                GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                mapViewInitParam.engineId = engineIDWithType;
                mapViewInitParam.x = rect.left;
                mapViewInitParam.y = rect.top;
                mapViewInitParam.width = rect.width();
                mapViewInitParam.height = rect.height();
                mapViewInitParam.screenWidth = i3;
                mapViewInitParam.screenHeight = i4;
                mapViewInitParam.screenScale = f2;
                mapViewInitParam.textScale = this.c * f2;
                mapViewInitParam.mapZoomScale = this.b;
                mapViewInitParam.taskThreadCount = 3;
                this.f979a.createAMapEngineWithFrame(mapViewInitParam);
                GLMapState mapState = this.f979a.getMapState(engineIDWithType);
                mapState.setMapZoomer(this.f984a.getSZ());
                mapState.setCameraDegree(this.f984a.getSC());
                mapState.setMapAngle(this.f984a.getSR());
                mapState.setMapGeoCenter(this.f984a.getSX(), this.f984a.getSY());
                this.f979a.setMapState(engineIDWithType, mapState);
                this.b = mapState.calMapZoomScalefactor(i3, i4, i5);
                this.f979a.setOvelayBundle(engineIDWithType, new GLOverlayBundle<>(engineIDWithType, this));
            }
        }
        this.f999a.set(false);
        return engineIDWithType;
    }

    public final boolean b0(MotionEvent motionEvent) throws RemoteException {
        try {
            List listA = this.f987a.a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay baseOverlayF = this.f990a.f(motionEvent);
            if (baseOverlayF != null && (baseOverlayF instanceof Marker)) {
                synchronized (listA) {
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        ((AMap.OnInfoWindowClickListener) listA.get(i2)).onInfoWindowClick((Marker) baseOverlayF);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void beforeDrawLabel(int i2, GLMapState gLMapState) {
        g0();
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.l = this.f974a.draw(0, this.d, this.y) ? this.l : this.l + 1;
        GLMapEngine gLMapEngine2 = this.f979a;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    public final Size c(Size size) {
        Size size2 = new Size(getMapWidth(), getMapHeight());
        h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size.getWidth(), size.getHeight());
        getGLMapView().setLayoutParams(layoutParams);
        this.f966a.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        C(false);
        return size2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i2, int i3, int i4, int i5, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i2 == i3 && i3 == i4 && i4 == i5 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.u || this.f999a.get()) {
            DPoint dPointObtain = DPoint.obtain();
            GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), dPointObtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(dPointObtain.y, dPointObtain.x));
            dPointObtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(this.f957a, this.f979a.getNativeInstance());
        Pair<Float, IPoint> pairR = zwa.r(mapConfig, i2, i3, i4, i5, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (pairR == null) {
            return null;
        }
        DPoint dPointObtain2 = DPoint.obtain();
        Object obj = pairR.second;
        GLMapState.geo2LonLat(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y, dPointObtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(pairR.first, new LatLng(dPointObtain2.y, dPointObtain2.x));
        dPointObtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean canShowIndoorSwitch() {
        pja pjaVar;
        if (getZoomLevel() < 17.0f || (pjaVar = this.f989a) == null || pjaVar.f18867a == null) {
            return false;
        }
        FPoint fPointObtain = FPoint.obtain();
        Point point = this.f989a.f18867a;
        j(point.x, point.y, fPointObtain);
        return this.f961a.contains((int) ((PointF) fPointObtain).x, (int) ((PointF) fPointObtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine == null) {
            return true;
        }
        gLMapEngine.canStopMapRender(this.f957a);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeGLOverlayIndex() {
        this.f974a.changeOverlayIndex();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeLogoIconStyle(String str, boolean z2, int i2) {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            eiVar.a(str, Boolean.valueOf(z2), Integer.valueOf(i2));
        }
        wia wiaVar = this.f994a;
        if (wiaVar != null) {
            wiaVar.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeMapLogo(int i2, boolean z2) {
        if (this.f999a.get()) {
            return;
        }
        try {
            List listA = this.f987a.a(AMapWidgetListener.class.hashCode());
            if (listA == null || listA.size() <= 0) {
                return;
            }
            this.f966a.g(Boolean.valueOf(!z2));
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSize(int i2, int i3) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            this.g = i2;
            this.h = i3;
            mapConfig.setMapWidth(i2);
            this.f984a.setMapHeight(i3);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSurface(int i2, GL10 gl10, int i3, int i4) {
        WindowManager windowManager;
        bxa.e(axa.f40634a, "changeSurface " + i3 + " " + i4);
        this.x = false;
        if (!this.u) {
            createSurface(i2, gl10, null);
        }
        com.amap.api.col.p0003l.c0 c0Var = this.f963a;
        if (c0Var != null && this.f959a != null && ((this.g != c0Var.g() || this.h != this.f963a.j()) && (windowManager = (WindowManager) this.f959a.getSystemService("window")) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.f963a.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.g = i3;
        this.h = i4;
        this.f961a = new Rect(0, 0, i3, i4);
        this.f957a = b(i2, new Rect(0, 0, this.g, this.h), this.g, this.h);
        bxa.e(axa.f40634a, "create engine with frame complete");
        if (!this.v) {
            MapConfig mapConfig = this.f984a;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.b);
                this.f984a.setMapWidth(i3);
                this.f984a.setMapHeight(i4);
            }
            this.f979a.setIndoorEnable(this.f957a, false);
            this.f979a.setSimple3DEnable(this.f957a, false);
            this.f979a.setStyleChangeGradualEnable(this.f957a, false);
            this.f979a.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
            GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
            AeUtil.initIntersectionRes(this.f959a, initParam);
            this.f979a.setVectorOverlayPath(initParam.mIntersectionResPath);
        }
        synchronized (this) {
            this.v = true;
        }
        if (this.f1024e) {
            this.f984a.setAnchorX(Math.max(1, Math.min(this.j, i3 - 1)));
            this.f984a.setAnchorY(Math.max(1, Math.min(this.k, i4 - 1)));
        } else {
            this.f984a.setAnchorX(i3 >> 1);
            this.f984a.setAnchorY(i4 >> 1);
        }
        this.f979a.setProjectionCenter(this.f957a, this.f984a.getAnchorX(), this.f984a.getAnchorY());
        this.f1001a = true;
        a aVar = this.f1037l;
        if (aVar.f1042a) {
            aVar.run();
        }
        a aVar2 = this.f1014c;
        if (aVar2.f1042a) {
            aVar2.run();
        }
        a aVar3 = this.f1018d;
        if (aVar3.f1042a) {
            aVar3.run();
        }
        a aVar4 = this.f968a;
        if (aVar4.f1042a) {
            aVar4.run();
        }
        a aVar5 = this.f1022e;
        if (aVar5.f1042a) {
            aVar5.run();
        }
        a aVar6 = this.n;
        if (aVar6.f1042a) {
            aVar6.run();
        }
        a aVar7 = this.f1025f;
        if (aVar7.f1042a) {
            aVar7.run();
        }
        a aVar8 = this.f1027g;
        if (aVar8.f1042a) {
            aVar8.run();
        }
        a aVar9 = this.f1029h;
        if (aVar9.f1042a) {
            aVar9.run();
        }
        a aVar10 = this.f1039m;
        if (aVar10.f1042a) {
            aVar10.run();
        }
        a aVar11 = this.f1006b;
        if (aVar11.f1042a) {
            aVar11.run();
        }
        a aVar12 = this.f1031i;
        if (aVar12.f1042a) {
            aVar12.run();
        }
        a aVar13 = this.f1033j;
        if (aVar13 != null) {
            aVar13.run();
        }
        a aVar14 = this.f1035k;
        if (aVar14 != null) {
            aVar14.run();
        }
        CustomRenderer customRenderer = this.f971a;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i3, i4);
        }
        com.autonavi.extra.b bVar = this.f985a;
        if (bVar != null) {
            bVar.d();
        }
        Handler handler = this.f962a;
        if (handler != null) {
            handler.post(this.f995a);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void checkMapState(IGLMapState iGLMapState) {
        if (this.f984a == null || this.f999a.get()) {
            return;
        }
        LatLngBounds limitLatLngBounds = this.f984a.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds == null) {
                if (this.f984a.isSetLimitZoomLevel()) {
                    iGLMapState.setMapZoomer(Math.max(this.f984a.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.f984a.getMaxZoomLevel())));
                    return;
                }
                return;
            }
            IPoint[] limitIPoints = this.f984a.getLimitIPoints();
            if (limitIPoints == null) {
                IPoint iPointObtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, iPointObtain);
                IPoint iPointObtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPointObtain2);
                IPoint[] iPointArr = {iPointObtain, iPointObtain2};
                this.f984a.setLimitIPoints(iPointArr);
                limitIPoints = iPointArr;
            }
            MapConfig mapConfig = this.f984a;
            IPoint iPoint = limitIPoints[0];
            int i2 = ((Point) iPoint).x;
            int i3 = ((Point) iPoint).y;
            IPoint iPoint2 = limitIPoints[1];
            float fJ = zwa.j(mapConfig, i2, i3, ((Point) iPoint2).x, ((Point) iPoint2).y, getMapWidth(), getMapHeight());
            float mapZoomer = iGLMapState.getMapZoomer();
            if (this.f984a.isSetLimitZoomLevel()) {
                float maxZoomLevel = this.f984a.getMaxZoomLevel();
                float minZoomLevel = this.f984a.getMinZoomLevel();
                float fMax = Math.max(fJ, Math.min(mapZoomer, maxZoomLevel));
                if (fJ <= maxZoomLevel) {
                    maxZoomLevel = fMax;
                }
                fJ = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
            } else if (fJ <= 0.0f || mapZoomer >= fJ) {
                fJ = mapZoomer;
            }
            iGLMapState.setMapZoomer(fJ);
            IPoint iPointObtain3 = IPoint.obtain();
            iGLMapState.getMapGeoCenter(iPointObtain3);
            int i4 = ((Point) iPointObtain3).x;
            int i5 = ((Point) iPointObtain3).y;
            IPoint iPoint3 = limitIPoints[0];
            int i6 = ((Point) iPoint3).x;
            int i7 = ((Point) iPoint3).y;
            IPoint iPoint4 = limitIPoints[1];
            int[] iArrU = zwa.U(i6, i7, ((Point) iPoint4).x, ((Point) iPoint4).y, this.f984a, iGLMapState, i4, i5);
            iGLMapState.setMapGeoCenter(iArrU[0], iArrU[1]);
            iPointObtain3.recycle();
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float checkZoomLevel(float f2) throws RemoteException {
        return zwa.h(this.f984a, f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "clear");
            zwa.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void clearTileCache() {
        this.f974a.clearTileCache();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long createGLOverlay(int i2) {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.f957a, i2);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.f974a;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int createOverlayTexture(int i2, Bitmap bitmap) {
        try {
            GLMapEngine gLMapEngine = this.f979a;
            if (gLMapEngine == null || bitmap == null) {
                return -1;
            }
            return gLMapEngine.createOverlayTexture(i2, bitmap);
        } catch (Throwable th) {
            zwa.D(th);
        }
        return -1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final synchronized void createSurface(int i2, GL10 gl10, EGLConfig eGLConfig) {
        bxa.e(axa.f40634a, "createSurface");
        this.f1005b = System.currentTimeMillis();
        if (this.f1012c == 3) {
            this.f966a.d().a(ed.b);
        } else {
            this.f966a.d().a(ed.f25912a);
        }
        this.v = false;
        this.g = this.f982a.getWidth();
        this.h = this.f982a.getHeight();
        this.x = false;
        try {
            AeUtil.loadLib(this.f959a);
            bxa.e(axa.f40634a, "load lib complete");
            AeUtil.initCrashHandle(this.f959a);
            GLMapEngine.InitParam initParamInitResource = AeUtil.initResource(this.f959a);
            bxa.e(axa.f40634a, "load res complete");
            this.f979a.createAMapInstance(initParamInitResource);
            bxa.e(axa.f40634a, "create engine complete");
            this.f992a = new ssa();
            bxa.e(axa.f40634a, "init shader complete");
            com.autonavi.extra.b bVar = this.f985a;
            if (bVar != null) {
                bVar.i();
            }
            this.u = true;
            this.f1015c = gl10.glGetString(7937);
        } catch (Throwable th) {
            zwa.D(th);
            a7b.m(th, "AMapDElegateImp", "createSurface");
            bxa.l(axa.f40634a, "createSurface failed " + th.getMessage());
            xwa.l(this.f959a, "init failed:" + th.getMessage());
        }
        if (fo.a(this.f959a, zwa.t()).f26036a == fo.c.SuccessCode) {
            n0();
        }
        if (MapsInitializer.isTerrainEnable() && this.f993a == null) {
            svb svbVar = new svb(this.f959a, this);
            this.f993a = svbVar;
            svbVar.d(0L);
        }
        CustomRenderer customRenderer = this.f971a;
        if (customRenderer != null) {
            customRenderer.onSurfaceCreated(gl10, eGLConfig);
        }
        com.autonavi.extra.b bVar2 = this.f985a;
        if (bVar2 != null) {
            bVar2.c();
        }
        this.f974a.onCreateAMapInstance();
    }

    public final void d0() {
        if (this.f1004b > 0) {
            boolean zCanStopMapRender = this.f979a.canStopMapRender(this.f957a);
            if (!zCanStopMapRender) {
                int i2 = this.f1004b - 1;
                this.f1004b = i2;
                if (i2 > 0) {
                    this.f979a.renderAMap();
                    return;
                }
            }
            this.f1004b = 0;
            Message messageObtainMessage = this.f962a.obtainMessage(15, this.f979a.getScreenShot(this.f957a, 0, 0, getMapWidth(), getMapHeight()));
            messageObtainMessage.arg1 = zCanStopMapRender ? 1 : 0;
            messageObtainMessage.sendToTarget();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroy() {
        this.f999a.set(true);
        bxa.e(axa.f40634a, "destroy map");
        try {
            LocationSource locationSource = this.f972a;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.f972a = null;
            this.f969a = null;
            GLMapRender gLMapRender = this.f980a;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            Z();
            Thread thread = this.f997a;
            if (thread != null) {
                thread.interrupt();
                this.f997a = null;
            }
            Thread thread2 = this.f1009b;
            if (thread2 != null) {
                thread2.interrupt();
                this.f1009b = null;
            }
            svb svbVar = this.f993a;
            if (svbVar != null) {
                svbVar.c();
                this.f993a = null;
            }
            cs csVar = this.f964a;
            if (csVar != null) {
                csVar.a();
                this.f964a = null;
            }
            cu cuVar = this.f965a;
            if (cuVar != null) {
                cuVar.b(null);
                this.f965a.a();
                this.f965a = null;
            }
            lwa.f();
            GLMapEngine gLMapEngine = this.f979a;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                this.f979a.releaseNetworkState();
                queueEvent(new c0());
                int i2 = 0;
                while (this.f979a != null) {
                    int i3 = i2 + 1;
                    if (i2 >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e2) {
                        zwa.D(e2);
                    }
                    i2 = i3;
                    a7b.m(th, "AMapDelegateImp", "destroy");
                    zwa.D(th);
                    th.printStackTrace();
                }
            }
            IGLSurfaceView iGLSurfaceView = this.f982a;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    zwa.D(e3);
                }
            }
            ei eiVar = this.f966a;
            if (eiVar != null) {
                eiVar.g();
                this.f966a = null;
            }
            jsa jsaVar = this.f988a;
            if (jsaVar != null) {
                jsaVar.n();
                this.f988a = null;
            }
            this.f972a = null;
            this.f986a = null;
            u0();
            this.f978a = null;
            bxa.a();
            a7b.j();
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "destroy");
            zwa.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroySurface(int i2) {
        this.f1000a.lock();
        try {
            if (this.u) {
                EGL14.eglGetCurrentContext();
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                w0();
                GLMapEngine gLMapEngine = this.f979a;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.f957a) != null) {
                        this.f979a.getOverlayBundle(this.f957a).removeAll(true);
                    }
                    this.f979a.destroyAMapEngine();
                    this.f979a = null;
                    int i3 = this.l;
                    if (i3 > 0) {
                        xwa.d(this.f959a, i3);
                    }
                    bxa.e(axa.f40634a, "destroy engine complete");
                }
                com.autonavi.extra.b bVar = this.f985a;
                if (bVar != null) {
                    bVar.f();
                }
            }
            this.u = false;
            this.v = false;
            this.x = false;
            this.f1000a.unlock();
        } catch (Throwable th) {
            try {
                zwa.D(th);
            } finally {
                this.f1000a.unlock();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void drawFrame(GL10 gl10) {
        if (this.f999a.get() || this.f979a == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(16640);
            return;
        }
        f(this.f957a);
        this.f979a.renderAMap();
        this.f979a.pushRendererState();
        com.amap.api.col.p0003l.k kVar = this.f967a;
        if (kVar != null) {
            kVar.a();
        }
        d0();
        i0();
        if (!this.w) {
            this.w = true;
        }
        this.f979a.popRendererState();
        if (qwa.b()) {
            try {
                if (this.f982a instanceof com.amap.api.col.p0003l.o) {
                    if (this.f991a == null) {
                        this.f991a = new qwa();
                    }
                    this.f991a.i();
                    if (!this.f991a.j() || this.f991a.h()) {
                        return;
                    }
                    if (this.f991a.c(((com.amap.api.col.p0003l.o) this.f982a).getBitmap())) {
                        if (qwa.e()) {
                            removecache();
                        }
                        if (qwa.g()) {
                            qwa.k();
                        }
                        bxa.l(axa.e, "pure screen: found pure check");
                    }
                }
            } catch (Throwable th) {
                a7b.m(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    public final void e(double d2, double d3) {
        this.f962a.post(new b(d2, d3));
    }

    public final void f(int i2) {
        int i3 = this.f;
        if (i3 != -1) {
            this.f980a.setRenderFps(i3);
            resetRenderTime();
        } else if (this.f979a.isInMapAction(i2) || this.s) {
            this.f980a.setRenderFps(40.0f);
        } else if (this.f979a.isInMapAnimation(i2) || this.f974a.isGLTFAnimated()) {
            this.f980a.setRenderFps(30.0f);
            this.f980a.resetTickCount(15);
        } else {
            this.f980a.setRenderFps(15.0f);
        }
        if (this.f984a.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            w();
            this.f984a.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    public final synchronized void g(int i2, int i3, int i4) {
        i(i2, i3, i4, false, null);
    }

    public final void g0() {
        GLMapState mapState;
        List listA;
        List listA2;
        List listA3;
        if (this.f999a.get() || (mapState = this.f979a.getMapState(this.f957a)) == null) {
            return;
        }
        mapState.getViewMatrix(this.f984a.getViewMatrix());
        mapState.getProjectionMatrix(this.f984a.getProjectionMatrix());
        this.f984a.updateFinalMatrix();
        DPoint mapGeoCenter = mapState.getMapGeoCenter();
        this.f984a.setSX(mapGeoCenter.x);
        this.f984a.setSY(mapGeoCenter.y);
        this.f984a.setSZ(mapState.getMapZoomer());
        this.f984a.setSC(mapState.getCameraDegree());
        this.f984a.setSR(mapState.getMapAngle());
        this.f984a.setSkyHeight(mapState.getSkyHeight());
        if (!this.f984a.isMapStateChange()) {
            if (!this.s && this.f979a.getAnimateionsCount() == 0 && this.f979a.getStateMessageCount() == 0) {
                onChangeFinish();
                return;
            }
            return;
        }
        DPoint dPointPixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapGeoCenter.x, mapGeoCenter.y, 20);
        CameraPosition cameraPosition = new CameraPosition(new LatLng(dPointPixelsToLatLong.y, dPointPixelsToLatLong.x, false), this.f984a.getSZ(), this.f984a.getSC(), this.f984a.getSR());
        dPointPixelsToLatLong.recycle();
        Message messageObtainMessage = this.f962a.obtainMessage();
        messageObtainMessage.what = 10;
        messageObtainMessage.obj = cameraPosition;
        this.f962a.sendMessage(messageObtainMessage);
        boolean z2 = true;
        this.t = true;
        redrawInfoWindow();
        try {
            if (this.f994a.isZoomControlsEnabled() && this.f984a.isNeedUpdateZoomControllerState() && (listA3 = this.f987a.a(AMapWidgetListener.class.hashCode())) != null && listA3.size() > 0) {
                synchronized (listA3) {
                    for (int i2 = 0; i2 < listA3.size(); i2++) {
                        ((AMapWidgetListener) listA3.get(i2)).invalidateZoomController(this.f984a.getSZ());
                    }
                }
            }
            if (this.f984a.getChangeGridRatio() != 1.0d) {
                w();
            }
            if (!this.f994a.isCompassEnabled() || (!this.f984a.isTiltChanged() && !this.f984a.isBearingChanged())) {
                z2 = false;
            }
            if (z2 && (listA2 = this.f987a.a(AMapWidgetListener.class.hashCode())) != null && listA2.size() > 0) {
                synchronized (listA2) {
                    for (int i3 = 0; i3 < listA2.size(); i3++) {
                        ((AMapWidgetListener) listA2.get(i3)).invalidateCompassView();
                    }
                }
            }
            if (!this.f994a.isScaleControlsEnabled() || (listA = this.f987a.a(AMapWidgetListener.class.hashCode())) == null || listA.size() <= 0) {
                return;
            }
            synchronized (listA) {
                for (int i4 = 0; i4 < listA.size(); i4++) {
                    ((AMapWidgetListener) listA.get(i4)).invalidateScaleView();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Latlng(int i2, int i3, DPoint dPoint) {
        DPoint dPointPixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i2, i3, 20);
        dPoint.x = dPointPixelsToLatLong.x;
        dPoint.y = dPointPixelsToLatLong.y;
        dPointPixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Map(int i2, int i3, FPoint fPoint) {
        ((PointF) fPoint).x = (int) (((double) i2) - this.f984a.getSX());
        ((PointF) fPoint).y = (int) (((double) i3) - this.f984a.getSY());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.f985a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.f983a);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.f973a == null) {
            this.f973a = new UiSettings(this.f994a);
        }
        return this.f973a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getCameraAngle() {
        return getCameraDegree(this.f957a);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getCameraDegree(int i2) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.f1024e);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final CameraPosition getCameraPositionPrj(boolean z2) {
        LatLng latLngW;
        try {
            if (this.f984a == null) {
                return null;
            }
            if (!this.u || this.f1020d || this.f979a == null) {
                DPoint dPointObtain = DPoint.obtain();
                geo2Latlng((int) this.f984a.getSX(), (int) this.f984a.getSY(), dPointObtain);
                LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
                dPointObtain.recycle();
                return CameraPosition.builder().target(latLng).bearing(this.f984a.getSR()).tilt(this.f984a.getSC()).zoom(this.f984a.getSZ()).build();
            }
            if (z2) {
                DPoint dPointObtain2 = DPoint.obtain();
                getPixel2LatLng(this.f984a.getAnchorX(), this.f984a.getAnchorY(), dPointObtain2);
                latLngW = new LatLng(dPointObtain2.y, dPointObtain2.x, false);
                dPointObtain2.recycle();
            } else {
                latLngW = W();
            }
            return CameraPosition.builder().target(latLngW).bearing(this.f984a.getSR()).tilt(this.f984a.getSC()).zoom(this.f984a.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Context getContext() {
        return this.f959a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getCurrentWorldVectorMapStyle() {
        try {
            com.autonavi.extra.b bVar = this.f985a;
            if (bVar == null) {
                return "";
            }
            Object objJ = bVar.j();
            return objJ instanceof String ? (String) objJ : "";
        } catch (Throwable th) {
            zwa.D(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.col.p0003l.k getCustomStyleManager() {
        return this.f967a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.f979a;
        return gLMapEngine != null ? gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo) : this.f957a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float[] getFinalMatrix() {
        MapConfig mapConfig = this.f984a;
        return mapConfig != null ? mapConfig.getMvpMatrix() : this.f1002a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapEngine getGLMapEngine() {
        return this.f979a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final View getGLMapView() {
        Object obj = this.f982a;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getGeoCenter(int i2, IPoint iPoint) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.f984a.getSY();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IGlOverlayLayer getGlOverlayLayer() {
        return this.f974a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.f957a);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final qja getInfoWindowDelegate() {
        return this.f990a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Map(double d2, double d3, FPoint fPoint) {
        IPoint iPointObtain = IPoint.obtain();
        latlon2Geo(d2, d3, iPointObtain);
        geo2Map(((Point) iPointObtain).x, ((Point) iPointObtain).y, fPoint);
        iPointObtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Pixel(double d2, double d3, IPoint iPoint) {
        if (this.f999a.get() || !this.u || this.f979a == null) {
            return;
        }
        try {
            Point pointLatLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
            FPoint fPointObtain = FPoint.obtain();
            j(pointLatLongToPixels.x, pointLatLongToPixels.y, fPointObtain);
            if (((PointF) fPointObtain).x == -10000.0f && ((PointF) fPointObtain).y == -10000.0f) {
                GLMapState gLMapState = (GLMapState) this.f979a.getNewMapState(this.f957a);
                gLMapState.setCameraDegree(0.0f);
                gLMapState.recalculate();
                gLMapState.p20ToScreenPoint(pointLatLongToPixels.x, pointLatLongToPixels.y, fPointObtain);
                gLMapState.recycle();
            }
            ((Point) iPoint).x = (int) ((PointF) fPointObtain).x;
            ((Point) iPoint).y = (int) ((PointF) fPointObtain).y;
            fPointObtain.recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.f984a.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i2 = 0; i2 < 4; i2++) {
                    IPoint iPoint = clipRect[i2];
                    GLMapState.geo2LonLat(((Point) iPoint).x, ((Point) iPoint).y, dPointArr[i2]);
                }
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getLogoMarginRate(int i2) {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            return eiVar.a(i2);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getLogoPosition() {
        try {
            return this.f994a.getLogoPosition();
        } catch (RemoteException e2) {
            a7b.m(e2, "AMapDelegateImp", "getLogoPosition");
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Handler getMainHandler() {
        return this.f962a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapAngle(int i2) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final LatLngBounds getMapBounds(LatLng latLng, float f2, float f3, float f4) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.f999a.get()) {
            return null;
        }
        float fH = zwa.h(this.f984a, f2);
        GLMapState gLMapState = new GLMapState(this.f957a, this.f979a.getNativeInstance());
        if (latLng != null) {
            IPoint iPointObtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, iPointObtain);
            gLMapState.setCameraDegree(f4);
            gLMapState.setMapAngle(f3);
            gLMapState.setMapGeoCenter(((Point) iPointObtain).x, ((Point) iPointObtain).y);
            gLMapState.setMapZoomer(fH);
            gLMapState.recalculate();
            iPointObtain.recycle();
        }
        DPoint dPointObtain = DPoint.obtain();
        o(gLMapState, 0, 0, dPointObtain);
        LatLng latLng2 = new LatLng(dPointObtain.y, dPointObtain.x, false);
        o(gLMapState, mapWidth, mapHeight, dPointObtain);
        LatLng latLng3 = new LatLng(dPointObtain.y, dPointObtain.x, false);
        dPointObtain.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final MapConfig getMapConfig() {
        return this.f984a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.f984a;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        xwa.q(this.f959a);
        String strB = pwa.b(this.f959a, "approval_number", "mc", "");
        return !TextUtils.isEmpty(strB) ? strB : "GS(2021)5875号 | GS(2020)2189号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapHeight() {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.f987a.e(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), onmapprintscreenlistener);
            this.f1004b = 20;
            this.f1040m = true;
            resetRenderTime();
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.f957a);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (zwa.I(getMapWidth(), getMapHeight()) && !this.f999a.get()) {
            return this.f974a.getMapScreenMarkers();
        }
        return new ArrayList();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z2) {
        try {
            this.f987a.e(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), onMapScreenShotListener);
            this.f1004b = 20;
            this.f1040m = z2;
            resetRenderTime();
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapTextZIndex() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapType() throws RemoteException {
        return this.f1012c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapWidth() {
        return this.g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapZoomScale() {
        return this.b;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getMaskLayerType() {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.f984a;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            zwa.D(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.f984a;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            zwa.D(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Location getMyLocation() throws RemoteException {
        if (this.f972a != null) {
            return this.f986a.f40781a;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        jsa jsaVar = this.f988a;
        if (jsaVar != null) {
            return jsaVar.a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getNativeEngineID() {
        return this.f957a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getNativeMapController() {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.f957a);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List listA = this.f987a.a(AMap.OnCameraChangeListener.class.hashCode());
            if (listA == null && listA.size() != 0) {
                return (AMap.OnCameraChangeListener) listA.get(0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2Geo(int i2, int i3, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f999a.get() || !this.u || (gLMapEngine = this.f979a) == null || (mapState = gLMapEngine.getMapState(this.f957a)) == null) {
            return;
        }
        mapState.screenToP20Point(i2, i3, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2LatLng(int i2, int i3, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f999a.get() || !this.u || (gLMapEngine = this.f979a) == null || (mapState = gLMapEngine.getMapState(this.f957a)) == null) {
            return;
        }
        IPoint iPointObtain = IPoint.obtain();
        mapState.screenToP20Point(i2, i3, iPointObtain);
        DPoint dPointPixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPointObtain).x, ((Point) iPointObtain).y, 20);
        dPoint.x = dPointPixelsToLatLong.x;
        dPoint.y = dPointPixelsToLatLong.y;
        iPointObtain.recycle();
        dPointPixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getPreciseLevel(int i2) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IProjectionDelegate getProjection() throws RemoteException {
        return this.f983a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.f984a;
        return mapConfig != null ? mapConfig.getProjectionMatrix() : this.f1017c;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Rect getRect() {
        return this.f961a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getRenderMode() {
        return this.f982a.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSX() {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSY() {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getSatelliteImageApprovalNumber() {
        xwa.r(this.f959a);
        String strB = pwa.b(this.f959a, "approval_number", "si", "");
        return !TextUtils.isEmpty(strB) ? strB : "GS(2021)1328号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "getScalePerPixel");
            zwa.D(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getSkyHeight() {
        return this.f984a.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getTerrainApprovalNumber() {
        xwa.s(this.f959a);
        String strB = pwa.b(this.f959a, "approval_number", "te", "");
        return !TextUtils.isEmpty(strB) ? strB : "GS(2021)6352号";
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IUiSettingsDelegate getUiSettings() {
        return this.f994a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getUnitLengthByZoom(int i2) {
        GLMapState gLMapState = new GLMapState(this.f957a, this.f979a.getNativeInstance());
        gLMapState.setMapZoomer(i2);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final View getView() throws RemoteException {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            return eiVar.j();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.f984a;
        return mapConfig != null ? mapConfig.getViewMatrix() : this.f1011b;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Point getWaterMarkerPositon() {
        ei eiVar = this.f966a;
        return eiVar != null ? eiVar.a() : new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapLanguage() {
        return this.f996a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapStyle() {
        return this.f1008b;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getZoomLevel() {
        return D();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng == null || latLng2 == null || !this.u || this.f999a.get()) {
                return mapConfig.getSZ();
            }
            Pair<Float, IPoint> pairR = zwa.r(mapConfig, 0, 0, 0, 0, new LatLngBounds.Builder().include(latLng).include(latLng2).build(), getMapWidth(), getMapHeight());
            if (pairR != null) {
                return ((Float) pairR.first).floatValue();
            }
            GLMapState gLMapState = new GLMapState(this.f957a, this.f979a.getNativeInstance());
            float mapZoomer = gLMapState.getMapZoomer();
            gLMapState.recycle();
            return mapZoomer;
        } catch (Throwable th) {
            zwa.D(th);
            return 0.0f;
        }
    }

    public final void h(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLMapEngine gLMapEngine = this.f979a;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i2, i3, i4, i5, i6, i7, i8);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void hideInfoWindow() {
        qja qjaVar = this.f990a;
        if (qjaVar != null) {
            qjaVar.w();
        }
    }

    public final synchronized void i(int i2, int i3, int i4, boolean z2, StyleItem[] styleItemArr) {
        if (this.v && this.u && this.f1001a) {
            O(i4);
            queueEvent(new f(i2, i3, i4, z2, styleItemArr));
            return;
        }
        a aVar = this.f1014c;
        aVar.M = i2;
        aVar.K = i3;
        aVar.L = i4;
        aVar.f1042a = true;
    }

    public final void i0() {
        if (!this.f1026f) {
            this.f962a.sendEmptyMessage(16);
            this.f1026f = true;
            w();
        }
        long j2 = this.f1013c;
        if (j2 < 2) {
            this.f1013c = j2 + 1;
            return;
        }
        ed edVarD = this.f966a.d();
        if (edVarD == null || edVarD.getVisibility() == 8) {
            return;
        }
        xwa.g(this.f959a, System.currentTimeMillis() - this.f1005b);
        this.f962a.post(new d(edVarD));
        this.f979a.setStyleChangeGradualEnable(this.f957a, true);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isIndoorEnabled() throws RemoteException {
        return this.f984a.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapAngle(int i2) {
        return X(i2);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapCameraDegree(int i2) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMaploaded() {
        return this.f1026f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.f1016c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTrafficEnabled() throws RemoteException {
        return this.f984a.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isUseAnchor() {
        return this.f1024e;
    }

    public final void j(int i2, int i3, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f999a.get() || !this.u || (gLMapEngine = this.f979a) == null || (mapState = gLMapEngine.getMapState(this.f957a)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i2, i3, fPoint);
    }

    public final void k(int i2, boolean z2) {
        if (this.u && this.v) {
            resetRenderTime();
            queueEvent(new h(i2, z2));
        } else {
            a aVar = this.f1022e;
            aVar.b = z2;
            aVar.f1042a = true;
            aVar.M = i2;
        }
    }

    public final void k0() {
        GLMapRender gLMapRender = this.f980a;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    public final void l(MotionEvent motionEvent) throws RemoteException {
        if (!this.f1028g || this.f977a == null) {
            return;
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) (motionEvent.getY() - 60.0f);
        if (this.f977a.getPosition() != null) {
            DPoint dPointObtain = DPoint.obtain();
            getPixel2LatLng(x2, y2, dPointObtain);
            LatLng latLng = new LatLng(dPointObtain.y, dPointObtain.x);
            dPointObtain.recycle();
            this.f977a.setPosition(latLng);
            try {
                List listA = this.f987a.a(AMap.OnMarkerDragListener.class.hashCode());
                if (listA == null || listA.size() <= 0) {
                    return;
                }
                synchronized (listA) {
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        try {
                            ((AMap.OnMarkerDragListener) listA.get(i2)).onMarkerDrag(this.f977a);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void latlon2Geo(double d2, double d3, IPoint iPoint) {
        Point pointLatLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
        ((Point) iPoint).x = pointLatLongToPixels.x;
        ((Point) iPoint).y = pointLatLongToPixels.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void loadWorldVectorMap(boolean z2) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z2);
        }
    }

    public final void m0() {
        GLMapRender gLMapRender;
        if (!this.u || (gLMapRender = this.f980a) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void map2Geo(float f2, float f3, IPoint iPoint) {
        ((Point) iPoint).x = (int) (((double) f2) + this.f984a.getSX());
        ((Point) iPoint).y = (int) (((double) f3) + this.f984a.getSY());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    public final void n(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z2 = this.f1024e;
        abstractCameraUpdateMessage.isUseAnchor = z2;
        if (z2) {
            abstractCameraUpdateMessage.anchorX = this.f984a.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.f984a.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.f984a;
    }

    public final void n0() {
        if (this.o) {
            return;
        }
        try {
            this.f997a.setName("AuthThread");
            this.f997a.start();
            this.o = true;
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
    }

    public final void o(GLMapState gLMapState, int i2, int i3, DPoint dPoint) {
        if (!this.u || this.f979a == null) {
            return;
        }
        Point point = new Point();
        gLMapState.screenToP20Point(i2, i3, point);
        DPoint dPointPixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(point.x, point.y, 20);
        dPoint.x = dPointPixelsToLatLong.x;
        dPoint.y = dPointPixelsToLatLong.y;
        dPointPixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        cnb cnbVar = this.f987a;
        if (cnbVar == null) {
            return;
        }
        for (AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener : cnbVar.a(AMap.AMapAppResourceRequestListener.class.hashCode())) {
            if (aMapAppResourceRequestListener != null) {
                aMapAppResourceRequestListener.onRequest(aMapAppRequestParam);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityPause() {
        this.f1020d = true;
        F(this.f957a);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityResume() {
        this.f1020d = false;
        K(this.f957a);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onChangeFinish() {
        Message messageObtainMessage = this.f962a.obtainMessage();
        messageObtainMessage.what = 11;
        this.f962a.sendMessage(messageObtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onDoubleTap(int i2, MotionEvent motionEvent) {
        if (!this.u) {
            return false;
        }
        s((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.f974a;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.f1038l = true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00b5  */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onIndoorBuildingActivity(int i2, byte[] bArr) {
        pja pjaVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    pjaVar = new pja();
                    byte b2 = bArr[0];
                    pjaVar.f18868a = new String(bArr, 1, b2, "utf-8");
                    int i3 = b2 + 1;
                    int i4 = i3 + 1;
                    byte b3 = bArr[i3];
                    pjaVar.f18871b = new String(bArr, i4, b3, "utf-8");
                    int i5 = i4 + b3;
                    int i6 = i5 + 1;
                    byte b4 = bArr[i5];
                    pjaVar.activeFloorName = new String(bArr, i6, b4, "utf-8");
                    int i7 = i6 + b4;
                    pjaVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i7);
                    int i8 = i7 + 4;
                    int i9 = i8 + 1;
                    byte b5 = bArr[i8];
                    pjaVar.poiid = new String(bArr, i9, b5, "utf-8");
                    int i10 = i9 + b5;
                    int i11 = i10 + 1;
                    byte b6 = bArr[i10];
                    pjaVar.c = new String(bArr, i11, b6, "utf-8");
                    int i12 = i11 + b6;
                    int i13 = GLConvertUtil.getInt(bArr, i12);
                    pjaVar.f43997a = i13;
                    int i14 = i12 + 4;
                    pjaVar.floor_indexs = new int[i13];
                    pjaVar.floor_names = new String[i13];
                    pjaVar.f18870a = new String[i13];
                    for (int i15 = 0; i15 < pjaVar.f43997a; i15++) {
                        pjaVar.floor_indexs[i15] = GLConvertUtil.getInt(bArr, i14);
                        int i16 = i14 + 4;
                        int i17 = i16 + 1;
                        byte b7 = bArr[i16];
                        if (b7 > 0) {
                            pjaVar.floor_names[i15] = new String(bArr, i17, b7, "utf-8");
                            i17 += b7;
                        }
                        i14 = i17 + 1;
                        byte b8 = bArr[i17];
                        if (b8 > 0) {
                            pjaVar.f18870a[i15] = new String(bArr, i14, b8, "utf-8");
                            i14 += b8;
                        }
                    }
                    int i18 = GLConvertUtil.getInt(bArr, i14);
                    pjaVar.b = i18;
                    int i19 = i14 + 4;
                    if (i18 > 0) {
                        pjaVar.f18869a = new int[i18];
                        for (int i20 = 0; i20 < pjaVar.b; i20++) {
                            pjaVar.f18869a[i20] = GLConvertUtil.getInt(bArr, i19);
                            i19 += 4;
                        }
                    }
                } else {
                    pjaVar = null;
                }
            } catch (Throwable th) {
                zwa.D(th);
                th.printStackTrace();
                return;
            }
        } else {
            pjaVar = null;
        }
        this.f1007b = pjaVar;
        post(new b0());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onLongPress(int i2, MotionEvent motionEvent) {
        int i3 = 0;
        try {
            this.f1032i = false;
            x(i2);
            BaseOverlay hitBaseOverlay = this.f974a.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.f977a = (Marker) hitBaseOverlay;
            }
            BaseOverlay hitBaseOverlay2 = this.f974a.getHitBaseOverlay(motionEvent, 3);
            if (hitBaseOverlay2 instanceof GLTFOverlay) {
                this.f976a = (GLTFOverlay) hitBaseOverlay2;
            }
            Marker marker = this.f977a;
            if (marker == null || !marker.isDraggable()) {
                GLTFOverlay gLTFOverlay = this.f976a;
                if (gLTFOverlay == null || !gLTFOverlay.isDraggable()) {
                    List listA = this.f987a.a(AMap.OnMapLongClickListener.class.hashCode());
                    if (listA != null && listA.size() > 0) {
                        DPoint dPointObtain = DPoint.obtain();
                        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), dPointObtain);
                        synchronized (listA) {
                            while (i3 < listA.size()) {
                                ((AMap.OnMapLongClickListener) listA.get(i3)).onMapLongClick(new LatLng(dPointObtain.y, dPointObtain.x));
                                i3++;
                            }
                        }
                        this.f1034j = true;
                        dPointObtain.recycle();
                    }
                } else {
                    LatLng latlng = this.f976a.getLatlng();
                    if (latlng != null) {
                        IPoint iPointObtain = IPoint.obtain();
                        getLatLng2Pixel(latlng.latitude, latlng.longitude, iPointObtain);
                        ((Point) iPointObtain).y -= 60;
                        DPoint dPointObtain2 = DPoint.obtain();
                        getPixel2LatLng(((Point) iPointObtain).x, ((Point) iPointObtain).y, dPointObtain2);
                        this.f976a.setLatLng(new LatLng(dPointObtain2.y, dPointObtain2.x));
                        this.f974a.set2Top(this.f976a.getId());
                        this.f1030h = true;
                        iPointObtain.recycle();
                        dPointObtain2.recycle();
                    }
                }
            } else {
                LatLng position = this.f977a.getPosition();
                if (position != null) {
                    IPoint iPointObtain2 = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, iPointObtain2);
                    ((Point) iPointObtain2).y -= 60;
                    DPoint dPointObtain3 = DPoint.obtain();
                    getPixel2LatLng(((Point) iPointObtain2).x, ((Point) iPointObtain2).y, dPointObtain3);
                    this.f977a.setPosition(new LatLng(dPointObtain3.y, dPointObtain3.x));
                    this.f974a.set2Top(this.f977a.getId());
                    try {
                        List listA2 = this.f987a.a(AMap.OnMarkerDragListener.class.hashCode());
                        if (listA2 != null && listA2.size() > 0) {
                            synchronized (listA2) {
                                while (i3 < listA2.size()) {
                                    ((AMap.OnMarkerDragListener) listA2.get(i3)).onMarkerDragStart(this.f977a);
                                    i3++;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        a7b.m(th, "AMapDelegateImp", "onMarkerDragStart");
                        th.printStackTrace();
                    }
                    this.f1028g = true;
                    iPointObtain2.recycle();
                    dPointObtain3.recycle();
                }
            }
            this.f980a.resetTickCount(30);
        } catch (Throwable th2) {
            a7b.m(th2, "AMapDelegateImp", "onLongPress");
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapBlankClick(double d2, double d3) {
        e(d2, d3);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapPOIClick(MapPoi mapPoi) {
        List listA;
        MapConfig mapConfig = this.f984a;
        if ((mapConfig != null || mapConfig.isTouchPoiEnable()) && (listA = this.f987a.a(AMap.OnPOIClickListener.class.hashCode())) != null && listA.size() > 0 && mapPoi != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 20;
            messageObtain.obj = new Poi(mapPoi.getName(), new LatLng(mapPoi.getLatitude(), mapPoi.getLongitude()), mapPoi.getPoiid());
            this.f962a.sendMessage(messageObtain);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onPause() {
        R();
        IGlOverlayLayer iGlOverlayLayer = this.f974a;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onResume() {
        try {
            this.f980a.setRenderFps(15.0f);
            this.f982a.setRenderMode(0);
            IGlOverlayLayer iGlOverlayLayer = this.f974a;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            jsa jsaVar = this.f988a;
            if (jsaVar != null) {
                jsaVar.k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onSingleTapConfirmed(int i2, MotionEvent motionEvent) {
        if (!this.u) {
            return false;
        }
        try {
            x(i2);
            if (b0(motionEvent) || P(motionEvent) || Y(motionEvent)) {
                return true;
            }
            L(motionEvent);
            if (T(motionEvent)) {
                return true;
            }
            H(motionEvent);
            return true;
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "onSingleTapUp");
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1020d || !this.u || !this.r) {
            return false;
        }
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f981a;
        eAMapPlatformGestureInfo.mGestureState = 3;
        eAMapPlatformGestureInfo.mGestureType = 8;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        getEngineIDWithGestureInfo(this.f981a);
        k0();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            m0();
            J();
        } else if (action == 1) {
            N();
        }
        if (motionEvent.getAction() == 2 && this.f1028g) {
            try {
                l(motionEvent);
            } catch (Throwable th) {
                a7b.m(th, "AMapDelegateImp", "onDragMarker");
                th.printStackTrace();
            }
            return true;
        }
        if (motionEvent.getAction() == 2 && this.f1030h) {
            try {
                A(motionEvent);
            } catch (Throwable th2) {
                a7b.m(th2, "AMapDelegateImp", "onDragGLTF");
                th2.printStackTrace();
            }
            return true;
        }
        if (this.q) {
            try {
                this.f963a.e(motionEvent);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        try {
            List listA = this.f987a.a(AMap.OnMapTouchListener.class.hashCode());
            if (listA != null && listA.size() > 0) {
                this.f962a.removeMessages(14);
                Message messageObtainMessage = this.f962a.obtainMessage();
                messageObtainMessage.what = 14;
                messageObtainMessage.obj = MotionEvent.obtain(motionEvent);
                messageObtainMessage.sendToTarget();
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final void p(boolean z2) {
        com.autonavi.extra.b bVar = this.f985a;
        if (bVar != null) {
            Object objJ = bVar.j();
            if (objJ != null && (objJ instanceof Boolean)) {
                MapConfig mapConfig = this.f984a;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z2 && ((Boolean) objJ).booleanValue());
                }
                if (z2 && ((Boolean) objJ).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object objJ2 = this.f985a.j();
            if (objJ2 != null && (objJ2 instanceof Boolean)) {
                this.f966a.a(((Boolean) objJ2).booleanValue());
            }
            Object objJ3 = this.f985a.j();
            if (objJ2 == null || !(objJ2 instanceof Integer)) {
                return;
            }
            this.d = ((Integer) objJ3).intValue();
        }
    }

    public final void p0() {
        if (this.p) {
            return;
        }
        try {
            if (this.f1009b == null) {
                this.f1009b = new eob(this.f959a, this);
            }
            this.f1009b.setName("AuthProThread");
            this.f1009b.start();
            this.p = true;
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void pixel2Map(int i2, int i3, PointF pointF) {
        if (!this.u || this.f1020d || this.f979a == null) {
            return;
        }
        IPoint iPointObtain = IPoint.obtain();
        getPixel2Geo(i2, i3, iPointObtain);
        pointF.x = ((Point) iPointObtain).x - ((float) this.f984a.getSX());
        pointF.y = ((Point) iPointObtain).y - ((float) this.f984a.getSY());
        iPointObtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.f982a;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    public final void q(boolean z2, byte[] bArr, boolean z3) {
        yua yuaVarE;
        try {
            this.f984a.setCustomStyleEnable(z2);
            boolean z4 = false;
            if (this.f984a.isHideLogoEnable()) {
                this.f994a.setLogoEnable(!z2);
            }
            if (!z2) {
                G(this.f957a, false);
                g(this.f957a, this.f984a.getMapStyleMode(), this.f984a.getMapStyleTime());
                return;
            }
            G(this.f957a, true);
            wsa wsaVar = new wsa();
            MyTrafficStyle myTrafficStyle = this.f978a;
            if (myTrafficStyle != null && myTrafficStyle.getTrafficRoadBackgroundColor() != -1) {
                wsaVar.i(this.f978a.getTrafficRoadBackgroundColor());
            }
            if (this.f984a.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f984a.getCustomTextureResourcePath())) {
                z4 = true;
            }
            StyleItem[] styleItemArrC = null;
            if (bArr != null) {
                yuaVarE = wsaVar.f(bArr, z4);
                if (yuaVarE != null && (styleItemArrC = yuaVarE.c()) != null) {
                    this.f984a.setUseProFunction(true);
                }
            } else {
                yuaVarE = null;
            }
            if (styleItemArrC == null && (yuaVarE = wsaVar.e(this.f984a.getCustomStylePath(), z4)) != null) {
                styleItemArrC = yuaVarE.c();
            }
            if (wsaVar.a() != 0) {
                this.f984a.setCustomBackgroundColor(wsaVar.a());
            }
            if (yuaVarE == null || yuaVarE.d() == null) {
                r(styleItemArrC, z3);
            } else if (this.f965a != null) {
                this.f965a.d((String) yuaVarE.d());
                this.f965a.c(yuaVarE);
                this.f965a.b();
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void queueEvent(Runnable runnable) {
        long id;
        try {
            try {
                id = Thread.currentThread().getId();
            } catch (Throwable th) {
                zwa.D(th);
                a7b.m(th, "AMapdelegateImp", "queueEvent");
                id = -1;
            }
            if (id != -1 && id == this.f958a) {
                runnable.run();
            } else if (this.f979a != null) {
                this.f982a.queueEvent(runnable);
            }
        } catch (Throwable th2) {
            zwa.D(th2);
            a7b.m(th2, "AMapdelegateImp", "queueEvent");
        }
    }

    public final void r(StyleItem[] styleItemArr, boolean z2) {
        if (!(z2 || (styleItemArr != null && styleItemArr.length > 0))) {
            xwa.j(this.f959a, false);
        } else {
            i(this.f957a, 0, 0, true, styleItemArr);
            xwa.j(this.f959a, true);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void redrawInfoWindow() {
        if (!this.f999a.get() && this.u) {
            this.f962a.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void refreshLogo() {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            eiVar.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void reloadMapCustomStyle() {
        com.amap.api.col.p0003l.k kVar = this.f967a;
        if (kVar != null) {
            kVar.k();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        if (this.f979a != null) {
            queueEvent(new e0(baseMapOverlay));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLModel(String str) {
        try {
            this.f974a.removeOverlay(str);
            return false;
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.f974a.removeOverlay(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.f(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void requestRender() {
        GLMapRender gLMapRender = this.f980a;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.f982a.requestRender();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0049 */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void resetMinMaxZoomPreference() {
        List listA;
        this.f984a.resetMinMaxZoomPreference();
        if (!this.f994a.isZoomControlsEnabled() || !this.f984a.isNeedUpdateZoomControllerState() || (listA = this.f987a.a(AMapWidgetListener.class.hashCode())) == null || listA.size() <= 0) {
            return;
        }
        synchronized (listA) {
            for (int i2 = 0; i2 < listA.size(); i2++) {
                try {
                    ((AMapWidgetListener) listA.get(i2)).invalidateZoomController(this.f984a.getSZ());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.f980a;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.f980a;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    public final boolean s(int i2, int i3) {
        AbstractCameraUpdateMessage abstractCameraUpdateMessageD;
        if (!this.u || ((int) D()) >= this.f984a.getMaxZoomLevel()) {
            return false;
        }
        try {
            if (this.f1024e || this.f994a.isZoomInByScreenCenter()) {
                abstractCameraUpdateMessageD = kja.d(1.0f, null);
            } else {
                Point point = this.f960a;
                point.x = i2;
                point.y = i3;
                abstractCameraUpdateMessageD = kja.d(1.0f, point);
            }
            animateCamera(abstractCameraUpdateMessageD);
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    public final void s0() {
        try {
            LatLngBounds limitLatLngBounds = this.f984a.getLimitLatLngBounds();
            if (this.f979a != null && t(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(this.f957a, this.f979a.getNativeInstance());
                IPoint iPointObtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, iPointObtain);
                IPoint iPointObtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPointObtain2);
                this.f984a.setLimitIPoints(new IPoint[]{iPointObtain, iPointObtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f984a.setLimitIPoints(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void set3DBuildingEnabled(boolean z2) throws RemoteException {
        try {
            F(this.f957a);
            k(this.f957a, z2);
            K(this.f957a);
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        com.amap.api.col.p0003l.c0 c0Var = this.f963a;
        if (c0Var != null) {
            this.f975a = aMapGestureListener;
            c0Var.d(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCenterToPixel(int i2, int i3) throws RemoteException {
        this.f1024e = true;
        this.j = i2;
        this.k = i3;
        if (this.v && this.u) {
            if (this.f984a.getAnchorX() == this.j && this.f984a.getAnchorY() == this.k) {
                return;
            }
            this.f984a.setAnchorX(this.j);
            this.f984a.setAnchorY(this.k);
            queueEvent(new y());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setConstructingRoadEnable(boolean z2) {
        try {
            if (this.u && this.v) {
                resetRenderTime();
                queueEvent(new u(z2));
            } else {
                a aVar = this.f1031i;
                aVar.b = z2;
                aVar.f1042a = true;
                aVar.M = this.f957a;
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (u(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable() && (customMapStyleOptions.getStyleId() != null || customMapStyleOptions.getStyleTexturePath() != null || customMapStyleOptions.getStyleTextureData() != null || customMapStyleOptions.getStyleResDataPath() != null || customMapStyleOptions.getStyleResData() != null)) {
                    p0();
                }
                this.f967a.m();
                this.f967a.d(customMapStyleOptions);
                com.autonavi.extra.b bVar = this.f985a;
                if (bVar != null) {
                    bVar.i();
                }
            } catch (Throwable th) {
                zwa.D(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyleID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f984a.getCustomStyleID())) {
            return;
        }
        this.f984a.setCustomStyleID(str);
        this.f1010b = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStylePath(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f984a.getCustomStylePath())) {
            return;
        }
        this.f984a.setCustomStylePath(str);
        this.f1010b = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.f971a = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomTextureResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f984a.setCustomTextureResourcePath(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setGestureStatus(int i2, int i3) {
        if (this.i == 0 || i3 != 5) {
            this.i = i3;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setHideLogoEnble(boolean z2) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z2);
            if (this.f984a.isCustomStyleEnable()) {
                this.f994a.setLogoEnable(!z2);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.f999a.get() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.f989a = (pja) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new a0());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorEnabled(boolean z2) throws RemoteException {
        List listA;
        try {
            if (!this.u || this.f999a.get()) {
                a aVar = this.f1039m;
                aVar.b = z2;
                aVar.f1042a = true;
                aVar.M = this.f957a;
                return;
            }
            this.f984a.setIndoorEnable(z2);
            resetRenderTime();
            if (z2) {
                GLMapEngine gLMapEngine = this.f979a;
                if (gLMapEngine != null) {
                    gLMapEngine.setIndoorEnable(this.f957a, true);
                }
            } else {
                GLMapEngine gLMapEngine2 = this.f979a;
                if (gLMapEngine2 != null) {
                    gLMapEngine2.setIndoorEnable(this.f957a, false);
                }
                MapConfig mapConfig = this.f984a;
                mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.f984a.getMaxZoomLevel() : 20.0f;
                try {
                    if (this.f994a.isZoomControlsEnabled() && (listA = this.f987a.a(AMapWidgetListener.class.hashCode())) != null && listA.size() > 0) {
                        synchronized (listA) {
                            for (int i2 = 0; i2 < listA.size(); i2++) {
                                try {
                                    ((AMapWidgetListener) listA.get(i2)).invalidateZoomController(this.f984a.getSZ());
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            xwa.p(this.f959a, z2);
            if (this.f994a.isIndoorSwitchEnabled()) {
                this.f962a.post(new p(z2));
            }
        } catch (Throwable th2) {
            zwa.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        qja qjaVar;
        if (this.f999a.get() || (qjaVar = this.f990a) == null) {
            return;
        }
        qjaVar.i(infoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLoadOfflineData(boolean z2) throws RemoteException {
        queueEvent(new q(z2));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.f999a.get()) {
                return;
            }
            LocationSource locationSource2 = this.f972a;
            if (locationSource2 != null && (locationSource2 instanceof com.amap.api.col.p0003l.a)) {
                locationSource2.deactivate();
            }
            this.f972a = locationSource;
            if (locationSource != null) {
                this.f966a.h(Boolean.TRUE);
            } else {
                this.f966a.h(Boolean.FALSE);
            }
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoBottomMargin(int i2) {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            eiVar.c(Integer.valueOf(i2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoLeftMargin(int i2) {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            eiVar.d(Integer.valueOf(i2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoMarginRate(int i2, float f2) {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            eiVar.a(Integer.valueOf(i2), Float.valueOf(f2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoPosition(int i2) {
        ei eiVar = this.f966a;
        if (eiVar != null) {
            eiVar.b(Integer.valueOf(i2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapCustomEnable(boolean z2, boolean z3) {
        cs csVar;
        if (!this.u || this.f999a.get()) {
            a aVar = this.f1018d;
            aVar.f1042a = true;
            aVar.b = z2;
            return;
        }
        boolean z4 = z3 ? z3 : false;
        if (TextUtils.isEmpty(this.f984a.getCustomStylePath()) && TextUtils.isEmpty(this.f984a.getCustomStyleID())) {
            return;
        }
        if (z2) {
            try {
                if (this.f984a.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f984a.getCustomStyleID()) && (csVar = this.f964a) != null) {
                    csVar.b(this.f984a.getCustomStyleID());
                    this.f964a.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                zwa.D(th);
                return;
            }
        }
        if (z3 || this.f1010b || (this.f984a.isCustomStyleEnable() ^ z2)) {
            q(z2, null, z4);
        }
        this.f1010b = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapEnable(boolean z2) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (TextUtils.isEmpty(str) || (mapConfig = this.f984a) == null || mapConfig.isCustomStyleEnable() || this.f984a.getMapLanguage().equals(str)) {
            return;
        }
        if (!str.equals(AMap.ENGLISH)) {
            this.f984a.setMapLanguage("zh_cn");
            this.d = 0;
        } else {
            if (this.f1012c != 1) {
                try {
                    setMapType(1);
                } catch (Throwable th) {
                    zwa.D(th);
                    th.printStackTrace();
                }
            }
            this.f984a.setMapLanguage(AMap.ENGLISH);
            this.d = -10000;
        }
        try {
            B(getCameraPosition());
        } catch (Throwable th2) {
            zwa.D(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.f984a.setLimitLatLngBounds(latLngBounds);
            s0();
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextEnable(boolean z2) throws RemoteException {
        try {
            if (this.u && this.v) {
                resetRenderTime();
                queueEvent(new r(z2));
            } else {
                a aVar = this.f1025f;
                aVar.b = z2;
                aVar.f1042a = true;
                aVar.M = this.f957a;
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextZIndex(int i2) throws RemoteException {
        this.d = i2;
        this.y = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapType(int i2) throws RemoteException {
        MapConfig mapConfig;
        if (i2 != this.f1012c || ((mapConfig = this.f984a) != null && mapConfig.isCustomStyleEnable())) {
            this.f1012c = i2;
            a0(i2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            cnb cnbVar = this.f987a;
            if (cnbVar != null) {
                cnbVar.c(AMapWidgetListener.class.hashCode(), aMapWidgetListener);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaskLayerParams(int i2, int i3, int i4, int i5, int i6, long j2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaxZoomLevel(float f2) {
        this.f984a.setMaxZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMinZoomLevel(float f2) {
        this.f984a.setMinZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z2) throws RemoteException {
        if (this.f999a.get()) {
            return;
        }
        try {
            ei eiVar = this.f966a;
            if (eiVar != null) {
                LocationSource locationSource = this.f972a;
                if (locationSource == null) {
                    eiVar.h(Boolean.FALSE);
                } else if (z2) {
                    locationSource.activate(this.f986a);
                    this.f966a.h(Boolean.TRUE);
                    if (this.f988a == null) {
                        this.f988a = new jsa(this, this.f959a);
                    }
                } else {
                    jsa jsaVar = this.f988a;
                    if (jsaVar != null) {
                        jsaVar.n();
                        this.f988a = null;
                    }
                    this.f972a.deactivate();
                }
            }
            if (!z2) {
                this.f994a.setMyLocationButtonEnabled(z2);
            }
            this.f1016c = z2;
            resetRenderTime();
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f2) throws RemoteException {
        try {
            jsa jsaVar = this.f988a;
            if (jsaVar != null) {
                jsaVar.b(f2);
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.f999a.get()) {
            return;
        }
        try {
            if (this.f988a == null) {
                this.f988a = new jsa(this, this.f959a);
            }
            if (this.f988a != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000L);
                }
                LocationSource locationSource = this.f972a;
                if (locationSource != null && (locationSource instanceof com.amap.api.col.p0003l.a)) {
                    ((com.amap.api.col.p0003l.a) locationSource).b(myLocationStyle.getInterval());
                    ((com.amap.api.col.p0003l.a) this.f972a).a(myLocationStyle.getMyLocationType());
                }
                this.f988a.g(myLocationStyle);
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationType(int i2) throws RemoteException {
        try {
            jsa jsaVar = this.f988a;
            if (jsaVar == null || jsaVar.a() == null) {
                return;
            }
            this.f988a.a().myLocationType(i2);
            setMyLocationStyle(this.f988a.a());
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setNaviLabelEnable(boolean z2, int i2, int i3) throws RemoteException {
        try {
            if (this.u && this.v) {
                resetRenderTime();
                queueEvent(new t(z2, i2, i3));
                return;
            }
            a aVar = this.f1029h;
            aVar.b = z2;
            aVar.N = i2;
            aVar.O = i3;
            aVar.f1042a = true;
            aVar.M = this.f957a;
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnCameraChangeListener.class.hashCode(), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnIndoorBuildingActiveListener.class.hashCode(), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnInfoWindowClickListener.class.hashCode(), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnMapClickListener.class.hashCode(), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnMapLongClickListener.class.hashCode(), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnMapTouchListener.class.hashCode(), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnMapLoadedListener.class.hashCode(), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnMarkerClickListener.class.hashCode(), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnMarkerDragListener.class.hashCode(), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.f970a = onMultiPointClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnMyLocationChangeListener.class.hashCode(), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnPOIClickListener.class.hashCode(), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.c(AMap.OnPolylineClickListener.class.hashCode(), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderFps(int i2) {
        try {
            if (i2 == -1) {
                this.f = i2;
            } else {
                this.f = Math.max(10, Math.min(i2, 40));
            }
            xwa.t(this.f959a);
        } catch (Throwable th) {
            zwa.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderMode(int i2) {
        try {
            IGLSurfaceView iGLSurfaceView = this.f982a;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRoadArrowEnable(boolean z2) throws RemoteException {
        try {
            if (this.u && this.v) {
                resetRenderTime();
                queueEvent(new s(z2));
            } else {
                a aVar = this.f1027g;
                aVar.b = z2;
                aVar.f1042a = true;
                aVar.M = this.f957a;
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRunLowFrame(boolean z2) {
        if (z2) {
            return;
        }
        try {
            if (this.f == -1) {
                m0();
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setTerrainAuth(boolean z2) {
        GLMapEngine gLMapEngine;
        if (this.f999a.get() || (gLMapEngine = this.f979a) == null) {
            return;
        }
        gLMapEngine.setTerrainAuth(z2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTouchPoiEnable(boolean z2) {
        MapConfig mapConfig = this.f984a;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficEnabled(boolean z2) throws RemoteException {
        try {
            if (this.u && !this.f999a.get()) {
                queueEvent(new o(z2, z2));
                return;
            }
            a aVar = this.f968a;
            aVar.b = z2;
            aVar.f1042a = true;
            aVar.M = this.f957a;
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (this.f999a.get()) {
            return;
        }
        try {
            if (this.u && this.v && bArr != null && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new v(bArr, myTrafficStyle));
                return;
            }
            a aVar = this.f1035k;
            aVar.f1043a = bArr;
            aVar.f25988a = myTrafficStyle;
            aVar.f1042a = true;
            aVar.M = this.f957a;
        } catch (Exception e2) {
            zwa.D(e2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (this.f999a.get()) {
            return;
        }
        try {
            if (this.u && this.v && bArr != null) {
                resetRenderTime();
                queueEvent(new x(bArr));
            } else {
                a aVar = this.f1033j;
                aVar.f1043a = bArr;
                aVar.f1042a = true;
                aVar.M = this.f957a;
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setVisibilityEx(int i2) {
        IGLSurfaceView iGLSurfaceView = this.f982a;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setWorldVectorMapStyle(String str) {
        if (u(false, true) || TextUtils.isEmpty(str) || this.f984a == null || this.f1008b.equals(str)) {
            return;
        }
        this.f1008b = str;
        com.autonavi.extra.b bVar = this.f985a;
        if (bVar != null) {
            bVar.i();
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZOrderOnTop(boolean z2) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setZoomPosition(int i2) {
        ei eiVar;
        if (this.f999a.get() || (eiVar = this.f966a) == null) {
            return;
        }
        eiVar.a(Integer.valueOf(i2));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZoomScaleParam(float f2) {
        this.b = f2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showCompassEnabled(boolean z2) {
        ei eiVar;
        if (this.f999a.get() || (eiVar = this.f966a) == null) {
            return;
        }
        eiVar.d(Boolean.valueOf(z2));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showIndoorSwitchControlsEnabled(boolean z2) {
        ei eiVar;
        if (this.f999a.get() || (eiVar = this.f966a) == null) {
            return;
        }
        eiVar.a(Boolean.valueOf(z2));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        qja qjaVar;
        if (baseOverlayImp == null || (qjaVar = this.f990a) == null) {
            return;
        }
        try {
            qjaVar.k(baseOverlayImp);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showLogoEnabled(boolean z2) {
        if (this.f999a.get()) {
            return;
        }
        this.f966a.f(Boolean.valueOf(z2));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationButtonEnabled(boolean z2) {
        ei eiVar;
        if (this.f999a.get() || (eiVar = this.f966a) == null) {
            return;
        }
        eiVar.c(Boolean.valueOf(z2));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.f1016c && this.f972a != null) {
                if (this.f988a == null) {
                    this.f988a = new jsa(this, this.f959a);
                }
                if (location.getLongitude() != AudioStats.AUDIO_AMPLITUDE_NONE && location.getLatitude() != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    this.f988a.e(location);
                }
                List listA = this.f987a.a(AMap.OnMyLocationChangeListener.class.hashCode());
                if (listA != null && listA.size() > 0) {
                    synchronized (listA) {
                        for (int i2 = 0; i2 < listA.size(); i2++) {
                            ((AMap.OnMyLocationChangeListener) listA.get(i2)).onMyLocationChange(location);
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            jsa jsaVar = this.f988a;
            if (jsaVar != null) {
                jsaVar.n();
            }
            this.f988a = null;
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showScaleEnabled(boolean z2) {
        ei eiVar;
        if (this.f999a.get() || (eiVar = this.f966a) == null) {
            return;
        }
        eiVar.e(Boolean.valueOf(z2));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showZoomControlsEnabled(boolean z2) {
        ei eiVar;
        if (this.f999a.get() || (eiVar = this.f966a) == null) {
            return;
        }
        eiVar.b(Boolean.valueOf(z2));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.f979a;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float toMapLenWithWin(int i2) {
        GLMapEngine gLMapEngine;
        if (!this.u || this.f1020d || (gLMapEngine = this.f979a) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.f957a).getGLUnitWithWin(i2);
    }

    public final boolean u(boolean z2, boolean z3) {
        if (z2) {
            if (this.A) {
                dva.c("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效");
                return true;
            }
            this.z = true;
        }
        if (!z3) {
            return false;
        }
        if (this.z) {
            dva.c("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效");
            return true;
        }
        this.A = true;
        return false;
    }

    public final void u0() {
        cnb cnbVar = this.f987a;
        if (cnbVar != null) {
            cnbVar.b();
        }
    }

    public final void w() {
        this.f962a.obtainMessage(17, 1, 0).sendToTarget();
    }

    public final void w0() {
        ssa ssaVar = this.f992a;
        if (ssaVar != null) {
            ssaVar.a();
            this.f992a = null;
        }
    }

    public final void x(int i2) {
        queueEvent(new e(i2));
    }

    public final void y(int i2, boolean z2) {
        if (this.u && this.v) {
            resetRenderTime();
            queueEvent(new i(z2, i2));
        } else {
            a aVar = this.f1037l;
            aVar.b = z2;
            aVar.f1042a = true;
            aVar.M = i2;
        }
    }

    public final void z(Size size) {
        h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        getGLMapView().setLayoutParams(layoutParams);
        this.f966a.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        C(true);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void zoomOut(int i2) {
        if (this.u && ((int) D()) > this.f984a.getMinZoomLevel()) {
            try {
                animateCamera(kja.l());
            } catch (Throwable th) {
                a7b.m(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public l(IGLSurfaceView iGLSurfaceView, Context context, boolean z2) {
        this.f986a = null;
        this.f987a = new cnb();
        byte b2 = 0;
        this.f1001a = false;
        this.f1010b = false;
        this.f1016c = false;
        this.f999a = new AtomicBoolean(false);
        this.f1020d = false;
        this.f984a = new MapConfig(true);
        this.f1024e = false;
        this.f1026f = false;
        this.f1028g = false;
        this.f1030h = false;
        this.f977a = null;
        this.f976a = null;
        this.f1032i = false;
        this.f1034j = false;
        this.f1036k = false;
        this.f1038l = false;
        this.f1004b = 0;
        this.f1040m = true;
        this.f1041n = true;
        this.f961a = new Rect();
        this.f1012c = 1;
        this.f978a = null;
        this.o = false;
        this.p = false;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.f998a = new ArrayList();
        this.f991a = null;
        this.f958a = -1L;
        this.q = false;
        this.f25987a = 0.0f;
        this.b = 1.0f;
        this.c = 1.0f;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.f1000a = new ReentrantLock();
        this.i = 0;
        this.y = true;
        this.f962a = new HandlerC0248l(Looper.getMainLooper());
        this.f968a = new c();
        this.f1006b = new n();
        this.f1014c = new z();
        this.f1018d = new f0();
        this.f1022e = new g0();
        this.f1025f = new i0();
        this.f1027g = new j0();
        this.f1029h = new k0();
        this.f1031i = new w();
        this.f1033j = new h0();
        this.f1035k = new l0();
        this.f1037l = new m0();
        this.f1039m = new n0();
        this.f995a = new o0();
        this.n = new p0();
        this.f996a = "";
        this.f1008b = "";
        this.z = false;
        this.A = false;
        this.l = 0;
        this.f981a = new EAMapPlatformGestureInfo();
        this.f960a = new Point();
        this.f1013c = 0L;
        this.f1015c = null;
        this.f1007b = null;
        this.f1002a = new float[16];
        this.f1011b = new float[16];
        this.f1017c = new float[16];
        this.f1003a = null;
        this.f1021d = new float[12];
        this.f1019d = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.f1023e = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.m = -1;
        this.f959a = context;
        com.amap.api.col.p0003l.m mVarA = fo.a(context, zwa.t());
        fo.c cVar = mVarA.f26036a;
        fo.c cVar2 = fo.c.SuccessCode;
        if (cVar == cVar2) {
            bxa.d(context);
            bxa.e(axa.f40634a, "init map delegate");
        }
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.f985a = bVar;
        bVar.a();
        this.f985a.b();
        a7b.e(this.f959a);
        lwa.a().b(this.f959a);
        qwb.f19196a = j4b.g(context);
        ava.a(this.f959a);
        this.f963a = new com.amap.api.col.p0003l.c0(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.f980a = gLMapRender;
        this.f982a = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        bia biaVar = new bia(this, this.f959a);
        this.f974a = biaVar;
        this.f979a = new GLMapEngine(this.f959a, this);
        this.f966a = new eh(this.f959a, this, biaVar);
        this.f994a = new wia(this);
        this.f966a.a(new s0(this, b2));
        this.f969a = new r0();
        iGLSurfaceView.setRenderMode(0);
        this.f980a.setRenderFps(15.0f);
        this.f979a.setMapListener(this);
        this.f983a = new pia(this);
        this.f986a = new bmb(this);
        qja qjaVar = new qja(this.f959a);
        this.f990a = qjaVar;
        qjaVar.l(this.f966a);
        this.f990a.s(new psa(biaVar, context));
        this.f997a = new com.amap.api.col.p0003l.a0(this.f959a, this);
        this.f972a = new com.amap.api.col.p0003l.a(this.f959a);
        this.f964a = new cs(this.f959a, this);
        cu cuVar = new cu(this.f959a);
        this.f965a = cuVar;
        cuVar.b(this);
        p(z2);
        MapConfig mapConfig = this.f984a;
        com.amap.api.col.p0003l.k kVar = new com.amap.api.col.p0003l.k(this, this.f959a, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.f967a = kVar;
        kVar.c(this);
        if (mVarA.f26036a != cVar2) {
            this.f984a.setMapEnable(false);
        }
        this.f957a = this.f979a.getEngineIDWithType(1);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j2, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.f999a.get() || this.f979a == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j2;
        if (!this.f1020d && getMapHeight() != 0 && getMapWidth() != 0) {
            try {
                this.f979a.interruptAnimation();
                resetRenderTime();
                n(abstractCameraUpdateMessage);
                this.f979a.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (Throwable th) {
                zwa.D(th);
                th.printStackTrace();
                return;
            }
        }
        try {
            moveCamera(abstractCameraUpdateMessage);
            AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
            if (cancelableCallback2 != null) {
                cancelableCallback2.onFinish();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            zwa.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.f962a == null || this.f979a == null) {
            return;
        }
        try {
            t0 t0Var = new t0(this.f959a, onCacheRemoveListener);
            this.f962a.removeCallbacks(t0Var);
            this.f962a.post(t0Var);
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            zwa.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.f979a == null || this.f999a.get()) {
            return;
        }
        try {
            if (this.f1020d && this.f979a.getStateMessageCount() > 0) {
                AbstractCameraUpdateMessage abstractCameraUpdateMessageO = kja.o();
                abstractCameraUpdateMessageO.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                abstractCameraUpdateMessageO.geoPoint = new DPoint(this.f984a.getSX(), this.f984a.getSY());
                abstractCameraUpdateMessageO.zoom = this.f984a.getSZ();
                abstractCameraUpdateMessageO.bearing = this.f984a.getSR();
                abstractCameraUpdateMessageO.tilt = this.f984a.getSC();
                this.f979a.addMessage(abstractCameraUpdateMessage, false);
                while (this.f979a.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.f979a.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(abstractCameraUpdateMessageO);
                    }
                }
                abstractCameraUpdateMessage = abstractCameraUpdateMessageO;
            }
        } catch (Throwable th) {
            zwa.D(th);
        }
        resetRenderTime();
        this.f979a.clearAnimations(this.f957a, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        n(abstractCameraUpdateMessage);
        this.f979a.addMessage(abstractCameraUpdateMessage, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        qja qjaVar;
        if (this.f999a.get() || (qjaVar = this.f990a) == null) {
            return;
        }
        qjaVar.h(commonInfoWindowAdapter);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        qja qjaVar;
        if (baseOverlay == null || (qjaVar = this.f990a) == null) {
            return;
        }
        try {
            qjaVar.j(baseOverlay);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public static abstract class a implements Runnable {
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyTrafficStyle f25988a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1042a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f1043a;
        public boolean b;

        public a() {
            this.f1042a = false;
            this.b = false;
            this.N = 0;
            this.O = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1042a = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear(boolean z2) throws RemoteException {
        String strP;
        try {
            hideInfoWindow();
            String strQ = "";
            jsa jsaVar = this.f988a;
            if (jsaVar == null) {
                strP = null;
            } else if (z2) {
                strP = jsaVar.p();
                strQ = this.f988a.q();
            } else {
                jsaVar.r();
                strP = null;
            }
            this.f974a.clear(strP, strQ);
            queueEvent(new m());
            resetRenderTime();
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImp", "clear");
            zwa.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setCustomMapStyle(boolean z2, byte[] bArr) {
        q(z2, bArr, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapCustomEnable(boolean z2) {
        if (z2) {
            p0();
        }
        setMapCustomEnable(z2, false);
    }

    @Override // com.amap.api.col.3l.k.a
    public final void a() {
        com.autonavi.extra.b bVar = this.f985a;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.amap.api.col.3l.cu.a
    public final void a(String str, yua yuaVar) {
        setCustomTextureResourcePath(str);
        if (!this.f984a.isCustomStyleEnable() || yuaVar == null) {
            return;
        }
        r(yuaVar.c(), false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.f958a = Thread.currentThread().getId();
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th2) {
            th2.printStackTrace();
            zwa.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void changeSurface(GL10 gl10, int i2, int i3) {
        try {
            changeSurface(1, gl10, i2, i3);
        } catch (Throwable th) {
            th.printStackTrace();
            zwa.D(th);
        }
    }
}
