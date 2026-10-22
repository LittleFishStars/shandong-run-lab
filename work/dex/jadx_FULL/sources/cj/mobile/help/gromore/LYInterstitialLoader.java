package cj.mobile.help.gromore;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJInterstitial;
import cj.mobile.listener.CJInitListener;
import cj.mobile.listener.CJInterstitialListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYInterstitialLoader extends MediationCustomInterstitialLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJInterstitial f22232a;

    public class a implements CJInitListener {
        public a(LYInterstitialLoader lYInterstitialLoader) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public class b implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYInterstitialLoader f22233a;

        public b(LYInterstitialLoader lYInterstitialLoader) {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader
    public void showAd(Activity activity) {
    }
}
