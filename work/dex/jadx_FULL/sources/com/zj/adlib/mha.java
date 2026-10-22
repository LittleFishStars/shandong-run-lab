package com.zj.adlib;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"NewApi"})
public final class mha {
    public static boolean e = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f18195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f18201a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PendingIntent f18194a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18208a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GeoFenceListener f18196a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f18207a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f43302a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<GeoFence> f18209a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f18205a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f18211b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Object f18213c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f18203a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f18204a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f18210a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile boolean f18212b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public volatile boolean f18214c = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zma f18206a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kra f18202a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClient f18198a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile AMapLocation f18197a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18193a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption f18199a = null;
    public int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationListener f18200a = new a();
    public final int c = 3;
    public volatile boolean d = false;

    public class a implements AMapLocationListener {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:17:0x005d A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:2:0x0000, B:5:0x0007, B:8:0x000e, B:10:0x001b, B:12:0x0025, B:17:0x005d, B:19:0x0066, B:21:0x0071, B:22:0x0083, B:24:0x008d, B:13:0x0035), top: B:27:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0066 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:2:0x0000, B:5:0x0007, B:8:0x000e, B:10:0x001b, B:12:0x0025, B:17:0x005d, B:19:0x0066, B:21:0x0071, B:22:0x0083, B:24:0x008d, B:13:0x0035), top: B:27:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x0071 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:2:0x0000, B:5:0x0007, B:8:0x000e, B:10:0x001b, B:12:0x0025, B:17:0x005d, B:19:0x0066, B:21:0x0071, B:22:0x0083, B:24:0x008d, B:13:0x0035), top: B:27:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x008d A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #0 {all -> 0x0099, blocks: (B:2:0x0000, B:5:0x0007, B:8:0x000e, B:10:0x001b, B:12:0x0025, B:17:0x005d, B:19:0x0066, B:21:0x0071, B:22:0x0083, B:24:0x008d, B:13:0x0035), top: B:27:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            int errorCode;
            boolean z;
            Bundle bundle;
            int i;
            try {
                if (!mha.this.d && mha.this.f18214c) {
                    mha.this.f18197a = aMapLocation;
                    if (aMapLocation != null) {
                        errorCode = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            mha.this.f18193a = i.b();
                            mha.this.j(5, null, 0L);
                            z = true;
                        } else {
                            mha.o("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                        }
                        if (z) {
                            mha mhaVar = mha.this;
                            mhaVar.b = 0;
                            mhaVar.j(6, null, 0L);
                            return;
                        }
                        bundle = new Bundle();
                        if (!mha.this.f18210a) {
                            mha.this.C(7);
                            bundle.putLong("interval", 2000L);
                            mha.this.j(8, bundle, 2000L);
                        }
                        mha mhaVar2 = mha.this;
                        i = mhaVar2.b + 1;
                        mhaVar2.b = i;
                        if (i >= 3) {
                            bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, errorCode);
                            mha.this.i(1002, bundle);
                        }
                    }
                    errorCode = 8;
                    z = false;
                    if (z) {
                        mha mhaVar3 = mha.this;
                        mhaVar3.b = 0;
                        mhaVar3.j(6, null, 0L);
                        return;
                    }
                    bundle = new Bundle();
                    if (!mha.this.f18210a) {
                        mha.this.C(7);
                        bundle.putLong("interval", 2000L);
                        mha.this.j(8, bundle, 2000L);
                    }
                    mha mhaVar4 = mha.this;
                    i = mhaVar4.b + 1;
                    mhaVar4.b = i;
                    if (i >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, errorCode);
                        mha.this.i(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        mha.this.E(message.getData());
                        break;
                    case 1:
                        mha.this.L(message.getData());
                        break;
                    case 2:
                        mha.this.R(message.getData());
                        break;
                    case 3:
                        mha.this.O(message.getData());
                        break;
                    case 4:
                        mha.this.T(message.getData());
                        break;
                    case 5:
                        mha.this.Q();
                        break;
                    case 6:
                        mha mhaVar = mha.this;
                        mhaVar.m(mhaVar.f18197a);
                        break;
                    case 7:
                        mha.this.N();
                        break;
                    case 8:
                        mha.this.b0(message.getData());
                        break;
                    case 9:
                        mha.this.k(message.getData());
                        break;
                    case 10:
                        mha.this.J();
                        break;
                    case 11:
                        mha.this.X(message.getData());
                        break;
                    case 12:
                        mha.this.V(message.getData());
                        break;
                    case 13:
                        mha.this.U();
                        break;
                    default:
                        break;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class c extends HandlerThread {
        public c(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public mha(Context context) {
        this.f18195a = null;
        try {
            this.f18195a = context.getApplicationContext();
            a0();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "<init>");
        }
    }

    public static DPoint A(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list == null) {
            return dPoint;
        }
        try {
            double latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
            double longitude = 0.0d;
            for (DPoint dPoint2 : list) {
                latitude += dPoint2.getLatitude();
                longitude += dPoint2.getLongitude();
            }
            return new DPoint(i.b(latitude / ((double) list.size())), i.b(longitude / ((double) list.size())));
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceUtil", "getPolygonCenter");
            return dPoint;
        }
    }

    public static boolean G(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z = false;
        try {
            if (x(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(i.b());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && i.b() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1L);
                    z = true;
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isFenceStatusChanged");
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }

    public static boolean H(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.b.a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x001d A[PHI: r2
      0x001d: PHI (r2v3 int) = (r2v2 int), (r2v4 int) binds: [B:14:0x0015, B:16:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
    public static int M(int i) {
        if (i != 1) {
            int i2 = 7;
            if (i != 7 && i != 4 && i != 5 && i != 16 && i != 17) {
                switch (i) {
                    case 10000:
                        i = 0;
                        break;
                    case 10001:
                    case 10002:
                    case PushConsts.GET_SDKONLINESTATE /* 10007 */:
                    case PushConsts.GET_SDKSERVICEPID /* 10008 */:
                    case 10009:
                    case 10012:
                    case 10013:
                        i = i2;
                        break;
                    case 10003:
                    case 10004:
                    case 10005:
                    case 10006:
                    case 10010:
                    case 10011:
                    case PushConsts.ACTION_NOTIFICATION_ENABLE /* 10014 */:
                    case PushConsts.ACTION_POPUP_SHOW /* 10015 */:
                    case PushConsts.ACTION_POPUP_CLICKED /* 10016 */:
                    case 10017:
                        i = 4;
                        break;
                    default:
                        i2 = 8;
                        switch (i) {
                            case 20000:
                            case 20001:
                            case 20002:
                                i = 1;
                                break;
                            case 20003:
                            default:
                                i = i2;
                                break;
                        }
                        break;
                }
            }
        }
        if (i != 0) {
            o("添加围栏失败", i, "searchErrCode is ".concat(String.valueOf(i)), new String[0]);
        }
        return i;
    }

    public static float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float fMin = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float fA = i.a(dPoint, geoFence.getCenter());
                    if (fA > geoFence.getMinDis2Center() && fA < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (fA > geoFence.getMaxDis2Center()) {
                        fMin = Math.min(fMin, fA - geoFence.getMaxDis2Center());
                    }
                    if (fA < geoFence.getMinDis2Center()) {
                        fMin = Math.min(fMin, geoFence.getMinDis2Center() - fA);
                    }
                }
            }
        }
        return fMin;
    }

    public static float b(DPoint dPoint, List<DPoint> list) {
        float fMin = Float.MAX_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            Iterator<DPoint> it = list.iterator();
            while (it.hasNext()) {
                fMin = Math.min(fMin, i.a(dPoint, it.next()));
            }
        }
        return fMin;
    }

    public static Bundle e(GeoFence geoFence, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i2);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    public static void o(String str, int i, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i)));
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    public static boolean u(int i, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    o("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    return false;
                }
            }
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    public static boolean w(GeoFence geoFence, int i) {
        boolean z = false;
        if ((i & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z = true;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "remindStatus");
                return z;
            }
        }
        if ((i & 2) == 2 && geoFence.getStatus() == 2) {
            z = true;
        }
        return ((i & 4) == 4 && geoFence.getStatus() == 3) ? true : z;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0029 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:3:0x0001, B:6:0x0009, B:8:0x000f, B:10:0x0019, B:18:0x0029, B:19:0x0031, B:21:0x0037, B:24:0x0045), top: B:31:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0037 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:3:0x0001, B:6:0x0009, B:8:0x000f, B:10:0x0019, B:18:0x0029, B:19:0x0031, B:21:0x0037, B:24:0x0045), top: B:31:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0045 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:3:0x0001, B:6:0x0009, B:8:0x000f, B:10:0x0019, B:18:0x0029, B:19:0x0031, B:21:0x0037, B:24:0x0045), top: B:31:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
    public static boolean x(AMapLocation aMapLocation, GeoFence geoFence) {
        Iterator<List<DPoint>> it;
        boolean z = false;
        try {
            if (i.a(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                int type = geoFence.getType();
                if (type == 0) {
                    if (y(aMapLocation, geoFence.getCenter(), geoFence.getRadius())) {
                        return true;
                    }
                } else if (type == 1) {
                    it = geoFence.getPointList().iterator();
                    while (it.hasNext()) {
                        if (H(aMapLocation, it.next())) {
                            z = true;
                        }
                    }
                } else if (type != 2) {
                    if (type == 3) {
                        it = geoFence.getPointList().iterator();
                        while (it.hasNext()) {
                            if (H(aMapLocation, it.next())) {
                                z = true;
                            }
                        }
                    }
                } else if (y(aMapLocation, geoFence.getCenter(), geoFence.getRadius())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isInGeoFence");
        }
        return z;
    }

    public static boolean y(AMapLocation aMapLocation, DPoint dPoint, float f) {
        return i.a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f;
    }

    public static float z(DPoint dPoint, List<DPoint> list) {
        float fMax = Float.MIN_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            Iterator<DPoint> it = list.iterator();
            while (it.hasNext()) {
                fMax = Math.max(fMax, i.a(dPoint, it.next()));
            }
        }
        return fMax;
    }

    public final List<GeoFence> B() {
        try {
            if (this.f18209a == null) {
                this.f18209a = new ArrayList<>();
            }
            return (ArrayList) this.f18209a.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public final void C(int i) {
        try {
            synchronized (this.f18211b) {
                b bVar = this.f18203a;
                if (bVar != null) {
                    bVar.removeMessages(i);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0133: MOVE (r2 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY]), block:B:44:0x0133 */
    public final void D(int i, Bundle bundle) {
        String str;
        int iC;
        int i2;
        String str2;
        int i3;
        String strB;
        int iM;
        String str3 = "errorCode";
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str3 = "errorCode";
                i2 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString("city");
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i4 = bundle.getInt("searchSize", 10);
                float f = bundle.getFloat("aroundRadius", 3000.0f);
                if (u(i, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.f18208a);
                    bundle3.putLong("expiration", -1L);
                    bundle3.putInt("activatesAction", this.f43302a);
                    try {
                        if (i == 1) {
                            i3 = 3;
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            strB = this.f18206a.b(this.f18195a, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i4));
                        } else if (i != 2) {
                            strB = i != 3 ? null : this.f18206a.a(this.f18195a, "http://restsdk.amap.com/v3/config/district?", string2);
                            i3 = 3;
                        } else {
                            double dB = i.b(dPoint.getLatitude());
                            double dB2 = i.b(dPoint.getLongitude());
                            int iIntValue = Float.valueOf(f).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            strB = this.f18206a.c(this.f18195a, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i4), String.valueOf(dB), String.valueOf(dB2), String.valueOf(iIntValue));
                            i3 = 3;
                        }
                        if (strB != null) {
                            int iB = 1 == i ? kra.b(strB, arrayList2, bundle3) : 0;
                            if (2 == i) {
                                iB = kra.e(strB, arrayList2, bundle3);
                            }
                            if (i3 == i) {
                                iB = this.f18202a.f(strB, arrayList2, bundle3);
                            }
                            if (iB != 10000) {
                                iM = M(iB);
                            } else if (arrayList2.isEmpty()) {
                                iM = 16;
                            } else {
                                iC = c(arrayList2);
                                if (iC == 0) {
                                    try {
                                        arrayList.addAll(arrayList2);
                                    } catch (Throwable th) {
                                        th = th;
                                        str = str3;
                                        try {
                                            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                            bundle2.putInt(str, 8);
                                            int i5 = 1000;
                                            return;
                                        } finally {
                                            bundle2.putInt(str, iC);
                                            i(1000, bundle2);
                                        }
                                    }
                                }
                            }
                            iC = iM;
                        } else {
                            iC = 4;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str = str2;
                        iC = 0;
                        com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                        bundle2.putInt(str, 8);
                        int i6 = 1000;
                        return;
                    }
                } else {
                    str3 = "errorCode";
                    iC = 1;
                }
                bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i2 = iC;
            }
            bundle2.putInt(str3, i2);
            i(1000, bundle2);
        } catch (Throwable th3) {
            th = th3;
            str = "errorCode";
        }
    }

    public final void E(Bundle bundle) {
        String string;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int I = 1;
            if (bundle == null || bundle.isEmpty()) {
                string = str;
            } else {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint == null) {
                    str = string;
                    string = str;
                } else if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    o("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                } else {
                    GeoFence geoFenceF = f(bundle, false);
                    I = I(geoFenceF);
                    if (I == 0) {
                        arrayList.add(geoFenceF);
                    }
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("errorCode", I);
            bundle2.putParcelableArrayList("resultList", arrayList);
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
            i(1000, bundle2);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    public final void F(GeoFence geoFence) {
        try {
            synchronized (this.f18207a) {
                if (this.f18195a != null) {
                    if (this.f18194a == null && geoFence.getPendingIntent() == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(e(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    String str = this.f18208a;
                    if (str != null) {
                        intent.setAction(str);
                    }
                    intent.setPackage(j4b.g(this.f18195a));
                    if (geoFence.getPendingIntent() != null) {
                        geoFence.getPendingIntent().send(this.f18195a, 0, intent);
                    } else {
                        this.f18194a.send(this.f18195a, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    public final int I(GeoFence geoFence) {
        try {
            if (this.f18209a == null) {
                this.f18209a = new ArrayList<>();
            }
            if (this.f18209a.contains(geoFence)) {
                return 17;
            }
            this.f18209a.add(geoFence);
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFence2List");
            o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    public final void J() {
        try {
            if (!this.f18212b) {
                return;
            }
            ArrayList<GeoFence> arrayList = this.f18209a;
            if (arrayList != null) {
                arrayList.clear();
                this.f18209a = null;
            }
            if (this.f18214c) {
                return;
            }
            e0();
            AMapLocationClient aMapLocationClient = this.f18198a;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.f18198a.onDestroy();
            }
            this.f18198a = null;
            c cVar = this.f18204a;
            if (cVar != null) {
                cVar.quitSafely();
            }
            this.f18204a = null;
            this.f18206a = null;
            synchronized (this.f18207a) {
                PendingIntent pendingIntent = this.f18194a;
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                this.f18194a = null;
            }
            d0();
            g gVar = this.f18201a;
            if (gVar != null) {
                gVar.b(this.f18195a);
            }
        } catch (Throwable unused) {
        }
        this.f18210a = false;
        this.f18212b = false;
    }

    public final void K(int i) {
        try {
            if (this.f18195a != null) {
                synchronized (this.f18207a) {
                    if (this.f18194a == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(e(null, null, null, 4, i));
                    this.f18194a.send(this.f18195a, 0, intent);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    public final void L(Bundle bundle) {
        GeoFence geoFenceF;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int I = 1;
            if (bundle != null && !bundle.isEmpty()) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (I = I((geoFenceF = f(bundle, true)))) == 0) {
                    arrayList.add(geoFenceF);
                }
                str = string;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", I);
            bundle2.putParcelableArrayList("resultList", arrayList);
            i(1000, bundle2);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    public final void N() {
        try {
            if (this.f18198a != null) {
                g0();
                this.f18199a.setOnceLocation(true);
                this.f18198a.setLocationOption(this.f18199a);
                this.f18198a.startLocation();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    public final void O(Bundle bundle) {
        D(2, bundle);
    }

    public final void P(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        i(1001, bundle);
    }

    public final void Q() {
        try {
            if (!this.d && i.a(this.f18197a)) {
                float fA = a(this.f18197a, this.f18209a);
                if (fA == Float.MAX_VALUE) {
                    return;
                }
                if (fA < 1000.0f) {
                    C(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong("interval", 2000L);
                    j(8, bundle, 500L);
                    return;
                }
                if (fA < 5000.0f) {
                    g0();
                    C(7);
                    j(7, null, 10000L);
                } else {
                    g0();
                    C(7);
                    j(7, null, (long) (((fA - 4000.0f) / 100.0f) * 1000.0f));
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    public final void R(Bundle bundle) {
        D(1, bundle);
    }

    public final void S() {
        try {
            a0();
            this.d = true;
            j(13, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public final void T(Bundle bundle) {
        D(3, bundle);
    }

    public final void U() {
        try {
            C(7);
            C(8);
            AMapLocationClient aMapLocationClient = this.f18198a;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f18210a = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    public final void V(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z = bundle.getBoolean("ab", true);
                ArrayList<GeoFence> arrayList = this.f18209a;
                if (arrayList != null && !arrayList.isEmpty()) {
                    for (GeoFence geoFence : this.f18209a) {
                        if (geoFence.getFenceId().equals(string)) {
                            geoFence.setAble(z);
                            break;
                        }
                    }
                }
                if (z) {
                    f0();
                } else if (c0()) {
                    U();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public final void W() {
        try {
            a0();
            if (this.d) {
                this.d = false;
                f0();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public final void X(Bundle bundle) {
        try {
            if (this.f18209a != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable(AliyunLogKey.KEY_FILL_COLOR);
                if (this.f18209a.contains(geoFence)) {
                    this.f18209a.remove(geoFence);
                }
                if (this.f18209a.size() <= 0) {
                    J();
                } else {
                    f0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void Y(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i = bundle.getInt("errorCode");
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new ArrayList();
                }
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (string == null) {
                    string = "";
                }
                GeoFenceListener geoFenceListener = this.f18196a;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i, string);
                }
                if (i == 0) {
                    f0();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public final boolean Z() {
        return this.d;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:38:0x0030). Please report as a decompilation issue!!! */
    public final void a0() {
        if (!this.f18214c) {
            this.f18214c = true;
        }
        if (this.f18212b) {
            return;
        }
        try {
            if (Looper.myLooper() == null) {
                this.f18205a = new d(this.f18195a.getMainLooper());
            } else {
                this.f18205a = new d();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "init 1");
        }
        try {
            c cVar = new c("fenceActionThread");
            this.f18204a = cVar;
            cVar.setPriority(5);
            this.f18204a.start();
            this.f18203a = new b(this.f18204a.getLooper());
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.f18206a = new zma(this.f18195a);
            this.f18202a = new kra();
            this.f18199a = new AMapLocationClientOption();
            this.f18198a = new AMapLocationClient(this.f18195a);
            this.f18199a.setLocationCacheEnable(true);
            this.f18199a.setNeedAddress(false);
            this.f18198a.setLocationListener(this.f18200a);
            if (this.f18201a == null) {
                this.f18201a = new g();
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "GeoFenceManger", "initBase");
        }
        this.f18212b = true;
        try {
            String str = this.f18208a;
            if (str != null && this.f18194a == null) {
                d(str);
            }
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "GeoFenceManger", "init 4");
        }
        if (e) {
            return;
        }
        e = true;
        g.a(this.f18195a, "O020", (JSONObject) null);
    }

    public final void b0(Bundle bundle) {
        try {
            if (this.f18198a != null) {
                long j = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j = bundle.getLong("interval", 2000L);
                }
                this.f18199a.setOnceLocation(false);
                this.f18199a.setInterval(j);
                this.f18198a.setLocationOption(this.f18199a);
                if (this.f18210a) {
                    return;
                }
                this.f18198a.stopLocation();
                this.f18198a.startLocation();
                this.f18210a = true;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public final int c(List<GeoFence> list) {
        try {
            if (this.f18209a == null) {
                this.f18209a = new ArrayList<>();
            }
            Iterator<GeoFence> it = list.iterator();
            while (it.hasNext()) {
                I(it.next());
            }
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFenceList");
            o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    public final boolean c0() {
        ArrayList<GeoFence> arrayList = this.f18209a;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        Iterator<GeoFence> it = this.f18209a.iterator();
        while (it.hasNext()) {
            if (it.next().isAble()) {
                return false;
            }
        }
        return true;
    }

    public final PendingIntent d(String str) {
        synchronized (this.f18207a) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(j4b.g(this.f18195a));
                if (Build.VERSION.SDK_INT < 31 || this.f18195a.getApplicationInfo().targetSdkVersion < 31) {
                    this.f18194a = PendingIntent.getBroadcast(this.f18195a, 0, intent, 0);
                } else {
                    this.f18194a = PendingIntent.getBroadcast(this.f18195a, 0, intent, 33554432);
                }
                this.f18208a = str;
                ArrayList<GeoFence> arrayList = this.f18209a;
                if (arrayList != null && !arrayList.isEmpty()) {
                    for (GeoFence geoFence : this.f18209a) {
                        geoFence.setPendingIntent(this.f18194a);
                        geoFence.setPendingIntentAction(this.f18208a);
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "createPendingIntent");
            }
        }
        return this.f18194a;
    }

    public final void d0() {
        try {
            synchronized (this.f18213c) {
                d dVar = this.f18205a;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.f18205a = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    public final void e0() {
        try {
            synchronized (this.f18211b) {
                b bVar = this.f18203a;
                if (bVar != null) {
                    bVar.removeCallbacksAndMessages(null);
                }
                this.f18203a = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    public final GeoFence f(Bundle bundle, boolean z) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = A(arrayList);
            }
            geoFence.setMaxDis2Center(z(dPoint, arrayList));
            geoFence.setMinDis2Center(b(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f = bundle.getFloat("fenceRadius", 1000.0f);
            float f2 = f > 0.0f ? f : 1000.0f;
            geoFence.setRadius(f2);
            geoFence.setMinDis2Center(f2);
            geoFence.setMaxDis2Center(f2);
        }
        geoFence.setActivatesAction(this.f43302a);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.f18208a);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.f18194a);
        StringBuilder sb = new StringBuilder();
        sb.append(kra.c());
        geoFence.setFenceId(sb.toString());
        g gVar = this.f18201a;
        if (gVar != null) {
            gVar.a(this.f18195a, 2);
        }
        return geoFence;
    }

    public final void f0() {
        if (this.d || this.f18203a == null) {
            return;
        }
        if (h0()) {
            j(6, null, 0L);
            j(5, null, 0L);
        } else {
            C(7);
            j(7, null, 0L);
        }
    }

    public final void g() {
        try {
            this.f18214c = false;
            j(10, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public final void g0() {
        try {
            if (this.f18210a) {
                C(8);
            }
            AMapLocationClient aMapLocationClient = this.f18198a;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f18210a = false;
        } catch (Throwable unused) {
        }
    }

    public final void h(int i) {
        try {
            a0();
            if (i > 7 || i <= 0) {
                i = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i);
            j(9, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    public final boolean h0() {
        return this.f18197a != null && i.a(this.f18197a) && i.b() - this.f18193a < 10000;
    }

    public final void i(int i, Bundle bundle) {
        try {
            synchronized (this.f18213c) {
                d dVar = this.f18205a;
                if (dVar != null) {
                    Message messageObtainMessage = dVar.obtainMessage();
                    messageObtainMessage.what = i;
                    messageObtainMessage.setData(bundle);
                    this.f18205a.sendMessage(messageObtainMessage);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    public final void j(int i, Bundle bundle, long j) {
        try {
            synchronized (this.f18211b) {
                b bVar = this.f18203a;
                if (bVar != null) {
                    Message messageObtainMessage = bVar.obtainMessage();
                    messageObtainMessage.what = i;
                    messageObtainMessage.setData(bundle);
                    this.f18203a.sendMessageDelayed(messageObtainMessage, j);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    public final void k(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            try {
                i = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f43302a != i) {
            ArrayList<GeoFence> arrayList = this.f18209a;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (GeoFence geoFence : this.f18209a) {
                    geoFence.setStatus(0);
                    geoFence.setEnterTime(-1L);
                }
            }
            f0();
        }
        this.f43302a = i;
    }

    public final void l(GeoFenceListener geoFenceListener) {
        try {
            this.f18196a = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    public final void m(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.d || (arrayList = this.f18209a) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            for (GeoFence geoFence : this.f18209a) {
                if (geoFence.isAble() && G(aMapLocation, geoFence) && w(geoFence, this.f43302a)) {
                    geoFence.setCurrentLocation(aMapLocation);
                    P(geoFence);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public final void n(DPoint dPoint, float f, String str) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(0, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void p(String str, String str2) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            j(4, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void q(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            a0();
            if (f <= 0.0f || f > 50000.0f) {
                f = 3000.0f;
            }
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            j(3, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void r(String str, String str2, String str3, int i, String str4) {
        try {
            a0();
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            j(2, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void s(String str, boolean z) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z);
            j(12, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void t(List<DPoint> list, String str) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(1, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final boolean v(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.f18209a;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.f18209a.contains(geoFence)) {
                    return false;
                }
                if (this.f18209a.size() == 1) {
                    this.f18214c = false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(AliyunLogKey.KEY_FILL_COLOR, geoFence);
                j(11, bundle, 0L);
                return true;
            }
            this.f18214c = false;
            j(10, null, 0L);
            return true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        mha.this.Y(data);
                        return;
                    case 1001:
                        try {
                            mha.this.F((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            mha.this.K(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }

        public d() {
        }
    }
}
