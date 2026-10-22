package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private TransViewPager lF;
    private int lL;
    private ImageView lR;
    private ImageView lS;
    private ImageView lT;
    private int lU;
    private final ViewPager.OnPageChangeListener lV;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    private void dK() {
        int i = this.lU;
        if (i < this.lL - 1) {
            this.lF.setCurrentItem(i + 1, true);
        }
    }

    private void initView() {
        m.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.lR = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.lS = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.lT = imageView;
        com.kwad.sdk.c.a.a.a(this, this.lR, this.lS, imageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.ad.interstitial.h.c cVarU;
        if (view.equals(this.lR)) {
            dK();
            com.kwad.sdk.core.adlog.c.t(this.mAdTemplate, 162);
        } else if (view.equals(this.lS)) {
            dK();
            com.kwad.sdk.core.adlog.c.t(this.mAdTemplate, 36);
        } else {
            if (!view.equals(this.lT) || (cVarU = this.lF.U(this.lU)) == null) {
                return;
            }
            cVarU.fj();
        }
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lV = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                InterstitialAggregateManualTipsView.this.lU = i2;
                if (InterstitialAggregateManualTipsView.this.lU == InterstitialAggregateManualTipsView.this.lL - 1) {
                    InterstitialAggregateManualTipsView.this.lR.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.lS.setAlpha(0.5f);
                } else {
                    InterstitialAggregateManualTipsView.this.lR.setAlpha(1.0f);
                    InterstitialAggregateManualTipsView.this.lS.setAlpha(1.0f);
                }
            }
        };
        this.mContext = context;
        initView();
    }
}
