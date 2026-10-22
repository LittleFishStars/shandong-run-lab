package cj.mobile.help.beizi;

import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.CJSplash;
import cj.mobile.listener.CJSplashListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYSplashAdapter extends AMPSSplashAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJSplash f22228a;

    public class a implements IAMPSChannelInitCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYSplashAdapter f22229a;

        public a(LYSplashAdapter lYSplashAdapter) {
        }

        public void failCallBack(AMPSError aMPSError) {
        }

        public void successCallBack() {
        }
    }

    public class b implements CJSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYSplashAdapter f22230a;

        public b(LYSplashAdapter lYSplashAdapter) {
        }

        @Override // cj.mobile.listener.CJSplashListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJSplashListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJSplashListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJSplashListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJSplashListener
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

    public void showAd(ViewGroup viewGroup) {
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
    }
}
