package com.byazt.yf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.triver.basic.api.RequestPermission;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 508, 72})
public final class da {
    public static Context c = null;
    public static c tt = null;
    public static long uj = -1;
    public static long ve = -1;

    @Nullable
    public static String a() {
        return com.byazt.bp.c.t().m();
    }

    public static void c(final Activity activity, final List<u> list, final int i, final int i2) {
        c(new m() { // from class: com.byazt.yf.da.1
            @Override // com.byazt.yf.m
            public void c() {
                com.byazt.ix.uj.c().c(activity, list, i, i2);
            }
        });
    }

    @Nullable
    public static String da() {
        return com.byazt.bp.c.t().u();
    }

    @Nullable
    public static String i() {
        return com.byazt.bp.c.t().my();
    }

    public static boolean n() {
        return com.byazt.bp.c.t().z();
    }

    @Nullable
    public static String sl() {
        return ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getOAID(false);
    }

    @Nullable
    public static Map<String, String> sp() {
        return com.byazt.bp.c.t().nu();
    }

    @Deprecated
    public static void t() {
        com.byazt.bp.tt.tt().uj(com.byazt.rq.c.c().get("if_test", 0));
    }

    public static long tt() {
        return ve;
    }

    @Nullable
    public static Map<String, Object> u() {
        return com.byazt.bp.c.t().or();
    }

    public static String uj() {
        return com.byazt.yl.tt.tt();
    }

    public static long ve() {
        return uj;
    }

    public static boolean x() {
        return com.byazt.omf.x.m().lr();
    }

    @Nullable
    @Deprecated
    public static com.byazt.ly.uj a(String str) {
        return com.byazt.px.tt.c().c(str);
    }

    public static void c(m mVar) {
        com.byazt.bp.tt.tt().c(mVar);
    }

    @Nullable
    @Deprecated
    public static com.byazt.id.c n(String str) {
        return com.byazt.px.c.c(str);
    }

    public static void tt(String str) {
        com.byazt.bp.c.t().n(str);
    }

    @Deprecated
    public static boolean uj(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.byazt.bp.c.t().u())) {
            return false;
        }
        return com.byazt.bp.tt.tt().ve(str);
    }

    @Nullable
    public static String ve(String str) {
        str.hashCode();
        switch (str) {
            case "tt_pangle_preview_ext":
                return com.byazt.jj.n.ve();
            case "tt_pangle_preview_creative_id":
                return com.byazt.jj.n.tt();
            case "tt_pangle_preview_ad_id":
                return com.byazt.jj.n.c();
            default:
                return null;
        }
    }

    public static boolean c() {
        if (TextUtils.isEmpty(com.byazt.bp.c.t().u())) {
            return false;
        }
        return com.byazt.bp.tt.tt().bx();
    }

    public static boolean tt(String str, String str2) {
        return com.byazt.sx.c.tt(str, str2);
    }

    @Deprecated
    public static void tt(int i) {
        com.byazt.bp.tt.tt().uj(i);
    }

    public static void c(@NonNull Context context, @NonNull c cVar) {
        if (ve == -1) {
            ve = System.currentTimeMillis();
            if (cVar != null && cVar.ve()) {
                com.byazt.eu.tt.c();
                com.byazt.hm.c.c();
            }
            com.byazt.eu.tt.tt("TMe", "call init time " + ve);
            c = context;
            tt = cVar;
        }
    }

    public static void c(JSONObject jSONObject) {
        if (c == null || tt == null) {
            return;
        }
        if (uj == -1) {
            uj = System.currentTimeMillis();
            com.byazt.eu.tt.tt("TMe", "call start up time " + uj);
        }
        c(c, tt, jSONObject);
        com.byazt.sx.uj.tt();
    }

    private static void c(@NonNull Context context, @NonNull c cVar, JSONObject jSONObject) {
        com.byazt.bp.c.t().ve(cVar.c());
        com.byazt.bp.c.t().ve(cVar.z());
        com.byazt.ii.c.c().a();
        com.byazt.sx.ve.c(cVar, context.getApplicationContext(), jSONObject);
        com.byazt.ii.c.c().sp();
    }

    public static void c(a aVar) {
        com.byazt.bp.c.t().c(aVar, false);
    }

    public static void c(String str) {
        com.byazt.eu.tt.c(MediationConstant.TAG, "app运行中setPulisherDid: ".concat(String.valueOf(str)));
        com.byazt.bp.c.t().uj(str);
    }

    public static void c(com.byazt.dj.uj ujVar) {
        com.byazt.bp.c.t().tt().tt(com.byazt.px.n.c(ujVar));
        com.byazt.bp.c.t().gu();
        com.byazt.sx.ve.c(com.byazt.px.n.c(ujVar));
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        com.byazt.vx.uj.c(context, intent, null);
    }

    public static void c(Context context, int[] iArr) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra(RequestPermission.PERMISSIONS, iArr);
        if (context != null) {
            com.byazt.vx.uj.c(context, intent, null);
        }
    }

    public static void c(int i) {
        HashMap map = new HashMap();
        map.put(com.byazt.ly.c.n, Integer.valueOf(i));
        Map<String, com.byazt.ly.uj> mapTt = com.byazt.px.tt.c().tt();
        if (mapTt == null || mapTt.size() == 0) {
            return;
        }
        for (com.byazt.ly.uj ujVar : com.byazt.px.tt.c().ve()) {
            if (ujVar != null) {
                ujVar.setThemeStatus(map);
            }
        }
    }

    public static int c(ve veVar) {
        com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c("gdt");
        if (ujVarC == null) {
            return 0;
        }
        return ujVarC.showOpenOrInstallAppDialog(veVar);
    }

    public static boolean c(String str, String str2) {
        return com.byazt.sx.c.c(str, str2);
    }

    public static void c(com.byazt.ko.c cVar) {
        if (!com.byazt.sx.ve.tt()) {
            com.byazt.bp.c.t().c(cVar);
        } else if (cVar != null) {
            cVar.c();
        }
    }
}
