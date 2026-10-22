package com.igexin.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.igexin.push.b.b;
import com.igexin.push.g.c;
import com.igexin.push.g.d;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushService;
import com.zx.sdk.api.ZXID;
import com.zx.sdk.api.ZXIDListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements InvocationHandler {
    private static String b = "ZxExecutor";
    private static volatile a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f37850a;

    /* JADX INFO: renamed from: com.igexin.d.a$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.c(a.this.f37850a)) {
                    a aVar = a.this;
                    a.a(aVar, aVar.f37850a);
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.d.a$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37852a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        public AnonymousClass2(Context context, String str, String str2) {
            this.f37852a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Class cls = (Class) d.a(this.f37852a, PushService.class).second;
                if (cls != null) {
                    Intent intent = new Intent(this.f37852a, (Class<?>) cls);
                    intent.putExtra("action", PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253);
                    intent.putExtra("id", this.b);
                    intent.putExtra("aid", this.c);
                    c.a(this.f37852a, intent);
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    a aVar = new a();
                    c = aVar;
                    return aVar;
                }
            }
        }
        return c;
    }

    public static /* synthetic */ void a(a aVar, Context context) {
        try {
            Class<?> cls = Class.forName("com.zx.sdk.api.ZXManager");
            Object objInvoke = cls.getDeclaredMethod("newSDK", String.class).invoke(cls, com.igexin.push.a.r);
            Method declaredMethod = objInvoke.getClass().getDeclaredMethod("init", Context.class);
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("allowPermissionDialog", Boolean.TYPE);
            declaredMethod.invoke(objInvoke, context);
            declaredMethod2.invoke(objInvoke, Boolean.FALSE);
            objInvoke.getClass().getDeclaredMethod("getZXID", ZXIDListener.class).invoke(objInvoke, Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{ZXIDListener.class}, aVar));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(String str, String str2, Context context) {
        com.igexin.b.a.a().f37791a.execute(new AnonymousClass2(context, str, str2));
    }

    private void b(Context context) {
        this.f37850a = context.getApplicationContext();
        com.igexin.b.a.a().b().schedule(new AnonymousClass1(), 2000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x004e A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:26:0x0046, B:30:0x004e), top: B:38:0x0046 }] */
    public static boolean c(Context context) throws Throwable {
        b bVar;
        Cursor cursorA = null;
        try {
            bVar = new b(context);
            try {
                cursorA = bVar.a("config", new String[]{"value"}, "id = 79");
                if (cursorA == null || !cursorA.moveToFirst()) {
                    if (cursorA != null) {
                        try {
                            cursorA.close();
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                    bVar.close();
                    return false;
                }
                boolean z = Boolean.parseBoolean(cursorA.getString(0));
                try {
                    cursorA.close();
                    bVar.close();
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                if (cursorA != null) {
                    try {
                        cursorA.close();
                        if (bVar != null) {
                            bVar.close();
                        }
                    } catch (Throwable th4) {
                        com.igexin.c.a.c.a.a(th4);
                        throw th;
                    }
                } else if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bVar = null;
        }
    }

    private void d(Context context) {
        try {
            Class<?> cls = Class.forName("com.zx.sdk.api.ZXManager");
            Object objInvoke = cls.getDeclaredMethod("newSDK", String.class).invoke(cls, com.igexin.push.a.r);
            Method declaredMethod = objInvoke.getClass().getDeclaredMethod("init", Context.class);
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("allowPermissionDialog", Boolean.TYPE);
            declaredMethod.invoke(objInvoke, context);
            declaredMethod2.invoke(objInvoke, Boolean.FALSE);
            objInvoke.getClass().getDeclaredMethod("getZXID", ZXIDListener.class).invoke(objInvoke, Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{ZXIDListener.class}, this));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        byte b2;
        try {
            String name = method.getName();
            int iHashCode = name.hashCode();
            if (iHashCode != -530890460) {
                if (iHashCode == 1116433148 && name.equals("onFailed")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (name.equals("onSuccess")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                Object obj2 = objArr[0];
                com.igexin.c.a.c.a.b(b, " get zxid success ".concat(String.valueOf(obj2)));
                JSONObject jSONObject = (JSONObject) ZXID.class.getDeclaredMethod("getAids", new Class[0]).invoke(obj2, new Object[0]);
                com.igexin.b.a.a().f37791a.execute(new AnonymousClass2(this.f37850a, obj2.toString(), jSONObject instanceof JSONObject ? jSONObject.optString("venderAid", "") : ""));
                return null;
            }
            if (b2 != 1) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj3 : objArr) {
                sb.append(obj3);
                sb.append(",");
            }
            com.igexin.c.a.c.a.a("ZxExecutor | ", " get zxid failed code  msg = ".concat(String.valueOf(sb)));
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
