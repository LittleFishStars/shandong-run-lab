package com.fl.saas.base.manager;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.fl.saas.base.adapter.AdViewBannerAdapter;
import com.fl.saas.base.base.builder.InnerBannerBuilder;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewBannerManager extends BuilderLoadManager<InnerBannerBuilder<?>, AdViewBannerAdapter, AdViewBannerListener> {
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
        int i;
        AdPlace adPlace = getAdPlace();
        if (adPlace == null || !adPlace.isOpenCycle() || (i = adPlace.lbjg) <= 0) {
            return;
        }
        cancelRefresh();
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.fl.saas.base.manager.AdViewBannerManager.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AdViewBannerManager.this.innerAutoRefresh();
            }
        }, ((long) i) * 1000);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager, com.fl.saas.base.manager.api.ManagerInfoAPI
    public void destroy() {
        super.destroy();
        this.bannerView = null;
        getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.mw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewBannerAdapter) obj).destroy();
            }
        });
        cancelRefresh();
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewBannerListener initProxyEventListener(InnerBannerBuilder<?> innerBannerBuilder) {
        return new AdViewBannerListener(innerBannerBuilder, innerBannerBuilder.getEventListener()) { // from class: com.fl.saas.base.manager.AdViewBannerManager.1
            private boolean isLoaded = false;
            private FrameLayout.LayoutParams mParams;
            final /* synthetic */ AdViewBannerListener val$adViewAdInterface;
            final /* synthetic */ InnerBannerBuilder val$builder;

            {
                this.val$builder = innerBannerBuilder;
                this.val$adViewAdInterface = adViewBannerListener;
                Context context = AdViewBannerManager.this.getContextOpt().get();
                AdViewBannerManager.this.bannerView = new FrameLayout(context == null ? DeviceUtil.getContext() : context);
                AdViewBannerManager.this.bannerView.setBackgroundColor(-1);
                this.mParams = new FrameLayout.LayoutParams(DeviceUtil.dip2px(innerBannerBuilder.getWidth()), DeviceUtil.dip2px(innerBannerBuilder.getHeight()));
                AdViewBannerManager.this.bannerView.setLayoutParams(this.mParams);
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdClick(String str) {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdClick(str);
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdExposure() {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdExposure();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onAdFailed(ydError);
                if (this.isLoaded) {
                    AdViewBannerManager.this.setRefresh();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onClosed() {
                ViewHelper.removeParent(AdViewBannerManager.this.bannerView);
                AdViewBannerManager.this.cancelRefresh();
                AdViewBannerListener adViewBannerListener = this.val$adViewAdInterface;
                if (adViewBannerListener == null) {
                    return;
                }
                adViewBannerListener.onClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onReceived(View view) {
                try {
                    if (AdViewBannerManager.this.bannerView == null) {
                        Context context = AdViewBannerManager.this.getContextOpt().get();
                        if (context == null) {
                            context = DeviceUtil.getContext();
                        }
                        AdViewBannerManager.this.bannerView = new FrameLayout(context);
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
                        adViewBannerListener.onAdFailed(new YdError("BannerView加载失败"));
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
                    adViewBannerListener2.onAdFailed(new YdError("BannerView加载失败"));
                    if (this.isLoaded) {
                        AdViewBannerManager.this.setRefresh();
                    }
                }
            }
        };
    }
}
