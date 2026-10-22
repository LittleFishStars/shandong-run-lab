package com.ipd.dsp.internal.c2;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.DspCustomController;
import com.kc.openset.constant.DeviceIdType;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.WebSettings;
import com.zj.adlib.c49;
import com.zj.adlib.nl0;
import com.zj.adlib.xh9;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DspCustomController f38224a;
    public final HashMap<String, Object> b;
    public String c;
    public String d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f38225a = new g();
    }

    public static g a() {
        return b.f38225a;
    }

    public final int A() {
        int i;
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 != null) {
                try {
                    i = Integer.parseInt(property2);
                } catch (NumberFormatException unused) {
                    i = -1;
                }
            } else {
                i = -1;
            }
            return (TextUtils.isEmpty(property) || i == -1) ? 2 : 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public final int B() {
        return a(com.ipd.dsp.internal.l1.a.a().getContext());
    }

    public final int C() {
        Context context = Dsp.getContext();
        if (context == null) {
            return 1;
        }
        try {
            return context.getResources().getConfiguration().orientation == 2 ? 2 : 1;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public final int D() {
        Context context = Dsp.getContext();
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @SuppressLint({"HardwareIds"})
    public final String E() {
        DspCustomController dspCustomController;
        if (Dsp.getContext() == null || !((dspCustomController = this.f38224a) == null || dspCustomController.canUsePhoneState())) {
            return "";
        }
        try {
            String str = Build.SERIAL;
            return !"unknown".equalsIgnoreCase(str) ? str : "";
        } catch (Throwable unused) {
        }
    }

    public final String F() {
        String simOperator;
        Context context = Dsp.getContext();
        if (context == null) {
            return "0-null";
        }
        DspCustomController dspCustomController = this.f38224a;
        if (dspCustomController != null && !dspCustomController.canUseSimOperator()) {
            simOperator = this.f38224a.getSimOperatorCode();
            if (TextUtils.isEmpty(simOperator)) {
                return "0";
            }
        } else if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                simOperator = (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) ? telephonyManager.getSimOperator() : telephonyManager.getNetworkOperator();
            } catch (Throwable th) {
                r.a(th);
                simOperator = "";
            }
        } else {
            simOperator = "";
        }
        int iHashCode = simOperator.hashCode();
        if (iHashCode == 49679502) {
            return simOperator.equals("46011") ? "2" : "4";
        }
        if (iHashCode == 49679532) {
            simOperator.equals("46020");
            return "4";
        }
        switch (iHashCode) {
            case 49679470:
                return simOperator.equals("46000") ? "1" : "4";
            case 49679471:
                return simOperator.equals("46001") ? "3" : "4";
            case 49679472:
                return simOperator.equals("46002") ? "1" : "4";
            case 49679473:
                return simOperator.equals("46003") ? "2" : "4";
            case 49679474:
                return simOperator.equals("46004") ? "1" : "4";
            case 49679475:
                return simOperator.equals("46005") ? "2" : "4";
            case 49679476:
                return simOperator.equals("46006") ? "3" : "4";
            case 49679477:
                return simOperator.equals("46007") ? "1" : "4";
            case 49679478:
                return simOperator.equals("46008") ? "1" : "4";
            case 49679479:
                return simOperator.equals("46009") ? "3" : "4";
            default:
                return "4";
        }
    }

    public String G() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = I();
        }
        return o.b(this.d);
    }

    public final String H() {
        try {
            StructStat structStatStat = Os.stat("/data/data");
            if (Build.VERSION.SDK_INT >= 27) {
                StructTimespec structTimespec = structStatStat.st_atim;
                return structTimespec.tv_sec + Consts.DOT + structTimespec.tv_nsec;
            }
            return structStatStat.st_atime + Consts.DOT + new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10) + "000000";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String I() {
        Context context = com.ipd.dsp.internal.l1.a.a().getContext();
        if (context == null) {
            return "";
        }
        if (q.a()) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (Throwable unused) {
            }
        }
        try {
            return android.webkit.WebSettings.getDefaultUserAgent(context);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public final int J() {
        try {
            Context context = Dsp.getContext();
            if (context != null) {
                try {
                    Object objInvoke = WXAPIFactory.class.getDeclaredMethod("createWXAPI", Context.class, String.class).invoke(null, context, "");
                    if ((objInvoke instanceof IWXAPI) && ((IWXAPI) objInvoke).isWXAppInstalled()) {
                        return !TextUtils.isEmpty(com.ipd.dsp.internal.l1.a.a().getWxOpenId()) ? 4 : 3;
                    }
                } catch (Throwable unused) {
                }
            }
            return 2;
        } catch (Throwable unused2) {
            return 1;
        }
    }

    public int K() {
        if (!this.b.isEmpty()) {
            Object obj = this.b.get("wx_open_sdk");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return J();
    }

    public final void L() {
        JSONObject jSONObject;
        boolean z;
        String str;
        String string;
        DspCustomController dspCustomController = this.f38224a;
        int iA = 1;
        boolean z2 = dspCustomController == null || dspCustomController.canReadInstalledPackages();
        DspCustomController dspCustomController2 = this.f38224a;
        List<Integer> listAvailablePackageIds = dspCustomController2 == null ? null : dspCustomController2.availablePackageIds();
        String strA = d.c.a();
        if (TextUtils.isEmpty(strA)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(strA);
                try {
                    z = System.currentTimeMillis() - jSONObject.optLong("a") > 57600000;
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                jSONObject = null;
            }
        }
        String string2 = "";
        try {
            try {
                if (z) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("a", System.currentTimeMillis());
                    iA = com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.f38215a, z2, listAvailablePackageIds);
                    jSONObject2.put("b", iA);
                    string = a(iA, z2, listAvailablePackageIds).toString();
                    jSONObject2.put("c", string);
                    DspCustomController dspCustomController3 = this.f38224a;
                    string2 = a(z2, dspCustomController3 != null ? dspCustomController3.getInstalledPackages() : null).toString();
                    jSONObject2.put("d", string2);
                    d.c.a(jSONObject2.toString());
                } else {
                    iA = jSONObject.getInt("b");
                    string = jSONObject.getString("c");
                    string2 = jSONObject.getString("d");
                }
            } catch (Throwable th) {
                th = th;
                str = "";
                string2 = listAvailablePackageIds;
                r.a(th);
                string = string2;
                string2 = str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = string2;
            r.a(th);
            string = string2;
            string2 = str;
        }
        this.b.put("alipay_status", Integer.valueOf(iA));
        this.b.put("device_app_list", string);
        this.b.put("device_all_app_list", string2);
    }

    public final int M() {
        Context context = com.ipd.dsp.internal.l1.a.a().getContext();
        if (context != null) {
            return (context.getApplicationInfo().flags & 2) != 0 ? 1 : 2;
        }
        return 0;
    }

    public final int N() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/", "/system/sbin/", "/usr/bin/", "/vendor/bin/"};
        for (int i = 0; i < 11; i++) {
            if (new File(strArr[i] + "su").exists()) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public String O() {
        String str;
        if (this.b.isEmpty()) {
            str = null;
        } else {
            Object obj = this.b.get("package_name");
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
        }
        return str == null ? "" : str;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00db A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void b(DspCustomController dspCustomController) {
        JSONObject jSONObject;
        String strB;
        String strT;
        String str;
        Throwable th;
        String str2;
        String strQ;
        DspCustomController dspCustomController2 = this.f38224a;
        boolean z = dspCustomController2 == null || dspCustomController2.canReadInstalledPackages();
        this.f38224a = dspCustomController;
        boolean z2 = dspCustomController == null || dspCustomController.canReadInstalledPackages();
        List<Integer> listAvailablePackageIds = dspCustomController == null ? null : dspCustomController.availablePackageIds();
        String strA = d.a.a();
        if (o.c(strA)) {
            try {
                jSONObject = new JSONObject(strA);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        String strR = "";
        String strF = "0";
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th2) {
                strB = "";
                strT = strB;
                str = "0";
                th = th2;
                str2 = strT;
                r.a(th);
                strQ = strR;
                strR = str2;
                strF = str;
                this.b.put("imei_o", o.d(strQ));
                this.b.put("android_id_o", o.d(strB));
                this.b.put("operator", strF);
                this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                this.b.put("mac_o", o.d(strT));
                this.b.put("imsi_o", o.d(strR));
                if (z) {
                    return;
                } else {
                    return;
                }
            }
        }
        jSONObject.put("a", System.currentTimeMillis());
        strQ = q();
        try {
            jSONObject.put("b", strQ);
            strB = b();
            try {
                jSONObject.put("d", strB);
                strF = F();
                jSONObject.put("i", strF);
                strT = t();
                try {
                    jSONObject.put("q", strT);
                    strR = r();
                    jSONObject.put("s", strR);
                    d.a.a(jSONObject.toString());
                } catch (Throwable th3) {
                    str = strF;
                    th = th3;
                    str2 = strR;
                    strR = strQ;
                    r.a(th);
                    strQ = strR;
                    strR = str2;
                    strF = str;
                }
            } catch (Throwable th4) {
                th = th4;
                strT = "";
                str = strF;
                th = th;
                strR = strQ;
                str2 = strT;
                r.a(th);
                strQ = strR;
                strR = str2;
                strF = str;
                this.b.put("imei_o", o.d(strQ));
                this.b.put("android_id_o", o.d(strB));
                this.b.put("operator", strF);
                this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                this.b.put("mac_o", o.d(strT));
                this.b.put("imsi_o", o.d(strR));
                if (z) {
                    return;
                } else {
                    return;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            strB = "";
            strT = strB;
        }
        try {
            this.b.put("imei_o", o.d(strQ));
            this.b.put("android_id_o", o.d(strB));
            this.b.put("operator", strF);
            this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
            this.b.put("mac_o", o.d(strT));
            this.b.put("imsi_o", o.d(strR));
            if (z || !z2) {
                return;
            }
            int iA = com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.f38215a, true, listAvailablePackageIds);
            this.b.put("alipay_status", Integer.valueOf(iA));
            this.b.put("device_app_list", a(iA, true, listAvailablePackageIds).toString());
            this.b.put("device_all_app_list", a(true, dspCustomController != null ? dspCustomController.getInstalledPackages() : null).toString());
        } catch (Throwable th6) {
            r.a(th6);
        }
    }

    public final String c() {
        Context context = com.ipd.dsp.internal.l1.a.a().getContext();
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo("com.huawei.appmarket", 0).versionCode);
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String d() {
        Context context = Dsp.getContext();
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo;
            String string = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()).toString() : null;
            if (TextUtils.isEmpty(string)) {
                string = "def";
            }
            return URLEncoder.encode(string, "utf-8");
        } catch (Throwable th) {
            r.a(th);
            return "";
        }
    }

    public final Pair<String, Integer> e() {
        Context context = Dsp.getContext();
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return new Pair<>(packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return new Pair<>("", 0);
    }

    public final Pair<Integer, Integer> f() {
        Context context = com.ipd.dsp.internal.l1.a.a().getContext();
        if (context != null) {
            try {
                Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver != null) {
                    return new Pair<>(Integer.valueOf(intentRegisterReceiver.getIntExtra("status", -1)), Integer.valueOf(intentRegisterReceiver.getIntExtra(com.alibaba.ariver.permission.b.b, 0)));
                }
            } catch (Throwable unused) {
            }
        }
        return new Pair<>(1, 0);
    }

    public final String g() {
        DspCustomController dspCustomController = this.f38224a;
        String str = "";
        if (dspCustomController != null && !dspCustomController.canUseBootId()) {
            return "";
        }
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            String strTrim = new BufferedReader(new InputStreamReader(fileInputStream2)).readLine().trim();
                            try {
                                strTrim = strTrim.substring(0, 36);
                            } catch (Throwable unused) {
                            }
                            str = strTrim;
                            fileInputStream2.close();
                        } catch (IOException unused2) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return str;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    r.a(e);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        r.a(e2);
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable unused4) {
        }
        return str;
    }

    public Map<String, Object> h() {
        HashMap map = new HashMap();
        if (!this.b.containsKey("alipay_status")) {
            L();
        }
        if (!this.b.isEmpty()) {
            map.putAll(this.b);
            map.put("oaid_o", o.d(w()));
            map.put("network_type", Integer.valueOf(u()));
            map.put("proxy_status", Integer.valueOf(A()));
            Pair<Integer, Integer> pairF = f();
            map.put("battery_state", pairF.first);
            map.put("battery", pairF.second);
        }
        return map;
    }

    @Nullable
    public DspCustomController i() {
        return this.f38224a;
    }

    public final String j() {
        try {
            Context context = Dsp.getContext();
            return context != null ? Settings.Secure.getString(context.getContentResolver(), "bluetooth_name") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String k() {
        Context context = Dsp.getContext();
        if (context != null) {
            DspCustomController dspCustomController = this.f38224a;
            if (dspCustomController != null && !dspCustomController.canUsePhoneState()) {
                return "";
            }
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return String.valueOf(memoryInfo.totalMem);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public final String l() {
        if (Dsp.getContext() != null) {
            DspCustomController dspCustomController = this.f38224a;
            if (dspCustomController != null && !dspCustomController.canUsePhoneState()) {
                return "";
            }
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return String.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public final int m() {
        Context context = Dsp.getContext();
        if (context != null) {
            try {
                if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                    return 2;
                }
            } catch (Throwable unused) {
            }
        }
        return 1;
    }

    public final Pair<String, String> n() {
        Context context = Dsp.getContext();
        if (context != null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return new Pair<>(String.valueOf(displayMetrics.densityDpi), String.valueOf(displayMetrics.density));
            } catch (Throwable unused) {
            }
        }
        return new Pair<>("", "");
    }

    public final String o() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object objInvoke = cls.getMethod("getOsBrand", null).invoke(cls, null);
            if (objInvoke != null && "Harmony".equalsIgnoreCase(objInvoke.toString())) {
                return p.a(com.alipay.sdk.m.d.a.b);
            }
        } catch (Throwable unused) {
        }
        Context context = Dsp.getContext();
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionCode);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public final String p() {
        Context context = Dsp.getContext();
        if (context == null) {
            return "";
        }
        int iU = u();
        if (iU == 1) {
            try {
                DspCustomController dspCustomController = this.f38224a;
                if (dspCustomController == null || dspCustomController.canUseNetworkState()) {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    return wifiManager != null ? a(wifiManager.getConnectionInfo().getIpAddress()) : "";
                }
            } catch (Throwable unused) {
                return "";
            }
        }
        if (iU != 2) {
            return "";
        }
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                    return inetAddressNextElement.getHostAddress();
                }
            }
        }
        return "";
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public final String q() {
        Context context;
        DspCustomController dspCustomController = this.f38224a;
        if (dspCustomController == null || dspCustomController.canUsePhoneState()) {
            if (Build.VERSION.SDK_INT < 29 && (context = Dsp.getContext()) != null && ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                try {
                    String deviceId = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getDeviceId();
                    if (!TextUtils.isEmpty(deviceId)) {
                        return deviceId;
                    }
                } catch (Throwable unused) {
                }
            }
            return "";
        }
        String imei = this.f38224a.getImei();
        if (TextUtils.isEmpty(imei)) {
            String[] imeis = this.f38224a.getImeis();
            if (imeis == null) {
                return "";
            }
            for (String str : imeis) {
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return imei;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public final String r() {
        Context context;
        DspCustomController dspCustomController = this.f38224a;
        if ((dspCustomController == null || dspCustomController.canUsePhoneState()) && Build.VERSION.SDK_INT < 29 && (context = Dsp.getContext()) != null && ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
            try {
                String subscriberId = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSubscriberId();
                if (!TextUtils.isEmpty(subscriberId)) {
                    return subscriberId;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public final String s() {
        Context context = Dsp.getContext();
        if (context == null) {
            return "0.0000,0.0000";
        }
        DspCustomController dspCustomController = this.f38224a;
        if (dspCustomController != null && !dspCustomController.canReadLocation()) {
            Pair<Double, Double> locationPair = this.f38224a.getLocationPair();
            if (locationPair == null) {
                return "0.0000,0.0000";
            }
            try {
                return locationPair.first + "," + locationPair.second;
            } catch (Throwable th) {
                r.a(th);
                return "0.0000,0.0000";
            }
        }
        try {
            boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
            boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
            if (!z && !z2) {
                return "0.0000,0.0000";
            }
            LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            Iterator<String> it = locationManager.getProviders(true).iterator();
            while (it.hasNext()) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
                if (lastKnownLocation != null) {
                    return lastKnownLocation.getLongitude() + "," + lastKnownLocation.getLatitude();
                }
            }
            return "0.0000,0.0000";
        } catch (Throwable th2) {
            r.a(th2);
            return "0.0000,0.0000";
        }
    }

    public final String t() {
        byte[] hardwareAddress;
        Context context = Dsp.getContext();
        DspCustomController dspCustomController = this.f38224a;
        if (dspCustomController != null && !dspCustomController.canUseMacAddress()) {
            String macAddress = this.f38224a.getMacAddress();
            return macAddress == null ? "" : macAddress;
        }
        if (context != null && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.d) == 0) {
            try {
                ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
                int size = list.size();
                int i = 0;
                while (i < size) {
                    Object obj = list.get(i);
                    i++;
                    NetworkInterface networkInterface = (NetworkInterface) obj;
                    if ("wlan0".equalsIgnoreCase(networkInterface.getName()) && (hardwareAddress = networkInterface.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b2)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public final int u() {
        DspCustomController dspCustomController;
        NetworkInfo activeNetworkInfo;
        Context context = Dsp.getContext();
        if (context != null && (((dspCustomController = this.f38224a) == null || dspCustomController.canUseNetworkState()) && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0)) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo == null) {
                        return 2;
                    }
                    NetworkInfo.State state = networkInfo.getState();
                    return (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) ? 1 : 2;
                }
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return 0;
    }

    public String v() {
        return !this.b.isEmpty() ? o.a((String) this.b.get("oaid_o")) : w();
    }

    public final String w() {
        if (Dsp.getContext() != null) {
            String strA = m.a("IPD_SHARED", DeviceIdType.OAID, "");
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
            String strA2 = m.a("ZJ_SHARED", DeviceIdType.OAID, "", false);
            if (!TextUtils.isEmpty(strA2)) {
                return strA2;
            }
        }
        return !TextUtils.isEmpty(this.c) ? this.c : "";
    }

    public final String x() {
        Context context = Dsp.getContext();
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("IPD_SHARED", 0);
        String strA = m.a(sharedPreferences, "uuid", "", true);
        if (TextUtils.isEmpty(strA)) {
            strA = m.a("ZJ_SHARED", "uuid", "", false);
            if (TextUtils.isEmpty(strA)) {
                strA = UUID.randomUUID().toString().replace(c49.f40900a, "").toLowerCase();
                m.a(sharedPreferences, "uuid", strA);
            }
        }
        return o.d(strA);
    }

    public String y() {
        return !this.b.isEmpty() ? (String) this.b.get("uuid_o") : x();
    }

    public final String z() {
        Context context = Dsp.getContext();
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Throwable th) {
            r.a(th);
            return "";
        }
    }

    public g() {
        this.b = new HashMap<>();
        this.f38224a = null;
    }

    public boolean a(String str) {
        DspCustomController dspCustomController = this.f38224a;
        if (dspCustomController != null && !dspCustomController.canReadInstalledPackages()) {
            List<String> installedPackages = this.f38224a.getInstalledPackages();
            if (installedPackages != null) {
                return installedPackages.contains(str);
            }
            return false;
        }
        Context context = Dsp.getContext();
        if (context == null) {
            return false;
        }
        try {
            return o.c(context.getPackageManager().getApplicationInfo(str, 8192).packageName);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(DspCustomController dspCustomController) {
        JSONObject jSONObject;
        boolean z;
        Throwable th;
        String strOptString;
        String strOptString2;
        String strB;
        String strZ;
        String str;
        String str2;
        String strOptString3;
        String strOptString4;
        String strOptString5;
        String strOptString6;
        String strOptString7;
        String strOptString8;
        int i;
        int iOptInt;
        int iOptInt2;
        int iB;
        int iM;
        int i2;
        int i3;
        String str3;
        String str4;
        String strQ;
        String str5;
        int iD;
        this.f38224a = dspCustomController;
        this.b.clear();
        String strA = d.a.a();
        if (TextUtils.isEmpty(strA)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(strA);
                try {
                    z = System.currentTimeMillis() - jSONObject.optLong("a") > 259200000;
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                jSONObject = null;
            }
        }
        JSONObject jSONObject2 = jSONObject;
        String strOptString9 = "";
        String strOptString10 = "0";
        try {
            if (z) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("a", System.currentTimeMillis());
                strQ = q();
                try {
                    jSONObject3.put("b", strQ);
                    strZ = z();
                    try {
                        jSONObject3.put("c", strZ);
                        strB = b();
                        try {
                            jSONObject3.put("d", strB);
                            iM = m();
                            try {
                                jSONObject3.put("e", iM);
                                iOptInt = C();
                                try {
                                    jSONObject3.put("f", iOptInt);
                                    iD = D();
                                    try {
                                        jSONObject3.put(y6b.f, iD);
                                        iB = B();
                                        try {
                                            jSONObject3.put(y6b.g, iB);
                                            strOptString10 = F();
                                            try {
                                                jSONObject3.put("i", strOptString10);
                                                strOptString = d();
                                                try {
                                                    jSONObject3.put("j", strOptString);
                                                    strOptString7 = k();
                                                    try {
                                                        jSONObject3.put("k", strOptString7);
                                                        strOptString8 = l();
                                                        try {
                                                            jSONObject3.put(com.kuaishou.weapon.p0.t.d, strOptString8);
                                                            Pair<String, String> pairN = n();
                                                            strOptString4 = (String) pairN.first;
                                                            try {
                                                                jSONObject3.put("m", strOptString4);
                                                                str2 = (String) pairN.second;
                                                                try {
                                                                    jSONObject3.put("n", str2);
                                                                    strOptString3 = o();
                                                                    try {
                                                                        jSONObject3.put(com.google.android.exoplayer2.source.rtsp.j.b, strOptString3);
                                                                        strOptString5 = c();
                                                                        iOptInt = iOptInt;
                                                                        try {
                                                                            jSONObject3.put("p", strOptString5);
                                                                            String strT = t();
                                                                            strQ = strQ;
                                                                            try {
                                                                                jSONObject3.put("q", strT);
                                                                                String strE = E();
                                                                                strOptString7 = strOptString7;
                                                                                try {
                                                                                    jSONObject3.put("r", strE);
                                                                                    strOptString6 = strT;
                                                                                    try {
                                                                                        String strR = r();
                                                                                        try {
                                                                                            jSONObject3.put("s", strR);
                                                                                            strOptString10 = strR;
                                                                                            try {
                                                                                                int iN = N();
                                                                                                try {
                                                                                                    jSONObject3.put("t", iN);
                                                                                                    i2 = iN;
                                                                                                    try {
                                                                                                        String strJ = j();
                                                                                                        try {
                                                                                                            jSONObject3.put("u", strJ);
                                                                                                            strOptString9 = strJ;
                                                                                                            int iM2 = M();
                                                                                                            try {
                                                                                                                jSONObject3.put("v", iM2);
                                                                                                                i3 = iM2;
                                                                                                                try {
                                                                                                                    String strI = I();
                                                                                                                    strOptString8 = strOptString8;
                                                                                                                    try {
                                                                                                                        this.d = strI;
                                                                                                                        jSONObject3.put("w", strI);
                                                                                                                        d.a.a(jSONObject3.toString());
                                                                                                                        str4 = strOptString5;
                                                                                                                        iOptInt = iOptInt;
                                                                                                                        str5 = strOptString7;
                                                                                                                        str3 = strE;
                                                                                                                        this = this;
                                                                                                                        strOptString3 = strOptString3;
                                                                                                                        strOptString8 = strOptString8;
                                                                                                                        strOptString10 = strOptString10;
                                                                                                                    } catch (Throwable th2) {
                                                                                                                        iOptInt = iOptInt;
                                                                                                                        str = strOptString9;
                                                                                                                        th = th2;
                                                                                                                        strOptString9 = strQ;
                                                                                                                        i = i3;
                                                                                                                        iOptInt2 = iD;
                                                                                                                        strOptString = strOptString;
                                                                                                                        strOptString2 = strE;
                                                                                                                        this = this;
                                                                                                                        strOptString10 = strOptString10;
                                                                                                                        r.a(th);
                                                                                                                        i3 = i;
                                                                                                                        str3 = strOptString2;
                                                                                                                        str4 = strOptString5;
                                                                                                                        strQ = strOptString9;
                                                                                                                        strOptString9 = str;
                                                                                                                        strOptString3 = strOptString3;
                                                                                                                        str5 = strOptString7;
                                                                                                                        strOptString8 = strOptString8;
                                                                                                                        int i4 = iOptInt2;
                                                                                                                        strOptString = strOptString;
                                                                                                                        iD = i4;
                                                                                                                    }
                                                                                                                } catch (Throwable th3) {
                                                                                                                    th = th3;
                                                                                                                    strOptString8 = strOptString8;
                                                                                                                    strOptString10 = strOptString10;
                                                                                                                    iOptInt = iOptInt;
                                                                                                                    str = strOptString9;
                                                                                                                    th = th;
                                                                                                                    strOptString2 = strE;
                                                                                                                    strOptString9 = strQ;
                                                                                                                    this = this;
                                                                                                                    i = i3;
                                                                                                                    iOptInt2 = iD;
                                                                                                                    strOptString = strOptString;
                                                                                                                    r.a(th);
                                                                                                                    i3 = i;
                                                                                                                    str3 = strOptString2;
                                                                                                                    str4 = strOptString5;
                                                                                                                    strQ = strOptString9;
                                                                                                                    strOptString9 = str;
                                                                                                                    strOptString3 = strOptString3;
                                                                                                                    str5 = strOptString7;
                                                                                                                    strOptString8 = strOptString8;
                                                                                                                    int i5 = iOptInt2;
                                                                                                                    strOptString = strOptString;
                                                                                                                    iD = i5;
                                                                                                                    String str6 = str4;
                                                                                                                    this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                                                                    this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                                                                    this.b.put("imei_o", o.d(strQ));
                                                                                                                    this.b.put("uuid_o", x());
                                                                                                                    this.b.put("brand", Build.BRAND);
                                                                                                                    this.b.put(ze1.k, Build.MODEL);
                                                                                                                    this.b.put("package_name", strZ);
                                                                                                                    this.b.put("osv", Build.VERSION.RELEASE);
                                                                                                                    this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                                                                    this.b.put("android_id_o", o.d(strB));
                                                                                                                    this.b.put("device_type", Integer.valueOf(iM));
                                                                                                                    this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                                                                    this.b.put("width", Integer.valueOf(iD));
                                                                                                                    this.b.put("height", Integer.valueOf(iB));
                                                                                                                    this.b.put("operator", strOptString10);
                                                                                                                    this.b.put("app_name", strOptString);
                                                                                                                    this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                                                                    Pair<String, Integer> pairE = e();
                                                                                                                    this.b.put("app_ver_name", pairE.first);
                                                                                                                    this.b.put("app_ver_code", pairE.second);
                                                                                                                    this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                                                                    this.b.put("ip_address_o", o.d(p()));
                                                                                                                    this.b.put("physical_memory_byte", str5);
                                                                                                                    this.b.put("hard_disk_size_byte", strOptString8);
                                                                                                                    this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                                                                    this.b.put("dpi", strOptString4);
                                                                                                                    this.b.put("ppi", str2);
                                                                                                                    this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                                                                    this.b.put("boot_mark", g());
                                                                                                                    this.b.put("update_mark", H());
                                                                                                                    this.b.put("foreground_background", 1);
                                                                                                                    this.b.put("hms_core", strOptString3);
                                                                                                                    this.b.put("ag_ver", str6);
                                                                                                                    this.b.put("mac_o", o.d(strOptString6));
                                                                                                                    this.b.put("serial_o", o.d(str3));
                                                                                                                    this.b.put("imsi_o", o.d(strOptString10));
                                                                                                                    this.b.put("device_is_root", Integer.valueOf(i2));
                                                                                                                    this.b.put("device_name_o", o.d(strOptString9));
                                                                                                                    this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                                                                    this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                                                                    this.b.put(ze1.p, Build.MANUFACTURER);
                                                                                                                    this.b.put("vendor", Build.PRODUCT);
                                                                                                                    this.b.put("device", Build.DEVICE);
                                                                                                                    this.b.put("board", Build.BOARD);
                                                                                                                    this.b.put(ze1.l, Build.HARDWARE);
                                                                                                                    this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                                                                    this.b.put("x5_sdk_ver", q.b());
                                                                                                                    this.b.put("x5_ver", q.a(null));
                                                                                                                    this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                                                                }
                                                                                                            } catch (Throwable th4) {
                                                                                                                th = th4;
                                                                                                                i3 = iM2;
                                                                                                            }
                                                                                                        } catch (Throwable th5) {
                                                                                                            th = th5;
                                                                                                            strOptString9 = strJ;
                                                                                                            strOptString8 = strOptString8;
                                                                                                            strOptString10 = strOptString10;
                                                                                                            iOptInt = iOptInt;
                                                                                                            str = strOptString9;
                                                                                                            th = th;
                                                                                                            strOptString2 = strE;
                                                                                                            strOptString9 = strQ;
                                                                                                            i = 0;
                                                                                                            this = this;
                                                                                                            iOptInt2 = iD;
                                                                                                            strOptString = strOptString;
                                                                                                            r.a(th);
                                                                                                            i3 = i;
                                                                                                            str3 = strOptString2;
                                                                                                            str4 = strOptString5;
                                                                                                            strQ = strOptString9;
                                                                                                            strOptString9 = str;
                                                                                                            strOptString3 = strOptString3;
                                                                                                            str5 = strOptString7;
                                                                                                            strOptString8 = strOptString8;
                                                                                                            int i6 = iOptInt2;
                                                                                                            strOptString = strOptString;
                                                                                                            iD = i6;
                                                                                                            String str7 = str4;
                                                                                                            this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                                                            this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                                                            this.b.put("imei_o", o.d(strQ));
                                                                                                            this.b.put("uuid_o", x());
                                                                                                            this.b.put("brand", Build.BRAND);
                                                                                                            this.b.put(ze1.k, Build.MODEL);
                                                                                                            this.b.put("package_name", strZ);
                                                                                                            this.b.put("osv", Build.VERSION.RELEASE);
                                                                                                            this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                                                            this.b.put("android_id_o", o.d(strB));
                                                                                                            this.b.put("device_type", Integer.valueOf(iM));
                                                                                                            this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                                                            this.b.put("width", Integer.valueOf(iD));
                                                                                                            this.b.put("height", Integer.valueOf(iB));
                                                                                                            this.b.put("operator", strOptString10);
                                                                                                            this.b.put("app_name", strOptString);
                                                                                                            this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                                                            Pair<String, Integer> pairE2 = e();
                                                                                                            this.b.put("app_ver_name", pairE2.first);
                                                                                                            this.b.put("app_ver_code", pairE2.second);
                                                                                                            this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                                                            this.b.put("ip_address_o", o.d(p()));
                                                                                                            this.b.put("physical_memory_byte", str5);
                                                                                                            this.b.put("hard_disk_size_byte", strOptString8);
                                                                                                            this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                                                            this.b.put("dpi", strOptString4);
                                                                                                            this.b.put("ppi", str2);
                                                                                                            this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                                                            this.b.put("boot_mark", g());
                                                                                                            this.b.put("update_mark", H());
                                                                                                            this.b.put("foreground_background", 1);
                                                                                                            this.b.put("hms_core", strOptString3);
                                                                                                            this.b.put("ag_ver", str7);
                                                                                                            this.b.put("mac_o", o.d(strOptString6));
                                                                                                            this.b.put("serial_o", o.d(str3));
                                                                                                            this.b.put("imsi_o", o.d(strOptString10));
                                                                                                            this.b.put("device_is_root", Integer.valueOf(i2));
                                                                                                            this.b.put("device_name_o", o.d(strOptString9));
                                                                                                            this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                                                            this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                                                            this.b.put(ze1.p, Build.MANUFACTURER);
                                                                                                            this.b.put("vendor", Build.PRODUCT);
                                                                                                            this.b.put("device", Build.DEVICE);
                                                                                                            this.b.put("board", Build.BOARD);
                                                                                                            this.b.put(ze1.l, Build.HARDWARE);
                                                                                                            this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                                                            this.b.put("x5_sdk_ver", q.b());
                                                                                                            this.b.put("x5_ver", q.a(null));
                                                                                                            this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                                                        }
                                                                                                    } catch (Throwable th6) {
                                                                                                        th = th6;
                                                                                                    }
                                                                                                } catch (Throwable th7) {
                                                                                                    th = th7;
                                                                                                    i2 = iN;
                                                                                                }
                                                                                            } catch (Throwable th8) {
                                                                                                th = th8;
                                                                                                str = "";
                                                                                                i2 = 0;
                                                                                                th = th;
                                                                                                strOptString2 = strE;
                                                                                                strOptString9 = strQ;
                                                                                                i = 0;
                                                                                                this = this;
                                                                                                iOptInt2 = iD;
                                                                                                strOptString = strOptString;
                                                                                                r.a(th);
                                                                                                i3 = i;
                                                                                                str3 = strOptString2;
                                                                                                str4 = strOptString5;
                                                                                                strQ = strOptString9;
                                                                                                strOptString9 = str;
                                                                                                strOptString3 = strOptString3;
                                                                                                str5 = strOptString7;
                                                                                                strOptString8 = strOptString8;
                                                                                                int i7 = iOptInt2;
                                                                                                strOptString = strOptString;
                                                                                                iD = i7;
                                                                                                String str8 = str4;
                                                                                                this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                                                this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                                                this.b.put("imei_o", o.d(strQ));
                                                                                                this.b.put("uuid_o", x());
                                                                                                this.b.put("brand", Build.BRAND);
                                                                                                this.b.put(ze1.k, Build.MODEL);
                                                                                                this.b.put("package_name", strZ);
                                                                                                this.b.put("osv", Build.VERSION.RELEASE);
                                                                                                this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                                                this.b.put("android_id_o", o.d(strB));
                                                                                                this.b.put("device_type", Integer.valueOf(iM));
                                                                                                this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                                                this.b.put("width", Integer.valueOf(iD));
                                                                                                this.b.put("height", Integer.valueOf(iB));
                                                                                                this.b.put("operator", strOptString10);
                                                                                                this.b.put("app_name", strOptString);
                                                                                                this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                                                Pair<String, Integer> pairE3 = e();
                                                                                                this.b.put("app_ver_name", pairE3.first);
                                                                                                this.b.put("app_ver_code", pairE3.second);
                                                                                                this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                                                this.b.put("ip_address_o", o.d(p()));
                                                                                                this.b.put("physical_memory_byte", str5);
                                                                                                this.b.put("hard_disk_size_byte", strOptString8);
                                                                                                this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                                                this.b.put("dpi", strOptString4);
                                                                                                this.b.put("ppi", str2);
                                                                                                this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                                                this.b.put("boot_mark", g());
                                                                                                this.b.put("update_mark", H());
                                                                                                this.b.put("foreground_background", 1);
                                                                                                this.b.put("hms_core", strOptString3);
                                                                                                this.b.put("ag_ver", str8);
                                                                                                this.b.put("mac_o", o.d(strOptString6));
                                                                                                this.b.put("serial_o", o.d(str3));
                                                                                                this.b.put("imsi_o", o.d(strOptString10));
                                                                                                this.b.put("device_is_root", Integer.valueOf(i2));
                                                                                                this.b.put("device_name_o", o.d(strOptString9));
                                                                                                this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                                                this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                                                this.b.put(ze1.p, Build.MANUFACTURER);
                                                                                                this.b.put("vendor", Build.PRODUCT);
                                                                                                this.b.put("device", Build.DEVICE);
                                                                                                this.b.put("board", Build.BOARD);
                                                                                                this.b.put(ze1.l, Build.HARDWARE);
                                                                                                this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                                                this.b.put("x5_sdk_ver", q.b());
                                                                                                this.b.put("x5_ver", q.a(null));
                                                                                                this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                                            }
                                                                                        } catch (Throwable th9) {
                                                                                            th = th9;
                                                                                            strOptString10 = strR;
                                                                                        }
                                                                                    } catch (Throwable th10) {
                                                                                        th = th10;
                                                                                        str = "";
                                                                                        strOptString10 = str;
                                                                                        i2 = 0;
                                                                                        th = th;
                                                                                        strOptString2 = strE;
                                                                                        strOptString9 = strQ;
                                                                                        i = 0;
                                                                                        this = this;
                                                                                        iOptInt2 = iD;
                                                                                        strOptString = strOptString;
                                                                                        r.a(th);
                                                                                        i3 = i;
                                                                                        str3 = strOptString2;
                                                                                        str4 = strOptString5;
                                                                                        strQ = strOptString9;
                                                                                        strOptString9 = str;
                                                                                        strOptString3 = strOptString3;
                                                                                        str5 = strOptString7;
                                                                                        strOptString8 = strOptString8;
                                                                                        int i8 = iOptInt2;
                                                                                        strOptString = strOptString;
                                                                                        iD = i8;
                                                                                        String str9 = str4;
                                                                                        this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                                        this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                                        this.b.put("imei_o", o.d(strQ));
                                                                                        this.b.put("uuid_o", x());
                                                                                        this.b.put("brand", Build.BRAND);
                                                                                        this.b.put(ze1.k, Build.MODEL);
                                                                                        this.b.put("package_name", strZ);
                                                                                        this.b.put("osv", Build.VERSION.RELEASE);
                                                                                        this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                                        this.b.put("android_id_o", o.d(strB));
                                                                                        this.b.put("device_type", Integer.valueOf(iM));
                                                                                        this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                                        this.b.put("width", Integer.valueOf(iD));
                                                                                        this.b.put("height", Integer.valueOf(iB));
                                                                                        this.b.put("operator", strOptString10);
                                                                                        this.b.put("app_name", strOptString);
                                                                                        this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                                        Pair<String, Integer> pairE4 = e();
                                                                                        this.b.put("app_ver_name", pairE4.first);
                                                                                        this.b.put("app_ver_code", pairE4.second);
                                                                                        this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                                        this.b.put("ip_address_o", o.d(p()));
                                                                                        this.b.put("physical_memory_byte", str5);
                                                                                        this.b.put("hard_disk_size_byte", strOptString8);
                                                                                        this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                                        this.b.put("dpi", strOptString4);
                                                                                        this.b.put("ppi", str2);
                                                                                        this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                                        this.b.put("boot_mark", g());
                                                                                        this.b.put("update_mark", H());
                                                                                        this.b.put("foreground_background", 1);
                                                                                        this.b.put("hms_core", strOptString3);
                                                                                        this.b.put("ag_ver", str9);
                                                                                        this.b.put("mac_o", o.d(strOptString6));
                                                                                        this.b.put("serial_o", o.d(str3));
                                                                                        this.b.put("imsi_o", o.d(strOptString10));
                                                                                        this.b.put("device_is_root", Integer.valueOf(i2));
                                                                                        this.b.put("device_name_o", o.d(strOptString9));
                                                                                        this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                                        this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                                        this.b.put(ze1.p, Build.MANUFACTURER);
                                                                                        this.b.put("vendor", Build.PRODUCT);
                                                                                        this.b.put("device", Build.DEVICE);
                                                                                        this.b.put("board", Build.BOARD);
                                                                                        this.b.put(ze1.l, Build.HARDWARE);
                                                                                        this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                                        this.b.put("x5_sdk_ver", q.b());
                                                                                        this.b.put("x5_ver", q.a(null));
                                                                                        this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                                    }
                                                                                } catch (Throwable th11) {
                                                                                    th = th11;
                                                                                    strOptString6 = strT;
                                                                                }
                                                                            } catch (Throwable th12) {
                                                                                th = th12;
                                                                                strOptString6 = strT;
                                                                                strOptString7 = strOptString7;
                                                                                strOptString8 = strOptString8;
                                                                                this = this;
                                                                                strOptString10 = strOptString10;
                                                                                iOptInt = iOptInt;
                                                                                strOptString2 = "";
                                                                                str = strOptString2;
                                                                                strOptString10 = str;
                                                                                i2 = 0;
                                                                                th = th;
                                                                                strOptString9 = strQ;
                                                                                i = 0;
                                                                                iOptInt2 = iD;
                                                                                strOptString = strOptString;
                                                                                r.a(th);
                                                                                i3 = i;
                                                                                str3 = strOptString2;
                                                                                str4 = strOptString5;
                                                                                strQ = strOptString9;
                                                                                strOptString9 = str;
                                                                                strOptString3 = strOptString3;
                                                                                str5 = strOptString7;
                                                                                strOptString8 = strOptString8;
                                                                                int i9 = iOptInt2;
                                                                                strOptString = strOptString;
                                                                                iD = i9;
                                                                                String str10 = str4;
                                                                                this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                                this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                                this.b.put("imei_o", o.d(strQ));
                                                                                this.b.put("uuid_o", x());
                                                                                this.b.put("brand", Build.BRAND);
                                                                                this.b.put(ze1.k, Build.MODEL);
                                                                                this.b.put("package_name", strZ);
                                                                                this.b.put("osv", Build.VERSION.RELEASE);
                                                                                this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                                this.b.put("android_id_o", o.d(strB));
                                                                                this.b.put("device_type", Integer.valueOf(iM));
                                                                                this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                                this.b.put("width", Integer.valueOf(iD));
                                                                                this.b.put("height", Integer.valueOf(iB));
                                                                                this.b.put("operator", strOptString10);
                                                                                this.b.put("app_name", strOptString);
                                                                                this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                                Pair<String, Integer> pairE5 = e();
                                                                                this.b.put("app_ver_name", pairE5.first);
                                                                                this.b.put("app_ver_code", pairE5.second);
                                                                                this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                                this.b.put("ip_address_o", o.d(p()));
                                                                                this.b.put("physical_memory_byte", str5);
                                                                                this.b.put("hard_disk_size_byte", strOptString8);
                                                                                this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                                this.b.put("dpi", strOptString4);
                                                                                this.b.put("ppi", str2);
                                                                                this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                                this.b.put("boot_mark", g());
                                                                                this.b.put("update_mark", H());
                                                                                this.b.put("foreground_background", 1);
                                                                                this.b.put("hms_core", strOptString3);
                                                                                this.b.put("ag_ver", str10);
                                                                                this.b.put("mac_o", o.d(strOptString6));
                                                                                this.b.put("serial_o", o.d(str3));
                                                                                this.b.put("imsi_o", o.d(strOptString10));
                                                                                this.b.put("device_is_root", Integer.valueOf(i2));
                                                                                this.b.put("device_name_o", o.d(strOptString9));
                                                                                this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                                this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                                this.b.put(ze1.p, Build.MANUFACTURER);
                                                                                this.b.put("vendor", Build.PRODUCT);
                                                                                this.b.put("device", Build.DEVICE);
                                                                                this.b.put("board", Build.BOARD);
                                                                                this.b.put(ze1.l, Build.HARDWARE);
                                                                                this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                                this.b.put("x5_sdk_ver", q.b());
                                                                                this.b.put("x5_ver", q.a(null));
                                                                                this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                            }
                                                                        } catch (Throwable th13) {
                                                                            th = th13;
                                                                            strQ = strQ;
                                                                            strOptString7 = strOptString7;
                                                                            strOptString8 = strOptString8;
                                                                            this = this;
                                                                            strOptString10 = strOptString10;
                                                                            iOptInt = iOptInt;
                                                                            strOptString2 = "";
                                                                            str = strOptString2;
                                                                            strOptString6 = str;
                                                                            strOptString10 = strOptString6;
                                                                            i2 = 0;
                                                                            th = th;
                                                                            strOptString9 = strQ;
                                                                            i = 0;
                                                                            iOptInt2 = iD;
                                                                            strOptString = strOptString;
                                                                            r.a(th);
                                                                            i3 = i;
                                                                            str3 = strOptString2;
                                                                            str4 = strOptString5;
                                                                            strQ = strOptString9;
                                                                            strOptString9 = str;
                                                                            strOptString3 = strOptString3;
                                                                            str5 = strOptString7;
                                                                            strOptString8 = strOptString8;
                                                                            int i10 = iOptInt2;
                                                                            strOptString = strOptString;
                                                                            iD = i10;
                                                                            String str11 = str4;
                                                                            this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                            this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                            this.b.put("imei_o", o.d(strQ));
                                                                            this.b.put("uuid_o", x());
                                                                            this.b.put("brand", Build.BRAND);
                                                                            this.b.put(ze1.k, Build.MODEL);
                                                                            this.b.put("package_name", strZ);
                                                                            this.b.put("osv", Build.VERSION.RELEASE);
                                                                            this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                            this.b.put("android_id_o", o.d(strB));
                                                                            this.b.put("device_type", Integer.valueOf(iM));
                                                                            this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                            this.b.put("width", Integer.valueOf(iD));
                                                                            this.b.put("height", Integer.valueOf(iB));
                                                                            this.b.put("operator", strOptString10);
                                                                            this.b.put("app_name", strOptString);
                                                                            this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                            Pair<String, Integer> pairE6 = e();
                                                                            this.b.put("app_ver_name", pairE6.first);
                                                                            this.b.put("app_ver_code", pairE6.second);
                                                                            this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                            this.b.put("ip_address_o", o.d(p()));
                                                                            this.b.put("physical_memory_byte", str5);
                                                                            this.b.put("hard_disk_size_byte", strOptString8);
                                                                            this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                            this.b.put("dpi", strOptString4);
                                                                            this.b.put("ppi", str2);
                                                                            this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                            this.b.put("boot_mark", g());
                                                                            this.b.put("update_mark", H());
                                                                            this.b.put("foreground_background", 1);
                                                                            this.b.put("hms_core", strOptString3);
                                                                            this.b.put("ag_ver", str11);
                                                                            this.b.put("mac_o", o.d(strOptString6));
                                                                            this.b.put("serial_o", o.d(str3));
                                                                            this.b.put("imsi_o", o.d(strOptString10));
                                                                            this.b.put("device_is_root", Integer.valueOf(i2));
                                                                            this.b.put("device_name_o", o.d(strOptString9));
                                                                            this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                            this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                            this.b.put(ze1.p, Build.MANUFACTURER);
                                                                            this.b.put("vendor", Build.PRODUCT);
                                                                            this.b.put("device", Build.DEVICE);
                                                                            this.b.put("board", Build.BOARD);
                                                                            this.b.put(ze1.l, Build.HARDWARE);
                                                                            this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                            this.b.put("x5_sdk_ver", q.b());
                                                                            this.b.put("x5_ver", q.a(null));
                                                                            this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                        }
                                                                    } catch (Throwable th14) {
                                                                        th = th14;
                                                                        strQ = strQ;
                                                                        strOptString7 = strOptString7;
                                                                        strOptString8 = strOptString8;
                                                                        this = this;
                                                                        strOptString10 = strOptString10;
                                                                        strOptString2 = "";
                                                                        str = strOptString2;
                                                                        strOptString5 = str;
                                                                        strOptString6 = strOptString5;
                                                                        strOptString10 = strOptString6;
                                                                        i2 = 0;
                                                                        th = th;
                                                                        strOptString9 = strQ;
                                                                        i = 0;
                                                                        iOptInt2 = iD;
                                                                        strOptString = strOptString;
                                                                        r.a(th);
                                                                        i3 = i;
                                                                        str3 = strOptString2;
                                                                        str4 = strOptString5;
                                                                        strQ = strOptString9;
                                                                        strOptString9 = str;
                                                                        strOptString3 = strOptString3;
                                                                        str5 = strOptString7;
                                                                        strOptString8 = strOptString8;
                                                                        int i11 = iOptInt2;
                                                                        strOptString = strOptString;
                                                                        iD = i11;
                                                                        String str12 = str4;
                                                                        this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                        this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                        this.b.put("imei_o", o.d(strQ));
                                                                        this.b.put("uuid_o", x());
                                                                        this.b.put("brand", Build.BRAND);
                                                                        this.b.put(ze1.k, Build.MODEL);
                                                                        this.b.put("package_name", strZ);
                                                                        this.b.put("osv", Build.VERSION.RELEASE);
                                                                        this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                        this.b.put("android_id_o", o.d(strB));
                                                                        this.b.put("device_type", Integer.valueOf(iM));
                                                                        this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                        this.b.put("width", Integer.valueOf(iD));
                                                                        this.b.put("height", Integer.valueOf(iB));
                                                                        this.b.put("operator", strOptString10);
                                                                        this.b.put("app_name", strOptString);
                                                                        this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                        Pair<String, Integer> pairE7 = e();
                                                                        this.b.put("app_ver_name", pairE7.first);
                                                                        this.b.put("app_ver_code", pairE7.second);
                                                                        this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                        this.b.put("ip_address_o", o.d(p()));
                                                                        this.b.put("physical_memory_byte", str5);
                                                                        this.b.put("hard_disk_size_byte", strOptString8);
                                                                        this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                        this.b.put("dpi", strOptString4);
                                                                        this.b.put("ppi", str2);
                                                                        this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                        this.b.put("boot_mark", g());
                                                                        this.b.put("update_mark", H());
                                                                        this.b.put("foreground_background", 1);
                                                                        this.b.put("hms_core", strOptString3);
                                                                        this.b.put("ag_ver", str12);
                                                                        this.b.put("mac_o", o.d(strOptString6));
                                                                        this.b.put("serial_o", o.d(str3));
                                                                        this.b.put("imsi_o", o.d(strOptString10));
                                                                        this.b.put("device_is_root", Integer.valueOf(i2));
                                                                        this.b.put("device_name_o", o.d(strOptString9));
                                                                        this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                        this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                        this.b.put(ze1.p, Build.MANUFACTURER);
                                                                        this.b.put("vendor", Build.PRODUCT);
                                                                        this.b.put("device", Build.DEVICE);
                                                                        this.b.put("board", Build.BOARD);
                                                                        this.b.put(ze1.l, Build.HARDWARE);
                                                                        this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                        this.b.put("x5_sdk_ver", q.b());
                                                                        this.b.put("x5_ver", q.a(null));
                                                                        this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                    }
                                                                } catch (Throwable th15) {
                                                                    th = th15;
                                                                    strOptString2 = "";
                                                                    str = strOptString2;
                                                                    strOptString3 = str;
                                                                    strOptString5 = strOptString3;
                                                                    strOptString6 = strOptString5;
                                                                    strOptString10 = strOptString6;
                                                                    i2 = 0;
                                                                    th = th;
                                                                    strOptString9 = strQ;
                                                                    i = 0;
                                                                    iOptInt2 = iD;
                                                                    strOptString = strOptString;
                                                                    r.a(th);
                                                                    i3 = i;
                                                                    str3 = strOptString2;
                                                                    str4 = strOptString5;
                                                                    strQ = strOptString9;
                                                                    strOptString9 = str;
                                                                    strOptString3 = strOptString3;
                                                                    str5 = strOptString7;
                                                                    strOptString8 = strOptString8;
                                                                    int i12 = iOptInt2;
                                                                    strOptString = strOptString;
                                                                    iD = i12;
                                                                    String str13 = str4;
                                                                    this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                    this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                    this.b.put("imei_o", o.d(strQ));
                                                                    this.b.put("uuid_o", x());
                                                                    this.b.put("brand", Build.BRAND);
                                                                    this.b.put(ze1.k, Build.MODEL);
                                                                    this.b.put("package_name", strZ);
                                                                    this.b.put("osv", Build.VERSION.RELEASE);
                                                                    this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                    this.b.put("android_id_o", o.d(strB));
                                                                    this.b.put("device_type", Integer.valueOf(iM));
                                                                    this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                    this.b.put("width", Integer.valueOf(iD));
                                                                    this.b.put("height", Integer.valueOf(iB));
                                                                    this.b.put("operator", strOptString10);
                                                                    this.b.put("app_name", strOptString);
                                                                    this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                    Pair<String, Integer> pairE8 = e();
                                                                    this.b.put("app_ver_name", pairE8.first);
                                                                    this.b.put("app_ver_code", pairE8.second);
                                                                    this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                    this.b.put("ip_address_o", o.d(p()));
                                                                    this.b.put("physical_memory_byte", str5);
                                                                    this.b.put("hard_disk_size_byte", strOptString8);
                                                                    this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                    this.b.put("dpi", strOptString4);
                                                                    this.b.put("ppi", str2);
                                                                    this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                    this.b.put("boot_mark", g());
                                                                    this.b.put("update_mark", H());
                                                                    this.b.put("foreground_background", 1);
                                                                    this.b.put("hms_core", strOptString3);
                                                                    this.b.put("ag_ver", str13);
                                                                    this.b.put("mac_o", o.d(strOptString6));
                                                                    this.b.put("serial_o", o.d(str3));
                                                                    this.b.put("imsi_o", o.d(strOptString10));
                                                                    this.b.put("device_is_root", Integer.valueOf(i2));
                                                                    this.b.put("device_name_o", o.d(strOptString9));
                                                                    this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                    this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                    this.b.put(ze1.p, Build.MANUFACTURER);
                                                                    this.b.put("vendor", Build.PRODUCT);
                                                                    this.b.put("device", Build.DEVICE);
                                                                    this.b.put("board", Build.BOARD);
                                                                    this.b.put(ze1.l, Build.HARDWARE);
                                                                    this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                    this.b.put("x5_sdk_ver", q.b());
                                                                    this.b.put("x5_ver", q.a(null));
                                                                    this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                }
                                                            } catch (Throwable th16) {
                                                                th = th16;
                                                                strOptString2 = "";
                                                                str = strOptString2;
                                                                str2 = str;
                                                                strOptString3 = str2;
                                                            }
                                                        } catch (Throwable th17) {
                                                            th = th17;
                                                            strQ = strQ;
                                                            strOptString7 = strOptString7;
                                                            strOptString8 = strOptString8;
                                                            this = this;
                                                            strOptString10 = strOptString10;
                                                            strOptString2 = "";
                                                            str = strOptString2;
                                                            str2 = str;
                                                            strOptString3 = str2;
                                                            strOptString4 = strOptString3;
                                                            strOptString5 = strOptString4;
                                                        }
                                                    } catch (Throwable th18) {
                                                        th = th18;
                                                        strOptString7 = strOptString7;
                                                        strOptString2 = "";
                                                        str = strOptString2;
                                                        str2 = str;
                                                        strOptString3 = str2;
                                                        strOptString4 = strOptString3;
                                                        strOptString5 = strOptString4;
                                                        strOptString6 = strOptString5;
                                                        strOptString10 = strOptString6;
                                                        strOptString8 = strOptString10;
                                                        i2 = 0;
                                                        th = th;
                                                        strOptString9 = strQ;
                                                        i = 0;
                                                        iOptInt2 = iD;
                                                        strOptString = strOptString;
                                                        r.a(th);
                                                        i3 = i;
                                                        str3 = strOptString2;
                                                        str4 = strOptString5;
                                                        strQ = strOptString9;
                                                        strOptString9 = str;
                                                        strOptString3 = strOptString3;
                                                        str5 = strOptString7;
                                                        strOptString8 = strOptString8;
                                                        int i13 = iOptInt2;
                                                        strOptString = strOptString;
                                                        iD = i13;
                                                        String str14 = str4;
                                                        this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                        this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                        this.b.put("imei_o", o.d(strQ));
                                                        this.b.put("uuid_o", x());
                                                        this.b.put("brand", Build.BRAND);
                                                        this.b.put(ze1.k, Build.MODEL);
                                                        this.b.put("package_name", strZ);
                                                        this.b.put("osv", Build.VERSION.RELEASE);
                                                        this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                        this.b.put("android_id_o", o.d(strB));
                                                        this.b.put("device_type", Integer.valueOf(iM));
                                                        this.b.put("orientation", Integer.valueOf(iOptInt));
                                                        this.b.put("width", Integer.valueOf(iD));
                                                        this.b.put("height", Integer.valueOf(iB));
                                                        this.b.put("operator", strOptString10);
                                                        this.b.put("app_name", strOptString);
                                                        this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                        Pair<String, Integer> pairE9 = e();
                                                        this.b.put("app_ver_name", pairE9.first);
                                                        this.b.put("app_ver_code", pairE9.second);
                                                        this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                        this.b.put("ip_address_o", o.d(p()));
                                                        this.b.put("physical_memory_byte", str5);
                                                        this.b.put("hard_disk_size_byte", strOptString8);
                                                        this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                        this.b.put("dpi", strOptString4);
                                                        this.b.put("ppi", str2);
                                                        this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                        this.b.put("boot_mark", g());
                                                        this.b.put("update_mark", H());
                                                        this.b.put("foreground_background", 1);
                                                        this.b.put("hms_core", strOptString3);
                                                        this.b.put("ag_ver", str14);
                                                        this.b.put("mac_o", o.d(strOptString6));
                                                        this.b.put("serial_o", o.d(str3));
                                                        this.b.put("imsi_o", o.d(strOptString10));
                                                        this.b.put("device_is_root", Integer.valueOf(i2));
                                                        this.b.put("device_name_o", o.d(strOptString9));
                                                        this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                        this.b.put("is_debuggable", Integer.valueOf(i3));
                                                        this.b.put(ze1.p, Build.MANUFACTURER);
                                                        this.b.put("vendor", Build.PRODUCT);
                                                        this.b.put("device", Build.DEVICE);
                                                        this.b.put("board", Build.BOARD);
                                                        this.b.put(ze1.l, Build.HARDWARE);
                                                        this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                        this.b.put("x5_sdk_ver", q.b());
                                                        this.b.put("x5_ver", q.a(null));
                                                        this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                    }
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    strOptString2 = "";
                                                    str = strOptString2;
                                                    str2 = str;
                                                    strOptString3 = str2;
                                                    strOptString4 = strOptString3;
                                                    strOptString5 = strOptString4;
                                                    strOptString6 = strOptString5;
                                                    strOptString7 = strOptString6;
                                                    strOptString10 = strOptString7;
                                                }
                                            } catch (Throwable th20) {
                                                this = this;
                                                iOptInt2 = iD;
                                                strOptString10 = strOptString10;
                                                strOptString = "";
                                                strOptString2 = strOptString;
                                                str = strOptString2;
                                                str2 = str;
                                                strOptString3 = str2;
                                                strOptString4 = strOptString3;
                                                strOptString5 = strOptString4;
                                                strOptString6 = strOptString5;
                                                strOptString7 = strOptString6;
                                                strOptString10 = strOptString7;
                                                strOptString8 = strOptString10;
                                                i2 = 0;
                                                th = th20;
                                                strOptString9 = strQ;
                                                i = 0;
                                            }
                                        } catch (Throwable th21) {
                                            th = th21;
                                            strQ = strQ;
                                            this = this;
                                            iOptInt2 = iD;
                                            strOptString = "";
                                            strOptString2 = strOptString;
                                            str = strOptString2;
                                            str2 = str;
                                            strOptString3 = str2;
                                            strOptString4 = strOptString3;
                                            strOptString5 = strOptString4;
                                            strOptString6 = strOptString5;
                                            strOptString7 = strOptString6;
                                            strOptString8 = strOptString7;
                                            strOptString10 = "0";
                                            i2 = 0;
                                            th = th;
                                            strOptString10 = strOptString8;
                                            i = 0;
                                            strOptString9 = strQ;
                                            r.a(th);
                                            i3 = i;
                                            str3 = strOptString2;
                                            str4 = strOptString5;
                                            strQ = strOptString9;
                                            strOptString9 = str;
                                            strOptString3 = strOptString3;
                                            str5 = strOptString7;
                                            strOptString8 = strOptString8;
                                            int i14 = iOptInt2;
                                            strOptString = strOptString;
                                            iD = i14;
                                            String str15 = str4;
                                            this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                            this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                            this.b.put("imei_o", o.d(strQ));
                                            this.b.put("uuid_o", x());
                                            this.b.put("brand", Build.BRAND);
                                            this.b.put(ze1.k, Build.MODEL);
                                            this.b.put("package_name", strZ);
                                            this.b.put("osv", Build.VERSION.RELEASE);
                                            this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                            this.b.put("android_id_o", o.d(strB));
                                            this.b.put("device_type", Integer.valueOf(iM));
                                            this.b.put("orientation", Integer.valueOf(iOptInt));
                                            this.b.put("width", Integer.valueOf(iD));
                                            this.b.put("height", Integer.valueOf(iB));
                                            this.b.put("operator", strOptString10);
                                            this.b.put("app_name", strOptString);
                                            this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                            Pair<String, Integer> pairE10 = e();
                                            this.b.put("app_ver_name", pairE10.first);
                                            this.b.put("app_ver_code", pairE10.second);
                                            this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                            this.b.put("ip_address_o", o.d(p()));
                                            this.b.put("physical_memory_byte", str5);
                                            this.b.put("hard_disk_size_byte", strOptString8);
                                            this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                            this.b.put("dpi", strOptString4);
                                            this.b.put("ppi", str2);
                                            this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                            this.b.put("boot_mark", g());
                                            this.b.put("update_mark", H());
                                            this.b.put("foreground_background", 1);
                                            this.b.put("hms_core", strOptString3);
                                            this.b.put("ag_ver", str15);
                                            this.b.put("mac_o", o.d(strOptString6));
                                            this.b.put("serial_o", o.d(str3));
                                            this.b.put("imsi_o", o.d(strOptString10));
                                            this.b.put("device_is_root", Integer.valueOf(i2));
                                            this.b.put("device_name_o", o.d(strOptString9));
                                            this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                            this.b.put("is_debuggable", Integer.valueOf(i3));
                                            this.b.put(ze1.p, Build.MANUFACTURER);
                                            this.b.put("vendor", Build.PRODUCT);
                                            this.b.put("device", Build.DEVICE);
                                            this.b.put("board", Build.BOARD);
                                            this.b.put(ze1.l, Build.HARDWARE);
                                            this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                            this.b.put("x5_sdk_ver", q.b());
                                            this.b.put("x5_ver", q.a(null));
                                            this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                        }
                                    } catch (Throwable th22) {
                                        th = th22;
                                        iOptInt2 = iD;
                                        strOptString = "";
                                        strOptString2 = strOptString;
                                        str = strOptString2;
                                        str2 = str;
                                        strOptString3 = str2;
                                        strOptString4 = strOptString3;
                                        strOptString5 = strOptString4;
                                        strOptString6 = strOptString5;
                                        strOptString7 = strOptString6;
                                        strOptString8 = strOptString7;
                                        iB = 0;
                                        i2 = 0;
                                        th = th;
                                        strOptString10 = strOptString8;
                                        i = 0;
                                        strOptString9 = strQ;
                                        r.a(th);
                                        i3 = i;
                                        str3 = strOptString2;
                                        str4 = strOptString5;
                                        strQ = strOptString9;
                                        strOptString9 = str;
                                        strOptString3 = strOptString3;
                                        str5 = strOptString7;
                                        strOptString8 = strOptString8;
                                        int i15 = iOptInt2;
                                        strOptString = strOptString;
                                        iD = i15;
                                        String str16 = str4;
                                        this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                        this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                        this.b.put("imei_o", o.d(strQ));
                                        this.b.put("uuid_o", x());
                                        this.b.put("brand", Build.BRAND);
                                        this.b.put(ze1.k, Build.MODEL);
                                        this.b.put("package_name", strZ);
                                        this.b.put("osv", Build.VERSION.RELEASE);
                                        this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                        this.b.put("android_id_o", o.d(strB));
                                        this.b.put("device_type", Integer.valueOf(iM));
                                        this.b.put("orientation", Integer.valueOf(iOptInt));
                                        this.b.put("width", Integer.valueOf(iD));
                                        this.b.put("height", Integer.valueOf(iB));
                                        this.b.put("operator", strOptString10);
                                        this.b.put("app_name", strOptString);
                                        this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                        Pair<String, Integer> pairE11 = e();
                                        this.b.put("app_ver_name", pairE11.first);
                                        this.b.put("app_ver_code", pairE11.second);
                                        this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                        this.b.put("ip_address_o", o.d(p()));
                                        this.b.put("physical_memory_byte", str5);
                                        this.b.put("hard_disk_size_byte", strOptString8);
                                        this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                        this.b.put("dpi", strOptString4);
                                        this.b.put("ppi", str2);
                                        this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                        this.b.put("boot_mark", g());
                                        this.b.put("update_mark", H());
                                        this.b.put("foreground_background", 1);
                                        this.b.put("hms_core", strOptString3);
                                        this.b.put("ag_ver", str16);
                                        this.b.put("mac_o", o.d(strOptString6));
                                        this.b.put("serial_o", o.d(str3));
                                        this.b.put("imsi_o", o.d(strOptString10));
                                        this.b.put("device_is_root", Integer.valueOf(i2));
                                        this.b.put("device_name_o", o.d(strOptString9));
                                        this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                        this.b.put("is_debuggable", Integer.valueOf(i3));
                                        this.b.put(ze1.p, Build.MANUFACTURER);
                                        this.b.put("vendor", Build.PRODUCT);
                                        this.b.put("device", Build.DEVICE);
                                        this.b.put("board", Build.BOARD);
                                        this.b.put(ze1.l, Build.HARDWARE);
                                        this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                        this.b.put("x5_sdk_ver", q.b());
                                        this.b.put("x5_ver", q.a(null));
                                        this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                    }
                                } catch (Throwable th23) {
                                    th = th23;
                                    strOptString = "";
                                    strOptString2 = strOptString;
                                    str = strOptString2;
                                    str2 = str;
                                    strOptString3 = str2;
                                    strOptString4 = strOptString3;
                                    strOptString5 = strOptString4;
                                    strOptString6 = strOptString5;
                                    strOptString7 = strOptString6;
                                    strOptString8 = strOptString7;
                                    iOptInt2 = 0;
                                }
                            } catch (Throwable th24) {
                                strQ = strQ;
                                this = this;
                                th = th24;
                                strOptString = "";
                                strOptString2 = strOptString;
                                str = strOptString2;
                                str2 = str;
                                strOptString3 = str2;
                                strOptString4 = strOptString3;
                                strOptString5 = strOptString4;
                                strOptString6 = strOptString5;
                                strOptString7 = strOptString6;
                                strOptString8 = strOptString7;
                                i = 0;
                                iOptInt = 1;
                                iOptInt2 = 0;
                                iB = 0;
                                i2 = 0;
                                strOptString10 = strOptString8;
                                strOptString9 = strQ;
                                r.a(th);
                                i3 = i;
                                str3 = strOptString2;
                                str4 = strOptString5;
                                strQ = strOptString9;
                                strOptString9 = str;
                                strOptString3 = strOptString3;
                                str5 = strOptString7;
                                strOptString8 = strOptString8;
                                int i16 = iOptInt2;
                                strOptString = strOptString;
                                iD = i16;
                                String str17 = str4;
                                this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                this.b.put("imei_o", o.d(strQ));
                                this.b.put("uuid_o", x());
                                this.b.put("brand", Build.BRAND);
                                this.b.put(ze1.k, Build.MODEL);
                                this.b.put("package_name", strZ);
                                this.b.put("osv", Build.VERSION.RELEASE);
                                this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                this.b.put("android_id_o", o.d(strB));
                                this.b.put("device_type", Integer.valueOf(iM));
                                this.b.put("orientation", Integer.valueOf(iOptInt));
                                this.b.put("width", Integer.valueOf(iD));
                                this.b.put("height", Integer.valueOf(iB));
                                this.b.put("operator", strOptString10);
                                this.b.put("app_name", strOptString);
                                this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                Pair<String, Integer> pairE12 = e();
                                this.b.put("app_ver_name", pairE12.first);
                                this.b.put("app_ver_code", pairE12.second);
                                this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                this.b.put("ip_address_o", o.d(p()));
                                this.b.put("physical_memory_byte", str5);
                                this.b.put("hard_disk_size_byte", strOptString8);
                                this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                this.b.put("dpi", strOptString4);
                                this.b.put("ppi", str2);
                                this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                this.b.put("boot_mark", g());
                                this.b.put("update_mark", H());
                                this.b.put("foreground_background", 1);
                                this.b.put("hms_core", strOptString3);
                                this.b.put("ag_ver", str17);
                                this.b.put("mac_o", o.d(strOptString6));
                                this.b.put("serial_o", o.d(str3));
                                this.b.put("imsi_o", o.d(strOptString10));
                                this.b.put("device_is_root", Integer.valueOf(i2));
                                this.b.put("device_name_o", o.d(strOptString9));
                                this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                this.b.put("is_debuggable", Integer.valueOf(i3));
                                this.b.put(ze1.p, Build.MANUFACTURER);
                                this.b.put("vendor", Build.PRODUCT);
                                this.b.put("device", Build.DEVICE);
                                this.b.put("board", Build.BOARD);
                                this.b.put(ze1.l, Build.HARDWARE);
                                this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                this.b.put("x5_sdk_ver", q.b());
                                this.b.put("x5_ver", q.a(null));
                                this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                            }
                        } catch (Throwable th25) {
                            th = th25;
                            strOptString = "";
                            strOptString2 = strOptString;
                            str = strOptString2;
                            str2 = str;
                            strOptString3 = str2;
                            strOptString4 = strOptString3;
                            strOptString5 = strOptString4;
                            strOptString6 = strOptString5;
                            strOptString7 = strOptString6;
                            strOptString8 = strOptString7;
                            i = 0;
                            iOptInt = 1;
                            iOptInt2 = 0;
                            iB = 0;
                            iM = 1;
                            i2 = 0;
                            strOptString10 = strOptString8;
                            strOptString9 = strQ;
                            r.a(th);
                            i3 = i;
                            str3 = strOptString2;
                            str4 = strOptString5;
                            strQ = strOptString9;
                            strOptString9 = str;
                            strOptString3 = strOptString3;
                            str5 = strOptString7;
                            strOptString8 = strOptString8;
                            int i17 = iOptInt2;
                            strOptString = strOptString;
                            iD = i17;
                            String str18 = str4;
                            this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                            this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                            this.b.put("imei_o", o.d(strQ));
                            this.b.put("uuid_o", x());
                            this.b.put("brand", Build.BRAND);
                            this.b.put(ze1.k, Build.MODEL);
                            this.b.put("package_name", strZ);
                            this.b.put("osv", Build.VERSION.RELEASE);
                            this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                            this.b.put("android_id_o", o.d(strB));
                            this.b.put("device_type", Integer.valueOf(iM));
                            this.b.put("orientation", Integer.valueOf(iOptInt));
                            this.b.put("width", Integer.valueOf(iD));
                            this.b.put("height", Integer.valueOf(iB));
                            this.b.put("operator", strOptString10);
                            this.b.put("app_name", strOptString);
                            this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                            Pair<String, Integer> pairE13 = e();
                            this.b.put("app_ver_name", pairE13.first);
                            this.b.put("app_ver_code", pairE13.second);
                            this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                            this.b.put("ip_address_o", o.d(p()));
                            this.b.put("physical_memory_byte", str5);
                            this.b.put("hard_disk_size_byte", strOptString8);
                            this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                            this.b.put("dpi", strOptString4);
                            this.b.put("ppi", str2);
                            this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                            this.b.put("boot_mark", g());
                            this.b.put("update_mark", H());
                            this.b.put("foreground_background", 1);
                            this.b.put("hms_core", strOptString3);
                            this.b.put("ag_ver", str18);
                            this.b.put("mac_o", o.d(strOptString6));
                            this.b.put("serial_o", o.d(str3));
                            this.b.put("imsi_o", o.d(strOptString10));
                            this.b.put("device_is_root", Integer.valueOf(i2));
                            this.b.put("device_name_o", o.d(strOptString9));
                            this.b.put("wx_open_sdk", Integer.valueOf(J()));
                            this.b.put("is_debuggable", Integer.valueOf(i3));
                            this.b.put(ze1.p, Build.MANUFACTURER);
                            this.b.put("vendor", Build.PRODUCT);
                            this.b.put("device", Build.DEVICE);
                            this.b.put("board", Build.BOARD);
                            this.b.put(ze1.l, Build.HARDWARE);
                            this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                            this.b.put("x5_sdk_ver", q.b());
                            this.b.put("x5_ver", q.a(null));
                            this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                        }
                    } catch (Throwable th26) {
                        th = th26;
                        strOptString = "";
                        strOptString2 = strOptString;
                        strB = strOptString2;
                        str = strB;
                    }
                } catch (Throwable th27) {
                    th = th27;
                    strOptString = "";
                    strOptString2 = strOptString;
                    strB = strOptString2;
                    strZ = strB;
                    str = strZ;
                }
            } else {
                String strOptString11 = jSONObject2.optString("b");
                try {
                    if (TextUtils.isEmpty(strOptString11)) {
                        strOptString11 = q();
                    }
                    String strOptString12 = jSONObject2.optString("c");
                    try {
                        if (TextUtils.isEmpty(strOptString12)) {
                            strOptString12 = z();
                        }
                        String strOptString13 = jSONObject2.optString("d");
                        try {
                            if (TextUtils.isEmpty(strOptString13)) {
                                strOptString13 = b();
                            }
                            int iOptInt3 = jSONObject2.optInt("e");
                            try {
                                iOptInt = jSONObject2.optInt("f");
                                try {
                                    iOptInt2 = jSONObject2.optInt(y6b.f);
                                    try {
                                        iB = jSONObject2.getInt(y6b.g);
                                        try {
                                            strOptString10 = jSONObject2.optString("i");
                                            if (TextUtils.isEmpty(strOptString10)) {
                                                strOptString10 = F();
                                            }
                                            strOptString = jSONObject2.optString("j");
                                            try {
                                                strOptString7 = jSONObject2.optString("k");
                                                try {
                                                    strOptString8 = jSONObject2.optString(com.kuaishou.weapon.p0.t.d);
                                                    try {
                                                        strOptString4 = jSONObject2.optString("m");
                                                        try {
                                                            String strOptString14 = jSONObject2.optString("n");
                                                            try {
                                                                strOptString3 = jSONObject2.optString(com.google.android.exoplayer2.source.rtsp.j.b);
                                                                try {
                                                                    strOptString5 = jSONObject2.optString("p");
                                                                    try {
                                                                        if (TextUtils.isEmpty(strOptString5)) {
                                                                            strOptString5 = c();
                                                                        }
                                                                        strOptString6 = jSONObject2.optString("q");
                                                                        try {
                                                                            if (TextUtils.isEmpty(strOptString6)) {
                                                                                strOptString6 = t();
                                                                            }
                                                                            strOptString2 = jSONObject2.optString("r");
                                                                            try {
                                                                                String strOptString15 = jSONObject2.optString("s");
                                                                                try {
                                                                                    int iOptInt4 = jSONObject2.optInt("t");
                                                                                    try {
                                                                                        strOptString9 = jSONObject2.optString("u");
                                                                                        if (TextUtils.isEmpty(strOptString9)) {
                                                                                            strOptString9 = j();
                                                                                        }
                                                                                        int iOptInt5 = jSONObject2.optInt("v");
                                                                                        try {
                                                                                            this = this;
                                                                                            try {
                                                                                                this.d = jSONObject2.optString("w");
                                                                                                str4 = strOptString5;
                                                                                                iOptInt = iOptInt;
                                                                                                iD = iOptInt2;
                                                                                                iB = iB;
                                                                                                i3 = iOptInt5;
                                                                                                i2 = iOptInt4;
                                                                                                strQ = strOptString11;
                                                                                                strZ = strOptString12;
                                                                                                strB = strOptString13;
                                                                                                iM = iOptInt3;
                                                                                                str5 = strOptString7;
                                                                                                strOptString4 = strOptString4;
                                                                                                str2 = strOptString14;
                                                                                                strOptString10 = strOptString10;
                                                                                                strOptString10 = strOptString15;
                                                                                                strOptString6 = strOptString6;
                                                                                                str3 = strOptString2;
                                                                                            } catch (Throwable th28) {
                                                                                                th = th28;
                                                                                                strOptString8 = strOptString8;
                                                                                                strOptString3 = strOptString3;
                                                                                                th = th;
                                                                                                i = iOptInt5;
                                                                                                i2 = iOptInt4;
                                                                                                String str19 = strOptString12;
                                                                                                strB = strOptString13;
                                                                                                iM = iOptInt3;
                                                                                                str = strOptString9;
                                                                                                strOptString9 = strOptString11;
                                                                                                strZ = str19;
                                                                                                str2 = strOptString14;
                                                                                                strOptString10 = strOptString10;
                                                                                                strOptString10 = strOptString15;
                                                                                                strOptString7 = strOptString7;
                                                                                                strOptString4 = strOptString4;
                                                                                                r.a(th);
                                                                                                i3 = i;
                                                                                                str3 = strOptString2;
                                                                                                str4 = strOptString5;
                                                                                                strQ = strOptString9;
                                                                                                strOptString9 = str;
                                                                                                strOptString3 = strOptString3;
                                                                                                str5 = strOptString7;
                                                                                                strOptString8 = strOptString8;
                                                                                                int i18 = iOptInt2;
                                                                                                strOptString = strOptString;
                                                                                                iD = i18;
                                                                                            }
                                                                                        } catch (Throwable th29) {
                                                                                            th = th29;
                                                                                            this = this;
                                                                                        }
                                                                                    } catch (Throwable th30) {
                                                                                        th = th30;
                                                                                        i2 = iOptInt4;
                                                                                        th = th;
                                                                                        i = 0;
                                                                                        String str110 = strOptString12;
                                                                                        strB = strOptString13;
                                                                                        iM = iOptInt3;
                                                                                        str = strOptString9;
                                                                                        strOptString9 = strOptString11;
                                                                                        strZ = str110;
                                                                                        str2 = strOptString14;
                                                                                        strOptString10 = strOptString10;
                                                                                        strOptString10 = strOptString15;
                                                                                        strOptString7 = strOptString7;
                                                                                        strOptString4 = strOptString4;
                                                                                        r.a(th);
                                                                                        i3 = i;
                                                                                        str3 = strOptString2;
                                                                                        str4 = strOptString5;
                                                                                        strQ = strOptString9;
                                                                                        strOptString9 = str;
                                                                                        strOptString3 = strOptString3;
                                                                                        str5 = strOptString7;
                                                                                        strOptString8 = strOptString8;
                                                                                        int i19 = iOptInt2;
                                                                                        strOptString = strOptString;
                                                                                        iD = i19;
                                                                                        String str111 = str4;
                                                                                        this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                                        this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                                        this.b.put("imei_o", o.d(strQ));
                                                                                        this.b.put("uuid_o", x());
                                                                                        this.b.put("brand", Build.BRAND);
                                                                                        this.b.put(ze1.k, Build.MODEL);
                                                                                        this.b.put("package_name", strZ);
                                                                                        this.b.put("osv", Build.VERSION.RELEASE);
                                                                                        this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                                        this.b.put("android_id_o", o.d(strB));
                                                                                        this.b.put("device_type", Integer.valueOf(iM));
                                                                                        this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                                        this.b.put("width", Integer.valueOf(iD));
                                                                                        this.b.put("height", Integer.valueOf(iB));
                                                                                        this.b.put("operator", strOptString10);
                                                                                        this.b.put("app_name", strOptString);
                                                                                        this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                                        Pair<String, Integer> pairE14 = e();
                                                                                        this.b.put("app_ver_name", pairE14.first);
                                                                                        this.b.put("app_ver_code", pairE14.second);
                                                                                        this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                                        this.b.put("ip_address_o", o.d(p()));
                                                                                        this.b.put("physical_memory_byte", str5);
                                                                                        this.b.put("hard_disk_size_byte", strOptString8);
                                                                                        this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                                        this.b.put("dpi", strOptString4);
                                                                                        this.b.put("ppi", str2);
                                                                                        this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                                        this.b.put("boot_mark", g());
                                                                                        this.b.put("update_mark", H());
                                                                                        this.b.put("foreground_background", 1);
                                                                                        this.b.put("hms_core", strOptString3);
                                                                                        this.b.put("ag_ver", str111);
                                                                                        this.b.put("mac_o", o.d(strOptString6));
                                                                                        this.b.put("serial_o", o.d(str3));
                                                                                        this.b.put("imsi_o", o.d(strOptString10));
                                                                                        this.b.put("device_is_root", Integer.valueOf(i2));
                                                                                        this.b.put("device_name_o", o.d(strOptString9));
                                                                                        this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                                        this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                                        this.b.put(ze1.p, Build.MANUFACTURER);
                                                                                        this.b.put("vendor", Build.PRODUCT);
                                                                                        this.b.put("device", Build.DEVICE);
                                                                                        this.b.put("board", Build.BOARD);
                                                                                        this.b.put(ze1.l, Build.HARDWARE);
                                                                                        this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                                        this.b.put("x5_sdk_ver", q.b());
                                                                                        this.b.put("x5_ver", q.a(null));
                                                                                        this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                                    }
                                                                                } catch (Throwable th31) {
                                                                                    th = th31;
                                                                                    i2 = 0;
                                                                                }
                                                                            } catch (Throwable th32) {
                                                                                this = this;
                                                                                strOptString8 = strOptString8;
                                                                                strOptString7 = strOptString7;
                                                                                strOptString3 = strOptString3;
                                                                                i2 = 0;
                                                                                strOptString5 = strOptString5;
                                                                                iOptInt = iOptInt;
                                                                                strOptString = strOptString;
                                                                                iOptInt2 = iOptInt2;
                                                                                iB = iB;
                                                                                strOptString4 = strOptString4;
                                                                                strOptString2 = strOptString2;
                                                                                str2 = strOptString14;
                                                                                strOptString6 = strOptString6;
                                                                                strOptString10 = strOptString10;
                                                                                th = th32;
                                                                                strOptString10 = "";
                                                                                i = 0;
                                                                                strOptString9 = strOptString11;
                                                                                strZ = strOptString12;
                                                                                strB = strOptString13;
                                                                                iM = iOptInt3;
                                                                                str = strOptString10;
                                                                                r.a(th);
                                                                                i3 = i;
                                                                                str3 = strOptString2;
                                                                                str4 = strOptString5;
                                                                                strQ = strOptString9;
                                                                                strOptString9 = str;
                                                                                strOptString3 = strOptString3;
                                                                                str5 = strOptString7;
                                                                                strOptString8 = strOptString8;
                                                                                int i110 = iOptInt2;
                                                                                strOptString = strOptString;
                                                                                iD = i110;
                                                                                String str112 = str4;
                                                                                this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                                this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                                this.b.put("imei_o", o.d(strQ));
                                                                                this.b.put("uuid_o", x());
                                                                                this.b.put("brand", Build.BRAND);
                                                                                this.b.put(ze1.k, Build.MODEL);
                                                                                this.b.put("package_name", strZ);
                                                                                this.b.put("osv", Build.VERSION.RELEASE);
                                                                                this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                                this.b.put("android_id_o", o.d(strB));
                                                                                this.b.put("device_type", Integer.valueOf(iM));
                                                                                this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                                this.b.put("width", Integer.valueOf(iD));
                                                                                this.b.put("height", Integer.valueOf(iB));
                                                                                this.b.put("operator", strOptString10);
                                                                                this.b.put("app_name", strOptString);
                                                                                this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                                Pair<String, Integer> pairE15 = e();
                                                                                this.b.put("app_ver_name", pairE15.first);
                                                                                this.b.put("app_ver_code", pairE15.second);
                                                                                this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                                this.b.put("ip_address_o", o.d(p()));
                                                                                this.b.put("physical_memory_byte", str5);
                                                                                this.b.put("hard_disk_size_byte", strOptString8);
                                                                                this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                                this.b.put("dpi", strOptString4);
                                                                                this.b.put("ppi", str2);
                                                                                this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                                this.b.put("boot_mark", g());
                                                                                this.b.put("update_mark", H());
                                                                                this.b.put("foreground_background", 1);
                                                                                this.b.put("hms_core", strOptString3);
                                                                                this.b.put("ag_ver", str112);
                                                                                this.b.put("mac_o", o.d(strOptString6));
                                                                                this.b.put("serial_o", o.d(str3));
                                                                                this.b.put("imsi_o", o.d(strOptString10));
                                                                                this.b.put("device_is_root", Integer.valueOf(i2));
                                                                                this.b.put("device_name_o", o.d(strOptString9));
                                                                                this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                                this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                                this.b.put(ze1.p, Build.MANUFACTURER);
                                                                                this.b.put("vendor", Build.PRODUCT);
                                                                                this.b.put("device", Build.DEVICE);
                                                                                this.b.put("board", Build.BOARD);
                                                                                this.b.put(ze1.l, Build.HARDWARE);
                                                                                this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                                this.b.put("x5_sdk_ver", q.b());
                                                                                this.b.put("x5_ver", q.a(null));
                                                                                this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                            }
                                                                        } catch (Throwable th33) {
                                                                            strOptString6 = strOptString6;
                                                                            i2 = 0;
                                                                            th = th33;
                                                                            strOptString5 = strOptString5;
                                                                            strOptString2 = "";
                                                                            i = 0;
                                                                            str2 = strOptString14;
                                                                            strOptString10 = strOptString10;
                                                                            strOptString10 = strOptString2;
                                                                            strOptString9 = strOptString11;
                                                                            strZ = strOptString12;
                                                                            strB = strOptString13;
                                                                            iM = iOptInt3;
                                                                            str = strOptString10;
                                                                            r.a(th);
                                                                            i3 = i;
                                                                            str3 = strOptString2;
                                                                            str4 = strOptString5;
                                                                            strQ = strOptString9;
                                                                            strOptString9 = str;
                                                                            strOptString3 = strOptString3;
                                                                            str5 = strOptString7;
                                                                            strOptString8 = strOptString8;
                                                                            int i111 = iOptInt2;
                                                                            strOptString = strOptString;
                                                                            iD = i111;
                                                                            String str113 = str4;
                                                                            this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                            this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                            this.b.put("imei_o", o.d(strQ));
                                                                            this.b.put("uuid_o", x());
                                                                            this.b.put("brand", Build.BRAND);
                                                                            this.b.put(ze1.k, Build.MODEL);
                                                                            this.b.put("package_name", strZ);
                                                                            this.b.put("osv", Build.VERSION.RELEASE);
                                                                            this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                            this.b.put("android_id_o", o.d(strB));
                                                                            this.b.put("device_type", Integer.valueOf(iM));
                                                                            this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                            this.b.put("width", Integer.valueOf(iD));
                                                                            this.b.put("height", Integer.valueOf(iB));
                                                                            this.b.put("operator", strOptString10);
                                                                            this.b.put("app_name", strOptString);
                                                                            this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                            Pair<String, Integer> pairE16 = e();
                                                                            this.b.put("app_ver_name", pairE16.first);
                                                                            this.b.put("app_ver_code", pairE16.second);
                                                                            this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                            this.b.put("ip_address_o", o.d(p()));
                                                                            this.b.put("physical_memory_byte", str5);
                                                                            this.b.put("hard_disk_size_byte", strOptString8);
                                                                            this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                            this.b.put("dpi", strOptString4);
                                                                            this.b.put("ppi", str2);
                                                                            this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                            this.b.put("boot_mark", g());
                                                                            this.b.put("update_mark", H());
                                                                            this.b.put("foreground_background", 1);
                                                                            this.b.put("hms_core", strOptString3);
                                                                            this.b.put("ag_ver", str113);
                                                                            this.b.put("mac_o", o.d(strOptString6));
                                                                            this.b.put("serial_o", o.d(str3));
                                                                            this.b.put("imsi_o", o.d(strOptString10));
                                                                            this.b.put("device_is_root", Integer.valueOf(i2));
                                                                            this.b.put("device_name_o", o.d(strOptString9));
                                                                            this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                            this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                            this.b.put(ze1.p, Build.MANUFACTURER);
                                                                            this.b.put("vendor", Build.PRODUCT);
                                                                            this.b.put("device", Build.DEVICE);
                                                                            this.b.put("board", Build.BOARD);
                                                                            this.b.put(ze1.l, Build.HARDWARE);
                                                                            this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                            this.b.put("x5_sdk_ver", q.b());
                                                                            this.b.put("x5_ver", q.a(null));
                                                                            this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                        }
                                                                    } catch (Throwable th34) {
                                                                        th = th34;
                                                                        strOptString6 = "";
                                                                        i = 0;
                                                                        i2 = 0;
                                                                        strOptString5 = strOptString5;
                                                                        strOptString2 = strOptString6;
                                                                    }
                                                                } catch (Throwable th35) {
                                                                    th = th35;
                                                                    strOptString3 = strOptString3;
                                                                    strOptString2 = "";
                                                                    strOptString5 = strOptString2;
                                                                    strOptString6 = strOptString5;
                                                                    i = 0;
                                                                    i2 = 0;
                                                                    strOptString4 = strOptString4;
                                                                    str2 = strOptString14;
                                                                    strOptString10 = strOptString6;
                                                                    strOptString9 = strOptString11;
                                                                    strZ = strOptString12;
                                                                    strB = strOptString13;
                                                                    iM = iOptInt3;
                                                                    str = strOptString10;
                                                                    r.a(th);
                                                                    i3 = i;
                                                                    str3 = strOptString2;
                                                                    str4 = strOptString5;
                                                                    strQ = strOptString9;
                                                                    strOptString9 = str;
                                                                    strOptString3 = strOptString3;
                                                                    str5 = strOptString7;
                                                                    strOptString8 = strOptString8;
                                                                    int i112 = iOptInt2;
                                                                    strOptString = strOptString;
                                                                    iD = i112;
                                                                    String str114 = str4;
                                                                    this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                                    this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                                    this.b.put("imei_o", o.d(strQ));
                                                                    this.b.put("uuid_o", x());
                                                                    this.b.put("brand", Build.BRAND);
                                                                    this.b.put(ze1.k, Build.MODEL);
                                                                    this.b.put("package_name", strZ);
                                                                    this.b.put("osv", Build.VERSION.RELEASE);
                                                                    this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                                    this.b.put("android_id_o", o.d(strB));
                                                                    this.b.put("device_type", Integer.valueOf(iM));
                                                                    this.b.put("orientation", Integer.valueOf(iOptInt));
                                                                    this.b.put("width", Integer.valueOf(iD));
                                                                    this.b.put("height", Integer.valueOf(iB));
                                                                    this.b.put("operator", strOptString10);
                                                                    this.b.put("app_name", strOptString);
                                                                    this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                                    Pair<String, Integer> pairE17 = e();
                                                                    this.b.put("app_ver_name", pairE17.first);
                                                                    this.b.put("app_ver_code", pairE17.second);
                                                                    this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                                    this.b.put("ip_address_o", o.d(p()));
                                                                    this.b.put("physical_memory_byte", str5);
                                                                    this.b.put("hard_disk_size_byte", strOptString8);
                                                                    this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                                    this.b.put("dpi", strOptString4);
                                                                    this.b.put("ppi", str2);
                                                                    this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                                    this.b.put("boot_mark", g());
                                                                    this.b.put("update_mark", H());
                                                                    this.b.put("foreground_background", 1);
                                                                    this.b.put("hms_core", strOptString3);
                                                                    this.b.put("ag_ver", str114);
                                                                    this.b.put("mac_o", o.d(strOptString6));
                                                                    this.b.put("serial_o", o.d(str3));
                                                                    this.b.put("imsi_o", o.d(strOptString10));
                                                                    this.b.put("device_is_root", Integer.valueOf(i2));
                                                                    this.b.put("device_name_o", o.d(strOptString9));
                                                                    this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                                    this.b.put("is_debuggable", Integer.valueOf(i3));
                                                                    this.b.put(ze1.p, Build.MANUFACTURER);
                                                                    this.b.put("vendor", Build.PRODUCT);
                                                                    this.b.put("device", Build.DEVICE);
                                                                    this.b.put("board", Build.BOARD);
                                                                    this.b.put(ze1.l, Build.HARDWARE);
                                                                    this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                                    this.b.put("x5_sdk_ver", q.b());
                                                                    this.b.put("x5_ver", q.a(null));
                                                                    this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                                }
                                                            } catch (Throwable th36) {
                                                                th = th36;
                                                                strOptString2 = "";
                                                                strOptString3 = strOptString2;
                                                                strOptString5 = strOptString3;
                                                            }
                                                        } catch (Throwable th37) {
                                                            this = this;
                                                            th = th37;
                                                            iOptInt = iOptInt;
                                                            strOptString = strOptString;
                                                            iOptInt2 = iOptInt2;
                                                            iB = iB;
                                                            strOptString8 = strOptString8;
                                                            strOptString7 = strOptString7;
                                                            strOptString2 = "";
                                                            strOptString3 = strOptString2;
                                                            strOptString5 = strOptString3;
                                                            strOptString6 = strOptString5;
                                                            strOptString10 = strOptString10;
                                                            i = 0;
                                                            i2 = 0;
                                                            strOptString4 = strOptString4;
                                                            str2 = strOptString6;
                                                            strOptString10 = str2;
                                                        }
                                                    } catch (Throwable th38) {
                                                        this = this;
                                                        th = th38;
                                                        iOptInt = iOptInt;
                                                        strOptString = strOptString;
                                                        iOptInt2 = iOptInt2;
                                                        iB = iB;
                                                        strOptString8 = strOptString8;
                                                        strOptString7 = strOptString7;
                                                        strOptString2 = "";
                                                        str2 = strOptString2;
                                                        strOptString3 = str2;
                                                        strOptString4 = strOptString3;
                                                        strOptString5 = strOptString4;
                                                        strOptString6 = strOptString5;
                                                        i = 0;
                                                        i2 = 0;
                                                    }
                                                } catch (Throwable th39) {
                                                    this = this;
                                                    th = th39;
                                                    iOptInt = iOptInt;
                                                    strOptString = strOptString;
                                                    iOptInt2 = iOptInt2;
                                                    iB = iB;
                                                    strOptString7 = strOptString7;
                                                    strOptString2 = "";
                                                    str2 = strOptString2;
                                                    strOptString3 = str2;
                                                    strOptString4 = strOptString3;
                                                    strOptString5 = strOptString4;
                                                    strOptString6 = strOptString5;
                                                    strOptString8 = strOptString6;
                                                    strOptString10 = strOptString10;
                                                    i = 0;
                                                    i2 = 0;
                                                    strOptString10 = strOptString8;
                                                    strOptString9 = strOptString11;
                                                    strZ = strOptString12;
                                                    strB = strOptString13;
                                                    iM = iOptInt3;
                                                    str = strOptString10;
                                                    r.a(th);
                                                    i3 = i;
                                                    str3 = strOptString2;
                                                    str4 = strOptString5;
                                                    strQ = strOptString9;
                                                    strOptString9 = str;
                                                    strOptString3 = strOptString3;
                                                    str5 = strOptString7;
                                                    strOptString8 = strOptString8;
                                                    int i113 = iOptInt2;
                                                    strOptString = strOptString;
                                                    iD = i113;
                                                    String str115 = str4;
                                                    this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                    this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                    this.b.put("imei_o", o.d(strQ));
                                                    this.b.put("uuid_o", x());
                                                    this.b.put("brand", Build.BRAND);
                                                    this.b.put(ze1.k, Build.MODEL);
                                                    this.b.put("package_name", strZ);
                                                    this.b.put("osv", Build.VERSION.RELEASE);
                                                    this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                    this.b.put("android_id_o", o.d(strB));
                                                    this.b.put("device_type", Integer.valueOf(iM));
                                                    this.b.put("orientation", Integer.valueOf(iOptInt));
                                                    this.b.put("width", Integer.valueOf(iD));
                                                    this.b.put("height", Integer.valueOf(iB));
                                                    this.b.put("operator", strOptString10);
                                                    this.b.put("app_name", strOptString);
                                                    this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                    Pair<String, Integer> pairE18 = e();
                                                    this.b.put("app_ver_name", pairE18.first);
                                                    this.b.put("app_ver_code", pairE18.second);
                                                    this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                    this.b.put("ip_address_o", o.d(p()));
                                                    this.b.put("physical_memory_byte", str5);
                                                    this.b.put("hard_disk_size_byte", strOptString8);
                                                    this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                    this.b.put("dpi", strOptString4);
                                                    this.b.put("ppi", str2);
                                                    this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                    this.b.put("boot_mark", g());
                                                    this.b.put("update_mark", H());
                                                    this.b.put("foreground_background", 1);
                                                    this.b.put("hms_core", strOptString3);
                                                    this.b.put("ag_ver", str115);
                                                    this.b.put("mac_o", o.d(strOptString6));
                                                    this.b.put("serial_o", o.d(str3));
                                                    this.b.put("imsi_o", o.d(strOptString10));
                                                    this.b.put("device_is_root", Integer.valueOf(i2));
                                                    this.b.put("device_name_o", o.d(strOptString9));
                                                    this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                    this.b.put("is_debuggable", Integer.valueOf(i3));
                                                    this.b.put(ze1.p, Build.MANUFACTURER);
                                                    this.b.put("vendor", Build.PRODUCT);
                                                    this.b.put("device", Build.DEVICE);
                                                    this.b.put("board", Build.BOARD);
                                                    this.b.put(ze1.l, Build.HARDWARE);
                                                    this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                    this.b.put("x5_sdk_ver", q.b());
                                                    this.b.put("x5_ver", q.a(null));
                                                    this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                                }
                                            } catch (Throwable th40) {
                                                th = th40;
                                                strOptString = strOptString;
                                                strOptString2 = "";
                                                str2 = strOptString2;
                                                strOptString3 = str2;
                                                strOptString4 = strOptString3;
                                                strOptString5 = strOptString4;
                                                strOptString6 = strOptString5;
                                                strOptString7 = strOptString6;
                                                strOptString8 = strOptString7;
                                                strOptString10 = strOptString10;
                                                i = 0;
                                                i2 = 0;
                                                strOptString10 = strOptString8;
                                                strOptString9 = strOptString11;
                                                strZ = strOptString12;
                                                strB = strOptString13;
                                                iM = iOptInt3;
                                                str = strOptString10;
                                                r.a(th);
                                                i3 = i;
                                                str3 = strOptString2;
                                                str4 = strOptString5;
                                                strQ = strOptString9;
                                                strOptString9 = str;
                                                strOptString3 = strOptString3;
                                                str5 = strOptString7;
                                                strOptString8 = strOptString8;
                                                int i114 = iOptInt2;
                                                strOptString = strOptString;
                                                iD = i114;
                                                String str116 = str4;
                                                this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                                this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                                this.b.put("imei_o", o.d(strQ));
                                                this.b.put("uuid_o", x());
                                                this.b.put("brand", Build.BRAND);
                                                this.b.put(ze1.k, Build.MODEL);
                                                this.b.put("package_name", strZ);
                                                this.b.put("osv", Build.VERSION.RELEASE);
                                                this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                                this.b.put("android_id_o", o.d(strB));
                                                this.b.put("device_type", Integer.valueOf(iM));
                                                this.b.put("orientation", Integer.valueOf(iOptInt));
                                                this.b.put("width", Integer.valueOf(iD));
                                                this.b.put("height", Integer.valueOf(iB));
                                                this.b.put("operator", strOptString10);
                                                this.b.put("app_name", strOptString);
                                                this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                                Pair<String, Integer> pairE19 = e();
                                                this.b.put("app_ver_name", pairE19.first);
                                                this.b.put("app_ver_code", pairE19.second);
                                                this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                                this.b.put("ip_address_o", o.d(p()));
                                                this.b.put("physical_memory_byte", str5);
                                                this.b.put("hard_disk_size_byte", strOptString8);
                                                this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                                this.b.put("dpi", strOptString4);
                                                this.b.put("ppi", str2);
                                                this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                                this.b.put("boot_mark", g());
                                                this.b.put("update_mark", H());
                                                this.b.put("foreground_background", 1);
                                                this.b.put("hms_core", strOptString3);
                                                this.b.put("ag_ver", str116);
                                                this.b.put("mac_o", o.d(strOptString6));
                                                this.b.put("serial_o", o.d(str3));
                                                this.b.put("imsi_o", o.d(strOptString10));
                                                this.b.put("device_is_root", Integer.valueOf(i2));
                                                this.b.put("device_name_o", o.d(strOptString9));
                                                this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                                this.b.put("is_debuggable", Integer.valueOf(i3));
                                                this.b.put(ze1.p, Build.MANUFACTURER);
                                                this.b.put("vendor", Build.PRODUCT);
                                                this.b.put("device", Build.DEVICE);
                                                this.b.put("board", Build.BOARD);
                                                this.b.put(ze1.l, Build.HARDWARE);
                                                this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                                this.b.put("x5_sdk_ver", q.b());
                                                this.b.put("x5_ver", q.a(null));
                                                this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                            }
                                        } catch (Throwable th41) {
                                            th = th41;
                                            strOptString = "";
                                            strOptString2 = strOptString;
                                        }
                                    } catch (Throwable th42) {
                                        this = this;
                                        th = th42;
                                        iOptInt = iOptInt;
                                        iOptInt2 = iOptInt2;
                                        strOptString = "";
                                        strOptString2 = strOptString;
                                        str2 = strOptString2;
                                        strOptString3 = str2;
                                        strOptString4 = strOptString3;
                                        strOptString5 = strOptString4;
                                        strOptString6 = strOptString5;
                                        strOptString7 = strOptString6;
                                        strOptString8 = strOptString7;
                                        strOptString10 = "0";
                                        i = 0;
                                        iB = 0;
                                        i2 = 0;
                                        strOptString10 = strOptString8;
                                        strOptString9 = strOptString11;
                                        strZ = strOptString12;
                                        strB = strOptString13;
                                        iM = iOptInt3;
                                        str = strOptString10;
                                        r.a(th);
                                        i3 = i;
                                        str3 = strOptString2;
                                        str4 = strOptString5;
                                        strQ = strOptString9;
                                        strOptString9 = str;
                                        strOptString3 = strOptString3;
                                        str5 = strOptString7;
                                        strOptString8 = strOptString8;
                                        int i115 = iOptInt2;
                                        strOptString = strOptString;
                                        iD = i115;
                                        String str117 = str4;
                                        this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                        this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                        this.b.put("imei_o", o.d(strQ));
                                        this.b.put("uuid_o", x());
                                        this.b.put("brand", Build.BRAND);
                                        this.b.put(ze1.k, Build.MODEL);
                                        this.b.put("package_name", strZ);
                                        this.b.put("osv", Build.VERSION.RELEASE);
                                        this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                        this.b.put("android_id_o", o.d(strB));
                                        this.b.put("device_type", Integer.valueOf(iM));
                                        this.b.put("orientation", Integer.valueOf(iOptInt));
                                        this.b.put("width", Integer.valueOf(iD));
                                        this.b.put("height", Integer.valueOf(iB));
                                        this.b.put("operator", strOptString10);
                                        this.b.put("app_name", strOptString);
                                        this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                        Pair<String, Integer> pairE110 = e();
                                        this.b.put("app_ver_name", pairE110.first);
                                        this.b.put("app_ver_code", pairE110.second);
                                        this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                        this.b.put("ip_address_o", o.d(p()));
                                        this.b.put("physical_memory_byte", str5);
                                        this.b.put("hard_disk_size_byte", strOptString8);
                                        this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                        this.b.put("dpi", strOptString4);
                                        this.b.put("ppi", str2);
                                        this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                        this.b.put("boot_mark", g());
                                        this.b.put("update_mark", H());
                                        this.b.put("foreground_background", 1);
                                        this.b.put("hms_core", strOptString3);
                                        this.b.put("ag_ver", str117);
                                        this.b.put("mac_o", o.d(strOptString6));
                                        this.b.put("serial_o", o.d(str3));
                                        this.b.put("imsi_o", o.d(strOptString10));
                                        this.b.put("device_is_root", Integer.valueOf(i2));
                                        this.b.put("device_name_o", o.d(strOptString9));
                                        this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                        this.b.put("is_debuggable", Integer.valueOf(i3));
                                        this.b.put(ze1.p, Build.MANUFACTURER);
                                        this.b.put("vendor", Build.PRODUCT);
                                        this.b.put("device", Build.DEVICE);
                                        this.b.put("board", Build.BOARD);
                                        this.b.put(ze1.l, Build.HARDWARE);
                                        this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                        this.b.put("x5_sdk_ver", q.b());
                                        this.b.put("x5_ver", q.a(null));
                                        this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                    }
                                } catch (Throwable th43) {
                                    th = th43;
                                    iOptInt = iOptInt;
                                    strOptString = "";
                                    strOptString2 = strOptString;
                                    str2 = strOptString2;
                                    strOptString3 = str2;
                                    strOptString4 = strOptString3;
                                    strOptString5 = strOptString4;
                                    strOptString6 = strOptString5;
                                    strOptString7 = strOptString6;
                                    strOptString8 = strOptString7;
                                    i = 0;
                                    iOptInt2 = 0;
                                    iB = 0;
                                    i2 = 0;
                                    strOptString10 = strOptString8;
                                    strOptString9 = strOptString11;
                                    strZ = strOptString12;
                                    strB = strOptString13;
                                    iM = iOptInt3;
                                    str = strOptString10;
                                    r.a(th);
                                    i3 = i;
                                    str3 = strOptString2;
                                    str4 = strOptString5;
                                    strQ = strOptString9;
                                    strOptString9 = str;
                                    strOptString3 = strOptString3;
                                    str5 = strOptString7;
                                    strOptString8 = strOptString8;
                                    int i116 = iOptInt2;
                                    strOptString = strOptString;
                                    iD = i116;
                                    String str118 = str4;
                                    this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
                                    this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
                                    this.b.put("imei_o", o.d(strQ));
                                    this.b.put("uuid_o", x());
                                    this.b.put("brand", Build.BRAND);
                                    this.b.put(ze1.k, Build.MODEL);
                                    this.b.put("package_name", strZ);
                                    this.b.put("osv", Build.VERSION.RELEASE);
                                    this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
                                    this.b.put("android_id_o", o.d(strB));
                                    this.b.put("device_type", Integer.valueOf(iM));
                                    this.b.put("orientation", Integer.valueOf(iOptInt));
                                    this.b.put("width", Integer.valueOf(iD));
                                    this.b.put("height", Integer.valueOf(iB));
                                    this.b.put("operator", strOptString10);
                                    this.b.put("app_name", strOptString);
                                    this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
                                    Pair<String, Integer> pairE111 = e();
                                    this.b.put("app_ver_name", pairE111.first);
                                    this.b.put("app_ver_code", pairE111.second);
                                    this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
                                    this.b.put("ip_address_o", o.d(p()));
                                    this.b.put("physical_memory_byte", str5);
                                    this.b.put("hard_disk_size_byte", strOptString8);
                                    this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
                                    this.b.put("dpi", strOptString4);
                                    this.b.put("ppi", str2);
                                    this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
                                    this.b.put("boot_mark", g());
                                    this.b.put("update_mark", H());
                                    this.b.put("foreground_background", 1);
                                    this.b.put("hms_core", strOptString3);
                                    this.b.put("ag_ver", str118);
                                    this.b.put("mac_o", o.d(strOptString6));
                                    this.b.put("serial_o", o.d(str3));
                                    this.b.put("imsi_o", o.d(strOptString10));
                                    this.b.put("device_is_root", Integer.valueOf(i2));
                                    this.b.put("device_name_o", o.d(strOptString9));
                                    this.b.put("wx_open_sdk", Integer.valueOf(J()));
                                    this.b.put("is_debuggable", Integer.valueOf(i3));
                                    this.b.put(ze1.p, Build.MANUFACTURER);
                                    this.b.put("vendor", Build.PRODUCT);
                                    this.b.put("device", Build.DEVICE);
                                    this.b.put("board", Build.BOARD);
                                    this.b.put(ze1.l, Build.HARDWARE);
                                    this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
                                    this.b.put("x5_sdk_ver", q.b());
                                    this.b.put("x5_ver", q.a(null));
                                    this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
                                }
                            } catch (Throwable th44) {
                                th = th44;
                                strOptString = "";
                                strOptString2 = strOptString;
                                str2 = strOptString2;
                                strOptString3 = str2;
                                strOptString4 = strOptString3;
                                strOptString5 = strOptString4;
                                strOptString6 = strOptString5;
                                strOptString7 = strOptString6;
                                strOptString8 = strOptString7;
                                i = 0;
                                iOptInt = 1;
                            }
                        } catch (Throwable th45) {
                            this = this;
                            th = th45;
                            strOptString = "";
                            strOptString2 = strOptString;
                            str = strOptString2;
                            str2 = str;
                            strOptString3 = str2;
                            strOptString4 = strOptString3;
                            strOptString5 = strOptString4;
                            strOptString6 = strOptString5;
                            strOptString7 = strOptString6;
                            strOptString8 = strOptString7;
                            strOptString10 = "0";
                            i = 0;
                            iOptInt = 1;
                            iOptInt2 = 0;
                            iB = 0;
                            i2 = 0;
                            strOptString10 = strOptString8;
                            strOptString9 = strOptString11;
                            strZ = strOptString12;
                            strB = strOptString13;
                            iM = 1;
                        }
                    } catch (Throwable th46) {
                        this = this;
                        th = th46;
                        strOptString = "";
                        strOptString2 = strOptString;
                        str = strOptString2;
                        str2 = str;
                        strOptString3 = str2;
                        strOptString4 = strOptString3;
                        strOptString5 = strOptString4;
                        strOptString6 = strOptString5;
                        strOptString7 = strOptString6;
                        strOptString8 = strOptString7;
                        strOptString10 = "0";
                        i = 0;
                        iOptInt = 1;
                        iOptInt2 = 0;
                        iB = 0;
                        iM = 1;
                        i2 = 0;
                        strOptString10 = strOptString8;
                        strOptString9 = strOptString11;
                        strZ = strOptString12;
                        strB = strOptString10;
                    }
                } catch (Throwable th47) {
                    this = this;
                    th = th47;
                    strOptString = "";
                    strOptString2 = strOptString;
                    strB = strOptString2;
                    str = strB;
                    str2 = str;
                    strOptString3 = str2;
                    strOptString4 = strOptString3;
                    strOptString5 = strOptString4;
                    strOptString6 = strOptString5;
                    strOptString7 = strOptString6;
                    strOptString8 = strOptString7;
                    strOptString10 = "0";
                    i = 0;
                    iOptInt = 1;
                    iOptInt2 = 0;
                    iB = 0;
                    iM = 1;
                    i2 = 0;
                    strOptString10 = strOptString8;
                    strOptString9 = strOptString11;
                    strZ = strOptString10;
                }
            }
        } catch (Throwable th48) {
            this = this;
            th = th48;
            strOptString = strOptString9;
            strOptString2 = strOptString;
            strB = strOptString2;
            strZ = strB;
            str = strZ;
            str2 = str;
            strOptString3 = str2;
            strOptString4 = strOptString3;
            strOptString5 = strOptString4;
            strOptString6 = strOptString5;
            strOptString7 = strOptString6;
            strOptString8 = strOptString7;
            strOptString10 = strOptString10;
            i = 0;
            iOptInt = 1;
            iOptInt2 = 0;
            iB = 0;
            iM = 1;
            i2 = 0;
            strOptString10 = strOptString8;
        }
        try {
            String str119 = str4;
            this.b.put("version_code", Long.valueOf(com.ipd.dsp.internal.z1.a.f));
            this.b.put(HiAnalyticsConstant.BI_KEY_SDK_VER, Dsp.getSDKVersion());
            this.b.put("imei_o", o.d(strQ));
            this.b.put("uuid_o", x());
            this.b.put("brand", Build.BRAND);
            this.b.put(ze1.k, Build.MODEL);
            this.b.put("package_name", strZ);
            this.b.put("osv", Build.VERSION.RELEASE);
            this.b.put("osl", Integer.valueOf(Build.VERSION.SDK_INT));
            this.b.put("android_id_o", o.d(strB));
            this.b.put("device_type", Integer.valueOf(iM));
            this.b.put("orientation", Integer.valueOf(iOptInt));
            this.b.put("width", Integer.valueOf(iD));
            this.b.put("height", Integer.valueOf(iB));
            this.b.put("operator", strOptString10);
            this.b.put("app_name", strOptString);
            this.b.put(RequestParameters.SUBRESOURCE_LOCATION, s());
            Pair<String, Integer> pairE112 = e();
            this.b.put("app_ver_name", pairE112.first);
            this.b.put("app_ver_code", pairE112.second);
            this.b.put(xh9.WEBSITE_PARAMS_CHANNEL, 2);
            this.b.put("ip_address_o", o.d(p()));
            this.b.put("physical_memory_byte", str5);
            this.b.put("hard_disk_size_byte", strOptString8);
            this.b.put("device_start_sec", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
            this.b.put("dpi", strOptString4);
            this.b.put("ppi", str2);
            this.b.put("sys_compiling_ms", Long.valueOf(Build.TIME));
            this.b.put("boot_mark", g());
            this.b.put("update_mark", H());
            this.b.put("foreground_background", 1);
            this.b.put("hms_core", strOptString3);
            this.b.put("ag_ver", str119);
            this.b.put("mac_o", o.d(strOptString6));
            this.b.put("serial_o", o.d(str3));
            this.b.put("imsi_o", o.d(strOptString10));
            this.b.put("device_is_root", Integer.valueOf(i2));
            this.b.put("device_name_o", o.d(strOptString9));
            this.b.put("wx_open_sdk", Integer.valueOf(J()));
            this.b.put("is_debuggable", Integer.valueOf(i3));
            this.b.put(ze1.p, Build.MANUFACTURER);
            this.b.put("vendor", Build.PRODUCT);
            this.b.put("device", Build.DEVICE);
            this.b.put("board", Build.BOARD);
            this.b.put(ze1.l, Build.HARDWARE);
            this.b.put("x5_env", Integer.valueOf(q.a() ? 1 : 0));
            this.b.put("x5_sdk_ver", q.b());
            this.b.put("x5_ver", q.a(null));
            this.b.put("reboot_sec", Long.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
        } catch (Throwable th49) {
            r.a(th49);
        }
    }

    public void b(String str) {
        this.c = str;
    }

    public final String b() {
        DspCustomController dspCustomController = this.f38224a;
        if (dspCustomController != null && !dspCustomController.canUseAndroidId()) {
            String androidId = this.f38224a.getAndroidId();
            return androidId == null ? "" : androidId;
        }
        Context context = Dsp.getContext();
        if (context != null) {
            try {
                return Settings.System.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return "";
    }

    public int a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final String a(int i) {
        return (i & 255) + Consts.DOT + ((i >> 8) & 255) + Consts.DOT + ((i >> 16) & 255) + Consts.DOT + ((i >> 24) & 255);
    }

    public final JSONArray a(int i, boolean z, @Nullable List<Integer> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(new JSONObject().put("type", "meituan").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.b, z, list)));
            jSONArray.put(new JSONObject().put("type", "meituantakeout").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.c, z, list)));
            jSONArray.put(new JSONObject().put("type", "dianping").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.d, z, list)));
            jSONArray.put(new JSONObject().put("type", "taobao").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.e, z, list)));
            jSONArray.put(new JSONObject().put("type", "jd").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.i, z, list)));
            jSONArray.put(new JSONObject().put("type", "pinduoduo").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.j, z, list)));
            jSONArray.put(new JSONObject().put("type", "kuaishou").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.k, z, list)));
            jSONArray.put(new JSONObject().put("type", "kuaishou_lite").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.l, z, list)));
            jSONArray.put(new JSONObject().put("type", "douyin").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.m, z, list)));
            jSONArray.put(new JSONObject().put("type", "douyin_lite").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.n, z, list)));
            jSONArray.put(new JSONObject().put("type", nl0.WEIXIN_PRE).put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.o, z, list)));
            jSONArray.put(new JSONObject().put("type", "alipay").put("inst_status", i));
            jSONArray.put(new JSONObject().put("type", "weibo").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.p, z, list)));
            jSONArray.put(new JSONObject().put("type", "weibo_lite").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.q, z, list)));
            jSONArray.put(new JSONObject().put("type", "xhs").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.r, z, list)));
            jSONArray.put(new JSONObject().put("type", "toutiao").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.s, z, list)));
            jSONArray.put(new JSONObject().put("type", "toutiao_lite").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.t, z, list)));
            jSONArray.put(new JSONObject().put("type", "xigua").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.u, z, list)));
            jSONArray.put(new JSONObject().put("type", "bili").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.v, z, list)));
            jSONArray.put(new JSONObject().put("type", "fanqienovel").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.w, z, list)));
            jSONArray.put(new JSONObject().put("type", "baidu").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.x, z, list)));
            jSONArray.put(new JSONObject().put("type", "baidu_lite").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.y, z, list)));
            jSONArray.put(new JSONObject().put("type", "ctrip").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.z, z, list)));
            jSONArray.put(new JSONObject().put("type", "qunar").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.A, z, list)));
            jSONArray.put(new JSONObject().put("type", "vipshop").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.B, z, list)));
            jSONArray.put(new JSONObject().put("type", "duapp").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.C, z, list)));
            jSONArray.put(new JSONObject().put("type", "tmall").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.f, z, list)));
            jSONArray.put(new JSONObject().put("type", "idlefish").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.g, z, list)));
            jSONArray.put(new JSONObject().put("type", "eleme").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.h, z, list)));
            jSONArray.put(new JSONObject().put("type", "didi").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.D, z, list)));
            jSONArray.put(new JSONObject().put("type", "quark_browser").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.E, z, list)));
            jSONArray.put(new JSONObject().put("type", "luckycoffee").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.F, z, list)));
            jSONArray.put(new JSONObject().put("type", "starbucks").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.G, z, list)));
            jSONArray.put(new JSONObject().put("type", "unipay").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.H, z, list)));
            jSONArray.put(new JSONObject().put("type", "ne_cloudmusic").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.I, z, list)));
            jSONArray.put(new JSONObject().put("type", "youku").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.J, z, list)));
            jSONArray.put(new JSONObject().put("type", "dingdong").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.K, z, list)));
            jSONArray.put(new JSONObject().put("type", "smzdm").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.L, z, list)));
            jSONArray.put(new JSONObject().put("type", "douyin_merchant").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.M, z, list)));
            jSONArray.put(new JSONObject().put("type", "wawj").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.N, z, list)));
            jSONArray.put(new JSONObject().put("type", "ziroom").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.O, z, list)));
            jSONArray.put(new JSONObject().put("type", "homelink").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.P, z, list)));
            jSONArray.put(new JSONObject().put("type", "beike").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.Q, z, list)));
            jSONArray.put(new JSONObject().put("type", "anjuke").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.R, z, list)));
            jSONArray.put(new JSONObject().put("type", "fangdd").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.S, z, list)));
            jSONArray.put(new JSONObject().put("type", "fangtx").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.T, z, list)));
            jSONArray.put(new JSONObject().put("type", "cainiao").put("inst_status", com.ipd.dsp.internal.c2.a.a(com.ipd.dsp.internal.c2.a.U, z, list)));
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public final JSONArray a(boolean z, @Nullable List<String> list) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        JSONArray jSONArray = new JSONArray();
        try {
            if (z) {
                Context context = com.ipd.dsp.internal.l1.a.a().getContext();
                if (context != null && ((Build.VERSION.SDK_INT < 30 || context.checkPermission("android.permission.QUERY_ALL_PACKAGES", Process.myPid(), Process.myUid()) == 0) && (packageManager = context.getPackageManager()) != null)) {
                    List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
                    if (!installedPackages.isEmpty()) {
                        for (PackageInfo packageInfo : installedPackages) {
                            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                                int i = applicationInfo.flags;
                                if ((i & 1) == 0 && (i & 2) == 0) {
                                    String str = packageInfo.packageName;
                                    if (o.c(str)) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put(com.igexin.push.core.b.aC, str);
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (list != null && !list.isEmpty()) {
                for (String str2 : list) {
                    if (o.c(str2)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(com.igexin.push.core.b.aC, str2);
                        jSONArray.put(jSONObject2);
                    }
                }
            }
        } catch (Throwable th) {
            r.a(th);
        }
        return jSONArray;
    }
}
