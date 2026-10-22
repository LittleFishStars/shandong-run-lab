package cj.mobile.wm.common.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cj.mobile.wm.common.bean.InstReportBean;
import cj.mobile.wm.common.bean.ReportDeviceBean;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
import cj.mobile.wm.okhttp.callback.ByteCallback;
import cj.mobile.wm.okhttp.callback.StringCallback;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.utils.AesUtil;
import cj.mobile.wm.okhttp.utils.GZIPUtils;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
                sb.append(dexc.dexa("-bqq!jogp!hfu!gbjmfe-"));
                sb.append(th);
            }
            try {
                reportDeviceBean.setBrand(Build.BRAND);
                reportDeviceBean.setModel(Build.MODEL);
            } catch (Throwable th2) {
                sb.append(dexc.dexa("-efwjdf!jogp!hfu!gbjmfe-"));
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
                    sb.append(dexc.dexa("-bqqQbdlbhfObnf!ps!bqqWfstjpo!hfu!gbjmfe-"));
                    sb.append(th3);
                }
                try {
                    reportDeviceBean.setOaid(PrivateInfoHelper.getOaid(context));
                    if (Build.VERSION.SDK_INT <= 28) {
                        reportDeviceBean.setImei(PrivateInfoHelper.getIMEI(context));
                    }
                } catch (Throwable th4) {
                    sb.append(dexc.dexa("-pbje!ps!jnfj!hfu!gbjmfe-"));
                    sb.append(th4);
                }
            } else {
                sb.append(dexc.dexa("dpoufyu!jt!ovmm"));
            }
            try {
                reportDeviceBean.setCode(i + "");
                reportDeviceBean.setCodeMsg(str2);
                reportDeviceBean.setError_info(sb.toString());
                OkHttp.post(ConstantInfo.getTrackHostUrl() + dexc.dexa("tel0sfqpsu0fssps/bqj")).upString(GsonUtils.getInstance().toJson(reportDeviceBean)).execute(new StringCallback() { // from class: cj.mobile.wm.common.utils.ReportUtils.3
                    @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
                    public void onError(Response<String> response) {
                        super.onError(response);
                        StringBuilder sb2 = new StringBuilder(dexc.dexa("fy!sq!gbjm"));
                        if (response != null) {
                            sb2.append(dexc.dexa(c49.f40900a));
                            sb2.append(response.body());
                        }
                        DebugLog.common_w(sb2.toString());
                    }

                    @Override // cj.mobile.wm.okhttp.callback.Callback
                    public void onSuccess(Response<String> response) {
                        DebugLog.common_all(dexc.dexa("fy!sq!epof"));
                    }
                });
            } catch (Throwable th5) {
                DebugLog.common_w(dexc.dexa("fssps!sfqpsu!gbjm-") + th5);
            }
        } catch (Throwable th6) {
            DebugLog.common_w(dexc.dexa("fssps!sfqpsu!gbjm-") + th6);
        }
    }

    public static void exReport(Context context, int i, String str, String str2) {
        exReport(context, "", i, str, str2);
    }

    public static void reportInstInfo(InstReportBean instReportBean) {
        if (instReportBean == null) {
            DebugLog.inst_w(dexc.dexa("sfqpsuJotuJogp!gbjm-ebub!jt!ovmm"));
            return;
        }
        String json = GsonUtils.getInstance().toJson(instReportBean);
        OkHttp.post(ConstantInfo.getTrackHostUrl() + dexc.dexa("tel0sfqpsu0jut/bqj")).upBytes(AesUtil.encryptByt(GZIPUtils.compress(json, dexc.dexa("vug.9")), ConstantInfo.getAppToken())).execute(new ByteCallback() { // from class: cj.mobile.wm.common.utils.ReportUtils.1
            @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
            public void onError(Response<byte[]> response) {
                super.onError(response);
                DebugLog.common_w(dexc.dexa("gvmmJotu!sfqpsu!gbjm!") + response.code() + dexc.dexa(c49.f40900a) + response.getException());
            }

            @Override // cj.mobile.wm.okhttp.callback.Callback
            public void onSuccess(Response<byte[]> response) {
                DebugLog.inst_d(dexc.dexa("gvmmJotu!sfqpsu!epof"));
            }
        });
    }

    public static void exReport(final Context context, final String str, final int i, final String str2, final String str3) {
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            DebugLog.common_w(dexc.dexa("fsspsJogp!jt!fnquz\""));
        } else if (ThreadUtils.isUIThread(dexc.dexa("fySfqpsu"))) {
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: cj.mobile.wm.common.utils.ReportUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    ReportUtils.doReportException(context, str, i, str2, str3);
                }
            });
        } else {
            doReportException(context, str, i, str2, str3);
        }
    }
}
