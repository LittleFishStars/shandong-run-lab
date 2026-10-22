package cj.mobile.help.gromore;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import cj.mobile.CJSplash;
import cj.mobile.listener.CJInitListener;
import cj.mobile.listener.CJSplashListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYSplashLoader extends MediationCustomSplashLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJSplash f22240a;
    public Context b;
    public Activity c;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f22241a;
        public final /* synthetic */ LYSplashLoader b;

        public a(LYSplashLoader lYSplashLoader, ViewGroup viewGroup) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }
    }

    public class b implements CJInitListener {
        public b(LYSplashLoader lYSplashLoader) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public class c implements CJSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYSplashLoader f22242a;

        public c(LYSplashLoader lYSplashLoader) {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public void showAd(ViewGroup viewGroup) {
    }
}
