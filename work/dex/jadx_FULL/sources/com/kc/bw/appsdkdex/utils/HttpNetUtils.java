package com.kc.bw.appsdkdex.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.appsdkdex.WMDexAdHelper;
import com.kc.bw.common.bean.ActionReqBean;
import com.kc.bw.common.bean.AppConfigRespBean;
import com.kc.bw.common.bean.Appconfig;
import com.kc.bw.common.bean.SdkMediationAppResp;
import com.kc.bw.common.runnable.HasTypeRunnable;
import com.kc.bw.common.utils.AppConfigUtil;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.GsonUtils;
import com.kc.bw.common.utils.PrivateInfoHelper;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.common.utils.SharedPreferencesHelper;
import com.kc.bw.common.utils.ThreadUtils;
import com.kc.bw.dexg;
import com.kc.bw.dexl;
import com.kc.bw.dexo;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.callback.ByteCallback;
import com.kc.bw.okhttp.callback.StringCallback;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.utils.AesUtil;
import com.kc.bw.okhttp.utils.GZIPUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HttpNetUtils {
    public static volatile HttpNetUtils httpNetUtils;

    /* JADX INFO: renamed from: com.kc.bw.appsdkdex.utils.HttpNetUtils$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends ByteCallback {
        public final HttpNetUtils this$0;
        public final ICommonListener val$commonListener;
        public final Context val$context;

        public AnonymousClass1(HttpNetUtils httpNetUtils, Context context, ICommonListener iCommonListener) {
            this.this$0 = httpNetUtils;
            this.val$context = context;
            this.val$commonListener = iCommonListener;
        }

        @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            String str;
            super.onError(response);
            StringBuilder sb = new StringBuilder();
            sb.append(dexg.dexa("gfudi!bqq!dpogjh!poFssps-"));
            if (response == null || response.getException() == null) {
                str = "";
            } else {
                str = response.code() + dexg.dexa(c49.f40900a) + response.getException();
            }
            sb.append(str);
            String string = sb.toString();
            DebugLog.common_e(string);
            ICommonListener iCommonListener = this.val$commonListener;
            if (iCommonListener != null) {
                iCommonListener.onFailed(string);
            }
            ReportUtils.exReport(this.val$context, 200006, dexg.dexa("TEL扞樌捗楲鵦"), string);
        }

        @Override // com.kc.bw.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            if (ThreadUtils.isUIThread(dexg.dexa("gfudiBqqDpogjh.poTvddftt"))) {
                ThreadUtils.runOnThreadPool(new Runnable(this, response) { // from class: com.kc.bw.appsdkdex.utils.HttpNetUtils.1.1
                    public final AnonymousClass1 this$1;
                    public final Response val$response;

                    {
                        this.this$1 = this;
                        this.val$response = response;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = this.this$1;
                        anonymousClass1.this$0.doFetchAppConfigResponse(anonymousClass1.val$context, this.val$response, anonymousClass1.val$commonListener);
                    }
                });
            } else {
                this.this$0.doFetchAppConfigResponse(this.val$context, response, this.val$commonListener);
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.bw.appsdkdex.utils.HttpNetUtils$4, reason: invalid class name */
    @Keep
    public class AnonymousClass4 extends StringCallback {
        public final HttpNetUtils this$0;
        public final Context val$context;
        public final String val$url;

        public AnonymousClass4(HttpNetUtils httpNetUtils, Context context, String str) {
            this.this$0 = httpNetUtils;
            this.val$context = context;
            this.val$url = str;
        }

        @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
        public void onError(Response<String> response) {
            String str;
            super.onError(response);
            if (response == null || response.getException() == null) {
                str = null;
            } else {
                str = response.code() + dexg.dexa(c49.f40900a) + response.message() + dexg.dexa(c49.f40900a) + response.getException();
            }
            DebugLog.common_w(dexg.dexa("gscdg!") + str);
            this.this$0.readLocalCreativeIds(this.val$context);
        }

        @Override // com.kc.bw.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            if (ThreadUtils.isUIThread(dexg.dexa("gfudiBeCmbdlMjtuDpogjh.poTvddftt"))) {
                ThreadUtils.runOnThreadPool(new Runnable(this, response) { // from class: com.kc.bw.appsdkdex.utils.HttpNetUtils.4.1
                    public final AnonymousClass4 this$1;
                    public final Response val$response;

                    {
                        this.this$1 = this;
                        this.val$response = response;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = this.this$1;
                        anonymousClass4.this$0.doFetchAdBlackListConfigResponse(anonymousClass4.val$context, this.val$response, anonymousClass4.val$url);
                    }
                });
            } else {
                this.this$0.doFetchAdBlackListConfigResponse(this.val$context, response, this.val$url);
            }
        }
    }

    @Keep
    public interface ICommonListener {
        void onFailed(String str);

        void onSuccess();
    }

    private void fetchAdBlackListConfig(Context context, String str) {
        DebugLog.common_weak(dexg.dexa("gscd!"));
        OkHttp.get(str).execute(new AnonymousClass4(this, context, str));
    }

    public static HttpNetUtils getInstance() {
        if (httpNetUtils == null) {
            synchronized (HttpNetUtils.class) {
                try {
                    if (httpNetUtils == null) {
                        httpNetUtils = new HttpNetUtils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return httpNetUtils;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readLocalCreativeIds(Context context) {
        dexl.dexa(context, dexg.dexa("cmbdlmjtu"), new dexl.dexd(this) { // from class: com.kc.bw.appsdkdex.utils.HttpNetUtils.5
            public final HttpNetUtils this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.dexl.dexd
            public void onFailed(String str) {
                DebugLog.common_w(dexg.dexa("smdjg!") + str);
            }

            @Override // com.kc.bw.dexl.dexd
            public void onSuccess(String str) {
                try {
                    DebugLog.common_weak(dexg.dexa("smdjt!"));
                    ConstantInfo.Config.filterMaterialIdList = Arrays.asList(str.split(dexg.dexa(c49.f40900a)));
                } catch (Throwable th) {
                    DebugLog.common_w(dexg.dexa("smdjg!") + th);
                }
            }
        });
    }

    public void doFetchAdBlackListConfigResponse(Context context, Response<String> response, String str) {
        try {
            if (response.isSuccessful()) {
                String strReplaceAll = response.body().replaceAll("\r\n", dexg.dexa(c49.f40900a));
                ConstantInfo.Config.filterMaterialIdList = Arrays.asList(strReplaceAll.split(dexg.dexa(c49.f40900a)));
                dexl.dexc(context, dexg.dexa("cmbdlmjtu"), strReplaceAll);
                SharedPreferencesHelper.getInstance(context).savePreferencesString(dexg.dexa("nn`tq`l7"), str);
            } else {
                DebugLog.common_w(dexg.dexa("gscdg!") + response.code() + dexg.dexa(c49.f40900a) + response.message());
                readLocalCreativeIds(context);
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("gscdg!") + th);
            ReportUtils.exReport(context, 900001, dexg.dexa("疱环楅葇楲鵦"), dexg.dexa("epGfudiBeCmbdlMjtuDpogjhSftqpotf!gbjm!") + th);
        }
    }

    public void doFetchAppConfigResponse(Context context, Response<byte[]> response, ICommonListener iCommonListener) {
        try {
            AppConfigRespBean appConfigRespBean = (AppConfigRespBean) GsonUtils.getInstance().fromJson(GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken(), dexg.dexa("gfudiBqqDpogjhSftqpotf"))), AppConfigRespBean.class);
            if (appConfigRespBean != null && appConfigRespBean.getNbr().getCode() == 0) {
                updateGlobalVariable(context, appConfigRespBean);
                initAdBlackListConfig(appConfigRespBean, context);
                saveAppConfig(context, appConfigRespBean);
                if (iCommonListener != null) {
                    iCommonListener.onSuccess();
                    return;
                }
                return;
            }
            String strDexa = dexg.dexa("gfudi!bqq!dpogjh!sftqpotf!gbjm-");
            if (appConfigRespBean != null && appConfigRespBean.getNbr() != null) {
                strDexa = strDexa + appConfigRespBean.getNbr().getCode() + dexg.dexa(c49.f40900a) + appConfigRespBean.getNbr().getMsg();
            }
            DebugLog.common_e(strDexa);
            if (iCommonListener != null) {
                iCommonListener.onFailed(strDexa);
            }
            ReportUtils.exReport(context, 200006, dexg.dexa("TEL扞樌捗楲鵦"), strDexa);
        } catch (Throwable th) {
            String str = dexg.dexa("gfudi!bqq!dpogjh!sftqpotf!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            if (iCommonListener != null) {
                iCommonListener.onFailed(str);
            }
            ReportUtils.exReport(context, 200006, dexg.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    public void fetchAppConfig(Context context, ICommonListener iCommonListener) {
        try {
            String json = GsonUtils.getInstance().toJson(dexo.dexa(context, ConstantInfo.getAppToken(), ConstantInfo.getAppKey()));
            OkHttp.post(ConstantInfo.getRealNameUrl() + dexg.dexa("tel0bqq0nd/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, dexg.dexa("vug.9")), ConstantInfo.getAppToken())).execute(new AnonymousClass1(this, context, iCommonListener));
        } catch (Throwable th) {
            String str = dexg.dexa("gfudi!bqq!dpogjh!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            if (iCommonListener != null) {
                iCommonListener.onFailed(str);
            }
            ReportUtils.exReport(context, 200006, dexg.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    public void fetchAppConfigV2(HasTypeRunnable hasTypeRunnable) {
        OkHttp.post(ConstantInfo.getRealNameUrl() + dexg.dexa("tel0nfejbujpo0dpogjh/bqj")).upBytes((byte[]) null).execute(new ByteCallback(this, hasTypeRunnable) { // from class: com.kc.bw.appsdkdex.utils.HttpNetUtils.2
            public final HttpNetUtils this$0;
            public final HasTypeRunnable val$runnable;

            {
                this.this$0 = this;
                this.val$runnable = hasTypeRunnable;
            }

            @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
            public void onError(Response<byte[]> response) {
                String str;
                super.onError(response);
                if (response == null || response.getException() == null) {
                    str = "";
                } else {
                    str = response.code() + dexg.dexa(c49.f40900a) + response.getException();
                }
                DebugLog.common_w(dexg.dexa("dpogjh!w3!poFssps-") + str);
            }

            @Override // com.kc.bw.okhttp.callback.Callback
            public void onSuccess(Response<byte[]> response) {
                try {
                    SdkMediationAppResp sdkMediationAppResp = (SdkMediationAppResp) GsonUtils.getInstance().fromJson(GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken(), dexg.dexa("gfudiBqqDpogjhW3"))), SdkMediationAppResp.class);
                    if (sdkMediationAppResp.getCode() != 0) {
                        DebugLog.common_w(dexg.dexa("dpogjh!w3!gbjm!") + sdkMediationAppResp.getCode());
                        return;
                    }
                    if (sdkMediationAppResp.getApp() == null) {
                        DebugLog.inst_w(dexg.dexa("bqq!dpogjh!jt!ovmm"));
                        return;
                    }
                    if (sdkMediationAppResp.getApp().getCheckInstalledStatus() == 0) {
                        DebugLog.inst_w(dexg.dexa("gvmmJotu!txjudi!vobwbjmbcmf"));
                        return;
                    }
                    if (sdkMediationAppResp.getApp().getCheckMaxLimit() <= 0) {
                        DebugLog.inst_w(dexg.dexa("gvmmJotu!mjnju!=>!1"));
                        return;
                    }
                    if (sdkMediationAppResp.getBundle() != null && !sdkMediationAppResp.getBundle().isEmpty()) {
                        HasTypeRunnable hasTypeRunnable2 = this.val$runnable;
                        if (hasTypeRunnable2 != null) {
                            hasTypeRunnable2.run(sdkMediationAppResp);
                        }
                        this.this$0.saveConfigInfo(sdkMediationAppResp);
                        return;
                    }
                    DebugLog.inst_w(dexg.dexa("gvmmJotu!cvoemf!jt!ovmm"));
                } catch (Throwable th) {
                    DebugLog.common_w(dexg.dexa("dpogjh!w3!gbjm-") + Log.getStackTraceString(th));
                }
            }
        });
    }

    public void initAdBlackListConfig(AppConfigRespBean appConfigRespBean, Context context) {
        String strDexa;
        try {
            if (appConfigRespBean.getAppConfig().getAppBlackConfig() != null) {
                ConstantInfo.Config.filterMaterialKeyWorldList = appConfigRespBean.getAppConfig().getAppBlackConfig().getSensitiveWord();
                String creativeIdsUrl = appConfigRespBean.getAppConfig().getAppBlackConfig().getCreativeIdsUrl();
                if (TextUtils.isEmpty(creativeIdsUrl)) {
                    strDexa = dexg.dexa("scj!");
                } else {
                    if (!creativeIdsUrl.equals(SharedPreferencesHelper.getInstance(context).getPreferencesString(dexg.dexa("nn`tq`l7"), ""))) {
                        DebugLog.common_weak(dexg.dexa("scmd!"));
                        fetchAdBlackListConfig(context, creativeIdsUrl);
                        return;
                    }
                    strDexa = dexg.dexa("cmod!");
                }
            } else {
                strDexa = dexg.dexa("scj!");
            }
            DebugLog.common_weak(strDexa);
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("gscdg!") + th);
            ReportUtils.exReport(context, 999957, dexg.dexa("赡瞑���缥ꆎ辯楅葇楲鵦"), dexg.dexa("jojuBeGjmufsDpogjh!gbjm!") + th);
        }
        readLocalCreativeIds(context);
    }

    public void reportAction(ActionReqBean actionReqBean) {
        if (actionReqBean == null) {
            DebugLog.common_weak(dexg.dexa("sfqpsuBdujpo!gbjm-ebub!jt!ovmm"));
            return;
        }
        dexo.dexa(WMDexAdHelper.gapc(), actionReqBean);
        String json = GsonUtils.getInstance().toJson(actionReqBean);
        OkHttp.post(ConstantInfo.getTrackHostUrl() + dexg.dexa("tel0dtdSfqpsu/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, dexg.dexa("vug.9")), ConstantInfo.getAppToken())).execute(new ByteCallback(this) { // from class: com.kc.bw.appsdkdex.utils.HttpNetUtils.3
            public final HttpNetUtils this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
            public void onError(Response<byte[]> response) {
                super.onError(response);
                DebugLog.common_w(dexg.dexa("sbetg!-") + response.code() + dexg.dexa(c49.f40900a) + response.getException());
            }

            @Override // com.kc.bw.okhttp.callback.Callback
            public void onSuccess(Response<byte[]> response) {
                DebugLog.common_weak(dexg.dexa("sbett!"));
            }
        });
    }

    public void saveAppConfig(Context context, AppConfigRespBean appConfigRespBean) {
        AppConfigUtil.getInstance().saveAppConfig(context, appConfigRespBean);
        try {
            PrivateInfoHelper.BeanInfo beanInfo = (PrivateInfoHelper.BeanInfo) GsonUtils.getInstance().fromJson(GsonUtils.getInstance().toJson(appConfigRespBean.getAppConfig().getAppPermissionConfig()), PrivateInfoHelper.BeanInfo.class);
            if (beanInfo == null) {
                beanInfo = new PrivateInfoHelper.BeanInfo();
            }
            PrivateInfoHelper.putPrivateInfo(context, beanInfo);
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("qfsnjttjpo!tbwf!gbjmfe-") + Log.getStackTraceString(th));
        }
    }

    public void saveConfigInfo(final SdkMediationAppResp sdkMediationAppResp) {
        ThreadUtils.runOnThreadPool(new Runnable(sdkMediationAppResp) { // from class: com.kc.bw.appsdkdex.utils.HttpNetUtils$$ExternalSyntheticLambda0
            public final SdkMediationAppResp f$0;

            {
                this.f$0 = sdkMediationAppResp;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferencesHelper.getInstance(WMDexAdHelper.gapc()).savePreferencesString(SharedPreferencesHelper.ConfigType.EXT, dexg.dexa("nn`fyu`l2"), GsonUtils.getInstance().toJson(this.f$0));
            }
        });
    }

    public void updateGlobalVariable(Context context, AppConfigRespBean appConfigRespBean) {
        try {
            String realmName = appConfigRespBean.getRealmName();
            if (!TextUtils.isEmpty(realmName)) {
                DebugLog.common_weak(dexg.dexa("vqebuf!bqj!sfnpuf"));
                ConstantInfo.updateRealNameUrl(realmName);
            }
            String trackHost = appConfigRespBean.getTrackHost();
            if (!TextUtils.isEmpty(trackHost)) {
                DebugLog.common_weak(dexg.dexa("vqebuf!usbdl!sfnpuf"));
                ConstantInfo.updateTrackHostUrl(trackHost);
            }
            Appconfig appConfig = appConfigRespBean.getAppConfig();
            if (appConfig != null) {
                AppConfigUtil.updateAppConfig(appConfig);
            }
        } catch (Throwable th) {
            String str = dexg.dexa("vqebuf!wbsjbcmf)sfnpuf*!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_w(str);
            ReportUtils.exReport(context, 200006, dexg.dexa("TEL扞樌捗楲鵦"), str);
        }
    }
}
