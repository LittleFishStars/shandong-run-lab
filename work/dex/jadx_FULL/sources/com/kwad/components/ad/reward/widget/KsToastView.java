package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsToastView extends LinearLayout {
    private Runnable FA;
    TextView Fy;
    private String Fz;
    private int countDown;

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.Fz = "%ss后自动进入";
        this.FA = null;
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i) {
        this.Fy.setText(String.format(this.Fz, Integer.valueOf(i)));
    }

    public static /* synthetic */ int b(KsToastView ksToastView) {
        int i = ksToastView.countDown;
        ksToastView.countDown = i - 1;
        return i;
    }

    private void init(Context context) {
        m.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.Fy = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    public final void au(int i) {
        if (this.FA == null) {
            this.FA = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.R(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.FA);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.FA);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.Fz = "%ss后自动进入";
        this.FA = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 3;
        this.Fz = "%ss后自动进入";
        this.FA = null;
        init(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.countDown = 3;
        this.Fz = "%ss后自动进入";
        this.FA = null;
        init(context);
    }
}
