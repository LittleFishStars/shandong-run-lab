package com.getui.gtc.a;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.a.a.h;
import com.getui.gtc.a.a.i;
import com.getui.gtc.a.a.l;
import com.getui.gtc.a.a.n;
import com.getui.gtc.a.a.o;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.ScheduleQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements b {
    public static int e = 4;
    private static long i = 86400000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30267a;
    public int b;
    private boolean h = false;
    private long j = 604800000;
    private String k = "none";
    public boolean c = true;
    public boolean d = true;
    public boolean f = false;
    public boolean g = false;
    private final AtomicBoolean l = new AtomicBoolean(true);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2) {
        if (i2 == -1) {
            com.getui.gtc.i.c.a.d("not integrate ct.");
            a(3, new o(-3));
            return;
        }
        if (!l.c()) {
            com.getui.gtc.i.c.a.d("not init ct.");
            a(3, new o(-4));
            return;
        }
        o oVarB = l.b("");
        boolean zIsEmpty = TextUtils.isEmpty(oVarB.c);
        if (this.l.getAndSet(false) && zIsEmpty) {
            ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.getui.gtc.i.c.a.d("ct retry.");
                        g.this.a(i2);
                    } catch (Throwable th) {
                        com.getui.gtc.i.c.a.c(th);
                    }
                }
            }, 5000L);
        } else if (zIsEmpty && (this.b & 1) == 1) {
            l.g();
        } else {
            a(3, oVarB);
        }
    }

    public static void a(int i2, o oVar) {
        String strA;
        String str;
        try {
            String str2 = oVar.c;
            int i3 = 0;
            if (TextUtils.isEmpty(str2)) {
                strA = "";
                str = "";
            } else {
                if (i2 != 1) {
                    strA = n.a(str2);
                    com.getui.gtc.i.c.a.d("305 * PM: ".concat(String.valueOf(str2)));
                } else {
                    i3 = 1;
                    strA = n.a(h.a(str2));
                }
                str = "2#" + n.a();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            a(a.a(simpleDateFormat.format(new Date())) + "|" + a.a(com.getui.gtc.c.b.d) + "|" + a.a(com.getui.gtc.c.b.f30289a) + "|android|" + GtcProvider.context().getPackageName() + "|GTC-3.2.16.0|" + i2 + "|" + oVar.f30261a + "|" + strA + "|" + oVar.b + "|" + str + "|" + i3);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c("type 305 report error: " + th.toString());
        }
    }

    private static void a(final String str) {
        boolean z;
        try {
            final JSONObject jSONObjectB = com.getui.gtc.e.c.a.f30351a.f30350a.b();
            if (str == null) {
                str = jSONObjectB.optString("content");
                z = true;
            } else {
                jSONObjectB.put("collectTime", System.currentTimeMillis());
                jSONObjectB.put("content", str);
                com.getui.gtc.e.c.a.f30351a.f30350a.b(jSONObjectB);
                com.getui.gtc.i.c.a.a("type 305 save content");
                z = false;
            }
            if (TextUtils.isEmpty(str)) {
                com.getui.gtc.i.c.a.c("type 305 no content report");
                return;
            }
            boolean z2 = str.endsWith("|1") ? false : true;
            if (System.currentTimeMillis() - jSONObjectB.optLong("reportTime") < i) {
                com.getui.gtc.i.c.a.c("type 305 report not expired");
                return;
            }
            if (z2) {
                com.getui.gtc.h.a.a(str, 305);
                jSONObjectB.put("reportTime", System.currentTimeMillis());
                com.getui.gtc.e.c.a.f30351a.f30350a.b(jSONObjectB);
            } else {
                if (!z) {
                    ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.g.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                com.getui.gtc.h.a.a(str, 305);
                                jSONObjectB.put("reportTime", System.currentTimeMillis());
                                jSONObjectB.put("content", "");
                                com.getui.gtc.e.c.a.f30351a.f30350a.b(jSONObjectB);
                                com.getui.gtc.i.c.a.a("type 305 delete content");
                            } catch (Throwable th) {
                                com.getui.gtc.i.c.a.c(th);
                            }
                        }
                    }, 300000L);
                    return;
                }
                com.getui.gtc.h.a.a(str, 305);
                jSONObjectB.put("reportTime", System.currentTimeMillis());
                jSONObjectB.put("content", "");
                com.getui.gtc.e.c.a.f30351a.f30350a.b(jSONObjectB);
                com.getui.gtc.i.c.a.a("type 305 delete content");
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!z) {
            com.getui.gtc.i.c.a.d("not integrate cu.");
            a(2, new o(-3));
            return;
        }
        if (!l.d()) {
            com.getui.gtc.i.c.a.d("not init cu.");
            a(2, new o(-4));
            return;
        }
        o oVarE = l.e();
        boolean zIsEmpty = TextUtils.isEmpty(oVarE.c);
        if (this.l.getAndSet(false) && zIsEmpty) {
            ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.getui.gtc.i.c.a.d("cu retry.");
                        g.this.a(true);
                    } catch (Throwable th) {
                        com.getui.gtc.i.c.a.c(th);
                    }
                }
            }, 5000L);
        } else if (zIsEmpty && (this.b & 2) == 2) {
            l.f();
        } else {
            a(2, oVarE);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, String> mapA = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, (com.getui.gtc.f.e) null);
        if (mapA != null && mapA.size() > 0) {
            try {
                String str = mapA.get("sdk.gtc.type305.enable");
                if (str != null) {
                    this.h = Boolean.parseBoolean(str);
                }
            } catch (Exception e2) {
                com.getui.gtc.i.c.a.b(e2);
            }
            try {
                String str2 = mapA.get("sdk.gtc.type305.interval");
                if (str2 != null) {
                    i = Long.parseLong(str2) * 1000;
                }
            } catch (Exception e3) {
                com.getui.gtc.i.c.a.b(e3);
            }
            try {
                String str3 = mapA.get("sdk.gtc.type305.collect_interval");
                if (str3 != null) {
                    this.j = Long.parseLong(str3) * 1000;
                }
            } catch (Exception e4) {
                com.getui.gtc.i.c.a.b(e4);
            }
            try {
                String str4 = mapA.get("sdk.gtc.type305.cu_path_list");
                if (str4 != null) {
                    this.k = str4;
                }
            } catch (Exception e5) {
                com.getui.gtc.i.c.a.b(e5);
            }
            try {
                String str5 = mapA.get("sdk.gtc.type305.s_pm_enable");
                if (str5 != null) {
                    this.f30267a = Integer.parseInt(str5);
                }
            } catch (Exception e6) {
                com.getui.gtc.i.c.a.b(e6);
            }
            try {
                String str6 = mapA.get("sdk.gtc.type305.pl_enable");
                if (str6 != null) {
                    this.b = Integer.parseInt(str6);
                }
            } catch (Exception e7) {
                com.getui.gtc.i.c.a.b(e7);
            }
            try {
                String str7 = mapA.get("sdk.gtc.type305.first_call");
                if (str7 != null) {
                    e = Integer.parseInt(str7);
                }
            } catch (Exception e8) {
                com.getui.gtc.i.c.a.b(e8);
            }
            try {
                String str8 = mapA.get("sdk.gtc.type305.n_pm_enable");
                if (str8 != null) {
                    this.f = Boolean.parseBoolean(str8);
                }
            } catch (Exception e9) {
                com.getui.gtc.i.c.a.b(e9);
            }
            try {
                String str9 = mapA.get("sdk.gtc.type305.cl_enable");
                if (str9 != null) {
                    this.g = Boolean.parseBoolean(str9);
                }
            } catch (Exception e10) {
                com.getui.gtc.i.c.a.b(e10);
            }
            try {
                String str10 = mapA.get("sdk.gtc.type305.sf_enable");
                if (str10 != null) {
                    this.d = Boolean.parseBoolean(str10);
                }
            } catch (Exception e11) {
                com.getui.gtc.i.c.a.b(e11);
            }
            try {
                String str11 = mapA.get("sdk.gtc.type305.gbd.check");
                if (str11 != null) {
                    this.c = Boolean.parseBoolean(str11);
                }
            } catch (Exception e12) {
                com.getui.gtc.i.c.a.b(e12);
            }
        }
        if (!this.h) {
            com.getui.gtc.i.c.a.b("type 305 is not enabled");
            return;
        }
        try {
            if (this.c) {
                Bundle bundle = new Bundle();
                bundle.putString("cn", "com.getui.gtc.extension.distribution.gbd.stub.PushExtension");
                if (com.getui.gtc.g.b.a(bundle) != null) {
                    com.getui.gtc.i.c.a.a("type 305 exist gbd pm");
                    return;
                }
            }
            a((String) null);
            JSONObject jSONObjectB = com.getui.gtc.e.c.a.f30351a.f30350a.b();
            if (System.currentTimeMillis() - jSONObjectB.optLong("collectTime") < this.j) {
                com.getui.gtc.i.c.a.c("type 305 collect time not expired");
                return;
            }
            int iOptInt = jSONObjectB.optInt("accessCount") + 1;
            jSONObjectB.put("accessCount", iOptInt);
            com.getui.gtc.e.c.a.f30351a.f30350a.b(jSONObjectB);
            if (iOptInt < e) {
                com.getui.gtc.i.c.a.d("accessCount:" + iOptInt + " < starPmFirstCall:" + e + ", ignored");
                return;
            }
            try {
                int iA = l.a(GtcProvider.context());
                if (this.d && !l.b(GtcProvider.context())) {
                    com.getui.gtc.i.c.a.d("type 305 report not sf.");
                    a(iA, new o(-1));
                    return;
                }
                if (!l.a()) {
                    com.getui.gtc.i.c.a.d("type 305 report not net.");
                    a(iA, new o(-2));
                    return;
                }
                com.getui.gtc.i.c.a.d("type 305 pmEnable: " + this.f30267a);
                if (iA != 1) {
                    if (iA == 2) {
                        if ((this.f30267a & 2) != 2) {
                            com.getui.gtc.i.c.a.d("type 305 starPm disable.");
                            return;
                        } else {
                            com.getui.gtc.i.c.a.d("type 305 cu fetch.");
                            a(l.a(this.k));
                            return;
                        }
                    }
                    if (iA != 3) {
                        com.getui.gtc.i.c.a.d("type 305 no mc or error.");
                        return;
                    } else if ((this.f30267a & 1) != 1) {
                        com.getui.gtc.i.c.a.d("type 305 starPm disable.");
                        return;
                    } else {
                        com.getui.gtc.i.c.a.d("type 305 ct fetch.");
                        a(l.b());
                        return;
                    }
                }
                if (!this.f) {
                    com.getui.gtc.i.c.a.d("type 305 cm vd disable.");
                    return;
                }
                com.getui.gtc.i.c.a.d("type 305 cm vd fetch.");
                final i iVar = new i(GtcProvider.context());
                boolean z = this.g;
                final ConnectivityManager connectivityManager = (ConnectivityManager) iVar.f30247a.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    com.getui.gtc.i.c.a.d("net info is null");
                    return;
                }
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    com.getui.gtc.i.c.a.d("in cl.");
                    iVar.a((Network) null);
                    return;
                }
                if (type == 1) {
                    com.getui.gtc.i.c.a.d("in wf.");
                    if (!z) {
                        com.getui.gtc.i.c.a.d("sc dy not allow");
                        a(1, new o(-2, "", ""));
                        return;
                    }
                    try {
                        if (!CommonUtil.hasPermission(iVar.f30247a, "android.permission.CHANGE_NETWORK_STATE", false)) {
                            com.getui.gtc.i.c.a.d("sc dy not allow or no net perm.");
                            a(1, new o(-2, "", ""));
                            return;
                        }
                        if (!i.a(connectivityManager)) {
                            com.getui.gtc.i.c.a.d("sc  cl closed.");
                            a(1, new o(-5, "", ""));
                            return;
                        }
                        com.getui.gtc.i.c.a.d("in wf mode, attempt 2 cl.");
                        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                        NetworkRequest.Builder builder = new NetworkRequest.Builder();
                        builder.addCapability(12);
                        builder.addTransportType(0);
                        NetworkRequest networkRequestBuild = builder.build();
                        final ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.getui.gtc.a.a.i.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onAvailable(final Network network) {
                                super.onAvailable(network);
                                com.getui.gtc.i.c.a.d("w2cl su.");
                                if (atomicBoolean.getAndSet(false)) {
                                    ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.a.i.1.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            i.this.a(network);
                                        }
                                    });
                                }
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                                super.onCapabilitiesChanged(network, networkCapabilities);
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                                super.onLinkPropertiesChanged(network, linkProperties);
                                com.getui.gtc.i.c.a.d("onLPChanged, if name = " + linkProperties.getInterfaceName());
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onLosing(Network network, int i2) {
                                super.onLosing(network, i2);
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onLost(Network network) {
                                super.onLost(network);
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onUnavailable() {
                                super.onUnavailable();
                                com.getui.gtc.i.c.a.d("w2cu f.");
                            }
                        };
                        connectivityManager.requestNetwork(networkRequestBuild, networkCallback);
                        iVar.b = new Runnable() { // from class: com.getui.gtc.a.a.i.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    i.this.b = null;
                                    connectivityManager.unregisterNetworkCallback(networkCallback);
                                } catch (Throwable th) {
                                    com.getui.gtc.i.c.a.c(th);
                                }
                            }
                        };
                        ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.a.a.i.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                Runnable runnable = i.this.b;
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        }, 15000L);
                    } catch (Throwable th) {
                        com.getui.gtc.i.c.a.c(th);
                    }
                }
            } catch (Throwable th2) {
                com.getui.gtc.i.c.a.c(th2);
            }
        } catch (Throwable th3) {
            com.getui.gtc.i.c.a.c("type 305 report error: " + th3.toString());
        }
    }
}
