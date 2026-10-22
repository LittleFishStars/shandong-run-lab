package com.example.topon_adapter.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ltmb.ltsdk.core.load.banner.LTBannerAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BannerAdKeView extends FrameLayout {
    private LTBannerAd ltBannerAd;

    public BannerAdKeView(@NonNull Context context, LTBannerAd lTBannerAd) {
        super(context);
        this.ltBannerAd = lTBannerAd;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LTBannerAd lTBannerAd = this.ltBannerAd;
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
