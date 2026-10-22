package cj.mobile.help.beizi;

import android.content.Context;
import android.view.View;
import cj.mobile.CJNativeExpress;
import cj.mobile.listener.CJNativeExpressListener;
import java.util.List;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYNativeExpressAdapter extends AMPSNativeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJNativeExpress f22221a;
    public LYNativeExpressInfo b;

    public class a implements IAMPSChannelInitCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYNativeExpressAdapter f22222a;

        public a(LYNativeExpressAdapter lYNativeExpressAdapter) {
        }

        public void failCallBack(AMPSError aMPSError) {
        }

        public void successCallBack() {
        }
    }

    public class b implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYNativeExpressAdapter f22223a;

        public b(LYNativeExpressAdapter lYNativeExpressAdapter) {
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

    public void destroy() {
    }

    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
    }

    public void initSdk() {
    }

    public boolean isValid() {
    }

    public void loadAd() {
    }

    public /* bridge */ /* synthetic */ void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener) {
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
    }
}
