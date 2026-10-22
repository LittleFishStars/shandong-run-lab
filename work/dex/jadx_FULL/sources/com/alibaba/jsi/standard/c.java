package com.alibaba.jsi.standard;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import androidx.camera.core.CameraInfo;
import com.alibaba.jsi.standard.js.Bridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    private static final Map<String, Long> e = new HashMap();
    private static final Map<Long, c> f = new HashMap();
    private static final Object g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24573a;
    private final Handler b;
    private long h;
    private final ArrayList<b> c = new ArrayList<>();
    private final Runnable d = new a(4);
    private boolean i = true;
    private boolean j = false;
    private final Set<com.alibaba.jsi.standard.js.b> k = new HashSet();

    private c(Context context, String str, String str2, String str3, long j, Handler handler) {
        String strA;
        String str4;
        this.h = 0L;
        if (context != null) {
            e.a(context);
        }
        this.f24573a = str;
        this.b = handler == null ? new Handler(Looper.myLooper()) : handler;
        if (j != 0) {
            this.h = j;
            return;
        }
        if (context != null) {
            String packageName = context.getPackageName();
            strA = a(context, packageName);
            str4 = packageName;
        } else {
            strA = "";
            str4 = strA;
        }
        JNIBridge.nativeSetInfo(0L, "app-package", str4, 0L);
        JNIBridge.nativeSetInfo(0L, "app-version", strA, 0L);
        this.h = JNIBridge.nativeInitInstance(e.f24576a + WVNativeCallbackUtil.SEPERATER + str3, str, str2);
        c(0L);
    }

    public static String k() {
        Object objCmd = Bridge.cmd(null, 4);
        if (objCmd == null || !(objCmd instanceof String)) {
            return null;
        }
        return (String) objCmd;
    }

    public static String l() {
        return JNIBridge.nativeGetVersion(null);
    }

    public static int m() {
        return (int) JNIBridge.nativeCommand(3L, 0L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        b bVar;
        synchronized (this.c) {
            bVar = this.c.size() > 0 ? this.c.get(0) : null;
        }
        synchronized (this.k) {
            d.a(bVar, this.k, this.f24573a);
        }
    }

    public String c() {
        return this.f24573a;
    }

    public void d() {
        a(false);
    }

    public boolean e() {
        return this.h == 0;
    }

    public List<b> f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.c) {
            Iterator<b> it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public int g() {
        int size;
        synchronized (this.c) {
            size = this.c.size();
        }
        return size;
    }

    public void h() {
        this.b.post(new a(2));
    }

    public void i() {
        this.b.post(new a(5));
    }

    public void j() {
        this.b.post(new a(3));
    }

    public static c b() {
        Object objCmd = Bridge.cmd(null, 3);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return null;
        }
        return a(((Long) objCmd).longValue());
    }

    public long a() {
        return this.h;
    }

    public final void c(long j) {
        this.b.removeCallbacks(this.d);
        this.b.postDelayed(this.d, j);
    }

    public final class a implements Runnable {
        private final int b;
        private final Object[] c;

        public a(int i) {
            this.b = i;
            this.c = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            if (i == 1) {
                Object[] objArr = this.c;
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                Log.d("jsi", "Starting trace");
                if (JNIBridge.nativeStartTrace(c.this.h, str, str2)) {
                    return;
                }
                Log.e("jsi", "Start trace failed!");
                return;
            }
            if (i == 2) {
                Log.d("jsi", "Stopping trace");
                JNIBridge.nativeStopTrace(c.this.h);
                return;
            }
            if (i == 3) {
                c.this.n();
                return;
            }
            if (i == 4) {
                JNIBridge.nativeOnLoop(c.this.h);
            } else {
                if (i == 5) {
                    JNIBridge.nativeOnLowMemory(c.this.h);
                    return;
                }
                Log.e("jsi", "Unknown JSI task " + this.b);
            }
        }

        public a(Object[] objArr) {
            this.b = 1;
            this.c = objArr;
        }
    }

    public final synchronized void a(boolean z) {
        Iterator<b> it = f().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        if (this.j && this.i) {
            Log.i("jsi", "Print java objects at dispose ...");
            n();
        }
        long j = this.h;
        this.h = 0L;
        if (!z) {
            JNIBridge.nativeDisposeInstance(j);
        }
        Map<Long, c> map = f;
        synchronized (map) {
            e.remove(this.f24573a);
            map.remove(Long.valueOf(j));
        }
    }

    public static c b(Context context, Bundle bundle) {
        return a(context, bundle, null);
    }

    public b b(long j) {
        synchronized (this.c) {
            for (b bVar : this.c) {
                if (bVar.e() == j) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public b b(String str) {
        b bVar = new b(str, this);
        synchronized (this.c) {
            this.c.add(bVar);
        }
        c(0L);
        return bVar;
    }

    public static c a(long j) {
        c cVar;
        Map<Long, c> map = f;
        synchronized (map) {
            cVar = map.get(Long.valueOf(j));
        }
        return cVar;
    }

    public void b(boolean z) {
        if (!z) {
            synchronized (this.k) {
                this.k.clear();
            }
        }
        if (this.j != z) {
            d.a(z);
            this.j = z;
        }
        Bridge.engineCmd(this, 5, z ? 1L : 0L);
    }

    public static c a(Context context, String str, String str2, String str3, String str4, long j, Handler handler) {
        c cVar;
        Map<Long, c> map = f;
        synchronized (map) {
            Map<String, Long> map2 = e;
            Long l = map2.get(str);
            if (l != null && l.longValue() != 0 && (cVar = map.get(l)) != null) {
                Log.w("jsi", "Instance '" + str + "' already created!");
                return cVar;
            }
            c cVar2 = new c(context, str, str2, str4, j, handler);
            map2.put(str, Long.valueOf(cVar2.h));
            map.put(Long.valueOf(cVar2.h), cVar2);
            if (str3 != null && str3.length() > 0) {
                cVar2.i = !str3.contains("--disable-print-objects-at-dispose");
                JNIBridge.nativeSetInfo(cVar2.h, "flags", str3, 0L);
            }
            return cVar2;
        }
    }

    public final void b(com.alibaba.jsi.standard.js.b bVar) {
        if (this.j) {
            synchronized (this.k) {
                this.k.remove(bVar);
            }
        }
    }

    public static boolean a(Context context, Bundle bundle) {
        boolean zA;
        if (context == null) {
            throw new NullPointerException("context can not be null");
        }
        if (bundle != null) {
            e.a(context);
            String string = bundle.getString("jsiSoPath");
            if (string == null) {
                string = bundle.getString("p8SoPath");
            }
            String string2 = bundle.getString("jsEngineSoPath");
            synchronized (g) {
                zA = e.a(string, string2);
            }
            return zA;
        }
        throw new NullPointerException("args can not be null");
    }

    public static c a(Context context, Bundle bundle, Handler handler) {
        if (context != null && bundle != null) {
            String string = bundle.getString("name");
            if (string != null) {
                String string2 = bundle.getString("version", "");
                String string3 = bundle.getString("flags", "");
                String string4 = bundle.getString("datadir", null);
                if (string4 == null || string4.trim().length() == 0) {
                    string4 = "shared";
                }
                String str = string4;
                if (!str.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                    return a(context, string, string2, string3, str, 0L, handler);
                }
                throw new IllegalArgumentException("'datadir' can not be a absolute path!");
            }
            throw new RuntimeException("'name' not set!");
        }
        throw new NullPointerException("context and args can not be null!");
    }

    public static c a(String str) {
        Map<Long, c> map = f;
        synchronized (map) {
            Long l = e.get(str);
            if (l == null || l.longValue() == 0) {
                return null;
            }
            return map.get(l);
        }
    }

    public void a(b bVar) {
        if (!bVar.b()) {
            bVar.a();
        }
        synchronized (this.c) {
            this.c.remove(bVar);
        }
        c(0L);
    }

    public void a(String str, String str2) {
        if (str == null) {
            str = "/sdcard/jsi_trace_${pid}_${time}_${index}.json";
        }
        if (str2 == null) {
            str2 = "jsi,v8,v8.compile,disabled-by-default-v8.compile";
        }
        this.b.post(new a(new Object[]{str, str2}));
    }

    public final void a(com.alibaba.jsi.standard.js.b bVar) {
        if (this.j) {
            synchronized (this.k) {
                this.k.add(bVar);
            }
        }
    }

    private static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
        }
    }
}
