package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class CloseCountDownView extends LinearLayout {
    private a JS;
    private String Ll;
    private int Lm;
    private TextView Ln;
    private TextView Lo;
    private ImageView Lp;
    private com.kwad.components.ad.splashscreen.widget.a Lq;
    private Runnable Lr;
    private boolean rp;

    public interface a {
        void eo();

        void mB();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.Ll = "%ss";
        this.Lm = 5;
        this.rp = false;
        this.Lr = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.rp) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.Lm <= 0) {
                    if (CloseCountDownView.this.JS != null) {
                        CloseCountDownView.this.JS.mB();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.aB(closeCountDownView.Lm);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(int i) {
        this.Ln.setText(String.format(this.Ll, Integer.valueOf(i)));
    }

    private void ah(Context context) {
        setOrientation(0);
        m.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.Ln = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.Lo = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.Lp = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.JS != null) {
                    CloseCountDownView.this.JS.eo();
                }
            }
        });
    }

    private void az() {
        post(this.Lr);
    }

    public static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i = closeCountDownView.Lm;
        closeCountDownView.Lm = i - 1;
        return i;
    }

    private void gb() {
        this.rp = true;
    }

    private void gc() {
        this.rp = false;
    }

    private void nT() {
        am.a(this, this.Lq.nx());
        am.a(this.Lo, this.Lq.nW());
        am.a(this.Lp, this.Lq.nZ());
        this.Ln.setTextSize(0, this.Lq.nX());
        this.Lo.setTextSize(0, this.Lq.nX());
        Drawable background = getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(this.Lq.nY());
        }
    }

    public final void bA() {
        gb();
    }

    public final void bz() {
        gc();
    }

    public final void cw() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public void setOnViewClickListener(a aVar) {
        this.JS = aVar;
    }

    public final void a(AdInfo adInfo, float f) {
        com.kwad.components.ad.splashscreen.widget.a aVarAi;
        boolean zDv = com.kwad.sdk.core.response.helper.a.dv(adInfo);
        if (zDv) {
            aVarAi = com.kwad.components.ad.splashscreen.widget.a.aj(getContext());
        } else {
            aVarAi = com.kwad.components.ad.splashscreen.widget.a.ai(getContext());
        }
        this.Lq = aVarAi;
        aVarAi.d(f);
        boolean zCC = com.kwad.sdk.core.response.helper.a.cC(adInfo);
        this.Lm = com.kwad.sdk.core.response.helper.a.cB(adInfo);
        if (zDv) {
            nT();
        }
        if (zCC) {
            this.Ln.setVisibility(0);
            this.Lo.setVisibility(0);
            aB(this.Lm);
            float fNV = this.Lq.nV();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), fNV), 0, com.kwad.sdk.c.a.a.a(getContext(), fNV), 0);
        } else {
            float fNU = this.Lq.nU();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), fNU), 0, com.kwad.sdk.c.a.a.a(getContext(), fNU), 0);
        }
        az();
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ll = "%ss";
        this.Lm = 5;
        this.rp = false;
        this.Lr = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.rp) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.Lm <= 0) {
                    if (CloseCountDownView.this.JS != null) {
                        CloseCountDownView.this.JS.mB();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.aB(closeCountDownView.Lm);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ll = "%ss";
        this.Lm = 5;
        this.rp = false;
        this.Lr = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.rp) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.Lm <= 0) {
                    if (CloseCountDownView.this.JS != null) {
                        CloseCountDownView.this.JS.mB();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.aB(closeCountDownView.Lm);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Ll = "%ss";
        this.Lm = 5;
        this.rp = false;
        this.Lr = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.rp) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.Lm <= 0) {
                    if (CloseCountDownView.this.JS != null) {
                        CloseCountDownView.this.JS.mB();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.aB(closeCountDownView.Lm);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }
}
