package com.zj.adlib;

import android.content.Context;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.ad.adapter.ThirdSdkInit;
import cn.hzjizhun.admin.ad.adapter.ThirdSdkInitCallback;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.api.bean.PlatformInfoBean;
import cn.hzjizhun.admin.ddk;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.ClassUtil;
import cn.hzjizhun.admin.util.PackageUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class vgb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static vgb f45347a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f20216a = "ThirdSdkInitManger";

    public class a implements ThirdSdkInitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThirdSdkInit f45348a;

        public a(ThirdSdkInit thirdSdkInit) {
            this.f45348a = thirdSdkInit;
        }

        @Override // cn.hzjizhun.admin.ad.adapter.ThirdSdkInitCallback
        public void onFailed(ThirdSdkInit thirdSdkInit, String str) {
            ALog.i(vgb.f20216a, "onFailed:" + str);
            FunctionConfig.instance().setInitResult(thirdSdkInit.getPlatformType(), false);
        }

        @Override // cn.hzjizhun.admin.ad.adapter.ThirdSdkInitCallback
        public void onSucceed(String str) {
            vgb unused = vgb.f45347a;
            ALog.i(vgb.f20216a, "onSucceed:" + str);
            FunctionConfig.instance().setInitResult(this.f45348a.getPlatformType(), true);
        }
    }

    public static vgb a() {
        if (f45347a == null) {
            synchronized (vgb.class) {
                if (f45347a == null) {
                    f45347a = new vgb();
                }
            }
        }
        return f45347a;
    }

    public static ThirdSdkInit d(ThirdSdkInit thirdSdkInit) {
        thirdSdkInit.setThirdSdkInitCallback(new a(thirdSdkInit));
        return thirdSdkInit;
    }

    public void c() {
        List<PlatformInfoBean> platformInfo = FunctionConfig.instance().getPlatformInfo();
        if (platformInfo == null || platformInfo.isEmpty()) {
            ALog.i(f20216a, "initThirdSdk error InitConfig is empty");
            return;
        }
        Context context = JZAdSdk.getInstance().getContext();
        for (PlatformInfoBean platformInfoBean : platformInfo) {
            String lowerCase = platformInfoBean.getPlatformType().toLowerCase();
            f(context, lowerCase, (String) ddk.f22713a.get(lowerCase), platformInfoBean.getThirdAppId());
        }
    }

    public final void f(Context context, String str, String str2, String str3) {
        if (str2 != null) {
            try {
                if (str2.isEmpty()) {
                    return;
                }
                Object objCreateInstanceByClass = ClassUtil.createInstanceByClass(str2);
                if (objCreateInstanceByClass == null) {
                    g(str);
                }
                if (objCreateInstanceByClass instanceof ThirdSdkInit) {
                    ThirdSdkInit thirdSdkInitD = d((ThirdSdkInit) objCreateInstanceByClass);
                    PackageUtil.getPackageName(context);
                    thirdSdkInitD.init(context, str3);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void g(String str) {
        try {
            ApiManager.reportErrorAndMsg("10005", String.format("没有接入 %s aar", str), "");
        } catch (Throwable unused) {
        }
    }
}
