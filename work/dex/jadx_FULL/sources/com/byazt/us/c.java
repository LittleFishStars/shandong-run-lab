package com.byazt.us;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.ar.AdDownloadController;
import com.byazt.ar.AdDownloadModel;
import com.byazt.bv.BaseConstants;
import com.byazt.e.DeepLink;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.ou.gt;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadModel;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 251, 20})
public class c {
    public static final String c = "c";

    public static boolean c(@NonNull com.byazt.nn.n nVar) {
        boolean z;
        DeepLink deepLink = nVar.tt.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectC = com.byazt.hu.a.c(new JSONObject(), nVar);
        u.c(jSONObjectC, "applink_source", "click_by_sdk");
        com.byazt.zn.c.c().tt("applink_click", jSONObjectC, nVar);
        com.byazt.nn.sp spVarC = com.byazt.hu.i.c(openUrl, nVar);
        if (spVarC.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                tt("by_url", spVarC, jSONObjectC, nVar);
            }
            spVarC = com.byazt.hu.i.c(t.getContext(), nVar.tt.getPackageName(), nVar);
        }
        boolean z2 = false;
        if (c(nVar.c) && t.i().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = nVar.tt;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.byazt.zn.c.c().c(nVar.c, 0);
            z = true;
        } else {
            z = false;
        }
        int type = spVarC.getType();
        if (type != 1) {
            if (type == 3) {
                c("by_package", jSONObjectC, nVar);
            } else if (type != 4) {
                com.byazt.dm.ve.c().tt("AppLinkClick default");
            } else {
                c("by_package", spVarC, jSONObjectC, nVar);
            }
            if (z2 && !z && ((com.byazt.zn.ve.c().tt() && !com.byazt.zn.ve.c().tt(nVar.c, nVar.tt.getLogExtra())) || com.byazt.zn.ve.c().ve())) {
                com.byazt.zn.c.c().c(nVar.c, 2);
            }
            return z2;
        }
        tt("by_url", jSONObjectC, nVar);
        z2 = true;
        if (z2) {
            com.byazt.zn.c.c().c(nVar.c, 2);
        }
        return z2;
    }

    public static void tt(com.byazt.dd.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        String strA = com.byazt.k.c.ve().tt("app_link_opt") == 1 ? ttVar.a() : null;
        JSONObject jSONObjectC = com.byazt.hu.a.c(new JSONObject(), ttVar);
        u.c(jSONObjectC, "applink_source", "dialog_click_by_sdk");
        com.byazt.zn.c.c().tt("applink_click", jSONObjectC, ttVar);
        com.byazt.nn.sp spVarC = com.byazt.hu.i.c(strA, ttVar);
        if (spVarC.getType() == 2) {
            if (!TextUtils.isEmpty(strA)) {
                tt("dialog_by_url", spVarC, jSONObjectC, ttVar);
            }
            spVarC = com.byazt.hu.i.c(t.getContext(), ttVar.n(), ttVar);
        }
        int type = spVarC.getType();
        if (type == 1) {
            tt("dialog_by_url", jSONObjectC, ttVar);
            return;
        }
        if (type == 3) {
            c("dialog_by_package", jSONObjectC, ttVar);
        } else if (type != 4) {
            com.byazt.dm.ve.c().tt("AppLinkClickDialog default");
        } else {
            c("dialog_by_package", spVarC, jSONObjectC, ttVar);
        }
    }

    public static void tt(String str, @NonNull final JSONObject jSONObject, @NonNull final com.byazt.dd.c cVar) {
        u.c(jSONObject, "applink_source", str);
        u.c(jSONObject, "download_scene", Integer.valueOf(cVar.gt()));
        com.byazt.zn.c.c().tt("deeplink_url_open", jSONObject, cVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((t.i().optInt("check_applink_mode") & 1) != 0) {
                    u.c(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    n.c().c(new uj() { // from class: com.byazt.us.c.2
                        @Override // com.byazt.us.uj
                        public void c(boolean z) {
                            com.byazt.zn.c.c().tt(z ? "deeplink_success" : "deeplink_failed", jSONObject, cVar);
                            if (z) {
                                t.rl().c(t.getContext(), cVar.rl(), cVar.gu(), cVar.qy(), cVar.n(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    t.tt().c(t.getContext(), cVar.rl(), cVar.gu(), cVar.qy(), cVar.n(), str);
                    break;
                }
                break;
        }
    }

    public static void c(@NonNull com.byazt.dd.tt ttVar) {
        String strA = ttVar.a();
        JSONObject jSONObjectC = com.byazt.hu.a.c(new JSONObject(), ttVar);
        u.c(jSONObjectC, "applink_source", "notify_click_by_sdk");
        com.byazt.zn.c.c().tt("applink_click", jSONObjectC, ttVar);
        com.byazt.nn.sp spVarC = com.byazt.hu.i.c(strA, ttVar);
        if (spVarC.getType() == 2) {
            if (!TextUtils.isEmpty(strA)) {
                tt("notify_by_url", spVarC, jSONObjectC, ttVar);
            }
            spVarC = com.byazt.hu.i.c(t.getContext(), ttVar.n(), ttVar);
        }
        int type = spVarC.getType();
        if (type == 1) {
            tt("notify_by_url", jSONObjectC, ttVar);
            return;
        }
        if (type == 3) {
            c("notify_by_package", jSONObjectC, ttVar);
        } else if (type != 4) {
            com.byazt.dm.ve.c().tt("AppLinkClickNotification default");
        } else {
            c("notify_by_package", spVarC, jSONObjectC, ttVar);
        }
    }

    public static void tt(String str, @NonNull com.byazt.nn.sp spVar, @NonNull JSONObject jSONObject, @NonNull com.byazt.dd.c cVar) {
        u.c(jSONObject, "applink_source", str);
        u.c(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(spVar.c()));
        u.c(jSONObject, "download_scene", Integer.valueOf(cVar.gt()));
        com.byazt.zn.c.c().tt("deeplink_url_open_fail", jSONObject, cVar);
    }

    public static boolean c(String str, @NonNull com.byazt.dd.tt ttVar) {
        if (!com.byazt.gq.i.tt(ttVar.ic())) {
            return false;
        }
        if (TextUtils.isEmpty(ttVar.a()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.byazt.n.tt.c().a(ttVar.my());
        JSONObject jSONObject = new JSONObject();
        com.byazt.hu.a.c(jSONObject, ttVar);
        u.c(jSONObject, "applink_source", "auto_click");
        com.byazt.zn.c.c().tt("applink_click", ttVar);
        com.byazt.nn.sp spVarC = com.byazt.hu.i.c(ttVar, ttVar.a(), ttVar.n());
        int type = spVarC.getType();
        if (type == 1) {
            tt("auto_by_url", jSONObject, ttVar);
            return true;
        }
        if (type == 2) {
            tt("auto_by_url", spVarC, jSONObject, ttVar);
            return false;
        }
        if (type == 3) {
            c("auto_by_package", jSONObject, ttVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        c("auto_by_package", spVarC, jSONObject, ttVar);
        return false;
    }

    public static void c(String str, @NonNull final JSONObject jSONObject, @NonNull final com.byazt.dd.c cVar) {
        u.c(jSONObject, "applink_source", str);
        u.c(jSONObject, "download_scene", Integer.valueOf(cVar.gt()));
        com.byazt.zn.c.c().tt("deeplink_app_open", jSONObject, cVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((t.i().optInt("check_applink_mode") & 1) != 0) {
                    u.c(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    n.c().c(new uj() { // from class: com.byazt.us.c.1
                        @Override // com.byazt.us.uj
                        public void c(boolean z) {
                            com.byazt.zn.c.c().tt(z ? "deeplink_success" : "deeplink_failed", jSONObject, cVar);
                            if (z) {
                                t.rl().c(t.getContext(), cVar.rl(), cVar.gu(), cVar.qy(), cVar.n(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    t.tt().c(t.getContext(), cVar.rl(), cVar.gu(), cVar.qy(), cVar.n(), str);
                    break;
                }
                break;
        }
    }

    public static void c(String str, @NonNull com.byazt.nn.sp spVar, @NonNull JSONObject jSONObject, @NonNull com.byazt.dd.c cVar) {
        u.c(jSONObject, "applink_source", str);
        u.c(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(spVar.c()));
        u.c(jSONObject, "download_scene", Integer.valueOf(cVar.gt()));
        com.byazt.zn.c.c().tt("deeplink_app_open_fail", jSONObject, cVar);
    }

    public static boolean c(@NonNull com.byazt.nn.n nVar, int i) {
        JSONObject jSONObject = new JSONObject();
        u.c(jSONObject, "download_scene", Integer.valueOf(nVar.gt()));
        com.byazt.su.tt marketStatusChangeListener = nVar.uj.getMarketStatusChangeListener();
        com.byazt.zn.c.c().tt("market_click_open", jSONObject, nVar);
        DownloadController downloadController = nVar.uj;
        Context context = t.getContext();
        if (downloadController instanceof AdDownloadController) {
            AdDownloadController adDownloadController = (AdDownloadController) downloadController;
            if (adDownloadController.getWeakActivity() != null) {
                context = adDownloadController.getWeakActivity();
            }
        }
        com.byazt.nn.sp spVarC = com.byazt.hu.i.c(context, nVar, nVar.tt.getPackageName());
        String strC = u.c(spVarC.tt(), "open_market");
        int type = spVarC.getType();
        if (type == 5) {
            c(strC, jSONObject, nVar, true);
        } else {
            if (type == 6) {
                u.c(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(spVarC.c()));
                u.c(jSONObject, "download_scene", Integer.valueOf(nVar.gt()));
                if (marketStatusChangeListener != null) {
                    marketStatusChangeListener.tt();
                }
                com.byazt.zn.c.c().tt("market_open_failed", jSONObject, nVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.byazt.zn.c.c().c(nVar.c, i);
        return true;
    }

    public static void c(final String str, @Nullable final JSONObject jSONObject, final com.byazt.nn.n nVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.byazt.dm.ve.c().c(e, "onMarketSuccess");
                return;
            }
        }
        u.c(jSONObject, "applink_source", str);
        u.c(jSONObject, "download_scene", Integer.valueOf(nVar.gt()));
        if (z) {
            com.byazt.su.tt marketStatusChangeListener = nVar.uj.getMarketStatusChangeListener();
            if (marketStatusChangeListener != null) {
                marketStatusChangeListener.c();
            }
            com.byazt.zn.c.c().tt("market_open_success", jSONObject, nVar);
        }
        if ((t.i().optInt("check_applink_mode") & 4) != 0) {
            n.c().tt(new uj() { // from class: com.byazt.us.c.3
                @Override // com.byazt.us.uj
                public void c(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        c.c(com.byazt.hu.i.c(t.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + nVar.n())), nVar, false);
                    }
                    com.byazt.zn.c.c().c(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, nVar);
                    if (z2) {
                        gt gtVarRl = t.rl();
                        Context context = t.getContext();
                        com.byazt.nn.n nVar2 = nVar;
                        DownloadModel downloadModel = nVar2.tt;
                        gtVarRl.c(context, downloadModel, nVar2.uj, nVar2.ve, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.byazt.ou.ve veVarTt = t.tt();
            Context context = t.getContext();
            DownloadModel downloadModel = nVar.tt;
            veVarTt.c(context, downloadModel, nVar.uj, nVar.ve, downloadModel.getPackageName(), str);
        }
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(nVar.tt.getPackageName());
        if (ttVarC != null) {
            com.byazt.hu.t.c().c(c, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            com.byazt.hu.t.c().c(c, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            ttVarC = new com.byazt.dd.tt(nVar.tt, nVar.ve, nVar.uj);
        }
        ttVarC.n(2);
        ttVarC.a(System.currentTimeMillis());
        ttVarC.x(4);
        ttVarC.i(2);
        com.byazt.nn.a.c().c(ttVarC);
        com.byazt.hu.t.c().c(c, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.byazt.di.i.c().c(nVar, ttVarC);
    }

    public static void c(com.byazt.nn.sp spVar, com.byazt.nn.n nVar, boolean z) {
        String strC = u.c(spVar.tt(), "open_market");
        JSONObject jSONObject = new JSONObject();
        u.c(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = spVar.getType();
        if (type == 5) {
            c(strC, jSONObject, nVar, z);
        } else {
            if (type != 6) {
                return;
            }
            u.c(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(spVar.c()));
            u.c(jSONObject, "download_scene", Integer.valueOf(nVar.gt()));
            nVar.uj.getMarketStatusChangeListener();
            com.byazt.zn.c.c().tt("market_open_failed", jSONObject, nVar);
        }
    }

    public static boolean c(long j) {
        return com.byazt.nn.a.c().uj(j) == null;
    }
}
