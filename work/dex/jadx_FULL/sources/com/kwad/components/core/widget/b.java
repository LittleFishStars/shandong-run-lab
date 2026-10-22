package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.j.c {
    public a avs;
    private long avt;
    private com.kwad.sdk.core.j.b dH;
    private com.kwad.components.core.widget.a.c fx;
    public AdInfo mAdInfo;

    @NonNull
    protected T mAdResultData;

    @NonNull
    public R mAdTemplate;

    @NonNull
    public Context mContext;
    private bx mTimerHelper;
    protected boolean pw;

    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ long a(b bVar, long j) {
        long j2 = bVar.avt + j;
        bVar.avt = j2;
        return j2;
    }

    private void b(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.e.Kg() && com.kwad.sdk.core.config.e.Kf() >= 0.0f) {
            e(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new com.kwad.components.core.widget.a.InterfaceC1245a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void aD() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.pw) {
                            long jXg = bVar.getTimerHelper().Xg();
                            b.a(b.this, jXg);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jXg, (JSONObject) null);
                            b.this.pw = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void ae() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void af() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.pw) {
                            long jXg = bVar.getTimerHelper().Xg();
                            b.a(b.this, jXg);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jXg, (JSONObject) null);
                            b.this.pw = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void b(View view) {
                    if (!b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.avs != null) {
                            bVar.pw = true;
                            bVar.aa();
                            b.this.getTimerHelper().startTiming();
                        }
                    }
                    b bVar2 = b.this;
                    if (!bVar2.pw) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.pw = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void onWindowFocusChanged(boolean z) {
                }
            });
            aVar.zM();
            return;
        }
        c cVarD = d(viewGroup);
        if (cVarD == null) {
            cVarD = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(cVarD);
        }
        cVarD.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void fz() {
                b.this.aa();
            }
        });
        cVarD.setNeedCheckingShow(true);
    }

    public static void e(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    private void initView() {
        m.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bC();
        this.fx = new com.kwad.components.core.widget.a.c(this, 70);
    }

    public void aa() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.avs) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
        R r = this.mAdTemplate;
        FeedType feedTypeFromInt = FeedType.fromInt(r.type, r.defaultType);
        if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c1273a.templateId = String.valueOf(feedTypeFromInt.getType());
        c1273a.aLh = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        bVar.b(c1273a);
        bVar.z(getHeight(), getWidth());
        com.kwad.components.core.t.b.wF().a(this.mAdTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ae() {
        super.ae();
        this.fx.a(this);
        this.fx.a(this.dH);
        this.fx.Aa();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void af() {
        super.af();
        this.fx.Ab();
        this.fx.b(this);
        cw();
    }

    public void bA() {
    }

    public abstract void bC();

    public final void bY(int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.nm = i;
        com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
        R r = this.mAdTemplate;
        FeedType feedTypeFromInt = FeedType.fromInt(r.type, r.defaultType);
        c1273a.templateId = String.valueOf(feedTypeFromInt.getType());
        c1273a.aLh = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        aVar.QZ = c1273a;
        int i2 = this.mAdTemplate.swipeAngle;
        if (i2 != 0) {
            aVar.aMR = i2;
        }
        if (getTouchCoords() != null) {
            aVar.no = getTouchCoords();
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, aVar, (JSONObject) null);
        a aVar2 = this.avs;
        if (aVar2 != null) {
            aVar2.onAdClicked();
        }
    }

    public void bz() {
    }

    public final void c(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public void cw() {
    }

    public void d(@NonNull T t) {
        this.mAdResultData = t;
        R r = (R) com.kwad.sdk.core.response.helper.c.r(t);
        this.mAdTemplate = r;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(r);
        b(this);
    }

    public final boolean fx() {
        int i = this.mAdInfo.status;
        return (i == 2 || i == 3) ? false : true;
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public long getStayTime() {
        return this.avt + getTimerHelper().getTime();
    }

    public bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bx();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.avs = aVar;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        if (com.kwad.sdk.core.config.e.KD()) {
            return;
        }
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dH = bVar;
    }

    public final void zN() {
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void zO() {
        com.kwad.sdk.core.adlog.c.cn(this.mAdTemplate);
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private static c d(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }
}
