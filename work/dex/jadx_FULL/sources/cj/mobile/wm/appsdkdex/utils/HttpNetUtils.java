package cj.mobile.wm.appsdkdex.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.common.bean.ActionReqBean;
import cj.mobile.wm.common.bean.AppConfigRespBean;
import cj.mobile.wm.common.bean.Appconfig;
import cj.mobile.wm.common.bean.SdkMediationAppResp;
import cj.mobile.wm.common.runnable.HasTypeRunnable;
import cj.mobile.wm.common.utils.AppConfigUtil;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.GsonUtils;
import cj.mobile.wm.common.utils.PrivateInfoHelper;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.common.utils.SharedPreferencesHelper;
import cj.mobile.wm.common.utils.ThreadUtils;
import cj.mobile.wm.dexc;
import cj.mobile.wm.dexh;
import cj.mobile.wm.dexk;
import cj.mobile.wm.okhttp.OkHttp;
import cj.mobile.wm.okhttp.callback.ByteCallback;
import cj.mobile.wm.okhttp.callback.StringCallback;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.utils.AesUtil;
import cj.mobile.wm.okhttp.utils.GZIPUtils;
import com.zj.adlib.c49;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpNetUtils {
    public static volatile HttpNetUtils httpNetUtils;

    public interface ICommonListener {
        void onFailed(String str);

        void onSuccess();
    }

    private void fetchAdBlackListConfig(final Context context, final String str) {
        DebugLog.common_weak(dexc.dexa("gscd!"));
        OkHttp.get(str).execute(new StringCallback() { // from class: cj.mobile.wm.appsdkdex.utils.HttpNetUtils.4
            @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
            public void onError(Response<String> response) {
                String str2;
                super.onError(response);
                if (response == null || response.getException() == null) {
                    str2 = null;
                } else {
                    str2 = response.code() + dexc.dexa(c49.f40900a) + response.message() + dexc.dexa(c49.f40900a) + response.getException();
                }
                DebugLog.common_w(dexc.dexa("gscdg!") + str2);
                HttpNetUtils.this.readLocalCreativeIds(context);
            }

            @Override // cj.mobile.wm.okhttp.callback.Callback
            public void onSuccess(final Response<String> response) {
                if (ThreadUtils.isUIThread(dexc.dexa("gfudiBeCmbdlMjtuDpogjh.poTvddftt"))) {
                    ThreadUtils.runOnThreadPool(new Runnable() { // from class: cj.mobile.wm.appsdkdex.utils.HttpNetUtils.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            HttpNetUtils.this.doFetchAdBlackListConfigResponse(context, response, str);
                        }
                    });
                } else {
                    HttpNetUtils.this.doFetchAdBlackListConfigResponse(context, response, str);
                }
            }
        });
    }

    public static HttpNetUtils getInstance() {
        if (httpNetUtils == null) {
            synchronized (HttpNetUtils.class) {
                if (httpNetUtils == null) {
                    httpNetUtils = new HttpNetUtils();
                }
            }
        }
        return httpNetUtils;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readLocalCreativeIds(Context context) {
        dexh.dexa(context, dexc.dexa("cmbdlmjtu"), new dexh.dexd() { // from class: cj.mobile.wm.appsdkdex.utils.HttpNetUtils.5
            @Override // cj.mobile.wm.dexh.dexd
            public void onFailed(String str) {
                DebugLog.common_w(dexc.dexa("smdjg!") + str);
            }

            @Override // cj.mobile.wm.dexh.dexd
            public void onSuccess(String str) {
                try {
                    DebugLog.common_weak(dexc.dexa("smdjt!"));
                    ConstantInfo.Config.filterMaterialIdList = Arrays.asList(str.split(dexc.dexa(c49.f40900a)));
                } catch (Throwable th) {
                    DebugLog.common_w(dexc.dexa("smdjg!") + th);
                }
            }
        });
    }

    public void doFetchAdBlackListConfigResponse(Context context, Response<String> response, String str) {
        try {
            if (response.isSuccessful()) {
                String strReplaceAll = response.body().replaceAll("\r\n", dexc.dexa(c49.f40900a));
                ConstantInfo.Config.filterMaterialIdList = Arrays.asList(strReplaceAll.split(dexc.dexa(c49.f40900a)));
                dexh.dexc(context, dexc.dexa("cmbdlmjtu"), strReplaceAll);
                SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l7"), str);
            } else {
                DebugLog.common_w(dexc.dexa("gscdg!") + response.code() + dexc.dexa(c49.f40900a) + response.message());
                readLocalCreativeIds(context);
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("gscdg!") + th);
            ReportUtils.exReport(context, 900001, dexc.dexa("疱环楅葇楲鵦"), dexc.dexa("epGfudiBeCmbdlMjtuDpogjhSftqpotf!gbjm!") + th);
        }
    }

    public void doFetchAppConfigResponse(Context context, Response<byte[]> response, ICommonListener iCommonListener) {
        try {
            AppConfigRespBean appConfigRespBean = (AppConfigRespBean) GsonUtils.getInstance().fromJson(GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken(), dexc.dexa("gfudiBqqDpogjhSftqpotf"))), AppConfigRespBean.class);
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
            String strDexa = dexc.dexa("gfudi!bqq!dpogjh!sftqpotf!gbjm-");
            if (appConfigRespBean != null && appConfigRespBean.getNbr() != null) {
                strDexa = strDexa + appConfigRespBean.getNbr().getCode() + dexc.dexa(c49.f40900a) + appConfigRespBean.getNbr().getMsg();
            }
            DebugLog.common_e(strDexa);
            if (iCommonListener != null) {
                iCommonListener.onFailed(strDexa);
            }
            ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), strDexa);
        } catch (Throwable th) {
            String str = dexc.dexa("gfudi!bqq!dpogjh!sftqpotf!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            if (iCommonListener != null) {
                iCommonListener.onFailed(str);
            }
            ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    public void fetchAppConfig(final Context context, final ICommonListener iCommonListener) {
        try {
            String json = GsonUtils.getInstance().toJson(dexk.dexa(context, ConstantInfo.getAppToken(), ConstantInfo.getAppKey()));
            OkHttp.post(ConstantInfo.getRealNameUrl() + dexc.dexa("tel0bqq0nd/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, dexc.dexa("vug.9")), ConstantInfo.getAppToken())).execute(new ByteCallback() { // from class: cj.mobile.wm.appsdkdex.utils.HttpNetUtils.1
                @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
                public void onError(Response<byte[]> response) {
                    String str;
                    super.onError(response);
                    StringBuilder sb = new StringBuilder();
                    sb.append(dexc.dexa("gfudi!bqq!dpogjh!poFssps-"));
                    if (response == null || response.getException() == null) {
                        str = "";
                    } else {
                        str = response.code() + dexc.dexa(c49.f40900a) + response.getException();
                    }
                    sb.append(str);
                    String string = sb.toString();
                    DebugLog.common_e(string);
                    ICommonListener iCommonListener2 = iCommonListener;
                    if (iCommonListener2 != null) {
                        iCommonListener2.onFailed(string);
                    }
                    ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), string);
                }

                @Override // cj.mobile.wm.okhttp.callback.Callback
                public void onSuccess(final Response<byte[]> response) {
                    if (ThreadUtils.isUIThread(dexc.dexa("gfudiBqqDpogjh.poTvddftt"))) {
                        ThreadUtils.runOnThreadPool(new Runnable() { // from class: cj.mobile.wm.appsdkdex.utils.HttpNetUtils.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                HttpNetUtils.this.doFetchAppConfigResponse(context, response, iCommonListener);
                            }
                        });
                    } else {
                        HttpNetUtils.this.doFetchAppConfigResponse(context, response, iCommonListener);
                    }
                }
            });
        } catch (Throwable th) {
            String str = dexc.dexa("gfudi!bqq!dpogjh!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            if (iCommonListener != null) {
                iCommonListener.onFailed(str);
            }
            ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    public void fetchAppConfigV2(final HasTypeRunnable hasTypeRunnable) {
        OkHttp.post(ConstantInfo.getRealNameUrl() + dexc.dexa("tel0nfejbujpo0dpogjh/bqj")).upBytes((byte[]) null).execute(new ByteCallback() { // from class: cj.mobile.wm.appsdkdex.utils.HttpNetUtils.2
            @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
            public void onError(Response<byte[]> response) {
                String str;
                super.onError(response);
                if (response == null || response.getException() == null) {
                    str = "";
                } else {
                    str = response.code() + dexc.dexa(c49.f40900a) + response.getException();
                }
                DebugLog.common_w(dexc.dexa("dpogjh!w3!poFssps-") + str);
            }

            @Override // cj.mobile.wm.okhttp.callback.Callback
            public void onSuccess(Response<byte[]> response) {
                try {
                    SdkMediationAppResp sdkMediationAppResp = (SdkMediationAppResp) GsonUtils.getInstance().fromJson(GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken(), dexc.dexa("gfudiBqqDpogjhW3"))), SdkMediationAppResp.class);
                    if (sdkMediationAppResp.getCode() != 0) {
                        DebugLog.common_w(dexc.dexa("dpogjh!w3!gbjm!") + sdkMediationAppResp.getCode());
                        return;
                    }
                    if (sdkMediationAppResp.getApp() == null) {
                        DebugLog.inst_w(dexc.dexa("bqq!dpogjh!jt!ovmm"));
                        return;
                    }
                    if (sdkMediationAppResp.getApp().getCheckInstalledStatus() == 0) {
                        DebugLog.inst_w(dexc.dexa("gvmmJotu!txjudi!vobwbjmbcmf"));
                        return;
                    }
                    if (sdkMediationAppResp.getApp().getCheckMaxLimit() <= 0) {
                        DebugLog.inst_w(dexc.dexa("gvmmJotu!mjnju!=>!1"));
                        return;
                    }
                    if (sdkMediationAppResp.getBundle() != null && !sdkMediationAppResp.getBundle().isEmpty()) {
                        HasTypeRunnable hasTypeRunnable2 = hasTypeRunnable;
                        if (hasTypeRunnable2 != null) {
                            hasTypeRunnable2.run(sdkMediationAppResp);
                        }
                        HttpNetUtils.this.saveConfigInfo(sdkMediationAppResp);
                        return;
                    }
                    DebugLog.inst_w(dexc.dexa("gvmmJotu!cvoemf!jt!ovmm"));
                } catch (Throwable th) {
                    DebugLog.common_w(dexc.dexa("dpogjh!w3!gbjm-") + Log.getStackTraceString(th));
                }
            }
        });
    }

    public void initAdBlackListConfig(AppConfigRespBean appConfigRespBean, Context context) {
        try {
            if (appConfigRespBean.getAppConfig().getAppBlackConfig() != null) {
                ConstantInfo.Config.filterMaterialKeyWorldList = appConfigRespBean.getAppConfig().getAppBlackConfig().getSensitiveWord();
                String creativeIdsUrl = appConfigRespBean.getAppConfig().getAppBlackConfig().getCreativeIdsUrl();
                if (TextUtils.isEmpty(creativeIdsUrl)) {
                    DebugLog.common_weak(dexc.dexa("scj!"));
                } else {
                    if (!creativeIdsUrl.equals(SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l7"), ""))) {
                        DebugLog.common_weak(dexc.dexa("scmd!"));
                        fetchAdBlackListConfig(context, creativeIdsUrl);
                        return;
                    }
                    DebugLog.common_weak(dexc.dexa("cmod!"));
                }
            } else {
                DebugLog.common_weak(dexc.dexa("scj!"));
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("gscdg!") + th);
            ReportUtils.exReport(context, 999957, dexc.dexa("赡瞑���缥ꆎ辯楅葇楲鵦"), dexc.dexa("jojuBeGjmufsDpogjh!gbjm!") + th);
        }
        readLocalCreativeIds(context);
    }

    public void reportAction(ActionReqBean actionReqBean) {
        if (actionReqBean == null) {
            DebugLog.common_weak(dexc.dexa("sfqpsuBdujpo!gbjm-ebub!jt!ovmm"));
            return;
        }
        dexk.dexa(WMDexAdHelper.gapc(), actionReqBean);
        String json = GsonUtils.getInstance().toJson(actionReqBean);
        OkHttp.post(ConstantInfo.getTrackHostUrl() + dexc.dexa("tel0dtdSfqpsu/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, dexc.dexa("vug.9")), ConstantInfo.getAppToken())).execute(new ByteCallback() { // from class: cj.mobile.wm.appsdkdex.utils.HttpNetUtils.3
            @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
            public void onError(Response<byte[]> response) {
                super.onError(response);
                DebugLog.common_w(dexc.dexa("sbetg!-") + response.code() + dexc.dexa(c49.f40900a) + response.getException());
            }

            @Override // cj.mobile.wm.okhttp.callback.Callback
            public void onSuccess(Response<byte[]> response) {
                DebugLog.common_weak(dexc.dexa("sbett!"));
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
            DebugLog.common_w(dexc.dexa("qfsnjttjpo!tbwf!gbjmfe-") + Log.getStackTraceString(th));
        }
    }

    public void saveConfigInfo(final SdkMediationAppResp sdkMediationAppResp) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.m24
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferencesHelper.getInstance(WMDexAdHelper.gapc()).savePreferencesString(SharedPreferencesHelper.ConfigType.EXT, dexc.dexa("nn`fyu`l2"), GsonUtils.getInstance().toJson(sdkMediationAppResp));
            }
        });
    }

    public void updateGlobalVariable(Context context, AppConfigRespBean appConfigRespBean) {
        try {
            String realmName = appConfigRespBean.getRealmName();
            if (!TextUtils.isEmpty(realmName)) {
                DebugLog.common_weak(dexc.dexa("vqebuf!bqj!sfnpuf"));
                ConstantInfo.updateRealNameUrl(realmName);
            }
            String trackHost = appConfigRespBean.getTrackHost();
            if (!TextUtils.isEmpty(trackHost)) {
                DebugLog.common_weak(dexc.dexa("vqebuf!usbdl!sfnpuf"));
                ConstantInfo.updateTrackHostUrl(trackHost);
            }
            Appconfig appConfig = appConfigRespBean.getAppConfig();
            if (appConfig != null) {
                AppConfigUtil.updateAppConfig(appConfig);
            }
        } catch (Throwable th) {
            String str = dexc.dexa("vqebuf!wbsjbcmf)sfnpuf*!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_w(str);
            ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), str);
        }
    }
}
