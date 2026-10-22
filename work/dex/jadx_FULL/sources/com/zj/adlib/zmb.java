package com.zj.adlib;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.ad.RcSdk;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class zmb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static zmb f46298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f21093a = RcSdk.e();

    public static zmb a() {
        if (f46298a == null) {
            synchronized (zmb.class) {
                if (f46298a == null) {
                    f46298a = new zmb();
                }
            }
        }
        return f46298a;
    }

    public static boolean d() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            ArrayList list = Collections.list(networkInterfaces);
            if (list.isEmpty()) {
                return false;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String name = ((NetworkInterface) it.next()).getName();
                if (name != null && (name.equals("tun0") || name.equals("ppp0"))) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return false;
    }

    public static boolean e() {
        try {
            return (TextUtils.isEmpty(System.getProperty("http.proxyHost")) && TextUtils.isEmpty(System.getProperty("http.proxyPort")) && TextUtils.isEmpty(System.getProperty("https.proxyHost")) && TextUtils.isEmpty(System.getProperty("https.proxyPort"))) ? false : true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final boolean b() {
        Context context = this.f21093a;
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final boolean c() {
        Context context = this.f21093a;
        if (context == null) {
            return true;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
            return true;
        }
    }
}
