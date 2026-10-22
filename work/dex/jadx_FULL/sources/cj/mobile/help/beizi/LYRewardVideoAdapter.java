package cj.mobile.help.beizi;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJRewardVideo;
import cj.mobile.listener.CJRewardListener;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYRewardVideoAdapter extends AMPSRewardAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJRewardVideo f22225a;

    public class a implements IAMPSChannelInitCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYRewardVideoAdapter f22226a;

        public a(LYRewardVideoAdapter lYRewardVideoAdapter) {
        }

        public void failCallBack(AMPSError aMPSError) {
        }

        public void successCallBack() {
        }
    }

    public class b implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYRewardVideoAdapter f22227a;

        public b(LYRewardVideoAdapter lYRewardVideoAdapter) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onReward(String str) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onShow() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoEnd() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoStart() {
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

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
    }
}
