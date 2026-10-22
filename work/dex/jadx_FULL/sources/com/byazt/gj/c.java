package com.byazt.gj;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.ds.i;
import com.byazt.yv.da;
import com.byazt.za.Collector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 150, 20})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f28570a = true;

    @SuppressLint({"StaticFieldLeak"})
    public static i c = null;

    @SuppressLint({"StaticFieldLeak"})
    public static volatile com.byazt.ds.x n = null;
    public static boolean sp = false;
    public static boolean tt = true;
    public static tt uj;
    public static ConcurrentHashMap<String, String> ve = new ConcurrentHashMap<>(4);
    public static volatile uj x;

    @Nullable
    public static JSONObject a() {
        if (n != null) {
            return n.gt();
        }
        return null;
    }

    public static void c(@NonNull Context context, @NonNull x xVar) {
        if (n != null) {
            da.tt(new RuntimeException("Init Twice!"));
            return;
        }
        if (xVar.eo() == null) {
            da.tt(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        com.byazt.lu.uj ujVarN = com.byazt.lu.uj.n();
        com.byazt.ds.x xVar2 = new com.byazt.ds.x(application, xVar);
        n = xVar2;
        i iVar = new i(application, xVar2);
        ujVarN.c(application, xVar2, iVar, new com.byazt.za.c(xVar.i()));
        c = iVar;
        if (n.nu()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        da.uj("Inited", null);
    }

    public static String da() {
        i iVar = c;
        return iVar != null ? iVar.da() : "";
    }

    public static String i() {
        i iVar = c;
        return iVar != null ? iVar.sp() : "";
    }

    public static String n() {
        i iVar = c;
        if (iVar != null) {
            return iVar.yp();
        }
        return null;
    }

    public static String sl() {
        i iVar = c;
        return iVar != null ? iVar.sl() : "";
    }

    public static String sp() {
        i iVar = c;
        return iVar != null ? iVar.x() : "";
    }

    @NonNull
    public static ve t() {
        return com.byazt.yv.tt.c();
    }

    public static void tt() {
        com.byazt.lu.uj.c();
    }

    public static x u() {
        if (n != null) {
            return n.bm();
        }
        return null;
    }

    public static tt uj() {
        return uj;
    }

    public static uj ve() {
        return x;
    }

    public static boolean x() {
        return true;
    }

    public static void yp() {
        com.byazt.lu.uj.n().i();
    }

    public static void z() {
        com.byazt.lu.uj.n().da();
    }

    public static void tt(@NonNull String str, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            da.tt("call onEventData with invalid params, return", null);
            return;
        }
        try {
            com.byazt.lu.uj.c(new com.byazt.tv.uj(str, jSONObject));
        } catch (Exception e) {
            da.ve("call onEventData get exception: ", e);
        }
    }

    public static void c(boolean z) {
        tt = z;
    }

    public static void c() {
        i iVar;
        if (!tt || (iVar = c) == null) {
            return;
        }
        iVar.uj();
    }

    public static void c(HashMap<String, Object> map) {
        i iVar = c;
        if (iVar != null) {
            iVar.c(map);
        }
    }

    public static <T> T c(String str, T t) {
        i iVar = c;
        if (iVar != null) {
            return (T) iVar.c(str, t);
        }
        return null;
    }

    public static void c(@NonNull String str, @Nullable JSONObject jSONObject) {
        com.byazt.lu.uj.c(new com.byazt.tv.n(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void c(@NonNull String str, @Nullable JSONObject jSONObject, int i) {
        com.byazt.lu.uj.c(new com.byazt.tv.n(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void c(@NonNull String str, @Nullable Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        da.tt(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        c(str, jSONObject);
    }

    public static void c(@NonNull String str, @Nullable Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        da.tt(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        c(str, jSONObject, i);
    }

    @AnyThread
    public static void c(@Nullable n nVar) {
        com.byazt.vm.sp.c(nVar);
    }
}
