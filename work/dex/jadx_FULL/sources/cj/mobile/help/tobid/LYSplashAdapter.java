package cj.mobile.help.tobid;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.CJSplash;
import cj.mobile.listener.CJSplashListener;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYSplashAdapter extends WMCustomSplashAdapter {
    public CJSplash h;

    public class a implements CJSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYSplashAdapter f22247a;

        public a(LYSplashAdapter lYSplashAdapter) {
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

    public void destroyAd() {
    }

    public boolean isReady() {
    }

    public void loadAd(Context context, ViewGroup viewGroup, Map<String, Object> map, Map<String, Object> map2) {
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
    }
}
