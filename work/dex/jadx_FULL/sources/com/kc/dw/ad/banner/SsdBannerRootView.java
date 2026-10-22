package com.kc.dw.ad.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdBannerRootView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.platform.ad_adapter.banner.a f39083a;
    public boolean b;

    @Keep
    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SsdBannerRootView f39084a;

        public a(SsdBannerRootView ssdBannerRootView) {
            this.f39084a = ssdBannerRootView;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.platform.ad_adapter.banner.a aVar = this.f39084a.f39083a;
            if (aVar == null || aVar.getInteractionListener() == null) {
                return;
            }
            this.f39084a.f39083a.getInteractionListener().onAdExposure();
        }
    }

    public SsdBannerRootView(Context context) {
        super(context);
    }

    public SsdBannerRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SsdBannerRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.b) {
            return;
        }
        this.b = true;
        if (i == 0 && isShown()) {
            LogUtil.d("SsdBannerRootView", "send onADExposure");
            post(new a(this));
        }
    }

    public void setBannerAd(com.kc.dw.platform.ad_adapter.banner.a aVar) {
        this.f39083a = aVar;
    }
}
