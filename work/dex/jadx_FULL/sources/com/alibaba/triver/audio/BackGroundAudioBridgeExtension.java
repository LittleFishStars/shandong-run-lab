package com.alibaba.triver.audio;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.commonability.file.g;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.DomainNameController;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BackGroundAudioBridgeExtension implements AppDestroyPoint, AppPausePoint, BridgeExtension {
    public static final String ATTR_RECORD_PLAY_STATE = "isRecordAudioPlayState";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24653a = "BackgroundAudio";
    private static final String b = "playWithNoParam";
    private static final String c = "src";
    private static final String d = "startTime";
    private static final String e = "title";
    private static final String f = "epname";
    private static final String g = "singer";
    private static final String h = "coverImgUrl";
    private static final String i = "webUrl";
    private static final String j = "duration";
    private static final String k = "currentTime";
    private static final String l = "buffered";
    private static final String m = "paused";
    private static final String n = "bizIdentifier";
    private static final String o = "option";
    private static final boolean p = true;
    private static final boolean q = false;
    private static final String s = "please insure your video source is in domain whitelist";
    private String r;

    private void a(Page page, ApiContext apiContext, BridgeCallback bridgeCallback) {
        b.g().a(apiContext);
        d(bridgeCallback);
    }

    private void a(String str, BridgeCallback bridgeCallback) {
    }

    private void b(Page page, ApiContext apiContext, BridgeCallback bridgeCallback) {
        b.g().a((ApiContext) null);
        d(bridgeCallback);
    }

    private void c(BridgeCallback bridgeCallback) {
        int iK = b.g().k();
        int iL = b.g().l();
        int iJ = b.g().j();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("duration", (Object) Float.valueOf(iK / 1000.0f));
        jSONObject.put("currentPosition", (Object) Float.valueOf(iL / 1000.0f));
        jSONObject.put("downloadPercent", (Object) Integer.valueOf(iJ));
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private static void d(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private static void e(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("errorCode", "INVALID_PARAM");
        jSONObject.put(SendToNativeCallback.KEY_MESSAGE, "INVALID_PARAM");
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getAudioPlayStateRecord(@BindingParam({c}) String str, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("getAudioPlayStateRecord, src=" + str + ", params=" + jSONObject + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        b.g().a(apiContext);
        a(str, bridgeCallback);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getBackgroundAudioOption(@BindingParam({"optionName"}) String str, @BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("getBackgroundAudioOption, optionName=" + str + ", page=" + page + ", params=" + jSONObject + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        this.r = "";
        if (page.getApp() != null) {
            this.r = page.getApp().getAppId();
        }
        b("getBackgroundAudioOption, currentAppId :" + this.r);
        a(bridgeCallback, str);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getBackgroundAudioPlayerState(@BindingRequest JSONObject jSONObject, @BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("getBackgroundAudioPlayerState, params=" + jSONObject + ", page=" + page + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        this.r = "";
        if (page.getApp() != null) {
            this.r = page.getApp().getAppId();
        }
        b("setBackgroundAudioOption, currentAppId :" + this.r);
        b.g().a(apiContext);
        c(bridgeCallback);
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        try {
            ApiContext apiContextR = b.g().r();
            if (app == null || apiContextR == null || !app.getAppId().equals(apiContextR.getAppId())) {
                return;
            }
            b.g().d();
            b.g().n();
            b.g().a((ApiContext) null);
            RVLogger.e(f24653a, "app : " + app.getAppId() + "is destroy , stop background audio");
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppPausePoint
    public void onAppPause(App app) {
        TemplateConfigModel templateConfig;
        try {
            ApiContext apiContextR = b.g().r();
            if (app == null || apiContextR == null || !app.getAppId().equals(apiContextR.getAppId())) {
                return;
            }
            AppInfoModel appInfoModel = (AppInfoModel) app.getData(AppInfoModel.class);
            if (TROrangeController.enableBackGroundAduioPlay(apiContextR.getAppId(), (appInfoModel == null || (templateConfig = appInfoModel.getTemplateConfig()) == null) ? null : templateConfig.getTemplateId())) {
                return;
            }
            b.g().c();
            RVLogger.e(f24653a, "app : " + app.getAppId() + "is paused , pause background audio");
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void pauseBackgroundAudio(@BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("pauseBackgroundAudio, params=" + jSONObject + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        b.g().a(apiContext);
        a(bridgeCallback);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void playBackgroundAudio(@BindingParam({"business"}) String str, @BindingParam({b}) boolean z, @BindingParam({"audioDataUrl"}) String str2, @BindingParam({"audioName"}) String str3, @BindingParam({"audioDescribe"}) String str4, @BindingParam({"singerName"}) String str5, @BindingParam({"audioLogoURL"}) String str6, @BindingParam({h}) String str7, @BindingParam({"appName"}) String str8, @BindingParam({"appLogoUrl"}) String str9, @BindingParam({"isRecordAudioPlayState"}) boolean z2, @BindingParam({"hideRemoteControl"}) boolean z3, @BindingRequest JSONObject jSONObject, @BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("setBackgroundAudioOption, business=" + str + ", playWithNoParam=" + z + ", audioDataUrl=" + str2 + ", audioName=" + str3 + ", audioDescribe=" + str4 + ", audioLogoURL=" + str6 + ", coverImgUrl=" + str7 + ", appName=" + str8 + ", appLogoUrl=" + str9 + ", isRecordAudioPlayState=" + z2 + ", hideRemoteControl=" + z3 + ", params=" + jSONObject + ", page=" + page + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        this.r = "";
        if (page.getApp() != null) {
            this.r = page.getApp().getAppId();
        }
        b("setBackgroundAudioOption, currentAppId :" + this.r);
        b.g().a(apiContext);
        a(str2, str3, str5, str4, str7, str, str9, str8, z2, z3, z, jSONObject, bridgeCallback);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void seekBackgroundAudio(@BindingParam({"position"}) int i2, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("seekBackgroundAudio, position=" + i2 + ", params=" + jSONObject + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        b.g().a(apiContext);
        a(apiContext, bridgeCallback, i2);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void setBackgroundAudioOption(@BindingParam({o}) String str, @BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str2) {
        b("setBackgroundAudioOption, option=" + str + ", page=" + page + ", params=" + jSONObject + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        this.r = "";
        if (page.getApp() != null) {
            this.r = page.getApp().getAppId();
        }
        b("setBackgroundAudioOption, currentAppId :" + this.r);
        b.g().a(apiContext);
        a(bridgeCallback, jSONObject, page, str2);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void startMonitorBackgroundAudio(@BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("startMonitorBackgroundAudio, page=" + page + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        a(page, apiContext, bridgeCallback);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void stopBackgroundAudio(@BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("stopBackgroundAudio, params=" + jSONObject + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        b.g().a(apiContext);
        b(bridgeCallback);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void stopMonitorBackgroundAudio(@BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        b("stopMonitorBackgroundAudio, page=" + page + ", apiContext=" + apiContext + ", callback=" + bridgeCallback);
        b(page, apiContext, bridgeCallback);
    }

    private void a(BridgeCallback bridgeCallback, String str) {
        int i2;
        b("onGetOption:### " + str);
        if (TextUtils.isEmpty(str)) {
            e(bridgeCallback);
            return;
        }
        a aVarM = b.g().m();
        b bVarG = b.g();
        if (c.equalsIgnoreCase(str)) {
            String strFilePathToApUrl = aVarM.c;
            if (!TextUtils.isEmpty(strFilePathToApUrl) && !strFilePathToApUrl.startsWith("http")) {
                strFilePathToApUrl = FileUtils.filePathToApUrl(strFilePathToApUrl, "audio");
            }
            a(bridgeCallback, c, strFilePathToApUrl);
            return;
        }
        if (d.equalsIgnoreCase(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            jSONObject.put(d, (Object) Float.valueOf(bVarG.p() / 1000.0f));
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        if ("title".equalsIgnoreCase(str)) {
            a(bridgeCallback, "title", aVarM.d);
            return;
        }
        if (f.equalsIgnoreCase(str)) {
            a(bridgeCallback, f, aVarM.f24669a);
            return;
        }
        if (g.equalsIgnoreCase(str)) {
            a(bridgeCallback, g, aVarM.e);
            return;
        }
        if (h.equalsIgnoreCase(str)) {
            a(bridgeCallback, h, aVarM.f);
            return;
        }
        if (i.equalsIgnoreCase(str)) {
            a(bridgeCallback, i, aVarM.b);
            return;
        }
        if ("duration".equalsIgnoreCase(str)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", (Object) Boolean.TRUE);
            int iK = bVarG.k();
            i2 = iK >= 0 ? iK : 0;
            jSONObject2.put("duration", (Object) Float.valueOf(i2 != 0 ? i2 / 1000.0f : 0.0f));
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        if (k.equalsIgnoreCase(str)) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("success", (Object) Boolean.TRUE);
            int iL = bVarG.l();
            i2 = iL >= 0 ? iL : 0;
            jSONObject3.put(k, (Object) Float.valueOf(i2 != 0 ? i2 / 1000.0f : 0.0f));
            bridgeCallback.sendJSONResponse(jSONObject3);
            return;
        }
        if (l.equalsIgnoreCase(str)) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("success", (Object) Boolean.TRUE);
            jSONObject4.put(l, (Object) Integer.valueOf(bVarG.j()));
            bridgeCallback.sendJSONResponse(jSONObject4);
            return;
        }
        if (m.equalsIgnoreCase(str)) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("success", (Object) Boolean.TRUE);
            jSONObject5.put(m, (Object) Boolean.valueOf(bVarG.q()));
            bridgeCallback.sendJSONResponse(jSONObject5);
            return;
        }
        if ("isRecordAudioPlayState".equalsIgnoreCase(str)) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("success", (Object) Boolean.TRUE);
            jSONObject6.put("isRecordAudioPlayState", (Object) Boolean.FALSE);
            bridgeCallback.sendJSONResponse(jSONObject6);
            return;
        }
        e(bridgeCallback);
    }

    private void b(BridgeCallback bridgeCallback) {
        b.g().d();
        d(bridgeCallback);
    }

    private void b(String str) {
        RVLogger.d(f24653a, str);
    }

    private void a(BridgeCallback bridgeCallback, JSONObject jSONObject, Page page, String str) {
        b("onSetOption:### " + jSONObject);
        if (jSONObject == null) {
            e(bridgeCallback);
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(o);
        if (jSONObject2 == null) {
            e(bridgeCallback);
            return;
        }
        a aVarM = b.g().m();
        b bVarG = b.g();
        boolean z = true;
        if (jSONObject2.containsKey(c)) {
            String string = jSONObject2.getString(c);
            if ((TextUtils.isEmpty(string) || !string.startsWith(g.e)) && TRiverUtils.needAuthentication(page) && !DomainNameController.urlBothInOfficialDomainListAndPermissionModelList(string, page, str)) {
                RVLogger.e(f24653a, s);
                b.g().a(s);
                return;
            }
            aVarM.c = a(string);
            bVarG.o();
            b("Play when set src = " + aVarM.c);
        } else if (jSONObject2.containsKey(d)) {
            bVarG.b(jSONObject2.getIntValue(d) * 1000);
        } else if (jSONObject2.containsKey("title")) {
            aVarM.d = jSONObject2.getString("title");
        } else if (jSONObject2.containsKey(f)) {
            aVarM.f24669a = jSONObject2.getString(f);
        } else if (jSONObject2.containsKey(g)) {
            aVarM.e = jSONObject2.getString(g);
        } else if (jSONObject2.containsKey(h)) {
            aVarM.f = jSONObject2.getString(h);
        } else if (jSONObject2.containsKey(i)) {
            aVarM.b = jSONObject2.getString(i);
        } else {
            if (!jSONObject2.containsKey("isRecordAudioPlayState")) {
                e(bridgeCallback);
            }
            z = false;
        }
        if (z) {
            d(bridgeCallback);
            b.g().f();
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        b("handleActionPlay:###");
        if (z3) {
            b("Play with no param.");
            b.g().a();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", (Object) Boolean.TRUE);
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        String string = jSONObject.getString(f);
        String string2 = jSONObject.getString(i);
        a aVar = new a();
        aVar.f24669a = string;
        aVar.b = string2;
        aVar.c = str;
        aVar.d = str2;
        aVar.e = str3;
        aVar.f = str5;
        aVar.g = str4;
        aVar.i = z;
        b("AudioDetail=" + aVar.toString());
        b.g().a(aVar);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("success", (Object) Boolean.TRUE);
        bridgeCallback.sendJSONResponse(jSONObject3);
    }

    private void a(BridgeCallback bridgeCallback) {
        b.g().c();
        d(bridgeCallback);
    }

    private void a(ApiContext apiContext, BridgeCallback bridgeCallback, int i2) {
        b.g().a(i2);
        d(bridgeCallback);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(g.e)) {
            return str;
        }
        String strApUrlToFilePath = FileUtils.apUrlToFilePath(str);
        b("Covert apFilePath to absPath : " + str + " -> " + strApUrlToFilePath);
        return strApUrlToFilePath;
    }

    private void a(BridgeCallback bridgeCallback, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put(str, (Object) str2);
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
