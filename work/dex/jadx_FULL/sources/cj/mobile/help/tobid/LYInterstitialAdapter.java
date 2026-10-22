package cj.mobile.help.tobid;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJInterstitial;
import cj.mobile.listener.CJInterstitialListener;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYInterstitialAdapter extends WMCustomInterstitialAdapter {
    public CJInterstitial h;

    public class a implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYInterstitialAdapter f22245a;

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

    public void destroyAd() {
    }

    public boolean isReady() {
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
    }

    public void showAd(Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
    }
}
