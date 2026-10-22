package com.fl.saas.base.adapter;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.interfaces.AdGetWinInfo;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.pojo.NativeADAppMiitInfo;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewNativeAdapter extends BuilderLoadAdapter<InnerNativeBuilder<?>, AdViewNativeListener> implements AdGetWinInfo {
    private final String TAG = CommConstant.getObjTag(this);
    private int adCount;
    private int height;
    private boolean isManualReport;
    private boolean isSoundEnable;
    private boolean isTTStreamAd;
    private List<YdNativePojo> pojoList;
    private boolean showLogo;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewNativeListener adViewNativeListener) {
        adViewNativeListener.onAdDisplay(this.pojoList);
    }

    public int getAdCount() {
        return this.adCount;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // com.fl.saas.base.interfaces.AdGetWinInfo
    public WinAdInfo getWinAdInfo() {
        List<YdNativePojo> list = this.pojoList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        WinAdInfo winAdInfo = new WinAdInfo();
        NativeADAppMiitInfo appInfo = this.pojoList.get(0).getAppInfo();
        if (appInfo != null) {
            winAdInfo.setAdUserName(appInfo.getAppName());
        }
        winAdInfo.setTitle(this.pojoList.get(0).getTitle());
        winAdInfo.setPosId(getAdSource().tagid);
        return winAdInfo;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public boolean isManualReport() {
        return this.isManualReport;
    }

    public boolean isShowLogo() {
        return this.showLogo;
    }

    public boolean isSoundEnable() {
        return this.isSoundEnable;
    }

    public boolean isTTStreamAd() {
        return this.isTTStreamAd;
    }

    public List<YdNativePojo> loadBottomNativeAd() {
        LogcatUtil.d(this.TAG, "loadBottomNativeAd");
        return this.pojoList;
    }

    public void onClickedEvent(final int i) {
        super.onClickedEvent();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.jy
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeListener) obj).onAdClick(i);
            }
        });
    }

    public void onLoadedEvent(@NonNull List<YdNativePojo> list) {
        LogcatUtil.d(this.TAG, "onLoadedEvent:" + list);
        this.pojoList = list;
        super.onLoadedEvent();
    }

    public void onShowEvent(final int i) {
        super.onShowEvent();
        reportRequestShow();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.ly
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeListener) obj).onAdShow(i);
            }
        });
    }

    public void pauseVideo() {
    }

    public void resume() {
    }

    public void resumeVideo() {
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewNativeAdapter setBuilder(InnerNativeBuilder<?> innerNativeBuilder) {
        super.setBuilder(innerNativeBuilder);
        this.width = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.cy
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerNativeBuilder) obj).getWidth());
            }
        }).orElse(0)).intValue();
        this.height = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.dy
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerNativeBuilder) obj).getHeight());
            }
        }).orElse(0)).intValue();
        this.adCount = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.ey
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerNativeBuilder) obj).getAdCount());
            }
        }).orElse(1)).intValue();
        Optional<U> builderFieldOptional = getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.fy
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((InnerNativeBuilder) obj).isManualReport());
            }
        });
        Boolean bool = Boolean.FALSE;
        this.isManualReport = ((Boolean) builderFieldOptional.orElse(bool)).booleanValue();
        this.isSoundEnable = ((Boolean) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.gy
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((InnerNativeBuilder) obj).isSoundEnable());
            }
        }).orElse(bool)).booleanValue();
        this.isTTStreamAd = ((Boolean) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.hy
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((InnerNativeBuilder) obj).isStreamAd());
            }
        }).orElse(bool)).booleanValue();
        this.showLogo = ((Boolean) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.iy
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((InnerNativeBuilder) obj).isShowLogo());
            }
        }).orElse(bool)).booleanValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.pojoList == null) {
            return;
        }
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.ky
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f42941a.lambda$showAd$0((AdViewNativeListener) obj);
            }
        });
    }

    public void soundControl(boolean z) {
    }

    public void startVideo() {
    }

    public void stopVideo() {
    }
}
