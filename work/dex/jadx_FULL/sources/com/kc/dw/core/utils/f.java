package com.kc.dw.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.Toast;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byazt.bv.BaseConstants;
import com.google.gson.Gson;
import com.igexin.assist.util.AssistUtils;
import com.kc.dw.activity.SsdWebviewActivity;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.view.DownLoadDialogActivity;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.IAd;
import com.kc.dw.core.loader.ShareInteractionListener;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f {

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SoftReference f39361a;
        public final AdSlot b;
        public final SoftReference c;
        public final j0 d;
        public final List e;
        public final boolean f;

        public a(SoftReference softReference, AdSlot adSlot, SoftReference softReference2, j0 j0Var, List list, boolean z) {
            this.f39361a = softReference;
            this.b = adSlot;
            this.c = softReference2;
            this.d = j0Var;
            this.e = list;
            this.f = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            String str;
            int crdpf;
            AdSlot adSlot;
            Context context;
            com.kc.dw.platform.ad_adapter.c cVar;
            boolean z;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Gson gson = new Gson();
            int i = p0.m;
            int i2 = i > 0 ? i * 1000 : 2000;
            Object[] objArr = false;
            Object[] objArr2 = false;
            while (System.currentTimeMillis() - jCurrentTimeMillis <= 5000) {
                try {
                    PackageBean.AdBean adBean = b.b;
                    crdpf = adBean != null ? adBean.getCrdpf() : 0;
                } catch (Exception unused) {
                }
                if (crdpf == 1 && !this.e.isEmpty() && !((Boolean) this.e.get(0)).booleanValue()) {
                    str = "open deeplink fail. break";
                } else if (f.a(this.c) && f.a(this.f39361a)) {
                    try {
                        Thread.sleep(500L);
                        try {
                            try {
                                if (!com.kc.dw.core.service.c.a()) {
                                    try {
                                        try {
                                            Thread.sleep(500L);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                                        if (com.kc.dw.core.service.c.a()) {
                                            if (objArr2 != true && f.a(this.b, (com.kc.dw.platform.ad_adapter.c) this.f39361a.get())) {
                                                PackageBean.HappyBean happyBean = p0.l;
                                                if (happyBean != null) {
                                                    happyBean.setLastTime(System.currentTimeMillis());
                                                    r.a().b("happybean", gson.toJson(p0.l));
                                                    com.kc.dw.base.a.getSharedPreferences().edit().putString("happybean", gson.toJson(p0.l)).apply();
                                                }
                                                AdSlot adSlot2 = this.b;
                                                m0.a((Context) this.c.get(), this.b.getDeep_link(), this.b.getDpSign(), this.b.getDp_start(), adSlot2 instanceof BaseAdSlot ? ((BaseAdSlot) adSlot2).getDPSIGN() : null, this.f);
                                                try {
                                                    Thread.sleep(i2);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                if (com.kc.dw.core.service.c.a()) {
                                                    return;
                                                }
                                                adSlot = this.b;
                                                context = (Context) this.c.get();
                                                cVar = (com.kc.dw.platform.ad_adapter.c) this.f39361a.get();
                                                z = this.d.d;
                                                f.a(adSlot, context, cVar, z);
                                                return;
                                            }
                                            objArr = true;
                                        } else {
                                            if (jCurrentTimeMillis2 - jCurrentTimeMillis >= i2) {
                                                adSlot = this.b;
                                                context = (Context) this.c.get();
                                                cVar = (com.kc.dw.platform.ad_adapter.c) this.f39361a.get();
                                                z = this.d.d;
                                                f.a(adSlot, context, cVar, z);
                                                return;
                                            }
                                            objArr = true;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        objArr = true;
                                        th.printStackTrace();
                                    }
                                } else if (objArr != false && objArr2 == false && f.a(this.b, (com.kc.dw.platform.ad_adapter.c) this.f39361a.get())) {
                                    PackageBean.HappyBean happyBean2 = p0.l;
                                    if (happyBean2 != null) {
                                        happyBean2.setLastTime(System.currentTimeMillis());
                                        r.a().b("happybean", gson.toJson(p0.l));
                                        com.kc.dw.base.a.getSharedPreferences().edit().putString("happybean", gson.toJson(p0.l)).apply();
                                    }
                                    AdSlot adSlot3 = this.b;
                                    m0.a((Context) this.c.get(), this.b.getDeep_link(), this.b.getDpSign(), this.b.getDp_start(), adSlot3 instanceof BaseAdSlot ? ((BaseAdSlot) adSlot3).getDPSIGN() : null, this.f);
                                    try {
                                        Thread.sleep(i2);
                                    } catch (InterruptedException e3) {
                                        e3.printStackTrace();
                                    }
                                    if (com.kc.dw.core.service.c.a()) {
                                        return;
                                    }
                                    adSlot = this.b;
                                    context = (Context) this.c.get();
                                    cVar = (com.kc.dw.platform.ad_adapter.c) this.f39361a.get();
                                    z = this.d.d;
                                    f.a(adSlot, context, cVar, z);
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objArr = false;
                                objArr2 = true;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th.printStackTrace();
                        }
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                } else {
                    str = "reference invalid. break";
                }
                LogUtil.d("ClickHandler", str);
                f.a((com.kc.dw.platform.ad_adapter.c) this.f39361a.get(), this.b, (Context) this.c.get(), this.d.d ? 1 : 0);
            }
            str = "check self background timeout";
            LogUtil.d("ClickHandler", str);
            f.a((com.kc.dw.platform.ad_adapter.c) this.f39361a.get(), this.b, (Context) this.c.get(), this.d.d ? 1 : 0);
        }
    }

    public static Object a(Context context, String str, AdSlot adSlot) throws Exception {
        Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.BaseWXApiImplV10");
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class, String.class, Boolean.TYPE, Integer.TYPE);
        declaredConstructor.setAccessible(true);
        Object objNewInstance = declaredConstructor.newInstance(context, str, Boolean.TRUE, 2);
        Object objNewInstance2 = WXLaunchMiniProgram.Req.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
        declaredField.setAccessible(true);
        declaredField.set(objNewInstance2, adSlot.getWx_username());
        Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField("path");
        declaredField2.setAccessible(true);
        declaredField2.set(objNewInstance2, adSlot.getWx_path());
        Method declaredMethod = cls.getDeclaredMethod("sendReq", BaseReq.class);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(objNewInstance, objNewInstance2);
    }

    public static String a(String str, int i, ShakeResult shakeResult) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i2 = 0;
            int i3 = 1;
            if (2 != i && 1 != i && 512 != i) {
                if (4 == i || 64 == i) {
                    if (shakeResult != null) {
                        str = TextUtils.replace(str, new String[]{"__M_XMAX_ACC__", "__M_YMAX_ACC__", "__M_ZMAX_ACC__"}, new String[]{String.valueOf((int) (shakeResult.getShakeX() * 100.0f)), String.valueOf((int) (shakeResult.getShakeY() * 100.0f)), String.valueOf((int) (shakeResult.getShakeZ() * 100.0f))}).toString();
                    }
                    i2 = 2;
                } else if (8 == i || 256 == i) {
                    if (shakeResult != null) {
                        str = TextUtils.replace(str, new String[]{"__M_TURN_X__", "__M_TURN_Y__", "__M_TURN_Z__", "__M_TURN_TIME__"}, new String[]{String.valueOf((int) shakeResult.getTurnX()), String.valueOf((int) shakeResult.getTurnY()), String.valueOf((int) shakeResult.getTurnZ()), String.valueOf(shakeResult.getTotalTurnTime())}).toString();
                    }
                    i2 = 5;
                } else if (128 == i || 32 == i) {
                    i2 = 1;
                    i3 = 3;
                }
                i3 = i2;
            }
            return str.replace("__M_SLD__", String.valueOf(i2)).replace("__M_SLD2__", String.valueOf(i3)).replace("__M_DENSITY__", String.valueOf(com.kc.dw.base.a.getContext().getResources().getDisplayMetrics().density));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str, IAd iAd) {
        String default_coord;
        TouchPositionListener.TouchPosition touchPosition = iAd.getTouchData().getTouchPosition();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int upY = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        String strValueOf = String.valueOf((touchPosition == null || touchPosition.getDownX() == 0) ? -999 : touchPosition.getDownX());
        String strValueOf2 = String.valueOf((touchPosition == null || touchPosition.getDownY() == 0) ? -999 : touchPosition.getDownY());
        String strValueOf3 = String.valueOf((touchPosition == null || touchPosition.getUpX() == 0) ? -999 : touchPosition.getUpX());
        if (touchPosition != null && touchPosition.getUpY() != 0) {
            upY = touchPosition.getUpY();
        }
        String strValueOf4 = String.valueOf(upY);
        long time = (touchPosition == null || touchPosition.getTouchTime() == null) ? jCurrentTimeMillis / 1000 : touchPosition.getTouchTime().getTime() / 1000;
        if (touchPosition != null && touchPosition.getTouchTime() != null) {
            jCurrentTimeMillis = touchPosition.getTouchTime().getTime();
        }
        String strValueOf5 = String.valueOf((touchPosition == null || touchPosition.getDownTime() == null) ? "__M_DOWN_TIME__" : Long.valueOf(touchPosition.getDownTime().getTime()));
        String strValueOf6 = String.valueOf((touchPosition == null || touchPosition.getUpTime() == null) ? "__M_UP_TIME__" : Long.valueOf(touchPosition.getUpTime().getTime()));
        int iPx2dip = (int) DimensionUtils.px2dip(com.kc.dw.base.a.getContext(), Integer.MIN_VALUE);
        if (String.valueOf(iPx2dip).equals(strValueOf3)) {
            strValueOf3 = "0";
        }
        if (String.valueOf(iPx2dip).equals(strValueOf4)) {
            strValueOf4 = "0";
        }
        try {
            if (iAd instanceof com.kc.dw.platform.ad_adapter.c) {
                AdSlot adSlotA = ((com.kc.dw.platform.ad_adapter.c) iAd).a();
                if ((adSlotA instanceof BaseAdSlot) && (default_coord = ((BaseAdSlot) adSlotA).getDefault_coord()) != null) {
                    if ("-999".equals(strValueOf)) {
                        strValueOf = default_coord;
                    }
                    if ("-999".equals(strValueOf2)) {
                        strValueOf2 = default_coord;
                    }
                    if ("-999".equals(strValueOf3)) {
                        strValueOf3 = default_coord;
                    }
                    if ("-999".equals(strValueOf4)) {
                        strValueOf4 = default_coord;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return a(str, strValueOf, strValueOf2, strValueOf3, strValueOf4, String.valueOf(time), String.valueOf(jCurrentTimeMillis), strValueOf5, strValueOf6);
    }

    public static String a(String str, com.kc.dw.platform.ad_adapter.c cVar) {
        try {
            AdSlot adSlotA = cVar.a();
            if (adSlotA instanceof BaseAdSlot) {
                try {
                    int clkActType = ((BaseAdSlot) adSlotA).getClkActType();
                    if (clkActType == 4 || clkActType == 8 || clkActType == 64 || clkActType == 256) {
                        String default_coord = ((BaseAdSlot) adSlotA).getDefault_coord();
                        if (default_coord != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            str = a(str, default_coord, default_coord, default_coord, default_coord, String.valueOf(jCurrentTimeMillis / 1000), String.valueOf(jCurrentTimeMillis), "__M_DOWN_TIME__", "__M_UP_TIME__");
                        } else {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            str = a(str, "-999", "-999", "-999", "-999", String.valueOf(jCurrentTimeMillis2 / 1000), String.valueOf(jCurrentTimeMillis2), "__M_DOWN_TIME__", "__M_UP_TIME__");
                        }
                    } else {
                        str = a(str, (IAd) cVar);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return TextUtils.replace(str, new String[]{"__CLICK_ID__"}, new String[]{TextUtils.isEmpty(adSlotA.getClickid()) ? "__CLICK_ID__" : adSlotA.getClickid()}).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return TextUtils.replace(str, new String[]{"__DOWN_X__", "__DOWN_Y__", "__UP_X__", "__UP_Y__", "__MS_EVENT_SEC__", "__MS_EVENT_MSEC__", "__M_DOWN_TIME__", "__M_UP_TIME__"}, new String[]{String.valueOf(str2), String.valueOf(str3), String.valueOf(str4), String.valueOf(str5), String.valueOf(str6), String.valueOf(str7), String.valueOf(str8), String.valueOf(str9)}).toString();
    }

    public static void a(Context context, AdSlot adSlot, com.kc.dw.platform.ad_adapter.c cVar) {
        try {
            String[] dp_start = adSlot.getDp_start();
            if (dp_start != null) {
                LogUtil.i("ClickHandler", "send dp_start");
                for (int i = 0; i < dp_start.length; i++) {
                    if (!TextUtils.isEmpty(dp_start[i])) {
                        dp_start[i] = a(dp_start[i], cVar);
                    }
                }
                adSlot.setDp_start(dp_start);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, com.kc.dw.platform.ad_adapter.c cVar) {
        try {
            AdSlot adSlotA = cVar.a();
            String packageName = adSlotA.getPackageName();
            String[] dn_succ = adSlotA.getDn_succ();
            String[] dn_inst_start = adSlotA.getDn_inst_start();
            String[] dn_inst_succ = adSlotA.getDn_inst_succ();
            AppStoreUtil.f39335a = packageName;
            AppStoreUtil.b = dn_succ;
            AppStoreUtil.c = dn_inst_start;
            AppStoreUtil.d = dn_inst_succ;
            String[] strArrA = a(adSlotA.getDn_start(), cVar);
            if (strArrA != null) {
                LogUtil.i("ClickHandler", "Report send dn_start");
                for (String str : strArrA) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(context, str, new j());
                    }
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + adSlotA.getPackageName()));
            intent.addFlags(268435456);
            if (Build.MANUFACTURER.equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                intent.setPackage("com.hihonor.appmarket");
            }
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void a(AdSlot adSlot, Context context, com.kc.dw.platform.ad_adapter.c cVar, boolean z) {
        try {
            String[] dp_succ = adSlot.getDp_succ();
            g0.a(dp_succ, z ? 1 : 0);
            if (dp_succ != null) {
                for (String str : dp_succ) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(context, a(str, cVar), new j());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    public static void a(com.kc.dw.platform.ad_adapter.c cVar, Context context, AdSlot adSlot, boolean z) {
        try {
            boolean z2 = true;
            if (cVar.getInteractionType() == 1) {
                if (cVar.a().getDirect_market() != 1 || TextUtils.isEmpty(cVar.a().getPackageName())) {
                    b(context, cVar);
                    return;
                } else {
                    a(context, cVar);
                    return;
                }
            }
            if (cVar.getInteractionType() == 0) {
                if (!z) {
                    try {
                        s1.a(((BaseAdSlot) adSlot).getEventUrl());
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                boolean z3 = p0.q == 1;
                if (adSlot instanceof BaseAdSlot) {
                    BaseAdSlot baseAdSlot = (BaseAdSlot) adSlot;
                    if (baseAdSlot.getUob() == null) {
                        z2 = z3;
                    } else if (baseAdSlot.getUob().intValue() != 1) {
                        z2 = false;
                    }
                } else {
                    z2 = z3;
                }
                b(cVar, context, adSlot, z2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(com.kc.dw.platform.ad_adapter.c cVar, AdSlot adSlot) {
        boolean z;
        int i = 0;
        String str = null;
        try {
            if (adSlot instanceof BaseAdSlot) {
                str = ((BaseAdSlot) adSlot).getPower_index() + "," + ((BaseAdSlot) adSlot).getClkPower();
                ((BaseAdSlot) adSlot).getLoadedTime();
                String posId = ((BaseAdSlot) adSlot).getPosId();
                t0.a(posId, 4);
                t0.a aVar = t0.f39405a.get(posId + ((BaseAdSlot) adSlot).getLoadedTime());
                if (aVar == null) {
                    aVar = new t0.a();
                }
                z = !aVar.b ? aVar.f39406a : false;
                if (!z) {
                    try {
                        t0.a(posId, 8);
                    } catch (Exception e) {
                        e = e;
                        try {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                }
                aVar.b = true;
                t0.f39405a.put(posId + ((BaseAdSlot) adSlot).getLoadedTime(), aVar);
            } else {
                z = false;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        String[] clickUrl = adSlot.getClickUrl();
        if (clickUrl != null) {
            LogUtil.d("ClickHandler", "send handleClick");
            for (String strA : clickUrl) {
                if (!TextUtils.isEmpty(strA)) {
                    if (cVar.getAdView() != null) {
                        strA = g0.a(strA, cVar.getAdView().getWidth(), cVar.getAdView().getHeight());
                    }
                    if (z) {
                        if (((BaseAdSlot) adSlot).getDclk() != null) {
                            str = ((BaseAdSlot) adSlot).getDclk().getPower() + "," + ((BaseAdSlot) adSlot).getClkPower();
                        }
                        strA = strA.replace("__MS_DCLK_S__", "1");
                    }
                    if (adSlot instanceof BaseAdSlot) {
                        int clkActType = ((BaseAdSlot) adSlot).getClkActType();
                        String strReplace = strA.replace("__MS_CT__", String.valueOf(clkActType));
                        if (clkActType == 4 || clkActType == 8 || clkActType == 64 || clkActType == 256) {
                            if (TextUtils.isEmpty(str)) {
                                str = ((BaseAdSlot) adSlot).getPower_index() + "," + ((BaseAdSlot) adSlot).getClkPower();
                            }
                            strReplace = strReplace.replace("__MS_CP__", g0.b(str));
                        }
                        strA = a(strReplace, clkActType, ((BaseAdSlot) adSlot).getShakeResult());
                    }
                    z.a(cVar.getAdView().getContext(), a(strA, cVar), new j());
                }
            }
        }
        String[] strArr = adSlot.getdUrl();
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            int length = strArr.length;
            int i2 = 0;
            while (i < length) {
                strArr2[i2] = a(strArr[i], cVar);
                i++;
                i2++;
            }
            adSlot.setdUrl(strArr2);
        }
    }

    public static void a(com.kc.dw.platform.ad_adapter.c cVar, AdSlot adSlot, Context context, int i) {
        try {
            String[] dp_fail = adSlot.getDp_fail();
            g0.a(dp_fail, i);
            if (dp_fail != null) {
                LogUtil.i("ClickHandler", "send dp_fail");
                for (String str : dp_fail) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(context, a(str, cVar), new j());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(com.kc.dw.platform.ad_adapter.c cVar, boolean z) {
        try {
            LogUtil.i("ClickHandler", "handleClick");
            AdSlot adSlotA = cVar.a();
            a(cVar, adSlotA);
            Context context = cVar.getContext();
            if (cVar.getAdType() == AdType.FEED && (cVar instanceof com.kc.dw.ad.nativ.g) && ((com.kc.dw.ad.nativ.g) cVar).f39131a == 2 && ((com.kc.dw.ad.nativ.g) cVar).f && (cVar.getAdView() instanceof NormalMediaView)) {
                LogUtil.i("ClickHandler", "feed open detail");
                ((NormalMediaView) cVar.getAdView()).a(z);
                return;
            }
            if (!TextUtils.isEmpty(adSlotA.getWx_username())) {
                try {
                    String[] wx_start = adSlotA.getWx_start();
                    if (wx_start != null) {
                        LogUtil.i("ClickHandler", "send wx_start");
                        for (String str : wx_start) {
                            if (!TextUtils.isEmpty(str)) {
                                z.a(context, a(g0.a(str), cVar), new j());
                            }
                        }
                    }
                    String wxAppid = null;
                    String wx_appid = (!(adSlotA instanceof BaseAdSlot) || TextUtils.isEmpty(((BaseAdSlot) adSlotA).getWx_appid())) ? null : ((BaseAdSlot) adSlotA).getWx_appid();
                    if (wx_appid == null) {
                        wx_appid = com.kc.dw.base.a.getSharedPreferences().getString("wx_appid", null);
                    }
                    if (wx_appid != null) {
                        wxAppid = wx_appid;
                    } else if (com.kc.dw.base.a.adConfig() != null) {
                        wxAppid = com.kc.dw.base.a.adConfig().getWxAppid();
                    }
                    Object objA = a(context, wxAppid, adSlotA);
                    if (objA instanceof Boolean) {
                        if (((Boolean) objA).booleanValue()) {
                            String[] wx_succ = adSlotA.getWx_succ();
                            if (wx_succ != null) {
                                LogUtil.i("ClickHandler", "send wx_success");
                                for (String str2 : wx_succ) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        z.a(context, a(g0.a(str2), cVar), new j());
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        String[] wx_fail = adSlotA.getWx_fail();
                        if (wx_fail != null) {
                            LogUtil.i("ClickHandler", "send wx_fail");
                            for (String str3 : wx_fail) {
                                if (!TextUtils.isEmpty(str3)) {
                                    z.a(context, a(g0.a(str3), cVar), new j());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                    String[] wx_fail2 = adSlotA.getWx_fail();
                    if (wx_fail2 != null) {
                        LogUtil.i("ClickHandler", "send wx_fail 2");
                        for (String str4 : wx_fail2) {
                            if (!TextUtils.isEmpty(str4)) {
                                z.a(context, a(g0.a(str4), cVar), new j());
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(adSlotA.getDeep_link())) {
                try {
                    if (!a(adSlotA.getDeep_link())) {
                        a(cVar, adSlotA, context, 3);
                    } else if (a(context != null ? context : com.kc.dw.base.a.getContext(), adSlotA, cVar, true, z, null)) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            a(cVar, context, adSlotA, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Intent intent) {
        for (int i = 0; i < p0.i.size(); i++) {
            try {
                PackageBean.DpFlagBean dpFlagBean = p0.i.get(i);
                if (dpFlagBean.getScheme() != null && str.startsWith(dpFlagBean.getScheme())) {
                    List<String> flag = dpFlagBean.getFlag();
                    for (int i2 = 0; i2 < flag.size(); i2++) {
                        String str2 = flag.get(i2);
                        if ("FLAG_ACTIVITY_SINGLE_TOP".equals(str2)) {
                            intent.addFlags(536870912);
                        }
                        if ("FLAG_ACTIVITY_CLEAR_TASK".equals(str2)) {
                            intent.addFlags(32768);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    public static /* synthetic */ void a(List list, m0.a aVar, boolean z, boolean z2, boolean z3, com.kc.dw.platform.ad_adapter.c cVar, Context context, AdSlot adSlot, boolean z4) {
        list.add(Boolean.valueOf(z4));
        if (aVar != null) {
            aVar.a(z4);
        }
        if (z4 || !z) {
            return;
        }
        LogUtil.i("ClickHandler", "openDeepLink error. call defaultInteraction");
        boolean z5 = p0.s != 1 ? !z2 || z3 : false;
        if (cVar.getInteractionType() == 0) {
            a(cVar, context, adSlot, z5);
        }
    }

    public static void a(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.kc.dw.ad.interstitial.c.a(com.kc.dw.base.a.getContext(), str);
                }
            }
        }
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(final Context context, final AdSlot adSlot, final com.kc.dw.platform.ad_adapter.c cVar, final boolean z, final boolean z2, final m0.a aVar) {
        a(context, adSlot, cVar);
        try {
            final boolean z3 = (adSlot instanceof BaseAdSlot) && ((BaseAdSlot) adSlot).getNop() == 1;
            boolean z4 = !z3;
            final ArrayList arrayList = new ArrayList();
            m0.b.f39387a.f39386a = new m0.a(arrayList, aVar, z, z3, z2, cVar, context, adSlot) { // from class: com.kc.dw.core.utils.f$$ExternalSyntheticLambda0
                public final List f$0;
                public final m0.a f$1;
                public final boolean f$2;
                public final boolean f$3;
                public final boolean f$4;
                public final com.kc.dw.platform.ad_adapter.c f$5;
                public final Context f$6;
                public final AdSlot f$7;

                {
                    this.f$0 = arrayList;
                    this.f$1 = aVar;
                    this.f$2 = z;
                    this.f$3 = z3;
                    this.f$4 = z2;
                    this.f$5 = cVar;
                    this.f$6 = context;
                    this.f$7 = adSlot;
                }

                @Override // com.kc.dw.core.utils.m0.a
                public final void a(boolean z5) {
                    f.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, z5);
                }
            };
            j0 j0Var = new j0(-1L, false);
            com.kc.dw.core.router.helper.a.a(j0Var);
            m0.a(context, adSlot.getDeep_link(), adSlot.getDpSign(), adSlot.getDp_start(), adSlot instanceof BaseAdSlot ? ((BaseAdSlot) adSlot).getDPSIGN() : null, z4);
            new Thread(new a(new SoftReference(cVar), adSlot, new SoftReference(context), j0Var, arrayList, z4)).start();
            return true;
        } catch (Exception e) {
            try {
                a(cVar, adSlot, context, 4);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(AdSlot adSlot, com.kc.dw.platform.ad_adapter.c cVar) {
        HashMap<String, String> dynamicMap;
        String string;
        Exception e;
        Object obj;
        StringBuilder sb;
        StringBuilder sb2;
        try {
            if (p0.l == null) {
                return false;
            }
            Gson gson = new Gson();
            Map map = null;
            if (adSlot instanceof BaseAdSlot) {
                dynamicMap = ((BaseAdSlot) adSlot).getDynamicMap();
                if (((BaseAdSlot) adSlot).getIsAdClosed() && p0.l.getX() == 0) {
                    return false;
                }
            } else {
                dynamicMap = null;
            }
            if (System.currentTimeMillis() - p0.l.getLastTime() <= p0.l.getI() * 1000) {
                return false;
            }
            List<String> k = p0.l.getK();
            if (k != null) {
                string = "";
                for (int i = 0; i < k.size(); i++) {
                    try {
                        String str = k.get(i);
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                Field declaredField = BaseAdSlot.class.getDeclaredField(str);
                                declaredField.setAccessible(true);
                                obj = declaredField.get(adSlot);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                obj = null;
                            }
                            try {
                                if (NativeModel.JSON_KEY_SCHEME.equals(str) && obj == null && (adSlot instanceof BaseAdSlot)) {
                                    string = ((BaseAdSlot) adSlot).getScheme() != null ? string + LoginConstants.UNDER_LINE + ((BaseAdSlot) adSlot).getScheme() : string + LoginConstants.UNDER_LINE + Uri.parse(adSlot.getDeep_link()).getScheme();
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            if (obj != null) {
                                if (i == 0) {
                                    sb = new StringBuilder();
                                    sb.append(string);
                                    sb.append(obj);
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(string);
                                    sb.append(LoginConstants.UNDER_LINE);
                                    sb.append(obj);
                                }
                            } else if (dynamicMap != null && dynamicMap.containsKey(str)) {
                                if (i == 0) {
                                    sb2 = new StringBuilder();
                                    sb2.append(string);
                                    sb2.append(dynamicMap.get(str));
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append(string);
                                    sb2.append(LoginConstants.UNDER_LINE);
                                    sb2.append(dynamicMap.get(str));
                                }
                                string = sb2.toString();
                            } else if (i < k.size() - 1) {
                                sb = new StringBuilder();
                                sb.append(string);
                                sb.append(LoginConstants.UNDER_LINE);
                            }
                            string = sb.toString();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } else {
                string = "";
            }
            Map<String, Integer> r = p0.l.getR();
            long jLongValue = 0;
            try {
                String string2 = com.kc.dw.base.a.getSharedPreferences().getString("queryKeyLastTimeMap", "");
                if (!TextUtils.isEmpty(string2)) {
                    Map map2 = (Map) gson.fromJson(string2, new g().getType());
                    if (map2 != null) {
                        try {
                            if (map2.containsKey(string)) {
                                jLongValue = ((Long) map2.get(string)).longValue();
                            }
                        } catch (Exception e5) {
                            e = e5;
                            map = map2;
                            e.printStackTrace();
                        }
                    }
                    map = map2;
                }
            } catch (Exception e6) {
                e = e6;
            }
            if (r == null || TextUtils.isEmpty(string)) {
                return false;
            }
            if (System.currentTimeMillis() - jLongValue <= r.get(string).intValue() * 1000) {
                return false;
            }
            if (map == null) {
                map = new HashMap();
            }
            map.put(string, Long.valueOf(System.currentTimeMillis()));
            com.kc.dw.base.a.getSharedPreferences().edit().putString("queryKeyLastTimeMap", gson.toJson(map)).apply();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            Intent uri = Intent.parseUri(str, 0);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            return uri.resolveActivity(com.kc.dw.base.a.getContext().getPackageManager()) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(Reference reference) {
        if (reference != null) {
            try {
                if (reference.get() != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String[] a(String[] strArr, com.kc.dw.platform.ad_adapter.c cVar) {
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = a(strArr[i], cVar);
            }
        }
        return strArr;
    }

    public static void b(Context context, com.kc.dw.platform.ad_adapter.c cVar) {
        try {
            if (!a(context)) {
                Toast.makeText(context.getApplicationContext(), "请检查网络连接", 0).show();
                return;
            }
            AdSlot adSlotA = cVar.a();
            if (adSlotA.getdUrl() == null || adSlotA.getdUrl().length <= 0) {
                return;
            }
            adSlotA.getdUrl();
            String str = com.kc.dw.core.download.a.C1023a.f39242a.c;
            String strReplace = adSlotA.getdUrl()[0].substring(adSlotA.getdUrl()[0].lastIndexOf(WVNativeCallbackUtil.SEPERATER)).replace(WVNativeCallbackUtil.SEPERATER, "");
            try {
                strReplace = o1.a(MessageDigest.getInstance("MD5").digest(adSlotA.getdUrl()[0].getBytes())).toLowerCase() + ".apk";
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            File file = new File(str, strReplace);
            if (!file.exists()) {
                LogUtil.e("ClickHandler", "file not exists");
                c(context, cVar);
                return;
            }
            LogUtil.e("ClickHandler", "file install");
            String[] strArrA = a(cVar.a().getDn_start(), cVar);
            String[] strArrA2 = a(cVar.a().getDn_succ(), cVar);
            String[] strArrA3 = a(cVar.a().getDn_inst_start(), cVar);
            String[] strArrA4 = a(cVar.a().getDn_inst_succ(), cVar);
            String appName = cVar.a().getAppName();
            String packageName = cVar.a().getPackageName();
            Map<Integer, i0> map = DownloadUtils.h;
            i0 i0Var = new i0();
            i0Var.b = appName;
            i0Var.c = packageName;
            i0Var.d = strArrA;
            i0Var.e = strArrA2;
            i0Var.f = strArrA3;
            i0Var.g = strArrA4;
            DownloadUtils.a(context);
            DownloadUtils.a(context, file, i0Var);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(com.kc.dw.platform.ad_adapter.c cVar, Context context, AdSlot adSlot, boolean z) {
        if (adSlot != null) {
            try {
                if (adSlot.getdUrl() == null || adSlot.getdUrl().length <= 0) {
                    return;
                }
                boolean isRewardTmpClick = cVar.a() instanceof BaseAdSlot ? ((BaseAdSlot) cVar.a()).getIsRewardTmpClick() : false;
                if (!z && !isRewardTmpClick) {
                    if (cVar.getInteractionListener() instanceof ShareInteractionListener) {
                        try {
                            Class<? extends Activity> clsWebViewActivity = com.kc.dw.base.a.adConfig() != null ? com.kc.dw.base.a.adConfig().webViewActivity() : null;
                            if (clsWebViewActivity == null) {
                                clsWebViewActivity = SsdWebviewActivity.class;
                            }
                            clsWebViewActivity.getDeclaredMethod("setShareListener", ShareInteractionListener.class).invoke(null, (ShareInteractionListener) cVar.getInteractionListener());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    com.kc.dw.core.uri.c.c.a(context, a(adSlot.getdUrl()[0], (IAd) cVar), adSlot);
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(adSlot.getdUrl()[0]));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkUtil.NETWORK_TYPE_WIFI);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void c(Context context, com.kc.dw.platform.ad_adapter.c cVar) {
        try {
            if (com.kc.dw.base.a.adConfig() != null && (com.kc.dw.base.a.adConfig().downloadConfirm() == 1 || (com.kc.dw.base.a.adConfig().downloadConfirm() == 0 && !b(context)))) {
                DownLoadDialogActivity.x = cVar;
                Intent intent = new Intent(context, (Class<?>) DownLoadDialogActivity.class);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return;
            }
            String[] strArrA = a(cVar.a().getDn_start(), cVar);
            String[] strArrA2 = a(cVar.a().getDn_succ(), cVar);
            String[] strArrA3 = a(cVar.a().getDn_inst_start(), cVar);
            String[] strArrA4 = a(cVar.a().getDn_inst_succ(), cVar);
            String str = cVar.a().getdUrl()[0];
            String appName = cVar.a().getAppName();
            String packageName = cVar.a().getPackageName();
            String str2 = appName == null ? "" : appName;
            try {
                Map<Integer, i0> map = DownloadUtils.h;
                DownloadUtils.b.f39340a.a(context.getApplicationContext(), str, str2, packageName, strArrA, strArrA2, strArrA3, strArrA4);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(context.getApplicationContext(), com.ipd.dsp.internal.b1.b.a.l, 0).show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
