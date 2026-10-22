package com.zj.adlib;

import android.app.ActivityManager;
import android.content.Context;
import androidx.collection.ArrayMap;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleEventObserver;
import androidx.p002lifecycle.LifecycleOwner;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.blankj.utilcode.util.Utils;
import com.byazt.hv.TTDownloadField;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.location_ext.BDLocationResultHelper;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.t;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.WholeConfig;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J4\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\"\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\nH\u0002R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00150!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R,\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001b0!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010.¨\u00062"}, d2 = {"Lcom/zj/adlib/lj0;", "", "Landroid/content/Context;", "context", "", "needAddress", "Lcom/baidu/location/LocationClientOption$LocationMode;", "locationMode", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", j.b, "", "internal", "startServiceCheck", "m", "e", t.d, "u", "stopServiceCheck", "s", "Lcom/baidu/location/LocationClient;", y6b.g, "Lcom/baidu/location/LocationClientOption;", y6b.f, "client", "isOnceLocation", "Lcom/baidu/location/BDAbstractLocationListener;", "j", "", "dateStr", "f", "q", "Landroidx/collection/ArrayMap;", "a", "Landroidx/collection/ArrayMap;", "mCacheArray", "b", "mLocationListener", "", "[I", "SUC_TYPE", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledExecutorService;", "scheduledExecutor", "", "I", "restartLocNum", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBDLocationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BDLocationManager.kt\ncom/huachenjie/common/location_ext/BDLocationManager\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n215#2,2:322\n1#3:324\n*S KotlinDebug\n*F\n+ 1 BDLocationManager.kt\ncom/huachenjie/common/location_ext/BDLocationManager\n*L\n306#1:322,2\n*E\n"})
public final class lj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static int restartLocNum;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static ScheduledExecutorService scheduledExecutor;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final lj0 f17965a = new lj0();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final ArrayMap<String, LocationClient> mCacheArray = new ArrayMap<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final ArrayMap<LocationClient, ArrayMap<HCJLocationListener, BDAbstractLocationListener>> mLocationListener = new ArrayMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final int[] SUC_TYPE = {602, 601, 65, 160, 61, 61, 161, 66};

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/lj0$a", "Lcom/baidu/location/BDAbstractLocationListener;", "Lcom/baidu/location/BDLocation;", bo.g, "", "onReceiveLocation", "", "p1", "", "p2", "onLocDiagnosticMessage", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BDAbstractLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayMap<HCJLocationListener, BDAbstractLocationListener> f43079a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ LocationClient f17968a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ HCJLocationListener f17969a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f17970a;

        public a(boolean z, LocationClient locationClient, ArrayMap<HCJLocationListener, BDAbstractLocationListener> arrayMap, HCJLocationListener hCJLocationListener) {
            this.f17970a = z;
            this.f17968a = locationClient;
            this.f43079a = arrayMap;
            this.f17969a = hCJLocationListener;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onLocDiagnosticMessage(int p0, int p1, @Nullable String p2) {
            this.f17969a.onLocationListener(p0, (HCJAddressInfo) null);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x012a  */
        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(@Nullable BDLocation p0) throws ParseException {
            float speed;
            long jF;
            if (this.f17970a) {
                this.f17968a.unRegisterLocationListener(this);
                this.f43079a.remove(this.f17969a);
                this.f17968a.stop();
            }
            BDLocationResultHelper.f33823a.l(p0);
            if (p0 == null) {
                this.f17969a.onLocationListener(-1, (HCJAddressInfo) null);
                return;
            }
            i4a.b("BDLocationManager", "locType：" + p0.getLocType() + "，latitude：" + p0.getLatitude() + "，longitude：" + p0.getLongitude() + "，satellites：" + p0.getSatelliteNumber() + "，speed：" + p0.getSpeed() + "，accuracy：" + p0.getRadius() + "，mockGnssStrategy：" + p0.getMockGnssStrategy() + "，mockGnssProbability：" + p0.getMockGnssProbability() + "，time：" + p0.getTime());
            if (!ArraysKt.contains(lj0.SUC_TYPE, p0.getLocType())) {
                this.f17969a.onLocationListener(p0.getLocType(), (HCJAddressInfo) null);
                return;
            }
            if (r90.f().checkBDMock() && !WholeConfig.isMockEnable() && p0.getMockGnssStrategy() > 0 && p0.getMockGnssProbability() >= 3) {
                this.f17969a.onLocationListener(p0.getLocType(), (HCJAddressInfo) null);
                return;
            }
            HCJAddressInfo hCJAddressInfo = new HCJAddressInfo();
            hCJAddressInfo.setLat(new BigDecimal(p0.getLatitude()).setScale(6, RoundingMode.HALF_UP).doubleValue());
            hCJAddressInfo.setLng(new BigDecimal(p0.getLongitude()).setScale(6, RoundingMode.HALF_UP).doubleValue());
            hCJAddressInfo.setAccuracy(p0.getRadius());
            if (WholeConfig.isMockEnable()) {
                speed = p0.getSpeed() >= 0.0f ? p0.getSpeed() : 0.0f;
            }
            hCJAddressInfo.setSpeed(speed);
            hCJAddressInfo.setDirection(p0.getDirection());
            hCJAddressInfo.setSatellites(p0.getSatelliteNumber() > 0 ? p0.getSatelliteNumber() : 0);
            hCJAddressInfo.setGpsStatus(p0.getLocType() == 61 ? 1 : -1);
            hCJAddressInfo.setMock(p0.getMockGnssStrategy() > 0);
            if (p0.getTimeStamp() > 0) {
                jF = p0.getTimeStamp();
            } else {
                lj0 lj0Var = lj0.f17965a;
                String time = p0.getTime();
                Intrinsics.checkNotNullExpressionValue(time, "p0.time");
                jF = lj0Var.f(time);
            }
            hCJAddressInfo.setTime(jF);
            if (p0.getAddress() != null) {
                hCJAddressInfo.setAddress(p0.getAddress().address);
                hCJAddressInfo.setProvinceName(p0.getProvince());
                hCJAddressInfo.setCityName(p0.getCity());
            }
            this.f17969a.onLocationListener(0, hCJAddressInfo);
        }
    }

    @JvmStatic
    public static final void e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LocationClient locationClient = mCacheArray.get(context.getClass().getName());
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        l(context);
    }

    public static final void i(Context context, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            t(context, false, 2, null);
        }
    }

    public static /* synthetic */ BDAbstractLocationListener k(lj0 lj0Var, LocationClient locationClient, HCJLocationListener hCJLocationListener, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return lj0Var.j(locationClient, hCJLocationListener, z);
    }

    @JvmStatic
    public static final void l(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LocationClient locationClient = mCacheArray.get(context.getClass().getName());
        if (locationClient == null) {
            return;
        }
        locationClient.restart();
        i4a.b("BDLocationManager", "重启定位");
        BDLocationResultHelper bDLocationResultHelper = BDLocationResultHelper.f33823a;
        int i = restartLocNum + 1;
        restartLocNum = i;
        bDLocationResultHelper.k("r" + i);
    }

    @JvmStatic
    public static final void m(@NotNull Context context, long internal, @NotNull HCJLocationListener listener, @NotNull LocationClientOption.LocationMode locationMode, boolean startServiceCheck) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Intrinsics.checkNotNullParameter(locationMode, "locationMode");
        lj0 lj0Var = f17965a;
        LocationClient locationClientH = lj0Var.h(context);
        LocationClientOption locationClientOptionG = lj0Var.g();
        locationClientOptionG.setLocationMode(locationMode);
        locationClientOptionG.setOnceLocation(false);
        locationClientOptionG.setScanSpan((int) internal);
        locationClientOptionG.setWifiCacheTimeOut(1000);
        locationClientH.setLocOption(locationClientOptionG);
        locationClientH.registerLocationListener(k(lj0Var, locationClientH, listener, false, 4, null));
        locationClientH.start();
        if (startServiceCheck) {
            lj0Var.q();
        }
        restartLocNum = 0;
        BDLocationResultHelper.f33823a.i();
    }

    public static /* synthetic */ void n(Context context, long j, HCJLocationListener hCJLocationListener, LocationClientOption.LocationMode locationMode, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            locationMode = LocationClientOption.LocationMode.Hight_Accuracy;
        }
        LocationClientOption.LocationMode locationMode2 = locationMode;
        if ((i & 16) != 0) {
            z = false;
        }
        m(context, j, hCJLocationListener, locationMode2, z);
    }

    @JvmStatic
    public static final void o(@NotNull Context context, boolean needAddress, @NotNull LocationClientOption.LocationMode locationMode, @NotNull HCJLocationListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locationMode, "locationMode");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        lj0 lj0Var = f17965a;
        LocationClient locationClientH = lj0Var.h(context);
        LocationClientOption locationClientOptionG = lj0Var.g();
        locationClientOptionG.setIsNeedAddress(needAddress);
        locationClientOptionG.setLocationMode(locationMode);
        locationClientH.setLocOption(locationClientOptionG);
        locationClientH.registerLocationListener(lj0Var.j(locationClientH, listener, true));
        locationClientH.start();
    }

    public static /* synthetic */ void p(Context context, boolean z, LocationClientOption.LocationMode locationMode, HCJLocationListener hCJLocationListener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            locationMode = LocationClientOption.LocationMode.Hight_Accuracy;
        }
        o(context, z, locationMode, hCJLocationListener);
    }

    public static final void r() {
        Object next;
        ActivityManager activityManager = (ActivityManager) Utils.a().getSystemService(TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNull(activityManager);
        List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
        Intrinsics.checkNotNullExpressionValue(runningServices, "runningServices");
        Iterator<T> it = runningServices.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((ActivityManager.RunningServiceInfo) next).service.getClassName(), "com.baidu.location.f"));
        ActivityManager.RunningServiceInfo runningServiceInfo = (ActivityManager.RunningServiceInfo) next;
        BDLocationResultHelper.f33823a.m(runningServiceInfo != null);
        i4a.b("BDLocationManager", "服务是否存在 " + (runningServiceInfo != null));
    }

    @JvmStatic
    public static final void s(@NotNull Context context, boolean stopServiceCheck) {
        Intrinsics.checkNotNullParameter(context, "context");
        LocationClient locationClient = mCacheArray.get(context.getClass().getName());
        if (locationClient == null) {
            return;
        }
        ArrayMap<HCJLocationListener, BDAbstractLocationListener> arrayMap = mLocationListener.get(locationClient);
        if (arrayMap != null) {
            Iterator<Map.Entry<HCJLocationListener, BDAbstractLocationListener>> it = arrayMap.entrySet().iterator();
            while (it.hasNext()) {
                locationClient.unRegisterLocationListener(it.next().getValue());
            }
        }
        mLocationListener.remove(locationClient);
        locationClient.stop();
        mCacheArray.remove(context.getClass().getName());
        if (stopServiceCheck) {
            try {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutor;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
            } catch (Exception e) {
                i4a.c("close service check fail:" + e.getMessage());
            }
        }
    }

    public static /* synthetic */ void t(Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        s(context, z);
    }

    @JvmStatic
    public static final void u(@NotNull Context context, @NotNull HCJLocationListener listener) {
        ArrayMap<HCJLocationListener, BDAbstractLocationListener> arrayMap;
        BDAbstractLocationListener bDAbstractLocationListener;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        LocationClient locationClient = mCacheArray.get(context.getClass().getName());
        if (locationClient == null || (arrayMap = mLocationListener.get(locationClient)) == null || (bDAbstractLocationListener = arrayMap.get(listener)) == null) {
            return;
        }
        locationClient.unRegisterLocationListener(bDAbstractLocationListener);
        arrayMap.remove(listener);
    }

    public final long f(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(dateStr);
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }

    public final LocationClientOption g() {
        LocationClientOption locationClientOption = new LocationClientOption();
        locationClientOption.setIsNeedAddress(false);
        locationClientOption.setFirstLocType(LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC);
        locationClientOption.setIsNeedLocationPoiList(false);
        locationClientOption.setIsNeedAltitude(false);
        locationClientOption.setIsNeedLocationDescribe(false);
        locationClientOption.setNeedDeviceDirect(true);
        locationClientOption.setCoorType("gcj02");
        locationClientOption.setEnableSimulateGnss(WholeConfig.isMockEnable());
        return locationClientOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LocationClient h(final Context context) {
        LocationClient locationClient;
        ArrayMap<String, LocationClient> arrayMap = mCacheArray;
        if (arrayMap.get(context.getClass().getName()) == null) {
            locationClient = new LocationClient(context.getApplicationContext());
        } else {
            LocationClient locationClient2 = arrayMap.get(context.getClass().getName());
            Intrinsics.checkNotNull(locationClient2);
            locationClient = locationClient2;
        }
        arrayMap.put(context.getClass().getName(), locationClient);
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.zj.adlib.jj0
                @Override // androidx.p002lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    lj0.i(context, lifecycleOwner, event);
                }
            });
        }
        return locationClient;
    }

    public final BDAbstractLocationListener j(LocationClient client, HCJLocationListener listener, boolean isOnceLocation) {
        ArrayMap<HCJLocationListener, BDAbstractLocationListener> arrayMap;
        ArrayMap<LocationClient, ArrayMap<HCJLocationListener, BDAbstractLocationListener>> arrayMap2 = mLocationListener;
        if (arrayMap2.get(client) == null) {
            arrayMap = new ArrayMap<>();
            arrayMap2.put(client, arrayMap);
        } else {
            ArrayMap<HCJLocationListener, BDAbstractLocationListener> arrayMap3 = arrayMap2.get(client);
            Intrinsics.checkNotNull(arrayMap3);
            arrayMap = arrayMap3;
        }
        a aVar = new a(isOnceLocation, client, arrayMap, listener);
        arrayMap.put(listener, aVar);
        return aVar;
    }

    public final void q() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        if (scheduledExecutorServiceNewSingleThreadScheduledExecutor != null) {
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.zj.adlib.kj0
                @Override // java.lang.Runnable
                public final void run() {
                    lj0.r();
                }
            }, 5L, 15L, TimeUnit.SECONDS);
        }
    }
}
