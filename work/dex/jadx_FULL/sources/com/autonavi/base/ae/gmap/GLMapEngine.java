package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.acse.ottn.p3;
import com.amap.api.col.p0003l.it;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import com.zj.adlib.a7b;
import com.zj.adlib.ywa;
import com.zj.adlib.zwa;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class GLMapEngine implements IGLMapEngine, IAMapEngineCallback, NetworkState.NetworkChangeListener {
    private Context context;
    private int mEngineID;
    private IAMapDelegate mGlMapView;
    private IAMapListener mMapListener;
    boolean mRequestDestroy;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    GLMapState state;
    private TerrainOverlayProvider terrainTileProvider;
    private String userAgent;
    private long mNativeMapengineInstance = 0;
    private final List<AbstractCameraUpdateMessage> mStateMessageList = new Vector();
    private final List<AbstractGestureMapMessage> mGestureMessageList = new Vector();
    private List<AbstractGestureMapMessage> mGestureEndMessageList = new Vector();
    private final List<AbstractCameraUpdateMessage> mAnimateStateMessageList = new Vector();
    boolean isMoveCameraStep = false;
    boolean isGestureStep = false;
    private int mapGestureCount = 0;
    private GLMapState copyGLMapState = null;
    private Lock mLock = new ReentrantLock();
    private Object mutLock = new Object();
    private NetworkState mNetworkState = null;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle = null;
    private boolean isEngineRenderComplete = false;
    Map<Long, AMapLoader> aMapLoaderHashtable = new ConcurrentHashMap();
    boolean isNetworkConnected = false;
    private AtomicInteger mRequestID = new AtomicInteger(1);

    public static class InitParam {
        public String mRootPath = "";
        public String mConfigPath = "";
        public String mConfigContent = "";
        public String mOfflineDataPath = "";
        public String mP3dCrossPath = "";
        public String mIntersectionResPath = "";
    }

    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount = 8;
        public float textScale;
        public int width;
        public int x;
        public int y;
    }

    public GLMapEngine(Context context, IAMapDelegate iAMapDelegate) {
        this.mGlMapView = null;
        this.mapAnimationMgr = null;
        this.mRequestDestroy = false;
        this.terrainTileProvider = null;
        this.mRequestDestroy = false;
        if (context == null) {
            return;
        }
        this.context = context.getApplicationContext();
        this.mGlMapView = iAMapDelegate;
        this.mTextTextureGenerator = new TextTextureGenerator();
        AdglMapAnimationMgr adglMapAnimationMgr = new AdglMapAnimationMgr();
        this.mapAnimationMgr = adglMapAnimationMgr;
        adglMapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.5
            @Override // com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
            public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
            }
        });
        this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(context);
        this.terrainTileProvider = new TerrainOverlayProvider(iAMapDelegate.getGlOverlayLayer());
        this.mEngineID = GLEngineIDController.getController().generate();
    }

    private float adapterDpiScale(DisplayMetrics displayMetrics, int i, int i2, int i3) {
        int i4;
        int i5;
        String emui = getEMUI();
        if (emui == null || emui.isEmpty()) {
            return 1.0f;
        }
        if ((emui.indexOf("EmotionUI_8") == -1 && emui.indexOf("EmotionUI_9") == -1) || i3 <= 0) {
            return 1.0f;
        }
        int i6 = 0;
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField("noncompatWidthPixels");
            declaredField.setAccessible(true);
            i4 = declaredField.getInt(displayMetrics);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            i4 = 0;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            i4 = 0;
        }
        try {
            Field declaredField2 = DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
            declaredField2.setAccessible(true);
            i5 = declaredField2.getInt(displayMetrics);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            i5 = 0;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            i5 = 0;
        }
        try {
            Field declaredField3 = DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
            declaredField3.setAccessible(true);
            i6 = declaredField3.getInt(displayMetrics);
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
        }
        if (i6 <= i3 && i4 <= i && i5 <= i2) {
            return 1.0f;
        }
        float f = i6 / i3;
        if (f > 2.0f) {
            f = 2.0f;
        }
        if (f < 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onCancel();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onFinish();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i = this.mapGestureCount - 1;
        this.mapGestureCount = i;
        if (i == 0) {
            recycleMessage();
        }
    }

    private static String getEMUI() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(p3.f, String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        AbstractCameraUpdateMessage abstractCameraUpdateMessageRemove;
        if (this.mStateMessageList.size() > 0) {
            return;
        }
        synchronized (this.mAnimateStateMessageList) {
            abstractCameraUpdateMessageRemove = this.mAnimateStateMessageList.size() > 0 ? this.mAnimateStateMessageList.remove(0) : null;
        }
        if (abstractCameraUpdateMessageRemove != null) {
            abstractCameraUpdateMessageRemove.generateMapAnimation(this);
        }
    }

    private void initNetworkState() {
        NetworkState networkState = new NetworkState();
        this.mNetworkState = networkState;
        networkState.setNetworkListener(this);
        this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        boolean zIsNetworkConnected = NetworkState.isNetworkConnected(this.context.getApplicationContext());
        this.isNetworkConnected = zIsNetworkConnected;
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetNetStatus(j, zIsNetworkConnected ? 1 : 0);
        }
    }

    public static native void nativeAddGestureSingleTapMessage(int i, long j, float f, float f2);

    public static native String nativeAddNativeOverlay(int i, long j, int i2, int i3);

    private static native boolean nativeAddOverlayTexture(int i, long j, int i2, int i3, float f, float f2, Bitmap bitmap, boolean z, boolean z2);

    private static native void nativeCancelDownLoad(long j);

    private static native void nativeCreateAMapEngineWithFrame(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3, int i8);

    private static native long nativeCreateAMapInstance(float f, float f2, float f3, int i);

    public static native long nativeCreateOverlay(int i, long j, int i2);

    private static native int nativeCreateTextureFromImage(int i, long j, Bitmap bitmap);

    private static native void nativeDestroy(long j);

    private static native void nativeDestroyCurrentState(long j, long j2);

    public static native void nativeDestroyOverlay(int i, long j);

    private static native void nativeFailedDownLoad(long j, int i);

    private static native void nativeFinishDownLoad(long j);

    private static native void nativeGetCurTileIDs(int i, long j, int[] iArr, int i2);

    private static native long nativeGetCurrentMapState(int i, long j);

    private static native long nativeGetGlOverlayMgrPtr(int i, long j);

    public static native String nativeGetMapEngineVersion(int i);

    private static native int[] nativeGetMapModeState(int i, long j, boolean z);

    public static native String nativeGetMapSDKDeps();

    public static native String nativeGetMapSDKVersion();

    public static native long nativeGetNativeMapController(int i, long j);

    public static native int[] nativeGetScreenShot(int i, long j, int i2, int i3, int i4, int i5);

    private static native boolean nativeGetSrvViewStateBoolValue(int i, long j, int i2);

    private static native void nativeInitAMapEngineCallback(long j, Object obj);

    private static native void nativeInitOpenLayer(int i, long j, byte[] bArr);

    private static native void nativeInitParam(String str, String str2, String str3, String str4, String str5, String str6, int i);

    private static native boolean nativeIsEngineCreated(long j, int i);

    private static native void nativePopRenderState(int i, long j);

    private static native void nativePostRenderAMap(long j, int i);

    private static native void nativePushRendererState(int i, long j);

    private static native void nativeReceiveNetData(byte[] bArr, long j, int i);

    public static native void nativeRemoveNativeAllOverlay(int i, long j);

    public static native void nativeRemoveNativeOverlay(int i, long j, String str);

    private static native void nativeRenderAMap(long j, int i);

    private static native void nativeSetAllContentEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingTextureEnable(int i, long j, boolean z);

    private static native void nativeSetCustomStyleData(int i, long j, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i, long j, byte[] bArr);

    private static native void nativeSetCustomThirdLayerStyle(int i, long j, String str);

    private static native void nativeSetHighlightSubwayEnable(int i, long j, boolean z);

    private static native void nativeSetIndoorBuildingToBeActive(int i, long j, String str, int i2, String str2);

    private static native void nativeSetIndoorEnable(int i, long j, boolean z);

    private static native void nativeSetLabelEnable(int i, long j, boolean z);

    private static native boolean nativeSetMapModeAndStyle(int i, long j, int[] iArr);

    private static native void nativeSetNaviLabelEnable(int i, long j, boolean z, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetNetStatus(long j, int i);

    private static native void nativeSetOfflineDataEnable(int i, long j, boolean z);

    private static native void nativeSetOpenLayerEnable(int i, long j, boolean z);

    private static native void nativeSetParameter(int i, long j, int i2, int i3, int i4, int i5, int i6);

    private static native void nativeSetProjectionCenter(int i, long j, float f, float f2);

    private static native void nativeSetRenderListenerStatus(int i, long j);

    private static native void nativeSetRoadArrowEnable(int i, long j, boolean z);

    private static native void nativeSetServiceViewRect(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void nativeSetSetBackgroundTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i, long j, boolean z);

    private static native void nativeSetSkyTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i, long j, int i2, boolean z);

    private static native void nativeSetStyleChangeGradualEnable(int i, long j, boolean z);

    public static native void nativeSetTerrainAuth(int i, long j, boolean z);

    private static native void nativeSetTrafficEnable(int i, long j, boolean z);

    private static native void nativeSetTrafficTexture(int i, long j, byte[] bArr, long j2, int i2, int i3, int i4, int i5);

    private static native void nativeSetTrafficTextureAllInOne(int i, long j, byte[] bArr);

    public static native void nativeSetVectorOverlayPath(int i, long j, String str);

    public static native void nativeUpdateNativeArrowOverlay(int i, long j, String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, boolean z, int i5, int i6, int i7);

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r3.width != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r3.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
    
        if (r3.height != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        r3.height = r5.mGlMapView.getMapHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
    
        r2 = r3.getMapGestureState();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
    
        if (r2 != 100) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        gestureBegin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
    
        if (r2 != 101) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        r3.runCameraUpdate(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0069, code lost:
    
        if (r2 != 102) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        gestureEnd();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean processGestureMessage(GLMapState gLMapState) {
        AbstractGestureMapMessage abstractGestureMapMessageRemove;
        if (this.mGestureMessageList.size() <= 0) {
            if (this.isGestureStep) {
                this.isGestureStep = false;
            }
            return false;
        }
        this.isGestureStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mGestureMessageList) {
                abstractGestureMapMessageRemove = this.mGestureMessageList.size() > 0 ? this.mGestureMessageList.remove(0) : null;
                if (abstractGestureMapMessageRemove == null) {
                    break;
                }
            }
            this.mGestureEndMessageList.add(abstractGestureMapMessageRemove);
        }
        if (this.mGestureEndMessageList.size() > 0) {
            recycleMessage();
        }
        return true;
    }

    private boolean processMessage() {
        try {
            GLMapState gLMapState = (GLMapState) getNewMapState(this.mEngineID);
            boolean zProcessGestureMessage = processGestureMessage(gLMapState);
            boolean z = true;
            if (this.mGestureMessageList.size() <= 0) {
                zProcessGestureMessage = zProcessGestureMessage || processStateMapMessage(gLMapState);
            } else {
                synchronized (this.mStateMessageList) {
                    if (this.mStateMessageList.size() > 0) {
                        this.mStateMessageList.clear();
                    }
                }
            }
            if (!zProcessGestureMessage && !processAnimations(gLMapState)) {
                z = false;
            }
            if (z) {
                gLMapState.setCameraDegree(zwa.i(this.mGlMapView.getMapConfig(), gLMapState.getCameraDegree(), gLMapState.getMapZoomer()));
                setMapState(this.mEngineID, gLMapState);
            }
            gLMapState.recycle();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        AbstractCameraUpdateMessage abstractCameraUpdateMessageRemove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mStateMessageList) {
                abstractCameraUpdateMessageRemove = this.mStateMessageList.size() > 0 ? this.mStateMessageList.remove(0) : null;
                if (abstractCameraUpdateMessageRemove == null) {
                    return true;
                }
            }
            if (abstractCameraUpdateMessageRemove.width == 0) {
                abstractCameraUpdateMessageRemove.width = this.mGlMapView.getMapWidth();
            }
            if (abstractCameraUpdateMessageRemove.height == 0) {
                abstractCameraUpdateMessageRemove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            abstractCameraUpdateMessageRemove.runCameraUpdate(gLMapState);
        }
    }

    private void recycleMessage() {
        AbstractGestureMapMessage abstractGestureMapMessageRemove;
        while (this.mGestureEndMessageList.size() > 0 && (abstractGestureMapMessageRemove = this.mGestureEndMessageList.remove(0)) != null) {
            if (abstractGestureMapMessageRemove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) abstractGestureMapMessageRemove).recycle();
            } else if (abstractGestureMapMessageRemove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) abstractGestureMapMessageRemove).recycle();
            } else if (abstractGestureMapMessageRemove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) abstractGestureMapMessageRemove).recycle();
            } else if (abstractGestureMapMessageRemove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) abstractGestureMapMessageRemove).recycle();
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void OnIndoorBuildingActivity(int i, byte[] bArr) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addGestureMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage, boolean z, int i2, int i3) {
        if (abstractGestureMapMessage == null) {
            return;
        }
        abstractGestureMapMessage.isGestureScaleByMapCenter = z;
        synchronized (this.mGestureMessageList) {
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    public void addGestureSingleTapMessage(float f, float f2) {
        nativeAddGestureSingleTapMessage(this.mEngineID, this.mNativeMapengineInstance, f, f2);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i2);
        adglMapAnimGroup.setToCameraDegree(i4, 0);
        adglMapAnimGroup.setToMapAngle(i3, 0);
        adglMapAnimGroup.setToMapLevel(f, 0);
        adglMapAnimGroup.setToMapCenterGeo(i5, i6, 0);
        if (this.mapAnimationMgr == null || !adglMapAnimGroup.isValid()) {
            return;
        }
        this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z) {
        if (!z) {
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.add(abstractCameraUpdateMessage);
            }
        } else {
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
        }
    }

    public String addNativeOverlay(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return null;
        }
        String strNativeAddNativeOverlay = nativeAddNativeOverlay(i, j, i2, i3);
        if (TextUtils.isEmpty(strNativeAddNativeOverlay)) {
            return null;
        }
        return strNativeAddNativeOverlay;
    }

    public void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        Bitmap bitmap;
        if (this.mNativeMapengineInstance == 0 || gLTextureProperty == null || (bitmap = gLTextureProperty.mBitmap) == null || bitmap.isRecycled()) {
            return;
        }
        nativeAddOverlayTexture(i, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
    }

    public boolean canStopMapRender(int i) {
        return this.isEngineRenderComplete;
    }

    public void cancelAllAMapDownload() {
        try {
            Iterator<Map.Entry<Long, AMapLoader>> it = this.aMapLoaderHashtable.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().doCancelAndNotify();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void cancelRequireMapData(Object obj) {
        if (obj == null || !(obj instanceof AMapLoader)) {
            return;
        }
        ((AMapLoader) obj).doCancel();
    }

    public void changeSurface(int i, int i2) {
    }

    public void clearAllMessages(int i) {
    }

    public void clearAnimations(int i, boolean z) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.x, mapViewInitParam.y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale, mapViewInitParam.taskThreadCount);
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                setCustomStyleData(mapViewInitParam.engineId, FileUtil.uncompressToByteArray(FileUtil.readFileContentsFromAssets(this.context, "map_assets/style_1_17_for_terrain.data")), null);
            }
        }
    }

    public boolean createAMapInstance(InitParam initParam) {
        if (initParam == null) {
            return false;
        }
        synchronized (GLMapEngine.class) {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            float f = displayMetrics.density;
            float fAdapterDpiScale = adapterDpiScale(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, i);
            this.mGlMapView.getMapConfig().setTerrainEnable(MapsInitializer.isTerrainEnable());
            int i2 = MapsInitializer.isTerrainEnable() ? 1 : 0;
            nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath, "http://mpsapi.amap.com/", "http://m5.amap.com/", i);
            InitStorageParam.Holder.initPath(initParam.mP3dCrossPath);
            long jNativeCreateAMapInstance = nativeCreateAMapInstance(i, f, fAdapterDpiScale, i2);
            this.mNativeMapengineInstance = jNativeCreateAMapInstance;
            if (jNativeCreateAMapInstance == 0) {
                return false;
            }
            nativeInitAMapEngineCallback(jNativeCreateAMapInstance, this);
            initNetworkState();
            return true;
        }
    }

    public long createOverlay(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeCreateOverlay(i, j, i2);
        }
        return 0L;
    }

    public int createOverlayTexture(int i, Bitmap bitmap) {
        if (this.mNativeMapengineInstance == 0 || bitmap == null || bitmap.isRecycled()) {
            return -1;
        }
        return nativeCreateTextureFromImage(i, this.mNativeMapengineInstance, bitmap);
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            cancelAllAMapDownload();
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    this.mLock.lock();
                    try {
                        GLMapState gLMapState = this.copyGLMapState;
                        if (gLMapState != null) {
                            gLMapState.recycle();
                        }
                        this.mLock.unlock();
                        nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                        nativeDestroy(this.mNativeMapengineInstance);
                    } catch (Throwable th) {
                        this.mLock.unlock();
                        throw th;
                    }
                }
                this.mNativeMapengineInstance = 0L;
            }
            this.mGlMapView = null;
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.clear();
            }
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
            }
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.clear();
            }
            this.mGestureEndMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            ywa.c();
        } catch (Throwable th2) {
            th2.printStackTrace();
            zwa.D(th2);
        }
    }

    public void destroyOverlay(int i, long j) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i, j);
        }
    }

    public synchronized void finishDownLoad(int i, long j) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            nativeFinishDownLoad(j);
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    public GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(this.mEngineID, j);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            return this.copyGLMapState;
        } finally {
            this.mLock.unlock();
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i, int[] iArr) {
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            nativeGetCurTileIDs(i, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public BitmapDescriptor getDefaultTerrainImage() {
        return this.terrainTileProvider.getDefaultTerrain();
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return this.mEngineID;
    }

    public int getEngineIDWithType(int i) {
        return this.mEngineID;
    }

    public long getGlOverlayMgrPtr(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetGlOverlayMgrPtr(i, j);
        }
        return 0L;
    }

    public boolean getIsProcessBuildingMark(int i) {
        return false;
    }

    public boolean getMapDataTaskIsCancel(int i, long j) {
        return !this.aMapLoaderHashtable.containsKey(Long.valueOf(j));
    }

    public int[] getMapModeState(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return null;
        }
        nativeGetMapModeState(i, j, z);
        return null;
    }

    public GLMapState getMapState(int i) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0 && this.state == null) {
                long jNativeGetCurrentMapState = nativeGetCurrentMapState(i, j);
                if (jNativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(i, this.mNativeMapengineInstance, jNativeGetCurrentMapState);
                }
            }
            return this.state;
        } finally {
            this.mLock.unlock();
        }
    }

    public long getMapStateInstance(int i) {
        return 0L;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetNativeMapController(i, j);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public IGLMapState getNewMapState(int i) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                return new GLMapState(i, j);
            }
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i) {
        return this.bundle;
    }

    public Bitmap getScreenShot(int i, int i2, int i3, int i4, int i5) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return zwa.p(nativeGetScreenShot(i, j, i2, i3, i4, i5), i4 - i2, i5 - i3, true);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public List<BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public boolean getSrvViewStateBoolValue(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetSrvViewStateBoolValue(i, j, i2);
        }
        return false;
    }

    public AbstractCameraUpdateMessage getStateMessage() {
        synchronized (this.mStateMessageList) {
            if (this.mStateMessageList.size() == 0) {
                return null;
            }
            return this.mStateMessageList.remove(0);
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public InitStorageParam getStorageInitParam() {
        return InitStorageParam.obtain();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void initMapOpenLayer(String str) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || str == null) {
            return;
        }
        nativeInitOpenLayer(this.mEngineID, j, str.getBytes());
    }

    public void initNativeTexture(int i) {
        try {
            BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = bitmapDescriptorFromAsset != null ? bitmapDescriptorFromAsset.getBitmap() : null;
            BitmapDescriptor bitmapDescriptorFromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap2 = bitmapDescriptorFromAsset2 != null ? bitmapDescriptorFromAsset2.getBitmap() : null;
            BitmapDescriptor bitmapDescriptorFromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            Bitmap bitmap3 = bitmapDescriptorFromAsset3 != null ? bitmapDescriptorFromAsset3.getBitmap() : null;
            addOverlayTexture(i, bitmap, 111, 4);
            addOverlayTexture(i, bitmap2, 222, 4);
            addOverlayTexture(i, bitmap3, 333, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(this.mEngineID)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(this.mEngineID, false);
            } catch (Throwable th) {
                a7b.m(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeIsEngineCreated(j, i);
        }
        return false;
    }

    public boolean isInMapAction(int i) {
        return false;
    }

    public boolean isInMapAnimation(int i) {
        return getAnimateionsCount() > 0;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    public synchronized void netCancel(int i, long j, int i2) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            nativeFailedDownLoad(j, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
        }
    }

    public synchronized void netError(int i, long j, int i2, int i3) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            nativeFailedDownLoad(j, i3);
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
            try {
                if (MapsInitializer.getExceptionLogger() != null) {
                    MapsInitializer.getExceptionLogger().onDownloaderException(i2, i3);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void netStop(int i, long j, int i2) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            nativeCancelDownLoad(j);
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener
    public void networkStateChanged(Context context) {
        if (this.mRequestDestroy || this.mNativeMapengineInstance == 0 || this.mGlMapView == null) {
            return;
        }
        this.isNetworkConnected = NetworkState.isNetworkConnected(context);
        this.mGlMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.4
            @Override // java.lang.Runnable
            public void run() {
                GLMapEngine.nativeSetNetStatus(GLMapEngine.this.mNativeMapengineInstance, GLMapEngine.this.isNetworkConnected ? 1 : 0);
            }
        });
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.onAMapAppResourceRequest(aMapAppRequestParam);
        }
    }

    public void onClearCache(int i) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapBlandClick(double d, double d2) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapBlankClick(d, d2);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapPOIClick(MapPoi mapPoi) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapPOIClick(mapPoi);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapRender(int i, int i2) {
        try {
            if (i2 == 5) {
                IAMapListener iAMapListener = this.mMapListener;
                if (iAMapListener != null) {
                    iAMapListener.beforeDrawLabel(i, getMapState(i));
                    return;
                }
                return;
            }
            if (i2 == 6) {
                IAMapListener iAMapListener2 = this.mMapListener;
                if (iAMapListener2 != null) {
                    iAMapListener2.afterDrawLabel(i, getMapState(i));
                    return;
                }
                return;
            }
            if (i2 != 7) {
                if (i2 != 13) {
                    return;
                }
                this.isEngineRenderComplete = true;
            } else {
                IAMapListener iAMapListener3 = this.mMapListener;
                if (iAMapListener3 != null) {
                    iAMapListener3.afterRendererOver(i, getMapState(i));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void popRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePopRenderState(this.mEngineID, j);
        }
    }

    public void pushRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePushRendererState(this.mEngineID, j);
        }
    }

    public void putResourceData(int i, byte[] bArr) {
    }

    public synchronized void receiveNetData(int i, long j, byte[] bArr, int i2) {
        if (this.mRequestDestroy) {
            return;
        }
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            nativeReceiveNetData(bArr, j, i2);
        }
    }

    public void releaseNetworkState() {
        NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.mNetworkState.setNetworkListener(null);
            this.mNetworkState = null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i, String str, int i2) {
    }

    public void removeNativeAllOverlay(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeRemoveNativeAllOverlay(i, j);
        }
    }

    public void removeNativeOverlay(int i, String str) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || str == null) {
            return;
        }
        nativeRemoveNativeOverlay(i, j, str);
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean zProcessMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
                nativePostRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
            }
            initAnimation();
            if (zProcessMessage) {
                startCheckEngineRenderComplete();
            }
            if (this.isEngineRenderComplete) {
                return;
            }
            nativeSetRenderListenerStatus(this.mEngineID, this.mNativeMapengineInstance);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharBitmap(int i, int i2, int i3) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i2, i3);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public int requireMapDataAsyn(int i, byte[] bArr) {
        if (!this.mRequestDestroy && bArr != null) {
            AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
            int i2 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i2);
            int i3 = i2 + 4;
            int i4 = GLConvertUtil.getInt(bArr, i3);
            int i5 = i3 + 4;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i5, i4);
            int i6 = i5 + i4;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i6);
            int i7 = i6 + 8;
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i7);
            int i8 = i7 + 4;
            int i9 = GLConvertUtil.getInt(bArr, i8);
            int i10 = i8 + 4;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i10, i9);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i10 + i9);
            final AMapLoader aMapLoader = new AMapLoader(i, this, aDataRequestParam);
            this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            try {
                ywa.a().b(new it() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.1
                    @Override // com.amap.api.col.p0003l.it
                    public void runTask() {
                        AMapLoader aMapLoader2;
                        try {
                            if (GLMapEngine.this.mRequestDestroy || (aMapLoader2 = aMapLoader) == null) {
                                return;
                            }
                            aMapLoader2.doRequest();
                        } catch (Throwable th) {
                            a7b.m(th, "download Thread", "AMapLoader doRequest");
                            zwa.D(th);
                        }
                    }
                });
            } catch (Throwable th) {
                a7b.m(th, "download Thread", "requireMapData");
                zwa.D(th);
            }
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i, int i2, int i3) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireMapResource(int i, String str) {
        byte[] fileContentsFromAssets;
        if (str == null) {
            return null;
        }
        String strConcat = "map_assets/".concat(str);
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (this.mGlMapView.getCustomStyleManager() != null) {
                    fileContentsFromAssets = this.mGlMapView.getCustomStyleManager().i(str);
                    if (fileContentsFromAssets != null) {
                        return fileContentsFromAssets;
                    }
                } else {
                    fileContentsFromAssets = null;
                }
                if (str.startsWith("icons_5")) {
                    fileContentsFromAssets = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    fileContentsFromAssets = FileUtil.readFileContentsFromAssets(this.context, strConcat);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        fileContentsFromAssets = zwa.S(fileContentsFromAssets, customBackgroundColor);
                    }
                }
                if (fileContentsFromAssets != null) {
                    return fileContentsFromAssets;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, strConcat);
        } catch (Throwable th) {
            zwa.D(th);
            return null;
        }
    }

    public void setAllContentEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            if (z) {
                nativeSetAllContentEnable(i, j, true);
            } else {
                nativeSetAllContentEnable(i, j, false);
            }
            setSimple3DEnable(i, false);
        }
    }

    public void setBackgroundTexture(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSetBackgroundTexture(i, j, bArr);
        }
    }

    public void setBuildingEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingEnable(i, j, z);
        }
    }

    public void setBuildingTextureEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingTextureEnable(i, j, z);
        }
    }

    public void setCustomStyleData(int i, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetCustomStyleData(i, j, bArr, bArr2);
        }
    }

    public void setCustomStyleTexture(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetCustomStyleTexture(i, j, bArr);
        }
    }

    public void setCustomThirdLayerStyle(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetCustomThirdLayerStyle(this.mEngineID, j, str);
        }
    }

    public void setHighlightSubwayEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetHighlightSubwayEnable(i, j, z);
        }
    }

    public void setIndoorBuildingToBeActive(int i, String str, int i2, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetIndoorBuildingToBeActive(i, j, str, i2, str2);
        }
    }

    public void setIndoorEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetIndoorEnable(i, j, z);
        }
    }

    public void setInternaltexture(int i, byte[] bArr, int i2) {
    }

    public void setLabelEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetLabelEnable(i, j, z);
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public void setMapLoaderToTask(int i, long j, AMapLoader aMapLoader) {
    }

    public boolean setMapModeAndStyle(int i, int i2, int i3, boolean z, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i, i2, i3);
        if (styleItemArr != null && z) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                setBackgroundTexture(i, zwa.S(FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME), customBackgroundColor));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i, FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i2 == 0 && i3 == 0) {
            Context context = this.context;
            StringBuilder sb = new StringBuilder(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            String str = File.separator;
            sb.append(str);
            sb.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            setBackgroundTexture(i, FileUtil.readFileContentsFromAssets(context, sb.toString()));
            setCustomStyleTexture(i, FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + str + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayerEnable(boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetOpenLayerEnable(this.mEngineID, j, z);
        }
    }

    public void setMapState(int i, GLMapState gLMapState) {
        setMapState(i, gLMapState, true);
    }

    public boolean setNativeMapModeAndStyle(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i, j, new int[]{i2, i3});
    }

    public void setNaviLabelEnable(int i, boolean z, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetNaviLabelEnable(i, j, z, i2, i3);
        }
    }

    public void setOfflineDataEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetOfflineDataEnable(i, j, z);
        }
    }

    public void setOvelayBundle(int i, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetParameter(i, j, i2, i3, i4, i5, i6);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void setProjectionCenter(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetProjectionCenter(i, j, i2, i3);
        }
    }

    public void setRoadArrowEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetRoadArrowEnable(i, j, z);
        }
    }

    public void setServiceViewRect(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        nativeSetServiceViewRect(i, this.mNativeMapengineInstance, i2, i3, i4, i5, i6, i7);
    }

    public void setSimple3DEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSimple3DEnable(i, j, z);
        }
    }

    public void setSkyTexture(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSkyTexture(i, j, bArr);
        }
    }

    public void setSrvViewStateBoolValue(int i, int i2, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSrvViewStateBoolValue(i, j, i2, z);
        }
    }

    public void setStyleChangeGradualEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetStyleChangeGradualEnable(i, j, z);
        }
    }

    public void setTerrainAuth(boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return;
        }
        nativeSetTerrainAuth(this.mEngineID, j, z);
    }

    public void setTrafficEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetTrafficEnable(i, j, z);
        }
    }

    public void setTrafficStyleWithTexture(int i, byte[] bArr, MyTrafficStyle myTrafficStyle) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || myTrafficStyle == null) {
            return;
        }
        nativeSetTrafficTexture(i, j, bArr, bArr.length, myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
    }

    public void setTrafficStyleWithTextureData(int i, byte[] bArr) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || bArr == null) {
            return;
        }
        nativeSetTrafficTextureAllInOne(i, j, bArr);
    }

    public void setVectorOverlayPath(String str) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return;
        }
        nativeSetVectorOverlayPath(this.mEngineID, j, str);
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i, Point point, float f, float f2) {
        if (point == null) {
            return;
        }
        try {
            clearAnimations(i, true);
            GLMapState cloneMapState = getCloneMapState();
            cloneMapState.reset();
            cloneMapState.recalculate();
            float fAbs = Math.abs(f);
            float fAbs2 = Math.abs(f2);
            float f3 = 12000.0f;
            if ((fAbs > fAbs2 ? fAbs : fAbs2) > 12000.0f) {
                if (fAbs > fAbs2) {
                    f3 = (12000.0f / fAbs) * f2;
                    f = f > 0.0f ? 12000.0f : -12000.0f;
                } else {
                    float f4 = (12000.0f / fAbs2) * f;
                    if (f2 > 0.0f) {
                        f = f4;
                    } else {
                        f = f4;
                        f2 = -12000.0f;
                    }
                }
                f2 = f3;
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                AdglMapAnimFlingP20 adglMapAnimFlingP20 = new AdglMapAnimFlingP20(500);
                adglMapAnimFlingP20.setPositionAndVelocity(f, f2);
                adglMapAnimFlingP20.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFlingP20, null);
                return;
            }
            int mapWidth = this.mGlMapView.getMapWidth() >> 1;
            int mapHeight = this.mGlMapView.getMapHeight() >> 1;
            if (this.mGlMapView.isUseAnchor()) {
                mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
            }
            AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
            adglMapAnimFling.setPositionAndVelocity(f, f2);
            adglMapAnimFling.commitAnimation(cloneMapState);
            this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void startPivotZoomRotateAnim(int i, Point point, float f, int i2, int i3) {
    }

    public void updateNativeArrowOverlay(int i, String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, int i5, int i6, int i7, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || str == null) {
            return;
        }
        nativeUpdateNativeArrowOverlay(i, j, str, iArr, iArr2, i2, i3, i4, f, z, i5, i6, i7);
    }

    public void clearAnimations(int i, boolean z, int i2) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void setMapState(int i, GLMapState gLMapState, boolean z) {
        IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (z && (iAMapDelegate = this.mGlMapView) != null && iAMapDelegate.getMapConfig() != null) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void addOverlayTexture(int i, Bitmap bitmap, int i2, int i3) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i2;
        gLTextureProperty.mAnchor = i3;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i, gLTextureProperty);
    }
}
