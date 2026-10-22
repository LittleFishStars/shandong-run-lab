package com.hailiang.advlib.open;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.hailiang.advlib.common.d;
import com.hailiang.advlib.open.oaid.hla.e;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class a implements com.hailiang.advlib.open.b {
    private Object c;
    private long d;
    private Context e;
    private boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32573a = "";
    private String b = "";
    public boolean g = true;

    /* JADX INFO: renamed from: com.hailiang.advlib.open.a$a, reason: collision with other inner class name */
    @Keep
    public class RunnableC0767a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f32574a;
        final a b;

        public RunnableC0767a(a aVar, Context context) {
            this.b = aVar;
            this.f32574a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.acquireOAID(this.f32574a);
        }
    }

    @Keep
    public class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f32575a;

        public b(a aVar) {
            this.f32575a = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object objInvoke;
            if (method != null) {
                try {
                    if ("OnSupport".equals(method.getName())) {
                        objInvoke = objArr[1].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                    } else {
                        objInvoke = "onSupport".equals(method.getName()) ? objArr[0].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]) : null;
                    }
                    if (objInvoke instanceof String) {
                        this.f32575a.f32573a = (String) objInvoke;
                    }
                    if (TextUtils.isEmpty(this.f32575a.f32573a)) {
                        if (TextUtils.isEmpty(this.f32575a.b)) {
                            this.f32575a.a();
                        } else {
                            a aVar = this.f32575a;
                            aVar.f32573a = aVar.b;
                        }
                    }
                } catch (Throwable th) {
                    a aVar2 = this.f32575a;
                    aVar2.a("oaid_ref_exp", aVar2.c, String.valueOf(th.getMessage()), method);
                    th.printStackTrace();
                }
            }
            return null;
        }
    }

    @Keep
    public class c implements com.hailiang.advlib.open.oaid.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f32576a;

        public c(a aVar) {
            this.f32576a = aVar;
        }

        @Override // com.hailiang.advlib.open.oaid.a
        public void a(Exception exc) {
        }

        @Override // com.hailiang.advlib.open.oaid.a
        public void a(String str) {
            this.f32576a.f32573a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (TextUtils.isEmpty(this.f32573a)) {
            e.a(this.e).a(new c(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Object obj, String str2, Method method) {
        try {
            HashMap map = new HashMap();
            map.put("op1", str);
            map.put("opt_oaid_code", "" + obj);
            if (!TextUtils.isEmpty(str2)) {
                map.put("op2", str2);
            }
            if (method != null) {
                map.put("opt_reflect_method", method.toString());
            }
            com.hailiang.advlib.common.e.b(this.e, "init_oaid", map);
        } catch (Throwable unused) {
        }
    }

    private boolean a(String str) {
        return str.equals("00000000000000000000000000000000") || str.equals("00000000-0000-0000-0000-000000000000");
    }

    private boolean b() {
        return false;
    }

    @Override // com.hailiang.advlib.open.b
    public void acquireOAID(Context context) {
        Class<?> cls;
        if (this.g && !this.f && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.f32573a)) {
            this.f = true;
            this.e = context;
            if (context != null) {
                if (this.d == 0 || System.currentTimeMillis() - this.d > 1000) {
                    try {
                        if (b()) {
                            this.d = System.currentTimeMillis();
                            this.c = -1000;
                            a();
                            return;
                        }
                        Class<?> cls2 = Class.forName(new String(Base64.decode("Y29tLmJ1bi5taWl0bWRpZC5jb3JlLk1kaWRTZGtIZWxwZXI", 3)));
                        try {
                            cls = Class.forName(new String(Base64.decode("Y29tLmJ1bi5taWl0bWRpZC5pbnRlcmZhY2VzLklJZGVudGlmaWVyTGlzdGVuZXI", 3)));
                        } catch (ClassNotFoundException unused) {
                            cls = Class.forName(new String(Base64.decode("Y29tLmJ1bi5zdXBwbGllci5JSWRlbnRpZmllckxpc3RlbmVy", 3)));
                        }
                        d dVarA = d.b(cls2).a("InitSdk", context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{cls}, new b(this)));
                        if (dVarA != null) {
                            this.c = dVarA.d();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        a("oaid_exception", this.c, String.valueOf(th.getMessage()), null);
                    }
                    try {
                        Object obj = this.c;
                        if (obj == null || ((obj instanceof Integer) && ((Integer) obj).intValue() != 1008610 && ((Integer) this.c).intValue() != 1008614)) {
                            a();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    this.d = System.currentTimeMillis();
                }
            }
        }
    }

    @Override // com.hailiang.advlib.open.b
    public void asyncAcquireOAID(Context context) {
        com.hailiang.advlib.common.e.a(new RunnableC0767a(this, context));
    }

    @Override // com.hailiang.advlib.open.b
    public String getOaid() {
        return this.f32573a;
    }

    @Override // com.hailiang.advlib.open.b
    public void setIsCanUseOaid(Context context, boolean z) {
        this.g = z;
    }

    @Override // com.hailiang.advlib.open.b
    public void setOaid(String str) {
        if (TextUtils.isEmpty(str) || a(str)) {
            return;
        }
        this.b = str;
        if (TextUtils.isEmpty(this.f32573a)) {
            this.f32573a = this.b;
        }
    }
}
