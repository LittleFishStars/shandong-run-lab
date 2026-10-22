package cn.hzjizhun.admin.custom_ad;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader;
import cn.hzjizhun.admin.ad.bean.BasicJZAdInfoIpl;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.impl.JZRewardVideoAd;
import cn.hzjizhun.admin.ad.listener.JZRewardVideoAdListener;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.h5.VideoPlayActivity;
import cn.hzjizhun.admin.sads;
import com.zj.adlib.wgb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdapterCustomRewardVideoAdLoader extends AdapterCustomAdLoader<JZAdInfo, JZRewardVideoAdListener, JZRewardVideoAd> {
    private void setRewardCallback() {
        wgb.c().g(new sads() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomRewardVideoAdLoader.1
            @Override // cn.hzjizhun.admin.sads
            public void onAdClick() {
                AdapterCustomRewardVideoAdLoader.this.adClickSource(Cs.MC);
            }

            @Override // cn.hzjizhun.admin.sads
            public void onAdClose() {
                AdapterCustomRewardVideoAdLoader.this.onAdCloseListener();
                AdapterCustomRewardVideoAdLoader.this.release();
            }

            @Override // cn.hzjizhun.admin.sads
            public void onAdError(JZAdError jZAdError) {
                AdapterCustomRewardVideoAdLoader.this.onAdFailedListener(jZAdError);
                AdapterCustomRewardVideoAdLoader.this.release();
            }

            @Override // cn.hzjizhun.admin.sads
            public void onAdExpose() {
                AdapterCustomRewardVideoAdLoader.this.onAdExposeListener();
            }

            @Override // cn.hzjizhun.admin.sads
            public void onAdReward() {
                if (((AdapterAdLoaderImp) AdapterCustomRewardVideoAdLoader.this).mAd == null || ((JZRewardVideoAd) ((AdapterAdLoaderImp) AdapterCustomRewardVideoAdLoader.this).mAd).getAdListener() == null) {
                    return;
                }
                ((JZRewardVideoAd) ((AdapterAdLoaderImp) AdapterCustomRewardVideoAdLoader.this).mAd).getAdListener().onAdReward();
            }
        });
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZAdInfo createAdInfo() {
        return new BasicJZAdInfoIpl(this.mPosInfo, this);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        CustomAdPosResult.VideoBean videoBean;
        Log.d(this.TAG, "readyAdView: ");
        try {
            wgb.c().f(this.mAdObject);
            CustomAdPosResult customAdPosResult = this.mAdObject;
            if (customAdPosResult == null || (videoBean = customAdPosResult.video) == null || TextUtils.isEmpty(videoBean.url)) {
                onAdFailedListener(new JZAdError(-1, "video is null"));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader, cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        wgb.c().h();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        CustomAdPosResult customAdPosResult;
        CustomAdPosResult.VideoBean videoBean;
        super.renderView();
        Log.d(this.TAG, "readyAdView: ");
        try {
            if (isShowAd() && (customAdPosResult = this.mAdObject) != null && (videoBean = customAdPosResult.video) != null && !TextUtils.isEmpty(videoBean.url)) {
                setRewardCallback();
                wgb.c().e(this.mReport);
                Intent intent = new Intent(getContext(), (Class<?>) VideoPlayActivity.class);
                intent.addFlags(268435456);
                getContext().startActivity(intent);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [cn.hzjizhun.admin.ad.bean.JZAdInfo] */
    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void skipH5Listener(String str) {
        super.skipH5Listener(str);
        T t = this.mAd;
        if (t == 0 || ((JZRewardVideoAd) t).getAdListener() == null) {
            return;
        }
        ((JZRewardVideoAd) this.mAd).getAdListener().onAdClick(getAdInfo(), str);
    }
}
