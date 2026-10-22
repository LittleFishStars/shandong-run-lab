package com.ltmb.gromoreadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ltmb.ltsdk.core.load.banner.LTBannerAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BannerAdKeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LTBannerAd f40264a;

    public BannerAdKeView(@NonNull Context context, LTBannerAd lTBannerAd) {
        super(context);
        this.f40264a = lTBannerAd;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LTBannerAd lTBannerAd = this.f40264a;
        if (lTBannerAd != null) {
            lTBannerAd.showAd(this);
        }
    }

    public BannerAdKeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BannerAdKeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BannerAdKeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
