package com.zj.adlib;

import android.text.TextUtils;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.impl.JZBannerAd;
import cn.hzjizhun.admin.ad.impl.JZInterstitialAd;
import cn.hzjizhun.admin.ad.impl.JZNativeAd;
import cn.hzjizhun.admin.ad.impl.JZRewardVideoAd;
import cn.hzjizhun.admin.ad.impl.JZSplashAd;
import cn.hzjizhun.admin.ad.impl.JZUnifiedAD;
import cn.hzjizhun.admin.ad.loader.AdLoader;
import cn.hzjizhun.admin.akdsd;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.ddk;
import cn.hzjizhun.admin.dkkd;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.ClassUtil;
import com.igexin.sdk.PushConsts;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ghb implements AdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseAd f41907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dkkd f16766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f16768a;
    public String b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16769a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f16767a = getClass().getSimpleName();

    public ghb(BaseAd baseAd) {
        this.f41907a = baseAd;
    }

    public final String a(String str) {
        if (this.f41907a != null && !TextUtils.isEmpty(str)) {
            BaseAd baseAd = this.f41907a;
            if (baseAd instanceof JZBannerAd) {
                return (String) ddk.b.get(str);
            }
            if (baseAd instanceof JZNativeAd) {
                return (String) ddk.c.get(str);
            }
            if (baseAd instanceof JZUnifiedAD) {
                return (String) ddk.e.get(str);
            }
            if (baseAd instanceof JZInterstitialAd) {
                return (String) ddk.d.get(str);
            }
            if (baseAd instanceof JZSplashAd) {
                return (String) ddk.f.get(str);
            }
            if (baseAd instanceof JZRewardVideoAd) {
                return (String) ddk.g.get(str);
            }
        }
        return "";
    }

    @Override // cn.hzjizhun.admin.ad.loader.AdLoader
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BaseAd getAd() {
        return this.f41907a;
    }

    public AdapterAdLoaderImp c(String str, PosInfoBean posInfoBean) {
        Object objCreateInstanceByClass;
        try {
            String lowerCase = posInfoBean.getPosPlatform().toLowerCase();
            if (!FunctionConfig.instance().getInitResult(lowerCase)) {
                ALog.d("AdapterAdLoaderImp", "初始化失败" + lowerCase);
                return null;
            }
            String strA = a(lowerCase);
            if (strA != null && !strA.isEmpty() && (objCreateInstanceByClass = ClassUtil.createInstanceByClass(strA)) != null) {
                AdapterAdLoaderImp adapterAdLoaderImp = (AdapterAdLoaderImp) objCreateInstanceByClass;
                adapterAdLoaderImp.setAd(this.f41907a);
                return adapterAdLoaderImp;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    public final void d() {
        BaseAd baseAd = this.f41907a;
        if (baseAd == null || baseAd.getAdListener() == null) {
            return;
        }
        this.f41907a.getAdListener().onAdFailed(new JZAdError(11, "config no found adPosInfo"));
    }

    public dkkd kdsksdda(String str) {
        return akdsd.a(str, this);
    }

    @Override // cn.hzjizhun.admin.ad.loader.AdLoader
    public void loadAd(String str) {
        this.b = str;
        ALog.i(this.f16767a, "posId: " + str);
        dkkd dkkdVarKdsksdda = kdsksdda(str);
        this.f16766a = dkkdVarKdsksdda;
        if (dkkdVarKdsksdda != null) {
            dkkdVarKdsksdda.i(this.f41907a.isShow());
            this.f16766a.a();
            return;
        }
        BaseAd baseAd = this.f41907a;
        if (baseAd != null && baseAd.getAdListener() != null) {
            this.f41907a.getAdListener().onAdFailed(new JZAdError(11, "posId=" + str + ", config no found adPosInfo"));
        }
        ApiManager.reportError(PushConsts.SEND_MESSAGE_ERROR_GENERAL, this.b);
    }

    @Override // cn.hzjizhun.admin.ad.loader.AdLoader
    public void onPaused() {
        dkkd dkkdVar = this.f16766a;
        if (dkkdVar != null) {
            dkkdVar.j();
        }
    }

    @Override // cn.hzjizhun.admin.ad.loader.AdLoader
    public void onResumed() {
        dkkd dkkdVar = this.f16766a;
        if (dkkdVar != null) {
            dkkdVar.b();
        }
    }

    @Override // cn.hzjizhun.admin.ad.loader.AdLoader
    public void release() {
        try {
            ALog.e(this.f16767a, " release");
            BaseAd baseAd = this.f41907a;
            if (baseAd != null) {
                baseAd.onDestroyed();
                this.f41907a = null;
            }
            dkkd dkkdVar = this.f16766a;
            if (dkkdVar != null) {
                dkkdVar.f();
            }
            Map map = this.f16768a;
            if (map != null) {
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    AdapterAdLoaderImp adapterAdLoaderImp = (AdapterAdLoaderImp) this.f16768a.get((PosInfoBean) it.next());
                    if (adapterAdLoaderImp != null) {
                        adapterAdLoaderImp.release();
                    }
                }
                this.f16768a.clear();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.loader.AdLoader
    public void shakeClick() {
        try {
            dkkd dkkdVar = this.f16766a;
            if (dkkdVar != null) {
                dkkdVar.e();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.loader.AdLoader
    public void showAd() {
        try {
            dkkd dkkdVar = this.f16766a;
            if (dkkdVar != null) {
                dkkdVar.d();
            } else {
                d();
            }
        } catch (Throwable unused) {
            d();
        }
    }
}
