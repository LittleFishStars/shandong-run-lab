package com.ltmb.gromoreadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class DrawAdKeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LTDrawAd f40265a;

    public DrawAdKeView(@NonNull Context context, LTDrawAd lTDrawAd) {
        super(context);
        this.f40265a = lTDrawAd;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LTDrawAd lTDrawAd = this.f40265a;
        if (lTDrawAd != null) {
            lTDrawAd.showAd(this);
        }
    }

    public DrawAdKeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawAdKeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DrawAdKeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
