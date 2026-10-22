package cj.mobile.help.topon;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJMobileAd;
import cj.mobile.CJRewardVideo;
import cj.mobile.listener.CJRewardListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYRewardVideoAdapter extends CustomRewardVideoAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJRewardVideo f22256a;
    public String b;

    public class a implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYRewardVideoAdapter f22257a;

        public a(LYRewardVideoAdapter lYRewardVideoAdapter) {
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

    public class b implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ATBiddingListener f22258a;
        public final /* synthetic */ String b;
        public final /* synthetic */ LYRewardVideoAdapter c;

        public b(LYRewardVideoAdapter lYRewardVideoAdapter, ATBiddingListener aTBiddingListener, String str) {
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

    public void destory() {
    }

    public String getNetworkName() {
        return "LYAD";
    }

    public String getNetworkPlacementId() {
        return this.b;
    }

    public String getNetworkSDKVersion() {
        return CJMobileAd.getSdkVersion();
    }

    public boolean isAdReady() {
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
    }

    public void show(Activity activity) {
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
    }

    public void startLoad(Context context, String str, String str2, ATBiddingListener aTBiddingListener) {
    }
}
