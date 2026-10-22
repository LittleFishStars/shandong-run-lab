package com.alibaba.jsi.standard;

import android.util.Log;
import com.alibaba.jsi.standard.js.Bridge;
import com.alibaba.jsi.standard.js.i;
import com.alibaba.jsi.standard.js.o;
import com.alibaba.jsi.standard.js.w;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    private static final Map<Long, b> h = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f24572a;
    private String b;
    private final c c;
    private long d;
    private final long e;
    private final Object f = new Object();
    private boolean g = false;

    public b(String str, c cVar) {
        this.b = str;
        this.c = cVar;
        long jNativeCreateContext = JNIBridge.nativeCreateContext(cVar.a(), this.b, null);
        this.d = jNativeCreateContext;
        long jNativeCommand = JNIBridge.nativeCommand(2L, jNativeCreateContext, null);
        this.e = jNativeCommand;
        Map<Long, b> map = h;
        synchronized (map) {
            map.put(Long.valueOf(jNativeCommand), this);
        }
    }

    private boolean k() {
        if (!b()) {
            return false;
        }
        Log.e("jsi", "Context has been destroyed! Id: " + this.e);
        return true;
    }

    public void a(a aVar) {
        this.f24572a = aVar;
    }

    public boolean b() {
        return this.g;
    }

    public void c() {
        synchronized (this.f) {
            if (k()) {
                return;
            }
            JNIBridge.nativeResetContext(this.c.a(), this.d);
        }
    }

    public String d() {
        return this.b;
    }

    public long e() {
        return this.e;
    }

    public c f() {
        return this.c;
    }

    public o g() {
        Object objCmd;
        if (k() || (objCmd = Bridge.cmd(this, 10)) == null || !(objCmd instanceof o)) {
            return null;
        }
        return (o) objCmd;
    }

    public boolean h() {
        return (k() || Bridge.cmd(this, 11) == null) ? false : true;
    }

    public i i() {
        Object objCmd;
        if (k() || (objCmd = Bridge.cmd(this, 12)) == null || !(objCmd instanceof i)) {
            return null;
        }
        return (i) objCmd;
    }

    public long j() {
        return this.d;
    }

    public void a() {
        synchronized (this.f) {
            if (k()) {
                return;
            }
            JNIBridge.nativeDisposeContext(this.c.a(), this.d);
            Map<Long, b> map = h;
            synchronized (map) {
                map.remove(Long.valueOf(this.e));
            }
            this.d = 0L;
            this.g = true;
        }
    }

    public w a(String str, String str2) {
        synchronized (this.f) {
            if (k()) {
                return null;
            }
            Object objNativeExecuteJS = JNIBridge.nativeExecuteJS(this.c.a(), this.d, str, str2);
            w wVar = objNativeExecuteJS != null ? (w) objNativeExecuteJS : null;
            this.c.c(0L);
            return wVar;
        }
    }

    public w a(w wVar) {
        o oVarG = g();
        if (oVarG == null) {
            return null;
        }
        w wVarD = oVarG.d(this, wVar);
        oVarG.a();
        return wVarD;
    }

    public w a(String str) {
        o oVarG = g();
        if (oVarG == null) {
            return null;
        }
        w wVarA = oVarG.a(this, str);
        oVarG.a();
        return wVarA;
    }

    public void a(i iVar) {
        if (k()) {
            return;
        }
        Bridge.cmd(this, 13, new Object[]{iVar});
    }

    public static b a(long j) {
        b bVar;
        Map<Long, b> map = h;
        synchronized (map) {
            bVar = map.get(Long.valueOf(j));
        }
        return bVar;
    }
}
