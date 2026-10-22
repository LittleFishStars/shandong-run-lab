package cj.mobile.help.topon;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.CJMobileAd;
import cj.mobile.CJSplash;
import cj.mobile.listener.CJSplashListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYSplashAdapter extends CustomSplashAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJSplash f22259a;
    public String b;
    public int c;
    public int d;

    public class a implements CJSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ATBiddingListener f22260a;
        public final /* synthetic */ LYSplashAdapter b;

        public a(LYSplashAdapter lYSplashAdapter, ATBiddingListener aTBiddingListener) {
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

    public class b implements CJSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYSplashAdapter f22261a;

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

    public void show(Activity activity, ViewGroup viewGroup) {
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
    }

    public final void a(Context context, ATBiddingListener aTBiddingListener) {
    }
}
