package com.czhj.devicehelper.msaoaId;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0616a f29376a;
    private static String b;
    private static String c;
    private static Class<?> d;
    private static Class<?> e;
    private static Class<?> f;
    private static Class<?> g;
    private static String h;
    private static final List<String> i = new LinkedList<String>() { // from class: com.czhj.devicehelper.msaoaId.a.1
        {
            add("00000000-0000-0000-0000-000000000000");
            add("00000000000000000000000000000000");
        }
    };
    private static final List<String> j = new LinkedList<String>() { // from class: com.czhj.devicehelper.msaoaId.a.2
        {
            add("msaoaidsec");
            add("nllvm1632808251147706677");
            add("nllvm1630571663641560568");
            add("nllvm1623827671");
        }
    };

    /* JADX INFO: renamed from: com.czhj.devicehelper.msaoaId.a$a, reason: collision with other inner class name */
    public interface InterfaceC0616a {
        void a(String str);
    }

    public static class b implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (!"OnSupport".equalsIgnoreCase(method.getName())) {
                    return null;
                }
                Method declaredMethod = a.e.getDeclaredMethod("getOAID", new Class[0]);
                String unused = a.c = (String) (objArr.length == 1 ? declaredMethod.invoke(objArr[0], new Object[0]) : declaredMethod.invoke(objArr[1], new Object[0]));
                if (a.f29376a != null) {
                    a.f29376a.a(a.c);
                }
                SigmobLog.e("MdidSdkHelper oaid:" + a.c);
                return null;
            } catch (Throwable unused2) {
                if (a.f29376a == null) {
                    return null;
                }
                a.f29376a.a(a.c);
                return null;
            }
        }
    }

    static {
        e();
    }

    private static void a(Context context) {
        try {
            d();
            if (context != null && g != null && d != null && e != null) {
                if (TextUtils.isEmpty(c)) {
                    b(context);
                    return;
                }
                InterfaceC0616a interfaceC0616a = f29376a;
                if (interfaceC0616a != null) {
                    interfaceC0616a.a(c);
                    return;
                }
                return;
            }
            SigmobLog.e("OAID 读取类创建失败");
            InterfaceC0616a interfaceC0616a2 = f29376a;
            if (interfaceC0616a2 != null) {
                interfaceC0616a2.a(c);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            InterfaceC0616a interfaceC0616a3 = f29376a;
            if (interfaceC0616a3 != null) {
                interfaceC0616a3.a(c);
            }
        }
    }

    public static void a(Context context, InterfaceC0616a interfaceC0616a) {
        f29376a = interfaceC0616a;
        a(context);
    }

    public static void a(String str) {
        b = str;
    }

    private static void b(Context context) {
        InterfaceC0616a interfaceC0616a;
        try {
            c(context);
            try {
                Class<?> cls = f;
                if (cls != null && cls.getField("classLoader").get(f) == null) {
                    f.getDeclaredMethod("InitEntry", Context.class).invoke(f, context);
                }
            } catch (Exception unused) {
            }
            int iIntValue = ((Integer) g.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, d).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{d}, new b()))).intValue();
            SigmobLog.e("MdidSdkHelper ErrorCode : " + iIntValue);
            if (iIntValue == 1008614 || iIntValue == 1008610 || (interfaceC0616a = f29376a) == null) {
                return;
            }
            interfaceC0616a.a(c);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            InterfaceC0616a interfaceC0616a2 = f29376a;
            if (interfaceC0616a2 != null) {
                interfaceC0616a2.a(c);
            }
        }
    }

    public static void b(String str) {
        h = str;
    }

    private static void c(Context context) {
        try {
            String strD = !TextUtils.isEmpty(b) ? b : d(context);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            g.getDeclaredMethod("InitCert", Context.class, String.class).invoke(null, context, strD);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private static String d(Context context) {
        InputStream inputStreamOpen;
        try {
            String str = context.getPackageName() + ".cert.pem";
            AssetManager assets = context.getAssets();
            if (TextUtils.isEmpty(h)) {
                inputStreamOpen = assets.open(str);
            } else {
                try {
                    inputStreamOpen = assets.open(h);
                } catch (IOException unused) {
                    inputStreamOpen = assets.open(str);
                }
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            }
        } catch (IOException unused2) {
            SigmobLog.d("loadPemFromAssetFile failed");
            return "";
        }
    }

    private static void d() {
        try {
            g = MdidSdkHelper.class;
            try {
                try {
                    try {
                        d = IIdentifierListener.class;
                        e = IdSupplier.class;
                    } catch (Exception unused) {
                        d = Class.forName("com.bun.supplier.IIdentifierListener");
                        e = Class.forName("com.bun.supplier.IdSupplier");
                        f = Class.forName("com.bun.miitmdid.core.JLibrary");
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                d = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                e = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                f = Class.forName("com.bun.miitmdid.core.JLibrary");
            }
        } catch (ClassNotFoundException e2) {
            SigmobLog.e(e2.getMessage());
        }
    }

    private static void e() {
        Iterator<String> it = j.iterator();
        while (it.hasNext()) {
            try {
                System.loadLibrary(it.next());
                return;
            } catch (Throwable unused) {
            }
        }
    }
}
