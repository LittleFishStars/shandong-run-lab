package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.d;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a extends LinearLayout {
    protected View CR;
    protected Button CS;
    protected Button CU;
    protected KsAppTagsView Da;
    protected com.kwad.components.ad.j.a Dd;
    private Runnable De;
    protected AppScoreView FL;
    protected TextProgressBar Gb;
    protected View Ia;
    protected TextView Ox;
    protected TextView gS;
    protected ValueAnimator mn;
    protected ImageView nU;
    protected TextView nV;

    public a(Context context) {
        this(context, null);
    }

    private void initView() {
        this.Ia = m.inflate(getContext(), getLayoutId(), this);
        this.nU = (ImageView) findViewById(R.id.ksad_app_icon);
        this.nV = (TextView) findViewById(R.id.ksad_app_name);
        this.FL = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.gS = (TextView) findViewById(R.id.ksad_app_download_count);
        this.Ox = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.Gb = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.Gb.setTextColor(-1);
        this.Da = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.CS = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.CU = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.CR = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.Dd = new com.kwad.components.ad.j.a(this.Ia);
    }

    private void oC() {
        ValueAnimator valueAnimator = this.mn;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.mn = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(1200L);
            this.mn.setRepeatCount(-1);
            this.mn.setRepeatMode(1);
            this.mn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.Gb.setScaleY(fFloatValue);
                    a.this.Gb.setScaleX(fFloatValue);
                }
            });
            this.mn.start();
        }
    }

    public final void E(@NonNull AdInfo adInfo) {
        int i = adInfo.status;
        if (i == 1 || i == 2 || i == 3) {
            lR();
        } else {
            oC();
        }
    }

    public View getBtnInstallContainer() {
        return this.CR;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.Gb;
    }

    public final void lR() {
        ValueAnimator valueAnimator = this.mn;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mn.cancel();
            this.mn.end();
        }
        Runnable runnable = this.De;
        if (runnable != null) {
            this.CR.removeCallbacks(runnable);
            this.De = null;
        }
        this.Dd.ok();
    }

    public void n(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        if (e.S(adTemplate)) {
            KSImageLoader.loadAppIcon(this.nU, com.kwad.sdk.core.response.helper.a.cV(adInfoEO), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.nU, com.kwad.sdk.core.response.helper.a.cv(adInfoEO), adTemplate, 12);
        }
        this.nV.setText(com.kwad.sdk.core.response.helper.a.cs(adInfoEO));
        if (!e.S(adTemplate)) {
            float fAG = com.kwad.sdk.core.response.helper.a.aG(adInfoEO);
            if (fAG >= 3.0f) {
                this.FL.setScore(fAG);
                this.FL.setVisibility(0);
            } else {
                this.FL.setVisibility(8);
            }
            String strAF = com.kwad.sdk.core.response.helper.a.aF(adInfoEO);
            if (TextUtils.isEmpty(strAF)) {
                this.gS.setVisibility(8);
            } else {
                this.gS.setText(strAF);
                this.gS.setVisibility(0);
            }
        }
        this.Ox.setText(com.kwad.sdk.core.response.helper.a.aA(adInfoEO));
        if (e.S(adTemplate)) {
            this.Gb.setVisibility(8);
            this.CR.setVisibility(0);
            this.CU.setText("查看详情");
            Button button = this.CS;
            StringBuilder sb = new StringBuilder();
            sb.append(com.kwad.sdk.core.config.e.JY());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.De == null) {
                    this.De = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.Dd.jq();
                        }
                    };
                }
                this.CR.postDelayed(this.De, 1600L);
            }
        } else {
            this.Gb.setVisibility(0);
            this.CR.setVisibility(8);
            Runnable runnable = this.De;
            if (runnable != null) {
                this.CR.removeCallbacks(runnable);
                this.De = null;
            }
            E(e.eO(adTemplate));
        }
        if (e.S(adTemplate)) {
            List<String> listEF = d.eF(adTemplate);
            if (listEF.size() > 0) {
                this.Da.setVisibility(0);
            } else {
                this.Da.setVisibility(8);
            }
            this.Da.setAppTags(listEF);
        }
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        initView();
    }
}
