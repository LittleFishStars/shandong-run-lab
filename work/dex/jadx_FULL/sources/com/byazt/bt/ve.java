package com.byazt.bt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f28331a;
    public static String c;
    public static volatile WifiManager d;
    public static volatile String da;
    public static volatile WifiInfo eo;
    public static volatile boolean gr;
    public static volatile boolean gt;
    public static volatile boolean gu;
    public static volatile TelephonyManager h;
    public static volatile String i;
    public static volatile boolean m;
    public static volatile boolean md;
    public static volatile boolean my;
    public static volatile boolean nu;
    public static volatile long p;
    public static volatile boolean qy;
    public static volatile boolean rh;
    public static volatile boolean rl;
    public static volatile String sl;
    public static volatile String t;
    public static volatile String tt;
    public static volatile String u;
    public static volatile String uj;
    public static volatile String ve;
    public static volatile String yp;
    public static volatile String yv;
    public static volatile boolean zm;
    public static AtomicBoolean n = new AtomicBoolean(false);
    public static volatile String sp = "";
    public static volatile boolean x = true;
    public static volatile String z = null;

    private static String a(Context context) {
        if (gt) {
            return f28331a;
        }
        synchronized (ve.class) {
            if (gt) {
                return f28331a;
            }
            if (nu) {
                return tt;
            }
            TelephonyManager telephonyManagerC = c(context);
            if (telephonyManagerC == null) {
                return f28331a;
            }
            try {
                f28331a = telephonyManagerC.getSubscriberId();
            } catch (Throwable unused) {
            }
            gt = true;
            return f28331a;
        }
    }

    private static String da(com.byazt.dna.c cVar, Context context) {
        if (rh) {
            return ve;
        }
        synchronized (ve.class) {
            if (rh) {
                return ve;
            }
            try {
                WifiInfo wifiInfoC = c(cVar, context);
                if (wifiInfoC == null) {
                    return ve;
                }
                ve = wifiInfoC.getSSID();
                rh = true;
                return ve;
            } catch (Throwable unused) {
            }
        }
    }

    public static String i(com.byazt.dna.c cVar, Context context) {
        t(cVar, context);
        return u;
    }

    private static void n(Context context) {
        synchronized (ve.class) {
            if (m) {
                return;
            }
            if (nu) {
                return;
            }
            if (uj.c(context, "android.permission.READ_PHONE_STATE") == 0) {
                nu = true;
                TelephonyManager telephonyManagerC = c(context);
                if (telephonyManagerC == null) {
                    return;
                }
                try {
                    tt = telephonyManagerC.getImei();
                } catch (Throwable unused) {
                }
                m = true;
            }
        }
    }

    private static String sl(com.byazt.dna.c cVar, Context context) {
        if (my) {
            return uj;
        }
        synchronized (ve.class) {
            if (my) {
                return uj;
            }
            uj = ve(cVar, context);
            my = true;
            return uj;
        }
    }

    public static String sp(com.byazt.dna.c cVar, Context context) {
        t(cVar, context);
        return sl;
    }

    private static void t(com.byazt.dna.c cVar, Context context) {
        String strUj;
        String simOperatorName;
        String strSubstring;
        if (gu) {
            return;
        }
        synchronized (ve.class) {
            if (gu) {
                return;
            }
            TelephonyManager telephonyManagerC = c(context);
            String strSubstring2 = null;
            try {
                strUj = telephonyManagerC.getNetworkOperator();
            } catch (Throwable unused) {
                strUj = null;
            }
            if (TextUtils.isEmpty(strUj) || strUj.length() < 5) {
                strUj = uj(cVar, context);
            }
            try {
                simOperatorName = telephonyManagerC.getSimOperatorName();
            } catch (Throwable unused2) {
                simOperatorName = null;
            }
            if (TextUtils.isEmpty(strUj) || strUj.length() <= 4) {
                strSubstring = null;
            } else {
                strSubstring2 = strUj.substring(0, 3);
                strSubstring = strUj.substring(3);
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                i = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                sl = strSubstring;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                u = simOperatorName;
            }
            try {
                sp(context);
            } catch (Throwable th) {
                m.c(th);
            }
            gu = true;
        }
    }

    public static String tt(Boolean bool, com.byazt.dna.c cVar, Context context) {
        if (!TextUtils.isEmpty(f28331a)) {
            return f28331a;
        }
        if (bool == null) {
            com.byazt.lz.c customController = cVar.getCustomController();
            if (customController != null && !customController.isCanUsePhoneState()) {
                return null;
            }
        } else {
            if (gt || nu) {
                return f28331a;
            }
            if (!bool.booleanValue()) {
                return null;
            }
        }
        return a(context);
    }

    private static WifiManager uj(Context context) {
        if (d != null) {
            return d;
        }
        synchronized (ve.class) {
            if (d != null) {
                return d;
            }
            d = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            return d;
        }
    }

    public static String ve(Boolean bool, com.byazt.dna.c cVar, Context context) {
        if (!TextUtils.isEmpty(ve)) {
            return ve;
        }
        if (bool == null) {
            com.byazt.lz.c customController = cVar.getCustomController();
            if (customController != null && (!customController.isCanUseWifiState() || !customController.isCanUseLocation())) {
                return null;
            }
        } else {
            if (rh) {
                return ve;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return da(cVar, context);
    }

    public static String x(com.byazt.dna.c cVar, Context context) {
        t(cVar, context);
        return t;
    }

    public static TelephonyManager c(Context context) {
        if (h != null) {
            return h;
        }
        synchronized (ve.class) {
            if (h != null) {
                return h;
            }
            h = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            return h;
        }
    }

    private static synchronized void sp(Context context) {
        String strValueOf;
        String strValueOf2;
        if (md) {
            return;
        }
        synchronized (ve.class) {
            md = true;
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            if (subscriptionManager.getActiveSubscriptionInfoCount() < 2) {
                return;
            }
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList.size() < 2) {
                return;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                SubscriptionInfo subscriptionInfo = activeSubscriptionInfoList.get(i2);
                if (Build.VERSION.SDK_INT >= 29) {
                    strValueOf = subscriptionInfo.getMccString();
                    strValueOf2 = subscriptionInfo.getMncString();
                } else {
                    strValueOf = String.valueOf(subscriptionInfo.getMcc());
                    strValueOf2 = String.valueOf(subscriptionInfo.getMnc());
                }
                if (i2 == 0) {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        i = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        sl = strValueOf2;
                    }
                } else {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        da = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        t = strValueOf2;
                    }
                }
            }
        }
    }

    public static String tt(final com.byazt.dna.c cVar, final Context context) {
        if (TextUtils.isEmpty(uj) && !my) {
            if (n.get()) {
                return null;
            }
            n.set(true);
            ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("") { // from class: com.byazt.bt.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    ve.uj(null, cVar, context);
                    ve.n.set(false);
                }
            });
            return null;
        }
        return uj;
    }

    public static String ve(com.byazt.dna.c cVar, Context context) {
        try {
            WifiInfo wifiInfoC = c(cVar, context);
            if (wifiInfoC == null) {
                return "02:00:00:00:00:00";
            }
            String bssid = wifiInfoC.getBSSID();
            return TextUtils.isEmpty(bssid) ? "02:00:00:00:00:00" : bssid;
        } catch (Throwable unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static String uj(Boolean bool, com.byazt.dna.c cVar, Context context) {
        if (!TextUtils.isEmpty(uj)) {
            return uj;
        }
        if (bool == null) {
            com.byazt.lz.c customController = cVar.getCustomController();
            if (customController != null && (!customController.isCanUseWifiState() || !customController.isCanUseLocation())) {
                return null;
            }
        } else {
            if (my) {
                return uj;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return sl(cVar, context);
    }

    public static WifiInfo c(com.byazt.dna.c cVar, Context context) {
        com.byazt.lz.c customController = cVar.getCustomController();
        if (customController != null && (!customController.isCanUseWifiState() || !customController.isCanUseLocation())) {
            return eo;
        }
        if (eo != null) {
            return eo;
        }
        synchronized (ve.class) {
            if (eo != null) {
                return eo;
            }
            WifiManager wifiManagerUj = uj(context);
            if (wifiManagerUj == null) {
                return eo;
            }
            eo = wifiManagerUj.getConnectionInfo();
            return eo;
        }
    }

    @SuppressLint({"TrulyRandom", "HardwareIds"})
    public static synchronized String ve(Context context) {
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string) || string.length() < 13) {
            string = "";
        }
        return string;
    }

    public static boolean tt(Context context) {
        if (qy) {
            return x;
        }
        synchronized (ve.class) {
            if (qy) {
                return x;
            }
            try {
                int simState = c(context).getSimState();
                if (1 == simState) {
                    x = false;
                }
                if (simState == 0) {
                    x = false;
                }
                qy = true;
            } catch (Throwable unused) {
            }
            return x;
        }
    }

    public static String a(com.byazt.dna.c cVar, Context context) {
        t(cVar, context);
        return da;
    }

    public static String n(com.byazt.dna.c cVar, Context context) {
        try {
            t(cVar, context);
            if (!TextUtils.isEmpty(i)) {
                return i;
            }
            if (!c(p, 60000L)) {
                return yv;
            }
            if (!tt(context)) {
                return null;
            }
            int i2 = context.getResources().getConfiguration().mcc;
            String strValueOf = i2 != 0 ? String.valueOf(i2) : i;
            yv = strValueOf;
            p = System.currentTimeMillis();
            return strValueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String ve(com.byazt.dna.c cVar, boolean z2, int i2, com.byazt.lz.ve veVar) {
        try {
            String strTt = x.tt("new_mac_address", "", cVar);
            if (!TextUtils.isEmpty(strTt)) {
                JSONObject jSONObject = new JSONObject(strTt);
                long j = jSONObject.getLong("time");
                String strDecryptAESWithCBC = ((com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service")).decryptAESWithCBC(jSONObject.getString("value"));
                if (System.currentTimeMillis() - j <= 864000000 && !TextUtils.isEmpty(strDecryptAESWithCBC)) {
                    return strDecryptAESWithCBC;
                }
            }
        } catch (Exception unused) {
        }
        c(cVar, z2, i2, veVar);
        return z;
    }

    public static String uj(com.byazt.dna.c cVar, Context context) {
        com.byazt.lz.c customController = cVar.getCustomController();
        if (customController != null && !customController.isCanUsePhoneState()) {
            return "";
        }
        if (!TextUtils.isEmpty(sp)) {
            return sp;
        }
        if (rl) {
            return sp;
        }
        synchronized (ve.class) {
            if (rl) {
                return sp;
            }
            TelephonyManager telephonyManagerC = c(context);
            if (telephonyManagerC == null) {
                return sp;
            }
            try {
                sp = telephonyManagerC.getSimOperator();
            } catch (Throwable unused) {
            }
            rl = true;
            return sp;
        }
    }

    public static String c(Boolean bool, com.byazt.dna.c cVar, Context context) {
        if (!TextUtils.isEmpty(tt)) {
            return tt;
        }
        com.byazt.lz.c customController = cVar.getCustomController();
        if (bool == null) {
            return c(customController, customController != null && customController.isCanUsePhoneState(), context);
        }
        if (m) {
            return tt;
        }
        return c(customController, bool.booleanValue(), context);
    }

    private static String tt(com.byazt.dna.c cVar, boolean z2, int i2, com.byazt.lz.ve veVar) {
        if (zm) {
            return z;
        }
        synchronized (ve.class) {
            if (zm) {
                return z;
            }
            z = ve(cVar, z2, i2, veVar);
            zm = true;
            return z;
        }
    }

    private static String c(com.byazt.lz.c cVar, boolean z2, Context context) {
        if (cVar != null && !z2) {
            String devImei = cVar.getDevImei();
            tt = devImei;
            return devImei;
        }
        if (m) {
            return tt;
        }
        n(context);
        return tt;
    }

    public static String c(com.byazt.dna.c cVar) {
        com.byazt.lz.c customController = cVar.getCustomController();
        if (customController != null && !customController.isCanUsePhoneState()) {
            return null;
        }
        if (!TextUtils.isEmpty(yp)) {
            return yp;
        }
        if (gr) {
            return yp;
        }
        synchronized (ve.class) {
            if (gr) {
                return yp;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    yp = Build.getSerial();
                } catch (Throwable unused) {
                }
            } else {
                yp = Build.SERIAL;
            }
            gr = true;
            return yp;
        }
    }

    private static void c(com.byazt.dna.c cVar, boolean z2, int i2, com.byazt.lz.ve veVar) {
        String strC = tt.c(cVar, z2, i2, veVar);
        if (TextUtils.isEmpty(strC)) {
            strC = "DU:MM:YA:DD:RE:SS";
        }
        x.c("mac_address", strC, cVar, i2);
        x.c("new_mac_address", ((com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service")).encryptAESWithCBC(strC), cVar, i2);
        z = strC;
    }

    public static String c(Boolean bool, com.byazt.dna.c cVar, boolean z2, int i2, com.byazt.lz.ve veVar) {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        com.byazt.lz.c customController = cVar.getCustomController();
        if (bool == null) {
            if (customController != null && !customController.isCanUseWifiState()) {
                return customController.getMacAddress();
            }
        } else {
            if (zm) {
                return z;
            }
            if (customController != null && !bool.booleanValue()) {
                return customController.getMacAddress();
            }
        }
        return tt(cVar, z2, i2, veVar);
    }

    private static boolean c(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static String c(Context context, com.byazt.dna.c cVar) {
        TelephonyManager telephonyManagerC;
        try {
            com.byazt.lz.c customController = cVar.getCustomController();
            if ((customController == null || customController.isCanUsePhoneState()) && (telephonyManagerC = c(context)) != null) {
                return telephonyManagerC.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSimOperator();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
