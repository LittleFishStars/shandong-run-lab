package com.getui.gtc.dim.c;

import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.getui.gtc.dim.DimRequest;
import com.getui.gtc.dim.bean.GtLocation;
import com.getui.gtc.dim.bean.GtWifiInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f30318a = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.b.1
        {
            put("dim-2-1-18-4", "dim-2-1-18-1");
            put("dim-2-1-18-3", "dim-2-1-18-4");
            put("dim-2-1-17-3", "dim-2-1-17-1");
            put("dim-2-1-17-4", "dim-2-1-17-2");
            put("dim-2-1-5-2", "dim-2-1-5-1");
        }
    };

    public static Object a(DimRequest dimRequest) {
        return !"HONOR".equals(d.d) ? "" : b(dimRequest);
    }

    public static String a(Context context, DimRequest dimRequest) {
        try {
            GtWifiInfo json = GtWifiInfo.parseJson((String) b(dimRequest));
            return a.b(context, json != null ? json.getSSID() : "");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return null;
        }
    }

    public static String a(DimRequest dimRequest, int i) {
        String strA = null;
        try {
            com.getui.gtc.dim.e.b.a("get " + dimRequest.getKey() + " policy:" + i);
            WifiInfo wifiInfo = (WifiInfo) b(dimRequest);
            if (wifiInfo != null) {
                if (i == 0) {
                    return new GtWifiInfo(wifiInfo).toJsonString();
                }
                if (i == 1) {
                    return e.a(wifiInfo);
                }
                try {
                    strA = e.a(wifiInfo);
                    if (TextUtils.isEmpty(strA)) {
                        return new GtWifiInfo(wifiInfo).toJsonString();
                    }
                } catch (Throwable th) {
                    if (TextUtils.isEmpty(null)) {
                        new GtWifiInfo(wifiInfo).toJsonString();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.b(th2);
        }
        return strA;
    }

    private static Object b(DimRequest dimRequest) {
        String str = f30318a.get(dimRequest.getKey());
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.getui.gtc.dim.a.C0649a.f30300a.a(new DimRequest.Builder(dimRequest).key(str).build(), false);
    }

    public static String b(DimRequest dimRequest, int i) {
        String strA = null;
        try {
            com.getui.gtc.dim.e.b.a("get " + dimRequest.getKey() + " policy:" + i);
            Location location = (Location) b(dimRequest);
            if (location != null) {
                if (i == 0) {
                    return new GtLocation(location).toJsonString();
                }
                if (i == 1) {
                    return c.a(location);
                }
                try {
                    strA = c.a(location);
                    if (TextUtils.isEmpty(strA)) {
                        return new GtLocation(location).toJsonString();
                    }
                } catch (Throwable th) {
                    if (TextUtils.isEmpty(null)) {
                        new GtLocation(location).toJsonString();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.b(th2);
        }
        return strA;
    }
}
