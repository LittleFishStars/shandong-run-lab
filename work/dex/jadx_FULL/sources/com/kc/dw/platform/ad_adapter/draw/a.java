package com.kc.dw.platform.ad_adapter.draw;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.draw.DrawAd;
import com.kc.dw.core.utils.ResultBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends DrawAd implements com.kc.dw.platform.ad_adapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdSlot f39457a;
    public View b;
    public ViewGroup c;

    public a(AdSlot adSlot, View view) {
        super(null, "SSD");
        this.f39457a = adSlot;
        this.b = null;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdSlot a() {
        return this.f39457a;
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void destroy() {
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) view).c();
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdType getAdType() {
        return null;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public Context getContext() {
        ViewGroup viewGroup = this.c;
        return viewGroup != null ? viewGroup.getContext() : this.b.getContext();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        AdSlot adSlot = this.f39457a;
        if (adSlot instanceof i) {
            resultBean.setCid(((i) adSlot).getCid());
            resultBean.setCat(((i) this.f39457a).getCat());
            resultBean.setAderId(((i) this.f39457a).getAder_id());
            resultBean.setFromId(((i) this.f39457a).getFromId());
            resultBean.setDrawing(((i) this.f39457a).getDrawing());
            resultBean.setPid(((i) this.f39457a).getPosId());
            resultBean.setReqId(((i) this.f39457a).getReq_id());
            resultBean.setPrice(((i) this.f39457a).getEcpm());
            resultBean.setEcpm(((i) this.f39457a).getEcpm() + "");
            resultBean.setS_code(((i) this.f39457a).getS_code());
            resultBean.setS_ext(((i) this.f39457a).getS_ext());
            resultBean.setSdkName("SSD");
            resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.f39457a));
        }
        return resultBean;
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public int getDrawType() {
        return 2;
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public int getInteractionType() {
        return this.f39457a.getInteractionType();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((i) this.f39457a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((i) this.f39457a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void pause() {
        super.pause();
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) view).pause();
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void resume() {
        super.resume();
        View view = this.b;
        if (view != null && (view instanceof NormalMediaView) && view.getVisibility() == 0) {
            ((NormalMediaView) this.b).resume();
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(getContext(), ((i) this.f39457a).getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(getContext(), ((i) this.f39457a).getWinUrl(), map);
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void setVideoMute(boolean z) {
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        NormalMediaView normalMediaView = (NormalMediaView) view;
        if (z) {
            normalMediaView.f();
        } else {
            normalMediaView.i();
        }
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        this.c = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            viewGroup.addView(adView);
        }
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) view).start();
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void showAd(ViewGroup viewGroup) {
        this.c = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            viewGroup.addView(adView);
        }
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) view).start();
    }
}
