package cj.mobile.wm.appsdkdex;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.appsdkdex.WMAdSdk;
import cj.mobile.wm.appsdkdex.utils.AppInstUtil;
import cj.mobile.wm.appsdkdex.utils.HttpNetUtils;
import cj.mobile.wm.common.bean.AppConfigRespBean;
import cj.mobile.wm.common.bean.Appconfig;
import cj.mobile.wm.common.bean.SdkMediationAppResp;
import cj.mobile.wm.common.bean.SdkTrackEventBean;
import cj.mobile.wm.common.bean.SdkTrackEventBeans;
import cj.mobile.wm.common.runnable.HasTypeRunnable;
import cj.mobile.wm.common.utils.AppConfigUtil;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.ContextContainer;
import cj.mobile.wm.common.utils.CrashHandler;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.DeviceUtils;
import cj.mobile.wm.common.utils.GsonUtils;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.common.utils.SDKTrackUtils;
import cj.mobile.wm.common.utils.SharedPreferencesHelper;
import cj.mobile.wm.common.utils.ThreadUtils;
import cj.mobile.wm.common.utils.Utils;
import cj.mobile.wm.dexh;
import cj.mobile.wm.dexi;
import cj.mobile.wm.dexl;
import cj.mobile.wm.hiddenapibypass.HiddenApiBypass;
import cj.mobile.wm.okhttp.OkHttp;
import cj.mobile.wm.okhttp.callback.ByteCallback;
import cj.mobile.wm.okhttp.model.HttpHeaders;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.request.PostRequest;
import cj.mobile.wm.okhttp.utils.AesUtil;
import cj.mobile.wm.okhttp.utils.GZIPUtils;
import com.alibaba.android.arouter.utils.Consts;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMAdSdk {
    public static volatile boolean dexq = false;
    public static volatile boolean dexr = false;
    public static volatile boolean dexs = false;
    public static volatile SdkStatus dext = SdkStatus.NOT_INITIALIZED;
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
    public volatile boolean dexm;
    public volatile boolean dexn;
    public volatile boolean dexo;
    public String dexp;

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

    public interface IInitCallback {
        void onFail(String str);

        void onSuccess();
    }

    public class dexa implements Runnable {
        public dexa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealTime = Utils.getElapsedRealTime();
                HiddenApiBypass.setHiddenApiExemptions("");
                DebugLog.init_weak(cj.mobile.wm.dexc.dexa("sfh!ijeefo!") + Utils.getCostTime(elapsedRealTime));
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.common_w(cj.mobile.wm.dexc.dexa("sfh!ijeefo!gbjm!") + stackTraceString);
                ReportUtils.exReport(WMAdSdk.this.dexa, 200012, cj.mobile.wm.dexc.dexa("TEL扞樌捗紩懍ꛑ阐BQJ鲂憎楲鵦"), stackTraceString);
            }
        }
    }

    public class dexb implements HttpNetUtils.ICommonListener {
        public final /* synthetic */ Context dexa;

        public dexb(Context context) {
            this.dexa = context;
        }

        @Override // cj.mobile.wm.appsdkdex.utils.HttpNetUtils.ICommonListener
        public void onFailed(String str) {
            WMAdSdk.this.dexa(str);
        }

        @Override // cj.mobile.wm.appsdkdex.utils.HttpNetUtils.ICommonListener
        public void onSuccess() {
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("gfudi!dgh!epof!"));
            if (!WMAdSdk.dexq) {
                boolean unused = WMAdSdk.dexq = true;
            }
            WMAdSdk.this.dexn = true;
            WMAdSdk.this.dexa(this.dexa);
            WMAdSdk.this.dexg();
        }
    }

    public class dexc implements Runnable {
        public final /* synthetic */ Context dexa;

        public dexc(Context context) {
            this.dexa = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            WMAdSdk.this.dexb(this.dexa);
        }
    }

    public class dexd extends ByteCallback {
        public final /* synthetic */ Context dexa;

        public dexd(Context context) {
            this.dexa = context;
        }

        @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            String str;
            super.onError(response);
            if (response != null) {
                str = response.code() + cj.mobile.wm.dexc.dexa(c49.f40900a) + response.getException().toString();
            } else {
                str = null;
            }
            DebugLog.common_w(cj.mobile.wm.dexc.dexa("sumg!") + str);
        }

        @Override // cj.mobile.wm.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            try {
                DebugLog.init_weak(cj.mobile.wm.dexc.dexa("usbdl!sftq!poTvddftt;") + GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken(), cj.mobile.wm.dexc.dexa("sfqpsuUsbdlJogp"))));
            } catch (Throwable th) {
                DebugLog.common_w(cj.mobile.wm.dexc.dexa("usbdl!sftq!fssps-") + th);
                ReportUtils.exReport(this.dexa, 999960, cj.mobile.wm.dexc.dexa("栌胺疱环幋狦楅葇楲鵦"), cj.mobile.wm.dexc.dexa("幋狦栌胺疱环攎滕騤矑楲鵦-") + th);
            }
        }
    }

    public /* synthetic */ WMAdSdk(Context context, Builder builder, dexa dexaVar) {
        this(context, builder);
    }

    private void dexc() {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.ys9
            @Override // java.lang.Runnable
            public final void run() {
                this.f46109a.dexk();
            }
        });
    }

    private void dexd() {
        try {
            DebugLog.common_all(cj.mobile.wm.dexc.dexa("joju!epof"));
            IInitCallback iInitCallback = this.dexl;
            if (iInitCallback != null) {
                iInitCallback.onSuccess();
            } else {
                String strDexa = cj.mobile.wm.dexc.dexa("dbmmcbdlJojuEpofTvddftt!gbjm-jojuDbmmcbdl!jt!ovmm");
                DebugLog.common_e(strDexa);
                ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), strDexa);
            }
            dexp();
        } catch (Throwable th) {
            String str = cj.mobile.wm.dexc.dexa("dbmmcbdlJojuEpofTvddftt!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    private void dexe() {
        dext = SdkStatus.INITIALIZED;
        if (dexs) {
            return;
        }
        dexs = true;
        ConstantInfo.sdkInitEndTime = Utils.getElapsedRealTime();
        if (this.dexm) {
            ConstantInfo.sdkInitConfigType = 1;
        } else if (this.dexn) {
            ConstantInfo.sdkInitConfigType = 2;
        }
        ConstantInfo.sdkInitCostTime = ConstantInfo.sdkInitEndTime - ConstantInfo.sdkInitStartTime;
        DebugLog.init_weak(cj.mobile.wm.dexc.dexa("joju!epof!") + ConstantInfo.sdkInitEndTime + cj.mobile.wm.dexc.dexa("-du!") + ConstantInfo.sdkInitCostTime + cj.mobile.wm.dexc.dexa("-u!") + ConstantInfo.sdkInitConfigType);
        IInitCallback iInitCallback = this.dexl;
        if (iInitCallback != null) {
            iInitCallback.onSuccess();
        } else {
            String strDexa = cj.mobile.wm.dexc.dexa("dbmmcbdlTvddftt!gbjm-jojuDbmmcbdl!jt!ovmm");
            DebugLog.common_e(strDexa);
            ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), strDexa);
        }
        dexp();
        dexl.dexa(this.dexa);
        dexg(this.dexa);
    }

    private synchronized void dexf() {
        if (dexr) {
            DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!sfbez"));
        } else {
            dexr = dexh.dexa(this.dexa);
            if (dexr) {
                dexa(this.dexa);
                dexc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexg() {
        HttpNetUtils.getInstance().fetchAppConfigV2(new HasTypeRunnable() { // from class: com.zj.adlib.at9
            @Override // cj.mobile.wm.common.runnable.HasTypeRunnable
            public final void run(Object obj) {
                WMAdSdk.dexa((SdkMediationAppResp) obj);
            }
        });
    }

    private void dexh() {
        AppInstUtil.initFullInst();
    }

    private void dexi() {
        try {
            long elapsedRealTime = Utils.getElapsedRealTime();
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("joju!ofuxpsl"));
            String strDexa = cj.mobile.wm.dexc.dexa("8/29/31");
            String strDexc = dexh.dexc(this.dexa);
            if (!TextUtils.isEmpty(strDexc)) {
                String strDexa2 = dexh.dexa(strDexa, strDexc);
                if (strDexa2.equals(strDexc)) {
                    DebugLog.init_weak(cj.mobile.wm.dexc.dexa("n.w!") + strDexa2);
                    strDexa = strDexa2;
                } else {
                    DebugLog.init_weak(cj.mobile.wm.dexc.dexa("c.w!") + strDexa);
                }
            }
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("v.w!") + strDexa + " " + Utils.getCostTime(elapsedRealTime));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.put(cj.mobile.wm.dexc.dexa("Vtfs.BqqUplfo"), ConstantInfo.getAppToken());
            httpHeaders.put(cj.mobile.wm.dexc.dexa("Vtfs.Wfstjpo"), cj.mobile.wm.dexc.dexa("8/:/29/31"));
            httpHeaders.put(cj.mobile.wm.dexc.dexa("Vtfs.KbsWfstjpo"), strDexa);
            httpHeaders.put(cj.mobile.wm.dexc.dexa("Vtfs.Bhfou"), Utils.getUserAgent(this.dexa));
            OkHttp.getInstance().init(this.dexa, this.dexb).setRetryCount(0).setGlobalDefaultHeadersV2(httpHeaders);
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("ofuxpsl!d!") + Utils.getCostTime(elapsedRealTime));
        } catch (Throwable th) {
            DebugLog.common_e(cj.mobile.wm.dexc.dexa("joju!ofuxpsl!gbjm!") + Log.getStackTraceString(th));
        }
    }

    private void dexj() {
        try {
            long elapsedRealTime = Utils.getElapsedRealTime();
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("joju!nnJe"));
            ConstantInfo.deviceFingerprint = DeviceUtils.getDeviceFingerprint();
            ConstantInfo.bootMark = DeviceUtils.getBootMark();
            ConstantInfo.updateMark = DeviceUtils.getUpdateMark();
            String preferencesString = SharedPreferencesHelper.getInstance(this.dexa).getPreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l4"), "");
            if (TextUtils.isEmpty(preferencesString)) {
                preferencesString = AesUtil.md5Decode(ConstantInfo.deviceFingerprint) + cj.mobile.wm.dexc.dexa(Consts.DOT) + AesUtil.md5Decode(ConstantInfo.bootMark);
                SharedPreferencesHelper.getInstance(this.dexa).savePreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l4"), preferencesString);
            }
            ConstantInfo.wmId = preferencesString;
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("joju!nnJe!") + Utils.getCostTime(elapsedRealTime));
        } catch (Throwable th) {
            String str = cj.mobile.wm.dexc.dexa("xnJe!cvjme!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            ReportUtils.exReport(this.dexa, 200016, cj.mobile.wm.dexc.dexa("TEL扞樌捗瘻酊JE蕠牑楲鵦"), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexk() {
        dexh.dexb(this.dexa, ConstantInfo.getAppToken(), ConstantInfo.getAppKey());
    }

    private void dexm() {
        if (dexi.dexb) {
            return;
        }
        DebugLog.init_weak(cj.mobile.wm.dexc.dexa("sfhjtufs!mjgfdzdmf"));
        try {
            dexi.dexa(this.dexa);
        } catch (Throwable th) {
            DebugLog.common_w(cj.mobile.wm.dexc.dexa("mjgfdzdmf!sfhjtufs!gbjm!") + Log.getStackTraceString(th));
        }
    }

    private void dexn() {
        if (this.dexe) {
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("sfh!dsbti!"));
            try {
                CrashHandler.getInstance().init(this.dexa);
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                DebugLog.common_w(cj.mobile.wm.dexc.dexa("sfh!dsbti!gbjm!") + stackTraceString);
                ReportUtils.exReport(this.dexa, 200013, cj.mobile.wm.dexc.dexa("TEL扞樌捗紩懍潃湹楅葇楲鵦"), stackTraceString);
            }
        }
    }

    private void dexo() {
        if (this.dexh) {
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("sfh!ijeefo!"));
            ThreadUtils.runOnThreadPool(new dexa());
        }
    }

    private void dexp() {
        DebugLog.init_weak(cj.mobile.wm.dexc.dexa("sfnpwf!dbmmcbdl"));
        this.dexl = null;
        this.dexk = null;
    }

    private void dexq() {
        DebugLog.common_all(cj.mobile.wm.dexc.dexa("efcvh!") + this.dexf);
        ConstantInfo.setAppToken(this.dexb);
        ConstantInfo.setAppKey(this.dexc);
        ConstantInfo.setWxAppId(this.dexd);
        ConstantInfo.setDebug(this.dexf);
        ConstantInfo.setEnablePersonalized(this.dexg);
        ConstantInfo.setEnableSensor(this.dexi);
        DebugLog.common_d(cj.mobile.wm.dexc.dexa("lfz>") + this.dexc);
        DebugLog.common_d(cj.mobile.wm.dexc.dexa("uplfo>") + this.dexb);
        DebugLog.common_d(cj.mobile.wm.dexc.dexa("tfotps>") + this.dexi);
        DebugLog.common_d(cj.mobile.wm.dexc.dexa("qfstpobmj{fe>") + this.dexg);
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
        return cj.mobile.wm.dexc.dexa("8/:/29/31");
    }

    public void init(IInitCallback iInitCallback) {
        DebugLog.common_all(cj.mobile.wm.dexc.dexa("tel!tubsu!joju!8/:/29/31"));
        this.dexl = iInitCallback;
        if (this.dexa == null) {
            dexa(cj.mobile.wm.dexc.dexa("nBqqDpoufyu!jt!ovmm-!Qmfbtf!difdl!XNBeTel/Cvjmefs)*/cvjme)dpoufyu*!gvodujpo!xifuifs!ps!opu!up!tfu\""));
            return;
        }
        dexq();
        if (dext == SdkStatus.INITIALIZED) {
            DebugLog.common_all(cj.mobile.wm.dexc.dexa("nn!tel!ibt!jojujbmj{fe\""));
            dexd();
            return;
        }
        SdkStatus sdkStatus = dext;
        SdkStatus sdkStatus2 = SdkStatus.INITIALIZING;
        if (sdkStatus == sdkStatus2) {
            DebugLog.common_all(cj.mobile.wm.dexc.dexa("nn!tel!jt!jojujbmj{joh-qmfbtf!xbju!gps!b!npnfou"));
            dexp();
            return;
        }
        ConstantInfo.sdkInitStartTime = Utils.getElapsedRealTime();
        dext = sdkStatus2;
        dexs = false;
        ContextContainer.init(this.dexa);
        dexm();
        if (ThreadUtils.isUIThread(cj.mobile.wm.dexc.dexa("joju"))) {
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.ws9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45682a.dexl();
                }
            });
        } else {
            dexl();
        }
    }

    public WMAdSdk(Context context, Builder builder) {
        this.dexo = false;
        if (context == null) {
            DebugLog.common_w(cj.mobile.wm.dexc.dexa("dpoufyu!jt!ovmm"));
            this.dexa = WMDexAdHelper.gapc();
        } else {
            this.dexa = context.getApplicationContext();
        }
        if (this.dexa == null) {
            DebugLog.common_e(cj.mobile.wm.dexc.dexa("nBqqDpoufyu!jt!ovmm"));
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

    private void dexc(Context context) {
        AppConfigRespBean appConfigRespBean;
        AppConfigRespBean appConfigRespBean2;
        try {
            long elapsedRealTime = Utils.getElapsedRealTime();
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("mpbe!mdgh!!"));
            if (TextUtils.isEmpty(this.dexp) || (appConfigRespBean2 = (AppConfigRespBean) GsonUtils.getInstance().fromJson(this.dexp, AppConfigRespBean.class)) == null) {
                DebugLog.init_weak(cj.mobile.wm.dexc.dexa("mdgh!jowbme"));
                String strDexa = dexa(context, this.dexj);
                if (!TextUtils.isEmpty(strDexa) && (appConfigRespBean = (AppConfigRespBean) GsonUtils.getInstance().fromJson(strDexa, AppConfigRespBean.class)) != null) {
                    DebugLog.init_weak(cj.mobile.wm.dexc.dexa("mdgh!mpbe!epof!") + Utils.getCostTime(elapsedRealTime));
                    dexa(context, appConfigRespBean);
                    AppConfigUtil.getInstance().saveAppConfig(context, strDexa);
                }
            } else {
                this.dexp = null;
                DebugLog.init_weak(cj.mobile.wm.dexc.dexa("mdgh!mpbe!epof!") + Utils.getCostTime(elapsedRealTime));
                dexa(context, appConfigRespBean2);
            }
        } catch (Throwable th) {
            String str = cj.mobile.wm.dexc.dexa("mpdbm!dpogjh!mpbe!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    private void dexg(Context context) {
        int iNextInt = new Random().nextInt(100);
        DebugLog.init_weak(cj.mobile.wm.dexc.dexa("sfqpsu!fwfout!") + iNextInt + cj.mobile.wm.dexc.dexa(Consts.DOT) + ConstantInfo.Config.trackEventRatio);
        if (iNextInt <= ConstantInfo.Config.trackEventRatio) {
            if (ThreadUtils.isUIThread(cj.mobile.wm.dexc.dexa("sfqpsuUsbdlJogp"))) {
                ThreadUtils.runOnThreadPool(new dexc(context));
            } else {
                dexb(context);
            }
        }
    }

    private void dexb(String str) {
        try {
            long elapsedRealTime = Utils.getElapsedRealTime();
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("difdl!mdgh"));
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(this.dexa);
            String preferencesString = sharedPreferencesHelper.getPreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l41"));
            String strMd5Decode = AesUtil.md5Decode(str);
            if (!TextUtils.isEmpty(preferencesString)) {
                if (!strMd5Decode.equals(preferencesString)) {
                    DebugLog.init_weak(cj.mobile.wm.dexc.dexa("dpogjh!fyqjsfe-dmfbs'tbwf"));
                    sharedPreferencesHelper.clearAllPreferences();
                    sharedPreferencesHelper.savePreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l41"), strMd5Decode);
                } else {
                    DebugLog.init_weak(cj.mobile.wm.dexc.dexa("dpogjh!bwbjmbcmf"));
                    String preferencesString2 = SharedPreferencesHelper.getInstance(this.dexa).getPreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l2"));
                    this.dexp = preferencesString2;
                    this.dexo = !TextUtils.isEmpty(preferencesString2);
                }
            } else {
                DebugLog.init_weak(cj.mobile.wm.dexc.dexa("mUplfo!jt!ovmm-dmfbs'tbwf"));
                sharedPreferencesHelper.clearAllPreferences();
                sharedPreferencesHelper.savePreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l41"), strMd5Decode);
            }
            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("difdl!mdgh!") + Utils.getCostTime(elapsedRealTime));
        } catch (Throwable th) {
            DebugLog.common_w(cj.mobile.wm.dexc.dexa("difdlMpdbmDpogjh!gbjm!") + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public void dexl() {
        dexi();
        if (dexa(this.dexb, this.dexc) && dexf(this.dexa)) {
            dexb(this.dexb);
            dexj();
            dexf();
            dexe(this.dexa);
            dexn();
            dexo();
            dexh();
            ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
        }
    }

    private boolean dexf(Context context) {
        String processName = Utils.getProcessName(context);
        if (TextUtils.isEmpty(processName) || context.getPackageName().equals(processName)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(cj.mobile.wm.dexc.dexa("TEL幎異獂杩殑���詌幮扞樌捗;"));
        sb.append(cj.mobile.wm.dexc.dexa("qspdfttObnf>"));
        sb.append(processName);
        dexa(sb.toString());
        ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), sb.toString());
        return false;
    }

    private void dexd(Context context) {
        DebugLog.init_weak(cj.mobile.wm.dexc.dexa("gfudi!dgh!"));
        HttpNetUtils.getInstance().fetchAppConfig(context, new dexb(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(Context context) {
        try {
            if (this.dexo) {
                DebugLog.init_weak(cj.mobile.wm.dexc.dexa("dgh!wbmje-fyq!") + dexr + cj.mobile.wm.dexc.dexa("-dgh!") + dexq);
                if (dexr && dexq) {
                    dexe();
                }
            } else {
                DebugLog.init_weak(cj.mobile.wm.dexc.dexa("dgh!jowbmje-fyq!") + dexr);
                if (dexr) {
                    dexe();
                }
            }
        } catch (Throwable th) {
            String str = cj.mobile.wm.dexc.dexa("dbmmcbdlTvddftt!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_e(str);
            ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    private void dexe(Context context) {
        dexc(context);
        dexd(context);
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
            ((PostRequest) OkHttp.post(ConstantInfo.getTrackHostUrl() + cj.mobile.wm.dexc.dexa("tel0usbdlfwfou/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, cj.mobile.wm.dexc.dexa("vug.9")), ConstantInfo.getAppToken())).retryCount(2)).execute(new dexd(context));
        } catch (Throwable th) {
            DebugLog.common_w(cj.mobile.wm.dexc.dexa("sumg!") + th);
            ReportUtils.exReport(this.dexa, 999960, cj.mobile.wm.dexc.dexa("栌胺疱环幋狦楅葇楲鵦"), cj.mobile.wm.dexc.dexa("sfqpsuUsbdlJogp!gbjm!") + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(String str) {
        try {
            DebugLog.common_e(cj.mobile.wm.dexc.dexa("dbmmcbdlGbjm-") + str);
            if (dexs) {
                return;
            }
            dext = SdkStatus.INITIALIZATION_FAILED;
            dexs = true;
            IInitCallback iInitCallback = this.dexl;
            if (iInitCallback != null) {
                iInitCallback.onFail(str);
            }
            dexp();
        } catch (Throwable th) {
            DebugLog.common_e(cj.mobile.wm.dexc.dexa("dbmmcbdlGbjm!gbjm-") + Log.getStackTraceString(th));
        }
    }

    private void dexa(Context context, AppConfigRespBean appConfigRespBean) {
        try {
            if (!TextUtils.isEmpty(appConfigRespBean.getRealmName())) {
                DebugLog.common_weak(cj.mobile.wm.dexc.dexa("vqebuf!bqj!dbdif"));
                ConstantInfo.updateRealNameUrl(appConfigRespBean.getRealmName());
            }
            if (!TextUtils.isEmpty(appConfigRespBean.getTrackHost())) {
                DebugLog.common_weak(cj.mobile.wm.dexc.dexa("vqebuf!usbdl!dbdif"));
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
            String str = cj.mobile.wm.dexc.dexa("vqebuf!wbsjbcmf!gbjm-") + Log.getStackTraceString(th);
            DebugLog.common_w(str);
            ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), str);
        }
    }

    public static /* synthetic */ void dexa(SdkMediationAppResp sdkMediationAppResp) {
        if (sdkMediationAppResp == null || !AppInstUtil.isNeedScanFullInst()) {
            return;
        }
        AppInstUtil.startSyncFullInstScan(sdkMediationAppResp);
    }

    private boolean dexa(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            String strDexa = cj.mobile.wm.dexc.dexa("Uplfo!jt!ovmm-!qmfbtf!difdl!XNBeTel/Cvjmefs)*/tfuUplfo)uplfo*!gvodujpo!xifuifs!ps!opu!up!tfu\"");
            dexa(strDexa);
            ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), strDexa);
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        String strDexa2 = cj.mobile.wm.dexc.dexa("Lfz!jt!ovmm-!qmfbtf!difdl!XNBeTel/Cvjmefs)*/tfuLfz)lfz*!gvodujpo!xifuifs!ps!opu!up!tfu\"");
        dexa(strDexa2);
        ReportUtils.exReport(this.dexa, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), strDexa2);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0113 A[Catch: IOException -> 0x0116, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0116, blocks: (B:23:0x00c3, B:36:0x0113), top: B:57:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:62:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String dexa(Context context, String str) {
        Object th;
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        String str2;
        if (TextUtils.isEmpty(str)) {
            DebugLog.common_w(cj.mobile.wm.dexc.dexa("nfejb!dgh!jowbmje!"));
            return null;
        }
        try {
            try {
                DebugLog.common_d(cj.mobile.wm.dexc.dexa("nfejb!dghObnf>") + str);
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
                        String string = new JSONObject(sb.toString()).getString(cj.mobile.wm.dexc.dexa("nfttbhf"));
                        if (!TextUtils.isEmpty(string)) {
                            String strDecrypt = AesUtil.decrypt(string, ConstantInfo.getAppToken(), cj.mobile.wm.dexc.dexa("hfuBttfutMpdbmDpogjh"));
                            DebugLog.init_weak(cj.mobile.wm.dexc.dexa("nfejb!dgh!mpbe!epof!"));
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
                        str2 = cj.mobile.wm.dexc.dexa(o61.h) + str + cj.mobile.wm.dexc.dexa("^") + cj.mobile.wm.dexc.dexa("ꆎ辯痈強瘡疉");
                        DebugLog.common_w(str2);
                        ReportUtils.exReport(this.dexa, 200018, cj.mobile.wm.dexc.dexa("TEL扞樌捗櫓徔ꆎ辯拡龾楲鵦"), str2);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused3) {
                            }
                        }
                        bufferedReader.close();
                        DebugLog.common_w(str2);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            str2 = cj.mobile.wm.dexc.dexa(o61.h) + str + cj.mobile.wm.dexc.dexa("^") + cj.mobile.wm.dexc.dexa("ꆎ辯痈強鰼搗楲鵦�鰸礁砦bttfut蜯澖幌ꆎ辯痈強癰摧殙杩") + cj.mobile.wm.dexc.dexa("-fssps>") + th;
                            DebugLog.common_w(str2);
                            ReportUtils.exReport(this.dexa, 200018, cj.mobile.wm.dexc.dexa("TEL扞樌捗櫓徔ꆎ辯拡龾楲鵦"), str2);
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            DebugLog.common_w(str2);
                            return null;
                        } catch (Throwable th3) {
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    throw th3;
                                } catch (IOException unused6) {
                                    throw th3;
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    str2 = cj.mobile.wm.dexc.dexa(o61.h) + str + cj.mobile.wm.dexc.dexa("^") + cj.mobile.wm.dexc.dexa("ꆎ辯痈強鰼搗楲鵦�鰸礁砦bttfut蜯澖幌ꆎ辯痈強癰摧殙杩") + cj.mobile.wm.dexc.dexa("-fssps>") + th;
                    DebugLog.common_w(str2);
                    ReportUtils.exReport(this.dexa, 200018, cj.mobile.wm.dexc.dexa("TEL扞樌捗櫓徔ꆎ辯拡龾楲鵦"), str2);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    DebugLog.common_w(str2);
                    return null;
                }
            } catch (IOException unused7) {
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamOpen = null;
        }
    }
}
