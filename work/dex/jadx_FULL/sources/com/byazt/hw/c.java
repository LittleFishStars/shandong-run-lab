package com.byazt.hw;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.bwm.x;
import com.byazt.dna.qp;
import com.byazt.nr.gt;
import com.byazt.nr.m;
import com.zj.adlib.xh9;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 77, 20})
public class c implements qp.c {
    public static ThreadPoolExecutor i;
    public static boolean x;
    public final Context sl;
    public final boolean tt;
    public com.byazt.hm.c u;
    public int yp;
    public volatile boolean ve = false;
    public boolean uj = true;
    public boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28631a = 0;
    public long sp = 0;
    public AtomicBoolean da = new AtomicBoolean(false);
    public volatile boolean t = false;
    public final Handler c = ((qp) com.byazt.ut.uj.getService("thread_service")).getIOHandler();

    public c(Context context, int i2) {
        this.sl = context;
        this.tt = gt.c(context);
        this.yp = i2;
    }

    private com.byazt.hm.c i() {
        if (this.u == null) {
            com.byazt.hm.c.C0422c c0422c = new com.byazt.hm.c.C0422c();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.u = c0422c.c(10L, timeUnit).tt(10L, timeUnit).ve(10L, timeUnit).c();
        }
        return this.u;
    }

