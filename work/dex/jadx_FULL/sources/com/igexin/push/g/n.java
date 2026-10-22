package com.igexin.push.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaDrm;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.getui.gtc.api.GtcManager;
import com.getui.gtc.api.OnDycEnableChangedListener;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimManager;
import com.getui.gtc.dim.DimRequest;
import com.getui.gtc.dim.bean.GtWifiInfo;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38155a = "PhoneInfoUtils";
    public static final String b = "";
    static boolean c = false;
    private static volatile PackageInfo d;
    private static String e;

    public static int a(Context context) {
        try {
            return c(context).applicationInfo.targetSdkVersion;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return 0;
        }
    }

    private static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
            String str3 = "";
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return str3;
                }
                str3 = str3 + line;
            }
        } catch (Exception unused) {
            return str2;
        }
    }

    public static List<PackageInfo> a() {
        List<PackageInfo> list;
        try {
            list = (List) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.O).caller(Caller.PUSH).build());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            list = null;
        }
        return list == null ? Collections.emptyList() : list;
    }

    public static ApplicationInfo b(Context context) {
        try {
            return c(context).applicationInfo;
        } catch (PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static Pair<String, String> b() {
        try {
            if (!com.igexin.push.config.d.X || d.b("3.1.12.0")) {
                com.igexin.c.a.c.a.b(f38155a, "use wf");
                WifiInfo wifiInfo = (WifiInfo) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.F).caller(Caller.PUSH).build());
                if (wifiInfo == null) {
                    return null;
                }
                return Pair.create(wifiInfo.getSSID(), wifiInfo.getBSSID());
            }
            com.igexin.c.a.c.a.b(f38155a, "use gt wf");
            GtWifiInfo json = GtWifiInfo.parseJson((String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.I).caller(Caller.PUSH).build()));
            if (json == null) {
                return null;
            }
            return Pair.create(json.getSSID(), json.getBSSID());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    private static PackageInfo c(Context context) throws PackageManager.NameNotFoundException {
        if (d != null) {
            com.igexin.c.a.c.a.b(f38155a, "getSelfPackageInfo cache");
            return d;
        }
        synchronized (n.class) {
            if (d == null) {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                com.igexin.c.a.c.a.b(f38155a, "getSelfPackageInfo");
            }
        }
        return d;
    }

    public static String c() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.j).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static String d() {
        return Build.BRAND;
    }

    public static String e() {
        return Build.MODEL;
    }

    public static String f() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.f).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static String g() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.b).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static String h() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.q).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static String i() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.r).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static List<ScanResult> j() {
        try {
            return (List) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.G).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static String k() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static boolean l() {
        try {
            if (!com.igexin.push.config.d.G.contains("*")) {
                return Arrays.asList(com.igexin.push.config.d.G.toUpperCase().split(",")).contains(Build.BRAND.toUpperCase());
            }
            com.igexin.c.a.c.a.a("PhoneInfoUtils|delAlarm all", new Object[0]);
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PhoneInfoUtils|delAlarm " + com.igexin.push.config.d.G + " err " + e2.toString(), new Object[0]);
            return false;
        }
    }

    public static String m() {
        String str;
        try {
            str = (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.l).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            str = null;
        }
        if (!TextUtils.isEmpty(str) && !str.equals(com.igexin.push.core.e.h)) {
            com.igexin.push.core.e.h = str;
        }
        return str;
    }

    public static String n() {
        try {
            return c(com.igexin.push.core.e.l).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static long o() {
        try {
            return c(com.igexin.push.core.e.l).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return 0L;
        }
    }

    public static String p() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.H).caller(Caller.PUSH).build());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a("PhoneInfoUtils|".concat(String.valueOf(th)), new Object[0]);
            return "";
        }
    }

    public static String q() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Error | Exception unused) {
            return "";
        }
    }

    public static Location r() {
        try {
            return (Location) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.B).caller(Caller.PUSH).build());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Location s() {
        try {
            return (Location) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.C).caller(Caller.PUSH).build());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String t() {
        try {
            Context context = com.igexin.push.core.e.l;
            if (!CommonUtil.hasPermission(context, "android.permission.READ_PHONE_STATE", false)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            switch (telephonyManager != null ? telephonyManager.getDataNetworkType() : 0) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3";
                case 13:
                case 18:
                case 19:
                    return "4";
                case 16:
                default:
                    return "";
                case 20:
                    return "5";
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static void u() {
        if (d.b("3.2.16.0")) {
            return;
        }
        GtcManager.getInstance().addOnDycEnableChangedListener(com.igexin.push.core.e.l, new OnDycEnableChangedListener.Stub() { // from class: com.igexin.push.g.n.1
            @Override // com.getui.gtc.api.OnDycEnableChangedListener
            public final void onDycEnableChanged(final Map map) throws RemoteException {
                if (map == null || n.c) {
                    return;
                }
                n.c = true;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.d() { // from class: com.igexin.push.g.n.1.1
                    @Override // com.igexin.push.f.d
                    public final void b() {
                        try {
                            Iterator it = map.keySet().iterator();
                            while (it.hasNext()) {
                                com.igexin.c.a.c.a.b(n.f38155a, String.valueOf(it.next()));
                            }
                            Object obj = map.get(f.a.l);
                            Boolean bool = Boolean.TRUE;
                            if (Objects.equals(obj, bool)) {
                                if (com.igexin.push.core.e.u) {
                                    com.igexin.push.core.a.b.d().i();
                                } else {
                                    com.igexin.push.core.e.aM = true;
                                }
                            }
                            if (Objects.equals(map.get(f.a.O), bool)) {
                                com.igexin.push.core.c.a.a().a(false);
                            }
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }, false, true);
            }
        });
    }

    private static String v() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.e).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    private static String w() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String lowerCase = str.toLowerCase();
            HashMap map = new HashMap();
            map.put(AssistUtils.BRAND_HW, "ro.build.version.emui");
            map.put("blackshark", com.blankj.utilcode.util.e.c);
            map.put("redmi", com.blankj.utilcode.util.e.c);
            map.put("xiaomi", com.blankj.utilcode.util.e.c);
            map.put("samsang", com.blankj.utilcode.util.e.c);
            map.put("vivo", "ro.vivo.os.version");
            map.put("oppo", com.blankj.utilcode.util.e.d);
            map.put(AssistUtils.BRAND_MZ, "ro.build.display.id");
            map.put("lenovo", com.blankj.utilcode.util.e.c);
            map.put("smartisan", "ro.modversion");
            map.put("htc", "ro.build.sense.version");
            map.put("oneplus", com.blankj.utilcode.util.e.h);
            map.put("yunos", "ro.cta.yunos.version");
            map.put("360", com.blankj.utilcode.util.e.f);
            map.put("nubia", "ro.build.rom.internal.id");
            if (map.containsKey(lowerCase)) {
                String strA = a((String) map.get(lowerCase), "");
                e = strA;
                return strA;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return "";
    }

    private static boolean x() {
        return Build.VERSION.SDK_INT > 28;
    }

    private static String y() {
        return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.u).caller(Caller.PUSH).build());
    }

    private static String z() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.J).caller(Caller.PUSH).build());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }
}
