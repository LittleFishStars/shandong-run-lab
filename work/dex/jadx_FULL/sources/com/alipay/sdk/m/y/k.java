package com.alipay.sdk.m.y;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k {
    public static final String i = "sp_bind_failed";
    public static final String j = "failed";
    public static final String k = "scheme_failed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f25533a;
    public volatile IAlixPay b;
    public boolean d;
    public f e;
    public final com.alipay.sdk.m.w.a f;
    public final Object c = IAlixPay.class;
    public boolean g = false;
    public String h = null;

    public class a implements APayEntranceActivity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f25534a;

        public a(Object obj) {
            this.f25534a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            k.this.h = str;
            synchronized (this.f25534a) {
                try {
                    this.f25534a.notify();
                } catch (Throwable th) {
                    com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, "BSAResultEx", th);
                }
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ APayEntranceActivity.a f25535a;

        public b(APayEntranceActivity.a aVar) {
            this.f25535a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f == null || k.this.f.h()) {
                return;
            }
            com.alipay.sdk.m.m.a.b(k.this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.e0, "");
            if (com.alipay.sdk.m.o.b.i().A()) {
                k.this.f.b(true);
                this.f25535a.a(com.alipay.sdk.m.l.b.a());
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f25536a;
        public final /* synthetic */ Object b;

        public c(Intent intent, Object obj) {
            this.f25536a = intent;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (k.this.f25533a != null) {
                    k.this.f25533a.startActivity(this.f25536a);
                } else {
                    com.alipay.sdk.m.m.a.b(k.this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.c0, "");
                    Context contextB = k.this.f.b();
                    if (contextB != null) {
                        contextB.startActivity(this.f25536a);
                    }
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.d0, th);
                q.a("alipaySdk", com.alipay.sdk.m.n.b.q, k.this.f25533a, k.this.f);
                synchronized (this.b) {
                    try {
                        k.this.h = k.k;
                        this.b.notify();
                    } catch (Throwable th2) {
                        com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, "BSAResultEx", th2);
                    }
                }
            }
        }
    }

    public class d extends IRemoteServiceCallback.Stub {
        public d() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (k.this.e != null) {
                    k.this.e.a();
                }
                if (k.this.f != null) {
                    k.this.f.c(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.Z, e);
            }
            intent.setClassName(str, str2);
            try {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
            } catch (Throwable unused) {
            }
            try {
                if (k.this.f25533a == null) {
                    com.alipay.sdk.m.m.a.b(k.this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.a0, "");
                    Context contextB = k.this.f.b();
                    if (contextB != null) {
                        contextB.startActivity(intent);
                        return;
                    }
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                k.this.f25533a.startActivity(intent);
                com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, "stAct2", "" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.b0, th);
                throw th;
            }
        }

        public /* synthetic */ d(k kVar, a aVar) {
            this();
        }
    }

    public class e implements ServiceConnection {
        public e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, "srvCon");
            synchronized (k.this.c) {
                k.this.b = IAlixPay.Stub.asInterface(iBinder);
                k.this.c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.m.m.a.a(k.this.f, com.alipay.sdk.m.m.b.l, "srvDis");
            k.this.b = null;
        }

        public /* synthetic */ e(k kVar, a aVar) {
            this();
        }
    }

    public interface f {
        void a();

        void b();
    }

    public k(Activity activity, com.alipay.sdk.m.w.a aVar, f fVar) {
        this.f25533a = activity;
        this.f = aVar;
        this.e = fVar;
        g.d(com.alipay.sdk.m.n.a.B, "alipaySdk");
    }

    public String a(String str, boolean z) {
        q.c cVarA;
        String strB = "";
        PackageInfo packageInfo = null;
        try {
            List<com.alipay.sdk.m.o.b.C0199b> listM = com.alipay.sdk.m.o.b.i().m();
            if (!com.alipay.sdk.m.o.b.i().g || listM == null) {
                listM = com.alipay.sdk.m.l.a.d;
            }
            cVarA = q.a(this.f, this.f25533a, listM);
            if (cVarA != null) {
                try {
                    if (cVarA.a(this.f) || cVarA.a() || q.a(cVarA.f25547a)) {
                        return j;
                    }
                    PackageInfo packageInfo2 = cVarA.f25547a;
                    if (packageInfo2 != null && !"com.eg.android.AlipayGphone".equals(packageInfo2.packageName)) {
                        strB = cVarA.f25547a.packageName;
                    } else {
                        strB = q.b();
                    }
                    PackageInfo packageInfo3 = cVarA.f25547a;
                    packageInfo = packageInfo3 != null ? packageInfo3 : null;
                    String strD = com.alipay.sdk.m.o.b.i().d();
                    if (strD != null && strD.length() > 0) {
                        try {
                            JSONObject jSONObjectOptJSONObject = new JSONObject(strD).optJSONObject(strB);
                            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    int i2 = Integer.parseInt(next);
                                    if (packageInfo != null && packageInfo.versionCode >= i2) {
                                        try {
                                            boolean zA = com.alipay.sdk.m.o.b.i().a(this.f25533a, Integer.parseInt(jSONObjectOptJSONObject.getString(next)));
                                            this.g = zA;
                                            if (zA) {
                                                break;
                                            }
                                        } catch (Exception unused) {
                                            continue;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.N, th);
                }
                boolean zB = q.b(this.f);
                if ((z || this.g) && !zB && a(strB, this.f25533a, this.f)) {
                    return a(str, strB, packageInfo);
                }
                return a(str, strB, packageInfo, cVarA);
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            cVarA = null;
        }
    }

    public final void a(q.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.f25547a) == null) {
            return;
        }
        if (!com.alipay.sdk.m.o.b.i().b(this.f)) {
            com.alipay.sdk.m.w.a aVar = this.f;
            String strA = m.a(aVar, aVar.b(), i, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            g.d(com.alipay.sdk.m.n.a.B, "get SP_BIND_FAILED: " + strA);
            if (TextUtils.isEmpty(strA) || TextUtils.equals(strA, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                return;
            }
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f25533a.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.g0, th);
        }
        Thread.sleep(com.alipay.sdk.m.o.b.i().t());
    }

    public final String a(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        g.d(com.alipay.sdk.m.n.a.B, "pay payInvokeAct");
        com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.X, str2 + "|" + str3);
        Activity activity = this.f25533a;
        com.alipay.sdk.m.w.a aVar = this.f;
        com.alipay.sdk.m.m.a.a(activity, aVar, str, aVar.d);
        return a(str, str2);
    }

    public final String a(String str, String str2, PackageInfo packageInfo, q.c cVar) {
        String str3;
        Activity activity;
        boolean zContains = false;
        int i2 = packageInfo != null ? packageInfo.versionCode : 0;
        g.d(com.alipay.sdk.m.n.a.B, "pay bind or scheme");
        com.alipay.sdk.m.w.a aVar = this.f;
        if (aVar != null && !TextUtils.isEmpty(aVar.g)) {
            zContains = this.f.g.toLowerCase().contains("auth");
        }
        if (!zContains && q.d(this.f, str2)) {
            if (cVar != null) {
                try {
                    if (com.alipay.sdk.m.o.b.i().E()) {
                        a(cVar);
                    }
                } catch (Throwable unused) {
                }
            }
            com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BindSkipByL");
            str3 = j;
        } else {
            if (cVar != null) {
                try {
                    if (!com.alipay.sdk.m.o.b.i().r()) {
                        a(cVar);
                    }
                } catch (Throwable unused2) {
                }
            }
            Pair<String, Boolean> pairA = a(str, str2, this.f);
            str3 = (String) pairA.first;
            try {
                if (j.equals(str3) && ((Boolean) pairA.second).booleanValue() && com.alipay.sdk.m.o.b.i().p()) {
                    com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BindRetry");
                    str3 = (String) a(str, str2, this.f).first;
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BindRetryEx", th);
            }
        }
        g.d(com.alipay.sdk.m.n.a.B, "pay bind result: " + str3);
        Activity activity2 = this.f25533a;
        com.alipay.sdk.m.w.a aVar2 = this.f;
        com.alipay.sdk.m.m.a.a(activity2, aVar2, str, aVar2.d);
        if (j.equals(str3)) {
            if (!com.alipay.sdk.m.o.b.i().b(this.f)) {
                g.d(com.alipay.sdk.m.n.a.B, "save SP_BIND_FAILED: true");
                com.alipay.sdk.m.w.a aVar3 = this.f;
                m.b(aVar3, aVar3.b(), i, "true");
            }
            if (!"com.eg.android.AlipayGphone".equals(str2)) {
                com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSPNotStartByAlipay", str2 + "|" + i2);
                return str3;
            }
            if (i2 >= 460 && !zContains && (activity = this.f25533a) != null && a(str2, activity, this.f)) {
                return a(str, str2, packageInfo);
            }
        }
        return str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.m.w.a aVar) {
        int i2;
        e eVar;
        IRemoteServiceCallback dVar;
        Activity activity;
        int version;
        String strA;
        Activity activity2;
        Activity activity3;
        String strPay;
        Activity activity4;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(q.c(str2));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(jElapsedRealtime);
        sb.append("|");
        sb.append(str != null ? str.length() : 0);
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.R, sb.toString());
        com.alipay.sdk.m.m.a.a(this.f25533a, aVar, str, aVar.d);
        try {
            try {
                if (!com.alipay.sdk.m.o.b.i().h()) {
                    ComponentName componentNameStartService = this.f25533a.getApplication().startService(intent);
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "stSrv", componentNameStartService != null ? componentNameStartService.getPackageName() : "null");
                } else {
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "stSrv", "skipped");
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.J, th);
                q.a("alipaySdk", com.alipay.sdk.m.n.b.n, this.f25533a, this.f);
                return new Pair<>(j, Boolean.TRUE);
            }
        } catch (Throwable th2) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.K, th2);
        }
        if (com.alipay.sdk.m.o.b.i().c()) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "bindFlg", QdActivityType.IMP);
            i2 = 65;
        } else {
            i2 = 1;
        }
        boolean zB = com.alipay.sdk.m.o.b.i().b();
        if (Build.VERSION.SDK_INT >= 34 && zB) {
            i2 |= 512;
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "bindFlg", "allow");
        }
        a aVar2 = null;
        e eVar2 = new e(this, aVar2);
        if (this.f25533a.getApplicationContext().bindService(intent, eVar2, i2)) {
            synchronized (this.c) {
                if (this.b == null) {
                    try {
                        this.c.wait(com.alipay.sdk.m.o.b.i().l());
                    } catch (InterruptedException e2) {
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.L, e2);
                    }
                }
            }
            IAlixPay iAlixPay = this.b;
            try {
                if (iAlixPay == null) {
                    com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.E, "");
                    q.a("alipaySdk", com.alipay.sdk.m.n.b.o, this.f25533a, this.f);
                    Pair<String, Boolean> pair = new Pair<>(j, Boolean.TRUE);
                    try {
                        this.f25533a.getApplicationContext().unbindService(eVar2);
                    } catch (Throwable th3) {
                        g.a(th3);
                    }
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.T, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.m.a.a(this.f25533a, aVar, str, aVar.d);
                    this.b = null;
                    if (this.d && (activity4 = this.f25533a) != null) {
                        activity4.setRequestedOrientation(0);
                        this.d = false;
                    }
                    return pair;
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.S, "" + jElapsedRealtime2);
                f fVar = this.e;
                if (fVar != null) {
                    fVar.b();
                }
                if (this.f25533a.getRequestedOrientation() == 0) {
                    this.f25533a.setRequestedOrientation(1);
                    this.d = true;
                }
                try {
                    version = iAlixPay.getVersion();
                } catch (Throwable th4) {
                    g.a(th4);
                    version = 0;
                }
                dVar = new d(this, aVar2);
                try {
                    if (version >= 3) {
                        iAlixPay.registerCallback03(dVar, str, null);
                    } else {
                        iAlixPay.registerCallback(dVar);
                    }
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        sb2.append("");
                        sb2.append(jElapsedRealtime3);
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.U, sb2.toString());
                        if (version >= 3) {
                            iAlixPay.r03(com.alipay.sdk.m.m.b.l, "bind_pay", null);
                        }
                        try {
                            if (version >= 2) {
                                Map mapA = com.alipay.sdk.m.w.a.a(aVar);
                                mapA.put("ts_bind", String.valueOf(jElapsedRealtime));
                                mapA.put("ts_bend", String.valueOf(jElapsedRealtime2));
                                mapA.put("ts_pay", String.valueOf(jElapsedRealtime3));
                                strPay = iAlixPay.pay02(str, mapA);
                            } else {
                                strPay = iAlixPay.Pay(str);
                            }
                            strA = strPay;
                            eVar = eVar2;
                        } catch (Throwable th5) {
                            com.alipay.sdk.m.w.a aVar3 = this.f;
                            if (aVar3 != null && !aVar3.j()) {
                                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.H, th5);
                                q.a("alipaySdk", com.alipay.sdk.m.n.b.p, this.f25533a, this.f);
                                if (com.alipay.sdk.m.o.b.i().y()) {
                                    Pair<String, Boolean> pair2 = new Pair<>(j, Boolean.FALSE);
                                    try {
                                        iAlixPay.unregisterCallback(dVar);
                                    } catch (Throwable th6) {
                                        g.a(th6);
                                    }
                                    try {
                                        this.f25533a.getApplicationContext().unbindService(eVar2);
                                    } catch (Throwable th7) {
                                        g.a(th7);
                                    }
                                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.T, "" + SystemClock.elapsedRealtime());
                                    com.alipay.sdk.m.m.a.a(this.f25533a, aVar, str, aVar.d);
                                    this.b = null;
                                    if (this.d && (activity2 = this.f25533a) != null) {
                                        activity2.setRequestedOrientation(0);
                                        this.d = false;
                                    }
                                    return pair2;
                                }
                            }
                            eVar = eVar2;
                            try {
                                strA = com.alipay.sdk.m.l.b.a();
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        }
                        try {
                            iAlixPay.unregisterCallback(dVar);
                        } catch (Throwable th9) {
                            g.a(th9);
                        }
                        try {
                            this.f25533a.getApplicationContext().unbindService(eVar);
                        } catch (Throwable th10) {
                            g.a(th10);
                        }
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.T, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.m.a.a(this.f25533a, aVar, str, aVar.d);
                        this.b = null;
                        if (this.d && (activity3 = this.f25533a) != null) {
                            activity3.setRequestedOrientation(0);
                            this.d = false;
                        }
                        return new Pair<>(strA, Boolean.FALSE);
                    } catch (Throwable th11) {
                        th = th11;
                        eVar = eVar2;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    eVar = eVar2;
                }
            } catch (Throwable th13) {
                th = th13;
                eVar = eVar2;
                dVar = null;
            }
            try {
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.E, th, "in_bind");
                return new Pair<>(j, Boolean.TRUE);
            } finally {
                if (dVar != null) {
                    try {
                        iAlixPay.unregisterCallback(dVar);
                    } catch (Throwable th14) {
                        g.a(th14);
                    }
                }
                try {
                    this.f25533a.getApplicationContext().unbindService(eVar);
                } catch (Throwable th15) {
                    g.a(th15);
                }
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.T, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.m.m.a.a(this.f25533a, aVar, str, aVar.d);
                this.b = null;
                if (this.d && (activity = this.f25533a) != null) {
                    activity.setRequestedOrientation(0);
                    this.d = 0 == true ? 1 : 0;
                }
            }
        }
        throw new Throwable("bindService fail");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String a(String str, String str2) {
        JSONObject jSONObject;
        String str3;
        Object obj = new Object();
        String strA = q.a(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSAStart", strA + "|" + jElapsedRealtime);
        com.alipay.sdk.m.w.a.C0210a.a(this.f, strA);
        a aVar = new a(obj);
        APayEntranceActivity.h.put(strA, aVar);
        try {
            try {
                HashMap<String, String> mapA = com.alipay.sdk.m.w.a.a(this.f);
                mapA.put("ts_intent", String.valueOf(jElapsedRealtime));
                jSONObject = new JSONObject(mapA);
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSALocEx", th);
                jSONObject = null;
            }
            Intent intent = new Intent(this.f25533a, (Class<?>) APayEntranceActivity.class);
            intent.putExtra(APayEntranceActivity.d, str);
            intent.putExtra(APayEntranceActivity.e, str2);
            intent.putExtra(APayEntranceActivity.f, strA);
            if (jSONObject != null) {
                intent.putExtra(APayEntranceActivity.g, jSONObject.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new b(aVar), com.alipay.sdk.m.o.b.i().l());
            Activity activity = this.f25533a;
            com.alipay.sdk.m.w.a aVar2 = this.f;
            com.alipay.sdk.m.m.a.a(activity, aVar2, str, aVar2.d);
            if (com.alipay.sdk.m.o.b.i().D()) {
                new Handler(Looper.getMainLooper()).post(new c(intent, obj));
            } else {
                try {
                    Activity activity2 = this.f25533a;
                    if (activity2 != null) {
                        activity2.startActivity(intent);
                    } else {
                        com.alipay.sdk.m.m.a.b(this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.a0, "");
                        Context contextB = this.f.b();
                        if (contextB != null) {
                            contextB.startActivity(intent);
                        }
                    }
                } catch (Throwable th2) {
                    com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.b0, th2);
                    throw th2;
                }
            }
            synchronized (obj) {
                obj.wait();
            }
            String str4 = this.h;
            try {
                str3 = o.a(this.f, str4).get(o.f25542a);
                if (str3 == null) {
                    str3 = "null";
                }
            } catch (Throwable th3) {
                str3 = "unknown";
                com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSAStatEx", th3);
            }
            com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSADone-" + str3);
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSAEmpty");
            return k;
        } catch (InterruptedException e2) {
            com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSAWaiting", e2);
            com.alipay.sdk.m.l.c cVar = com.alipay.sdk.m.l.c.PAY_WAITTING;
            return com.alipay.sdk.m.l.b.a(cVar.c(), cVar.b(), "");
        } catch (Throwable th4) {
            com.alipay.sdk.m.m.a.a(this.f, com.alipay.sdk.m.m.b.l, "BSAEx", th4);
            q.a("alipaySdk", com.alipay.sdk.m.n.b.q, this.f25533a, this.f);
            return k;
        }
    }

    public void a() {
        this.f25533a = null;
        this.e = null;
    }

    public static boolean a(String str, Context context, com.alipay.sdk.m.w.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "BSADetectFail");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "BSADetectFail", th);
            return false;
        }
    }
}
