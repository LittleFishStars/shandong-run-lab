package com.fl.saas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.arch.core.util.Function;
import com.fl.saas.adx.base.activity.FLSpreadActivity;
import com.fl.saas.adx.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.FLAdTempHelper;
import com.fl.saas.adx.base.interfaces.AdMaterial;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import com.fl.saas.adx.base.interfaces.AdViewSpreadListener;
import com.fl.saas.adx.base.interfaces.SpreadLoadListener;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.huachenjie.shandong_school.splash.SplashActivity;
import com.zj.adlib.cz;
import com.zj.adlib.y4b;

/* JADX INFO: renamed from: com.fl.saas.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1409g extends AbstractC1425o {
    private final String TAG = CommConstant.getObjTag(this);
    private long adFillingTime = 0;
    private boolean hasBackDisplay = false;
    private boolean hasCallbackClose;
    private boolean isShow;
    private a mAdViewLoadListener;
    private SpreadLoadListener.SpreadAd spreadAd;

    /* JADX INFO: renamed from: com.fl.saas.g$a */
    public interface a {
        void a(ViewGroup viewGroup);
    }

    /* JADX INFO: renamed from: com.fl.saas.g$b */
    public class b implements SpreadLoadListener.SpreadAd {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (AbstractC1409g.this.hasCallbackClose) {
                return;
            }
            AbstractC1409g.this.hasCallbackClose = true;
            AbstractC1409g.this.handleListenerEvent(new cz());
        }

        @Override // com.fl.saas.adx.base.interfaces.AdMaterial
        public AdMaterial.AdMaterialData getAdMaterialData() {
            AbstractC1409g abstractC1409g = AbstractC1409g.this;
            return abstractC1409g instanceof AdMaterial ? abstractC1409g.getMaterialData() : AdMaterial.AdMaterialData.createEmpty(abstractC1409g.getAdSource().f30175a);
        }

        @Override // com.fl.saas.adx.base.interfaces.SpreadLoadListener.SpreadAd
        public int getEcpm() {
            return AbstractC1409g.this.getAdSource().f();
        }

        @Override // com.fl.saas.adx.base.interfaces.SpreadLoadListener.SpreadAd
        public boolean isAdReady() {
            return (AbstractC1409g.this.isShow || AbstractC1409g.this.adFillingTime == 0 || DeviceUtil.getBootTime() - AbstractC1409g.this.adFillingTime >= ((long) AbstractC1409g.this.getAdSource().D1) * 1000) ? false : true;
        }

        @Override // com.fl.saas.adx.base.interfaces.SpreadLoadListener.SpreadAd
        public void show(Activity activity, ViewGroup viewGroup) {
            if (AbstractC1409g.this.isShow) {
                return;
            }
            if (AbstractC1409g.this.getEventListener() instanceof AdViewSpreadListener) {
                DeviceUtil.postUIDelayed(SplashActivity.f36053a, new Runnable() { // from class: com.fl.saas.m1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30185a.a();
                    }
                });
            }
            AbstractC1409g.this.reportRequestShow();
            boolean z = true;
            AbstractC1409g.this.isShow = true;
            if (activity != null) {
                try {
                    AbstractC1409g.this.setContext((Context) activity);
                } catch (Exception e) {
                    e.printStackTrace();
                    AbstractC1409g.this.onAdFailed(new FLError(20405, e.getMessage()));
                    return;
                }
            }
            String str = AbstractC1409g.this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("spreadLoadListener show:");
            if (viewGroup != null) {
                z = false;
            }
            sb.append(z);
            LogcatUtil.d(str, sb.toString());
            AbstractC1409g.this.a(viewGroup);
        }

        @Override // com.fl.saas.adx.base.interfaces.SpreadLoadListener.SpreadAd
        public void show(ViewGroup viewGroup) {
            Activity activityOrNull = AbstractC1409g.this.getActivityOrNull();
            if (activityOrNull == null) {
                activityOrNull = DeviceUtil.getTopActivity();
            }
            LogcatUtil.d(AbstractC1409g.this.TAG, "spreadLoadListener show:" + activityOrNull + AbstractC1409g.this.isShow);
            show(activityOrNull, viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SpreadLoadListener spreadLoadListener) {
        spreadLoadListener.onADLoaded(loadSpreadAd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        a((ViewGroup) getBuilderFieldOptional(new y4b()).c(null));
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
    }

    public ViewGroup getContainer() {
        return (ViewGroup) getBuilderFieldOptional(new y4b()).c(null);
    }

    public boolean isAdReady() {
        return (this.isShow || this.adFillingTime == 0 || DeviceUtil.getBootTime() - this.adFillingTime >= ((long) getAdSource().D1) * 1000) ? false : true;
    }

    public SpreadLoadListener.SpreadAd loadSpreadAd() {
        LogcatUtil.d(this.TAG, "loadSpreadAd");
        if (this.spreadAd == null) {
            this.spreadAd = new b();
        }
        return this.spreadAd;
    }

    @Override // com.fl.saas.AbstractC1425o, com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.interfaces.AdViewListener
    public void onAdFailed(FLError fLError) {
        super.onAdFailed(fLError);
        this.hasCallbackClose = true;
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onClickedEvent() {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdClick("");
        }
    }

    public void onClosedEvent() {
        if (this.hasCallbackClose) {
            return;
        }
        this.hasCallbackClose = true;
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdClose();
        }
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onShowEvent() {
        super.onShowEvent();
        if (this.hasBackDisplay) {
            return;
        }
        this.hasBackDisplay = true;
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdDisplay();
        }
    }

    public void onSpreadLoadedEvent(a aVar) {
        this.adFillingTime = DeviceUtil.getBootTime();
        this.mAdViewLoadListener = aVar;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void showAd() {
        LogcatUtil.d(this.TAG, "show");
        super.showAd();
        getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.l5b
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((InnerSpreadBuilder) obj).getSpreadLoadListener();
            }
        }).a(new B() { // from class: com.zj.adlib.p5b
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f43909a.a((SpreadLoadListener) obj);
            }
        }, new Runnable() { // from class: com.zj.adlib.t5b
            @Override // java.lang.Runnable
            public final void run() {
                this.f44851a.b();
            }
        });
    }

    public void startActivityShow(Activity activity) {
        LogcatUtil.d(this.TAG, "startActivityShow");
        if (this.spreadAd == null || activity == null) {
            onAdFailed(new FLError(20407, "展示广告失败"));
            return;
        }
        FLAdTempHelper.getInstance().setSpreadAd(this.spreadAd);
        Intent intent = new Intent(activity, (Class<?>) FLSpreadActivity.class);
        intent.putExtra("id", getAdSource().g);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup) {
        LogcatUtil.d(this.TAG, "loadAdView");
        if (viewGroup == null) {
            onAdFailed(new FLError(20409, "container is null"));
            return;
        }
        a aVar = this.mAdViewLoadListener;
        if (aVar == null) {
            onAdFailed(new FLError(20405, "Ad filling Exception"));
        } else {
            aVar.a(viewGroup);
            LogcatUtil.d(this.TAG, "viewGroup AdViewLoad");
        }
    }

    public void onClickedEvent(String str) {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdClick(str);
        }
    }
}
