package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bf {
    public static String bqc = "";

    public static /* synthetic */ String A(Context context, boolean z) {
        return ea(context);
    }

    public static com.kwad.sdk.k.a.b TB() {
        return com.kwad.sdk.k.a.b.TB();
    }

    public static com.kwad.sdk.k.a.f TC() {
        return com.kwad.sdk.k.a.f.TC();
    }

    private static String Wh() {
        com.kwad.sdk.k.a.f fVarTC = com.kwad.sdk.k.a.f.TC();
        int i = fVarTC != null ? fVarTC.bmF : -1;
        if (i >= 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i), 0);
        }
        return !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FF() ? com.kwad.sdk.e.b.a(false, String.valueOf(i), 1) : com.kwad.sdk.e.b.a(false, String.valueOf(i), 2);
    }

    private static String Wi() {
        com.kwad.sdk.k.a.b bVarTB = com.kwad.sdk.k.a.b.TB();
        if (bVarTB != null) {
            return com.kwad.sdk.e.b.a(false, bVarTB.toJson(), 0);
        }
        return !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FH() ? com.kwad.sdk.e.b.a(false, "", 1) : com.kwad.sdk.e.b.a(false, "", 2);
    }

    private static String Wj() {
        return com.kwad.sdk.e.b.a(false, "1", 0);
    }

    private static String Wk() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String Wl() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    public static /* synthetic */ String cA(boolean z) {
        return cv(true);
    }

    public static /* synthetic */ String cB(boolean z) {
        return cw(true);
    }

    public static /* synthetic */ String cC(boolean z) {
        return Wj();
    }

    public static /* synthetic */ String cD(boolean z) {
        return Wk();
    }

    public static /* synthetic */ String cE(boolean z) {
        return Wl();
    }

    private static String cu(boolean z) {
        String strCF = bt.cF(z);
        if (!z) {
            return TextUtils.isEmpty(strCF) ? "" : strCF;
        }
        if (TextUtils.isEmpty(strCF)) {
            return (be.useOaidDisable() || !t.UI()) ? com.kwad.sdk.e.b.a(false, strCF, 1) : com.kwad.sdk.e.b.a(false, strCF, 5);
        }
        return com.kwad.sdk.e.b.a(be.useOaidDisable() && !TextUtils.isEmpty(be.getDevOaid()), strCF, 0);
    }

    private static String cv(boolean z) {
        if (com.kwad.framework.a.a.pe.booleanValue() && !TextUtils.isEmpty(bu.getDeviceId())) {
            return bu.getDeviceId();
        }
        String deviceId = bt.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return (be.usePhoneStateDisable() || !t.UG()) ? com.kwad.sdk.e.b.a(false, deviceId, 1) : com.kwad.sdk.e.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.e.b.a(be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevAndroidId()), deviceId, 0);
    }

    private static String cw(boolean z) {
        String strWY = bt.WY();
        if (!z) {
            return TextUtils.isEmpty(strWY) ? "" : strWY;
        }
        if (TextUtils.isEmpty(strWY)) {
            return (be.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(8L)) ? com.kwad.sdk.e.b.a(false, strWY, 1) : com.kwad.sdk.e.b.a(false, strWY, 2);
        }
        return com.kwad.sdk.e.b.a(be.useNetworkStateDisable(), strWY, 0);
    }

    public static /* synthetic */ String cx(boolean z) {
        return cu(true);
    }

    public static /* synthetic */ String cy(boolean z) {
        return Wh();
    }

    public static /* synthetic */ String cz(boolean z) {
        return Wi();
    }

    public static String dO(Context context) {
        return j(context, false);
    }

    public static String dP(Context context) {
        return k(context, false);
    }

    public static String dQ(Context context) {
        return l(context, false);
    }

    public static String dR(Context context) {
        return m(context, false);
    }

    public static String dS(Context context) {
        return n(context, false);
    }

    public static String dT(Context context) {
        return o(context, false);
    }

    public static String dU(Context context) {
        return p(context, false);
    }

    public static int dV(Context context) {
        return bt.ex(context);
    }

    private static String dW(Context context) {
        int iEx = bt.ex(context);
        return iEx > 0 ? com.kwad.sdk.e.b.a(false, String.valueOf(iEx), 0) : com.kwad.sdk.e.b.a(false, String.valueOf(iEx), 3);
    }

    public static int dX(Context context) {
        return bt.ey(context);
    }

    private static String dY(Context context) {
        List<cf.a> listO = o(context, 15);
        if (listO != null && listO.size() > 0) {
            return com.kwad.sdk.e.b.a(be.useNetworkStateDisable(), ac.Y(listO), 0);
        }
        if (be.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(32L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", cf.eG(context) ? 1 : 3);
    }

    private static Map<String, AppPackageInfo> dZ(Context context) {
        com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
        return (pVar == null || !t.UK()) ? new HashMap() : pVar.P(context);
    }

    public static com.kwad.sdk.utils.d.a dg(Context context) {
        return z.dg(context);
    }

    private static String ea(Context context) {
        com.kwad.sdk.core.c.b.LW();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> mapDZ = dZ(context);
        if (mapDZ.size() > 0) {
            boolean z = be.readInstalledPackagesDisable() && be.getDevInstalledPackages() != null;
            com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
            if (pVar != null && t.UK()) {
                return com.kwad.sdk.e.b.a(z, pVar.c(mapDZ), 0);
            }
        }
        if (be.readInstalledPackagesDisable() || !t.UK()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", bt.eE(context) ? 3 : 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String eb(Context context) {
        com.kwad.sdk.utils.d.a aVarDg = z.dg(context);
        if (aVarDg == null || aVarDg.bsT == null) {
            if (be.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(64L)) {
                return com.kwad.sdk.e.b.a(false, "", 1);
            }
            return com.kwad.sdk.e.b.a(false, "", (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) == true ? 3 : 1);
        }
        HashMap map = new HashMap();
        map.put("latitude", String.valueOf(aVarDg.bsT.getLatitude()));
        map.put("longitude", String.valueOf(aVarDg.bsT.getLongitude()));
        return com.kwad.sdk.e.b.a(be.readLocationDisable() && be.Wf() != null, ac.parseMap2JSON(map), 0);
    }

    @NonNull
    private static com.kwad.sdk.e.c ec(final Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.bf.1
            @Override // com.kwad.sdk.e.a
            public final String QO() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + bf.r(context, true));
                return bf.r(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String QP() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + bf.t(context, true));
                return bf.t(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String QQ() {
                String strU = bf.u(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + strU);
                return strU;
            }

            @Override // com.kwad.sdk.e.a
            public final String QR() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + bf.v(context, true));
                return bf.v(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String QS() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + bf.x(context, true));
                return bf.x(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String QT() {
                String strCy = bf.cy(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + strCy);
                return strCy;
            }

            @Override // com.kwad.sdk.e.a
            public final String QU() {
                String strCz = bf.cz(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + strCz);
                return strCz;
            }

            @Override // com.kwad.sdk.e.a
            public final String QV() {
                String strY = bf.y(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + strY);
                return strY;
            }

            @Override // com.kwad.sdk.e.a
            public final String QW() {
                String strA = bf.A(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + strA);
                return strA;
            }

            @Override // com.kwad.sdk.e.a
            public final String QX() {
                String strCC = bf.cC(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + strCC);
                return strCC;
            }

            @Override // com.kwad.sdk.e.a
            public final String getAppId() {
                String strCE = bf.cE(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + strCE);
                return strCE;
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String strCA = bf.cA(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + strCA);
                return strCA;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIMEI() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + bf.q(context, true));
                return bf.q(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + bf.w(context, true));
                return bf.w(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String strCB = bf.cB(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIp:" + strCB);
                return strCB;
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String strZ = bf.z(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + strZ);
                return strZ;
            }

            @Override // com.kwad.sdk.e.a
            public final String getMac() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + bf.s(context, true));
                return bf.s(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + bf.cx(true));
                return bf.cx(true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getSdkVersion() {
                String strCD = bf.cD(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + strCD);
                return strCD;
            }
        };
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    public static String getDeviceId() {
        return cv(false);
    }

    public static String getOaid() {
        return cu(false);
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(ec(context));
    }

    private static String j(Context context, boolean z) {
        String strB = bt.B(context, z);
        if (!z) {
            return TextUtils.isEmpty(strB) ? "" : strB;
        }
        if (!TextUtils.isEmpty(strB)) {
            return com.kwad.sdk.e.b.a(be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevImei()), strB, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strB, 4);
        }
        if (be.usePhoneStateDisable() || !t.UM()) {
            return com.kwad.sdk.e.b.a(false, strB, 1);
        }
        return com.kwad.sdk.e.b.a(false, strB, SystemUtil.eo(context) ? 3 : 1);
    }

    private static String k(Context context, boolean z) {
        String strDP = bt.dP(context);
        if (!z) {
            return TextUtils.isEmpty(strDP) ? "" : strDP;
        }
        if (TextUtils.isEmpty(strDP)) {
            return (be.usePhoneStateDisable() || !t.UG()) ? com.kwad.sdk.e.b.a(false, strDP, 1) : com.kwad.sdk.e.b.a(false, strDP, 5);
        }
        return com.kwad.sdk.e.b.a(be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevAndroidId()), strDP, 0);
    }

    private static String l(Context context, boolean z) {
        String strEI = com.kwad.sdk.utils.c.d.eI(context);
        if (!z) {
            return TextUtils.isEmpty(strEI) ? "" : strEI;
        }
        if (!TextUtils.isEmpty(strEI)) {
            return com.kwad.sdk.e.b.a(be.useMacAddressDisable() && !TextUtils.isEmpty(be.getDevMacAddress()), strEI.toLowerCase(), 0);
        }
        if (be.useMacAddressDisable() || !t.UH()) {
            return com.kwad.sdk.e.b.a(false, strEI, 0);
        }
        return com.kwad.sdk.e.b.a(false, strEI, aw.aA(context, com.kuaishou.weapon.p0.g.d) == 0 ? 3 : 1);
    }

    private static String m(Context context, boolean z) {
        String[] strArrEw = bt.ew(context);
        String str = (strArrEw == null || strArrEw.length <= 0) ? null : strArrEw[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (be.usePhoneStateDisable() || !t.UM()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.eo(context) ? 3 : 1);
    }

    private static String n(Context context, boolean z) {
        String[] strArrEw = bt.ew(context);
        String str = (strArrEw == null || strArrEw.length <= 1) ? null : strArrEw[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (be.usePhoneStateDisable() || !t.UM()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.eo(context) ? 3 : 1);
    }

    private static String o(Context context, boolean z) {
        String strDT = bt.dT(context);
        if (!z) {
            return TextUtils.isEmpty(strDT) ? "" : strDT;
        }
        if (!TextUtils.isEmpty(strDT)) {
            return com.kwad.sdk.e.b.a(be.usePhoneStateDisable(), strDT, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strDT, 4);
        }
        if (be.usePhoneStateDisable() || !t.UN()) {
            return com.kwad.sdk.e.b.a(false, strDT, 1);
        }
        return com.kwad.sdk.e.b.a(false, strDT, SystemUtil.eo(context) ? 3 : 1);
    }

    private static String p(Context context, boolean z) {
        String strEz = bt.ez(context);
        if (!z) {
            return TextUtils.isEmpty(strEz) ? "" : strEz;
        }
        if (!TextUtils.isEmpty(strEz)) {
            return com.kwad.sdk.e.b.a(be.usePhoneStateDisable(), strEz, 0);
        }
        if (be.usePhoneStateDisable() || !t.UO()) {
            return com.kwad.sdk.e.b.a(false, strEz, 1);
        }
        return com.kwad.sdk.e.b.a(false, strEz, SystemUtil.eo(context) ? 3 : 1);
    }

    public static /* synthetic */ String q(Context context, boolean z) {
        return j(context, true);
    }

    public static /* synthetic */ String r(Context context, boolean z) {
        return k(context, true);
    }

    public static /* synthetic */ String s(Context context, boolean z) {
        return l(context, true);
    }

    public static /* synthetic */ String t(Context context, boolean z) {
        return m(context, true);
    }

    public static /* synthetic */ String u(Context context, boolean z) {
        return n(context, true);
    }

    public static /* synthetic */ String v(Context context, boolean z) {
        return o(context, true);
    }

    public static /* synthetic */ String w(Context context, boolean z) {
        return p(context, true);
    }

    public static /* synthetic */ String x(Context context, boolean z) {
        return dW(context);
    }

    public static /* synthetic */ String y(Context context, boolean z) {
        return dY(context);
    }

    public static /* synthetic */ String z(Context context, boolean z) {
        return eb(context);
    }

    public static List<cf.a> o(Context context, int i) {
        List<cf.a> listO = cf.o(context, 15);
        if (listO != null) {
            com.kwad.sdk.core.d.c.w("SDKPrivateSafetyDataUtil", "getWifiList: " + listO.size());
        }
        return listO;
    }
}
