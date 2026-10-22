package com.getui.gtc.dim.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dim.AllowSysCall;
import com.getui.gtc.dim.AppDataProvider;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimCallback;
import com.getui.gtc.dim.DimRequest;
import com.getui.gtc.dim.DimSource;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g extends f {
    private static final long i = SystemClock.elapsedRealtime();
    private static final Map<String, String> j = new HashMap<String, String>() { // from class: com.getui.gtc.dim.b.g.1
        {
            put("dim-2-1-1-1", "XhNWH0ANTAVL");
            put("dim-2-1-1-3", "XhNWHy4=");
            put("dim-2-1-1-4", "XhNWHy0=");
            put("dim-2-1-2-1", "XhNACVYbWhNd");
            put("dim-2-1-2-3", "XhNACTg=");
            put("dim-2-1-2-4", "XhNACTs=");
            put("dim-2-1-3-1", "WhtY");
            put("dim-2-1-3-2", "WhtYB0YKRg==");
            put("dim-2-1-4-1", "RAFTGlsXSAZTHlwZSw==");
            put("dim-2-1-5-1", "WBlQFA==");
            put("dim-2-1-6-1", "Xh1eF1MMQQBJBw==");
            put("dim-2-1-6-3", "Xh1eF1Ni");
            put("dim-2-1-6-4", "Xh1eF1Nh");
            put("dim-2-1-7-1", "VhhcDkEITBNaHg==");
            put("dim-2-1-8-1", "VhJEAVMHTh1UGl0CSw8=");
            put("dim-2-1-9-1", "VQdGCEw=");
            put("dim-2-1-10-1", "WhVRFFg=");
            put("dim-2-1-11-1", "RQpH");
            put("dim-2-1-12-1", "WhtVAEYHRBBFF1IA");
            put("dim-2-1-13-1", "RB1OEUcCUANKBUs=");
            put("dim-2-1-14-1", "VBVHFVwZSw==");
            put("dim-2-1-15-1", "WRxIH1ACSRZCG0sO");
            put("dim-2-1-16-1", "Xg4=");
            put("dim-2-1-16-2", "Xg5Ybg==");
            put("dim-2-1-17-1", "WxRXFkILRApVEkIR");
            put("dim-2-1-17-2", "WxRXFkILRApVG14KXRJACw==");
            put("dim-2-1-18-1", "QAlPBlkQXhhX");
            put("dim-2-1-18-2", "QAlPBlkKSQhGGVUcTxs=");
            put("dim-2-1-18-3", "QAlPBlkUVRY=");
            put("dim-2-1-19-1", "VBFdEU4HSQ9A");
            put("dim-2-1-19-2", "VBFdEU4HSQ9AH1EUQw==");
            put("dim-2-1-21-1", "VgZWCUUMXws=");
            put("dim-2-1-21-2", "VgZWCUUMXws=");
            put("dim-2-1-21-3", "VgZWCUUMXws=");
            put("dim-2-1-21-5", "VgZWCUUMXws=");
            put("dim-2-1-22-1", "UBVBFF0CRgNVHF8aRQxI");
        }
    };
    public Method g;
    public Method h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f30313a = new g(0);
    }

    private g() {
    }

    public /* synthetic */ g(byte b) {
        this();
    }

    private e a(DimRequest dimRequest, boolean z, boolean z2, boolean z3) {
        Object objB;
        Object objI;
        Object objB2;
        e eVar = new e("none");
        String key = dimRequest.getKey();
        if ((this.c & 2) != 0) {
            com.getui.gtc.dim.e.b.a(new Throwable("dim get sys trace, key: " + key + ", caller: " + dimRequest.getCaller()));
        }
        AppDataProvider appDataProvider = this.e;
        boolean z4 = appDataProvider != null && a(key);
        com.getui.gtc.dim.e.b.b("dim can call sys for " + key + ", caller: " + dimRequest.getCaller() + ", allowProvider: " + z4 + ", provider: " + appDataProvider + ", gdi:" + z + ", dim:" + z2 + ", hc:" + z3);
        if (z4) {
            if (!z3 && ((z || z2) && (objB2 = b(key, appDataProvider)) != Void.TYPE)) {
                eVar.f30308a = "app_provider";
                eVar.b = objB2;
            }
            return eVar;
        }
        if (z && (objI = i(key)) != Void.TYPE) {
            eVar.f30308a = "gdi";
            eVar.b = objI;
        }
        if (z2 && !com.getui.gtc.dim.e.c.a(eVar.b) && (objB = b(dimRequest)) != Void.TYPE) {
            eVar.f30308a = NotificationCompat.CATEGORY_SYSTEM;
            eVar.b = objB;
        }
        return eVar;
    }

    public static /* synthetic */ e a(g gVar, DimRequest dimRequest, boolean z, boolean z2) {
        return gVar.a(dimRequest, z, z2, false);
    }

    private static Object a(String str, AppDataProvider appDataProvider) {
        return a(str, appDataProvider, String.class, false, "");
    }

    private static Object a(String str, AppDataProvider appDataProvider, Class<?> cls, boolean z, Object obj) {
        try {
            String str2 = j.get(str);
            String str3 = str2 == null ? null : new String(com.getui.gtc.dim.e.a.a(Base64.decode(str2.getBytes(), 2)));
            if (str3 == null) {
                throw new IllegalStateException("decryptName==null");
            }
            try {
                Object appData = appDataProvider.getAppData(str3);
                if (!z) {
                    return cls.cast(appData);
                }
                List list = (List) appData;
                if (list != null && !list.isEmpty()) {
                    cls.cast(list.get(0));
                    if (list.size() > 1) {
                        cls.cast(list.get(list.size() - 1));
                    }
                }
                return appData;
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.b("dim call sys getProviderData failed for " + str + ",because " + th.getMessage());
                appDataProvider.onDataFailed(str3, th);
                return obj;
            }
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.b("dim call sys getProviderData failed for " + str + ",because " + th2.getMessage());
            return obj;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private Object b(DimRequest dimRequest) {
        Context context = GtcProvider.context();
        String key = dimRequest.getKey();
        key.hashCode();
        byte b = -1;
        switch (key.hashCode()) {
            case 320888255:
                if (key.equals("dim-2-1-10-1")) {
                    b = 0;
                }
                break;
            case 320889216:
                if (key.equals("dim-2-1-11-1")) {
                    b = 1;
                }
                break;
            case 320890177:
                if (key.equals("dim-2-1-12-1")) {
                    b = 2;
                }
                break;
            case 320891138:
                if (key.equals("dim-2-1-13-1")) {
                    b = 3;
                }
                break;
            case 320892099:
                if (key.equals("dim-2-1-14-1")) {
                    b = 4;
                }
                break;
            case 320893060:
                if (key.equals("dim-2-1-15-1")) {
                    b = 5;
                }
                break;
            case 320894021:
                if (key.equals("dim-2-1-16-1")) {
                    b = 6;
                }
                break;
            case 320894022:
                if (key.equals("dim-2-1-16-2")) {
                    b = 7;
                }
                break;
            case 320894982:
                if (key.equals("dim-2-1-17-1")) {
                    b = 8;
                }
                break;
            case 320894983:
                if (key.equals("dim-2-1-17-2")) {
                    b = 9;
                }
                break;
            case 320894984:
                if (key.equals("dim-2-1-17-3")) {
                    b = 10;
                }
                break;
            case 320894985:
                if (key.equals("dim-2-1-17-4")) {
                    b = 11;
                }
                break;
            case 320895943:
                if (key.equals("dim-2-1-18-1")) {
                    b = 12;
                }
                break;
            case 320895944:
                if (key.equals("dim-2-1-18-2")) {
                    b = 13;
                }
                break;
            case 320895945:
                if (key.equals("dim-2-1-18-3")) {
                    b = com.google.common.base.a.p;
                }
                break;
            case 320895946:
                if (key.equals("dim-2-1-18-4")) {
                    b = com.google.common.base.a.q;
                }
                break;
            case 320896904:
                if (key.equals("dim-2-1-19-1")) {
                    b = com.google.common.base.a.r;
                }
                break;
            case 320896905:
                if (key.equals("dim-2-1-19-2")) {
                    b = 17;
                }
                break;
            case 320919007:
                if (key.equals("dim-2-1-21-1")) {
                    b = com.google.common.base.a.u;
                }
                break;
            case 320919008:
                if (key.equals("dim-2-1-21-2")) {
                    b = 19;
                }
                break;
            case 320919009:
                if (key.equals("dim-2-1-21-3")) {
                    b = com.google.common.base.a.x;
                }
                break;
            case 320919011:
                if (key.equals("dim-2-1-21-5")) {
                    b = com.google.common.base.a.y;
                }
                break;
            case 320919968:
                if (key.equals("dim-2-1-22-1")) {
                    b = com.google.common.base.a.z;
                }
                break;
            case 1672919129:
                if (key.equals("dim-2-1-1-1")) {
                    b = com.google.common.base.a.A;
                }
                break;
            case 1672919131:
                if (key.equals("dim-2-1-1-3")) {
                    b = com.google.common.base.a.B;
                }
                break;
            case 1672919132:
                if (key.equals("dim-2-1-1-4")) {
                    b = com.google.common.base.a.C;
                }
                break;
            case 1672920090:
                if (key.equals("dim-2-1-2-1")) {
                    b = com.google.common.base.a.D;
                }
                break;
            case 1672920092:
                if (key.equals("dim-2-1-2-3")) {
                    b = com.google.common.base.a.E;
                }
                break;
            case 1672920093:
                if (key.equals("dim-2-1-2-4")) {
                    b = com.google.common.base.a.F;
                }
                break;
            case 1672921051:
                if (key.equals("dim-2-1-3-1")) {
                    b = com.google.common.base.a.G;
                }
                break;
            case 1672921052:
                if (key.equals("dim-2-1-3-2")) {
                    b = com.google.common.base.a.H;
                }
                break;
            case 1672922012:
                if (key.equals("dim-2-1-4-1")) {
                    b = 31;
                }
                break;
            case 1672922973:
                if (key.equals("dim-2-1-5-1")) {
                    b = 32;
                }
                break;
            case 1672922974:
                if (key.equals("dim-2-1-5-2")) {
                    b = com.google.android.exoplayer2.text.cea.a.e;
                }
                break;
            case 1672923934:
                if (key.equals("dim-2-1-6-1")) {
                    b = 34;
                }
                break;
            case 1672923936:
                if (key.equals("dim-2-1-6-3")) {
                    b = 35;
                }
                break;
            case 1672923937:
                if (key.equals("dim-2-1-6-4")) {
                    b = 36;
                }
                break;
            case 1672924895:
                if (key.equals("dim-2-1-7-1")) {
                    b = com.google.android.exoplayer2.text.cea.a.g;
                }
                break;
            case 1672925856:
                if (key.equals("dim-2-1-8-1")) {
                    b = com.google.android.exoplayer2.text.cea.a.h;
                }
                break;
            case 1672926817:
                if (key.equals("dim-2-1-9-1")) {
                    b = com.google.android.exoplayer2.text.cea.a.i;
                }
                break;
        }
        switch (b) {
            case 0:
                return com.getui.gtc.dim.c.a.c();
            case 1:
                return com.getui.gtc.dim.c.a.d();
            case 2:
                return com.getui.gtc.dim.c.a.e();
            case 3:
                return com.getui.gtc.dim.c.a.f();
            case 4:
                return com.getui.gtc.dim.c.a.h(context);
            case 5:
                return com.getui.gtc.dim.c.a.i(context);
            case 6:
                return com.getui.gtc.dim.c.a.j(context);
            case 7:
                return com.getui.gtc.dim.c.a.k(context);
            case 8:
                return com.getui.gtc.dim.c.a.a(context, "gps");
            case 9:
                return com.getui.gtc.dim.c.a.a(context, "network");
            case 10:
            case 11:
                return com.getui.gtc.dim.c.b.b(dimRequest, b(key));
            case 12:
                return com.getui.gtc.dim.c.a.l(context);
            case 13:
                return com.getui.gtc.dim.c.a.m(context);
            case 14:
                return com.getui.gtc.dim.c.b.a(context, dimRequest);
            case 15:
                return com.getui.gtc.dim.c.b.a(dimRequest, b(key));
            case 16:
                return com.getui.gtc.dim.c.a.n(context);
            case 17:
                return com.getui.gtc.dim.c.a.o(context);
            case 18:
                return com.getui.gtc.dim.c.a.p(context);
            case 19:
                return com.getui.gtc.dim.c.a.q(context);
            case 20:
                return com.getui.gtc.dim.c.a.r(context);
            case 21:
                if (b()) {
                    com.getui.gtc.dim.e.b.a("al us");
                    return com.getui.gtc.dim.c.a.h();
                }
                com.getui.gtc.dim.e.b.a("al pm");
                return com.getui.gtc.dim.c.a.g();
            case 22:
                return com.getui.gtc.dim.c.a.i();
            case 23:
                return com.getui.gtc.dim.c.a.a(context);
            case 24:
                return com.getui.gtc.dim.c.a.a(0, context);
            case 25:
                return com.getui.gtc.dim.c.a.a(1, context);
            case 26:
                return com.getui.gtc.dim.c.a.b(context);
            case 27:
                return com.getui.gtc.dim.c.a.b(com.getui.gtc.dim.c.a.c(0, context), context);
            case 28:
                return com.getui.gtc.dim.c.a.b(com.getui.gtc.dim.c.a.c(1, context), context);
            case 29:
                return com.getui.gtc.dim.c.a.g(context);
            case 30:
                return com.getui.gtc.dim.c.a.a();
            case 31:
                return com.getui.gtc.dim.c.a.f(context);
            case 32:
                return com.getui.gtc.dim.c.a.a(context, this.d != 0);
            case 33:
                return com.getui.gtc.dim.c.b.a(dimRequest);
            case 34:
                return com.getui.gtc.dim.c.a.c(context);
            case 35:
                return com.getui.gtc.dim.c.a.d(com.getui.gtc.dim.c.a.c(0, context), context);
            case 36:
                return com.getui.gtc.dim.c.a.d(com.getui.gtc.dim.c.a.c(1, context), context);
            case 37:
                return com.getui.gtc.dim.c.a.d(context);
            case 38:
                return com.getui.gtc.dim.c.a.e(context);
            case 39:
                return com.getui.gtc.dim.c.a.b();
            default:
                com.getui.gtc.dim.e.b.b("dim cannot understand key for " + dimRequest.getKey());
                return Void.TYPE;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Object b(String str, AppDataProvider appDataProvider) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 320888255:
                if (str.equals("dim-2-1-10-1")) {
                    b = 0;
                }
                break;
            case 320889216:
                if (str.equals("dim-2-1-11-1")) {
                    b = 1;
                }
                break;
            case 320890177:
                if (str.equals("dim-2-1-12-1")) {
                    b = 2;
                }
                break;
            case 320891138:
                if (str.equals("dim-2-1-13-1")) {
                    b = 3;
                }
                break;
            case 320892099:
                if (str.equals("dim-2-1-14-1")) {
                    b = 4;
                }
                break;
            case 320893060:
                if (str.equals("dim-2-1-15-1")) {
                    b = 5;
                }
                break;
            case 320894021:
                if (str.equals("dim-2-1-16-1")) {
                    b = 6;
                }
                break;
            case 320894022:
                if (str.equals("dim-2-1-16-2")) {
                    b = 7;
                }
                break;
            case 320894982:
                if (str.equals("dim-2-1-17-1")) {
                    b = 8;
                }
                break;
            case 320894983:
                if (str.equals("dim-2-1-17-2")) {
                    b = 9;
                }
                break;
            case 320895943:
                if (str.equals("dim-2-1-18-1")) {
                    b = 10;
                }
                break;
            case 320895944:
                if (str.equals("dim-2-1-18-2")) {
                    b = 11;
                }
                break;
            case 320895945:
                if (str.equals("dim-2-1-18-3")) {
                    b = 12;
                }
                break;
            case 320896904:
                if (str.equals("dim-2-1-19-1")) {
                    b = 13;
                }
                break;
            case 320896905:
                if (str.equals("dim-2-1-19-2")) {
                    b = com.google.common.base.a.p;
                }
                break;
            case 320919007:
                if (str.equals("dim-2-1-21-1")) {
                    b = com.google.common.base.a.q;
                }
                break;
            case 320919008:
                if (str.equals("dim-2-1-21-2")) {
                    b = com.google.common.base.a.r;
                }
                break;
            case 320919009:
                if (str.equals("dim-2-1-21-3")) {
                    b = 17;
                }
                break;
            case 320919011:
                if (str.equals("dim-2-1-21-5")) {
                    b = com.google.common.base.a.u;
                }
                break;
            case 320919968:
                if (str.equals("dim-2-1-22-1")) {
                    b = 19;
                }
                break;
            case 1672919129:
                if (str.equals("dim-2-1-1-1")) {
                    b = com.google.common.base.a.x;
                }
                break;
            case 1672919131:
                if (str.equals("dim-2-1-1-3")) {
                    b = com.google.common.base.a.y;
                }
                break;
            case 1672919132:
                if (str.equals("dim-2-1-1-4")) {
                    b = com.google.common.base.a.z;
                }
                break;
            case 1672920090:
                if (str.equals("dim-2-1-2-1")) {
                    b = com.google.common.base.a.A;
                }
                break;
            case 1672920092:
                if (str.equals("dim-2-1-2-3")) {
                    b = com.google.common.base.a.B;
                }
                break;
            case 1672920093:
                if (str.equals("dim-2-1-2-4")) {
                    b = com.google.common.base.a.C;
                }
                break;
            case 1672921051:
                if (str.equals("dim-2-1-3-1")) {
                    b = com.google.common.base.a.D;
                }
                break;
            case 1672921052:
                if (str.equals("dim-2-1-3-2")) {
                    b = com.google.common.base.a.E;
                }
                break;
            case 1672922012:
                if (str.equals("dim-2-1-4-1")) {
                    b = com.google.common.base.a.F;
                }
                break;
            case 1672922973:
                if (str.equals("dim-2-1-5-1")) {
                    b = com.google.common.base.a.G;
                }
                break;
            case 1672923934:
                if (str.equals("dim-2-1-6-1")) {
                    b = com.google.common.base.a.H;
                }
                break;
            case 1672923936:
                if (str.equals("dim-2-1-6-3")) {
                    b = 31;
                }
                break;
            case 1672923937:
                if (str.equals("dim-2-1-6-4")) {
                    b = 32;
                }
                break;
            case 1672924895:
                if (str.equals("dim-2-1-7-1")) {
                    b = com.google.android.exoplayer2.text.cea.a.e;
                }
                break;
            case 1672925856:
                if (str.equals("dim-2-1-8-1")) {
                    b = 34;
                }
                break;
            case 1672926817:
                if (str.equals("dim-2-1-9-1")) {
                    b = 35;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 12:
            case 13:
            case 14:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return a(str, appDataProvider);
            case 8:
            case 9:
                return a(str, appDataProvider, Location.class, false, null);
            case 10:
                return a(str, appDataProvider, WifiInfo.class, false, null);
            case 11:
                return a(str, appDataProvider, ScanResult.class, true, null);
            case 15:
            case 16:
            case 17:
            case 18:
                return a(str, appDataProvider, PackageInfo.class, true, null);
            default:
                com.getui.gtc.dim.e.b.b("dim cannot understand key for ".concat(str));
                return Void.TYPE;
        }
    }

    public static g d() {
        return a.f30313a;
    }

    private Object i(String str) {
        Method method;
        try {
            String str2 = this.f;
            if (str2 != null && (method = this.h) != null) {
                method.invoke(null, str2);
                this.f = null;
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
        }
        try {
            if (this.g != null) {
                Bundle bundle = new Bundle();
                bundle.putString("dimKey", str);
                return this.g.invoke(null, bundle);
            }
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.b(th2);
        }
        return Void.TYPE;
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ int a() {
        return super.a();
    }

    /* JADX WARN: Code duplicated, block: B:207:0x0390  */
    /* JADX WARN: Code duplicated, block: B:209:0x0395  */
    /* JADX WARN: Code duplicated, block: B:210:0x0397  */
    /* JADX WARN: Code duplicated, block: B:212:0x039a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:226:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:228:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:232:0x040b  */
    /* JADX WARN: Code duplicated, block: B:238:0x0422  */
    public final e a(DimRequest dimRequest) {
        AllowSysCall allowSysCall;
        boolean[] zArr;
        StringBuilder sb;
        final boolean z;
        final boolean z2;
        String key;
        Caller caller;
        boolean z3;
        DimSource dimSourceOf;
        b bVarA;
        String str;
        String str2;
        b bVarA2 = b.a();
        long j2 = i;
        try {
            synchronized (bVarA2) {
                if (bVarA2.b < 0) {
                    long jB = b.b("dim-key-sdk-access-count");
                    bVarA2.b = jB;
                    if (jB < bVarA2.f30302a) {
                        bVarA2.b = jB + 1;
                        d unused = d.a.f30307a;
                        d.a("dim-key-sdk-access-count", (Object) String.valueOf(bVarA2.b));
                        str2 = "dim sys update sdkAccessCount: " + bVarA2.b;
                    } else {
                        str2 = "dim sys sdkAccessCount: " + bVarA2.b + " enough";
                    }
                    com.getui.gtc.dim.e.b.a(str2);
                }
                if (bVarA2.d < 0) {
                    bVarA2.d = b.b("dim-key-sdk-total-runtime");
                }
                if (bVarA2.d < bVarA2.c * 1000) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = bVarA2.e;
                    if (j3 > 0) {
                        j2 = j3;
                    }
                    long j4 = jElapsedRealtime - j2;
                    if (j4 >= 10000) {
                        bVarA2.e = jElapsedRealtime;
                        bVarA2.d += j4;
                        d unused2 = d.a.f30307a;
                        d.a("dim-key-sdk-total-runtime", (Object) String.valueOf(bVarA2.d));
                        str = "dim sys update sdkTotalRuntime: " + bVarA2.d;
                    }
                } else {
                    str = "dim sys sdkTotalRuntime: " + bVarA2.d + " enough";
                }
                com.getui.gtc.dim.e.b.a(str);
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
        }
        e eVar = new e("none");
        if (dimRequest != null && !TextUtils.isEmpty(dimRequest.getKey())) {
            String key2 = dimRequest.getKey();
            int i2 = Build.VERSION.SDK_INT;
            byte b = com.google.common.base.a.F;
            boolean z4 = false;
            if (i2 >= 28 && f.f30309a.contains(key2) && CommonUtil.isAppDebugEnable()) {
                sb = new StringBuilder(" check debug ");
            } else {
                if (super.g(key2)) {
                    sb = new StringBuilder(" check exclude phone ");
                } else {
                    key2.hashCode();
                    switch (key2.hashCode()) {
                        case 320892099:
                            b = !key2.equals("dim-2-1-14-1") ? (byte) -1 : (byte) 0;
                            break;
                        case 320894021:
                            b = !key2.equals("dim-2-1-16-1") ? (byte) -1 : (byte) 1;
                            break;
                        case 320894022:
                            b = !key2.equals("dim-2-1-16-2") ? (byte) -1 : (byte) 2;
                            break;
                        case 320894982:
                            b = !key2.equals("dim-2-1-17-1") ? (byte) -1 : (byte) 3;
                            break;
                        case 320894983:
                            b = !key2.equals("dim-2-1-17-2") ? (byte) -1 : (byte) 4;
                            break;
                        case 320894984:
                            b = !key2.equals("dim-2-1-17-3") ? (byte) -1 : (byte) 5;
                            break;
                        case 320894985:
                            b = !key2.equals("dim-2-1-17-4") ? (byte) -1 : (byte) 6;
                            break;
                        case 320895943:
                            b = !key2.equals("dim-2-1-18-1") ? (byte) -1 : (byte) 7;
                            break;
                        case 320895944:
                            b = !key2.equals("dim-2-1-18-2") ? (byte) -1 : (byte) 8;
                            break;
                        case 320895945:
                            b = !key2.equals("dim-2-1-18-3") ? (byte) -1 : (byte) 9;
                            break;
                        case 320895946:
                            b = !key2.equals("dim-2-1-18-4") ? (byte) -1 : (byte) 10;
                            break;
                        case 320896904:
                            b = !key2.equals("dim-2-1-19-1") ? (byte) -1 : (byte) 11;
                            break;
                        case 320896905:
                            b = !key2.equals("dim-2-1-19-2") ? (byte) -1 : (byte) 12;
                            break;
                        case 320919007:
                            b = !key2.equals("dim-2-1-21-1") ? (byte) -1 : (byte) 13;
                            break;
                        case 320919008:
                            b = !key2.equals("dim-2-1-21-2") ? (byte) -1 : com.google.common.base.a.p;
                            break;
                        case 320919009:
                            b = !key2.equals("dim-2-1-21-3") ? (byte) -1 : com.google.common.base.a.q;
                            break;
                        case 320919011:
                            b = !key2.equals("dim-2-1-21-5") ? (byte) -1 : com.google.common.base.a.r;
                            break;
                        case 1672919129:
                            b = !key2.equals("dim-2-1-1-1") ? (byte) -1 : (byte) 17;
                            break;
                        case 1672919131:
                            b = !key2.equals("dim-2-1-1-3") ? (byte) -1 : com.google.common.base.a.u;
                            break;
                        case 1672919132:
                            b = !key2.equals("dim-2-1-1-4") ? (byte) -1 : (byte) 19;
                            break;
                        case 1672920090:
                            b = !key2.equals("dim-2-1-2-1") ? (byte) -1 : com.google.common.base.a.x;
                            break;
                        case 1672920092:
                            b = !key2.equals("dim-2-1-2-3") ? (byte) -1 : com.google.common.base.a.y;
                            break;
                        case 1672920093:
                            b = !key2.equals("dim-2-1-2-4") ? (byte) -1 : com.google.common.base.a.z;
                            break;
                        case 1672921051:
                            b = !key2.equals("dim-2-1-3-1") ? (byte) -1 : com.google.common.base.a.A;
                            break;
                        case 1672921052:
                            b = !key2.equals("dim-2-1-3-2") ? (byte) -1 : com.google.common.base.a.B;
                            break;
                        case 1672922012:
                            b = !key2.equals("dim-2-1-4-1") ? (byte) -1 : com.google.common.base.a.C;
                            break;
                        case 1672923934:
                            b = !key2.equals("dim-2-1-6-1") ? (byte) -1 : com.google.common.base.a.D;
                            break;
                        case 1672923936:
                            b = !key2.equals("dim-2-1-6-3") ? (byte) -1 : com.google.common.base.a.E;
                            break;
                        case 1672923937:
                            if (!key2.equals("dim-2-1-6-4")) {
                                b = -1;
                            }
                            break;
                        case 1672924895:
                            b = !key2.equals("dim-2-1-7-1") ? (byte) -1 : com.google.common.base.a.G;
                            break;
                        case 1672925856:
                            b = !key2.equals("dim-2-1-8-1") ? (byte) -1 : com.google.common.base.a.H;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                            allowSysCall = AllowSysCall.NOT_ALLOW;
                            break;
                        default:
                            allowSysCall = AllowSysCall.ALL_ALLOW;
                            break;
                    }
                    Integer num = this.b.get(key2);
                    if (num == null) {
                        num = this.b.get("dim-2-2-0-1");
                    }
                    AllowSysCall allowSysCallValueOf = num != null ? AllowSysCall.valueOf((num.intValue() >> 2) & 3) : AllowSysCall.NOT_ALLOW;
                    AllowSysCall allowSysCallValueOf2 = num != null ? AllowSysCall.valueOf(num.intValue() & 3) : allowSysCall;
                    com.getui.gtc.dim.e.b.a("dim allowSysCall check for " + key2 + ", dycValue = " + num + ", localValue = " + allowSysCall + ", use gdi = " + allowSysCallValueOf + " , dim = " + allowSysCallValueOf2);
                    int value = allowSysCallValueOf.getValue();
                    AllowSysCall allowSysCall2 = AllowSysCall.NOT_ALLOW;
                    zArr = new boolean[]{value <= allowSysCall2.getValue() ? false : allowSysCallValueOf.getValue() == AllowSysCall.ONLY_ALLOW_FORE_CALL.getValue() ? CommonUtil.isAppForeground() : true, allowSysCallValueOf2.getValue() <= allowSysCall2.getValue() ? false : allowSysCallValueOf2.getValue() == AllowSysCall.ONLY_ALLOW_FORE_CALL.getValue() ? CommonUtil.isAppForeground() : true, true};
                }
                z = zArr[0];
                z2 = zArr[1];
                key = dimRequest.getKey();
                caller = dimRequest.getCaller();
                if (z || z2) {
                    if ((this.c & 1) == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (caller != null || z3) {
                        if (d(key)) {
                            return a(dimRequest, z, z2, false);
                        }
                    } else if (caller == Caller.UNKNOWN) {
                        DimSource dimSourceE = e(key);
                        if (dimSourceE != null) {
                            return (e) dimSourceE.get(dimRequest, new DimCallback<DimRequest, e>() { // from class: com.getui.gtc.dim.b.g.2
                                @Override // com.getui.gtc.dim.DimCallback
                                public final /* synthetic */ e get(DimRequest dimRequest2) {
                                    return g.a(g.this, dimRequest2, z, z2);
                                }
                            });
                        }
                    } else if (a(caller, key) && (dimSourceOf = DimSource.of(caller)) != null) {
                        return (e) dimSourceOf.get(dimRequest, new DimCallback<DimRequest, e>() { // from class: com.getui.gtc.dim.b.g.3
                            @Override // com.getui.gtc.dim.DimCallback
                            public final /* synthetic */ e get(DimRequest dimRequest2) {
                                return g.a(g.this, dimRequest2, z, z2);
                            }
                        });
                    }
                }
                com.getui.gtc.dim.e.b.b("dim cannot call sys for " + key + ", caller: " + caller + ", callers: " + super.c() + ", allowed: " + Arrays.toString(zArr));
                if (zArr[2]) {
                    bVarA = b.a();
                    if (bVarA.c(key) && b.a(bVarA.h, bVarA.g)) {
                        z4 = true;
                    }
                    if (z4) {
                        return (!z || z2) ? a(dimRequest, z, z2, true) : a(dimRequest, true, b.a().f, true);
                    }
                }
            }
            sb.append(key2);
            sb.append(", disallow ");
            com.getui.gtc.dim.e.b.a(sb.toString());
            zArr = new boolean[]{false, false, false};
            z = zArr[0];
            z2 = zArr[1];
            key = dimRequest.getKey();
            caller = dimRequest.getCaller();
            if (z) {
                if ((this.c & 1) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (caller != null) {
                    if (d(key)) {
                        return a(dimRequest, z, z2, false);
                    }
                } else if (d(key)) {
                    return a(dimRequest, z, z2, false);
                }
            } else {
                if ((this.c & 1) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (caller != null) {
                    if (d(key)) {
                        return a(dimRequest, z, z2, false);
                    }
                } else if (d(key)) {
                    return a(dimRequest, z, z2, false);
                }
            }
            com.getui.gtc.dim.e.b.b("dim cannot call sys for " + key + ", caller: " + caller + ", callers: " + super.c() + ", allowed: " + Arrays.toString(zArr));
            if (zArr[2]) {
                bVarA = b.a();
                if (bVarA.c(key)) {
                    z4 = true;
                }
                if (z4) {
                    if (z) {
                    }
                }
            }
        }
        return eVar;
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void a(int i2) {
        super.a(i2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void a(AppDataProvider appDataProvider) {
        super.a(appDataProvider);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void a(Caller caller) {
        super.a(caller);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void a(String str, int i2) {
        super.a(str, i2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ boolean a(String str, Caller caller, boolean z) {
        return super.a(str, caller, z);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ boolean a(String str, String str2) {
        return super.a(str, str2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ Boolean b(String str, String str2) {
        return super.b(str, str2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void b(int i2) {
        super.b(i2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void b(String str, int i2) {
        super.b(str, i2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ boolean b(String str, Caller caller, boolean z) {
        return super.b(str, caller, z);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ int c() {
        return super.c();
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void c(int i2) {
        super.c(i2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void c(String str) {
        super.c(str);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void c(String str, int i2) {
        super.c(str, i2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void c(String str, String str2) {
        super.c(str, str2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void d(String str, String str2) {
        super.d(str, str2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void e(String str, String str2) {
        super.e(str, str2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void f(String str) {
        super.f(str);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void f(String str, String str2) {
        super.f(str, str2);
    }

    @Override // com.getui.gtc.dim.b.f
    public final /* bridge */ /* synthetic */ void g(String str, String str2) {
        super.g(str, str2);
    }
}
