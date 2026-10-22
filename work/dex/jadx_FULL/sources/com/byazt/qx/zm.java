package com.byazt.qx;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 482})
public class zm extends com.byazt.pct.n<JSONObject, JSONObject> {
    public String c;
    public com.byazt.omf.d tt;

    public zm(String str, com.byazt.omf.d dVar) {
        this.tt = dVar;
        this.c = str;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("appInfo", (com.byazt.pct.n<?, ?>) new zm("appInfo", dVar));
        nuVar.c("adInfo", (com.byazt.pct.n<?, ?>) new zm("adInfo", dVar));
        nuVar.c("getTemplateInfo", (com.byazt.pct.n<?, ?>) new zm("getTemplateInfo", dVar));
        nuVar.c("getTeMaiAds", (com.byazt.pct.n<?, ?>) new zm("getTeMaiAds", dVar));
        nuVar.c("isViewable", (com.byazt.pct.n<?, ?>) new zm("isViewable", dVar));
        nuVar.c("getScreenSize", (com.byazt.pct.n<?, ?>) new zm("getScreenSize", dVar));
        nuVar.c("getCloseButtonInfo", (com.byazt.pct.n<?, ?>) new zm("getCloseButtonInfo", dVar));
        nuVar.c("getVolume", (com.byazt.pct.n<?, ?>) new zm("getVolume", dVar));
        nuVar.c("sendReward", (com.byazt.pct.n<?, ?>) new zm("sendReward", dVar));
        nuVar.c("subscribe_app_ad", (com.byazt.pct.n<?, ?>) new zm("subscribe_app_ad", dVar));
        nuVar.c("download_app_ad", (com.byazt.pct.n<?, ?>) new zm("download_app_ad", dVar));
        nuVar.c("cancel_download_app_ad", (com.byazt.pct.n<?, ?>) new zm("cancel_download_app_ad", dVar));
        nuVar.c("unsubscribe_app_ad", (com.byazt.pct.n<?, ?>) new zm("unsubscribe_app_ad", dVar));
        nuVar.c("clickEvent", (com.byazt.pct.n<?, ?>) new zm("clickEvent", dVar));
        nuVar.c("renderDidFinish", (com.byazt.pct.n<?, ?>) new zm("renderDidFinish", dVar));
        nuVar.c("dynamicTrack", (com.byazt.pct.n<?, ?>) new zm("dynamicTrack", dVar));
        nuVar.c("skipVideo", (com.byazt.pct.n<?, ?>) new zm("skipVideo", dVar));
        nuVar.c("muteVideo", (com.byazt.pct.n<?, ?>) new zm("muteVideo", dVar));
        nuVar.c("changeVideoState", (com.byazt.pct.n<?, ?>) new zm("changeVideoState", dVar));
        nuVar.c("getCurrentVideoState", (com.byazt.pct.n<?, ?>) new zm("getCurrentVideoState", dVar));
        nuVar.c("send_temai_product_ids", (com.byazt.pct.n<?, ?>) new zm("send_temai_product_ids", dVar));
        nuVar.c("getMaterialMeta", (com.byazt.pct.n<?, ?>) new zm("getMaterialMeta", dVar));
        nuVar.c("endcard_load", (com.byazt.pct.n<?, ?>) new zm("endcard_load", dVar));
        nuVar.c("pauseWebView", (com.byazt.pct.n<?, ?>) new zm("pauseWebView", dVar));
        nuVar.c("pauseWebViewTimers", (com.byazt.pct.n<?, ?>) new zm("pauseWebViewTimers", dVar));
        nuVar.c("webview_time_track", (com.byazt.pct.n<?, ?>) new zm("webview_time_track", dVar));
        nuVar.c("adInfoStash", (com.byazt.pct.n<?, ?>) new zm("adInfoStash", dVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.omf.d.c cVar = new com.byazt.omf.d.c();
        cVar.c = "call";
        cVar.ve = this.c;
        cVar.uj = jSONObject;
        return this.tt.c(cVar, 3);
    }
}
