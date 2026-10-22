package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bwt.top.BannerAd;
import com.bwt.top.InterstitialAd;
import com.bwt.top.NativeAd;
import com.bwt.top.SplashAd;
import com.bwt.top.UnifiedAD;
import com.bwt.top.ad.BaseAd;
import com.bwt.top.ad.adapter.AdapterAdLoaderImp;
import com.bwt.top.ad.loader.AdLoader;
import com.bwt.top.ad.loader.ddksa.ddksa;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.exception.AdError;
import com.bwt.top.util.ALog;
import com.bwt.top.util.ClassUtil;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ygb<T extends BaseAd> implements AdLoader<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f46028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ddksa<ygb, AdapterAdLoaderImp> f20852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20853a = ygb.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<PosInfoBean, AdapterAdLoaderImp> f20854a;

    public ygb(T t) {
        this.f46028a = t;
    }

    @Override // com.bwt.top.ad.loader.AdLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T getAd() {
        return this.f46028a;
    }

    @Nullable
    public AdapterAdLoaderImp b(String str, PosInfoBean posInfoBean) {
        Object objCreateInstanceByClass;
        String strC = c(posInfoBean.getPosPlatform().toLowerCase());
        if (strC == null || strC.length() <= 0 || (objCreateInstanceByClass = ClassUtil.createInstanceByClass(strC)) == null) {
            return null;
        }
        AdapterAdLoaderImp adapterAdLoaderImp = (AdapterAdLoaderImp) objCreateInstanceByClass;
        adapterAdLoaderImp.setAd(this.f46028a);
        return adapterAdLoaderImp;
    }

    public final String c(String str) {
        Map<String, String> map;
        if (this.f46028a != null && !TextUtils.isEmpty(str)) {
            T t = this.f46028a;
            if (t instanceof BannerAd) {
                map = xgb.b;
            } else if (t instanceof NativeAd) {
                map = xgb.c;
            } else if (t instanceof UnifiedAD) {
                map = xgb.e;
            } else if (t instanceof InterstitialAd) {
                map = xgb.d;
            } else if (t instanceof SplashAd) {
                map = xgb.f;
            }
            return map.get(str);
        }
        return "";
    }

    public final void d() {
        T t = this.f46028a;
        if (t == null || t.getAdListener() == null) {
            return;
        }
        this.f46028a.getAdListener().onAdFailed(new AdError(11, "config no found adPosInfo"));
    }

    @Override // com.bwt.top.ad.loader.AdLoader
    public void loadAd(String str) {
        ALog.i(this.f20853a, "posId: " + str);
        ddksa<ygb, AdapterAdLoaderImp> ddksaVarA = jwa.a(str, this);
        this.f20852a = ddksaVarA;
        if (ddksaVarA != null) {
            ddksaVarA.h(this.f46028a.isShow());
            this.f20852a.a();
            return;
        }
        T t = this.f46028a;
        if (t == null || t.getAdListener() == null) {
            return;
        }
        this.f46028a.getAdListener().onAdFailed(new AdError(11, "posId=" + str + ", config no found adPosInfo"));
    }

    @Override // com.bwt.top.ad.loader.AdLoader
    public void onPaused() {
        ddksa<ygb, AdapterAdLoaderImp> ddksaVar = this.f20852a;
        if (ddksaVar != null) {
            ddksaVar.i();
        }
    }

    @Override // com.bwt.top.ad.loader.AdLoader
    public void onResumed() {
        ddksa<ygb, AdapterAdLoaderImp> ddksaVar = this.f20852a;
        if (ddksaVar != null) {
            ddksaVar.b();
        }
    }

    @Override // com.bwt.top.ad.loader.AdLoader
    public void release() {
        try {
            ALog.e(this.f20853a, " release");
            ddksa<ygb, AdapterAdLoaderImp> ddksaVar = this.f20852a;
            if (ddksaVar != null) {
                ddksaVar.e();
            }
            Map<PosInfoBean, AdapterAdLoaderImp> map = this.f20854a;
            if (map != null) {
                Iterator<PosInfoBean> it = map.keySet().iterator();
                while (it.hasNext()) {
                    AdapterAdLoaderImp adapterAdLoaderImp = this.f20854a.get(it.next());
                    if (adapterAdLoaderImp != null) {
                        adapterAdLoaderImp.release();
                    }
                }
                this.f20854a.clear();
            }
            T t = this.f46028a;
            if (t != null) {
                t.release();
                this.f46028a = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bwt.top.ad.loader.AdLoader
    public void showAd() {
        try {
            ddksa<ygb, AdapterAdLoaderImp> ddksaVar = this.f20852a;
            if (ddksaVar != null) {
                ddksaVar.d();
            } else {
                d();
            }
        } catch (Throwable unused) {
            d();
        }
    }
}
