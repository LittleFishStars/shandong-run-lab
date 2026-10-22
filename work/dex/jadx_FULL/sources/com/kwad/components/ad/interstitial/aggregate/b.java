package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.wrapper.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.interstitial.h.a {
    private final com.kwad.sdk.core.j.c fF;
    private com.kwad.components.core.widget.a.c fx;
    private TransViewPager lF;
    private a lG;
    private ViewPagerIndicator lH;
    private ValueAnimator lI;
    private boolean lJ;
    private int lK;
    private int lL;
    private boolean lM;
    private final ViewPager.OnPageChangeListener lN;
    protected KsInterstitialAd.AdInteractionListener ls;

    @NonNull
    protected AdResultData mAdResultData;
    private final List<AdTemplate> mAdTemplateList;
    private final View mRootView;

    public b(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final int i) {
        final int width = getWidth();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, width);
        this.lI = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(800L);
        this.lI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (i < b.this.lL - 1) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    b.this.lF.scrollTo((i * width) + iIntValue, 0);
                    b.this.lF.onPageScrolled(i + 1, iIntValue / width, 0);
                }
            }
        });
        this.lI.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (i < b.this.lL - 1) {
                    b.this.lF.setCurrentItem(i + 1);
                }
            }
        });
        this.lI.start();
    }

    private void dJ() {
        this.lH.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void T(int i) {
                b.this.S(i);
            }
        });
    }

    private static int g(AdResultData adResultData) {
        AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfoT;
        if (adResultData == null || (cycleAggregationInfoT = com.kwad.sdk.core.response.helper.c.t(adResultData)) == null) {
            return 10;
        }
        return cycleAggregationInfoT.cycleAggregationInterval;
    }

    private void initView() {
        this.lF = (TransViewPager) this.mRootView.findViewById(R.id.ksad_multi_ad_container);
        this.lH = (ViewPagerIndicator) this.mRootView.findViewById(R.id.ksad_multi_ad_indicator);
        this.fx = new com.kwad.components.core.widget.a.c(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dH() {
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dI() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fx.b(this.fF);
        this.fx.Ab();
        this.mAdTemplateList.clear();
        this.lF.clearOnPageChangeListeners();
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ls = adInteractionListener;
    }

    private b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.mAdTemplateList = new ArrayList();
        this.lK = 10;
        this.lL = 0;
        this.fF = new d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.8
            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void bA() {
                super.bA();
                if (b.this.lJ) {
                    return;
                }
                if (b.this.lH != null) {
                    b.this.lH.dM();
                }
                if (b.this.lI != null) {
                    b.this.lI.pause();
                }
                b.this.lJ = true;
            }

            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void bz() {
                super.bz();
                if (b.this.lJ) {
                    if (b.this.lH != null) {
                        b.this.lH.dN();
                    }
                    if (b.this.lI != null) {
                        b.this.lI.resume();
                    }
                    b.this.lJ = false;
                }
            }
        };
        this.lN = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.9
            private int lQ = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                com.kwad.components.ad.interstitial.h.c cVarU = b.this.lF.U(i);
                if (cVarU != null) {
                    cVarU.fh();
                }
                if (this.lQ != i) {
                    com.kwad.sdk.core.adlog.c.a((AdTemplate) b.this.mAdTemplateList.get(this.lQ), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.h.c cVarU2 = b.this.lF.U(this.lQ);
                    if (cVarU2 != null) {
                        cVarU2.fi();
                    }
                }
                this.lQ = i;
            }
        };
        this.mContext = context;
        this.mRootView = m.inflate(context, R.layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i) {
        this.mAdResultData = adResultData;
        this.lK = g(adResultData);
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(this.mAdResultData.getAdTemplateList());
        this.lL = this.mAdTemplateList.size();
        this.ls = adInteractionListener;
        a aVar = new a(this.mAdResultData, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.lG = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.h.c cVar, int i2) {
                b.this.lF.a(i2, cVar);
            }
        });
        this.lG.a(new a.InterfaceC1146a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC1146a
            public final void dG() {
                if (b.this.lI != null) {
                    b.this.lI.cancel();
                }
                b.this.lH.setPlayProgressListener(null);
                b.this.lH.setVisibility(8);
            }
        });
        this.lF.setAdapter(this.lG);
        this.lF.setScrollable(false);
        this.lF.setOffscreenPageLimit(this.mAdTemplateList.size() - 1);
        this.lF.addOnPageChangeListener(this.lN);
        this.lG.d(this.mAdTemplateList);
        this.lG.notifyDataSetChanged();
        this.fx.a(this.fF);
        this.fx.Aa();
        if (this.lH == null) {
            return;
        }
        dJ();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lH.getLayoutParams();
        if (marginLayoutParams != null) {
            boolean zVM = as.VM();
            this.lM = zVM;
            marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, zVM ? 12.0f : 6.0f);
            this.lH.setLayoutParams(marginLayoutParams);
        }
        this.lH.setAdShowTime(this.lK);
        this.lH.setVisibility(0);
        this.lH.setViewPager(this.lF);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i, boolean z) {
        this.mAdResultData = adResultData;
        this.lK = g(adResultData);
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(this.mAdResultData.getAdTemplateList());
        this.lL = this.mAdTemplateList.size();
        this.ls = adInteractionListener;
        a aVar = new a(this.mAdResultData, dVar, ksAdVideoPlayConfig, adInteractionListener, z);
        this.lG = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.h.c cVar, int i2) {
                b.this.lF.a(i2, cVar);
            }
        });
        this.lG.a(new a.InterfaceC1146a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC1146a
            public final void dG() {
                if (b.this.lI != null) {
                    b.this.lI.cancel();
                }
                b.this.lH.setPlayProgressListener(null);
                b.this.lH.setVisibility(8);
            }
        });
        this.lF.setAdapter(this.lG);
        this.lF.setScrollable(false);
        this.lF.setOffscreenPageLimit(this.mAdTemplateList.size() - 1);
        this.lF.addOnPageChangeListener(this.lN);
        this.lG.d(this.mAdTemplateList);
        this.lG.notifyDataSetChanged();
        this.fx.a(this.fF);
        this.fx.Aa();
        if (this.lH == null) {
            return;
        }
        dJ();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lH.getLayoutParams();
        if (marginLayoutParams != null) {
            boolean zVM = as.VM();
            this.lM = zVM;
            marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, zVM ? 12.0f : 6.0f);
            this.lH.setLayoutParams(marginLayoutParams);
        }
        this.lH.setAdShowTime(this.lK);
        this.lH.setVisibility(0);
        this.lH.setViewPager(this.lF);
    }
}
