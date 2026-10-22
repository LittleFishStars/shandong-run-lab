package cn.jy.ad.sdk;

import android.content.Context;
import android.text.TextUtils;
import cn.jy.ad.sdk.jycfg.JyConfig;
import cn.jy.ad.sdk.jyinter.AdManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdSdk {

    public interface Callback {
        void onFail(int i, String str);

        void onSuccess();
    }

    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callback f22759a;

        public a(Callback callback) {
            this.f22759a = callback;
        }

        @Override // cn.jy.ad.sdk.b
        public void onFail(int i, String str) {
            Callback callback = this.f22759a;
            if (callback != null) {
                callback.onFail(i, str);
            }
        }

        @Override // cn.jy.ad.sdk.b
        public void onSuccess() {
            Callback callback = this.f22759a;
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }

    public static synchronized AdManager getAdManager() {
        return d.a();
    }

    public static synchronized void init(Context context, JyConfig jyConfig) {
        try {
            if (context == null || jyConfig == null) {
                throw new RuntimeException("init context or config is null");
            }
            if (TextUtils.isEmpty(jyConfig.getAppId())) {
                throw new RuntimeException("appId不能为空");
            }
            g.a().a(context, jyConfig);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void start(Callback callback) {
        g.a().c(new a(callback));
    }
}
