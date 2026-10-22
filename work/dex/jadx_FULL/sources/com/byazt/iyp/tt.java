package com.byazt.iyp;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 13})
public final class tt {
    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    public static void c(com.byazt.dj.tt ttVar, boolean z, final String str) {
        Boolean boolValueOf;
        String str2;
        String str3;
        String strA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (x.c(ve.c(), str)) {
                Activity activityC = c();
                Boolean bool = Boolean.FALSE;
                if (activityC != null) {
                    strA = uj.a();
                    sl.c(activityC);
                    CharSequence title = activityC.getTitle();
                    String name = activityC.getClass().getName();
                    boolValueOf = Boolean.valueOf(activityC.hasWindowFocus());
                    if (title != null) {
                        String string = title.toString();
                        if (TextUtils.isEmpty(string)) {
                            str2 = null;
                        } else {
                            str2 = string;
                        }
                    } else {
                        str2 = null;
                    }
                    str3 = name;
                } else {
                    boolValueOf = bool;
                    str2 = null;
                    str3 = null;
                    strA = null;
                }
                String strU = ttVar != null ? ttVar.u() : " ";
                if (z) {
                    c.c(str, new c.C0441c(str2, str3, strA, boolValueOf, null, null, strU));
                    if (x.c(ve.n(), str)) {
                        final StackTraceElement[] stackTraceElementArrC = x.c();
                        final int iTt = ve.tt();
                        com.byazt.bzd.x.c(new com.byazt.bwm.sp("stage_feature") { // from class: com.byazt.iyp.tt.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    JSONArray jSONArrayC = x.c(stackTraceElementArrC, iTt);
                                    c.c(str, jSONArrayC, (jSONArrayC == null || jSONArrayC.length() <= 0) ? " " : x.c(jSONArrayC));
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(ic icVar, String str) {
        if (icVar == null || TextUtils.isEmpty(icVar.c())) {
            return;
        }
        try {
            if (x.c(ve.c(), icVar.c())) {
                JSONObject jSONObject = new JSONObject();
                c.C0441c c0441cC = c.c(icVar.c());
                if (c0441cC != null) {
                    jSONObject.put("top_page_title", c0441cC.c);
                    jSONObject.put("top_page_name", c0441cC.tt);
                    jSONObject.put("t_name", c0441cC.ve);
                    jSONObject.put("has_window_focus", c0441cC.uj.booleanValue());
                    JSONArray jSONArray = c0441cC.n;
                    jSONObject.put("call_chain", jSONArray != null ? jSONArray.toString() : " ");
                    String str2 = c0441cC.f28675a;
                    jSONObject.put("stack_hash", str2 != null ? str2 : " ");
                    jSONObject.put("media_extra", c0441cC.sp);
                    jSONObject.put("is_hit_chain", x.c(ve.n(), icVar.c()));
                } else {
                    sl.c(jSONObject, (Activity) null);
                    com.byazt.dj.tt ttVarIj = icVar.ij();
                    if (ttVarIj != null) {
                        jSONObject.put("media_extra", TextUtils.isEmpty(ttVarIj.u()) ? " " : ttVarIj.u());
                    }
                }
                jSONObject.put(AlibcCommonConstant.APP_VERSION, nb.da());
                jSONObject.put("app_no_tab", sp.ve());
                com.byazt.ddx.uj.tt(icVar, str, "load_feature", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (x.c(ve.n(), str)) {
                final StackTraceElement[] stackTraceElementArrC = x.c();
                final int iTt = ve.tt();
                com.byazt.bzd.x.c(new com.byazt.bwm.sp("stage_feature") { // from class: com.byazt.iyp.tt.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c.c(str, x.c(stackTraceElementArrC, iTt));
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(ic icVar, String str, View view, boolean z) {
        if (icVar == null || view == null) {
            return;
        }
        try {
            if (x.c(ve.c(), icVar.c())) {
                JSONObject jSONObject = new JSONObject();
                sl.c(jSONObject, (Activity) null);
                JSONArray jSONArrayVe = c.ve(icVar.c());
                if (jSONArrayVe != null) {
                    jSONObject.put("call_chain", jSONArrayVe.toString());
                    jSONObject.put("stack_hash", x.c(jSONArrayVe));
                } else {
                    jSONObject.put("call_chain", " ");
                    jSONObject.put("stack_hash", " ");
                }
                boolean zC = x.c(ve.n(), icVar.c());
                t.c(jSONObject, view, ve.tt(), zC);
                jSONObject.put("is_preload", z);
                jSONObject.put(AlibcCommonConstant.APP_VERSION, nb.da());
                jSONObject.put("is_hit_chain", zC);
                com.byazt.ddx.uj.tt(icVar, str, "show_feature", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(final ic icVar, final String str, Activity activity, String str2, boolean z) {
        if (icVar == null) {
            return;
        }
        try {
            if (x.c(ve.c(), icVar.c())) {
                boolean zC = x.c(ve.n(), icVar.c());
                final StackTraceElement[] stackTraceElementArrC = zC ? x.c() : null;
                final int iTt = ve.tt();
                final JSONObject jSONObject = new JSONObject();
                sl.c(jSONObject, activity);
                if (TextUtils.isEmpty(str2)) {
                    str2 = " ";
                }
                jSONObject.put("rit_scene", str2);
                jSONObject.put("is_preload", z);
                jSONObject.put(AlibcCommonConstant.APP_VERSION, nb.da());
                jSONObject.put("is_hit_chain", zC);
                com.byazt.bzd.x.c(new com.byazt.bwm.sp("stage_feature") { // from class: com.byazt.iyp.tt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            StackTraceElement[] stackTraceElementArr = stackTraceElementArrC;
                            if (stackTraceElementArr != null) {
                                JSONArray jSONArrayC = x.c(stackTraceElementArr, iTt);
                                jSONObject.put("call_chain", jSONArrayC.toString());
                                jSONObject.put("stack_hash", x.c(jSONArrayC));
                            } else {
                                jSONObject.put("call_chain", " ");
                                jSONObject.put("stack_hash", " ");
                            }
                            com.byazt.ddx.uj.tt(icVar, str, "show_feature", jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private static Activity c() {
        try {
            com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
            WeakReference<Activity> weakReferenceC = cVarVe != null ? cVarVe.c() : null;
            if (weakReferenceC != null) {
                return weakReferenceC.get();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
