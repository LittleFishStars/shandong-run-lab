package com.byazt.px;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28961a;
    public boolean sp;
    public com.byazt.sc.tt ve;
    public static final com.byazt.sc.c uj = new com.byazt.sc.c();
    public static Map<String, Pair<Boolean, String>> n = new ConcurrentHashMap();
    public static final Map<String, Boolean> x = new ConcurrentHashMap();
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final AtomicBoolean tt = new AtomicBoolean(false);

    public static void c(String str, Pair<Boolean, String> pair) {
        n.put(str, pair);
    }

    public static c tt() {
        return new c();
    }

    public static com.byazt.sc.c uj() {
        return uj;
    }

    public static synchronized void ve() {
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.px.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
                for (Map.Entry entry : c.n.entrySet()) {
                    if (entry.getValue() != null) {
                        if (!((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                            com.byazt.eu.tt.uj("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化失败 " + ((String) ((Pair) entry.getValue()).second));
                        } else if (com.byazt.bp.tt.tt().ve((String) entry.getKey())) {
                            com.byazt.eu.tt.uj("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果");
                        } else {
                            com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                        }
                    }
                }
                com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
            }
        });
    }

    public void a() {
        if (!this.f28961a && this.sp && this.c.get() && this.tt.get()) {
            com.byazt.sx.c.c();
            ve();
        }
    }

    public void n() {
        if (!com.byazt.bp.tt.tt().ve()) {
            com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.px.c.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.sc.tt ttVar = c.this.ve;
                    if (ttVar != null) {
                        ttVar.c();
                    }
                }
            });
            return;
        }
        com.byazt.sc.tt ttVar = this.ve;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    public static int c() {
        return n.size();
    }

    public static Map<String, Object> tt(Map<String, Object> map, String str) {
        return uj.tt(com.byazt.bp.tt.getContext(), map, str);
    }

    public static String c(Map<String, Object> map, String str) {
        return uj.c(com.byazt.bp.tt.getContext(), map, str);
    }

    public static final synchronized boolean ve(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                str = str + "_pl";
            }
            Boolean bool = x.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public void tt(Map<String, com.byazt.nbs.c> map) {
        if (map == null) {
            return;
        }
        com.byazt.nbs.c cVarRemove = map.remove(MediationConstant.ADN_MINTEGRAL);
        final ArrayList arrayList = new ArrayList();
        if (cVarRemove != null) {
            arrayList.add(cVarRemove);
        }
        Runnable runnable = new Runnable() { // from class: com.byazt.px.c.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    new com.byazt.uu.c((com.byazt.nbs.c) it.next()).uj();
                }
                c.this.c.set(true);
                c.this.a();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.byazt.eu.n.ve(runnable);
        }
    }

    public static com.byazt.id.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return uj.c(str);
    }

    public void c(Map<String, com.byazt.nbs.c> map) {
        com.byazt.nbs.c cVarRemove;
        if (map == null || (cVarRemove = map.remove("gdt")) == null) {
            return;
        }
        new com.byazt.uu.c(cVarRemove).uj();
    }

    public void c(final Context context, Map<String, com.byazt.nbs.c> map) {
        if (map == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, com.byazt.nbs.c>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            com.byazt.nbs.c value = it.next().getValue();
            if (value != null) {
                if (value.n()) {
                    arrayList.add(value);
                } else {
                    arrayList2.add(value);
                }
            }
        }
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.px.c.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    new com.byazt.uu.c((com.byazt.nbs.c) it2.next()).uj();
                }
                com.byazt.sx.tt.c(context, (List<com.byazt.nbs.c>) arrayList);
                c.this.tt.set(true);
                c.this.a();
            }
        });
    }

    public static final synchronized void tt(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                str = str + "_pl";
            }
            x.put(str, Boolean.TRUE);
        }
    }

    public void c(Context context, boolean z, boolean z2, JSONObject jSONObject, com.byazt.sc.tt ttVar) {
        this.ve = ttVar;
        this.c.set(false);
        this.tt.set(false);
        this.f28961a = z;
        this.sp = z2;
        c(context, jSONObject);
    }

    public void c(Context context, JSONObject jSONObject) {
        Map<String, com.byazt.nbs.c> mapVe = com.byazt.ck.ve.c().ve();
        if (com.byazt.bp.tt.tt().ve()) {
            n();
            c(mapVe);
            com.byazt.tjo.a.c(jSONObject, "s-gdt");
        } else {
            c(mapVe);
            com.byazt.tjo.a.c(jSONObject, "s-gdt");
            n();
        }
        tt(mapVe);
        c(context, mapVe);
    }

    public static void c(String str, boolean z) {
        com.byazt.nbs.c cVarC;
        if (TextUtils.isEmpty(str) || TextUtils.equals(MediationConstant.ADN_PANGLE, str) || ve(str, z) || (cVarC = com.byazt.bp.tt.tt().c(str)) == null) {
            return;
        }
        final com.byazt.uu.c cVar = new com.byazt.uu.c(cVarC);
        if ((TextUtils.equals(MediationConstant.ADN_MINTEGRAL, str) || TextUtils.equals(MediationConstant.ADN_KLEVIN, str)) && !com.byazt.eu.n.n()) {
            com.byazt.eu.n.tt(new Runnable() { // from class: com.byazt.px.c.5
                @Override // java.lang.Runnable
                public void run() {
                    cVar.uj();
                }
            });
        } else {
            cVar.uj();
        }
    }
}
