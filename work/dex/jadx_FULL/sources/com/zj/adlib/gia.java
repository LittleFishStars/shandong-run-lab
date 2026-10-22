package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.col.p0003l.n;
import com.amap.api.col.p0003l.o;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class gia implements IMapFragmentDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f41914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f16776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapOptions f16778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMap f16779a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16777a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16780a = true;

    public gia(int i) {
        this.b = 0;
        this.b = i % 3;
        d();
    }

    public static void a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName() != null && stackTrace[i].getClassName().endsWith("TextureMapView")) {
                    z2 = true;
                }
                if (stackTrace[i].getClassName() != null && stackTrace[i].getClassName().endsWith("Fragment")) {
                    z = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i].getMethodName())) {
                    z3 = true;
                }
            }
            if (z && z2 && !z3) {
                e();
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        if (context != null) {
            f41914a = context.getApplicationContext();
        }
    }

    public static void d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 80; i++) {
                sb.append("=");
            }
            f16776a = sb.toString();
        } catch (Throwable unused) {
        }
    }

    public static void e() {
        Log.i("errorLog", f16776a);
        Log.i("errorLog", "OnDestroy 方法需要在OnDestroyView中调用");
        Log.i("errorLog", f16776a);
    }

    public final void c(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.f16779a == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f16779a.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.f16779a.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.f16779a.setMapType(aMapOptions.getMapType());
        this.f16779a.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final IAMap getMap() throws RemoteException {
        if (this.f16779a == null) {
            if (f41914a == null) {
                Log.w("MapFragmentDelegateImp", "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
                return null;
            }
            int i = f41914a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                qwb.f44317a = 0.5f;
            } else if (i <= 160) {
                qwb.f44317a = 0.8f;
            } else if (i <= 240) {
                qwb.f44317a = 0.87f;
            } else if (i <= 320) {
                qwb.f44317a = 1.0f;
            } else if (i <= 480) {
                qwb.f44317a = 1.5f;
            } else if (i <= 640) {
                qwb.f44317a = 1.8f;
            } else {
                qwb.f44317a = 0.9f;
            }
            int i2 = this.b;
            if (i2 == 0) {
                this.f16779a = new n(f41914a, this.f16780a).a();
            } else if (i2 == 1) {
                this.f16779a = new o(f41914a, this.f16780a).a();
            } else {
                this.f16779a = new fjb(f41914a).a();
            }
        }
        return this.f16779a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void loadWorldVectorMap(boolean z) {
        this.f16780a = z;
        IAMap iAMap = this.f16779a;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onCreate(Bundle bundle) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (f41914a == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            IAMap map = getMap();
            this.f16779a = map;
            map.setVisibilityEx(this.f16777a);
            if (this.f16778a == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                this.f16778a = AMapOptions.CREATOR.createFromParcel(parcelObtain);
            }
            c(this.f16778a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f16779a.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroy() throws RemoteException {
        a();
        IAMap iAMap = this.f16779a;
        if (iAMap != null) {
            iAMap.clear();
            this.f16779a.destroy();
            this.f16779a = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity.getApplicationContext());
        this.f16778a = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onPause() throws RemoteException {
        IAMap iAMap = this.f16779a;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onResume() throws RemoteException {
        IAMap iAMap = this.f16779a;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.f16779a != null) {
            if (this.f16778a == null) {
                this.f16778a = new AMapOptions();
            }
            try {
                Parcel parcelObtain = Parcel.obtain();
                AMapOptions aMapOptionsCamera = this.f16778a.camera(getMap().getCameraPosition());
                this.f16778a = aMapOptionsCamera;
                aMapOptionsCamera.writeToParcel(parcelObtain, 0);
                bundle.putByteArray("MAP_OPTIONS", parcelObtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setContext(Context context) {
        b(context);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setOptions(AMapOptions aMapOptions) {
        this.f16778a = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setVisibility(int i) {
        this.f16777a = i;
        IAMap iAMap = this.f16779a;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i);
        }
    }
}
