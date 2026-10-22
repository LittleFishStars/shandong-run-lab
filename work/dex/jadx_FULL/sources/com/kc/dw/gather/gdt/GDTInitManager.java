package com.kc.dw.gather.gdt;

import android.content.Context;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTInitManager extends CustomInitLoader {
    public static /* synthetic */ Object lambda$initADN$0(Object obj, Method method, Object[] objArr) throws Throwable {
        LogUtil.d("GDTAdConfig", "gdt init succ");
        return null;
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getPlatform() {
        return "GDT";
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getVersionName() {
        return AdSdk.getGDTVersionName();
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public void initADN(String str, String str2, Map<String, Object> map) {
        if (a.adConfig().getCanUseSdkPersonalRecommend()) {
            GlobalSetting.setPersonalizedState(0);
        } else {
            GlobalSetting.setPersonalizedState(1);
        }
        if (a.adConfig().customController() != null) {
            GlobalSetting.setAgreePrivacyStrategy(a.adConfig().customController().isCanUsePhoneState());
            GlobalSetting.setEnableCollectAppInstallStatus(a.adConfig().customController().canReadInstalledPackages());
        }
        try {
            if (!a.adConfig().enableInstallBroadcast()) {
                HashMap map2 = new HashMap();
                map2.put("hieib", Boolean.FALSE);
                GlobalSetting.setConvOptimizeInfo(map2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            try {
                GDTAdSdk.class.getDeclaredMethod("initWithoutStart", Context.class, String.class).invoke(null, a.getContext(), str);
                GDTAdSdk.class.getDeclaredMethod("start", GDTAdSdk.OnStartListener.class).invoke(null, Proxy.newProxyInstance(GDTInitManager.class.getClassLoader(), new Class[]{GDTAdSdk.OnStartListener.class}, new InvocationHandler() { // from class: com.kc.dw.gather.gdt.GDTInitManager$$ExternalSyntheticLambda0
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        return GDTInitManager.lambda$initADN$0(obj, method, objArr);
                    }
                }));
            } catch (Throwable unused) {
                GDTAdSdk.class.getDeclaredMethod("init", Context.class, String.class).invoke(null, a.getContext(), str);
            }
            callInitSucc();
        } catch (Exception unused2) {
            callInitFail();
        }
    }
}
