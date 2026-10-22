package com.kc.dw.platform.ad_adapter.banner;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.banner.IBannerAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends com.kc.dw.platform.ad_adapter.b implements IBannerAd {
    public com.kc.dw.ad.banner.a b;
    public Activity c;
    public ViewGroup d;

    public a(com.kc.dw.ad.banner.a aVar) {
        super(aVar);
        this.b = aVar;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdType getAdType() {
        return AdType.BANNER;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public Context getContext() {
        Activity activity = this.c;
        if (activity != null) {
            return activity;
        }
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            return viewGroup.getContext();
        }
        View view = this.adView;
        if (view != null) {
            return view.getContext();
        }
        LogUtil.e("a", "Please call after reading onRenderSuccess.");
        return null;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCid(this.b.getCid());
        resultBean.setCat(this.b.getCat());
        resultBean.setAderId(this.b.getAder_id());
        resultBean.setFromId(this.b.getFromId());
        resultBean.setDrawing(this.b.getDrawing());
        resultBean.setPid(this.b.getPosId());
        resultBean.setReqId(this.b.getReq_id());
        resultBean.setPrice(this.b.getEcpm());
        resultBean.setEcpm(String.valueOf(this.b.getEcpm()));
        resultBean.setS_code(this.b.getS_code());
        resultBean.setS_ext(this.b.getS_ext());
        resultBean.setSdkName("SSD");
        resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.b));
        return resultBean;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = this.b.getExpire_timestamp();
            return SystemClock.uptimeMillis() - this.b.getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void render() {
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(getContext(), this.b.getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(getContext(), this.b.getWinUrl(), map);
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void setCloseButtonVisible(boolean z) {
        this.adView.findViewById(R.id.ms_banner_close_button).setVisibility(z ? 0 : 4);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        super.setInteractionListener(interactionListener);
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void setWidthAndHeight(int i, int i2) {
        if (i2 == 0) {
            return;
        }
        ImageView imageView = (ImageView) this.adView.findViewById(R.id.ms_banner_image);
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        imageView.getParent().requestLayout();
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        View view = this.adView;
        if (view == null) {
            return;
        }
        this.c = activity;
        this.d = viewGroup;
        if (viewGroup == null || view.getParent() != null) {
            return;
        }
        viewGroup.addView(this.adView);
    }

    @Override // com.kc.dw.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        View view = this.adView;
        if (view == null) {
            return;
        }
        this.d = viewGroup;
        if (viewGroup == null || view.getParent() != null) {
            return;
        }
        viewGroup.addView(this.adView);
    }
}
