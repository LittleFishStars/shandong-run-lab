package com.kc.bw.common.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kc.bw.common.bean.InstReportBean;
import com.kc.bw.common.bean.ReportDeviceBean;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.callback.ByteCallback;
import com.kc.bw.okhttp.callback.StringCallback;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.utils.AesUtil;
import com.kc.bw.okhttp.utils.GZIPUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ReportUtils {
    public static void doReportException(Context context, String str, int i, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder(str3);
            ReportDeviceBean reportDeviceBean = new ReportDeviceBean();
            reportDeviceBean.setOs(1);
            reportDeviceBean.setRequestTimeValue(System.currentTimeMillis() + "");
            if (!TextUtils.isEmpty(str)) {
                reportDeviceBean.setAdSlotId(str);
            }
            try {
                reportDeviceBean.setOsVersion(Build.VERSION.RELEASE);
            } catch (Throwable th) {
                sb.append(dexg.dexa("-bqq!jogp!hfu!gbjmfe-"));
                sb.append(th);
            }
            try {
                reportDeviceBean.setBrand(Build.BRAND);
                reportDeviceBean.setModel(Build.MODEL);
            } catch (Throwable th2) {
                sb.append(dexg.dexa("-efwjdf!jogp!hfu!gbjmfe-"));
                sb.append(th2);
            }
            if (context == null) {
                context = ContextContainer.getApplicationContext();
            }
            if (context != null) {
                try {
                    reportDeviceBean.setAppPackageName(context.getPackageName());
                    reportDeviceBean.setAppVersion(Utils.getVersionName(context));
                } catch (Throwable th3) {
                    sb.append(dexg.dexa("-bqqQbdlbhfObnf!ps!bqqWfstjpo!hfu!gbjmfe-"));
                    sb.append(th3);
                }
                try {
                    reportDeviceBean.setOaid(PrivateInfoHelper.getOaid(context));
                    if (Build.VERSION.SDK_INT <= 28) {
                        reportDeviceBean.setImei(PrivateInfoHelper.getIMEI(context));
                    }
                } catch (Throwable th4) {
                    sb.append(dexg.dexa("-pbje!ps!jnfj!hfu!gbjmfe-"));
                    sb.append(th4);
                }
            } else {
                sb.append(dexg.dexa("dpoufyu!jt!ovmm"));
            }
            try {
                reportDeviceBean.setCode(i + "");
                reportDeviceBean.setCodeMsg(str2);
                reportDeviceBean.setError_info(sb.toString());
                OkHttp.post(ConstantInfo.getTrackHostUrl() + dexg.dexa("tel0sfqpsu0fssps/bqj")).upString(GsonUtils.getInstance().toJson(reportDeviceBean)).execute(new StringCallback() { // from class: com.kc.bw.common.utils.ReportUtils.3
                    @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
                    public void onError(Response<String> response) {
                        super.onError(response);
                        StringBuilder sb2 = new StringBuilder(dexg.dexa("fy!sq!gbjm"));
                        if (response != null) {
                            sb2.append(dexg.dexa(c49.f40900a));
                            sb2.append(response.body());
                        }
                        DebugLog.common_w(sb2.toString());
                    }

                    @Override // com.kc.bw.okhttp.callback.Callback
                    public void onSuccess(Response<String> response) {
                        DebugLog.common_all(dexg.dexa("fy!sq!epof"));
                    }
                });
            } catch (Throwable th5) {
                DebugLog.common_w(dexg.dexa("fssps!sfqpsu!gbjm-") + th5);
            }
        } catch (Throwable th6) {
            DebugLog.common_w(dexg.dexa("fssps!sfqpsu!gbjm-") + th6);
        }
    }

    public static void exReport(Context context, int i, String str, String str2) {
        exReport(context, "", i, str, str2);
    }

    public static void exReport(Context context, String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            DebugLog.common_w(dexg.dexa("fsspsJogp!jt!fnquz\""));
        } else if (ThreadUtils.isUIThread(dexg.dexa("fySfqpsu"))) {
            ThreadUtils.runOnThreadPool(new Runnable(context, str, i, str2, str3) { // from class: com.kc.bw.common.utils.ReportUtils.2
                public final String val$adSlotId;
                public final Context val$context;
                public final int val$errorCode;
                public final String val$errorInfo;
                public final String val$errorMsg;

                {
                    this.val$context = context;
                    this.val$adSlotId = str;
                    this.val$errorCode = i;
                    this.val$errorMsg = str2;
                    this.val$errorInfo = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ReportUtils.doReportException(this.val$context, this.val$adSlotId, this.val$errorCode, this.val$errorMsg, this.val$errorInfo);
                }
            });
        } else {
            doReportException(context, str, i, str2, str3);
        }
    }

    public static void reportInstInfo(InstReportBean instReportBean) {
        if (instReportBean == null) {
            DebugLog.inst_w(dexg.dexa("sfqpsuJotuJogp!gbjm-ebub!jt!ovmm"));
            return;
        }
        String json = GsonUtils.getInstance().toJson(instReportBean);
        OkHttp.post(ConstantInfo.getTrackHostUrl() + dexg.dexa("tel0sfqpsu0jut/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, dexg.dexa("vug.9")), ConstantInfo.getAppToken())).execute(new ByteCallback() { // from class: com.kc.bw.common.utils.ReportUtils.1
            @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
            public void onError(Response<byte[]> response) {
                super.onError(response);
                DebugLog.common_w(dexg.dexa("gvmmJotu!sfqpsu!gbjm!") + response.code() + dexg.dexa(c49.f40900a) + response.getException());
            }

            @Override // com.kc.bw.okhttp.callback.Callback
            public void onSuccess(Response<byte[]> response) {
                DebugLog.inst_d(dexg.dexa("gvmmJotu!sfqpsu!epof"));
            }
        });
    }
}
