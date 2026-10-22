package cj.mobile.help.topon;

import android.content.Context;
import android.view.View;
import cj.mobile.CJMobileAd;
import cj.mobile.CJNativeExpress;
import cj.mobile.CJRenderNative;
import cj.mobile.listener.CJMediaListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYNativeExpressAdapter extends CustomNativeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJNativeExpress f22252a;
    public CJRenderNative b;
    public String c;
    public NativeAdExt d;
    public boolean e;

    public class a implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ATBiddingListener f22253a;
        public final /* synthetic */ String b;
        public final /* synthetic */ LYNativeExpressAdapter c;

        public a(LYNativeExpressAdapter lYNativeExpressAdapter, ATBiddingListener aTBiddingListener, String str) {
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

    public class b implements CJRenderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ATBiddingListener f22254a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ LYNativeExpressAdapter d;

        public class a implements CJMediaListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f22255a;

            public a(b bVar) {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoClicked() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoCompleted() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoError(String str, String str2) {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoInit() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoLoaded(int i) {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoLoading() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoPause() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoReady() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoResume() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoStart() {
            }

            @Override // cj.mobile.listener.CJMediaListener
            public void onVideoStop() {
            }
        }

        public b(LYNativeExpressAdapter lYNativeExpressAdapter, ATBiddingListener aTBiddingListener, String str, Context context) {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onShow() {
        }
    }

    public void destory() {
    }

    public String getNetworkName() {
        return "LYAD";
    }

    public String getNetworkPlacementId() {
        return this.c;
    }

    public String getNetworkSDKVersion() {
        return CJMobileAd.getSdkVersion();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
    }

    public void startLoadExpress(Context context, String str, int i, int i2, ATBiddingListener aTBiddingListener) {
    }

    public void startLoadNative(Context context, String str, int i, int i2, ATBiddingListener aTBiddingListener) {
    }
}
