package com.alibaba.analytics;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.u;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.zj.adlib.dx7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AnalyticsMgr {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static HandlerThread f599a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static d f601a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static IAnalytics f602a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile boolean f607a = false;
    private static Application b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f603a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static final Object f608b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static RunMode f600a = RunMode.Service;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f611b = false;
    private static String appKey = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f604a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f609b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static boolean f613c = false;
    private static String c = null;
    private static String d = null;
    private static String e = null;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static boolean f614d = false;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private static boolean f615e = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, String> f606a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static Map<String, String> f610b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final List<a> f605a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static Map<String, String> f612c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private static boolean f616f = false;
    private static boolean g = false;
    private static String f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ServiceConnection f23740a = new ServiceConnection() { // from class: com.alibaba.analytics.AnalyticsMgr.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            j.d("onServiceConnected", "this", AnalyticsMgr.f23740a);
            if (RunMode.Service == AnalyticsMgr.f600a) {
                IAnalytics iAnalyticsA = IAnalytics.Stub.a(iBinder);
                AnalyticsMgr.f602a = iAnalyticsA;
                j.i("onServiceConnected", "iAnalytics", iAnalyticsA);
            }
            synchronized (AnalyticsMgr.f603a) {
                AnalyticsMgr.f603a.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            j.d("AnalyticsMgr", "[onServiceDisconnected]");
            synchronized (AnalyticsMgr.f603a) {
                AnalyticsMgr.f603a.notifyAll();
            }
            boolean unused = AnalyticsMgr.f611b = true;
        }
    };

    public enum RunMode {
        Local,
        Service
    }

    public static class a {
        public DimensionSet b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public MeasureSet f618b;
        public boolean k;
        public String module;
        public String monitorPoint;
    }

    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AnalyticsMgr.f616f) {
                    j.i("delay 30 sec to wait the Remote service connected,waiting...", new Object[0]);
                    synchronized (AnalyticsMgr.f603a) {
                        try {
                            AnalyticsMgr.f603a.wait(30000L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (AnalyticsMgr.f602a == null) {
                    j.i("cannot get remote analytics object,new local object", new Object[0]);
                    AnalyticsMgr.m89b();
                }
                AnalyticsMgr.m84a().run();
            } catch (Throwable th) {
                j.e("AnalyticsMgr", "7", th);
            }
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                j.i("延时启动任务", new Object[0]);
                synchronized (AnalyticsMgr.f608b) {
                    int iA = AnalyticsMgr.a();
                    if (iA > 0) {
                        j.i("delay " + iA + " second to start service,waiting...", new Object[0]);
                        try {
                            AnalyticsMgr.f608b.wait(iA * 1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                boolean unused = AnalyticsMgr.f616f = AnalyticsMgr.m90b();
                AnalyticsMgr.f601a.postAtFrontOfQueue(new b());
            } catch (Throwable th) {
                j.e("AnalyticsMgr", "6", th);
            }
        }
    }

    public static class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            try {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = runnable;
                sendMessage(messageObtain);
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    try {
                        ((Runnable) obj).run();
                    } catch (Throwable th) {
                        j.e("AnalyticsMgr", th, new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                j.e("AnalyticsMgr", th2, new Object[0]);
            }
            super.handleMessage(message);
        }
    }

    public static void dispatchLocalHits() {
        if (m87a()) {
            f601a.a(d());
        }
    }

    public static Runnable e() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.saveCacheDataToLocal();
                } catch (RemoteException e2) {
                    j.w("AnalyticsMgr", e2, new Object[0]);
                }
            }
        };
    }

    public static String getGlobalProperty(String str) {
        if (m87a() && str != null) {
            return f612c.get(str);
        }
        return null;
    }

    public static String getValue(String str) {
        IAnalytics iAnalytics = f602a;
        if (iAnalytics == null) {
            return null;
        }
        try {
            return iAnalytics.getValue(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized void init(Application application) {
        try {
            if (!f607a) {
                j.i("AnalyticsMgr[init] start", "sdk_version", com.alibaba.analytics.b.a.a().E());
                b = application;
                HandlerThread handlerThread = new HandlerThread("Analytics_Client");
                f599a = handlerThread;
                try {
                    handlerThread.start();
                } catch (Throwable th) {
                    j.e("AnalyticsMgr", "1", th);
                }
                Looper looper = null;
                for (int i = 0; i < 3; i++) {
                    try {
                        looper = f599a.getLooper();
                        if (looper != null) {
                            break;
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (Throwable th2) {
                            j.e("AnalyticsMgr", "2", th2);
                        }
                    } catch (Throwable th3) {
                        j.e("AnalyticsMgr", "3", th3);
                        d dVar = new d(looper);
                        f601a = dVar;
                        dVar.postAtFrontOfQueue(new c());
                        f607a = true;
                        j.d("外面init完成", new Object[0]);
                        j.w("AnalyticsMgr", "isInit", Boolean.valueOf(f607a), "sdk_version", com.alibaba.analytics.b.a.a().E());
                    }
                    j.w("AnalyticsMgr", "5", th);
                }
                d dVar2 = new d(looper);
                f601a = dVar2;
                try {
                    dVar2.postAtFrontOfQueue(new c());
                } catch (Throwable th4) {
                    j.e("AnalyticsMgr", "4", th4);
                }
                f607a = true;
                j.d("外面init完成", new Object[0]);
            }
        } catch (Throwable th5) {
            j.w("AnalyticsMgr", "5", th5);
            j.w("AnalyticsMgr", "isInit", Boolean.valueOf(f607a), "sdk_version", com.alibaba.analytics.b.a.a().E());
        }
        j.w("AnalyticsMgr", "isInit", Boolean.valueOf(f607a), "sdk_version", com.alibaba.analytics.b.a.a().E());
    }

    public static void removeGlobalProperty(String str) {
        if (m87a() && !u.isEmpty(str) && f612c.containsKey(str)) {
            f612c.remove(str);
            f601a.a(c(str));
        }
    }

    public static void restart() {
        Map<String, String> map;
        j.d("[restart]", new Object[0]);
        try {
            if (f611b) {
                f611b = false;
                m89b();
                m84a().run();
                a(f613c, g, appKey, f609b).run();
                a(f604a).run();
                b(c).run();
                a(d, e, f).run();
                b(f606a).run();
                if (f614d) {
                    c().run();
                }
                boolean z = f615e;
                if (z && (map = f610b) != null) {
                    c(map).run();
                } else if (z) {
                    m88b().run();
                }
                synchronized (f605a) {
                    int i = 0;
                    while (true) {
                        List<a> list = f605a;
                        if (i >= list.size()) {
                            break;
                        }
                        a aVar = list.get(i);
                        if (aVar != null) {
                            try {
                                a(aVar.module, aVar.monitorPoint, aVar.f618b, aVar.b, aVar.k).run();
                            } catch (Throwable th) {
                                j.e("AnalyticsMgr", "[RegisterTask.run]", th);
                            }
                        }
                        i++;
                        throw th;
                    }
                }
                for (Map.Entry<String, String> entry : f612c.entrySet()) {
                    setGlobalProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th2) {
            j.e("AnalyticsMgr", "[restart]", th2);
        }
    }

    public static void setAppVersion(String str) {
        j.i(null, "aAppVersion", str);
        if (m87a()) {
            f601a.a(b(str));
            c = str;
        }
    }

    public static void setGlobalProperty(String str, String str2) {
        if (m87a()) {
            if (u.isEmpty(str) || str2 == null) {
                j.e("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
            } else {
                f612c.put(str, str2);
                f601a.a(a(str, str2));
            }
        }
    }

    public static void setSessionProperties(Map<String, String> map) {
        if (m87a()) {
            f601a.a(c(map));
        }
    }

    public static void turnOffRealTimeDebug() {
        if (m87a()) {
            f601a.a(m88b());
            f615e = false;
        }
    }

    public static void turnOnDebug() {
        j.i("turnOnDebug", new Object[0]);
        if (m87a()) {
            f601a.a(c());
            f614d = true;
            j.setDebug(true);
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        if (m87a()) {
            f601a.a(a(map));
            f610b = map;
            f615e = true;
        }
    }

    public static void updateSessionProperties(Map<String, String> map) {
        if (m87a()) {
            f601a.a(b(map));
            f606a = map;
        }
    }

    public static void updateUserAccount(String str, String str2, String str3) {
        j.i("AnalyticsMgr", "Usernick", str, "Userid", str2, dx7.c, str3);
        if (m87a()) {
            f601a.a(a(str, str2, str3));
            d(str, str2, str3);
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static void m91c() {
        if (m87a()) {
            f601a.a(e());
        }
    }

    private static Runnable d() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.dispatchLocalHits();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m89b() {
        f600a = RunMode.Local;
        f602a = new AnalyticsImp(b);
        j.w("Start AppMonitor Service failed,AppMonitor run in local Mode...", new Object[0]);
    }

    private static void d(String str, String str2, String str3) {
        d = str;
        if (TextUtils.isEmpty(str2)) {
            e = null;
            f = null;
        } else {
            if (TextUtils.isEmpty(str3) && str2.equals(e)) {
                return;
            }
            e = str2;
            f = str3;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m85a(String str) {
        if (m87a()) {
            f601a.a(a(str));
            f604a = str;
        }
    }

    private static Runnable c() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.turnOnDebug();
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable c(final Map<String, String> map) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.setSessionProperties(map);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m90b() {
        Application application = b;
        if (application == null) {
            return false;
        }
        boolean zBindService = application.getApplicationContext().bindService(new Intent(b.getApplicationContext(), (Class<?>) AnalyticsService.class), f23740a, 1);
        if (!zBindService) {
            m89b();
        }
        j.i("AnalyticsMgr", "bindsuccess", Boolean.valueOf(zBindService));
        return zBindService;
    }

    private static Runnable c(final String str) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.removeGlobalProperty(str);
                } catch (RemoteException e2) {
                    AnalyticsMgr.a(e2);
                }
            }
        };
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m86a(boolean z, boolean z2, String str, String str2) {
        if (m87a()) {
            f601a.a(a(z, z2, str, str2));
            f613c = z;
            appKey = str;
            f609b = str2;
            g = z2;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static Runnable m88b() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.turnOffRealTimeDebug();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m87a() {
        if (!f607a) {
            j.d("Please call init() before call other method", new Object[0]);
        }
        return f607a;
    }

    private static Runnable b(final String str) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.setAppVersion(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable b(final Map<String, String> map) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.updateSessionProperties(map);
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Runnable m84a() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.9
            @Override // java.lang.Runnable
            public void run() {
                j.i("call Remote init start...", new Object[0]);
                try {
                    AnalyticsMgr.f602a.a();
                } catch (Throwable th) {
                    j.e("initut error", th, new Object[0]);
                    AnalyticsMgr.m89b();
                    try {
                        AnalyticsMgr.f602a.a();
                    } catch (Throwable th2) {
                        j.e("initut error", th2, new Object[0]);
                    }
                }
                j.i("call Remote init end", new Object[0]);
            }
        };
    }

    private static Runnable a(final Map<String, String> map) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.turnOnRealTimeDebug(map);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable a(final boolean z, final boolean z2, final String str, final String str2) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.a(z, z2, str, str2);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable a(final String str) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.setChannel(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable a(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z) {
        j.d("", new Object[0]);
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.d("register stat event", "module", str, " monitorPoint: ", str2);
                    AnalyticsMgr.f602a.a(str, str2, measureSet, dimensionSet, z);
                } catch (RemoteException e2) {
                    AnalyticsMgr.a(e2);
                }
            }
        };
    }

    private static Runnable a(final String str, final String str2, final String str3) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.updateUserAccount(str, str2, str3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public static void a(Exception exc) {
        j.w("", exc, new Object[0]);
        if (exc instanceof DeadObjectException) {
            restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a() {
        String strA = com.alibaba.analytics.a.a.a(b.getApplicationContext(), "UTANALYTICS_REMOTE_SERVICE_DELAY_SECOND");
        if (TextUtils.isEmpty(strA)) {
            return 10;
        }
        try {
            int iIntValue = Integer.valueOf(strA).intValue();
            if (iIntValue < 0 || iIntValue > 30) {
                return 10;
            }
            return iIntValue;
        } catch (Throwable unused) {
            return 10;
        }
    }

    private static Runnable a(final String str, final String str2) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.f602a.setGlobalProperty(str, str2);
                } catch (RemoteException e2) {
                    AnalyticsMgr.a(e2);
                }
            }
        };
    }
}
