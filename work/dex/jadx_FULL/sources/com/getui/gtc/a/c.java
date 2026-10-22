package com.getui.gtc.a;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.NetworkUtil;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimManager;
import com.getui.gtc.dim.DimRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements b {
    private static final AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30263a;
    public long b;
    private String c;
    private boolean d = false;
    private final AtomicBoolean f = new AtomicBoolean(false);

    private c() {
        this.f30263a = 300000L;
        this.b = 5000L;
        Map<String, String> mapA = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, (com.getui.gtc.f.e) null);
        if (mapA == null || mapA.size() <= 0) {
            return;
        }
        try {
            String str = mapA.get("sdk.gtc.type256.interval");
            if (str != null) {
                this.f30263a = Long.parseLong(str) * 1000;
            }
        } catch (Exception e2) {
            com.getui.gtc.i.c.a.b(e2);
        }
        try {
            String str2 = mapA.get("sdk.gtc.type256.delay");
            if (str2 != null) {
                this.b = Long.parseLong(str2) * 1000;
            }
        } catch (Exception e3) {
            com.getui.gtc.i.c.a.b(e3);
        }
    }

    private static Object a(String str) {
        return DimManager.getInstance().get(new DimRequest.Builder().skipCache(true).key(str).caller(Caller.UNKNOWN).build());
    }

    private static String a(Context context) {
        try {
            if (!NetworkUtil.isNetWorkAvailable(context)) {
                com.getui.gtc.i.c.a.a("Iv6 network not connected.");
                return "no network|-1";
            }
            NetworkInfo networkInfoB = b(context);
            boolean z = false;
            boolean z2 = networkInfoB != null && networkInfoB.getType() == 0;
            if (networkInfoB != null && networkInfoB.getType() == 1) {
                z = true;
            }
            String str = (String) a("dim-2-1-16-2");
            if (str == null) {
                str = "";
            }
            if (z2) {
                com.getui.gtc.i.c.a.a("Phone Iv6 List = ".concat(str));
                return str + "|1";
            }
            if (!z) {
                return "error|-1";
            }
            com.getui.gtc.i.c.a.a("Wifi Iv6 List = ".concat(str));
            return str + "|2";
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return "error|-1";
        }
    }

    private static String a(ScanResult scanResult) {
        if (scanResult == null) {
            return "";
        }
        try {
            String str = scanResult.SSID;
            if (str == null) {
                return "";
            }
            return str.replace("|", "").replace("#", "").replace(",", "") + "#" + scanResult.BSSID + "#" + scanResult.level + "#" + scanResult.capabilities + "#" + (System.currentTimeMillis() - (((SystemClock.elapsedRealtimeNanos() / 1000) / 1000) - (scanResult.timestamp / 1000)));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return "";
        }
    }

    private static String a(List<ScanResult> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(a(list.get(i)));
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static void a() {
        if (e.getAndSet(true)) {
            return;
        }
        c cVar = new c();
        ScheduleQueue.getInstance().addSchedule(cVar, cVar.b, cVar.f30263a);
    }

    private static NetworkInfo b(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Pair<String, String> b() {
        try {
            String str = (String) a("dim-2-1-19-2");
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split(",");
                if (strArrSplit.length > 0) {
                    String str2 = strArrSplit[strArrSplit.length - 1];
                    if (!TextUtils.isEmpty(str2)) {
                        return new Pair<>(str2.substring(0, str2.lastIndexOf(124)), str2.substring(str2.lastIndexOf(124) + 1));
                    }
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a(th);
        }
        return new Pair<>("0|0|0|0", "0");
    }

    private void c() {
        JSONArray jSONArray;
        try {
            String str = com.getui.gtc.e.c.a.f30351a.f30350a.b;
            try {
                jSONArray = !TextUtils.isEmpty(str) ? new JSONArray(str) : new JSONArray();
            } catch (Throwable unused) {
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() < 100) {
                jSONArray.put(this.c);
            }
            com.getui.gtc.e.c.a.f30351a.f30350a.e(jSONArray.toString());
            for (int i = 0; i < jSONArray.length(); i++) {
                com.getui.gtc.h.a.a(jSONArray.getString(i), 256);
            }
            com.getui.gtc.e.d dVar = com.getui.gtc.e.c.a.f30351a.f30350a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (dVar.a(19, jCurrentTimeMillis)) {
                dVar.m = jCurrentTimeMillis;
            }
            com.getui.gtc.e.c.a.f30351a.f30350a.e("");
        } catch (Exception e2) {
            com.getui.gtc.i.c.a.c("type 256 report error: " + e2.toString());
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        long time;
        float accuracy;
        try {
            if (!this.f.getAndSet(true)) {
                try {
                    String str = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, (com.getui.gtc.f.e) null).get("sdk.gtc.type256.enable");
                    if (str != null) {
                        this.d = Boolean.parseBoolean(str);
                    }
                } catch (Exception e2) {
                    com.getui.gtc.i.c.a.b(e2);
                }
                if (System.currentTimeMillis() - com.getui.gtc.e.c.a.f30351a.f30350a.m < this.f30263a) {
                    com.getui.gtc.i.c.a.c("type 256 collect time not expired");
                    return;
                }
            }
            if (!this.d) {
                com.getui.gtc.i.c.a.b("type 256 is not enabled");
                return;
            }
            if (CommonUtil.isAppDebugEnable()) {
                com.getui.gtc.i.c.a.b("type 256 is debug, disallow");
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Location location = (Location) a("dim-2-1-17-1");
            if (location == null) {
                location = (Location) a("dim-2-1-17-2");
            }
            if (location != null) {
                time = location.getTime();
                accuracy = location.getAccuracy();
            } else {
                time = 0;
                accuracy = 0.0f;
            }
            StringBuilder sb = new StringBuilder();
            if (location == null) {
                sb.append("none");
                sb.append("|");
                sb.append("0");
                sb.append("|");
                sb.append("0");
                sb.append("|");
                sb.append("0");
            } else {
                sb.append(location.getProvider());
                sb.append("|");
                sb.append(location.getLongitude());
                sb.append("|");
                sb.append(location.getLatitude());
                sb.append("|");
                sb.append(location.getAltitude());
            }
            String string = sb.toString();
            Pair<String, String> pairB = b();
            String strA = a((List<ScanResult>) a("dim-2-1-18-2"));
            String strA2 = a(GtcProvider.context());
            String str2 = (String) a("dim-2-1-18-3");
            if (str2 == null) {
                str2 = "";
            }
            String str3 = simpleDateFormat.format(new Date()) + "|" + com.getui.gtc.c.b.d + "|" + com.getui.gtc.c.b.f30289a + "|" + string + "|" + ((String) pairB.first) + "|" + strA + "|" + time + "|" + accuracy + "||ANDROID|" + strA2 + "|" + str2 + "|" + ((String) pairB.second) + "||";
            this.c = str3;
            com.getui.gtc.i.c.a.a(str3);
            c();
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a("type 256", th);
        }
    }
}
