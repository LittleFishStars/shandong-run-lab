package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bwt.top.AdSdk;
import com.bwt.top.ad.adapter.ThirdSdkInit;
import com.bwt.top.ad.adapter.ThirdSdkInitCallback;
import com.bwt.top.api.FunctionConfig;
import com.bwt.top.api.bean.PlatformInfoBean;
import com.bwt.top.util.ALog;
import com.bwt.top.util.ClassUtil;
import com.bwt.top.util.PackageUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class kva implements ThirdSdkInitCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f42921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static kva f17793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17794a = "ThirdSdkInitManger";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f42922a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ThirdSdkInit f17795a;
        public final /* synthetic */ String f;

        public a(kva kvaVar, Context context, ThirdSdkInit thirdSdkInit, String str) {
            this.f42922a = context;
            this.f17795a = thirdSdkInit;
            this.f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageUtil.getPackageName(this.f42922a);
            this.f17795a.init(this.f42922a, this.f);
        }
    }

    public static kva a() {
        if (f17793a == null) {
            synchronized (kva.class) {
                if (f17793a == null) {
                    f17793a = new kva();
                }
            }
        }
        return f17793a;
    }

    public void b() {
        Object objCreateInstanceByClass;
        List<PlatformInfoBean> platformInfo = FunctionConfig.instance().getPlatformInfo();
        if (platformInfo == null || platformInfo.size() == 0) {
            ALog.i(this.f17794a, "initThirdSdk error InitConfig is empty");
            return;
        }
        if (f42921a == null) {
            f42921a = new Handler(Looper.getMainLooper());
        }
        Context context = AdSdk.getInstance().getContext();
        for (PlatformInfoBean platformInfoBean : platformInfo) {
            String lowerCase = platformInfoBean.getPlatformType().toLowerCase();
            String thirdAppId = platformInfoBean.getThirdAppId();
            String str = xgb.f45820a.get(lowerCase);
            if (str != null && str.length() > 0 && (objCreateInstanceByClass = ClassUtil.createInstanceByClass(str)) != null && (objCreateInstanceByClass instanceof ThirdSdkInit)) {
                ThirdSdkInit thirdSdkInit = (ThirdSdkInit) objCreateInstanceByClass;
                thirdSdkInit.setThirdSdkInitCallback(this);
                f42921a.post(new a(this, context, thirdSdkInit, thirdAppId));
            }
        }
    }

    @Override // com.bwt.top.ad.adapter.ThirdSdkInitCallback
    public void onFailed(ThirdSdkInit thirdSdkInit, String str) {
        ALog.i(this.f17794a, "onFailed:" + str);
    }

    @Override // com.bwt.top.ad.adapter.ThirdSdkInitCallback
    public void onSucceed(String str) {
        ALog.i(this.f17794a, "onSucceed:" + str);
    }
}
