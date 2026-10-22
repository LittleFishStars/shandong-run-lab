package cj.mobile.help.topon;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJInterstitial;
import cj.mobile.CJMobileAd;
import cj.mobile.listener.CJInterstitialListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYInterstitialAdapter extends CustomInterstitialAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJInterstitial f22249a;
    public String b;

    public class a implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYInterstitialAdapter f22250a;

        public a(LYInterstitialAdapter lYInterstitialAdapter) {
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

    public class b implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ATBiddingListener f22251a;
        public final /* synthetic */ LYInterstitialAdapter b;

        public b(LYInterstitialAdapter lYInterstitialAdapter, ATBiddingListener aTBiddingListener) {
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

    public final void a(Context context, ATBiddingListener aTBiddingListener) {
    }
}
