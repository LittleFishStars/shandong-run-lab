package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class g extends d {
    public KSFrameLayout Ba;

    public void a(FrameLayout frameLayout) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        KSFrameLayout kSFrameLayout = this.Ba;
        if (kSFrameLayout != null) {
            return kSFrameLayout;
        }
        KSFrameLayout kSFrameLayout2 = (KSFrameLayout) findViewById(jj());
        this.Ba = kSFrameLayout2;
        if (kSFrameLayout2 == null) {
            KSFrameLayout kSFrameLayout3 = new KSFrameLayout(getContext());
            this.Ba = kSFrameLayout3;
            kSFrameLayout3.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            a(this.Ba);
            ((FrameLayout) getRootView()).addView(this.Ba, layoutParams);
        }
        return this.Ba;
    }

    @IdRes
    public abstract int jj();
}
