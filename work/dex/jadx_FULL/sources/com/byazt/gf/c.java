package com.byazt.gf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.qi.a;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 914, 20})
public class c {
    public static volatile c c;
    public TelephonyManager n;
    public volatile int tt;
    public volatile int uj = -1;
    public ConnectivityManager ve;

    public c() {
        this.ve = null;
        this.n = null;
        Context contextVe = a.ve();
        if (contextVe != null) {
            this.ve = (ConnectivityManager) contextVe.getSystemService("connectivity");
            this.n = (TelephonyManager) contextVe.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        }
        c((int) (((n.c().ve() / 1000) / 60) / 60));
    }

    private int a() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.ve;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.ve.getActiveNetwork()) == null || (networkCapabilities = this.ve.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(0);
            boolean zHasTransport2 = networkCapabilities.hasTransport(1);
            if (c(this.ve) && zHasTransport2) {
                return 3;
            }
            if (zHasTransport2) {
                return 1;
            }
            return zHasTransport ? 2 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public int n() {
        TelephonyManager telephonyManager = this.n;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }

    @NonNull
    public int[] tt() {
        int[] iArr = new int[this.tt];
        LinkedList<JSONObject> linkedListC = tt.c().c("sp_net");
        if (linkedListC != null && !linkedListC.isEmpty()) {
            int iOptLong = (int) (((linkedListC.get(linkedListC.size() - 1).optLong("t", 0L) / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListC) {
                long jOptLong = jSONObject.optLong("t", 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iOptLong - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.tt) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int uj() {
        this.uj = a();
        return this.uj;
    }

    @NonNull
    public int[] ve() {
        int[] iArr = new int[this.tt];
        LinkedList<JSONObject> linkedListC = tt.c().c("sp_screen");
        if (linkedListC != null && linkedListC.size() > 0) {
            int iCurrentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListC) {
                long jOptLong = jSONObject.optLong("t", 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iCurrentTimeMillis - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.tt) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    private static boolean c(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void c(int i) {
        if (i <= 0) {
            this.tt = 1;
        } else if (i > 168) {
            this.tt = 168;
        } else {
            this.tt = i;
        }
    }
}
