package cj.mobile.help.beizi;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJInterstitial;
import cj.mobile.listener.CJInterstitialListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYInterstitialAdapter extends AMPSInterstitialAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJInterstitial f22218a;

    public class a implements IAMPSChannelInitCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYInterstitialAdapter f22219a;

        public a(LYInterstitialAdapter lYInterstitialAdapter) {
        }

        public void failCallBack(AMPSError aMPSError) {
        }

        public void successCallBack() {
        }
    }

    public class b implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYInterstitialAdapter f22220a;

        public b(LYInterstitialAdapter lYInterstitialAdapter) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onShow() {
        }
    }

    public void destroy() {
    }

    public void initSdk() {
    }

    public boolean isValid() {
    }

    public void loadAd() {
    }

    public /* bridge */ /* synthetic */ void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener) {
    }

    public void showAd(Activity activity) {
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
    }
}
