package com.fl.saas.adx.base.manager;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.fl.saas.AbstractC1403d;
import com.fl.saas.B;
import com.fl.saas.C1415j;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.base.builder.InnerBannerBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.banner.InnerNativeBannerAdapter;
import com.fl.saas.adx.base.interfaces.AdViewBannerListener;
import com.fl.saas.adx.base.manager.manager.BuilderLoadManager;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.ViewHelper;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewBannerManager extends BuilderLoadManager<InnerBannerBuilder<?>, AbstractC1403d, AdViewBannerListener> {
    private FrameLayout bannerView;
    private Timer mTimer;

    public AdViewBannerManager() {
        super(AdType.Banner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefresh() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerAutoRefresh() {
        try {
            if (this.mTimer != null && this.bannerView != null) {
                if (this.bannerView.getGlobalVisibleRect(new Rect())) {
                    restManagerLoad(AdType.Banner);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefresh() {
        C1415j adSource;
        if (!(getShowAdapter() instanceof InnerNativeBannerAdapter) || (adSource = getShowAdapter().getAdSource()) == null || adSource.e0 != 1 || adSource.f0 <= 0) {
            return;
        }
        TimerTask timerTask = new TimerTask() { // from class: com.fl.saas.adx.base.manager.AdViewBannerManager.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AdViewBannerManager.this.innerAutoRefresh();
            }
        };
        cancelRefresh();
        long j = ((long) adSource.f0) * 1000;
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(timerTask, j);
    }

    @Override // com.fl.saas.adx.base.manager.manager.BuilderLoadManager, com.fl.saas.adx.base.manager.api.ManagerInfoAPI
    public void destroy() {
        super.destroy();
        getValidAdapter().a(new B() { // from class: com.zj.adlib.nw
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((AbstractC1403d) obj).destroy();
            }
        });
        cancelRefresh();
    }

    @Override // com.fl.saas.adx.base.manager.manager.BuilderLoadManager
    public AdViewBannerListener initProxyEventListener(InnerBannerBuilder<?> innerBannerBuilder) {
        return new AdViewBannerListener(innerBannerBuilder, innerBannerBuilder.getEventListener()) { // from class: com.fl.saas.adx.base.manager.AdViewBannerManager.1
            private boolean isLoaded = false;
            private FrameLayout.LayoutParams mParams;
            final /* synthetic */ AdViewBannerListener val$adViewAdInterface;
            final /* synthetic */ InnerBannerBuilder val$builder;

            {
                this.val$builder = innerBannerBuilder;
                this.val$adViewAdInterface = adViewBannerListener;
                AdViewBannerManager.this.bannerView = new FrameLayout((Context) AdViewBannerManager.this.getContextOpt().b());
                AdViewBannerManager.this.bannerView.setBackgroundColor(-1);
                this.mParams = new FrameLayout.LayoutParams(DeviceUtil.dip2px(innerBannerBuilder.getWidth()), DeviceUtil.dip2px(innerBannerBuilder.getHeight()));
                AdViewBannerManager.this.bannerView.setLayoutParams(this.mParams);
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onAdClick(String str) {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdClick(str);
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onAdExposure() {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdExposure();
            }

            @Override // com.fl.saas.adx.base.interfaces.AdViewListener
            public void onAdFailed(FLError fLError) {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdFailed(fLError);
                if (this.isLoaded) {
                    AdViewBannerManager.this.setRefresh();
                }
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onClosed() {
                ViewHelper.removeParent(AdViewBannerManager.this.bannerView);
                AdViewBannerManager.this.cancelRefresh();
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onClosed();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerBannerListener
            public void onReceived(View view) {
                try {
                    if (AdViewBannerManager.this.bannerView == null) {
                        AdViewBannerManager.this.bannerView = new FrameLayout((Context) AdViewBannerManager.this.getContextOpt().b());
                        AdViewBannerManager.this.bannerView.setBackgroundColor(-1);
                        this.mParams = new FrameLayout.LayoutParams(DeviceUtil.dip2px(this.val$builder.getWidth()), DeviceUtil.dip2px(this.val$builder.getHeight()));
                        AdViewBannerManager.this.bannerView.setLayoutParams(this.mParams);
                    }
                    if (AdViewBannerManager.this.bannerView != null) {
                        AdViewBannerManager.this.bannerView.removeAllViews();
                        AdViewBannerManager.this.bannerView.addView(view, this.mParams);
                        if (!this.isLoaded) {
                            this.isLoaded = true;
                            if (this.val$adViewAdInterface == null) {
                                return;
                            }
                            ViewHelper.removeParent(AdViewBannerManager.this.bannerView);
                            this.val$adViewAdInterface.onReceived(AdViewBannerManager.this.bannerView);
                        }
                    } else {
                        AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                        if (adViewBannerListener == null) {
                            return;
                        }
                        adViewBannerListener.onAdFailed(new FLError("BannerView加载失败"));
                        if (!this.isLoaded) {
                            return;
                        }
                    }
                    AdViewBannerManager.this.setRefresh();
                } catch (Exception e) {
                    e.printStackTrace();
                    AdViewBannerListener adViewBannerListener2 = this.val$adViewAdInterface;
                    if (adViewBannerListener2 == null) {
                        return;
                    }
                    adViewBannerListener2.onAdFailed(new FLError("BannerView加载失败"));
                    if (this.isLoaded) {
                        AdViewBannerManager.this.setRefresh();
                    }
                }
            }
        };
    }

    public boolean isReady() {
        AdapterAPI showAdapter = getShowAdapter();
        if (showAdapter instanceof AbstractC1403d) {
            return ((AbstractC1403d) showAdapter).isBannerReady();
        }
        return false;
    }
}
