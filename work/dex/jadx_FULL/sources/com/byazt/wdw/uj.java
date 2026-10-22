package com.byazt.wdw;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.nb;
import com.byazt.bzd.x;
import com.byazt.cr.a;
import com.byazt.ddx.i;
import com.byazt.eia.da;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.nr.h;
import com.byazt.nr.md;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 15})
public final class uj {
    public static volatile uj c;
    public boolean tt;
    public Object ve;
    public AtomicBoolean uj = new AtomicBoolean(false);
    public AtomicInteger n = new AtomicInteger(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f29156a = new AtomicBoolean(false);

    private uj() {
        this.tt = false;
        try {
            Object obj = Build.class.getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                Locale locale = Locale.ROOT;
                this.tt = "android 5.3.1".toLowerCase(locale).compareTo(((String) obj).toLowerCase(locale)) <= 0;
            }
        } catch (Throwable unused) {
            this.tt = false;
        }
    }

    private void n() {
        x.c(new Runnable() { // from class: com.byazt.wdw.uj.2
            @Override // java.lang.Runnable
            public void run() {
                h.tt(gt.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    private boolean uj() {
        if (gt.getContext() == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (com.byazt.aas.x.c(intent, 0).size() > 0) {
            return true;
        }
        if (nb.yv()) {
            return false;
        }
        return nb.ve("com.tencent.mm");
    }

    public static uj ve() {
        if (c == null) {
            synchronized (uj.class) {
                if (c == null) {
                    c = new uj();
                }
            }
        }
        return c;
    }

    public int tt() {
        return this.tt ? 1 : 0;
    }

    public boolean c() {
        return this.tt;
    }

    private void c(String str) {
        Method methodC;
        Method methodC2;
        if (!this.uj.get() && this.n.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                c("wc_init_fail", "error_appid");
                return;
            }
            if (!uj()) {
                c("wc_init_fail", "error_no_wechat");
                return;
            }
            if (!this.tt) {
                c("wc_init_fail", "error_no_sdk");
                return;
            }
            try {
                Method methodC3 = md.c("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                if (methodC3 != null) {
                    Function<SparseArray<Object>, Object> functionLt = com.byazt.omf.x.m().lt();
                    Object objApply = functionLt != null ? functionLt.apply(com.byazt.yxi.uj.c().c(3).c(Context.class).tt()) : null;
                    if (objApply == null) {
                        objApply = gt.getContext();
                    }
                    boolean zEquals = "oppo".equals(p.x);
                    if (!zEquals && objApply == null && (methodC2 = md.c("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        objApply = methodC2.invoke(null, new Object[0]);
                    }
                    if (zEquals && objApply == null && (methodC = md.c("com.bykv.vk.openvk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        objApply = methodC.invoke(null, new Object[0]);
                    }
                    if (objApply == null) {
                        c("wc_init_fail", "error_sdk");
                        return;
                    }
                    this.ve = methodC3.invoke(null, objApply, str);
                    c("wc_init_suc", "");
                    this.uj.set(true);
                }
            } catch (Throwable th) {
                c("wc_init_fail", "error_sdk_" + th.getMessage());
            }
        }
    }

    private void c(String str, String str2) {
        try {
            final com.byazt.qal.tt<com.byazt.qal.tt> ttVarTt = com.byazt.qal.tt.tt();
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, str2);
                ttVarTt.tt(jSONObject.toString());
            }
            ttVarTt.c(str);
            yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.wdw.uj.1
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() {
                    return ttVarTt;
                }
            }, str);
        } catch (Throwable unused) {
        }
    }

    public void c(da daVar, String str, String str2, final n.c cVar, String str3, boolean z, Map<String, Object> map) {
        try {
            if (daVar == null) {
                cVar.c(a.uj);
                n();
                return;
            }
            hq hqVarA_ = daVar.A_();
            if (hqVarA_ == null) {
                c("wc_init_fail", "wechat data is null");
                cVar.c(a.uj);
                n();
                return;
            }
            c(hqVarA_.x());
            if (this.ve == null) {
                cVar.c(a.sl);
                n();
                return;
            }
            Object objNewInstance = WXLaunchMiniProgram.Req.class.newInstance();
            Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
            declaredField.setAccessible(true);
            declaredField.set(objNewInstance, str);
            Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField("path");
            declaredField2.setAccessible(true);
            declaredField2.set(objNewInstance, str2);
            Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
            declaredField3.setAccessible(true);
            try {
                declaredField3.set(objNewInstance, WXLaunchMiniProgram.Req.class.getDeclaredField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            } catch (Throwable unused) {
                declaredField3.set(objNewInstance, 0);
            }
            Method method = this.ve.getClass().getMethod("sendReq", WXLaunchMiniProgram.Req.class.getSuperclass());
            hqVarA_.tt(2);
            ic icVarC = com.byazt.ppf.ve.c(daVar, map);
            HashMap map2 = new HashMap();
            map2.put("source", "WeChatOpenSdkProcessor");
            com.byazt.ddx.uj.c(icVarC, str3, (Map<String, Object>) map2, false);
            com.byazt.ddx.uj.c(icVarC, str3, (Throwable) null, false, true);
            com.byazt.ddx.x.c().c(icVarC, str3, z, false, new i.c() { // from class: com.byazt.wdw.uj.3
                @Override // com.byazt.ddx.i.c
                public void c(long j) {
                    uj.this.c(false, cVar);
                }

                @Override // com.byazt.ddx.i.c
                public void c(String str4) {
                }

                @Override // com.byazt.ddx.i.c
                public void c(boolean z2) {
                    uj.this.c(true, cVar);
                }
            });
            method.invoke(this.ve, objNewInstance);
        } catch (Throwable th) {
            c("wc_init_fail", "invoke:" + th.getMessage());
            cVar.c(a.t);
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z, final n.c cVar) {
        x.c(new Runnable() { // from class: com.byazt.wdw.uj.4
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    cVar.c();
                } else {
                    cVar.c(a.x);
                }
            }
        });
    }
}
