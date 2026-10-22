package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.t.x;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    private ValueAnimator gG;
    private a gI;
    private ImageView gJ;
    private TextView gK;
    private TextView gL;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    public interface a {
        void bg();

        void bh();
    }

    public DrawCardH5(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.gJ = (ImageView) findViewById(R.id.ksad_card_close);
        this.gK = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.gL = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void br() {
        ValueAnimator valueAnimator = this.gG;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.gG.cancel();
        }
    }

    private void cb() {
        d(this.mHeight, 0);
    }

    private void d(int i, int i2) {
        br();
        ValueAnimator valueAnimatorB = x.b(this, i, i2);
        this.gG = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gG.setDuration(300L);
        this.gG.start();
    }

    public final void bZ() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.gJ) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.mAdTemplate).aN(view == this.gL ? 1 : 2).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (DrawCardH5.this.gI != null) {
                        DrawCardH5.this.gI.bh();
                    }
                }
            }));
            return;
        }
        cb();
        a aVar = this.gI;
        if (aVar != null) {
            aVar.bg();
        }
    }

    public final void release() {
        br();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        this.gI = aVar;
        this.gK.setText(com.kwad.sdk.core.response.helper.a.aA(adInfoEO));
        this.gL.setText(com.kwad.sdk.core.response.helper.a.aK(adInfoEO));
        this.gJ.setOnClickListener(this);
        this.gL.setOnClickListener(this);
        this.mLogoView.bl(adTemplate);
        setOnClickListener(this);
        this.gK.measure(View.MeasureSpec.makeMeasureSpec((n.getScreenWidth(this.mContext) - (com.kwad.sdk.c.a.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.c.a.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.c.a.a.a(this.mContext, 100.0f) + this.gK.getMeasuredHeight();
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }
}
