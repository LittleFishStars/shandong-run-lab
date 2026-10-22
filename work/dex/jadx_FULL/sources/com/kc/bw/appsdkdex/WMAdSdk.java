package com.kc.bw.appsdkdex;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.bw.appsdkdex.utils.AppInstUtil;
import com.kc.bw.appsdkdex.utils.HttpNetUtils;
import com.kc.bw.common.bean.AppConfigRespBean;
import com.kc.bw.common.bean.Appconfig;
import com.kc.bw.common.bean.SdkMediationAppResp;
import com.kc.bw.common.bean.SdkTrackEventBean;
import com.kc.bw.common.bean.SdkTrackEventBeans;
import com.kc.bw.common.runnable.HasTypeRunnable;
import com.kc.bw.common.utils.AppConfigUtil;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.ContextContainer;
import com.kc.bw.common.utils.CrashHandler;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.DeviceUtils;
import com.kc.bw.common.utils.GsonUtils;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.common.utils.SDKTrackUtils;
import com.kc.bw.common.utils.SharedPreferencesHelper;
import com.kc.bw.common.utils.ThreadUtils;
import com.kc.bw.common.utils.Utils;
import com.kc.bw.dexg;
import com.kc.bw.dexl;
import com.kc.bw.dexm;
import com.kc.bw.dexp;
import com.kc.bw.hiddenapibypass.HiddenApiBypass;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.callback.ByteCallback;
import com.kc.bw.okhttp.model.HttpHeaders;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.request.PostRequest;
import com.kc.bw.okhttp.utils.AesUtil;
import com.kc.bw.okhttp.utils.GZIPUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import com.zj.adlib.o61;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMAdSdk {
    public static boolean dexq;
    public static boolean dexr;
    public static boolean dexs;
    public static SdkStatus dext = SdkStatus.NOT_INITIALIZED;
    public final Context dexa;
    public final String dexb;
    public final String dexc;
    public final String dexd;
    public final boolean dexe;
    public final boolean dexf;
    public final boolean dexg;
    public final boolean dexh;
    public final boolean dexi;
    public final String dexj;
    public WMCustomPrivateController dexk;
    public IInitCallback dexl;
    public boolean dexm;
    public boolean dexn;
    public boolean dexo;
    public String dexp;

    @Keep
    public static class Builder {
        public String dexa;
        public String dexb;
        public String dexc;
        public boolean dexd = true;
        public boolean dexe = true;
        public boolean dexf = true;
        public boolean dexg = true;
        public boolean dexh = false;
        public String dexi;
        public WMCustomPrivateController dexj;

        public WMAdSdk build(Context context) {
            return new WMAdSdk(context, this, null);
        }

        public Builder debug(boolean z) {
            this.dexh = z;
            return this;
        }

        public Builder enableCrashHandle(boolean z) {
            this.dexd = z;
            return this;
        }

        public Builder enableHiddenApiExemptions(boolean z) {
            this.dexf = z;
            return this;
        }

        public Builder enablePersonalized(boolean z) {
            this.dexe = z;
            return this;
        }

        public Builder enableSensor(boolean z) {
            this.dexg = z;
            return this;
        }

        public Builder setLocalConfigFileName(String str) {
            this.dexi = str;
            return this;
        }

        public Builder setPrivateController(WMCustomPrivateController wMCustomPrivateController) {
            this.dexj = wMCustomPrivateController;
            return this;
        }

        public Builder setToken(String str) {
            this.dexa = str;
            return this;
        }

        public Builder setWXAppId(String str) {
            this.dexc = str;
            return this;
        }

        public Builder setkey(String str) {
            this.dexb = str;
            return this;
        }
    }

    @Keep
    public interface IInitCallback {
        void onFail(String str);

        void onSuccess();
    }

    @Keep
    public class dexa implements Runnable {
        public final WMAdSdk dexa;

        public dexa(WMAdSdk wMAdSdk) {
            this.dexa = wMAdSdk;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealTime = Utils.getElapsedRealTime();
                HiddenApiBypass.setHiddenApiExemptions("");
                DebugLog.init_weak(dexg.dexa("sfh!ijeefo!") + Utils.getCostTime(elapsedRealTime));
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.common_w(dexg.dexa("sfh!ijeefo!gbjm!") + stackTraceString);
                ReportUtils.exReport(this.dexa.dexa, 200012, dexg.dexa("TEL扞樌捗紩懍ꛑ阐BQJ鲂憎楲鵦"), stackTraceString);
            }
        }
    }

    @Keep
    public class dexb implements Runnable {
        public final Context dexa;
        public final WMAdSdk dexb;

        public dexb(WMAdSdk wMAdSdk, Context context) {
            this.dexb = wMAdSdk;
            this.dexa = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppConfigRespBean appConfigRespBean;
            AppConfigRespBean appConfigRespBean2;
            try {
                DebugLog.init_weak(dexg.dexa("mpbe!mdgh!!"));
                if (TextUtils.isEmpty(this.dexb.dexp) || (appConfigRespBean2 = (AppConfigRespBean) GsonUtils.getInstance().fromJson(this.dexb.dexp, AppConfigRespBean.class)) == null) {
                    DebugLog.init_weak(dexg.dexa("mdgh!jowbme"));
                    WMAdSdk wMAdSdk = this.dexb;
                    String strDexa = wMAdSdk.dexa(this.dexa, wMAdSdk.dexj);
                    if (!TextUtils.isEmpty(strDexa) && (appConfigRespBean = (AppConfigRespBean) GsonUtils.getInstance().fromJson(strDexa, AppConfigRespBean.class)) != null) {
                        this.dexb.dexa(this.dexa, appConfigRespBean);
                        AppConfigUtil.getInstance().saveAppConfig(this.dexa, strDexa);
                    }
                } else {
                    this.dexb.dexp = null;
                    DebugLog.init_weak(dexg.dexa("mdgh!mpbe!epof!"));
                    this.dexb.dexa(this.dexa, appConfigRespBean2);
                }
            } catch (Throwable th) {
                String str = dexg.dexa("mpdbm!dpogjh!mpbe!gbjm-") + Log.getStackTraceString(th);
                DebugLog.common_e(str);
                ReportUtils.exReport(this.dexb.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), str);
            }
        }
    }

    @Keep
    public class dexc implements HttpNetUtils.ICommonListener {
        public final Context dexa;
        public final WMAdSdk dexb;

        public dexc(WMAdSdk wMAdSdk, Context context) {
            this.dexb = wMAdSdk;
            this.dexa = context;
        }

        @Override // com.kc.bw.appsdkdex.utils.HttpNetUtils.ICommonListener
        public void onFailed(String str) {
            this.dexb.dexa(str);
        }

        @Override // com.kc.bw.appsdkdex.utils.HttpNetUtils.ICommonListener
        public void onSuccess() {
            DebugLog.init_weak(dexg.dexa("gfudi!dgh!epof!"));
            if (!WMAdSdk.dexq) {
                boolean unused = WMAdSdk.dexq = true;
            }
            this.dexb.dexn = true;
            this.dexb.dexa(this.dexa);
            this.dexb.dexe();
        }
    }

    @Keep
    public class dexd implements Runnable {
        public final Context dexa;
        public final WMAdSdk dexb;

        public dexd(WMAdSdk wMAdSdk, Context context) {
            this.dexb = wMAdSdk;
            this.dexa = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dexb.dexb(this.dexa);
        }
    }

    @Keep
    public class dexe extends ByteCallback {
        public final Context dexa;
        public final WMAdSdk dexb;

        public dexe(WMAdSdk wMAdSdk, Context context) {
            this.dexb = wMAdSdk;
            this.dexa = context;
        }

        @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            String str;
            super.onError(response);
            if (response != null) {
                str = response.code() + dexg.dexa(c49.f40900a) + response.getException().toString();
            } else {
                str = null;
            }
            DebugLog.common_w(dexg.dexa("sumg!") + str);
        }

        @Override // com.kc.bw.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            try {
                DebugLog.init_weak(dexg.dexa("usbdl!sftq!poTvddftt;") + GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken(), dexg.dexa("sfqpsuUsbdlJogp"))));
            } catch (Throwable th) {
                DebugLog.common_w(dexg.dexa("usbdl!sftq!fssps-") + th);
                ReportUtils.exReport(this.dexa, 999960, dexg.dexa("栌胺疱环幋狦楅葇楲鵦"), dexg.dexa("幋狦栌胺疱环攎滕騤矑楲鵦-") + th);
            }
        }
    }

    public WMAdSdk(Context context, Builder builder) {
        Context applicationContext;
        this.dexo = false;
        if (context == null) {
            DebugLog.common_w(dexg.dexa("dpoufyu!jt!ovmm"));
            applicationContext = WMDexAdHelper.gapc();
        } else {
            applicationContext = context.getApplicationContext();
        }
        this.dexa = applicationContext;
        if (this.dexa == null) {
            DebugLog.common_e(dexg.dexa("nBqqDpoufyu!jt!ovmm"));
        }
        this.dexb = builder.dexa;
        this.dexc = builder.dexb;
        this.dexd = builder.dexc;
        this.dexe = builder.dexd;
        this.dexg = builder.dexe;
        this.dexh = builder.dexf;
        this.dexi = builder.dexg;
        this.dexf = builder.dexh;
        this.dexk = builder.dexj;
        this.dexj = builder.dexi;
    }

    public /* synthetic */ WMAdSdk(Context context, Builder builder, dexa dexaVar) {
        this(context, builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:61:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String dexa(Context context, String str) {
        Object th;
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        String str2;
        if (TextUtils.isEmpty(str)) {
            DebugLog.common_w(dexg.dexa("nfejb!dgh!jowbmje!"));
            return null;
        }
        try {
            DebugLog.common_d(dexg.dexa("nfejb!dghObnf>") + str);
            inputStreamOpen = context.getAssets().open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen), 4096);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = new JSONObject(sb.toString()).getString(dexg.dexa("nfttbhf"));
                    if (!TextUtils.isEmpty(string)) {
                        String strDecrypt = AesUtil.decrypt(string, ConstantInfo.getAppToken(), dexg.dexa("hfuBttfutMpdbmDpogjh"));
                        DebugLog.init_weak(dexg.dexa("nfejb!dgh!mpbe!epof!"));
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                        return strDecrypt;
                    }
                    str2 = dexg.dexa(o61.h) + str + dexg.dexa("^") + dexg.dexa("ꆎ辯痈強瘡疉");
                    DebugLog.common_w(str2);
                    ReportUtils.exReport(this.dexa, 200018, dexg.dexa("TEL扞樌捗櫓徔ꆎ辯拡龾楲鵦"), str2);
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException unused3) {
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                    DebugLog.common_w(str2);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        str2 = dexg.dexa(o61.h) + str + dexg.dexa("^") + dexg.dexa("ꆎ辯痈強鰼搗楲鵦�鰸礁砦bttfut蜯澖幌ꆎ辯痈強癰摧殙杩") + dexg.dexa("-fssps>") + th;
                        DebugLog.common_w(str2);
                        ReportUtils.exReport(this.dexa, 200018, dexg.dexa("TEL扞樌捗櫓徔ꆎ辯拡龾楲鵦"), str2);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (bufferedReader != null) {
                        }
                        DebugLog.common_w(str2);
                        return null;
                    } catch (Throwable th3) {
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (bufferedReader == null) {
                            throw th3;
                        }
                        try {
                            bufferedReader.close();
                            throw th3;
                        } catch (IOException unused7) {
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                str2 = dexg.dexa(o61.h) + str + dexg.dexa("^") + dexg.dexa("ꆎ辯痈強鰼搗楲鵦�鰸礁砦bttfut蜯澖幌ꆎ辯痈強癰摧殙杩") + dexg.dexa("-fssps>") + th;
                DebugLog.common_w(str2);
                ReportUtils.exReport(this.dexa, 200018, dexg.dexa("TEL扞樌捗櫓徔ꆎ辯拡龾楲鵦"), str2);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                DebugLog.common_w(str2);
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamOpen = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(Context context) {
        try {
            if (this.dexo) {
                DebugLog.init_weak(dexg.dexa("dgh!wbmje-fyq!") + dexr + dexg.dexa("-dgh!") + dexq);
                if (!dexr || !dexq) {
                    return;
                }
            } else {
                DebugLog.init_weak(dexg.dexa("dgh!jowbmje-fyq!") + dexr);
                if (!dexr) {
                    return;
                }
            }
            dexc();
        } catch (Throwable th) {
            String str = dexg.dexa("dbmmcbdlTvddftt!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            ReportUtils.exReport(this.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(Context context, AppConfigRespBean appConfigRespBean) {
        try {
            if (!TextUtils.isEmpty(appConfigRespBean.getRealmName())) {
                DebugLog.common_weak(dexg.dexa("vqebuf!bqj!dbdif"));
                ConstantInfo.updateRealNameUrl(appConfigRespBean.getRealmName());
            }
            if (!TextUtils.isEmpty(appConfigRespBean.getTrackHost())) {
                DebugLog.common_weak(dexg.dexa("vqebuf!usbdl!dbdif"));
                ConstantInfo.updateTrackHostUrl(appConfigRespBean.getTrackHost());
            }
            Appconfig appConfig = appConfigRespBean.getAppConfig();
            if (appConfig != null) {
                AppConfigUtil.updateAppConfig(appConfig);
            }
            if (!dexq) {
                dexq = true;
            }
            this.dexm = true;
            dexa(context);
        } catch (Throwable th) {
            String str = dexg.dexa("vqebuf!wbsjbcmf!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_w(str);
            ReportUtils.exReport(this.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    public static /* synthetic */ void dexa(SdkMediationAppResp sdkMediationAppResp) {
        if (sdkMediationAppResp == null || !AppInstUtil.isNeedScanFullInst()) {
            return;
        }
        AppInstUtil.startSyncFullInstScan(sdkMediationAppResp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(String str) {
        try {
            DebugLog.common_e(dexg.dexa("dbmmcbdlGbjm-") + str);
            if (dexs) {
                return;
            }
            dext = SdkStatus.INITIALIZATION_FAILED;
            dexs = true;
            IInitCallback iInitCallback = this.dexl;
            if (iInitCallback != null) {
                iInitCallback.onFail(str);
            }
            dexm();
        } catch (Throwable th) {
            DebugLog.common_e(dexg.dexa("dbmmcbdlGbjm!gbjm-") + Log.getStackTraceString(th));
        }
    }

    private boolean dexa(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "Uplfo!jt!ovmm-!qmfbtf!difdl!XNBeTel/Cvjmefs)*/tfuUplfo)uplfo*!gvodujpo!xifuifs!ps!opu!up!tfu\"";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                return true;
            }
            str3 = "Lfz!jt!ovmm-!qmfbtf!difdl!XNBeTel/Cvjmefs)*/tfuLfz)lfz*!gvodujpo!xifuifs!ps!opu!up!tfu\"";
        }
        String strDexa = dexg.dexa(str3);
        dexa(strDexa);
        ReportUtils.exReport(this.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), strDexa);
        return false;
    }

    private void dexb() {
        try {
            DebugLog.common_all(dexg.dexa("joju!epof"));
            IInitCallback iInitCallback = this.dexl;
            if (iInitCallback != null) {
                iInitCallback.onSuccess();
            } else {
                String strDexa = dexg.dexa("dbmmcbdlJojuEpofTvddftt!gbjm-jojuDbmmcbdl!jt!ovmm");
                DebugLog.common_e(strDexa);
                ReportUtils.exReport(this.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), strDexa);
            }
            dexm();
        } catch (Throwable th) {
            String str = dexg.dexa("dbmmcbdlJojuEpofTvddftt!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            ReportUtils.exReport(this.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dexb(Context context) {
        try {
            ConcurrentHashMap<String, SdkTrackEventBean> sdkTrackReportBeanMap = SDKTrackUtils.getInstance().getSdkTrackReportBeanMap(context);
            if (sdkTrackReportBeanMap == null || sdkTrackReportBeanMap.isEmpty()) {
                return;
            }
            SDKTrackUtils.getInstance().cleanSdkTrackReportBean(context);
            ArrayList arrayList = new ArrayList();
            for (SdkTrackEventBean sdkTrackEventBean : sdkTrackReportBeanMap.values()) {
                sdkTrackEventBean.setRequest_time(System.currentTimeMillis());
                arrayList.add(sdkTrackEventBean);
            }
            SdkTrackEventBeans sdkTrackEventBeans = new SdkTrackEventBeans();
            sdkTrackEventBeans.setSdk_track_event(arrayList);
            String json = GsonUtils.getInstance().toJson(sdkTrackEventBeans);
            ((PostRequest) OkHttp.post(ConstantInfo.getTrackHostUrl() + dexg.dexa("tel0usbdlfwfou/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, dexg.dexa("vug.9")), ConstantInfo.getAppToken())).retryCount(2)).execute(new dexe(this, context));
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("sumg!") + th);
            ReportUtils.exReport(this.dexa, 999960, dexg.dexa("栌胺疱环幋狦楅葇楲鵦"), dexg.dexa("sfqpsuUsbdlJogp!gbjm!") + th);
        }
    }

    private void dexb(String str) {
        String strDexa;
        try {
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(this.dexa);
            String preferencesString = sharedPreferencesHelper.getPreferencesString(dexg.dexa("nn`tq`l41"));
            String strMd5Decode = AesUtil.md5Decode(str);
            if (TextUtils.isEmpty(preferencesString)) {
                DebugLog.init_weak(dexg.dexa("mUplfo!jt!ovmm-dmfbs'tbwf"));
                sharedPreferencesHelper.clearAllPreferences();
                strDexa = dexg.dexa("nn`tq`l41");
            } else {
                if (strMd5Decode.equals(preferencesString)) {
                    DebugLog.init_weak(dexg.dexa("dpogjh!bwbjmbcmf"));
                    String preferencesString2 = SharedPreferencesHelper.getInstance(this.dexa).getPreferencesString(dexg.dexa("nn`tq`l2"));
                    this.dexp = preferencesString2;
                    this.dexo = !TextUtils.isEmpty(preferencesString2);
                    return;
                }
                DebugLog.init_weak(dexg.dexa("dpogjh!fyqjsfe-dmfbs'tbwf"));
                sharedPreferencesHelper.clearAllPreferences();
                strDexa = dexg.dexa("nn`tq`l41");
            }
            sharedPreferencesHelper.savePreferencesString(strDexa, strMd5Decode);
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("difdlMpdbmDpogjh!gbjm!") + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexb(boolean z) {
        dexr = z;
        if (z) {
            dexa(this.dexa);
            dexl.dexb(this.dexa, ConstantInfo.getAppToken(), ConstantInfo.getAppKey());
        }
    }

    private void dexc() {
        dext = SdkStatus.INITIALIZED;
        if (dexs) {
            return;
        }
        int i = 1;
        dexs = true;
        ConstantInfo.sdkInitEndTime = Utils.getElapsedRealTime();
        if (this.dexm) {
            ConstantInfo.sdkInitConfigType = i;
        } else if (this.dexn) {
            i = 2;
            ConstantInfo.sdkInitConfigType = i;
        }
        ConstantInfo.sdkInitCostTime = ConstantInfo.sdkInitEndTime - ConstantInfo.sdkInitStartTime;
        DebugLog.init_weak(dexg.dexa("joju!epof!") + ConstantInfo.sdkInitEndTime + dexg.dexa("-d!") + ConstantInfo.sdkInitCostTime + dexg.dexa("-u!") + ConstantInfo.sdkInitConfigType);
        IInitCallback iInitCallback = this.dexl;
        if (iInitCallback != null) {
            iInitCallback.onSuccess();
        } else {
            String strDexa = dexg.dexa("dbmmcbdlTvddftt!gbjm-jojuDbmmcbdl!jt!ovmm");
            DebugLog.common_e(strDexa);
            ReportUtils.exReport(this.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), strDexa);
        }
        dexm();
        dexp.dexa(this.dexa);
        dexg(this.dexa);
    }

    private void dexc(Context context) {
        ThreadUtils.runOnThreadPool(new dexb(this, context));
    }

    private void dexd() {
        synchronized (this) {
            if (dexr) {
                DebugLog.loadPlugin(dexg.dexa("sft!sfbez"));
            } else {
                dexl.dexa(this.dexa, new dexl.dexc(this) { // from class: com.kc.bw.appsdkdex.WMAdSdk$$ExternalSyntheticLambda2
                    public final WMAdSdk f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // com.kc.bw.dexl.dexc
                    public final void dexa(boolean z) {
                        this.f$0.dexb(z);
                    }
                });
            }
        }
    }

    private void dexd(Context context) {
        DebugLog.init_weak(dexg.dexa("gfudi!dgh!"));
        HttpNetUtils.getInstance().fetchAppConfig(context, new dexc(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexe() {
        HttpNetUtils.getInstance().fetchAppConfigV2(new HasTypeRunnable() { // from class: com.kc.bw.appsdkdex.WMAdSdk$$ExternalSyntheticLambda1
            @Override // com.kc.bw.common.runnable.HasTypeRunnable
            public final void run(Object obj) {
                WMAdSdk.dexa((SdkMediationAppResp) obj);
            }
        });
    }

    private void dexe(Context context) {
        dexc(context);
        dexd(context);
    }

    private void dexf() {
        AppInstUtil.initFullInst();
    }

    private boolean dexf(Context context) {
        String processName = Utils.getProcessName(context);
        if (TextUtils.isEmpty(processName) || context.getPackageName().equals(processName)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(dexg.dexa("TEL幎異獂杩殑���詌幮扞樌捗;"));
        sb.append(dexg.dexa("qspdfttObnf>"));
        sb.append(processName);
        dexa(sb.toString());
        ReportUtils.exReport(this.dexa, 200006, dexg.dexa("TEL扞樌捗楲鵦"), sb.toString());
        return false;
    }

    private void dexg() {
        try {
            long elapsedRealTime = Utils.getElapsedRealTime();
            DebugLog.init_weak(dexg.dexa("joju!ofuxpsl"));
            String strDexa = dexg.dexa("8/25/21");
            String strDexb = dexl.dexb(this.dexa);
            if (!TextUtils.isEmpty(strDexb)) {
                String strDexa2 = dexl.dexa(strDexa, strDexb);
                if (strDexa2.equals(strDexb)) {
                    DebugLog.init_weak(dexg.dexa("n.w!") + strDexa2);
                    strDexa = strDexa2;
                } else {
                    DebugLog.init_weak(dexg.dexa("c.w!") + strDexa);
                }
            }
            DebugLog.init_weak(dexg.dexa("v.w!") + strDexa + dexg.dexa("-d!") + Utils.getCostTime(elapsedRealTime));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.put(dexg.dexa("Vtfs.BqqUplfo"), ConstantInfo.getAppToken());
            httpHeaders.put(dexg.dexa("Vtfs.Wfstjpo"), dexg.dexa("8/8/25/21"));
            httpHeaders.put(dexg.dexa("Vtfs.KbsWfstjpo"), strDexa);
            httpHeaders.put(dexg.dexa("Vtfs.Bhfou"), Utils.getUserAgent(this.dexa));
            OkHttp.getInstance().init(this.dexa, this.dexb).setRetryCount(0).setGlobalDefaultHeadersV2(httpHeaders);
            DebugLog.init_weak(dexg.dexa("ofuxpsl!d!") + Utils.getCostTime(elapsedRealTime));
        } catch (Throwable th) {
            DebugLog.common_e(dexg.dexa("joju!ofuxpsl!gbjm!") + Log.getStackTraceString(th));
        }
    }

    private void dexg(Context context) {
        int iNextInt = new Random().nextInt(100);
        DebugLog.init_weak(dexg.dexa("sfqpsu!fwfout!") + iNextInt + dexg.dexa(Consts.DOT) + ConstantInfo.Config.trackEventRatio);
        if (iNextInt <= ConstantInfo.Config.trackEventRatio) {
            if (ThreadUtils.isUIThread(dexg.dexa("sfqpsuUsbdlJogp"))) {
                ThreadUtils.runOnThreadPool(new dexd(this, context));
            } else {
                dexb(context);
            }
        }
    }

    private void dexh() {
        try {
            ConstantInfo.deviceFingerprint = DeviceUtils.getDeviceFingerprint();
            ConstantInfo.bootMark = DeviceUtils.getBootMark();
            ConstantInfo.updateMark = DeviceUtils.getUpdateMark();
            String preferencesString = SharedPreferencesHelper.getInstance(this.dexa).getPreferencesString(dexg.dexa("nn`tq`l4"), "");
            if (TextUtils.isEmpty(preferencesString)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(AesUtil.md5Decode(ConstantInfo.deviceFingerprint));
                stringBuffer.append(dexg.dexa(Consts.DOT));
                stringBuffer.append(AesUtil.md5Decode(ConstantInfo.bootMark));
                preferencesString = stringBuffer.toString();
                SharedPreferencesHelper.getInstance(this.dexa).savePreferencesString(dexg.dexa("nn`tq`l4"), preferencesString);
            }
            ConstantInfo.wmId = preferencesString;
        } catch (Throwable th) {
            String str = dexg.dexa("xnJe!cvjme!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            ReportUtils.exReport(this.dexa, 200016, dexg.dexa("TEL扞樌捗瘻酊JE蕠牑楲鵦"), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexi() {
        dexg();
        if (dexa(this.dexb, this.dexc) && dexf(this.dexa)) {
            ConstantInfo.sdkInitStartTime = Utils.getElapsedRealTime();
            dexk();
            dexb(this.dexb);
            DebugLog.common_all(dexg.dexa("nn!tel!joju!tubsu!8/8/25/21"));
            dexh();
            dexd();
            dexl();
            dexf();
            dexe(this.dexa);
            ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
        }
    }

    private void dexj() {
        if (dexm.dexb) {
            return;
        }
        DebugLog.init_weak(dexg.dexa("sfhjtufs!mjgfdzdmf"));
        try {
            dexm.dexa(this.dexa);
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("mjgfdzdmf!sfhjtufs!gbjm!") + Log.getStackTraceString(th));
        }
    }

    private void dexk() {
        if (this.dexe) {
            DebugLog.init_weak(dexg.dexa("sfh!dsbti!"));
            try {
                CrashHandler.getInstance().init(this.dexa);
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.common_w(dexg.dexa("sfh!dsbti!gbjm!") + stackTraceString);
                ReportUtils.exReport(this.dexa, 200013, dexg.dexa("TEL扞樌捗紩懍潃湹楅葇楲鵦"), stackTraceString);
            }
        }
    }

    private void dexl() {
        if (this.dexh) {
            DebugLog.init_weak(dexg.dexa("sfh!ijeefo!"));
            ThreadUtils.runOnThreadPool(new dexa(this));
        }
    }

    private void dexm() {
        DebugLog.init_weak(dexg.dexa("sfnpwf!dbmmcbdl"));
        this.dexl = null;
        this.dexk = null;
    }

    private void dexn() {
        DebugLog.common_all(dexg.dexa("efcvh!") + this.dexf);
        ConstantInfo.setAppToken(this.dexb);
        ConstantInfo.setAppKey(this.dexc);
        ConstantInfo.setWxAppId(this.dexd);
        ConstantInfo.setDebug(this.dexf);
        ConstantInfo.setEnablePersonalized(this.dexg);
        ConstantInfo.setEnableSensor(this.dexi);
        DebugLog.common_d(dexg.dexa("lfz>") + this.dexc);
        DebugLog.common_d(dexg.dexa("uplfo>") + this.dexb);
        DebugLog.common_d(dexg.dexa("tfotps>") + this.dexi);
        DebugLog.common_d(dexg.dexa("qfstpobmj{fe>") + this.dexg);
        WMCustomPrivateController wMCustomPrivateController = this.dexk;
        if (wMCustomPrivateController != null) {
            ConstantInfo.setCanUseLocation(wMCustomPrivateController.isCanUseLocation());
            ConstantInfo.setDevWMLocation(this.dexk.getLocation());
            ConstantInfo.setCanUsePhoneState(this.dexk.isCanUsePhoneState());
            ConstantInfo.setDevImei(this.dexk.getDevImei());
            ConstantInfo.setCanUseOaid(this.dexk.isCanUseOaid());
            ConstantInfo.setCanUseBootId(this.dexk.isCanUseBootId());
            ConstantInfo.setDevOaid(this.dexk.getDevOaid());
            ConstantInfo.setCanUseWifiState(this.dexk.isCanUseWifiState());
            ConstantInfo.setDevMacAddress(this.dexk.getDevMacAddress());
            ConstantInfo.setCanUseNetworkState(this.dexk.isCanUseNetworkState());
            ConstantInfo.setCanUseWriteExternal(this.dexk.isCanUseWriteExternal());
            ConstantInfo.setCanUseAppList(this.dexk.isCanUseAppList());
            ConstantInfo.setCanUsePermissionRecordAudio(this.dexk.isCanUsePermissionRecordAudio());
            ConstantInfo.setCanUseInstallPackages(this.dexk.isCanUseInstallPackages());
        }
    }

    public static SdkStatus getSdkStatus() {
        return dext;
    }

    public static String getSdkVersion() {
        return dexg.dexa("8/8/25/21");
    }

    public void init(IInitCallback iInitCallback) {
        DebugLog.common_all(dexg.dexa("tel!tubsu!joju"));
        this.dexl = iInitCallback;
        if (this.dexa == null) {
            dexa(dexg.dexa("nBqqDpoufyu!jt!ovmm-!Qmfbtf!difdl!XNBeTel/Cvjmefs)*/cvjme)dpoufyu*!gvodujpo!xifuifs!ps!opu!up!tfu\""));
            return;
        }
        dexn();
        if (dext == SdkStatus.INITIALIZED) {
            DebugLog.common_all(dexg.dexa("nn!tel!ibt!jojujbmj{fe\""));
            dexb();
            return;
        }
        SdkStatus sdkStatus = dext;
        SdkStatus sdkStatus2 = SdkStatus.INITIALIZING;
        if (sdkStatus == sdkStatus2) {
            DebugLog.common_all(dexg.dexa("nn!tel!jt!jojujbmj{joh-qmfbtf!xbju!gps!b!npnfou"));
            dexm();
            return;
        }
        dext = sdkStatus2;
        dexs = false;
        ContextContainer.init(this.dexa);
        dexj();
        ThreadUtils.runOnThreadPool(new Runnable(this) { // from class: com.kc.bw.appsdkdex.WMAdSdk$$ExternalSyntheticLambda0
            public final WMAdSdk f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.dexi();
            }
        });
    }
}
