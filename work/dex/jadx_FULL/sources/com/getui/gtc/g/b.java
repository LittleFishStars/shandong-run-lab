package com.getui.gtc.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.SdkLoader;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.igexin.push.GtPushInterface;
import com.igexin.push.core.g;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, ClassLoader> f30365a = new HashMap();

    public static ClassLoader a(Bundle bundle) {
        return f30365a.get(bundle.getString("cn"));
    }

    public static void a(Context context, ClassLoader classLoader, String str, String str2, String str3) throws Throwable {
        Class<?> clsLoadClass = classLoader.loadClass(str);
        com.getui.gtc.i.c.a.a("start load for class:" + str + ", appId: " + str2 + ", cid: " + str3);
        clsLoadClass.getDeclaredMethod("onCreate", Context.class, String.class, String.class).invoke(clsLoadClass.newInstance(), context, str2, str3);
        com.getui.gtc.i.c.a.a("load success for class:".concat(String.valueOf(str)));
        f30365a.put(str, classLoader);
    }

    public static void a(Context context, String str, String str2, String str3) throws Throwable {
        a(context, context.getClassLoader(), str, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) throws Throwable {
        Method declaredMethod = SdkLoader.class.getDeclaredMethod(TrackLoadSettingsAtom.TYPE, Context.class, String.class, String.class, String.class, String.class, String.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SdkLoader.class, context, str, str2, str3, str4, str5);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, com.getui.gtc.g.a.b bVar) {
        com.getui.gtc.g.a.a aVar = new com.getui.gtc.g.a.a(bVar);
        if (aVar.b != null) {
            aVar.a(str, str2, str3, str4, str5);
            return;
        }
        try {
            Class<?> cls = (Class) com.getui.gtc.g.a.a.a(context, Class.forName(g.f)).second;
            if (cls == null) {
                cls = Class.forName(g.f);
            }
            Intent intent = new Intent(context, cls);
            intent.setType(BuildConfig.VERSION_NAME);
            context.bindService(intent, new ServiceConnection() { // from class: com.getui.gtc.g.a.a.2

                /* JADX INFO: renamed from: a */
                final /* synthetic */ String f30364a;
                final /* synthetic */ String b;
                final /* synthetic */ String c;
                final /* synthetic */ String d;
                final /* synthetic */ String e;

                public AnonymousClass2() {
                    str = str;
                    str = str2;
                    str = str3;
                    str = str4;
                    str = str5;
                }

                @Override // android.content.ServiceConnection
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    a.this.b = GtPushInterface.Stub.asInterface(iBinder);
                    a.this.a(str, str, str, str, str);
                }

                @Override // android.content.ServiceConnection
                public final void onServiceDisconnected(ComponentName componentName) {
                    a.this.b = null;
                }
            }, 1);
        } catch (Exception e) {
            com.getui.gtc.i.c.a.c(e);
        }
    }

    public static boolean a(Context context, Bundle bundle) {
        try {
            String string = bundle.getString(t.q);
            String string2 = bundle.getString("ad");
            String string3 = bundle.getString("gd");
            String string4 = bundle.getString("od");
            String string5 = bundle.getString("cn");
            if (string == null) {
                a(context, string5, string2, string3);
                return true;
            }
            a(context, string, string4, string5, string2, string3);
            return true;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th.toString());
            return false;
        }
    }
}
