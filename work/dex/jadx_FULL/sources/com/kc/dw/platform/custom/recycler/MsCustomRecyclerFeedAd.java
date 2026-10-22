package com.kc.dw.platform.custom.recycler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.ad.interstitial.c;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.recycler.FeedAd;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.ad.recycler.RecyclerAdUtils;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.ClickAdState;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.ad_adapter.recycler.q;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Constructor;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomRecyclerFeedAd extends FeedAd<FeedInteractionListener> {
    private static final String TAG = "MsCustomRecyclerFeedAd";
    private BaseAdSlot baseAdSlot;
    private final Class<? extends ViewGroup> initAdContainer;

    public MsCustomRecyclerFeedAd() {
        this(null);
    }

    public MsCustomRecyclerFeedAd(Class<? extends ViewGroup> cls) {
        this.initAdContainer = cls;
    }

    private ViewGroup getInitAdContainer(Class<?> cls, Context context) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<?> constructor = cls.getConstructor(Context.class);
            constructor.setAccessible(true);
            return (ViewGroup) constructor.newInstance(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initBaseAdSlot() {
        if (this instanceof q) {
            q qVar = (q) this;
            if (qVar.d() != null) {
                this.baseAdSlot = qVar.d();
            }
        }
    }

    public abstract void bindAdToView(Context context, ViewGroup viewGroup, List<View> list);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, android.view.ViewGroup, com.kc.dw.core.view.TouchAdContainer] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.kc.dw.core.ad.IAd, com.kc.dw.core.ad.a, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.ViewGroup[]] */
    /* JADX WARN: Type inference failed for: r8v10, types: [android.view.ViewGroup] */
    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, FeedInteractionListener feedInteractionListener) {
        ViewGroup.LayoutParams layoutParams;
        try {
            if (!((BasePlatformLoader) getPlatformLoader()).getIsChangeAdapter() && getPlatformLoader() != null && getPlatformLoader().getSdkAdInfo() != null) {
                s1.b(getPlatformLoader().getSdkAdInfo().getEventUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.nativeListener = feedInteractionListener;
        ?? info = RecyclerAdUtils.getInfo(viewGroup, getClass(), TouchAdContainer.class);
        ?? r10 = info[1];
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        if (r10 == 0) {
            r10 = info[0];
            ?? r8 = (ViewGroup) r10.getParent();
            if (r8 != 0) {
                int iIndexOfChild = r8.indexOfChild(r10);
                ViewGroup.LayoutParams layoutParams2 = r10.getLayoutParams();
                r8.removeView(r10);
                ?? touchAdContainer = new TouchAdContainer(r10.getContext());
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                ?? initAdContainer = getInitAdContainer(this.initAdContainer, r10.getContext());
                if (initAdContainer == 0) {
                    layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    touchAdContainer.addView(r10, layoutParams);
                } else {
                    layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    touchAdContainer.addView(initAdContainer, layoutParams);
                    initAdContainer.addView(r10, new ViewGroup.LayoutParams(-1, -1));
                }
                touchAdContainer.setId(r10.getId());
                r8.addView(touchAdContainer, iIndexOfChild, layoutParams2);
                r10 = touchAdContainer;
                r1 = initAdContainer;
            }
        } else {
            if (r10 instanceof TouchAdContainer) {
                ((TouchAdContainer) r10).setTouchPositionListener(new TouchPositionListener(this));
            }
            try {
                Class<? extends ViewGroup> cls = this.initAdContainer;
                if (cls != null && cls.isAssignableFrom(r10.getChildAt(0).getClass())) {
                    r1 = (ViewGroup) r10.getChildAt(0);
                }
            } catch (Exception unused) {
            }
        }
        if (r1 != 0) {
            r10 = r1;
        }
        bindAdToView(context, r10, list);
    }

    public void callAdClicked() {
        int clkActType;
        initBaseAdSlot();
        if ((getPlatformLoader() instanceof BasePlatformLoader) && !((BasePlatformLoader) getPlatformLoader()).getIsChangeAdapter() && getPlatformLoader() != null && getPlatformLoader().getSdkAdInfo() != null) {
            b platformLoader = getPlatformLoader();
            ClickAdState clickAdState = new ClickAdState();
            BaseAdSlot baseAdSlot = this.baseAdSlot;
            if (baseAdSlot != null) {
                try {
                    clkActType = baseAdSlot.getClkActType();
                } catch (Exception e) {
                    e.printStackTrace();
                    clkActType = 0;
                }
            } else {
                clkActType = 0;
            }
            a.a(5, "e8", platformLoader, clickAdState.setData(clkActType, com.kc.dw.core.service.logrecord.b.a(this.baseAdSlot)));
            if (!TextUtils.isEmpty(getPlatformLoader().getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onAdClicked");
                c.a(com.kc.dw.base.a.getContext(), f.a(getPlatformLoader().getSdkAdInfo().getClk(), this));
            }
        }
        if (getNativeAdInteractionListener() != null) {
            getNativeAdInteractionListener().onAdClicked();
        }
    }

    public void callAdClosed() {
        a.a(5, "click_close", getPlatformLoader());
        if (getNativeAdInteractionListener() != null) {
            getNativeAdInteractionListener().onAdClosed();
        }
    }

    public void callAdExposure() {
        if (com.kc.dw.core.utils.a.a(getPlatformLoader())) {
            return;
        }
        try {
            getPlatformLoader().getSdkAdInfo().getAppendInfo().setHasExposed(true);
        } catch (Exception unused) {
        }
        initBaseAdSlot();
        if ((getPlatformLoader() instanceof BasePlatformLoader) && !((BasePlatformLoader) getPlatformLoader()).getIsChangeAdapter() && getPlatformLoader() != null && getPlatformLoader().getSdkAdInfo() != null) {
            com.kc.dw.core.service.logrecord.util.c.d(getPlatformLoader());
            a.a(5, "s7", getPlatformLoader(), new ShowAdState().setSuccess(com.kc.dw.core.service.logrecord.b.a(this.baseAdSlot, getPlatformLoader().getSdkAdInfo(), AdType.FEED_MIX.value()), com.kc.dw.core.service.logrecord.b.a(this.baseAdSlot)));
            if (!TextUtils.isEmpty(getPlatformLoader().getSdkAdInfo().getImp())) {
                c.a(com.kc.dw.base.a.getContext(), g0.a(getPlatformLoader().getSdkAdInfo().getImp()));
            }
        }
        if (getNativeAdInteractionListener() != null) {
            getNativeAdInteractionListener().onAdExposure();
        }
    }

    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setAdPatternType(int i) {
        this.adPatternType = i;
    }

    public void setAppIntro(String str) {
        this.appIntro = str;
    }

    public void setAppIntroUrl(String str) {
        this.appIntroUrl = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPermissionList(List<SsdAdInfo.PermissionBean> list) {
        this.appPermissionList = list;
    }

    public void setAppPremissionUrl(String str) {
        this.appPremissionUrl = str;
    }

    public void setAppSize(String str) {
        this.appSize = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDeveloper(String str) {
        this.developer = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setFromId(String str) {
        this.fromId = str;
    }

    public void setFromLogo(String str) {
        this.fromLogo = str;
    }

    public void setFromLogoBitmap(Bitmap bitmap) {
        this.fromLogoBitmap = bitmap;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setIconTitle(String str) {
        this.iconTitle = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setImgUrls(String[] strArr) {
        this.imgUrls = strArr;
    }

    public void setInteractionType(int i) {
        this.interactionType = i;
    }

    public void setMediaView(View view) {
        this.mediaView = view;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd
    public void setPlatform(String str) {
        ((FeedAd) this).platform = str;
    }

    public void setPrivacyAgreement(String str) {
        this.privacyAgreement = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
