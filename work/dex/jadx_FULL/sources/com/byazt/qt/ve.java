package com.byazt.qt;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.byazt.aas.zb;
import com.byazt.eia.sp;
import com.byazt.ete.gt;
import com.byazt.ete.ic;
import com.byazt.ete.n;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.m;
import com.byazt.omf.p;
import com.byazt.omf.rl;
import com.byazt.omf.x;
import com.byazt.ukr.yp;
import com.byazt.yih.i;
import com.byazt.yxi.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.coremedia.iso.boxes.MetaBox;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 54})
public class ve {
    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final Map<String, Object> map, ic icVar) {
        i.c(new Runnable() { // from class: com.byazt.qt.ve.3
            @Override // java.lang.Runnable
            public void run() {
                if (x.m().nb() != null) {
                    x.m().nb().apply(uj.c().c(12).c(Boolean.class).c(0, map).tt());
                }
            }
        }, icVar);
    }

    public static void c(String str, String str2, ic icVar, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        if (icVar == null) {
            c(true, functionNb, str2, icVar, jSONObject, str, "", null, i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            c(true, functionNb, str2, icVar, jSONObject, str, "", null, i);
            return;
        }
        String strLs = icVar.ls();
        if (TextUtils.isEmpty(strLs) && icVar.rh() != null) {
            strLs = icVar.rh().u();
        }
        c(false, functionNb, str2, icVar, jSONObject, str, "", strLs, i);
    }

    public static void tt(int i, int i2) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        functionNb.apply(uj.c().c(30).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(i2)).c("downloadScene", Integer.valueOf(i))).tt());
    }

    public static void c(String str, ic icVar, JSONObject jSONObject, int i) {
        String str2;
        String str3;
        String strUj;
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        if (icVar == null) {
            c(true, functionNb, str, icVar, jSONObject, null, null, null, i);
            return;
        }
        n nVarZ = icVar.z();
        if (nVarZ != null) {
            String strTt = nVarZ.tt();
            String strVe = nVarZ.ve();
            strUj = nVarZ.uj();
            str2 = strTt;
            str3 = strVe;
        } else {
            str2 = "";
            str3 = str2;
            strUj = str3;
        }
        c(false, functionNb, str, icVar, jSONObject, str2, str3, strUj, i);
    }

    private static void c(boolean z, Function<SparseArray<Object>, Object> function, String str, ic icVar, JSONObject jSONObject, String str2, String str3, String str4, int i) {
        String str5;
        JSONObject jSONObject2;
        String strV_;
        String strTt;
        boolean zC;
        if (function == null) {
            return;
        }
        if (z) {
            function.apply(uj.c().c(23).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(i)).c("mateIsEmpty", Boolean.valueOf(z))).tt());
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("open_ad_sdk_download_extra", tt.c().c(str).tt(jSONObject).c(icVar).tt());
        } catch (Exception unused) {
        }
        long jLongValue = Double.valueOf(icVar.uj()).longValue();
        String strC = icVar.te() == null ? null : icVar.te().c();
        boolean zH = x.m().h();
        boolean z2 = !x.m().h();
        String strW_ = icVar.w_();
        JSONObject jSONObjectC = i.c();
        JSONObject jSONObject4 = new JSONObject();
        try {
            int iOptInt = jSONObjectC.optInt("notification_opt_2", 0);
            if (iOptInt != 1) {
                iOptInt = 0;
            }
            int iM = gt.m(icVar);
            if (p.x()) {
                jSONObject2 = jSONObject3;
            } else {
                jSONObject2 = jSONObject3;
                try {
                    jSONObject4.put("cancel_pause_optimise_switch", iM);
                    jSONObject4.put("cancel_pause_optimise_wifi_retain_switch", iM);
                    jSONObject4.put("cancel_pause_optimise_apk_retain_switch", iM);
                    jSONObject4.put("cancel_pause_optimise_download_percent_retain_switch", iM);
                } catch (JSONException unused2) {
                    str5 = strW_;
                }
            }
            jSONObject4.put("show_pause_continue_toast", iM);
            str5 = strW_;
            try {
                if (iM == 1) {
                    c(true, i);
                    jSONObject4.put("download_start_toast_text", jSONObjectC.optString("download_start_toast_text", "已开始下载，再次点击可暂停或取消该下载任务。"));
                } else if (com.byazt.omf.gt.tt().jg()) {
                    c(true, i);
                    jSONObject4.put("enable_notification_ui", 1);
                    jSONObject4.put("download_start_toast_text", "下载中，可在通知栏暂停或取消");
                }
                jSONObject4.put("notification_opt_2", iOptInt);
                jSONObject4.put("is_use_obm_convert", gt.tt(icVar));
            } catch (JSONException unused3) {
            }
        } catch (JSONException unused4) {
            str5 = strW_;
            jSONObject2 = jSONObject3;
        }
        String strX = "";
        if (icVar.yp() != null) {
            strTt = icVar.yp().tt();
            strV_ = icVar.v_();
            if (icVar.yp().n() != 2 || ic.ve(icVar)) {
                if (icVar.yp().n() == 1) {
                    strX = icVar.yp().uj();
                } else {
                    strX = icVar.x();
                }
            }
        } else {
            strV_ = "";
            strX = icVar.x();
            strTt = strV_;
        }
        int i2 = p.uj;
        if (i2 >= 7000 && i2 < 7300) {
            boolean zC2 = com.byazt.nr.gt.c(com.byazt.omf.gt.getContext());
            zC = com.byazt.omf.gt.tt().zm();
            if (!zC2) {
                zC = com.byazt.ue.tt.c();
            }
        } else {
            zC = com.byazt.ue.tt.c();
        }
        String strC2 = com.byazt.wz.x.c(icVar, str2, false);
        if (!TextUtils.isEmpty(strC2)) {
            com.byazt.wz.x.c(gt.yp(icVar), jSONObject4);
        }
        function.apply(uj.c().c(23).c(Void.class).c(0, new zb().c("mateIsEmpty", Boolean.FALSE).c("id", Long.valueOf(jLongValue)).c("appIcon", strC).c("isShowNotification", Boolean.valueOf(zH)).c("isAutoInstallWithoutNotification", Boolean.valueOf(z2)).c("logExtra", str5).c("extraJson", jSONObject2).c("downloadSettings", jSONObject4).c("filePath", strC2).c("appName", str3).c("downloadUrl", str2).c(ALPParamConstant.PACKAGENAME, str4).c("isNeedIndependentProcess", Boolean.valueOf(zC)).c("openUrl", strTt).c("webTitle", strV_).c("hashCode", Integer.valueOf(i)).c("webUrl", strX)).tt());
    }

    public static void c(ic icVar, int i, boolean z) {
        boolean zTt;
        boolean zC;
        boolean z2;
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        int iUj = gt.uj(icVar);
        int iN = gt.n(icVar);
        if (icVar != null && (!TextUtils.isEmpty(icVar.gr()) || z)) {
            iN = 2;
        }
        if (icVar == null || icVar.nm() == null) {
            zTt = false;
            zC = false;
            z2 = false;
        } else {
            zC = icVar.nm().c();
            zTt = icVar.nm().tt();
            z2 = true;
        }
        functionNb.apply(uj.c().c(25).c(Void.class).c(0, new zb().c("autoOpen", Integer.valueOf(iUj)).c("downloadMode", Integer.valueOf(iN)).c("isHaveDownloadSdkConfig", Boolean.valueOf(z2)).c("hashCode", Integer.valueOf(i)).c("isEnableAH", Boolean.valueOf(zC)).c("isEnableAM", Boolean.valueOf(zTt))).tt());
    }

    public static void c(int i, int i2) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        functionNb.apply(uj.c().c(26).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(i2)).c("downloadMode", Integer.valueOf(i))).tt());
    }

    public static void c(boolean z, int i) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        functionNb.apply(uj.c().c(31).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(i)).c("isShowToast", Boolean.valueOf(z))).tt());
    }

    public static int c(Function<SparseArray<Object>, Object> function, int i) {
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(uj.c().c(27).c(Integer.class).c(0, new zb().c("hashCode", Integer.valueOf(i))).tt());
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static void c(boolean z, com.byazt.wrq.ve veVar, int i) {
        try {
            Function<SparseArray<Object>, Object> functionNb = x.m().nb();
            if (functionNb == null) {
                return;
            }
            functionNb.apply(uj.c().c(28).c(Void.class).c(0, new zb().c("isEnableOppoAutoDownload", Boolean.valueOf(z)).c("hashCode", Integer.valueOf(i)).c("downloadMarketInterceptor", veVar)).tt());
        } catch (Throwable th) {
            m.ve("xgc_dof", "throwable", th);
        }
    }

    public static void c(com.byazt.wrq.ve veVar, int i) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        functionNb.apply(uj.c().c(154).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(i)).c("downloadMarketInterceptor", veVar)).tt());
    }

    public static void c(c cVar, String str, int i, Bitmap bitmap) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null || cVar == null) {
            return;
        }
        functionNb.apply(uj.c().c(160).c(Void.class).c(0, new zb().c("install_app_name", cVar.c()).c("install_icon_bitmap", bitmap).c("install_action_type", str).c("install_click_type", Integer.valueOf(i)).c("install_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && com.byazt.omf.gt.tt().id() > 0)).c("install_package_name", cVar.ve()).c("install_tag", cVar.sp()).c("install_value", cVar.x()).c("install_log_extra", cVar.n()).c("install_download_id", Integer.valueOf(cVar.uj()))).tt());
    }

    public static com.byazt.wrq.ve c(sp spVar, final boolean z) {
        if (spVar == null) {
            return null;
        }
        String strRl = spVar.rl();
        if (!TextUtils.isEmpty(strRl) && p.uj >= 6400) {
            final String strQy = spVar.qy();
            final String strGu = spVar.gu();
            final com.byazt.ocd.tt ttVar = (com.byazt.ocd.tt) rl.c(strRl, com.byazt.ocd.tt.class);
            if (ttVar != null && !TextUtils.isEmpty(spVar.gr()) && spVar.u_().a() == 1) {
                return new com.byazt.wrq.ve() { // from class: com.byazt.qt.ve.1
                    @Override // com.byazt.ou.DownloadMarketInterceptor
                    public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
                        if (map != null) {
                            if (!z) {
                                map.put("is_button", Boolean.FALSE);
                            }
                            Object obj = map.get("is_button");
                            ttVar.c(100, map);
                            ve.c(map, obj, strQy, strGu);
                        } else {
                            yp ypVarC = yp.c();
                            Boolean bool = Boolean.FALSE;
                            ypVarC.c(bool, bool, "param is null", strQy, strGu);
                        }
                        return map;
                    }
                };
            }
            m.c("dof", "bridge something invalid");
        }
        return null;
    }

    public static boolean c(Uri uri, ic icVar, Context context, String str, int i) {
        if (x.m().nb() == null || icVar == null) {
            return false;
        }
        c(str, icVar, (JSONObject) null, i);
        c(icVar, i, false);
        c(str, i);
        zb<String, Object> zbVarC = new zb().c("hashCode", Integer.valueOf(i)).c(TTDownloadField.TT_ACTIVITY, context).c("open_market_in_app", Boolean.valueOf(gt.my(icVar))).c("uri", uri);
        com.byazt.yzg.ve veVar = new com.byazt.yzg.ve(context, icVar);
        veVar.c(new com.byazt.yzg.n());
        if (c(icVar, str, zbVarC, veVar)) {
            return true;
        }
        tt(zbVarC, icVar);
        return true;
    }

    private static boolean c(final ic icVar, String str, final Map<String, Object> map, com.byazt.yzg.ve veVar) {
        if (!veVar.uj(false)) {
            return false;
        }
        veVar.c(str, new com.byazt.av.tt() { // from class: com.byazt.qt.ve.2
            @Override // com.byazt.av.tt
            public void c() {
                ve.tt((Map<String, Object>) map, icVar);
            }
        });
        return true;
    }

    public static void c(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            yp.c().c(obj, obj2, "success", str, str2);
            return;
        }
        yp ypVarC = yp.c();
        Boolean bool = Boolean.FALSE;
        ypVarC.c(bool, bool, "no intercept result", str, str2);
    }

    public static void c(String str, int i) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return;
        }
        functionNb.apply(uj.c().c(29).c(Void.class).c(0, new zb().c("clickButtonTag", str).c("clickItemTag", str).c("hashCode", Integer.valueOf(i)).c("clickStartLabel", "click_start").c("clickContinueLabel", "click_continue").c("clickPauseLabel", "click_pause").c("storageDenyLabel", "download_failed").c("clickInstallLabel", "click_install").c("isEnableClickEvent", Boolean.TRUE).c("isEnableV3Event", Boolean.FALSE)).tt());
    }

    public static void c(String str, String str2, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null || jSONObject == null) {
            return;
        }
        functionNb.apply(uj.c().c(29).c(Void.class).c(0, new zb().c("clickButtonTag", str).c("clickItemTag", str2).c("clickStartLabel", "click_start").c("clickContinueLabel", "click_continue").c("clickPauseLabel", "click_pause").c("storageDenyLabel", "download_failed").c("clickInstallLabel", "click_install").c("isEnableClickEvent", Boolean.TRUE).c("hashCode", Integer.valueOf(i)).c("isEnableV3Event", Boolean.FALSE).c("extraEventObject", jSONObject)).tt());
    }

    public static void c(Map<String, Object> map, com.byazt.wrq.c cVar) {
        if (map == null || cVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", cVar);
    }

    public static boolean c(String str, String str2, ic icVar, int i) {
        Function<SparseArray<Object>, Object> functionNb = x.m().nb();
        if (functionNb == null) {
            return false;
        }
        Object objApply = functionNb.apply(uj.c().c(2).c(Boolean.class).c(0, new zb().c("tagIntercept", str).c("label", str2).c("hashCode", Integer.valueOf(i)).c(MetaBox.TYPE, icVar.yg().toString())).tt());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }
}