    public static ThreadPoolExecutor sp() {
        if (i == null) {
            synchronized (c.class) {
                if (i == null) {
                    com.byazt.jtc.uj ujVar = new com.byazt.jtc.uj(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new x("tnc/AppConfig"));
                    i = ujVar;
                    ujVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return i;
    }

    private void uj(boolean z) {
        if (this.n) {
            return;
        }
        if (this.uj) {
            this.uj = false;
            this.f28631a = 0L;
            this.sp = 0L;
        }
        long j = z ? 360000L : com.heytap.mcssdk.constant.a.g;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f28631a > j) {
            if (jCurrentTimeMillis - this.sp > com.igexin.push.config.c.l || !this.t) {
                ve();
            }
        }
    }

    private boolean x() {
        String[] strArrA = a();
        if (strArrA != null && strArrA.length != 0) {
            c(0);
        }
        return false;
    }

    public String[] a() {
        String[] strArrA = sp.c().c(this.yp).uj() != null ? sp.c().c(this.yp).uj().a() : null;
        return (strArrA == null || strArrA.length <= 0) ? new String[0] : strArrA;
    }

    public Context getContext() {
        return this.sl;
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.n = false;
            this.f28631a = System.currentTimeMillis();
            com.byazt.lf.ve.tt("TNCManager", "doRefresh, succ");
            if (this.uj) {
                c();
            }
            this.da.set(false);
            return;
        }
        if (i2 != 102) {
            return;
        }
        this.n = false;
        if (this.uj) {
            c();
        }
        com.byazt.lf.ve.tt("TNCManager", "doRefresh, error");
        this.da.set(false);
    }

    public void n() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.tt) {
                uj();
            } else {
                tt();
            }
        } catch (Throwable unused) {
        }
    }

    public boolean ve() {
        com.byazt.lf.ve.tt("TNCManager", "doRefresh: updating state " + this.da.get());
        sp().execute(new Runnable() { // from class: com.byazt.hw.c.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zC = com.byazt.lf.a.c(c.this.sl);
                if (zC) {
                    c.this.sp = System.currentTimeMillis();
                    if (c.this.da.compareAndSet(false, true)) {
                        c.this.ve(zC);
                    } else {
                        com.byazt.lf.ve.tt("TNCManager", "doRefresh, already running");
                    }
                }
            }
        });
        return true;
    }

    public static void tt(boolean z) {
        x = z;
    }

    public void ve(boolean z) {
        com.byazt.lf.ve.tt("TNCManager", "doRefresh, actual request");
        uj();
        this.n = true;
        if (!z) {
            this.c.sendEmptyMessage(102);
            return;
        }
        try {
            x();
        } catch (Exception unused) {
            this.da.set(false);
        }
    }

    public synchronized void tt() {
        if (System.currentTimeMillis() - this.f28631a > 3600000) {
            this.f28631a = System.currentTimeMillis();
            try {
                if (sp.c().c(this.yp).x() != null) {
                    sp.c().c(this.yp).x().tt();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void c() {
        c(false);
    }

    public synchronized void c(boolean z) {
        if (this.tt) {
            uj(z);
            return;
        }
        if (this.f28631a <= 0) {
            try {
                sp().execute(new Runnable() { // from class: com.byazt.hw.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tt();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void uj() {
        if (this.t) {
            return;
        }
        this.t = true;
        long j = com.byazt.nys.tt.tt(this.sl, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.f28631a = j;
        try {
            if (sp.c().c(this.yp).x() != null) {
                sp.c().c(this.yp).x().c();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i2) {
        Handler handler = this.c;
        if (handler != null) {
            handler.sendEmptyMessage(i2);
        }
    }

    public static void c(Context context, int i2) {
        c cVarC;
        if (x && (cVarC = sp.c().c(i2, context)) != null) {
            if (gt.c(context)) {
                cVarC.c(true);
            } else {
                cVarC.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = com.byazt.nys.tt.tt(this.sl, "ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (sp.c().c(this.yp).x() == null) {
            return true;
        }
        sp.c().c(this.yp).x().c(jSONObject2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i2) {
        String[] strArrA = a();
        if (strArrA != null && strArrA.length > i2) {
            String str = strArrA[i2];
            if (TextUtils.isEmpty(str)) {
                tt(102);
                return;
            }
            try {
                String strC = c(str);
                if (TextUtils.isEmpty(strC)) {
                    tt(102);
                    return;
                }
                com.byazt.va.ve veVarVe = i().ve();
                veVarVe.c(strC);
                c(veVarVe);
                veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.hw.c.3
                    @Override // com.byazt.mh.c
                    public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                        JSONObject jSONObject;
                        if (ttVar == null || !ttVar.i()) {
                            c.this.c(i2 + 1);
                            return;
                        }
                        String string = null;
                        try {
                            jSONObject = new JSONObject(ttVar.n());
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            c.this.c(i2 + 1);
                            return;
                        }
                        try {
                            string = jSONObject.getString("message");
                        } catch (Exception unused2) {
                        }
                        if (!"success".equals(string)) {
                            c.this.c(i2 + 1);
                            return;
                        }
                        try {
                            if (c.this.c(jSONObject)) {
                                c.this.tt(101);
                            } else {
                                c.this.c(i2 + 1);
                            }
                        } catch (Exception unused3) {
                        }
                    }

                    @Override // com.byazt.mh.c
                    public void c(com.byazt.va.uj ujVar, IOException iOException) {
                        c.this.c(i2 + 1);
                    }
                });
                return;
            } catch (Throwable th) {
                com.byazt.lf.ve.tt("AppConfig", "try app config exception: ".concat(String.valueOf(th)));
                return;
            }
        }
        tt(102);
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "https://" + str + "/get_domains/v4/";
    }

    private void c(com.byazt.va.ve veVar) {
        if (veVar == null) {
            return;
        }
        Address addressC = sp.c().c(this.yp).uj() != null ? sp.c().c(this.yp).uj().c(this.sl) : null;
        if (addressC != null && addressC.hasLatitude() && addressC.hasLongitude()) {
            StringBuilder sb = new StringBuilder();
            sb.append(addressC.getLatitude());
            veVar.c("latitude", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(addressC.getLongitude());
            veVar.c("longitude", sb2.toString());
            String locality = addressC.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                veVar.c("city", Uri.encode(locality));
            }
        }
        if (this.ve) {
            veVar.c("force", "1");
        }
        try {
            veVar.c("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable th) {
            m.c(th);
        }
        if (sp.c().c(this.yp).uj() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sp.c().c(this.yp).uj().c());
            veVar.c("aid", sb3.toString());
            veVar.c("device_platform", sp.c().c(this.yp).uj().ve());
            veVar.c(xh9.WEBSITE_PARAMS_CHANNEL, sp.c().c(this.yp).uj().tt());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sp.c().c(this.yp).uj().uj());
            veVar.c("version_code", sb4.toString());
            veVar.c("custom_info_1", sp.c().c(this.yp).uj().n());
        }
    }

    public static void c(ThreadPoolExecutor threadPoolExecutor) {
        i = threadPoolExecutor;
    }
}
