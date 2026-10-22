package com.autonavi.aps.amapapi.restruct;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.zj.adlib.mhb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    private com.autonavi.aps.amapapi.c E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WifiManager f26189a;
    Context i;
    h t;
    public static HashMap<String, Long> w = new HashMap<>(36);
    public static long x = 0;
    static int y = 0;
    public static long A = 0;
    ArrayList<mhb> b = new ArrayList<>();
    ArrayList<mhb> c = new ArrayList<>();
    boolean j = false;
    StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    boolean n = true;
    private volatile WifiInfo C = null;
    String o = null;
    TreeMap<Integer, mhb> p = null;
    public boolean q = true;
    public boolean r = true;
    public boolean s = false;
    String u = "";
    long v = 0;
    ConnectivityManager z = null;
    private long D = 30000;
    volatile boolean B = false;

    public i(Context context, WifiManager wifiManager, Handler handler) {
        this.f26189a = wifiManager;
        this.i = context;
        h hVar = new h(context, "wifiAgee", handler);
        this.t = hVar;
        hVar.a();
    }

    private void A() {
        try {
            if (com.autonavi.aps.amapapi.utils.i.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.r = this.f26189a.isWifiEnabled();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean B() {
        this.q = v();
        A();
        if (!this.q || !this.l) {
            return false;
        }
        if (f != 0) {
            if (com.autonavi.aps.amapapi.utils.i.b() - f < 4900 || com.autonavi.aps.amapapi.utils.i.b() - g < com.igexin.push.config.c.j) {
                return false;
            }
            com.autonavi.aps.amapapi.utils.i.b();
        }
        return true;
    }

    public static long b() {
        return ((com.autonavi.aps.amapapi.utils.i.b() - x) / 1000) + 1;
    }

    public static String p() {
        return String.valueOf(com.autonavi.aps.amapapi.utils.i.b() - g);
    }

    private List<mhb> r() {
        List<ScanResult> scanResults;
        if (this.f26189a != null) {
            try {
                if (com.autonavi.aps.amapapi.utils.i.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    scanResults = this.f26189a.getScanResults();
                } else {
                    com.autonavi.aps.amapapi.utils.b.a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    scanResults = null;
                }
                HashMap<String, Long> map = new HashMap<>(36);
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        map.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (w.isEmpty() || !w.equals(map)) {
                    w = map;
                    x = com.autonavi.aps.amapapi.utils.i.b();
                }
                this.o = null;
                ArrayList arrayList = new ArrayList();
                this.u = "";
                this.C = m();
                if (a(this.C)) {
                    this.u = this.C.getBSSID();
                }
                if (scanResults != null && scanResults.size() > 0) {
                    int size = scanResults.size();
                    for (int i = 0; i < size; i++) {
                        ScanResult scanResult2 = scanResults.get(i);
                        mhb mhbVar = new mhb(!TextUtils.isEmpty(this.u) && this.u.equals(scanResult2.BSSID));
                        mhbVar.f18216a = scanResult2.SSID;
                        mhbVar.b = scanResult2.frequency;
                        mhbVar.f18219b = scanResult2.timestamp;
                        mhbVar.f18215a = mhb.a(scanResult2.BSSID);
                        mhbVar.f43306a = (short) scanResult2.level;
                        short sElapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        mhbVar.f18217a = sElapsedRealtime;
                        if (sElapsedRealtime < 0) {
                            mhbVar.f18217a = (short) 0;
                        }
                        mhbVar.c = com.autonavi.aps.amapapi.utils.i.b();
                        arrayList.add(mhbVar);
                    }
                }
                this.t.a((List) arrayList);
                return arrayList;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
            } catch (Throwable th) {
                this.o = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private int s() {
        WifiManager wifiManager = this.f26189a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean t() {
        long jB = com.autonavi.aps.amapapi.utils.i.b() - d;
        if (jB < 4900) {
            return false;
        }
        if (u() && jB < 9900) {
            return false;
        }
        if (y > 1) {
            long jN = this.D;
            if (jN == 30000) {
                jN = com.autonavi.aps.amapapi.utils.a.n() != -1 ? com.autonavi.aps.amapapi.utils.a.n() : 30000L;
            }
            if (Build.VERSION.SDK_INT >= 28 && jB < jN) {
                return false;
            }
        }
        if (this.f26189a != null) {
            d = com.autonavi.aps.amapapi.utils.i.b();
            int i = y;
            if (i < 2) {
                y = i + 1;
            }
            if (com.autonavi.aps.amapapi.utils.i.c(this.i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                return this.f26189a.startScan();
            }
            com.autonavi.aps.amapapi.utils.b.a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    private boolean u() {
        if (this.z == null) {
            this.z = (ConnectivityManager) com.autonavi.aps.amapapi.utils.i.a(this.i, "connectivity");
        }
        return a(this.z);
    }

    private boolean v() {
        if (this.f26189a == null) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.i.g(this.i);
    }

    private void w() {
        if (B()) {
            long jB = com.autonavi.aps.amapapi.utils.i.b();
            if (jB - e >= 10000) {
                this.b.clear();
                h = g;
            }
            x();
            if (jB - e >= 10000) {
                for (int i = 20; i > 0 && g == h; i--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void x() {
        if (B()) {
            try {
                if (t()) {
                    f = com.autonavi.aps.amapapi.utils.i.b();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void y() {
        List<mhb> listR;
        if (h != g) {
            try {
                listR = r();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "updateScanResult");
                listR = null;
            }
            h = g;
            if (listR == null) {
                this.b.clear();
            } else {
                this.b.clear();
                this.b.addAll(listR);
            }
        }
    }

    private void z() {
        int iS;
        try {
            if (this.f26189a == null) {
                return;
            }
            try {
                iS = s();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "OPENSDK_WMW", "cwsc");
                iS = 4;
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (iS == 0 || iS == 1 || iS == 4) {
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public final ArrayList<mhb> a() {
        if (!this.s) {
            return this.c;
        }
        b(true);
        return this.c;
    }

    public final WifiInfo c() {
        try {
            if (this.f26189a == null) {
                return null;
            }
            if (com.autonavi.aps.amapapi.utils.i.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                return this.f26189a.getConnectionInfo();
            }
            com.autonavi.aps.amapapi.utils.b.a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final String d() {
        return this.o;
    }

    public final ArrayList<mhb> e() {
        if (this.b == null) {
            return null;
        }
        ArrayList<mhb> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void f() {
        try {
            this.s = true;
            List<mhb> listR = r();
            if (listR != null) {
                this.b.clear();
                this.b.addAll(listR);
            }
            d(true);
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        this.C = null;
        this.b.clear();
    }

    public final void h() {
        A = System.currentTimeMillis();
        com.autonavi.aps.amapapi.c cVar = this.E;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void i() {
        if (this.f26189a != null && com.autonavi.aps.amapapi.utils.i.b() - g > 4900) {
            g = com.autonavi.aps.amapapi.utils.i.b();
        }
    }

    public final void j() {
        if (this.f26189a == null) {
            return;
        }
        this.B = true;
    }

    public final boolean k() {
        return this.q;
    }

    public final boolean l() {
        return this.r;
    }

    public final WifiInfo m() {
        this.C = c();
        return this.C;
    }

    public final boolean n() {
        return this.j;
    }

    public final String o() {
        boolean z;
        String str;
        StringBuilder sb = this.k;
        if (sb == null) {
            this.k = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.j = false;
        int size = this.b.size();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i < size) {
            String strC = mhb.c(this.b.get(i).f18215a);
            if (!this.m && !"<unknown ssid>".equals(this.b.get(i).f18216a)) {
                z2 = true;
            }
            if (TextUtils.isEmpty(this.u) || !this.u.equals(strC)) {
                z = z3;
                str = "nb";
            } else {
                str = "access";
                z = true;
            }
            this.k.append(String.format(Locale.US, "#%s,%s", strC, str));
            i++;
            z3 = z;
        }
        if (this.b.size() == 0) {
            z2 = true;
        }
        if (!this.m && !z2) {
            this.j = true;
        }
        if (!z3 && !TextUtils.isEmpty(this.u)) {
            StringBuilder sb2 = this.k;
            sb2.append("#");
            sb2.append(this.u);
            this.k.append(",access");
        }
        return this.k.toString();
    }

    public final long q() {
        return this.v;
    }

    private void d(boolean z) {
        ArrayList<mhb> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.autonavi.aps.amapapi.utils.i.b() - g > 3600000) {
            g();
        }
        if (this.p == null) {
            this.p = new TreeMap<>(Collections.reverseOrder());
        }
        this.p.clear();
        if (this.s && z) {
            try {
                this.c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.b.size();
        this.v = 0L;
        for (int i = 0; i < size; i++) {
            mhb mhbVar = this.b.get(i);
            if (mhbVar.f18218a) {
                this.v = mhbVar.c;
            }
            if (com.autonavi.aps.amapapi.utils.i.a(mhb.c(mhbVar.f18215a)) && (size <= 20 || a(mhbVar.f43306a))) {
                if (this.s && z) {
                    this.c.add(mhbVar);
                }
                if (TextUtils.isEmpty(mhbVar.f18216a)) {
                    mhbVar.f18216a = "unkwn";
                } else if (!"<unknown ssid>".equals(mhbVar.f18216a)) {
                    mhbVar.f18216a = String.valueOf(i);
                }
                this.p.put(Integer.valueOf((mhbVar.f43306a * 25) + i), mhbVar);
            }
        }
        this.b.clear();
        Iterator<mhb> it = this.p.values().iterator();
        while (it.hasNext()) {
            this.b.add(it.next());
        }
        this.p.clear();
    }

    public final void b(boolean z) {
        if (z) {
            w();
        } else {
            x();
        }
        boolean z2 = false;
        if (this.B) {
            this.B = false;
            z();
        }
        y();
        if (com.autonavi.aps.amapapi.utils.i.b() - g > 20000) {
            this.b.clear();
        }
        e = com.autonavi.aps.amapapi.utils.i.b();
        if (this.b.isEmpty()) {
            g = com.autonavi.aps.amapapi.utils.i.b();
            List<mhb> listR = r();
            if (listR != null) {
                this.b.addAll(listR);
                z2 = true;
            }
        }
        d(z2);
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        try {
            return com.autonavi.aps.amapapi.utils.i.a(connectivityManager.getActiveNetworkInfo()) == 1 && a(c());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void c(boolean z) {
        g();
        this.b.clear();
        this.t.a(z);
    }

    public final void a(boolean z) {
        Context context = this.i;
        if (!com.autonavi.aps.amapapi.utils.a.m() || !this.n || this.f26189a == null || context == null || !z || com.autonavi.aps.amapapi.utils.i.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) com.autonavi.aps.amapapi.utils.e.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                com.autonavi.aps.amapapi.utils.e.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public static boolean a(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getSSID()) || !com.autonavi.aps.amapapi.utils.i.a(wifiInfo.getBSSID())) ? false : true;
    }

    public final void a(boolean z, boolean z2, boolean z3, long j) {
        this.l = z;
        this.m = z2;
        this.n = z3;
        if (j < 10000) {
            this.D = 10000L;
        } else {
            this.D = j;
        }
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.E = cVar;
    }

    private static boolean a(int i) {
        int iCalculateSignalLevel = 20;
        try {
            iCalculateSignalLevel = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e2) {
            com.autonavi.aps.amapapi.utils.b.a(e2, "Aps", "wifiSigFine");
        }
        return iCalculateSignalLevel > 0;
    }
}
