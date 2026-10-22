package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.triver.appinfo.core.AppInfoCenterInternal;
import com.amap.api.col.p0003l.ff;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.common.constants.ErrorCode;
import com.zj.adlib.a7b;
import com.zj.adlib.c25;
import com.zj.adlib.lbb;
import com.zj.adlib.mbb;
import com.zj.adlib.n9b;
import com.zj.adlib.o9b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray<Long> f26205a = new SparseArray<>();
    public int b = -1;
    public long c = 0;
    String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;
    private static List<lbb> i = new ArrayList();
    private static JSONArray j = null;
    static AMapLocation g = null;
    static boolean h = false;

    /* JADX INFO: renamed from: com.autonavi.aps.amapapi.utils.g$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26206a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f26206a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26206a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26206a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String a(int i2) {
        if (i2 == 2011) {
            return "ContextIsNull";
        }
        if (i2 == 2031) {
            return "CreateApsReqException";
        }
        if (i2 == 2041) {
            return "ResponseResultIsNull";
        }
        if (i2 == 2081) {
            return "LocalLocException";
        }
        if (i2 == 2091) {
            return "InitException";
        }
        if (i2 == 2111) {
            return "ErrorCgiInfo";
        }
        if (i2 == 2121) {
            return "NotLocPermission";
        }
        if (i2 == 2141) {
            return "NoEnoughStatellites";
        }
        if (i2 == 2021) {
            return "OnlyMainWifi";
        }
        if (i2 == 2022) {
            return "OnlyOneWifiButNotMain";
        }
        if (i2 == 2061) {
            return "ServerRetypeError";
        }
        if (i2 == 2062) {
            return "ServerLocFail";
        }
        switch (i2) {
            case 2051:
                return "NeedLoginNetWork\t";
            case 2052:
                return "MaybeIntercepted";
            case 2053:
                return "DecryptResponseException";
            case 2054:
                return "ParserDataException";
            default:
                switch (i2) {
                    case 2101:
                        return "BindAPSServiceException";
                    case ErrorCode.FENCE_ERROR.f33661a /* 2102 */:
                        return "AuthClientScodeFail";
                    case 2103:
                        return "NotConfigAPSService";
                    default:
                        switch (i2) {
                            case 2131:
                                return "NoCgiOAndWifiInfo";
                            case 2132:
                                return "AirPlaneModeAndWifiOff";
                            case 2133:
                                return "NoCgiAndWifiOff";
                            default:
                                switch (i2) {
                                    case 2151:
                                        return "MaybeMockNetLoc";
                                    case 2152:
                                        return "MaybeMockGPSLoc";
                                    case 2153:
                                        return "UNSUPPORT_COARSE_LBSLOC";
                                    case 2154:
                                        return "UNSUPPORT_CONTINUE_LOC";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    private static boolean a(AMapLocation aMapLocation) {
        if (i.a(aMapLocation)) {
            return !b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude());
        }
        return "http://abroad.apilocate.amap.com/mobile/binary".equals(b.c);
    }

    public static void b(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j2, z, "O024");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void f(Context context) {
        try {
            JSONArray jSONArray = j;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            o9b.e(new n9b(context, b.c(), j.toString()), context);
            j = null;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final int c(Context context) {
        try {
            long jA = h.a(context, "pref1", this.d[2], 0L);
            long jA2 = h.a(context, "pref1", this.d[0], 0L);
            long jA3 = h.a(context, "pref1", this.d[1], 0L);
            if (jA == 0 && jA2 == 0 && jA3 == 0) {
                return -1;
            }
            long j2 = jA2 - jA;
            long j3 = jA3 - jA;
            if (jA > j2) {
                return jA > j3 ? 2 : 1;
            }
            return j2 > j3 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long jA = h.a(context, "pref1", this.d[3], 0L);
            long jA2 = h.a(context, "pref1", this.d[4], 0L);
            long jA3 = h.a(context, "pref1", this.d[5], 0L);
            if (jA == 0 && jA2 == 0 && jA3 == 0) {
                return -1;
            }
            if (jA > jA2) {
                return jA > jA3 ? 3 : 5;
            }
            return jA2 > jA3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void e(Context context) {
        try {
            SharedPreferences.Editor editorA = h.a(context, "pref1");
            int i2 = 0;
            while (true) {
                String[] strArr = this.d;
                if (i2 >= strArr.length) {
                    h.a(editorA);
                    return;
                } else {
                    h.a(editorA, strArr[i2], 0L);
                    i2++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        int i2;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!"gps".equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                String str = a(aMapLocation) ? "abroad" : "domestic";
                String str2 = "cache";
                if (aMapLocation.getErrorCode() != 0) {
                    int errorCode = aMapLocation.getErrorCode();
                    if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                        str2 = "net";
                    }
                    i2 = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType == 5 || locationType == 6) {
                        str2 = "net";
                    }
                    i2 = 1;
                }
                a(context, "O016", str2, str, i2, aMapLocation.getErrorCode(), aVar);
            }
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportBatting");
        }
    }

    public final void b(Context context) {
        try {
            long jB = i.b() - this.c;
            int i2 = this.b;
            if (i2 != -1) {
                this.f26205a.append(this.b, Long.valueOf(jB + this.f26205a.get(i2, 0L).longValue()));
            }
            long jB2 = i.b() - this.f;
            int i3 = this.e;
            if (i3 != -1) {
                this.f26205a.append(this.e, Long.valueOf(jB2 + this.f26205a.get(i3, 0L).longValue()));
            }
            SharedPreferences.Editor editorA = h.a(context, "pref1");
            for (int i4 = 0; i4 < this.d.length; i4++) {
                long jLongValue = this.f26205a.get(i4, 0L).longValue();
                if (jLongValue > 0 && jLongValue > h.a(context, "pref1", this.d[i4], 0L)) {
                    h.a(editorA, this.d[i4], jLongValue);
                }
            }
            h.a(editorA);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public static void a(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j2, z, "O015");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(Context context, long j2, boolean z, String str) {
        a(context, str, !z ? "abroad" : "domestic", Long.valueOf(j2).intValue());
    }

    private static void a(Context context, String str, String str2, String str3, int i2, int i3, com.autonavi.aps.amapapi.a aVar) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    if (aVar != null) {
                        if (!TextUtils.isEmpty(aVar.d())) {
                            jSONObject.put("dns", aVar.d());
                        }
                        if (!TextUtils.isEmpty(aVar.e())) {
                            jSONObject.put("domain", aVar.e());
                        }
                        if (!TextUtils.isEmpty(aVar.f())) {
                            jSONObject.put("type", aVar.f());
                        }
                        if (!TextUtils.isEmpty(aVar.g())) {
                            jSONObject.put(MediationConstant.KEY_REASON, aVar.g());
                        }
                        if (!TextUtils.isEmpty(aVar.c())) {
                            jSONObject.put(LoginConstants.IP, aVar.c());
                        }
                        if (!TextUtils.isEmpty(aVar.b())) {
                            jSONObject.put("stack", aVar.b());
                        }
                        if (aVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(aVar.h()));
                        }
                        if (aVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(aVar.a()));
                        }
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, int i2) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void a(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
                if (a.a()) {
                    lbb lbbVar = new lbb(context, "loc", "6.1.0", str);
                    if (jSONObject != null) {
                        lbbVar.a(jSONObject.toString());
                    }
                    i.add(lbbVar);
                    if (i.size() >= 30) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(i);
                        mbb.h(arrayList, context);
                        i.clear();
                    }
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatistics");
            }
        }
    }

    public static synchronized void a(Context context) {
        if (context != null) {
            try {
                if (a.a()) {
                    List<lbb> list = i;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(i);
                        mbb.h(arrayList, context);
                        i.clear();
                    }
                    f(context);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "destroy");
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            a7b.l(b.c(), str2, str);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportLog");
        }
    }

    public final void a(Context context, int i2) {
        try {
            int i3 = this.b;
            if (i3 == i2) {
                return;
            }
            if (i3 != -1 && i3 != i2) {
                this.f26205a.append(this.b, Long.valueOf((i.b() - this.c) + this.f26205a.get(this.b, 0L).longValue()));
            }
            this.c = i.b() - h.a(context, "pref1", this.d[i2], 0L);
            this.b = i2;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        int i2;
        try {
            int i3 = AnonymousClass1.f26206a[aMapLocationClientOption.getLocationMode().ordinal()];
            if (i3 == 1) {
                i2 = 4;
            } else if (i3 != 2) {
                i2 = 3;
                if (i3 != 3) {
                    i2 = -1;
                }
            } else {
                i2 = 5;
            }
            int i4 = this.e;
            if (i4 == i2) {
                return;
            }
            if (i4 != -1 && i4 != i2) {
                this.f26205a.append(this.e, Long.valueOf((i.b() - this.f) + this.f26205a.get(this.e, 0L).longValue()));
            }
            this.f = i.b() - h.a(context, "pref1", this.d[i2], 0L);
            this.e = i2;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public static void a(Context context, int i2, int i3, long j2, long j3) {
        if (i2 == -1 || i3 == -1) {
            return;
        }
        try {
            a(context, "O012", i2, i3, j2, j3);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    private static void a(Context context, String str, int i2, int i3, long j2, long j3) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j2);
                    jSONObject.put("param_long_second", j3);
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void a(Context context, AMapLocation aMapLocation) {
        int i2;
        try {
            if (i.a(aMapLocation)) {
                int locationType = aMapLocation.getLocationType();
                int i3 = 0;
                if (locationType == 1) {
                    i2 = i3;
                    i3 = 1;
                } else if (locationType == 2 || locationType == 4) {
                    i2 = 1;
                    i3 = 1;
                } else {
                    if (locationType == 11) {
                        i2 = 4;
                    } else if (locationType == 8) {
                        i3 = 3;
                        i2 = i3;
                    } else if (locationType != 9) {
                        i2 = 0;
                    } else {
                        i2 = 2;
                    }
                    i3 = 1;
                }
                if (i3 != 0) {
                    int iC = a.c();
                    if (iC != 0) {
                        if (i2 == 0 || i2 == 4) {
                            if (iC == 2) {
                                return;
                            }
                        } else if (iC == 1) {
                            return;
                        }
                    }
                    if (j == null) {
                        j = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lon", i.b(aMapLocation.getLongitude()));
                    jSONObject.put("lat", i.b(aMapLocation.getLatitude()));
                    jSONObject.put("type", i2);
                    jSONObject.put("timestamp", i.a());
                    if (aMapLocation.getCoordType().equalsIgnoreCase(AMapLocation.COORD_TYPE_WGS84)) {
                        jSONObject.put("coordType", 1);
                    } else {
                        jSONObject.put("coordType", 2);
                    }
                    if (i2 == 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("accuracy", i.c(aMapLocation.getAccuracy()));
                        jSONObject2.put("altitude", i.c(aMapLocation.getAltitude()));
                        jSONObject2.put("bearing", i.c(aMapLocation.getBearing()));
                        jSONObject2.put("speed", i.c(aMapLocation.getSpeed()));
                        jSONObject.put("extension", jSONObject2);
                    }
                    JSONArray jSONArrayPut = j.put(jSONObject);
                    j = jSONArrayPut;
                    if (jSONArrayPut.length() >= a.b()) {
                        f(context);
                    }
                }
            }
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "recordOfflineLocLog");
        }
    }

    public static void a(String str, int i2) {
        a(str, String.valueOf(i2), a(i2));
    }

    public static void a(String str, String str2, String str3) {
        try {
            a7b.h(b.c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof ff) {
                a7b.g(b.c(), str, (ff) th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (g == null) {
                if (!i.a(aMapLocation)) {
                    g = aMapLocation2;
                    return;
                }
                g = aMapLocation.m149clone();
            }
            if (i.a(g) && i.a(aMapLocation2)) {
                AMapLocation aMapLocationM149clone = aMapLocation2.m149clone();
                if (g.getLocationType() != 1 && g.getLocationType() != 9 && !"gps".equalsIgnoreCase(g.getProvider()) && g.getLocationType() != 7 && aMapLocationM149clone.getLocationType() != 1 && aMapLocationM149clone.getLocationType() != 9 && !"gps".equalsIgnoreCase(aMapLocationM149clone.getProvider()) && aMapLocationM149clone.getLocationType() != 7) {
                    long jAbs = Math.abs(aMapLocationM149clone.getTime() - g.getTime()) / 1000;
                    if (jAbs <= 0) {
                        jAbs = 1;
                    }
                    if (jAbs <= AppInfoCenterInternal.c) {
                        float fA = i.a(g, aMapLocationM149clone);
                        float f = fA / jAbs;
                        if (fA > 30000.0f && f > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(g.getLatitude());
                            sb.append(",");
                            sb.append(g.getLongitude());
                            sb.append(",");
                            sb.append(g.getAccuracy());
                            sb.append(",");
                            sb.append(g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(i.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(g.getTime());
                            }
                            sb.append("#");
                            sb.append(aMapLocationM149clone.getLatitude());
                            sb.append(",");
                            sb.append(aMapLocationM149clone.getLongitude());
                            sb.append(",");
                            sb.append(aMapLocationM149clone.getAccuracy());
                            sb.append(",");
                            sb.append(aMapLocationM149clone.getLocationType());
                            sb.append(",");
                            if (aMapLocationM149clone.getTime() != 0) {
                                sb.append(i.a(aMapLocationM149clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(aMapLocationM149clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                g = aMapLocationM149clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j2, long j3) {
        try {
            if (h) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(i.a(j2, c25.o));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(i.a(j3, c25.o));
            stringBuffer.append(",");
            long jT = a.t();
            String strA = 0 != jT ? i.a(jT, c25.o) : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(strA);
            a("checkgpstime", stringBuffer.toString());
            if (0 != jT && Math.abs(j2 - jT) < 31536000000L) {
                stringBuffer.append(", correctError");
                a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            h = true;
        } catch (Throwable unused) {
        }
    }
}
