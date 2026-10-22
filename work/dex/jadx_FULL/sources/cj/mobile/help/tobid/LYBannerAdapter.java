package cj.mobile.help.tobid;

import android.content.Context;
import android.view.View;
import cj.mobile.CJNativeExpress;
import cj.mobile.listener.CJNativeExpressListener;
import com.windmill.sdk.custom.WMCustomBannerAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYBannerAdapter extends WMCustomBannerAdapter {
    public CJNativeExpress h;
    public View i;

    public class a implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYBannerAdapter f22243a;

        public a(LYBannerAdapter lYBannerAdapter) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void loadSuccess(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClick(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClose(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onShow(View view) {
        }
    }

    public void destroyAd() {
    }

    public View getBannerView() {
        return this.i;
    }

    public boolean isReady() {
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
    }
}
